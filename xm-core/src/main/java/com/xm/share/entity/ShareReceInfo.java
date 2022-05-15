package  com.xm.share.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 组织 com  顶级模块 xm 大模块 share  小模块 <br> 
 * 实体 ShareReceInfo所有属性名: <br>
 *	id,shareKey,receiverId,receiverName,receTime;<br>
 * 表 XM.xm_share_rece_info 分享后接收人行为记录表的所有字段名: <br>
 *	id,share_key,receiver_id,receiver_name,rece_time;<br>
 * 当前主键(包括多主键):<br>
 *	id;<br>
 */
@ApiModel(description="分享后接收人行为记录表")
public class ShareReceInfo  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes="主键,主键",allowEmptyValue=true,example="",allowableValues="")
	String id;
  	
	
	@ApiModelProperty(notes="分享编号，分享链接之间前端传递",allowEmptyValue=true,example="",allowableValues="")
	String shareKey;
	
	@ApiModelProperty(notes="接收人编号",allowEmptyValue=true,example="",allowableValues="")
	String receiverId;
	
	@ApiModelProperty(notes="接收入姓名",allowEmptyValue=true,example="",allowableValues="")
	String receiverName;
	
	@ApiModelProperty(notes="接收时间",allowEmptyValue=true,example="",allowableValues="")
	Date receTime;

	/**主键**/
	public ShareReceInfo(String id) {
		this.id = id;
	}
    
    /**分享后接收人行为记录表**/
	public ShareReceInfo() {
	}
	
	/**
	 * 主键
	 **/
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 分享编号，分享链接之间前端传递
	 **/
	public void setShareKey(String shareKey) {
		this.shareKey = shareKey;
	}
	/**
	 * 接收人编号
	 **/
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	/**
	 * 接收入姓名
	 **/
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	/**
	 * 接收时间
	 **/
	public void setReceTime(Date receTime) {
		this.receTime = receTime;
	}
	
	/**
	 * 主键
	 **/
	public String getId() {
		return this.id;
	}
	/**
	 * 分享编号，分享链接之间前端传递
	 **/
	public String getShareKey() {
		return this.shareKey;
	}
	/**
	 * 接收人编号
	 **/
	public String getReceiverId() {
		return this.receiverId;
	}
	/**
	 * 接收入姓名
	 **/
	public String getReceiverName() {
		return this.receiverName;
	}
	/**
	 * 接收时间
	 **/
	public Date getReceTime() {
		return this.receTime;
	}

}