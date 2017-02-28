package com.max.xml.core.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanAdapter extends XmlAdapter<String, Boolean> {

	@Override
	public Boolean unmarshal(String v) throws Exception {
		return v.equals("1") ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public String marshal(Boolean v) throws Exception {
		return v == null || v == Boolean.FALSE ? "0" : "1";
	}

}
