package com.xm.core;

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
