package com.max.xml;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.max.xml.core.bean.BaseRequest;

public class XmlServiceTest {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	private static final String URI_BASE = "http://localhost:9090/max-xml-rpc/";

	protected HttpEntity call(BaseRequest req) throws Exception {
		log.debug("()..." + System.getProperty("LOCATION"));
		// source request
		String requestBy = "TEST"; 
		this.setBaseFields(req, requestBy);
		log.debug(req.toString());
		String xml = this.getRequestXml(req);
		log.debug("xml: " + xml);

		HttpPost post = new HttpPost();
		// add custom headear
//		this.setHeaders(post, authBy);
		post.setURI(new URI(this.URI_BASE));
		post.setEntity(new StringEntity(xml));
		log.debug("req: " + req);

		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse res = client.execute(post);
		log.debug("res: " + res);
		log.debug("entity: " + EntityUtils.toString(res.getEntity()));
		return res.getEntity();
	}

	private void callByHttps() throws Exception {
		URL url = new URL(this.URI_BASE);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input;
		StringBuffer sb = new StringBuffer();
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}
		br.close();
	}

	private void setBaseFields(BaseRequest req, String requestBy) {
		req.setMethodName(req.getClass().getSimpleName().replaceFirst("Request", ""));
		req.setRequestBy(requestBy);
		req.setRequestID(String.valueOf(System.currentTimeMillis()));
		req.setRequestDateTime(new Date());
	}

	private String getRequestXml(Object obj) {
		StringWriter writer = null;
		try {
			writer = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// mar.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
			mar.marshal(obj, writer);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return writer.toString();
	}

	private void setHeaders(HttpRequestBase req, String requestBy) throws Exception {
		req.addHeader("Content-Type", "text/xml"); // "text/xml;charset=utf-8");
//		req.addHeader("Authorization", "Basic " + this.getAuth(requestBy));
	}

	private String getAuth(String name) {
		log.debug("()..." + name);
		String auth = Base64.encodeBase64String((name + ":pwd").getBytes());
		log.debug("auth: " + auth);
		return auth;
	}

}
