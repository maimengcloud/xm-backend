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

}
