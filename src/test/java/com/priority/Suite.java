package com.priority;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Suite {
	WebDriver driver;
	@BeforeClass
	private void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	@Parameters("username")
	@Test(priority=-1)
	private void tco1(String s) {
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys(s);
	}
	@Parameters("password")
	@Test
	private void tc02(String s) {
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(s);
    
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
		
		WebElement dDnloaction = driver.findElement(By.id("location"));
	
		Select select=new  Select(dDnloaction);
		select.selectByIndex(2);
		
		WebElement dDnhotel = driver.findElement(By.id("hotels"));
		
		Select select2= new Select(dDnhotel);
		select2.selectByIndex(3);
		
		WebElement dDnRmtype = driver.findElement(By.id("room_type"));
		
		Select  select3=new Select(dDnRmtype);
		select3.selectByIndex(2);
		
		WebElement dDnRmNo = driver.findElement(By.id("room_nos"));
		Select select4=new Select(dDnRmNo);
		select4.selectByIndex(2);
		
		WebElement dDnAdult = driver.findElement(By.id("adult_room"));
		Select select5=new Select(dDnAdult);
		select5.selectByIndex(2);
		 
		WebElement dDnChild = driver.findElement(By.id("child_room"));
		
		Select select6=new Select(dDnChild);
		select6.selectByIndex(2);
		
		WebElement clkSumit = driver.findElement(By.id("Submit"));
		clkSumit.click();
		
		WebElement clkRadio = driver.findElement(By.id("radiobutton_0"));
		clkRadio.click();
		
		WebElement clkOk = driver.findElement(By.id("continue"));
		clkOk.click();
		
	}
	@Parameters({"firstname","lastname","address","cardnum","Ccv"})
	@Test(priority=1)
	private void fristname(String s, String s1,String s2,String s3,String s4) {

		WebElement txtFirstnane = driver.findElement(By.id("first_name"));
		txtFirstnane.sendKeys(s);
		
		WebElement txtLastname = driver.findElement(By.id("last_name"));
		txtLastname.sendKeys(s1);
		
		WebElement txtAddress = driver.findElement(By.id("address"));
		txtAddress.sendKeys(s2);
		
		WebElement txtCardNo = driver.findElement(By.id("cc_num"));
		txtCardNo.sendKeys(s3);
		
		WebElement dDnCcType = driver.findElement(By.id("cc_type"));
		 Select select=new Select(dDnCcType);
		 select.selectByIndex(2);

		 WebElement dDnmonth = driver.findElement(By.id("cc_exp_month"));
		 Select select2=new Select(dDnmonth);
		 select2.selectByIndex(6);
		 
		 WebElement dDnYear = driver.findElement(By.id("cc_exp_year"));
		 
		 Select select3=new Select(dDnYear);
		  select3.selectByIndex(8);
		  
		  WebElement txtCcv = driver.findElement(By.id("cc_cvv"));
		  txtCcv.sendKeys(s4);

		  WebElement clkBooking = driver.findElement(By.id("book_now"));
		  clkBooking.click();
		
	}
}
