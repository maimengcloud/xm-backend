package  com.xm.share.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 share  小模块 <br> 
 * 实体 ShareBizInfo所有属性名: <br>
 *	shareKey,shareUserid,shareUsername,pageUrl,pageType,shareTime,bizPkId,bizBranchId,shareBranchId,bizSubPkId,params,shareType,pshareKey,pshareUserid,pshareUsername,bizType,bizCategoryId;<br>
 * 表 XM.xm_share_biz_info 分享行为记录表的所有字段名: <br>
 *	share_key,share_userid,share_username,page_url,page_type,share_time,biz_pk_id,biz_branch_id,share_branch_id,biz_sub_pk_id,params,share_type,pshare_key,pshare_userid,pshare_username,biz_type,biz_category_id;<br>
 * 当前主键(包括多主键):<br>
 *	share_key;<br>
 */
@ApiModel(description="分享行为记录表")
public class ShareBizInfo  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="分享编号，一次分享行为一个shareKey,分享链接之间前端传递；,主键",allowEmptyValue=true,example="",allowableValues="")
	String shareKey;
  	
	
	@ApiModelProperty(notes="分享人编号",allowEmptyValue=true,example="",allowableValues="")
	String shareUserid;
	
	@ApiModelProperty(notes="分享人姓名",allowEmptyValue=true,example="",allowableValues="")
	String shareUsername;
	
	@ApiModelProperty(notes="分享地址",allowEmptyValue=true,example="",allowableValues="")
	String pageUrl;
	
	@ApiModelProperty(notes="分享地址类型0-h5,1-微信小程序,2-微信公众号,3-app页面",allowEmptyValue=true,example="",allowableValues="")
	String pageType;
	
	@ApiModelProperty(notes="分享时间",allowEmptyValue=true,example="",allowableValues="")
	Date shareTime;
	
	@ApiModelProperty(notes="分享的业务对应的主键",allowEmptyValue=true,example="",allowableValues="")
	String bizPkId;
	
	@ApiModelProperty(notes="分享的业务所属机构号",allowEmptyValue=true,example="",allowableValues="")
	String bizBranchId;
	
	@ApiModelProperty(notes="分享人所属机构号",allowEmptyValue=true,example="",allowableValues="")
	String shareBranchId;
	
	@ApiModelProperty(notes="分享的业务对应的子主键（复合主键下使用）",allowEmptyValue=true,example="",allowableValues="")
	String bizSubPkId;
	
	@ApiModelProperty(notes="分享参数，需要特殊扩展时使用",allowEmptyValue=true,example="",allowableValues="")
	String params;
	
	@ApiModelProperty(notes="分享业务类型",allowEmptyValue=true,example="",allowableValues="")
	String shareType;
	
	@ApiModelProperty(notes="上级分享码，冗余字段，方便计算",allowEmptyValue=true,example="",allowableValues="")
	String pshareKey;
	
	@ApiModelProperty(notes="上级分享人编号，冗余字段，方便计算",allowEmptyValue=true,example="",allowableValues="")
	String pshareUserid;
	
	@ApiModelProperty(notes="上级分享人姓名，冗余字段，方便计算",allowEmptyValue=true,example="",allowableValues="")
	String pshareUsername;
	
	@ApiModelProperty(notes="业务分类0商品1项目2任务3故事4app",allowEmptyValue=true,example="",allowableValues="")
	String bizType;
	
	@ApiModelProperty(notes="业务分类的主键，用于与分佣方案比对，分佣方案是可以针对一类商品进行分佣，可以对于具体的商品进行分佣",allowEmptyValue=true,example="",allowableValues="")
	String bizCategoryId;

	/**分享编号，一次分享行为一个shareKey,分享链接之间前端传递；**/
	public ShareBizInfo(String shareKey) {
		this.shareKey = shareKey;
	}
    
    /**分享行为记录表**/
	public ShareBizInfo() {
	}
	
	/**
	 * 分享编号，一次分享行为一个shareKey,分享链接之间前端传递；
	 **/
	public void setShareKey(String shareKey) {
		this.shareKey = shareKey;
	}
	/**
	 * 分享人编号
	 **/
	public void setShareUserid(String shareUserid) {
		this.shareUserid = shareUserid;
	}
	/**
	 * 分享人姓名
	 **/
	public void setShareUsername(String shareUsername) {
		this.shareUsername = shareUsername;
	}
	/**
	 * 分享地址
	 **/
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	/**
	 * 分享地址类型0-h5,1-微信小程序,2-微信公众号,3-app页面
	 **/
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	/**
	 * 分享时间
	 **/
	public void setShareTime(Date shareTime) {
		this.shareTime = shareTime;
	}
	/**
	 * 分享的业务对应的主键
	 **/
	public void setBizPkId(String bizPkId) {
		this.bizPkId = bizPkId;
	}
	/**
	 * 分享的业务所属机构号
	 **/
	public void setBizBranchId(String bizBranchId) {
		this.bizBranchId = bizBranchId;
	}
	/**
	 * 分享人所属机构号
	 **/
	public void setShareBranchId(String shareBranchId) {
		this.shareBranchId = shareBranchId;
	}
	/**
	 * 分享的业务对应的子主键（复合主键下使用）
	 **/
	public void setBizSubPkId(String bizSubPkId) {
		this.bizSubPkId = bizSubPkId;
	}
	/**
	 * 分享参数，需要特殊扩展时使用
	 **/
	public void setParams(String params) {
		this.params = params;
	}
	/**
	 * 分享业务类型
	 **/
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}
	/**
	 * 上级分享码，冗余字段，方便计算
	 **/
	public void setPshareKey(String pshareKey) {
		this.pshareKey = pshareKey;
	}
	/**
	 * 上级分享人编号，冗余字段，方便计算
	 **/
	public void setPshareUserid(String pshareUserid) {
		this.pshareUserid = pshareUserid;
	}
	/**
	 * 上级分享人姓名，冗余字段，方便计算
	 **/
	public void setPshareUsername(String pshareUsername) {
		this.pshareUsername = pshareUsername;
	}
	/**
	 * 业务分类0商品1项目2任务3故事4app
	 **/
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	/**
	 * 业务分类的主键，用于与分佣方案比对，分佣方案是可以针对一类商品进行分佣，可以对于具体的商品进行分佣
	 **/
	public void setBizCategoryId(String bizCategoryId) {
		this.bizCategoryId = bizCategoryId;
	}
	
	/**
	 * 分享编号，一次分享行为一个shareKey,分享链接之间前端传递；
	 **/
	public String getShareKey() {
		return this.shareKey;
	}
	/**
	 * 分享人编号
	 **/
	public String getShareUserid() {
		return this.shareUserid;
	}
	/**
	 * 分享人姓名
	 **/
	public String getShareUsername() {
		return this.shareUsername;
	}
	/**
	 * 分享地址
	 **/
	public String getPageUrl() {
		return this.pageUrl;
	}
	/**
	 * 分享地址类型0-h5,1-微信小程序,2-微信公众号,3-app页面
	 **/
	public String getPageType() {
		return this.pageType;
	}
	/**
	 * 分享时间
	 **/
	public Date getShareTime() {
		return this.shareTime;
	}
	/**
	 * 分享的业务对应的主键
	 **/
	public String getBizPkId() {
		return this.bizPkId;
	}
	/**
	 * 分享的业务所属机构号
	 **/
	public String getBizBranchId() {
		return this.bizBranchId;
	}
	/**
	 * 分享人所属机构号
	 **/
	public String getShareBranchId() {
		return this.shareBranchId;
	}
	/**
	 * 分享的业务对应的子主键（复合主键下使用）
	 **/
	public String getBizSubPkId() {
		return this.bizSubPkId;
	}
	/**
	 * 分享参数，需要特殊扩展时使用
	 **/
	public String getParams() {
		return this.params;
	}
	/**
	 * 分享业务类型
	 **/
	public String getShareType() {
		return this.shareType;
	}
	/**
	 * 上级分享码，冗余字段，方便计算
	 **/
	public String getPshareKey() {
		return this.pshareKey;
	}
	/**
	 * 上级分享人编号，冗余字段，方便计算
	 **/
	public String getPshareUserid() {
		return this.pshareUserid;
	}
	/**
	 * 上级分享人姓名，冗余字段，方便计算
	 **/
	public String getPshareUsername() {
		return this.pshareUsername;
	}
	/**
	 * 业务分类0商品1项目2任务3故事4app
	 **/
	public String getBizType() {
		return this.bizType;
	}
	/**
	 * 业务分类的主键，用于与分佣方案比对，分佣方案是可以针对一类商品进行分佣，可以对于具体的商品进行分佣
	 **/
	public String getBizCategoryId() {
		return this.bizCategoryId;
	}

}