package com.max.xml.service;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.max.xml.core.bean.BaseRequest;
import com.max.xml.core.bean.BaseResponse;
import com.max.xml.core.bean.GetUserDetailRequest;
import com.max.xml.core.bean.GetUserDetailResponse;
import com.max.xml.core.bean.MethodCall;
import com.max.xml.core.bean.MethodResponse;

@Service
public class DispatchService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public BaseResponse run(MethodCall call, String xml) {
		StopWatch sw = new StopWatch();
		sw.start();
    	BaseResponse res = null;
		try {
			// initial BaseRequest
			BaseRequest req = (BaseRequest) this.newRequestObject(call.getMethodName());
			req = this.unmarshalRequestObject(xml, req);
			// invoke
			res = (BaseResponse) this.invokeRequestMethod(call.getMethodName(), req);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("catch: " + e.getMessage());
			res = new MethodResponse();
			res.setResponseCode(new Integer("999"));
			res.setResponseMessage(e.getMessage());
		}
		sw.stop();
		log.info("response time:" + sw.getTotalTimeMillis());
		return res; 
	}
	
	private Object invokeRequestMethod(String methodName, BaseRequest obj)  {
		try {
			Method m = this.getClass().getMethod("do" + methodName, new java.lang.Class[]{ obj.getClass() });
			return m.invoke(this, obj);
		} catch (Exception ex) {
			Throwable e = ex.getCause() == null ? ex : ex.getCause(); // watch here
				throw new RuntimeException(e);
		}
	}
	
	private Object newRequestObject(String methodName) {
		try {
			String clazzName = "com.max.xml.core.bean." + methodName + "Request";
			return Class.forName(clazzName).newInstance();
		} catch (Exception e) {
			log.error("catch: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	private BaseRequest unmarshalRequestObject(String xml, BaseRequest obj) {
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Unmarshaller unmar = context.createUnmarshaller();
			obj = (BaseRequest) unmar.unmarshal(new ByteArrayInputStream(xml.getBytes()));
			log.debug(obj.toString());
		} catch (JAXBException e) {
			log.error("catch: " + e.getMessage());
			throw new RuntimeException(e);
		}
		return obj;
	}
	
	// do xx Request
	public GetUserDetailResponse doGetUserDetail(GetUserDetailRequest req) throws Exception {
		GetUserDetailResponse res = new GetUserDetailResponse();
		res.setResponseDateTime(new Date());
		res.setResponseMessage("test res");
		res.setResponseCode(new Integer(999));
		return res;
	}
	
	// example
	//TODO
//	public UpdateUserDetailResponse doUpdateUserDetail(Object req) throws Exception {
//	   return  UserDetailService.doUpdateUserDetail(req);
//	}
}
