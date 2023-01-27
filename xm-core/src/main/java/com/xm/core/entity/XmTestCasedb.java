package  com.xm.core.entity;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 组织 com  顶级模块 xm 大模块 core  小模块 <br> 
 * 实体 XmTestCasedb所有属性名: <br>
 *	"id","主键","name","用例库名称","cuserid","创建人","cusername","创建人姓名","ctime","创建日期","cbranchId","归属机构编号","productId","产品编号","productName","产品名称","totalCases","总用例数","okCases","通过用例数","errCases","失败用例数","igCases","忽略用例数","blCases","阻塞用例数","bugCnt","bug数目","closedBugs","已关闭bug总数","resolvedBugs","已解决bug总数","activeBugs","激活的bug总数","confirmedBugs","已解决bug总数","testPlans","测试计划数","menus","需求数目","funcs","功能模块数","status","状态0初始，1-启用，2关闭","budgetWorkload","预算工时","actWorkload","实际工时","pbranchId","产品归属企业";<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
 @Data
@ApiModel(description="测试用例库")
public class XmTestCasedb  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="用例库名称",allowEmptyValue=true,example="",allowableValues="")
	String name;
	
	@ApiModelProperty(notes="创建人",allowEmptyValue=true,example="",allowableValues="")
	String cuserid;
	
	@ApiModelProperty(notes="创建人姓名",allowEmptyValue=true,example="",allowableValues="")
	String cusername;
	
	@ApiModelProperty(notes="创建日期",allowEmptyValue=true,example="",allowableValues="")
	Date ctime;
	
	@ApiModelProperty(notes="归属机构编号",allowEmptyValue=true,example="",allowableValues="")
	String cbranchId;
	
	@ApiModelProperty(notes="产品编号",allowEmptyValue=true,example="",allowableValues="")
	String productId;
	
	@ApiModelProperty(notes="产品名称",allowEmptyValue=true,example="",allowableValues="")
	String productName;
	
	@ApiModelProperty(notes="总用例数",allowEmptyValue=true,example="",allowableValues="")
	Integer totalCases;
	
	@ApiModelProperty(notes="通过用例数",allowEmptyValue=true,example="",allowableValues="")
	Integer okCases;
	
	@ApiModelProperty(notes="失败用例数",allowEmptyValue=true,example="",allowableValues="")
	Integer errCases;
	
	@ApiModelProperty(notes="忽略用例数",allowEmptyValue=true,example="",allowableValues="")
	Integer igCases;
	
	@ApiModelProperty(notes="阻塞用例数",allowEmptyValue=true,example="",allowableValues="")
	Integer blCases;
	
	@ApiModelProperty(notes="bug数目",allowEmptyValue=true,example="",allowableValues="")
	Integer bugCnt;
	
	@ApiModelProperty(notes="已关闭bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer closedBugs;
	
	@ApiModelProperty(notes="已解决bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer resolvedBugs;
	
	@ApiModelProperty(notes="激活的bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer activeBugs;
	
	@ApiModelProperty(notes="已解决bug总数",allowEmptyValue=true,example="",allowableValues="")
	Integer confirmedBugs;
	
	@ApiModelProperty(notes="测试计划数",allowEmptyValue=true,example="",allowableValues="")
	Integer testPlans;
	
	@ApiModelProperty(notes="需求数目",allowEmptyValue=true,example="",allowableValues="")
	Integer menus;
	
	@ApiModelProperty(notes="功能模块数",allowEmptyValue=true,example="",allowableValues="")
	Integer funcs;
	
	@ApiModelProperty(notes="状态0初始，1-启用，2关闭",allowEmptyValue=true,example="",allowableValues="")
	String status;
	
	@ApiModelProperty(notes="预算工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal budgetWorkload;
	
	@ApiModelProperty(notes="实际工时",allowEmptyValue=true,example="",allowableValues="")
	BigDecimal actWorkload;
	
	@ApiModelProperty(notes="产品归属企业",allowEmptyValue=true,example="",allowableValues="")
	String pbranchId;

	/**
	 *主键
	 **/
	public XmTestCasedb(String id) {
		this.id = id;
	}
    
    /**
     * 测试用例库
     **/
	public XmTestCasedb() {
	}

}