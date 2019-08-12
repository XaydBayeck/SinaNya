package dice.sinanya.db.heap;

import dice.sinanya.db.tools.DbUtil;
import org.apache.logging.log4j.LogManager;
import static com.sobte.cqp.jcq.event.JcqApp.CQ;
import java.util.Arrays;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;
import static dice.sinanya.tools.getinfo.GetMessagesSystem.MESSAGES_SYSTEM;
import static dice.sinanya.tools.getinfo.GetTime.getNowString;
import static dice.sinanya.tools.getinfo.GetTime.getTime;

/**
 * @author SitaNya
 * 日期: 2019-08-09
 * 电子邮箱: sitanya@qq.com
 * 维护群(QQ): 162279609
 * 有任何问题欢迎咨询
 * 类说明:
 */
public class InsertHeap {


    /**
     * 将QQ黑名单列表入库
     */
    public void updateHeap() {
        try (Connection conn = DbUtil.getConnection()) {
            String sql = "replace into heap(botId,time,enable,botMaster)  VALUES (?,?,?,?);";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, String.valueOf(CQ.getLoginQQ()));
                ps.setTimestamp(2, getTime(getNowString()));
                ps.setBoolean(3, Boolean.parseBoolean(MESSAGES_SYSTEM.get("heap")));
                ps.setString(4,MESSAGES_SYSTEM.get("master"));

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            CQ.logError(e.getMessage(), Arrays.toString(e.getStackTrace()));
        }
    }
}
