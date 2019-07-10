package dice.sinanya.system;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author SitaNya
 * 日期: 2019-06-15
 * 电子邮箱: sitanya@qq.com
 * 维护群(QQ): 162279609
 * 有任何问题欢迎咨询
 * 接口说明: 煤气灯的静态信息
 */
public class MessagesGas {

    private static ArrayList<String> initGas0() {
        return new ArrayList<String>() {{
            add("任意选择一个有(D)记号的特征。");
            add("高龄(D):年龄追加[(1D3+1)*10]岁,参照6版标准规则,超过30岁后开始获得EDU加值,40岁以后开始对于身体属性造成减值。");
            add("优雅的岁数: 40岁开始对身体能力造成减值的规则改为从50岁开始。");
            add("白化病患者(D):STR,CON,SIZ,DEX,POW,APP中的任意一项减少15点。在明亮阳光下时[侦察]技能值减少[1D4-1]*5%点,长时间受到光照的话会受到1点以上的HP伤害。白化病人在人群中很显眼并可能被他人用有色目光看待.");
            add("酒精中毒(D):CON-5。STR,DEX,POW,APP中任意一项减少5点。为了避免陷入酩酊大醉需要通过一个SANCHECK。陷入疯狂的情况下,调查员可能会寻求酒精来逃避现实。");
            add("警戒:不易被惊吓到。潜行时一直都保持着能够随时[侦察]或者[聆听]的状态。");
            add("同盟者:投掷一个D100来决定同盟的力量/数量和出现的频率(D100的出点越大可能能够获得越有利的同盟)。用途不限。");
            add("双手灵活:调查员可以灵活的使用他的任意一只手而不会受到非惯用手的惩罚。");
            add("讨厌动物(D):技能和动物有关时技能成功率减少[1D6*5]点。");
            add("艺术天才:音乐,写作之类的艺术技能增加[INT]%。");
            add("运动:运动系技能获得加值=选择一个技能+30%,或者选择两个技能各+20%,或者选择三个技能各+10%。");
            add("夜视强化:日落西山后视觉相关惩罚只有常人的一半。");
            add("累赘(D):调查员出生于世家但是却没能达到家人的期待,或者不服管教。对于交涉系技能可能会造成影响而减少[1D3*10]%。");
            add("领导者资质:POW+1D2*5,交涉系技能+[INT]%。");
            add("打斗者:[拳击]或者[擒拿]+[1D4*5]%,每回合可以进行两次[拳击]或者[擒拿],攻击成功时+1点伤害。");
            add("笨拙(D):大失败的几率变成通常的2倍,并且大失败时可能会招致灾难。");
            add("收藏家:调查员有收集硬币,书,昆虫,艺术作品,宝石,古董之类的爱好。");
            add("身体障碍(D):失去了身体的一部分。投掷一个D6。1~2=脚,3~4=手,5=头部(投掷D6,1~3=眼睛,4~6=耳朵),6=玩家自己选择。失去脚的话DEX-15，STR或者CON-5,MOVE只有常人的一半,所有运动系技能-25%。失去手腕的话STR-5,DEX-10,所有的操作系技能-15%,使用武器会受到限制。失去眼睛的话[侦察]和火器技能等全部-35%,另外投掷一个[幸运],失败的话APP-1D2*5。失去耳朵的话APP-1D3*5,[聆听]等和耳朵有关的技能全部-30%。");
            add("再投掷三次,由玩家选择其中一个作为特征。");
            add("再投掷三次,玩家和KP各选择一个特征。");
        }};
    }

