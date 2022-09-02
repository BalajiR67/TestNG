package com.priority;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	WebDriver driver;

	@Test(dataProvider = "getData")
	private void tc01(String s) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
		WebElement txtSearch = driver.findElement(By.id("twotabsearchtextbox"));
		txtSearch.sendKeys(s);
		WebElement clkSearch = driver.findElement(By.id("nav-search-submit-button"));
		clkSearch.click();

	}

	@DataProvider
	private Object[][] getData() {

		Object[][] data = new Object[10][1];

		data[0][0] = "iphone 13";
		data[1][0] = "macbook";
		data[2][0] = "Appel Smart watches";
		data[3][0] = "earphones";
		data[4][0] = "iphone tablet";
		data[5][0] = "Sony bravia LED smart tv";
		data[6][0] = "indian poetry";
		data[7][0] = "Sony Alpha DSLR camera";
		data[8][0] = "Air conditioner";
		data[9][0] = "Sunglasses";

		return data;

	}

}
