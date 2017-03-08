package com.max.xml;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.max.xml.core.bean.GetProductsResponse;
import com.max.xml.core.bean.GetUserDetailRequest;
import com.max.xml.core.bean.MethodCall;
import com.max.xml.core.bean.Product;
import com.max.xml.service.XmlClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaxXmlRpcApplicationTests extends XmlServiceTest {

private SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
	
	@Autowired
	XmlClientService xmlClientService;
	
	@Test
	public void contextLoads() throws Exception {
//		this.call(getGetUserDetailRequest());
	}
	
	@Test
	public void testLog4j2() throws Exception {
//		this.call(getGetUserDetailRequest());
		log.info(" info ===send====");
		log.debug(" debug ===send====");
		log.error(" error ===send====");
		log.warn(" warn ===send====");
		log.trace(" trace ===send====");
	}
	
	@Test
	public void testSendXml() throws Exception {
		this.call(getGetUserDetailRequest());
	}
	
	@Test
	public void testGetProductsResponse() throws Exception {
		List<Product> list = new ArrayList<>();
		list.add(getProduct("Pikachu", "25", "13.2kg"));
		list.add(getProduct("Raichuu", "26", "66.1kg"));
		list.add(getProduct("Pichu", "172", "4.4kg"));
		
		GetProductsResponse res = new GetProductsResponse();
		res.setResponseDateTime(new Date());
		res.setResponseMessage("ok");
		res.setResponseCode(new Integer(0));
		res.setProductList(list);
		System.out.println(this.marshal(res));
	}
	
	private Product getProduct(String name, String productID, String description){
		Product p = new Product();
		p.setProductName(name);
		p.setProductID(productID);
		p.setDescription(description);;
		return p;
	}
	
	public GetUserDetailRequest getGetUserDetailRequest(){
		GetUserDetailRequest req = new GetUserDetailRequest();
		req.setRequestDateTime(new Date());
		req.setUsername("Max");
		return req;
	}
	
	private MethodCall unmarshalMethodCall(String xml) {
    	MethodCall call = null;
		try {
			JAXBContext context = JAXBContext.newInstance(MethodCall.class);
			Unmarshaller unmar = context.createUnmarshaller();
//			unmar.setAdapter(new DateTimeAdapter());
			call = (MethodCall) unmar.unmarshal(new ByteArrayInputStream(xml.getBytes()));
		} catch (JAXBException e) {
//			log.error("catch: " + e.getMessage());
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
//			if(log.isDebugEnabled()) {
//				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//			}
			m.marshal(obj, writer);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	    return writer.toString();
	}

}
