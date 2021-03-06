package dice.sinanya.db.ban;

import dice.sinanya.db.tools.DbUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dice.sinanya.system.MessagesBanList.groupBanList;
import static dice.sinanya.system.MessagesBanList.qqBanList;

/**
 * @author SitaNya
 * 日期: 2019-08-07
 * 电子邮箱: sitanya@qq.com
 * 维护群(QQ): 162279609
 * 有任何问题欢迎咨询
 * 类说明:
 */
public class SelectBanList {
    private static final Logger Log = LogManager.getLogger(SelectBanList.class.getName());

    /**
     * 读取数据库中的骰点历史信息到缓存
     */
    public void flushQqBanListFromDataBase() {
        qqBanList.clear();
        try (Connection conn = DbUtil.getConnection()) {
            String sql = "select * from qqBanList order by qqId";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                try (ResultSet set = ps.executeQuery()) {
                    while (set.next()) {
                       qqBanList.put(set.getString("qqId"),set.getString("reason"));
                    }
                }
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * 读取数据库中的骰点历史信息到缓存
     */
    public void flushGroupBanListFromDataBase() {
        groupBanList.clear();
        try (Connection conn = DbUtil.getConnection()) {
            String sql = "select * from groupBanList order by groupId";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                try (ResultSet set = ps.executeQuery()) {
                    while (set.next()) {
                        groupBanList.put(set.getString("groupId"),set.getString("reason"));
                    }
                }
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }
}
