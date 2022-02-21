package com.xm.core;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Set;

public class PubTool {

    public static String getPidPaths(String pidPahts, String trimId){
        int i=pidPahts.indexOf(trimId+",");
        if(i>0){
            return pidPahts.substring(0,i);
        }else{
            return pidPahts;
        }
    }


}
