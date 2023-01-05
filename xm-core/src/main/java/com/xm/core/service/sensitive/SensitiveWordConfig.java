package com.xm.core.service.sensitive;

import com.mdp.sensitive.SensitiveWordService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class SensitiveWordConfig {

    @Value("mdp.sensitive-word.words:")
    String sensitiveWords="";

    @Bean
    SensitiveWordService xmSensitiveWordInit(){
        Set<String> sensitiveWordSet=new HashSet<>();
        SensitiveWordService xmSensitiveWordService=new SensitiveWordService();
        if(StringUtils.hasText(sensitiveWords)){
            String[] words=sensitiveWords.split(",");
            for (String word : words) {
                sensitiveWordSet.add(word);
            }
            xmSensitiveWordService.init(sensitiveWordSet);
        }else{
            xmSensitiveWordService.init(sensitiveWordSet);
        }
        return xmSensitiveWordService;
    }

    public static void main(String[] args) {
        String sensitiveWords="尼玛,sb,傻逼,草泥马,蛋疼,你妹,绿茶婊,屌爆,秒杀,抢爆,再不抢就没了,不会再便宜了,万人疯抢,抢疯了,霸王餐,0元价,算命,算卦,保佑,带来好运气,增强第六感,化解小人,增加事业运,招财进宝,健康富贵,提升运气,有助事业,护身,平衡正负能量,消除精神压力,调和气压,逢凶化吉,时来运转,万事亨通,旺人,旺财,助吉避凶,转富招福,高丽棒子,黑鬼,血统,杂种,东亚病夫,蛮夷,大男人,小女人,男尊女卑,重男轻女,洋鬼子,小日本,大汉族主义,全面调整人体内分泌平衡,增强或提高免疫力,助眠,失眠,滋阴补阳,壮阳,消炎,可促进新陈代谢,减少红血丝,产生优化细胞结构,修复受损肌肤,治愈,抗炎,活血,解毒,抗敏,脱敏,减肥,清热解毒,清热袪湿,治疗,除菌,杀菌,抗菌,灭菌,防菌,消毒,排毒,防敏,柔敏,舒敏,缓敏,脱敏,褪敏,改善敏感肌肤,改善过敏现象,降低肌肤敏感度,镇定,镇静,理气,行气,活血,生肌肉,补血,安神,养脑,益气,通脉,胃胀蠕动,利尿,驱寒解毒,调节内分泌,延缓更年期,补肾,祛风,生发,防癌,抗癌,祛疤,降血压,防治高血压,治疗,改善内分泌,平衡荷尔蒙,防止卵巢及子宫的功能紊乱,去除体内毒素,吸附铅汞,除湿,润燥,治疗腋臭,治疗体臭,治疗阴臭,美容治疗,消除斑点,斑立净,无斑,治疗斑秃,逐层减退多种色斑,妊娠纹,毛发新生,毛发再生,生黑发,止脱,生发止脱,脂溢性脱发,病变性脱发,毛囊激活,酒糟鼻,伤口愈合清除毒素,缓解痉挛抽搐,减轻或缓解疾病症状,处方,药方,例临床观察具有明显效果,丘疹,脓疱,手癣,甲癣,体癣,头癣,股癣,脚癣,脚气,鹅掌癣,花斑癣,牛皮癣,传染性湿疹,伤风感冒,经痛,肌痛,头痛,腹痛,便秘,哮喘,支气管炎,消化不良,刀伤,烧伤,烫伤,疮痈,毛囊炎,皮肤感染,皮肤面部痉挛,细菌,真菌,念珠菌,糠秕孢子菌,厌氧菌,牙孢菌,痤疮,毛囊寄生虫,雌性激素,雄性激素,荷尔蒙,抗生素,激素,药物,中草药,中枢神经,细胞再生,细胞增殖和分化,免疫力,患处,疤痕,关节痛,冻疮,冻伤,皮肤细胞间的氧气交换,红肿,淋巴液,毛细血管,淋巴毒,采用新型着色机理永不褪色,迅速修复受紫外线伤害的肌肤,更新肌肤,破坏黑色素细胞,黑色素的形成,丰乳,丰胸,使乳房丰满,预防乳房松弛下垂,改善睡眠,舒眠,特效,高效,全效,强效,速效,速白,一洗白,XX天见效,XX周期见效,超强,激活,全方位,全面,安全,无毒,溶脂,吸脂,燃烧脂肪,瘦身,瘦脸,瘦腿,减肥,延年益寿,提高（保护）记忆力,提高肌肤抗刺激,消除,清除,化解死细胞,去（祛）除皱纹,平皱,修复断裂弹性（力）纤维,止脱";
        Set<String> sensitiveWordSet=new HashSet<>();
        SensitiveWordService xmSensitiveWordService=new SensitiveWordService();
        if(StringUtils.hasText(sensitiveWords)){
            String[] words=sensitiveWords.split(",");
            for (String word : words) {
                sensitiveWordSet.add(word);
            }
            xmSensitiveWordService.init(sensitiveWordSet);
        }else{
            xmSensitiveWordService.init(sensitiveWordSet);
        }

        String txt="草泥马蛋疼你妹绿茶婊屌爆,秒杀,抢爆,再不抢就没了";
        Set<String> words=xmSensitiveWordService.getSensitiveWord(txt);
        System.out.println(words);
    }

}
