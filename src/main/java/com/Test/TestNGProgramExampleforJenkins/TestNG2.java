package com.Test.TestNGProgramExampleforJenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class TestNG2 extends TestNG1 {
	
	@Parameters({"url"})
	@Test
	public void admin(String url) throws Exception {
		driver.findElement(By.id("appAdmin_menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tr/td[contains(text(),'Update User')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("EmailId")).sendKeys(url);
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.RETURN).build().perform();
	}
}
