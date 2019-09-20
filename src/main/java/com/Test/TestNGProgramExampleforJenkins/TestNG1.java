package com.Test.TestNGProgramExampleforJenkins;

import java.io.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestNG1 {
	
	public WebDriver driver;
   
	@BeforeSuite
	public void intialize() {
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Parameters({"url","username","password"})
	@BeforeClass
	public void login(String url,String user,String pass) {
		try {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.name("UserID")).sendKeys(user);
		Thread.sleep(2000);
		driver.findElement(By.name("Password")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Got it']")).click();
		Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void logout() throws Exception {
		driver.findElement(By.xpath("//button/md-icon[@md-svg-icon='logout']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr/td/div[text()='Yes']")).click();
		Thread.sleep(3000);
	}
	
	@AfterSuite
	public void shut() {
		driver.close();
	}
}