    private static ArrayList<String> initGas1() {
        return new ArrayList<String>() {{
            add("再投掷一次,获得那个特征:特征具有(D)时,玩家可以再额外选择一个其他任意特征获得。特征没有(D)时,玩家必须再同时选择一个(D)特征。");
            add("诅咒(D):调查员被吉普赛人,魔女,法师,外国原住民等施予了诅咒,诅咒效果等同[邪眼]咒文或者由KP决定。KP也可以决定解除诅咒的条件。");
            add("黑暗先祖(D):调查员具有邪恶的一族,外国人,食人族,甚至神话生物的血统。投掷一个D100,出点越大,血统也越可怖。");
            add("听觉障碍(D):[聆听]减少[1D4*5]%。");
            add("绝症缠身(D):调查员身患绝症[癌症,失明,梅毒,结核等],绝症对调查员造成恶劣影响,至少也失去了5点CON,如果病情继续恶化的话还会继续失去其他能力值。投掷一个D100来决定剩余寿命,出点越大寿命越长。");
            add("钟楼怪人:调查员具有巨大的伤痕或者身体变形等特征,对APP造成至少减少1D4*5点影响。对交涉系技能也可能也造成影响[(失去的APP)]。");
            add("酒豪:不易喝醉。酒精作为毒素处理的情况下, POT值只有他人的一半。");
            add("鹰眼:[侦察]增加[2D3*5]%。");
            add("敌人(D):有对调查员不利的敌人存在,投掷一个D100来决定敌人的力量/数量,数值越大越恶劣。用途不限。");
            add("擅长武器:火器类射程+50%。近战类武器成功率+5%或者伤害增加1D2。并且武器不易被破坏(具有更多的耐久度),或者入手的武器具有比一般的武器更高的品质。");
            add("传家宝:调查员拥有绘画,书籍,武器,家具等具有高价值的宝物。也可能是模组中追加的宝物的持有人。");
            add("俊足:DEX+1*5。再投掷一个D6,1~4时MOVE+1,5~6时MOVE+2。");
            add("赌徒(D?):进行一次[幸运]鉴定。成功的话调查员获得[(INT+POW)*2/5]%的[赌博]技能。失败的话只有[INT或者POW*0.2]%的技能值,信用减少调查员原信用评级的[1D6*10]%,并且调查员遇到赌博时需要通过一个SAN CHECK才能克制自己。");
            add("擅长料理:获得 [(INT或者EDU)]%的[手艺(料理)]技能。");
            add("听力良好:[聆听]+[2D3*5]%。");
            add("洞察人心:[心理学]+ [2D3*5]%。");
            add("反应灵敏:投掷1D6。1~3=DEX+1*5,4~5=DEX+2*5,6=DEX+3*5。");
            add("驱使动物:技能和动物有关时获得[(1D6+1)*5]的加值,例如骑马,驾驶马车,特定情况的藏匿,潜行等。");
            add("没有特征但是可以选择任意技能(可多选)获得总计3D20点技能加值。");
            add("玩家自己选择一个特征。");
        }};
    }

    private static ArrayList<String> initGas2() {
        return new ArrayList<String>() {{
            add("再投掷三次,玩家和KP各选择一个。");
            add("贪婪(D):对调查员来说金钱至上。任何状况下都优先考虑金钱。为此欺骗他人也是正常的,欺骗对象也包含其他调查员。");
            add("悲叹人生:SAN-1D10,玩家和KP给调查员设定一个背景(失去爱人,子孙或者其他血亲的悲剧)。");
            add("憎恶(D):玩家和KP商议决定,调查员对于特定的国籍,人种或者宗教具有无理由的反感。调查员接触此类人群时会表现出敌意。");
            add("比马还要健壮:CON+1D3*5。");
            add("快乐主义者:追求个人的喜悦(美食,饮品,性,衣装,音乐,家具等)。为此浪费了调查员现有信用评级的[(1D4+2)*10]%的信用评级。通过一个[幸运]鉴定,失败的话因为这种放纵的生活而失去5点STR,CON,INT,POW,DEX或者APP。");
            add("骑手:[骑马]技能+[(1D6+1)*10]%。");
            add("易冲动(D):有不考虑后果轻率的行动的倾向。根据情况可能需要通过一个减半的[灵感]鉴定来使头脑冷静。");
            add("巧妙:二选一。A)[灵感]+10%,获得可以临时组装或者发明一些装置的能力。B)武器以外的操纵系技能获得加值,只选择一个技能的话+30%,选择2个技能各+20%,3个各+10%。");
            add("疯狂(D):SAN-1D8。玩家和KP商议给予调查员一个精神障碍。");
            add("土地勘测员:调查员对某一篇地域了解的非常详细(例:建筑配置,道路,商业,住民,历史等)。对应的区域应为都市某一块区域或者单个农村之类的较狭小的范围。对于这篇区域的详细情况调查员通过[教育]或者[灵感]鉴定即可知晓。");
            add("意志顽强:POW+1D3*5,san也获得对应的上升。");
            add("花花公子:APP+1D3*5,和异性交往有关的交涉技能+[1D3*10]%。");
            add("持有高额财产:调查员拥有某种具有巨大价值的东西(例:船只,工厂,房屋,矿山,大块的土地等)。这些东西可能需要调查员花费很大的时间和精力在这里，玩家和KP要慎重的决定。");
            add("语言学家:调查员即使语言不通也有可能和对象成功的交流,增加一个辅助技能[语言学家],初期技能值为[INT或者EDU]*0.2%。");
            add("家人失踪:调查员有着失踪很久的家人,有可能会在模组中登场(例:兄弟/姐妹/或者其他亲人遭遇海难,死在海外,被其他亲戚带走等情况)。");
            add("忠诚:调查员不会抛弃自己的家人,朋友,伙伴,在力所能及的范围内一定会帮助他们。这种性格也使他和自己周围的人群交涉时获得10%的加值。");
            add("魔术素质:学习咒文时只需要正常的一半时间,成功率也增加[INT*0.2]%。");
            add("虽然没有特侦但是职业技能值获得额外的3D20的技能点。");
            add("玩家自己选择一个特征。");
        }};
    }

