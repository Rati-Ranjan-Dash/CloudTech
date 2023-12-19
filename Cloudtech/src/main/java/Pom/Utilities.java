package Pom;

import java.util.Scanner;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;



public class Utilities {
	
	WebDriver dr;
	
	public Utilities(WebDriver dr) {
		this.dr = dr;
	}
	
//	public void choose_browser() {
//		
////		Scanner sc = new Scanner(System.in);
////		System.out.println("Enter the browser name(chrome/firefox/edge):");
////		String browserName = sc.next();
////		
////		if(browserName.equals("chrome")) {
////			dr = new ChromeDriver();
////		    }
////			else if(browserName.equals("firefox")) {
////				dr = new FirefoxDriver();
////			}
////			else if(browserName.equals("edge")) {
////				dr = new EdgeDriver();
////			}
////		
//	}
	
//	
	public void browser() throws Exception {
		

		//dr = new FirefoxDriver();
		dr.get("https://www.zdnet.com/article/what-is-cloud-computing-everything-you-need-to-know-about-the-cloud/");
		dr.manage().window().maximize();
		Thread.sleep(2000);
	}
	public void new_window() {
		
	       Set<String> windowHandles = dr.getWindowHandles();

	        // Switch to the new window
	        for (String windowHandle : windowHandles) {
	            if (!windowHandle.equals(dr.getWindowHandle())) {
	                dr.switchTo().window(windowHandle);
	                break;
	            }
	        }
	        String newWindowTitle = dr.getTitle();
	        System.out.println("Title of the new window: " + newWindowTitle);
	        
	    	dr.close();
	        // Switch back to the original window

	        dr.switchTo().window(dr.getWindowHandles().iterator().next());
	}

	

}
