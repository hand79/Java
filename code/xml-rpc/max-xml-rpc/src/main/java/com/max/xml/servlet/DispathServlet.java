package com.max.xml.servlet;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.max.xml.core.bean.BaseResponse;
import com.max.xml.core.bean.MethodCall;
import com.max.xml.core.bean.MethodResponse;
import com.max.xml.exception.Errors;
import com.max.xml.service.DispatchService;

@Controller
public class DispathServlet {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DispatchService dispatchService;
	
	@RequestMapping(value="/" , method = RequestMethod.POST)
	public ResponseEntity<String> doPost(@RequestBody String reqXml, HttpServletRequest req) {
		log.info("<!-- START " + req.getRemoteHost() + StringUtils.trimAllWhitespace(reqXml));
		StopWatch sw = new StopWatch();
		log.info("()... "+ reqXml);
		sw.start();
		BaseResponse res = null;
		MethodCall call = null;
		try {
			// initial MethodCall
			call = this.unmarshalMethodCall(reqXml);
			// run
			res = this.dispatchService.run(call, reqXml);
		} catch (Exception e) {
			log.error("catch: " + e.getMessage());
			res = new MethodResponse();
			res.setResponseCode(Errors.ERR_9999.getCode());
			res.setResponseMessage(e.getMessage());
		}
    	
		String resXml = this.marshal( res );
		// headers
    	HttpHeaders headers = new HttpHeaders();
    	headers.put("Content-Type", Arrays.asList("text/plain;charset=UTF-8")); //headers ContentType
    	// httpStatus
    	HttpStatus httpStatus = HttpStatus.OK;
		
		return new ResponseEntity<String>(resXml, headers, httpStatus);
	}
	
	
	private MethodCall unmarshalMethodCall(String xml) {
    	MethodCall call = null;
		try {
			JAXBContext context = JAXBContext.newInstance(MethodCall.class);
			Unmarshaller unmar = context.createUnmarshaller();
//			unmar.setAdapter(new DateTimeAdapter());
			call = (MethodCall) unmar.unmarshal(new ByteArrayInputStream(xml.getBytes()));
		} catch (JAXBException e) {
			log.error("catch: " + e.getMessage());
			throw new RuntimeException(e);
		}
    	return call;
	}
	
	
	private String marshal(Object obj) {
		StringWriter writer = null;
		try {
			writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller m = context.createMarshaller();
			// for DEBUG level only
			if(log.isDebugEnabled()) {
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			}
			m.marshal(obj, writer);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	    return writer.toString();
	}
}
