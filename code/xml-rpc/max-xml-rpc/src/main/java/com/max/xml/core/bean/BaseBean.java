package com.max.xml.core.bean;

import java.beans.PropertyDescriptor;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

public class BaseBean {
	protected transient final Logger log = LoggerFactory.getLogger(this.getClass());
	private transient final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("#").append(this.getClass().getSimpleName()).append(" ");
		PropertyDescriptor[] pds = BeanUtils.getPropertyDescriptors(this.getClass());
		for (int i = 0; i < pds.length; i++) {
			PropertyDescriptor pd = pds[i];
			if (pd.getReadMethod() != null) {
				try {
					Object srcValue = pd.getReadMethod().invoke(this, null);
					if (srcValue == null || pd.getName().equals("class")) {
						continue;
					}
					if (pd.getPropertyType() == Date.class) {
						builder.append(pd.getName()).append(":").append(sdf.format(srcValue)).append(", ");
					} else {
						builder.append(pd.getName()).append(":").append(srcValue.toString()).append(", ");
					}
				} catch (Exception e) {
					log.warn(pd.getName() + " catch:" + e.getMessage());
					continue;
				}
			}
		}
		return builder.toString();
	}
}
