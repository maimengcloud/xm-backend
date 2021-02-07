package com.xm.core.vo;

import com.xm.core.entity.XmExchange;

import java.util.List;

public class XmExchangeVo extends XmExchange {
    XmExchange quote;
    List<XmExchange> reply;
    
    public XmExchange getQuote() {
        return quote;
    }
    
    public void setQuote(XmExchange quote) {
        this.quote = quote;
    }
    
    public List<XmExchange> getReply() {
        return reply;
    }
    
    public void setReply(List<XmExchange> reply) {
        this.reply = reply;
    }
}
