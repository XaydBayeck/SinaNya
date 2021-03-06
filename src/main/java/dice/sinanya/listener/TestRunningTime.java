package dice.sinanya.listener;

import com.forte.qqrobot.anno.timetask.CronTask;
import com.forte.qqrobot.beans.messages.result.GroupList;
import com.forte.qqrobot.beans.messages.result.inner.Group;
import com.forte.qqrobot.exception.TimeTaskException;
import com.forte.qqrobot.sender.MsgSender;
import com.forte.qqrobot.timetask.TimeJob;
import com.forte.qqrobot.timetask.TimeTaskContext;
import com.forte.qqrobot.utils.CQCodeUtil;
import dice.sinanya.db.heap.InsertHeap;
import dice.sinanya.dice.MakeNickToSender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;

import java.util.ArrayList;

import static dice.sinanya.db.system.InsertBot.deleteBot;
import static dice.sinanya.db.system.SelectBot.selectOffBotList;
import static dice.sinanya.system.MessagesLoginInfo.ENTITY_LOGINQQ_INFO;
import static dice.sinanya.tools.getinfo.GetNickName.getGroupName;
import static dice.sinanya.tools.getinfo.GetTime.getNowString;
import static dice.sinanya.tools.makedata.RandomInt.random;

/**
 * @author SitaNya
 * 日期: 2019-06-15
 * 电子邮箱: sitanya@qq.com
 * 维护群(QQ): 162279609
 * 有任何问题欢迎咨询
 * 类说明: 定时任务类，会根据设定的时间每隔多久自动执行一次
 * <p>
 * 这里的“0 * * * * ? *”表示每分钟执行一次，具体怎么写请去查crontab的使用
 * 前5位应该是:分 时 日 月 周
 */
@CronTask("0 */10 * * * ? *")
public class TestRunningTime implements TimeJob, MakeNickToSender {
    private static Logger log = LogManager.getLogger(TestRunningTime.class.getName());

    private static String groupManager = "162279609";
    public TestRunningTime() {
//        定时任务按照接口无逻辑
    }

