package cloud_technology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sign_in {
	
	WebDriver dr;
	
	@Test
	public void login() throws Exception {
		
		dr = new ChromeDriver();
		dr.get("https://www.zdnet.com/article/what-is-cloud-computing-everything-you-need-to-know-about-the-cloud/");
		dr.manage().window().maximize();
		Thread.sleep(1000);
		
		dr.findElement(By.cssSelector(".c-siteHeaderNavigation_loginButton")).click();
		Thread.sleep(5000);
		
		for (String handle : dr.getWindowHandles()) {
	        dr.switchTo().window(handle);

	        }
		
		dr.findElement(By.xpath("//*[@id=\"username\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("ratiranjan.dash@ldtech.in");
		dr.findElement(By.id("password")).sendKeys("Ratirati@12");
		dr.findElement(By.cssSelector("button.cf1ef5a0b:nth-child(1)")).click();
	}
}
