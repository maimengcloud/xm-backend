package com.xm.core.service;

import com.mdp.core.err.BizException;
import com.mdp.core.service.BaseService;
import com.mdp.core.utils.DateUtils;
import com.xm.core.entity.XmTaskOrder;
import org.apache.poi.ss.usermodel.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 父类已经支持增删改查操作,因此,即使本类什么也不写,也已经可以满足一般的增删改查操作了.<br> 
 * 组织 com  顶级模块 xm 大模块 core 小模块 <br>
 * 实体 XmTaskOrder 表 xm_task_order 当前主键(包括多主键): id; 
 ***/
@Service("xm.core.xmTaskOrderService")
public class XmTaskOrderService extends BaseService {
	static Logger logger =LoggerFactory.getLogger(XmTaskOrderService.class);


	@Transactional
	public void orderPaySuccess(String orderId, String payId, String prepayId, String tranId, BigDecimal payAt, String remarks) {
		//更新订单状态

		if(!StringUtils.hasText(payId)){
			throw new BizException("payId-0","参数不正确，payId不能为空");
		}
		XmTaskOrder moOrder = this.selectOneById(orderId);
		if(!payId.equals(moOrder.getPayId())) {
			throw new BizException("payId-err", "参数不正确，payId与实际不匹配");
		}

		if("1".equals(moOrder.getSstatus())) {
			throw new BizException("该订单已经结算");
		}
		if(!"2".equals(moOrder.getStatus())) {
			throw new BizException("该订单状态出错");
		}

//        if(payAt.compareTo(moOrder.getOfinalFee()) != 0) {
//            throw new BizException("该订单支付金额与实际金额不符");
//        }

		//设置第三方付款号
		moOrder.setTranId(tranId);
		moOrder.setPayAt(payAt);
		//设置结算状态为已结算
		moOrder.setSstatus("1");
		//设置状态为已付款
		moOrder.setStatus("3");
		//设置付款确认时间
		moOrder.setPayCtime(new Date());

		//设置结算时间
		moOrder.setSetTime(new Date());


		//开通模块
		//获取订单模块
		MoOrderModule params = new MoOrderModule();
		params.setOrderId(orderId);
		List<MoOrderModule> orderModules = moOrderModuleService.selectListByWhere(params);

		List<MenuModuleBranch> menuModuleBranches = new ArrayList<>();
		for (MoOrderModule orderModule : orderModules) {
			MenuModuleBranch menuModuleBranch = new MenuModuleBranch();
			BeanUtils.copyProperties(orderModule,menuModuleBranch);
			menuModuleBranch.setBranchId(moOrder.getObranchId());
			menuModuleBranch.setModuleId(orderModule.getModuleId());
			menuModuleBranch.setModuleName(orderModule.getName());
			//模块启用
			menuModuleBranch.setStatus("1");
			menuModuleBranch.setMusers(orderModule.getMusers());
			menuModuleBranch.setStartTime(new Date());
			menuModuleBranch.setEndTime(DateUtil.offsetDay(menuModuleBranch.getStartTime(),orderModule.getDays()));
			menuModuleBranch.setCtime(new Date());
			menuModuleBranch.setLtime(new Date());
			menuModuleBranch.setFeeDate(new Date());
			menuModuleBranch.setVer("1");
			menuModuleBranches.add(menuModuleBranch);
		}

		moOrder.setStartTime(new Date());
		moOrder.setEndTime(DateUtil.offsetDay(moOrder.getStartTime(),moOrder.getOdays()));
		if(moOrder.getPayTime()==null){
			moOrder.setPayTime(new Date());
		}
		//保存订单信息
		this.updateSomeFieldByPk(moOrder);


		List<MenuModuleBranch> adds=new ArrayList<>();
		List<MenuModuleBranch> updates=new ArrayList<>();
		List<MenuModuleBranch> menuModuleBranchListDb = menuModuleBranchService.selectListByIds(menuModuleBranches.stream().map(i->map("branchId",i.getBranchId(),"moduleId",i.getModuleId())).collect(Collectors.toList()));
		if(menuModuleBranchListDb==null || menuModuleBranchListDb.size()<=0){
			adds=menuModuleBranches;
		}else{
			if("3".equals(moOrder.getOoper())){
				for (MenuModuleBranch edit : menuModuleBranches) {
					Optional<MenuModuleBranch> moduleBranchDb=menuModuleBranchListDb.stream().filter(i->i.getBranchId().equals(edit.getBranchId()) && i.getModuleId().equals(edit.getModuleId())).findAny();
					if(moduleBranchDb.isPresent()){
						MenuModuleBranch mdb=moduleBranchDb.get();
						mdb.setOusers(mdb.getOusers()+edit.getOusers());
						mdb.setMusers(mdb.getMusers()+edit.getMusers());
						updates.add(mdb);
					}else {
						adds.add(edit);
					}
				}
			}else {
				for (MenuModuleBranch edit : menuModuleBranches) {
					Optional<MenuModuleBranch> moduleBranchDb=menuModuleBranchListDb.stream().filter(i->i.getBranchId().equals(edit.getBranchId()) && i.getModuleId().equals(edit.getModuleId())).findAny();
					if(moduleBranchDb.isPresent()){
						MenuModuleBranch mdb=moduleBranchDb.get();
						if("2".equals(moOrder.getOoper())){
							edit.setEndTime(DateUtil.offsetDay(mdb.getEndTime(),moOrder.getOdays()));
						}
						if(mdb.getStartTime()==null){
							edit.setStartTime(new Date());
						}else {
							edit.setStartTime(mdb.getStartTime());
						}
						if(mdb.getCtime()==null){
							edit.setCtime(new Date());
						}else {
							edit.setCtime(mdb.getCtime());
						}
						edit.setLtime(new Date());
						updates.add(edit);
					}else{
						adds.add(edit);
					}
				}
			}

		}
		if(updates.size()>0){
			menuModuleBranchService.batchUpdate(updates);
		}
		if(adds.size()>0){
			menuModuleBranchService.batchInsert(adds);
		}

		BranchInterests branchInterests= branchInterestsService.selectOneById(moOrder.getObranchId());
		if(branchInterests==null){
			branchInterests=this.branchInterestsService.getDefaultBranchInterests(moOrder.getObranchId());
			branchInterests.setMaxUsers(moOrder.getOusers());
			branchInterests.setMver("1");
			branchInterests.setMaxRtime(DateUtils.format(moOrder.getEndTime(),"yyyy-MM-dd"));
			branchInterestsService.insert(branchInterests);
		}else {
			if("3".equals(moOrder.getOoper())){
				BranchInterests branchInterestsUpdate=new BranchInterests();
				branchInterestsUpdate.setMaxUsers(branchInterests.getMaxUsers()+moOrder.getOusers());
				branchInterestsUpdate.setBranchId(moOrder.getObranchId());
				branchInterestsUpdate.setLtime(new Date());
				branchInterestsService.updateSomeFieldByPk(branchInterestsUpdate);
			}else {
				BranchInterests branchInterestsUpdate=new BranchInterests();
				if(branchInterests.getMaxUsers()< moOrder.getOusers()) {
					branchInterestsUpdate.setMaxUsers(moOrder.getOusers());
				}
				branchInterestsUpdate.setBranchId(moOrder.getObranchId());
				branchInterestsUpdate.setMver("1");
				branchInterestsUpdate.setLtime(new Date());
				branchInterests.setMaxRtime(DateUtils.format(moOrder.getEndTime(),"yyyy-MM-dd"));
				branchInterestsService.updateSomeFieldByPk(branchInterestsUpdate);
			}

		}
	}

}

