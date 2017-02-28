package com.max.xml.core.struct;

import java.util.List;

public class UserDetail extends BaseStruct {

	private List<UserInformation> userInformationList;

	public List<UserInformation> getUserInformationList() {
		return userInformationList;
	}

	public void setUserInformationList(List<UserInformation> userInformationList) {
		this.userInformationList = userInformationList;
	}

}
