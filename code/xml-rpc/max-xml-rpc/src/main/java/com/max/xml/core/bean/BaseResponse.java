package com.max.xml.core.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.max.xml.core.adapter.DateTimeFormatAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class BaseResponse extends BaseBean {
	
	@XmlJavaTypeAdapter(value = DateTimeFormatAdapter.class, type = Date.class)
	@XmlElement(required = true)
	private Date responseDateTime;

	@XmlElement
	private Integer responseCode;

	@XmlElement
	private String responseMessage;

	public Date getResponseDateTime() {
		return responseDateTime;
	}

	public void setResponseDateTime(Date responseDateTime) {
		this.responseDateTime = responseDateTime;
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
