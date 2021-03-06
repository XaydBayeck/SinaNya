package dice.sinanya.tools.log;

import dice.sinanya.entity.EntityTypeMessages;

import static dice.sinanya.tools.getinfo.GetNickName.getNickName;

/**
 * @author SitaNya
 * 日期: 2019-06-15
 * 电子邮箱: sitanya@qq.com
 * 维护群(QQ): 162279609
 * 有任何问题欢迎咨询
 * 类说明: 日志信息规整类
 */
public class MakeLogInfo {

    private MakeLogInfo() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 规整输入的单条日志信息，规整后的结果存入数据库
     *
     * @param entityTypeMessages 消息封装类
     * @param info               单条日志信息
     * @return 规整后的单条日志信息
     */
    public static String makeLogInfo(EntityTypeMessages entityTypeMessages, String info) {
        info = info.trim()
                .replaceAll("([\"“”])", "\"")
                .replace("（", "(")
                .replace("）", ")")
                .replace("\\\"", "\"");
        StringBuilder result = new StringBuilder();

//        如果一个信息开头是括号且不存在括号完，或最后是括号且不存在括号开始，则是注释的一种
        boolean isNote1for1 = info.charAt(0) == '(' && !info.contains(")");
        boolean isNote1for2 = info.charAt(info.length() - 1) == ')' && !info.contains("(");
        boolean isNote1 = isNote1for1 || isNote1for2;

        boolean isNote2 = info.charAt(0) == '(' && info.charAt(info.length() - 1) == ')';

//        如果包含.log，则是.log系列命令，不予以记录
        if (info.contains(".log")) {
            return "";
        }

//        如果开头是。或.，则是跑团命令信息，规整化为=====分割的区块，并添加XXX发起投掷
        if (info.charAt(0) == '.' || info.trim().charAt(0) == '。') {
            result.append("\n=========================================================================================\n")
                    .append(getNickName(entityTypeMessages))
                    .append("发起骰掷");
            return result.toString();
        } else {
//            如果一个信息的开头结尾都是引号，则前面加昵称，冒号进行原样输出
            if (info.contains("\"")) {
                result.append(getNickName(entityTypeMessages))
                        .append(":\t")
                        .append(info);
//                如果一个信息开头是括号但不包含结尾括号，或者一个信息开头是括号结尾也是括号，则认为整体都被括号扩住
            } else if (isNote1 || isNote2) {
                info = info.replaceAll("([(（])", "").replaceAll("([)）])", "");
                result.append("(")
                        .append(getNickName(entityTypeMessages))
                        .append(":")
                        .append(info)
                        .append(")");
//                如果#开头，则标记为行动
            } else if (info.charAt(0) == '#') {
                result.append(getNickName(entityTypeMessages))
                        .append("发起行动")
                        .append(info);
            } else {
//                如果都不符合，那么语句既不是被引号引起来，也不是被括号括起来，那就是正常对话
                result.append(getNickName(entityTypeMessages))
                        .append(":\t")
                        .append("\"")
                        .append(info)
                        .append("\"");
            }
        }
        return result.toString();
    }

    /**
     * 规整化骰娘的结果信息
     *
     * @param info 骰娘录入的骰点信息
     * @return 规整化后的信息
     */
    public static String makeLogInfo(String info) {
        info = info.trim();
        StringBuilder result = new StringBuilder();
//        如果包含"暗骰结果"或"日志"字样则不录入日志
        if (info.contains("暗骰结果") || info.contains("日志")) {
            return "";
        }

        result
                .append("骰娘:\t")
                .append(info)
                .append("\n")
                .append("=========================================================================================\n");

        return result.toString();
    }
}
