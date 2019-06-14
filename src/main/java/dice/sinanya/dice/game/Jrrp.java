package dice.sinanya.dice.game;

import dice.sinanya.entity.EntityTypeMessages;

import java.text.SimpleDateFormat;
import java.util.Date;

import static dice.sinanya.tools.getinfo.GetNickName.getNickName;
import static dice.sinanya.tools.log.Sender.sender;

/**
 * 今日人品
 *
 * @author SitaNya
 */
public class Jrrp {
    private EntityTypeMessages entityTypeMessages;

    public Jrrp(EntityTypeMessages entityTypeMessages) {
        this.entityTypeMessages = entityTypeMessages;
    }

    public void get() {
        String date = toTimestamp(new Date());
        int tmp = 0;
        char[] b = (entityTypeMessages.getFromQq() + date).toCharArray();
        //转换成响应的ASCLL
        for (char c : b) {
            tmp += (int) c;
        }
        sender(entityTypeMessages, getNickName(entityTypeMessages) + "的今日人品为: " + (tmp % 100));
    }


    private static String toTimestamp(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String result;
        result = df.format(date);
        return result;
    }
}