    private static ArrayList<String> initGas3() {
        return new ArrayList<String>() {{
            add("虽然没有特征,但是调查员的持有现金为通常规则的2倍。");
            add("魔术道具:KP可以给予调查员一个魔术道具(可以杀伤神话生物的附魔武器,召唤神话生物的专用道具,占卜用品,POW储藏器等等)。调查员如果想要知道这件道具的详细性质需要通过一个[POW*0.2]的鉴定。");
            add("射击名人(手枪,步枪以及霰弹枪中选择一项):选择的这项火器技能+[2D3*5]%。");
            add("认错人:调查员被频繁的被误认为其他人,通常都会是些有着恶评的人物(罪犯,身怀丑闻的恶人之类的)。模组中在合适的情况下[幸运]可能会被降为原本的一半(简单来说,调查员因为某些理由获得其他人的犯罪历史,恶名,通过诈骗获得的财富或者权力这样的身份或者特征)。");
            add("天气预报:通过一个[灵感]鉴定调查员就可以得知[1D6+1]小时里的正确天气情况。有多大的降雨量,下雨的场所,风级,持续时间等等。");
            add("对外观的强迫观念(D):APP+5,但是调查员为了让自己看起来亮丽动人而花费大量的金钱来购买华贵的服饰和饰物。信用评级减半。");
            add("古书:调查员拥有和模组有关的重要书籍资料或者它的复印(例:杂志,黑魔术书籍,历史书,圣经,神话魔导书,地图等等)。KP可以决定这件道具的性质和价值。");
            add("试炼生还者:SAN-1D6。调查员拥有从恐怖环境中生还的经验(海难,战争,恐怖分子劫持,地震等等)。因为这个经历可能给调查员带来某种长久的影响(通常程度的恐怖症状,或者其他的精神障碍等)。");
            add("孤儿:调查员相依为命的家人都不在了,或者不知道自己真正的家人是谁。");
            add("其他语言:调查员可以追加获得一项其他语言技能。技能值为[1D4*INT*0.2]%。");
            add("野外活动爱好者:[导航],[自然史],[追踪]各增加[(2D3+1)*5]%(分别投掷)。");
            add("寄托爱意:模组中登场的某位角色对调查员怀有憧憬。由KP决定是哪位角色,为什么以及怀有何种程度。");
            add("身怀爱意(D):调查员对其他角色怀有憧憬。由KP决定喜欢谁,为什么以及何种程度。");
            add("麻痹(D):调查员因精神,疾病等原因苦于身体抽搐,扭曲等症状。各鉴定一次[幸运],失败的话减少1D2*5点DEX和5点APP。");
            add("超常现象经历:调查员曾经经历过难以说明的遭遇(幽灵,黑魔术,神话生物,超能力等)。玩家和KP讨论决定其内容并失去最多1D6点SAN值。");
            add("大肚子(D):这位调查员怎么说也太胖了点。鉴定一次[幸运],失败的话投掷一个D6,1~3 CON-5,4~6 APP-5。");
            add("说服力:[劝说]+[(2D3+1)*5]%。");
            add("宠物:调查员有养狗,猫或者鸟类。");
            add("虽然没有特征但是任意技能获得3D20点技能点。");
            add("再投掷一次,获得那个特征:特征具有(D)时,玩家可以再额外选择一个其他任意特征获得。特征没有(D)时,玩家必须再同时选择一个(D)特征。");
        }};
    }

