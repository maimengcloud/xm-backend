package com.xm.core.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description="项目权限码")
/**
 *
 权限码0,1,2,3,4,5,67,8,9，逗号分割
 共10位,不定长，暂时只启用前2个位
 第0位代表计划及任务指派及crud权限：
 0-代表不限制,1-同组织，2-同项目组（默认），3-同小组
 第1位代表计划及任务指派及crud时是否检查上下级关系：0-否（默认），1是
 */
public class ProjectQxCodeVo {


}
