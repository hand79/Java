package com.max.xml.service;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.net.URI;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.max.xml.core.bean.BaseRequest;
import com.max.xml.core.bean.BaseResponse;

@Service
public class XmlClientService {
	
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final String URI_BASE = "http://localhost:9090/max-xml-rpc/";
	
	// for obj's request
	public BaseResponse call(BaseRequest req, String requestBy, String requestID) throws Exception {
		log.info("()...");
    	this.setBaseFields(req, requestBy, requestID);
    	log.debug(req.toString());
		String reqXml = this.getRequestXml( req );
//		log.debug("reqXml: " + reqXml);
		return this.call(req.getMethodName(), reqXml, requestBy);
	}
	
	// for xml
	public BaseResponse call(String methodName, String reqXml, String requestBy) throws Exception {
		log.debug("()...");
		String resXml = this.call(reqXml, requestBy);
    	BaseResponse resObj = (BaseResponse) this.newResponseObject( methodName );
		log.debug(resObj.toString());
    	resObj = this.unmarshalResponseObject(resXml, resObj);
		log.debug(resObj.toString());
		return resObj;
	}
	
	public String call(String reqXml, String requestBy) throws Exception {
		log.debug("()..." + reqXml);
		HttpPost post = new HttpPost();
		this.setHeaders(post, requestBy);
		post.setURI( new URI(this.URI_BASE) );
		post.setEntity( new StringEntity( reqXml ) );
		log.info("post entity: " + post.getEntity().toString());
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse res = client.execute( post );
		log.info("res: " + res);
		
		String resXml = EntityUtils.toString(res.getEntity());
		log.debug("resXml: " + resXml);
		return resXml;
	}
	
	private void setBaseFields(BaseRequest req, String requestBy, String requestID) {
		req.setMethodName(req.getClass().getSimpleName().replaceFirst("Request", ""));
		req.setRequestBy( requestBy );
		req.setRequestID( requestID );
		req.setRequestDateTime( new Date());
	}
	
	private String getRequestXml(Object obj) {
		StringWriter writer = null;
		try {
			writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller mar = context.createMarshaller();
	    	mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//	    	mar.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
			mar.marshal(obj, writer);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	    return writer.toString();
	}
	
	private void setHeaders(HttpRequestBase req, String requestBy) {	
		req.addHeader("Content-Type", "text/xml"); // "text/xml;charset=utf-8");
//		req.addHeader("Authorization", "Basic " + this.getAuth(requestBy));
	}
	
//	private String getAuth(String name) {
//    	log.debug("()..." + name);
//    	String auth = Base64.encodeBase64String( (name + ":changeit").getBytes() );
//    	log.debug("auth: " + auth);
//    	return auth;
//	}

	private Object newResponseObject(String methodName) {
		try {
			String clazzName = "com.max.xml.core.bean." + methodName + "Response";
			return Class.forName(clazzName).newInstance();
		} catch (Exception e) {
			log.error("catch: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	private BaseResponse unmarshalResponseObject(String xml, BaseResponse obj) {
		log.debug("()..." + obj.toString());
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Unmarshaller unmar = context.createUnmarshaller();
			obj = (BaseResponse) unmar.unmarshal(new ByteArrayInputStream(xml.getBytes()));
			log.debug(obj.toString());
			return obj;
		}
		catch (Throwable e) {
			log.error("catch: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