    private static ArrayList<String> initGas4() {
        return new ArrayList<String>() {{
            add("虽然没有特征但是职业技能值额外获得3D20点技能点。");
            add("恐怖症/疯狂(D):调查员身患恐怖症状或者疯狂症状。参考6/7版标准规则随机决定症状,或者选择想要的症状。遭遇到自身症状根源的恐怖或者物品时,如果SAN CHECK失败,那么调查员将无法抑制自己的恐怖或者被魅惑。");
            add("权力/阶级/企业地位:调查员在政治,经济或者甚至军事环境里持有某种程度的权力。投掷D100,出点越大权力越大。企业地位影响融资,政治地位可能所属某种政府机关,军队地位远超本身拥有的军衔也说不定。[信用+25%。详细的情况和KP商议决定。");
            add("以前的经验:玩家可以选择获得[(INT或者EDU)]%的职业技能点数。");
            add("预知梦:由KP决定,游戏中玩家会做一个预言未来的梦。这大概会需要一个[POW*3*0.2]的鉴定。梦境没有必须符合现实的必要,如果梦境中见到的景象十分恐怖的话那么会失去一些SAN值(现实中见到相同景象失去SAN值的10%左右)。鉴定失败的话玩家会获得错误的预言。");
            add("繁荣:调查员的年收入和资产变成2倍。[信用]增加[1D4*5]%。调查员的事业很成功,或者调查员给富翁,持有权力的人做事或者与他们共事。");
            add("心理测量:接触某些物体时(或者抵达某个地方时),通过一个POW*0.2的鉴定,成功的话可以窥视到这个物品/地方的过去。这个能力的正确度由KP决定。这个能力消耗1D6点MP。因为幻觉也可能失去SAN值(和上述的”预知梦”类似,损失通常的10%左右)。");
            add("健谈者:[话术]+[2D4*5]%。调查员有着非常厉害的语言术,可以通过讲故事获得朋友的信任,降低敌人的敌意,赚到一顿免费的餐点也是可能的。");
            add("罕见的技能:调查员通过一个[INT*0.8]%的鉴定的话,可能会持有一些生活中完全不常见,或者一般来说不会有的技能。罕见的语言,格斗技,驾驶热气球之类,和KP商议决定。");
            add("红发:调查员有着一头好像燃烧着一般的红发,非常显眼(没有其他效果)。");
            add("评价(D?):鉴定一次[幸运]。成功的话调查员被人尊敬(设定其理由),调查员在自家所在的村子/都市中所有的交涉系技能获得15%的加值。[幸运]失败的话调查员获得极坏的评价,所有的交涉系技能-15%。KP也可以决定通过良好的业绩来抵消这个恶评。");
            add("报复追求者:调查员相信自己受到了不公正的待遇并且对导致自己受到这种恶意的对象进行报复行为。玩家和KP讨论决定敌人的真身。投掷一个D100来决定敌人的强度和调查员受到这种不公正的程度。");
            add("伤痕:鉴定一次[幸运]。成功的话伤痕没有影响调查员的外观,甚至彰显其英勇也说不定。失败的话失去1D3*5点APP,交涉系技能也减少[1D3*5]%。");
            add("科学的精神:[灵感]+5%。并且选择一个思考类技能+30%或选择2个思考系技能+20%或者所有其他思考系技能+10%。");
            add("秘密(D?):调查员有着决不能告诉别人的秘密。调查员的邻居可能会有些线索也说不定。调查员可能是个罪犯,间谍,或者卖国贼之类的也说不定。内容由玩家和KP商议决定。");
            add("秘密结社:调查员所属于秘密主义的团体,可能会是共济会,蔷薇十字团,神志主义者,炼金术师结社,光明会之类团体的一员。或者是地下医学研究者之类的犯罪/阴谋组织的一员。");
            add("自学:EDU+1D3*5,并增加因此获得的技能值。");
            add("可疑的过去/绯闻(D):调查员过去曾经做过一些惹人怀疑的事情(卖淫,偷人等),或者曾经犯下过某些重大罪行。所有的交涉系技能减少[1D3*10]%。");
            add("再投掷一次,获得那个特征:特征具有(D)时,玩家可以再额外选择一个其他任意特征获得。特征没有(D)时,玩家必须再同时选择一个(D)特征。");
            add("再投掷两次并获得那两个特征。");
        }};
    }

