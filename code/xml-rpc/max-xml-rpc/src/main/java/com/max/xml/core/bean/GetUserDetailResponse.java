package com.max.xml.core.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.max.xml.core.struct.UserInformation;

@XmlRootElement(name = "methodResponse")
public class GetUserDetailResponse extends BaseResponse {

	@XmlElement
	private UserInformation userInformation;

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

}
