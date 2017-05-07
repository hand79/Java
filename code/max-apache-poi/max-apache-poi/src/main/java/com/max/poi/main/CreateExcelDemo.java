package com.max.poi.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.max.poi.MailProperties;
import com.max.poi.bean.ReportBean;
import com.max.poi.smtp.SmtpClient;

public class CreateExcelDemo {
	private static Logger LOG = LogManager.getLogger(CreateExcelDemo.class);

	private final static String FILE_PATH = "./";
	private final static String APPLICATION_CONTEXT = "META-INF/spring/applicationContext.xml";

	public static void main(String[] args) {
		LOG.info("CreateExcel Start --->");

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT);
		MailProperties mailProperties = ctx.getBean(MailProperties.class);
		
		// read excel
		// surpport Excel 2003、2007、2010, demo as follows:
		/*	 
			XSSFWorkbook workbook = null;
			File file = new File(filePath);
			try (FileInputStream fis = new FileInputStream(file)) {
				workbook = (XSSFWorkbook) WorkbookFactory.create(fis);
				......
			} catch (Exception e) {
				LOG.error("catch: " + e.getMessage());
			}
		*/
		
		
		// create excel
		XSSFWorkbook workbook = new XSSFWorkbook();

		// create sheet
		XSSFSheet sheet = workbook.createSheet("工作列表");

		// create header
		Integer rowDataIndex = createExcelHeader(sheet, new String[] { "日期", "星期", "工作項目" }, 0);

		// init template data
		List<ReportBean> list = new ArrayList<ReportBean>();
		Date now = new Date();
		Date yesterday = DateUtils.addDays(now, -1);
		Date tomorrow = DateUtils.addDays(now, 1);
		list.add(new ReportBean(yesterday, getWeek(yesterday), "coding"));
		list.add(new ReportBean(now, getWeek(now), "test"));
		list.add(new ReportBean(tomorrow, getWeek(tomorrow), "code review"));

		// write data
		setExcelDataCell(sheet, list, rowDataIndex);

		// if have Formula Cell need to do
		XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
		
		// AutoSizeColumns
		doAutoSizeColumns(sheet, sheet.getRow(0).getPhysicalNumberOfCells());
		
		// ouput file
		String filename = "Test-Excel-" + new SimpleDateFormat("yyyyMMddHHmmss").format(now)+".xlsx";
		String absolutePath = buildExcelDocumentFile(workbook, filename);

		// send mail
		try {
			SmtpClient smtpClient = new SmtpClient();
			smtpClient.sendMail(absolutePath, filename, mailProperties);
		} catch (Exception e) {
			LOG.error("catch: " + e.getMessage());
		}

		ctx.close();
		LOG.info("---> END");
	}

	private static String getWeek(Date date) {
		Calendar cal = Calendar.getInstance(Locale.TAIWAN);
		cal.setTime(date);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String day = new String();
		DateFormatSymbols dfs = DateFormatSymbols.getInstance(Locale.TAIWAN);
		String[] days = dfs.getWeekdays();
		if (dayOfWeek >= 0 && dayOfWeek <= 7) {
			day = days[dayOfWeek];
		}
		return day;
	}

	private static Integer createExcelHeader(XSSFSheet sheet, String[] headers, Integer rowIndex) {
		XSSFRow row = sheet.createRow(rowIndex);
		int count = 0;
		for (String header : headers) {
			row.createCell(count).setCellValue(header);
			count++;
		}
		return rowIndex + 1;
	}

	private static void doAutoSizeColumns(XSSFSheet sheet, int columns) {
		for (int i = 0; i < columns; i++) {
			sheet.autoSizeColumn(i);
		}
	}

	private static Integer setExcelDataCell(XSSFSheet sheet, List<ReportBean> list, Integer rowIndex) {
		for (ReportBean reportBean : list) {
			XSSFRow row = sheet.createRow(rowIndex);
			row.createCell(0).setCellValue(new SimpleDateFormat("yyyy/MM/dd").format(reportBean.getDate()));
			row.createCell(1).setCellValue(reportBean.getWeek());
			row.createCell(2).setCellValue(reportBean.getWorkProjects());
			rowIndex++;
		}
		return rowIndex;
	}

	private static String buildExcelDocumentFile(XSSFWorkbook wb, String fileName) {

		File file = new File(FILE_PATH + fileName);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try (FileOutputStream fos = new FileOutputStream(file)) {
			if (!file.exists()) {
				file.createNewFile();
			}
			wb.write(fos);
		} catch (FileNotFoundException e) {
			LOG.error("catch: " + e.getMessage());
		} catch (IOException e) {
			LOG.error("catch: " + e.getMessage());
		}
		return file.getAbsolutePath();
	}

}