    private static ArrayList<String> initGas5() {
        return new ArrayList<String>() {{
            add("投掷三次,玩家和KP各选择一个特征。");
            add("病弱(D):CON-1D3*5。");
            add("巧妙的手法:[钳工]技能增加[DEX]%,可以在偷窃或者魔术的时候使用。");
            add("迟缓(D):MOVE-1。");
            add("失去名誉(D):探索者因为国籍,性别,人种,宗教或者过去的犯罪记录等原因失去了社会上的名誉地位。作为其影响,调查员可能减少自由活动时间甚至所有的交涉系技能减少[1D4*10]%甚至更多。具体的影响玩家和KP商议决定。");
            add("原军人:调查员获得[INT]点的技能点加到士兵的职业技能上。");
            add("咒文知识:由KP决定!调查员最多可以获知1D3种咒文。SAN值减少1D6点。");
            add("胆小(D):调查员见到血液或者流血就会感觉到身体不适,失去更多的SAN值。也可能因为疾病的原因无法靠近或通过流血现场。");
            add("坚毅:调查员不受到现实中的血迹或者流血的影响。遭遇血迹和流血时SAN损失为最小值,即使见到最残虐的场合(大量被撕裂的人,被猎奇杀死的尸体等)也最多只减少通常的一半。");
            add("比公牛还要强韧:STR+1D3*5。");
            add("迷信(D):调查员迷信不疑,依赖着护身符,仪式或者愚蠢的信念。遭遇超自然现象的时候比通常多损失1点SAN值,即使原本不损失的情况下可能变成损失1点。");
            add("同情心:调查员选择一个交涉系技能+30%或者选择两个各+20%,然后额外再选择一个+10%。");
            add("意外的帮手:调查员因为一些缘由拥有一个对自己忠实并帮助自己的协助者。KP来决定这个协助者的真身和影响(依旧可以D100来决定)。并且D100也决定其频率。");
            add("看不见的财产:调查员有一笔自己不知道的财产。这可能是亲人遗赠的或者理事会之类授予的。这可能会是一块土地,房屋或者事业。这依旧可以用D100来决定去价值程度。");
            add("虚弱(D):STR-1D3*5。");
            add("戴眼镜(D):调查员要看清东西必须戴眼镜。鉴定一个[幸运],成功的话眼镜只在读书或者进行精细工作的时候才需要。失败的话会在激烈运动等情况时会感觉到不能自由行动。不戴眼镜的话和视觉关联的技能减少[1D3*10]%(这个惩罚即使幸运成功也一样)。");
            add("彬彬有礼:调查员的[信用]+10%,真是个有礼貌的绅士(淑女)。");
            add("孩子(D):调查员的年龄变成[10+2D3]岁。最大EDU变成[年龄的1/2+2],DEX+5,STR,CON,APP中任意一项+5。玩家和KP商议决定,调查员大概依旧和家人住在一起,职业等也需要重新修正。");
            add("任意选择一项特征。");
            add("投掷两次,玩家任意选择其中一项特征。");
        }};
    }

    public static final HashMap<Integer, ArrayList<String>> GAS_LIST;

    static {
        HashMap<Integer, ArrayList<String>> gasListTmp = new HashMap<Integer, ArrayList<String>>();
        gasListTmp.put(0, initGas0());
        gasListTmp.put(1,

                initGas1());
        gasListTmp.put(2,

                initGas2());
        gasListTmp.put(3,

                initGas3());
        gasListTmp.put(4,

                initGas4());
        gasListTmp.put(5,

                initGas5());
        GAS_LIST = gasListTmp;
    }

}
