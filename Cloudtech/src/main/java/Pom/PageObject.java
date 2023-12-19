package Pom;

import java.io.File;
import java.io.FileInputStream;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class PageObject {

	WebDriver dr;


	public PageObject(WebDriver dr) {
		this.dr = dr;
	}
	public void login() throws Exception {

		dr.findElement(By.cssSelector(".c-siteHeaderNavigation_loginButton")).click();
		Thread.sleep(3000);

		for (String handle : dr.getWindowHandles()) {
			dr.switchTo().window(handle);
		}
		File fl = new File("./TestData/Rati_DDT1.xls");
		FileInputStream sh = new FileInputStream(fl);
		
		HSSFWorkbook wb = new HSSFWorkbook(sh);
		HSSFSheet sheet = wb.getSheet("Sheet1");
		
		dr.findElement(By.xpath("//*[@id=\"username\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		dr.findElement(By.id("password")).clear();
		dr.findElement(By.id("password")).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		
		dr.findElement(By.cssSelector("button.cf1ef5a0b:nth-child(1)")).click();

		for (String handle : dr.getWindowHandles()) {
			dr.switchTo().window(handle);
		}


	}

	public void navigation_bar() throws Exception 
	{


		dr.findElement(By.cssSelector(".c-sitePrimaryMenu-more > button:nth-child(1) > svg:nth-child(1)")).click();
		Thread.sleep(2000);
		dr.findElement(By.cssSelector("#more-menu > div:nth-child(1) > ul:nth-child(3) > li:nth-child(3) > span:nth-child(1) > a:nth-child(1) > span:nth-child(1)")).click();
		Thread.sleep(2000);
	}

	public void business() throws Exception {

		WebElement burgermenu=dr.findElement(By.cssSelector("div.c-sitePrimaryMenu:nth-child(4) > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)"));
		WebElement bsn = dr.findElement(By.cssSelector("#business-menu > div:nth-child(1) > ul:nth-child(3) > li:nth-child(4) > span:nth-child(1) > a:nth-child(1) > span:nth-child(1)"));
		Actions actions = new Actions(dr);

		actions.moveToElement(burgermenu).perform();
		Thread.sleep(2000);
		actions.moveToElement(bsn).perform();
		Thread.sleep(2000);
		dr.findElement(By.cssSelector("#business-menu > div:nth-child(1) > ul:nth-child(3) > li:nth-child(4) > span:nth-child(1) > a:nth-child(1) > span:nth-child(1)")).click();
		Thread.sleep(2000);	
	}

	public void search() throws Exception {
		dr.findElement(By.cssSelector(".mag")).click();
		Thread.sleep(2000);
		dr.findElement(By.id("header-search-field")).sendKeys("cloud");
		Thread.sleep(2000);
		dr.findElement(By.xpath("//button[@class='search-button']")).click();
		dr.findElement(By.cssSelector("#main > div > div > div.row > div > div > div > div:nth-child(1) > div > section > div > ul > li:nth-child(2) > div > a > span.img > img")).click();
		Thread.sleep(2000);
		String actualMessage3 = dr.findElement(By.cssSelector(".c-contentHeader_headline")).getText();
		String expectedMessage3 = "AWS announces preview of EC2 M1 Mac instances";
		String expectedMessage4 = "AWS fleshes out processor roadmap with Graviton3, Trainium, new instances";
		//    	Assert.assertEquals(actualMessage3,expectedMessage3);
		if(expectedMessage4==actualMessage3||expectedMessage3==actualMessage3)
		{
			dr.findElement(By.cssSelector("div.c-siteLogo:nth-child(1) > svg:nth-child(1)")).click();
			Thread.sleep(2000);
		}

	}

	public void globe_icon() throws Exception {

		dr.findElement(By.cssSelector(".c-sitePrimaryMenu_globeIcon")).click();
		Thread.sleep(2000);
		dr.findElement(By.cssSelector("#editions-menu > div:nth-child(1) > ul:nth-child(5) > li:nth-child(4) > span:nth-child(1) > a:nth-child(1) > span:nth-child(1)")).click();
		Thread.sleep(2000);
		dr.navigate().back();
		dr.findElement(By.cssSelector("div.c-siteLogo:nth-child(1) > svg:nth-child(1)")).click();
		Thread.sleep(2000);
	}

		 public void about_us() {
			 
			 dr.findElement(By.cssSelector("div.c-siteFooterColumnLinks:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();
			 
		}

	public void sign_out() throws Exception {

		dr.findElement(By.cssSelector(".c-sitePrimaryMenu_user-filledIcon")).click();
		Thread.sleep(2000);
		dr.findElement(By.cssSelector("#account-menu > div:nth-child(1) > ul:nth-child(4) > li:nth-child(3) > span:nth-child(1) > div:nth-child(1)")).click();
		Thread.sleep(2000);
	}
	
	public void facebook_button() throws Exception {
		
		Utilities ut = new Utilities(dr);
		
	    JavascriptExecutor tr = (JavascriptExecutor) dr;
        tr.executeScript("window.scrollBy(0,10000)", "");
        
        Thread.sleep(2000);
        
	    JavascriptExecutor ab = (JavascriptExecutor) dr;
        ab.executeScript("window.scrollBy(0,10000)", "");
        
       Thread.sleep(2000);
       
	    JavascriptExecutor cd = (JavascriptExecutor) dr;
        cd.executeScript("window.scrollBy(0,5000)", "");
        
       Thread.sleep(2000);
       
	    JavascriptExecutor ef = (JavascriptExecutor) dr;
        ef.executeScript("window.scrollBy(0,5000)", "");
       
        Thread.sleep(2000);
        
        dr.findElement(By.cssSelector("li.c-socialSharebar_button:nth-child(1) > a:nth-child(1)")).click();
        Thread.sleep(3000);
        
        ut.new_window();
	}
  
	
	
	
	public void twitter_button() throws Exception {
		
		Utilities ut = new Utilities(dr);
		
		dr.findElement(By.cssSelector("li.c-socialSharebar_button:nth-child(2) > a:nth-child(1) > svg:nth-child(1)")).click();
		Thread.sleep(3000);
		
		ut.new_window();

	}
	
	public void linkedin_button() throws Exception {
		
		Utilities ut = new Utilities(dr);
		
		dr.findElement(By.cssSelector("#__layout > div > div.c-layoutDefault_page > footer > div.c-siteFooter_container.g-grid-container.u-grid-columns > div.sm\\:u-col-2.md\\:u-col-6.lg\\:u-col-4 > div > div > div > ul > li.c-socialSharebar_button.c-socialSharebar_button-linkedin.c-socialSharebar_icon > a")).click();
		Thread.sleep(3000);
		
		ut.new_window();
	}

	public void youtube_button() throws Exception {
		
		Utilities ut = new Utilities(dr);
		
		dr.findElement(By.cssSelector(".c-socialSharebar_button-youtube > a:nth-child(1) > svg:nth-child(1)")).click();
		Thread.sleep(7000);
	    
		ut.new_window();
		
	}
	public void instagram_button() throws Exception {
		
		Utilities ut = new Utilities(dr);
		
		dr.findElement(By.cssSelector("li.c-socialSharebar_button:nth-child(5) > a:nth-child(1) > svg:nth-child(1)")).click();
		Thread.sleep(3000);
	
		ut.new_window();

	}
	public void tiktok_button() throws Exception {
		
		Utilities ut = new Utilities(dr);
		
		dr.findElement(By.cssSelector("li.c-socialSharebar_button:nth-child(6) > a:nth-child(1) > svg:nth-child(1)")).click();
		Thread.sleep(3000);
		
		ut.new_window();
		
	}


}
