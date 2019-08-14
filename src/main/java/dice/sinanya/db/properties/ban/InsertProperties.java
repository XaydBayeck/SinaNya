package dice.sinanya.db.properties.ban;

import dice.sinanya.db.tools.DbUtil;
import dice.sinanya.entity.EntityBanProperties;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.sobte.cqp.jcq.event.JcqApp.CQ;

/**
 * @author SitaNya
 * 日期: 2019-06-15
 * 电子邮箱: sitanya@qq.com
 * 维护群(QQ): 162279609
 * 有任何问题欢迎咨询
 * 类说明: 录入KP主群类
 */
public class InsertProperties {

    public void insertProperties(EntityBanProperties entityBanProperties) {
        try (Connection conn = DbUtil.getConnection()) {
            //language=MySQL
            String sql = "replace into banProperties(" +
                    "cloudBan," +
                    "Prometheus," +
                    "heap," +
                    "`master`," +
                    "notMaster," +
                    "banListInputNotId," +
                    "doSomthingForBanUserInGroup," +
                    "ignoreBanUser," +
                    "leaveByBanUser," +
                    "leaveGroupByBan," +
                    "banGroupBecauseBan," +
                    "banGroupBecauseReduce," +
                    "banUserBecauseReduce," +
                    "addGroup," +
                    "addFriend," +
                    "refuseGroupByBan," +
                    "refuseFriendByBan," +
                    "whiteGroup," +
                    "whiteUser," +
                    "notBanListInput," +
                    "botId," +
                    "clearGroupByOff,clearGroup,alterFrequentness,banFrequentness)  VALUES (?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?,?,?,?,?);";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setBoolean(1, entityBanProperties.isCloudBan());
                ps.setBoolean(2, entityBanProperties.isPrometheus());
                ps.setBoolean(3, entityBanProperties.isHeap());
                ps.setString(4, entityBanProperties.getMaster());
                ps.setString(5, entityBanProperties.getNotMaster());
                ps.setString(6, entityBanProperties.getBanListInputNotId());
                ps.setBoolean(7, entityBanProperties.isDoSomthingForBanUserInGroup());
                ps.setBoolean(8, entityBanProperties.isIgnoreBanUser());
                ps.setBoolean(9, entityBanProperties.isLeaveByBanUser());
                ps.setBoolean(10, entityBanProperties.isLeaveGroupByBan());
                ps.setBoolean(11, entityBanProperties.isBanGroupBecauseBan());
                ps.setBoolean(12, entityBanProperties.isBanGroupBecauseReduce());
                ps.setBoolean(13, entityBanProperties.isBanUserBecauseReduce());
                ps.setString(14, entityBanProperties.getAddGroup());
                ps.setString(15, entityBanProperties.getAddFriend());
                ps.setString(16, entityBanProperties.getRefuseGroupByBan());
                ps.setString(17, entityBanProperties.getRefuseFriendByBan());
                ps.setString(18, entityBanProperties.getWhiteGroup());
                ps.setString(19, entityBanProperties.getWhiteUser());
                ps.setString(20, entityBanProperties.getNotBanListInput());
                ps.setString(21, String.valueOf(CQ.getLoginQQ()));
                ps.setInt(22,entityBanProperties.getClearGroupByOff());
                ps.setInt(23,entityBanProperties.getClearGroup());
                ps.setInt(24,entityBanProperties.getAlterFrequentness());
                ps.setInt(25,entityBanProperties.getBanFrequentness());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            CQ.logError(e.getMessage(), StringUtils.join(e.getStackTrace(), "\n"));
        }
    }
}