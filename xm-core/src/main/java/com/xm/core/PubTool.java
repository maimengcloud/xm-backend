package com.xm.core;

import org.springframework.util.StringUtils;

public class PubTool {

    public static String getPidPaths(String pidPahts, String trimId){
        if(!StringUtils.hasText(pidPahts)){
            return null;
        }
        int i=pidPahts.indexOf(trimId+",");
        if(i>0){
            return pidPahts.substring(0,i);
        }else{
            return pidPahts;
        }
    }


}
