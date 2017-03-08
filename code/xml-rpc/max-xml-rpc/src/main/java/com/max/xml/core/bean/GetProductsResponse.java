package com.max.xml.core.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "methodResponse")
public class GetProductsResponse extends BaseResponse {
	
	// demo how to generate list xml (in src/test/java/MaxXmlApplicationTests testGetProductsResponse)
	
	@XmlElementWrapper
	@XmlElement(name = "Product")
	private List<Product> productList = new ArrayList<Product>();

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
