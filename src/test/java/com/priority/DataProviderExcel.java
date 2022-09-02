package com.priority;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExcel {

	public String getDataFromExcel(int rownum, int cellnum) throws IOException {
		String res = " ";
		File file = new File("C:\\Users\\91866\\eclipse-workspace\\TestingNg\\Excel\\Balaji1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Adactin");
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);

			} else {
				double d = cell.getNumericCellValue();
				// BigDecimal decimal = BigDecimal.valueOf(d);
				long check = Math.round(d);
				if (check == d) {
					res = String.valueOf(d);
				} else {
					res = String.valueOf(d);
				}

				break;
			}
		default:
			break;
		}
		return res;
	}

	@DataProvider
	public Object[][] excelIntegration() throws IOException {
		return new Object[][] {
				{ getDataFromExcel(1, 0), getDataFromExcel(1, 1), getDataFromExcel(1, 2), getDataFromExcel(1, 3),
						getDataFromExcel(1, 4), getDataFromExcel(1, 5), getDataFromExcel(1, 6), getDataFromExcel(1, 7),
						getDataFromExcel(1, 8), getDataFromExcel(1, 9), getDataFromExcel(1, 10),
						getDataFromExcel(1, 11), getDataFromExcel(1, 12), getDataFromExcel(1, 13),
						getDataFromExcel(1, 14), getDataFromExcel(1, 15), getDataFromExcel(1, 16), getDataFromExcel(1, 17) },

				{ getDataFromExcel(2, 0), getDataFromExcel(2, 1), getDataFromExcel(2, 2), getDataFromExcel(2, 3),
						getDataFromExcel(2, 4), getDataFromExcel(2, 5), getDataFromExcel(2, 6), getDataFromExcel(2, 7),
						getDataFromExcel(2, 8), getDataFromExcel(2, 9), getDataFromExcel(2, 10),
						getDataFromExcel(2, 11), getDataFromExcel(2, 12), getDataFromExcel(2, 13),
						getDataFromExcel(2, 14), getDataFromExcel(2, 15), getDataFromExcel(2, 16), getDataFromExcel(2, 17) },

				{ getDataFromExcel(3, 0), getDataFromExcel(3, 1), getDataFromExcel(3, 2), getDataFromExcel(3, 3),
						getDataFromExcel(3, 4), getDataFromExcel(3, 5), getDataFromExcel(3, 6), getDataFromExcel(3, 7),
						getDataFromExcel(3, 8), getDataFromExcel(3, 9), getDataFromExcel(3, 10),
						getDataFromExcel(3, 11), getDataFromExcel(3, 12), getDataFromExcel(3, 13),
						getDataFromExcel(3, 14), getDataFromExcel(3, 15), getDataFromExcel(3, 16), getDataFromExcel(3, 17) } };

	}

	@Test(dataProvider = "excelIntegration")
	private void tc01(String name, String pass, String location, String s1, String s2, String s3, String s4, String s5,
			String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13,
			String s14,String s15) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();

		WebElement txtUser = driver.findElement(By.id("username"));
		txtUser.sendKeys(name);

		WebElement txtPass = driver.findElement(By.id("password"));
		txtPass.sendKeys(pass);

		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();

		WebElement dDnlocation = driver.findElement(By.id("location"));
		dDnlocation.sendKeys(location);

		WebElement dDnHotels = driver.findElement(By.id("hotels"));
		dDnHotels.sendKeys(s1);

		WebElement dDnRMtype = driver.findElement(By.id("room_type"));
		dDnRMtype.sendKeys(s2);

		WebElement dDnRMno = driver.findElement(By.id("room_nos"));
		dDnRMno.sendKeys(s3);

		WebElement txtDateIn = driver.findElement(By.id("datepick_in"));
		txtDateIn.sendKeys(s4);

		WebElement txtDateOut = driver.findElement(By.id("datepick_out"));
		txtDateOut.sendKeys(s5);

		WebElement dDnAdult = driver.findElement(By.id("adult_room"));
		dDnAdult.sendKeys(s6);

		WebElement dDnChild = driver.findElement(By.id("child_room"));
		dDnChild.sendKeys(s7);

		WebElement clkSubmit = driver.findElement(By.id("Submit"));
		clkSubmit.click();

		WebElement sltRadio = driver.findElement(By.id("radiobutton_0"));
		sltRadio.click();

		WebElement clkContinue = driver.findElement(By.id("continue"));
		clkContinue.click();

		WebElement txtFirst = driver.findElement(By.id("first_name"));
		txtFirst.sendKeys(s8);

		WebElement txtLast = driver.findElement(By.id("last_name"));
		txtLast.sendKeys(s9);

		WebElement txtAddress = driver.findElement(By.id("address"));
		txtAddress.sendKeys(s10);

		WebElement dDnCNO = driver.findElement(By.id("cc_num"));
		dDnCNO.sendKeys(s11);

		WebElement dDnType = driver.findElement(By.id("cc_type"));
		dDnType.sendKeys(s12);

		WebElement dDnMonth = driver.findElement(By.id("cc_exp_month"));
		dDnMonth.sendKeys(s13);

		WebElement dDnYear = driver.findElement(By.id("cc_exp_year"));
		dDnYear.sendKeys(s14);
		
		WebElement txtcvv = driver.findElement(By.id("cc_cvv"));
		txtcvv.sendKeys(s15);
		
		WebElement btnBookNow = driver.findElement(By.id("book_now"));
		btnBookNow.click();
	}
}
