package dice.sinanya.system;

public interface MessagesSystem {
    String VERSIONS = "0.1.0.0 beta";
    String STR_SUCCESSFULLY_ENABLED_NOTICE = "啊~您需要奈梅斯了吗？我一定会好好努力的";
    String STR_ALREADY_ENABLED_ERR = "嗯！我在的呢，您尽管吩咐吧";
    String STR_SUCCESSFULLY_DISABLED_NOTICE = "这样啊……你找到更好的骰子了对吗？奈梅斯明白的，会好好安静下来的……";
    String STR_ALREADY_DISABLED_ERR = "奈梅斯还不够安静吗？您……您需要我离开吗？";
    String STR_EXIT_INFO = "离开群";


    StringBuilder STR_BOT_VERSIONS = new StringBuilder()
            .append("Dice made in java\n")
            .append("By SitaNya\n")
            .append("Versions is:\t")
            .append(VERSIONS)
            .append("\n\n");

    StringBuilder STR_BOT_INFO = new StringBuilder()
            .append(STR_BOT_VERSIONS.toString())
            .append("命令索引:\n")
            .append(".bot\t\t")
            .append("查看骰子版本信息\n")
            .append(".bot on\t\t")
            .append("开启骰子\n")
            .append(".bot off\t\t")
            .append("关闭骰子\n")
            .append(".bot exit\t\t")
            .append("命令骰子主动退群\n\n")
            .append(".help normal\t\t")
            .append("常用骰点指令:由于是全新底层的骰子，可能许多命令和原版不同\n")
            .append(".help book\t\t")
            .append("资料集:包含规则书、魔法大全等\n")
            .append(".help make\t\t")
            .append("获取车卡相关信息:如人物卡、车卡指南、RP守则等\n")
            .append(".help group\t\t")
            .append("带团增强:生成npc、隐蔽对抗、自动日志、PC状态管理等功能\n")
            .append(".help dnd\t\t")
            .append("dnd骰点命令集:没写呢，因为实在不会玩dnd，想要我写很简单，来个dm教教我怎么入门……");
}
