package Pom;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Negative_tests {
	
	WebDriver dr;
	


	public Negative_tests(WebDriver dr) {
		this.dr = dr;
	}
	public void valid_email_invalid_password() throws Exception {
		
		dr.findElement(By.cssSelector(".c-siteHeaderNavigation_loginButton")).click();
		Thread.sleep(3000);

		File fl = new File("./TestData/Rati_DDT1.xls");
		FileInputStream sh = new FileInputStream(fl);
		
		HSSFWorkbook wb = new HSSFWorkbook(sh);
		HSSFSheet sheet = wb.getSheet("Sheet1");
		
		for (String handle : dr.getWindowHandles()) {
			dr.switchTo().window(handle);
		}
	
		
		dr.findElement(By.xpath("//*[@id=\"username\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		dr.findElement(By.id("password")).clear();
		dr.findElement(By.id("password")).sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
		
		dr.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(5000);
		
		dr.findElement(By.cssSelector("button.cf1ef5a0b:nth-child(1)")).click();
		Thread.sleep(3000);
//		for (String handle : dr.getWindowHandles()) {
//			dr.switchTo().window(handle);
//		}
	}
	public void invalid_email_valid_password() throws Exception {
		
//		dr.findElement(By.cssSelector(".c-siteHeaderNavigation_loginButton")).click();
//		Thread.sleep(3000);
		
		File fl = new File("./TestData/Rati_DDT1.xls");
		FileInputStream sh = new FileInputStream(fl);
		
		HSSFWorkbook wb = new HSSFWorkbook(sh);
		HSSFSheet sheet = wb.getSheet("Sheet1");

//		for (String handle : dr.getWindowHandles()) {
//			dr.switchTo().window(handle);
//		}
		
		dr.findElement(By.xpath("//*[@id=\"username\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(3000);
		dr.findElement(By.id("password")).clear();
		dr.findElement(By.id("password")).sendKeys(sheet.getRow(3).getCell(1).getStringCellValue());
		
		dr.findElement(By.cssSelector("button.cf1ef5a0b:nth-child(1)")).click();
		Thread.sleep(5000);
		
		dr.close();
		
		for (String handle : dr.getWindowHandles()) {
			dr.switchTo().window(handle);
		}
		//dr.findElement(By.xpath("div.c-siteLogo:nth-child(1) > svg:nth-child(1)")).click();
	}

}
