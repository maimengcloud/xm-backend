package com.xm.core;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service

/**
 *
 权限码0,1,2,3,4,5,67,8,9，逗号分割
 共10位,不定长，暂时只启用前2个位
 第0位代表计划及任务指派及crud权限：
 0-代表不限制,1-同组织，2-同项目组（默认），3-同小组
 第1位代表计划及任务指派及crud时是否检查上下级关系：0-否（默认），1是
 */
public class ProjectQxTool {

    /**
     * 获取
     第0位代表计划及任务指派及crud权限：
     0-代表不限制,1-同组织，2-同项目组（默认），3-同小组
     * @param qxCode
     * @return
     */
    public static String getTaskScopeQx(String qxCode){
        String def="2";
        if(StringUtils.isEmpty(qxCode)){
            return def;
        }else{
            if(qxCode.length()<1){
                return def;
            }else{
                String[] qxCodeArr=qxCode.split(",");
                if(qxCodeArr.length<1){
                    return def;
                }else{
                    return qxCodeArr[0];
                }
            }
        }
    }
    /**
     * 获取
     第1位代表计划及任务指派及crud时是否检查上下级关系：0-否（默认），1是
     * @param qxCode
     * @return
     */
    public static String getTaskTransmitQx(String qxCode){
        String def="0";
        if(StringUtils.isEmpty(qxCode)){
            return def;
        }else{
            if(qxCode.length()<2){
                return def;
            }else{
                String[] qxCodeArr=qxCode.split(",");
                if(qxCodeArr.length<2){
                    return def;
                }else{
                    return qxCodeArr[1];
                }
            }
        }
    }
}
