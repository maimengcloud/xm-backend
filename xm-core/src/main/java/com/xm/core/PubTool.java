package com.xm.core;

import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

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

    public static Set<String> getPidSet(String pidPahts, String trimId){
        if(!StringUtils.hasText(pidPahts)){
            return new HashSet<>();
        }
        Set<String> sets=new HashSet<>();
        String[] pids=pidPahts.split(",");
        for (String pid : pids) {
            if("0".equals(pid)||pid.equals(trimId)){
                continue;
            }
            sets.add(pid);

        }
        return sets;
    }

}
