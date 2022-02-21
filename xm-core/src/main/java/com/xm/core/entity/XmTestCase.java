package com.xm.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 组织 com.qqkj  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTestCase所有属性名: <br>
 *	id,caseName,caseRemark,testStep,expectResult,menuId,menuName,ctime,ltime,luserid,lusername,cbranchId,moduleId,moduleName,caseStatus;<br>
 * 表 XM.xm_test_case 测试用例的所有字段名: <br>
 *	id,case_name,case_remark,test_step,expect_result,menu_id,menu_name,ctime,ltime,luserid,lusername,cbranch_id,module_id,module_name,case_status;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="测试用例")
public class XmTestCase  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="标题",allowEmptyValue=true,example="",allowableValues="")
	String caseName;
	
	@ApiModelProperty(notes="备注",allowEmptyValue=true,example="",allowableValues="")
	String caseRemark;
	
	@ApiModelProperty(notes="测试步骤",allowEmptyValue=true,example="",allowableValues="")
	String testStep;
	
	@ApiModelProperty(notes="期望结果",allowEmptyValue=true,example="",allowableValues="")
	String expectResult;
	
	@ApiModelProperty(notes="关联的需求",allowEmptyValue=true,example="",allowableValues="")
	String menuId;
	
	@ApiModelProperty(notes="关联需求名",allowEmptyValue=true,example="",allowableValues="")
	String menuName;
	
	@ApiModelProperty(notes="创建时间",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="更新时间",allowEmptyValue=true,example="",allowableValues="")
	Date ltime;
	
	@ApiModelProperty(notes="更新人编号",allowEmptyValue=true,example="",allowableValues="")
	String luserid;
	
	@ApiModelProperty(notes="更新人姓名",allowEmptyValue=true,example="",allowableValues="")
	String lusername;
	
	@ApiModelProperty(notes="创建机构",allowEmptyValue=true,example="",allowableValues="")
	String cbranchId;
	
	@ApiModelProperty(notes="模块编号",allowEmptyValue=true,example="",allowableValues="")
	String moduleId;
	
	@ApiModelProperty(notes="模块名称",allowEmptyValue=true,example="",allowableValues="")
	String moduleName;
	
	@ApiModelProperty(notes="用例状态1正常0废弃",allowEmptyValue=true,example="",allowableValues="")
	String caseStatus;

	/**主键**/
	public XmTestCase(String id) {
		this.id = id;
	}
    
    /**测试用例**/
	public XmTestCase() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 标题
	 **/
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	/**
	 * 备注
	 **/
	public void setCaseRemark(String caseRemark) {
		this.caseRemark = caseRemark;
	}
	/**
	 * 测试步骤
	 **/
	public void setTestStep(String testStep) {
		this.testStep = testStep;
	}
	/**
	 * 期望结果
	 **/
	public void setExpectResult(String expectResult) {
		this.expectResult = expectResult;
	}
	/**
	 * 关联的需求
	 **/
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * 关联需求名
	 **/
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 创建时间
	 **/
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 更新时间
	 **/
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	/**
	 * 更新人编号
	 **/
	public void setLuserid(String luserid) {
		this.luserid = luserid;
	}
	/**
	 * 更新人姓名
	 **/
	public void setLusername(String lusername) {
		this.lusername = lusername;
	}
	/**
	 * 创建机构
	 **/
	public void setCbranchId(String cbranchId) {
		this.cbranchId = cbranchId;
	}
	/**
	 * 模块编号
	 **/
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	/**
	 * 模块名称
	 **/
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	/**
	 * 用例状态1正常0废弃
	 **/
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
	
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 标题
	 **/
	public String getCaseName() {
		return this.caseName;
	}
	/**
	 * 备注
	 **/
	public String getCaseRemark() {
		return this.caseRemark;
	}
	/**
	 * 测试步骤
	 **/
	public String getTestStep() {
		return this.testStep;
	}
	/**
	 * 期望结果
	 **/
	public String getExpectResult() {
		return this.expectResult;
	}
	/**
	 * 关联的需求
	 **/
	public String getMenuId() {
		return this.menuId;
	}
	/**
	 * 关联需求名
	 **/
	public String getMenuName() {
		return this.menuName;
	}
	/**
	 * 创建时间
	 **/
	public Date getCtime() {
		return this.ctime;
	}
	/**
	 * 更新时间
	 **/
	public Date getLtime() {
		return this.ltime;
	}
	/**
	 * 更新人编号
	 **/
	public String getLuserid() {
		return this.luserid;
	}
	/**
	 * 更新人姓名
	 **/
	public String getLusername() {
		return this.lusername;
	}
	/**
	 * 创建机构
	 **/
	public String getCbranchId() {
		return this.cbranchId;
	}
	/**
	 * 模块编号
	 **/
	public String getModuleId() {
		return this.moduleId;
	}
	/**
	 * 模块名称
	 **/
	public String getModuleName() {
		return this.moduleName;
	}
	/**
	 * 用例状态1正常0废弃
	 **/
	public String getCaseStatus() {
		return this.caseStatus;
	}

}