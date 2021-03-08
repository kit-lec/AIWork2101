package com.lec.beans;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "WriteList")  // <WriteList> ~ </WriteList>
public class AjaxWriteListXML {
	
	@JacksonXmlProperty  // <count> ~ </count>
	int count;    // 
	
	@JacksonXmlProperty  // <status> ~ </status>
	String status;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
