package com.max.xml.core.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.max.xml.core.adapter.DateTimeFormatAdapter;

@XmlRootElement(name="methodCall")
@XmlAccessorType(XmlAccessType.FIELD)
public class MethodCall extends BaseBean {

	@XmlElement
	private String methodName;
	
	@XmlElement
	private String requestBy;
	
	@XmlElement
	private String requestID;

	@XmlJavaTypeAdapter(value = DateTimeFormatAdapter.class, type = Date.class)
	@XmlElement
	private Date requestTime;

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

}
