package dice.sinanya.db.roles;

import dice.sinanya.db.tools.DbUtil;
import dice.sinanya.entity.EntityRoleTag;
import dice.sinanya.entity.EntityTypeMessages;
import dice.sinanya.system.RolesInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import static dice.sinanya.system.RoleInfoCache.ROLE_CHOOSE;
import static dice.sinanya.system.RoleInfoCache.ROLE_INFO_CACHE;

public class SelectRoles {
    public SelectRoles() {
    }

    public void flushRoleChooseByQQ(long qqId) {
        try (Connection conn = DbUtil.getConnection()) {
            String sql = "select * from CHOOSE_ROLE where qq=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, qqId);
                try (ResultSet set = ps.executeQuery()) {
                    while (set.next()) {
                        ROLE_CHOOSE.put(set.getLong("qq"), set.getString("role"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("AlibabaMethodTooLong")
    public void flushRoleInfoCacheByFromQQ(EntityTypeMessages entityTypeMessages) {
        long qqId = Long.parseLong(entityTypeMessages.getFromQQ());
        selectRoleInfoCache(qqId);
    }

    @SuppressWarnings("AlibabaMethodTooLong")
    public void flushRoleChooseByFromQQ(EntityTypeMessages entityTypeMessages) {
        long qqId = Long.parseLong(entityTypeMessages.getFromQQ());
        selectRoleInfoCache(qqId);
    }

    @SuppressWarnings("AlibabaMethodTooLong")
    public void flushRoleInfoCacheByQQ(long qqId) {
        selectRoleInfoCache(qqId);
    }

    @SuppressWarnings("AlibabaMethodTooLong")
    public void flushRoleInfoCacheByQQ(String qqId) {
        long qq = Long.parseLong(qqId);
        flushRoleChooseByQQ(qq);
    }

    private void selectRoleInfoCache(long qqId) {
        HashMap<String, Integer> propertiesForRole = new RolesInfo().getPropertiesForRole();
        try (Connection conn = DbUtil.getConnection()) {
            String sql = "select * from role where qqId=?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setLong(1, qqId);
                try (ResultSet set = ps.executeQuery()) {
                    while (set.next()) {
                        String role = set.getString("userName");
                        propertiesForRole.put("str", set.getInt("str"));
                        propertiesForRole.put("dex", set.getInt("dex"));
                        propertiesForRole.put("pow", set.getInt("pow"));
                        propertiesForRole.put("con", set.getInt("con"));
                        propertiesForRole.put("app", set.getInt("app"));
                        propertiesForRole.put("edu", set.getInt("edu"));
                        propertiesForRole.put("siz", set.getInt("siz"));
                        propertiesForRole.put("intValue", set.getInt("intValue"));
                        propertiesForRole.put("san", set.getInt("san"));
                        propertiesForRole.put("luck", set.getInt("luck"));
                        propertiesForRole.put("mp", set.getInt("mp"));
                        propertiesForRole.put("hp", set.getInt("hp"));
                        propertiesForRole.put("accounting", set.getInt("accounting"));
                        propertiesForRole.put("anthropology", set.getInt("anthropology"));
                        propertiesForRole.put("evaluation", set.getInt("evaluation"));
                        propertiesForRole.put("archaeology", set.getInt("archaeology"));
                        propertiesForRole.put("enchantment", set.getInt("enchantment"));
                        propertiesForRole.put("toClimb", set.getInt("toClimb"));
                        propertiesForRole.put("computerUsage", set.getInt("computerUsage"));
                        propertiesForRole.put("creditRating", set.getInt("creditRating"));
                        propertiesForRole.put("cthulhuMythos", set.getInt("cthulhuMythos"));
                        propertiesForRole.put("disguise", set.getInt("disguise"));
                        propertiesForRole.put("dodge", set.getInt("dodge"));
                        propertiesForRole.put("drive", set.getInt("drive"));
                        propertiesForRole.put("electricalMaintenance", set.getInt("electricalMaintenance"));
                        propertiesForRole.put("electronics", set.getInt("electronics"));
                        propertiesForRole.put("talkingSkill", set.getInt("talkingSkill"));
                        propertiesForRole.put("aFistFight", set.getInt("aFistFight"));
                        propertiesForRole.put("wrangle", set.getInt("wrangle"));
                        propertiesForRole.put("pistol", set.getInt("pistol"));
                        propertiesForRole.put("firstAid", set.getInt("firstAid"));
                        propertiesForRole.put("history", set.getInt("history"));
                        propertiesForRole.put("intimidate", set.getInt("intimidate"));
                        propertiesForRole.put("jump", set.getInt("jump"));
                        propertiesForRole.put("motherTongue", set.getInt("motherTongue"));
                        propertiesForRole.put("law", set.getInt("law"));
                        propertiesForRole.put("libraryUse", set.getInt("libraryUse"));
                        propertiesForRole.put("listen", set.getInt("listen"));
                        propertiesForRole.put("unlock", set.getInt("unlock"));
                        propertiesForRole.put("mechanicalMaintenance", set.getInt("mechanicalMaintenance"));
                        propertiesForRole.put("medicalScience", set.getInt("medicalScience"));
                        propertiesForRole.put("naturalHistory", set.getInt("naturalHistory"));
                        propertiesForRole.put("naturalScience", set.getInt("naturalScience"));
                        propertiesForRole.put("pilotage", set.getInt("pilotage"));
                        propertiesForRole.put("occultScience", set.getInt("occultScience"));
                        propertiesForRole.put("operatingHeavyMachinery", set.getInt("operatingHeavyMachinery"));
                        propertiesForRole.put("persuade", set.getInt("persuade"));
                        propertiesForRole.put("psychoanalysis", set.getInt("psychoanalysis"));
                        propertiesForRole.put("psychology", set.getInt("psychology"));
                        propertiesForRole.put("horsemanship", set.getInt("horsemanship"));
                        propertiesForRole.put("aWonderfulHand", set.getInt("aWonderfulHand"));
                        propertiesForRole.put("investigationOfCrimes", set.getInt("investigationOfCrimes"));
                        propertiesForRole.put("stealth", set.getInt("stealth"));
                        propertiesForRole.put("existence", set.getInt("existence"));
                        propertiesForRole.put("swimming", set.getInt("swimming"));
                        propertiesForRole.put("throwValue", set.getInt("throwValue"));
                        propertiesForRole.put("trackValue", set.getInt("trackValue"));
                        propertiesForRole.put("domesticatedAnimal", set.getInt("domesticatedAnimal"));
                        propertiesForRole.put("diving", set.getInt("diving"));
                        propertiesForRole.put("blast", set.getInt("blast"));
                        propertiesForRole.put("lipReading", set.getInt("lipReading"));
                        propertiesForRole.put("hypnosis", set.getInt("hypnosis"));
                        propertiesForRole.put("artillery", set.getInt("artillery"));

                        ROLE_INFO_CACHE.put(new EntityRoleTag(qqId, role), propertiesForRole);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}