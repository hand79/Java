package com.max.poi.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.media.sound.InvalidFormatException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/applicationContext.xml" })
public class TestMethod {
	
	@BeforeClass
	public static void setupProperties() {
		System.setProperty("LOCATION", "LOCAL");
		System.setProperty("PROFILE", "LOCAL");
	}

	public void testExcel() throws IOException, InvalidFormatException{
		String filePath = "D:/max-apache-poi/";
		String fileName = "" + ".xlsx";
		String pathName = filePath +fileName;
		File file = new File(pathName);
		FileInputStream fis = new FileInputStream(file); 
//		OPCPackage pkg = OPCPackage.open(fis);
//		XSSFWorkbook wb = new XSSFWorkbook(pkg);
//		XSSFSheet sheet0 = wb.getSheetAt(0);
//		XSSFRow row2 = sheet0.getRow(2); // orders
	}
	
	
}
