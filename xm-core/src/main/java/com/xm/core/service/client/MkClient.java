package com.xm.core.service.client;

import com.mdp.core.entity.Tips;
import com.mdp.core.utils.BaseUtils;
import com.mdp.micro.client.CallBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
/**
 * 对mk接口调用
 */
public class MkClient {

    @Autowired
    CallBizService callBizService;

    /**
     * 		execOrder.setOrderId(sequence.getReqFlowNo());
     * 		execOrder.setActNum(new BigDecimal("1"));
     * 		execOrder.setEntityId(entityId);
     * 		execOrder.setCustId(receiverId);
     * 		execOrder.setActSinglePrice(new BigDecimal("10.22"));
     * 		execOrder.setTotalPrice(new BigDecimal("10.22"));
     * 		execOrder.setCustBranchId("platform-branch-001");
     * @return
     */
    public Tips pushActiExecOrder(String orderId,String custId,String custBranchId, String entityId,BigDecimal actNum,BigDecimal actSinglePrice,BigDecimal totalPrice){
        Tips tips = new Tips("推送订单成功");
        String restUrl="/mk/mk/acti/execOrder/add";
        Map<String,Object> params=new HashMap<>();
        params.put("orderId",orderId);
        params.put("custId",custId);
        params.put("entityId",entityId);
        params.put("actNum",actNum);
        params.put("actSinglePrice",orderId);
        params.put("totalPrice",totalPrice);
        Map<String,Object> resultMap=callBizService.postForMap(restUrl,params);
        tips= BaseUtils.mapToTips(resultMap);
        return tips;
    }
}
