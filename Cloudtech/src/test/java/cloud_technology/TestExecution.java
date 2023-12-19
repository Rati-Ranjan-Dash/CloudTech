package cloud_technology;

import Pom.*;

import java.io.File;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestExecution {
    // = new ChromeDriver();
	WebDriver dr;
	//=new FirefoxDriver();
	/*public TestExecution(WebDriver dr) {
		this.dr = dr;
	}*/
	static ExtentTest test;//Interface
	static ExtentReports rep;
	

	@BeforeTest
	public void launch() throws Exception {
		//System.setProperty("Webdriver.chrome.dr","C:/Users/user/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		//dr=new ChromeDriver();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the browser name(chrome/firefox/edge):");
		String browserName = sc.next();
		
		if(browserName.equals("chrome")) {
			
			//System.setProperty("Webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			dr = new ChromeDriver();
		    }
			else if(browserName.equals("firefox")) {
				dr = new FirefoxDriver();
			}
			else if(browserName.equals("edge")) {
				dr = new EdgeDriver();
			}
		
		Utilities ut = new Utilities(dr);
		
		//For screen recording
		MyScreenRecorder.startRecording("Execution Video");
		ut.browser();
		//MyScreenRecorder.stopRecording();

		rep = new ExtentReports(System.getProperty("user.dir")+"./Reports/Report.html");
		test = rep.startTest("report");
	}


	
	@Test(priority = 1)
	public void sign_in() throws Exception {
		
		PageObject po = new PageObject(dr);
		po.login();
		
		//For taking screenshots
		File src =((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshot/login.png"));
		
		Thread.sleep(2000);
		

	}

	@Test(priority = 2)
	public void TC001() throws Exception 
	{
		PageObject po = new PageObject(dr);


		po.navigation_bar();
		Thread.sleep(2000);

	
		String actualMessage1 = dr.findElement(By.xpath("/html/body/div[2]/div/div/div/header/h1")).getText();
		String expectedMessage1 = "education";
		Assert.assertEquals(actualMessage1,expectedMessage1);
		dr.navigate().back();

		File src =((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshot/navigation.png"));
		
		test.log(LogStatus.PASS,"Testcase executed succesfully");


	}
	@Test(priority = 3)
	public void TC002() throws Exception {
		PageObject po = new PageObject(dr);

		po.business();
		Thread.sleep(2000);

		String actualMessage2 = dr.findElement(By.cssSelector(".four-story > h2:nth-child(1)")).getText();
		String expectedMessage2 = "best products";
		Assert.assertEquals(actualMessage2,expectedMessage2);

		test.log(LogStatus.PASS,"Testcase executed succesfully");

	}
	@Test(priority = 4)
	public void TC003() throws Exception {
		PageObject po = new PageObject(dr);

		po.search();
		

		
		Thread.sleep(2000);

		File src =((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshot/search.png"));
		
		test.log(LogStatus.PASS,"Testcase executed succesfully");
	}
	@Test(priority = 5)
	public void TC004() throws Exception {
		PageObject po = new PageObject(dr);

		po.globe_icon();
		Thread.sleep(2000);

		File src =((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshot/globe.png"));
		test.log(LogStatus.PASS,"Testcase executed succesfully");
	}
	@Test(priority = 6)
	public void TC005() throws Exception {
		PageObject po = new PageObject(dr);

		po.about_us();
		
		Thread.sleep(2000);
		
		String actualMessage5 = dr.findElement(By.cssSelector("h3.c-sectionHeading")).getText();
		String expectedMessage5 = "about us";
		Assert.assertEquals(actualMessage5,expectedMessage5);
		
		File src =((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshot/about_us.png"));
		
		test.log(LogStatus.PASS,"Testcase executed succesfully");
	}
	@Test(priority = 7)
	public void TC006() throws Exception {
		PageObject po = new PageObject(dr);

		po.sign_out();
		Thread.sleep(2000);
		File src =((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshot/sign_out.png"));
		
		test.log(LogStatus.PASS,"Testcase executed succesfully");
	}
	
	@Test(priority = 8)
	public void invalid_login() throws Exception {
		
		Negative_tests nt = new Negative_tests(dr);
		nt.valid_email_invalid_password();
		
		System.out.println("Please give valid credential");
		
		String actualMessage6 = dr.findElement(By.id("error-element-password")).getText();
		String expectedMessage6 = "Wrong email or password";
		Assert.assertEquals(actualMessage6,expectedMessage6);
	
		File src =((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		Files.copy(src,new File("./Screenshot/invalid_login.png"));
		
		test.log(LogStatus.PASS,"Testcase executed succesfully");
	}
	@Test(priority = 9)
	public void invalid_login2() throws Exception {
		
		Negative_tests nt = new Negative_tests(dr);
		nt.invalid_email_valid_password();
		
		System.out.println("Please give valid credential");
		
		String actualMessage7 = dr.findElement(By.id("error-element-password")).getText();
		String expectedMessage7 = "Wrong email or password";
		Assert.assertEquals(actualMessage7,expectedMessage7);
		
		
	
		test.log(LogStatus.PASS,"Testcase executed succesfully");
	}
	
	
	@Test(priority = 10)
	public void footer() throws Exception {
		
		PageObject po = new PageObject(dr);
		po.facebook_button();
		po.twitter_button();
		po.linkedin_button();
		po.youtube_button();
		Thread.sleep(2000);
		po.instagram_button();
		Thread.sleep(2000);
		po.tiktok_button();
		Thread.sleep(2000);
	}
	
	
	
	@AfterTest
	public void exit() throws Exception {

		MyScreenRecorder.stopRecording();
		rep.endTest(test);
		rep.flush();
		rep.close();
		dr.quit();

	}
}

