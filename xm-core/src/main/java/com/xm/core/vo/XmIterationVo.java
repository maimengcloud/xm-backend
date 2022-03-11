package com.xm.core.vo;

import com.xm.core.entity.XmIteration;
import com.xm.core.entity.XmIterationLink;

import java.util.List;

public class XmIterationVo extends XmIteration {



	List<XmIterationLink> links;

	public List<XmIterationLink> getLinks() {
		return links;
	}

	public void setLinks(List<XmIterationLink> links) {
		this.links = links;
	}
}
