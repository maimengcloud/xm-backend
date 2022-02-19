package com.xm.core;

public class PubTool {

    public static String getPidPaths(String pidPahts, String trimId){
        return pidPahts.substring(0,pidPahts.indexOf(trimId+","));
    }
}