    @Override
    public void execute(MsgSender msgSender, CQCodeUtil cqCodeUtil) {
        String heapGroupId = "825848066";
        if (checkHasGroup(msgSender, heapGroupId)) {
            msgSender.SENDER.sendGroupMsg(heapGroupId, getNowString());
        }
        if (checkHasGroup(msgSender, groupManager)) {
            autoClean(msgSender);
            try {
                Thread.sleep(random(2000, 12000));
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
            autoCleanNotPlay(msgSender);
        }
        try{
            msgSender.GETTER.getGroupList();
            new InsertHeap().updateHeap();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            log.error("获取群列表失败，停止心跳");
        }
    }

    @Override
    public void execute(JobExecutionContext context) {
        try {
            CQCodeUtil cqCodeUtil = TimeTaskContext.getCQCodeUtil(context);
            MsgSender msgSender = TimeTaskContext.getMsgSender(context);
            execute(msgSender, cqCodeUtil);
        } catch (Exception e) {
            throw new TimeTaskException(e);
        }
    }

    private void autoClean(MsgSender msgSender) {
        ArrayList<String> offBotList = selectOffBotList();
        int type;
        for (String offBotGroupId : offBotList) {
            int times = 0;
            if (msgSender.GETTER.getGroupInfo(offBotGroupId).getTypeId() == null && !checkHasGroup(msgSender, offBotGroupId)) {
                deleteBot(offBotGroupId);
                msgSender.SENDER.sendGroupMsg(groupManager, "删除已不存在群： " + offBotGroupId);
                continue;
            } else if (msgSender.GETTER.getGroupInfo(offBotGroupId).getTypeId() == null) {
                type = 1;
            } else {
                type = msgSender.GETTER.getGroupInfo(offBotGroupId).getTypeId();
            }
            long lastMsgForNow =  System.currentTimeMillis()-msgSender.GETTER.getGroupMemberInfo(offBotGroupId, String.valueOf(ENTITY_LOGINQQ_INFO.getLoginQQ())).getLastTime()*1000;
            if (lastMsgForNow/1000 > 432000) {
                if (type == 1) {
                    msgSender.SENDER.sendGroupMsg(groupManager, "已清理" + lastMsgForNow/1000 / 60 / 60 / 24 + "日未使用，且已关闭本骰的讨论组: " + makeGroupNickToSender(getGroupName(msgSender, offBotGroupId)) + offBotGroupId);
                    msgSender.SENDER.sendDiscussMsg(offBotGroupId, "已在讨论组: " + makeGroupNickToSender(getGroupName(msgSender, offBotGroupId)) + offBotGroupId + "中超过5日未响应且处于关闭状态，即将退群。\n此次退群不会记录黑名单，如遇到问题请至群162279609进行反馈或使用退群命令缓解问题");
                    while (checkHasGroup(msgSender, offBotGroupId) && times < 20) {
                        log.info("尝试退出讨论组" + makeGroupNickToSender(getGroupName(msgSender, offBotGroupId)) + offBotGroupId + " type: " + type);
                        msgSender.SETTER.setDiscussLeave(offBotGroupId);
                        times++;
                    }
                    if (times >= 20) {
                        msgSender.SETTER.setGroupLeave(offBotGroupId);
                    }
                } else {
                    msgSender.SENDER.sendGroupMsg(groupManager, "已清理" + lastMsgForNow/1000 / 60 / 60 / 24 + "日未使用，且已关闭本骰的群: " + makeGroupNickToSender(getGroupName(msgSender, offBotGroupId)) + offBotGroupId);
                    msgSender.SENDER.sendGroupMsg(offBotGroupId, "已在群: " + makeGroupNickToSender(getGroupName(msgSender, offBotGroupId)) + offBotGroupId + "中超过5日未响应且处于关闭状态，即将退群。\n此次退群不会记录黑名单，如遇到问题请至群162279609进行反馈或使用退群命令缓解问题");
                    while (checkHasGroup(msgSender, offBotGroupId)) {
                        log.info("尝试退出群" + makeGroupNickToSender(getGroupName(msgSender, offBotGroupId)) + offBotGroupId + " type: " + type);
                        msgSender.SETTER.setGroupLeave(offBotGroupId);
                    }
                }
                deleteBot(offBotGroupId);
                return;
            }
        }
    }

    private void autoCleanNotPlay(MsgSender msgSender) {
        Group[] groupLists = msgSender.GETTER.getGroupList().getList();
        int type;
        for (Group group : groupLists) {
            String notPlayGroupId = group.getCode();
            int times = 0;
            if (msgSender.GETTER.getGroupInfo(notPlayGroupId).getTypeId() == null && !checkHasGroup(msgSender, notPlayGroupId)) {
                deleteBot(notPlayGroupId);
                msgSender.SENDER.sendGroupMsg(notPlayGroupId, "删除已不存在群： " + notPlayGroupId);
                continue;
            } else if (msgSender.GETTER.getGroupInfo(notPlayGroupId).getTypeId() == null) {
                type = 1;
            } else {
                type = msgSender.GETTER.getGroupInfo(notPlayGroupId).getTypeId();
            }
            long lastMsgForNow = System.currentTimeMillis() - msgSender.GETTER.getGroupMemberInfo(notPlayGroupId, String.valueOf(ENTITY_LOGINQQ_INFO.getLoginQQ())).getLastTime() * 1000;
            if (lastMsgForNow / 1000 > 1296000) {
                if (type == 1) {
                    msgSender.SENDER.sendGroupMsg(groupManager, "已清理" + lastMsgForNow / 1000 / 60 / 60 / 24 + "日未使用的讨论组: " + makeGroupNickToSender(getGroupName(msgSender, notPlayGroupId)) + notPlayGroupId);
                    msgSender.SENDER.sendDiscussMsg(notPlayGroupId, "已在讨论组: " + makeGroupNickToSender(getGroupName(msgSender, notPlayGroupId)) + notPlayGroupId + "中超过15日未响应，即将退群。\n此次退群不会记录黑名单，如遇到问题请至群162279609进行反馈或使用退群命令缓解问题");
                    while (checkHasGroup(msgSender, notPlayGroupId) && times < 20) {
                        log.info("尝试退出讨论组" + makeGroupNickToSender(getGroupName(msgSender, notPlayGroupId)) + notPlayGroupId + " type: " + type);
                        msgSender.SETTER.setDiscussLeave(notPlayGroupId);
                        times++;
                    }
                    if (times >= 20) {
                        msgSender.SETTER.setGroupLeave(notPlayGroupId);
                    }
                } else {
                    msgSender.SENDER.sendGroupMsg(groupManager, "已清理" + lastMsgForNow / 60 / 60 / 24 + "日未使用的群: " + makeGroupNickToSender(getGroupName(msgSender, notPlayGroupId)) + notPlayGroupId);
                    msgSender.SENDER.sendGroupMsg(notPlayGroupId, "已在群: " + makeGroupNickToSender(getGroupName(msgSender, notPlayGroupId)) + notPlayGroupId + "中超过15日未响应，即将退群。\n此次退群不会记录黑名单，如遇到问题请至群162279609进行反馈或使用退群命令缓解问题");
                    while (checkHasGroup(msgSender, notPlayGroupId)) {
                        log.info("尝试退出群" + makeGroupNickToSender(getGroupName(msgSender, notPlayGroupId)) + notPlayGroupId + " type: " + type);
                        msgSender.SETTER.setGroupLeave(notPlayGroupId);
                    }
                }
                deleteBot(notPlayGroupId);
                return;
            }
        }
    }

    private boolean checkHasGroup(MsgSender msgSender, String groupId) {
        GroupList groupList = msgSender.GETTER.getGroupList();
        ArrayList<String> groupListCode = new ArrayList<>();
        for (Group group : groupList) {
            groupListCode.add(group.getCode());
        }
        return groupListCode.contains(groupId);
    }
}