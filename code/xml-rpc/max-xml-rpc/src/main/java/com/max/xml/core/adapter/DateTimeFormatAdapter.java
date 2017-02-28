package com.max.xml.core.adapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateTimeFormatAdapter extends XmlAdapter<String, Date> {

	private static final String STANDARM_DATE_FORMAT = "yyyyMMddHHmmss";
	private final DateFormat sdf = new SimpleDateFormat(STANDARM_DATE_FORMAT);

	@Override
	public Date unmarshal(String v) throws Exception {
		if (v == null) {
			return null;
		}
		return sdf.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return sdf.format(v);
	}

}
