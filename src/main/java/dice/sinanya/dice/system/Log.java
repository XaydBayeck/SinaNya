package dice.sinanya.dice.system;

import dice.sinanya.dice.MakeNickToSender;
import dice.sinanya.entity.EntityLogTag;
import dice.sinanya.entity.EntityTypeMessages;
import dice.sinanya.tools.log.SaveDocx;
import org.docx4j.openpackaging.exceptions.Docx4JException;

import java.util.Arrays;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;
import static dice.sinanya.system.MessagesLog.LOG_NAME_FOR_GROUP;
import static dice.sinanya.system.MessagesLog.LOG_SWITCH_FOR_GROUP;
import static dice.sinanya.system.MessagesLogGetLock.LOG_GET_LOCK;
import static dice.sinanya.system.MessagesSystem.NONE;
import static dice.sinanya.system.MessagesTag.*;
import static dice.sinanya.tools.getinfo.GetMessagesSystem.entityProperties;
import static dice.sinanya.tools.getinfo.GetNickName.getGroupName;
import static dice.sinanya.tools.getinfo.LogTag.*;
import static dice.sinanya.tools.getinfo.LogText.getLogText;
import static dice.sinanya.tools.log.LogSave.logSave;
import static dice.sinanya.tools.log.SendMail.sendMail;
import static dice.sinanya.tools.makedata.MakeMessages.deleteTag;
import static dice.sinanya.tools.makedata.Sender.sender;

/**
 * @author SitaNya
 * 日期: 2019-06-15
 * 电子邮箱: sitanya@qq.com
 * 维护群(QQ): 162279609
 * 有任何问题欢迎咨询
 * 类说明: 日志记录类
 */
public class Log implements MakeNickToSender {

    private EntityTypeMessages entityTypeMessages;

    public Log(EntityTypeMessages entityTypeMessages) {
        this.entityTypeMessages = entityTypeMessages;
    }

    /**
     * 记录开启，若已存在则重新开启日志进行追加，若不存在则关闭日志
     */
    public void logOn() {
        String tag = TAG_LOG_ON;
        String msg = deleteTag(entityTypeMessages.getMsg(), tag.substring(0, tag.length() - 2));
        if (msg.equals(NONE)) {
            sender(entityTypeMessages, entityProperties.getCantEmptyLogName());
            return;
        }
        if (checkOthorLogTrue(entityTypeMessages.getFromGroup())) {
            sender(entityTypeMessages, getOtherLogTrue(entityTypeMessages.getFromGroup()) + entityProperties.getAlreadyOpen());
        } else {
            if (checkLogTagExist(entityTypeMessages, msg)) {
                sender(entityTypeMessages, makeLogNickToSender(msg) +entityProperties.getAppendLog());
            } else {
                sender(entityTypeMessages, makeLogNickToSender(msg) +entityProperties.getCreateLog());
            }
            LOG_NAME_FOR_GROUP.put(entityTypeMessages.getFromGroup(), msg);
            LOG_SWITCH_FOR_GROUP.put(entityTypeMessages.getFromGroup(), true);
            setLogTagSwitch(entityTypeMessages, msg, true);
        }
    }

    /**
     * 日志关闭
     */
    public void logOff() {
        String tag = TAG_LOG_OFF;
        String msg = deleteTag(entityTypeMessages.getMsg(), tag.substring(0, tag.length() - 2));
        if (checkLogTagExist(entityTypeMessages, msg)) {
            if (checkLogTagSwitch(entityTypeMessages, msg)) {
                setLogTagSwitch(entityTypeMessages, msg, false);
                LOG_NAME_FOR_GROUP.remove(entityTypeMessages.getFromGroup());
                LOG_SWITCH_FOR_GROUP.put(entityTypeMessages.getFromGroup(), false);
                sender(entityTypeMessages, makeLogNickToSender(msg) + "已关闭，现在可以使用\".log get " + msg + "\"进行获取");
            } else {
                sender(entityTypeMessages, makeLogNickToSender(msg) + entityProperties.getAlreadyClose());
            }
        } else {
            sender(entityTypeMessages, entityProperties.getNotFoundLog());
        }
    }

    /**
     * 日志get，无法get开启的日志
     */
    public void get() {
        String tag = TAG_LOG_GET;
        String msg = deleteTag(entityTypeMessages.getMsg(), tag.substring(0, tag.length() - 2));
        if (!checkLogTagSwitch(entityTypeMessages, msg)) {
            if (LOG_GET_LOCK.contains(msg)) {
                sender(entityTypeMessages, entityProperties.getReadLock());
            } else {
                LOG_GET_LOCK.add(msg);
            }
            String bigResult = getLogText(new EntityLogTag(entityTypeMessages.getFromGroup(), msg));
            sender(entityTypeMessages, "正在抽取数据库为" + makeLogNickToSender(msg) + "生成文件");
            logSave(entityTypeMessages.getFromGroup(), msg, bigResult);
            sender(entityTypeMessages, "正在抽取数据库为" + makeLogNickToSender(msg) + "生成染色文件");
            try {
                new SaveDocx(entityTypeMessages.getFromGroup(), entityTypeMessages.getFromQq(), msg, bigResult);
            } catch (Docx4JException e) {
                CQ.logError(e.getMessage(), Arrays.toString(e.getStackTrace()));
            }
            sender(entityTypeMessages, makeLogNickToSender(msg) + "正在发送到您的邮箱" + entityTypeMessages.getFromQq() + "@qq.com");
            sendMail(entityTypeMessages.getFromQq(), entityTypeMessages.getFromGroup(), getGroupName(entityTypeMessages), msg);
            sender(entityTypeMessages, "[CQ:at,qq=" + entityTypeMessages.getFromQq() + "] 已发送到您的QQ邮箱，注意查收");
            LOG_GET_LOCK.remove(msg);
        } else {
            sender(entityTypeMessages, makeLogNickToSender(msg) + "仍处于打开状态，请关闭后再试");
        }
    }

    /**
     * 当前群内日志列表
     */
    public void list() {
        sender(entityTypeMessages, getTagList(entityTypeMessages.getFromGroup()));
    }

    /**
     * 删除日志
     */
    public void del() {
        String tag = TAG_LOG_RM;
        String msg = deleteTag(entityTypeMessages.getMsg(), tag.substring(0, tag.length() - 2));
        if (checkLogTagExist(entityTypeMessages, msg)) {
            if (checkLogTagSwitch(entityTypeMessages, msg)) {
                sender(entityTypeMessages,entityProperties.getDeleteOpenLog());
            } else {
                delLog(new EntityLogTag(entityTypeMessages.getFromGroup(), msg));
                sender(entityTypeMessages, "已删除日志: " + makeLogNickToSender(msg));
            }
        } else {
            sender(entityTypeMessages, "不存在日志: " + makeLogNickToSender(msg));
        }
    }
}
