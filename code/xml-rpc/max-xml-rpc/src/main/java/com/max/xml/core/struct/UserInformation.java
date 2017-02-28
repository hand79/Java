package com.max.xml.core.struct;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.max.xml.core.adapter.DateTimeFormatAdapter;

@XmlRootElement
public class UserInformation extends BaseStruct {

	@XmlElement
	private String username;

	@XmlElement
	private Integer age;

	@XmlJavaTypeAdapter(value = DateTimeFormatAdapter.class, type = Date.class)
	@XmlElement
	private Date createTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
