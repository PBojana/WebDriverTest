package example1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class TestClas3 {
	public WebDriver driver;
	public String baseUrl;
	private String notification;
  @Test
  public void test() {
		
  	WebDriver driver = new FirefoxDriver();
  	 driver.manage().window().maximize();
  	driver.get("http://test.inspectionhost.com/rcibase4.5.4/Portal.bsd");
  	driver.switchTo().frame("MainWin");
  	driver.findElement(By.id("UserName")).clear();
  	driver.findElement(By.id("UserName")).sendKeys("admin");
  	driver.findElement(By.id("Password")).clear();
  	driver.findElement(By.id("Password")).sendKeys("password");
  	driver.findElement(By.linkText("Login")).click();
  	for (String handle : driver.getWindowHandles()) {
  		driver.switchTo().window(handle);
  	}
  	driver.switchTo().frame("HeaderWin");
  	Wait.seconds(15);
   	driver.findElement(By.linkText("Maintenance")).click();
  	for (String handle : driver.getWindowHandles()) {
  		driver.switchTo().window(handle);
  	}
  	Wait.seconds(10);
  	driver.switchTo().frame("MainWin");
  	Wait.seconds(10);
  	driver.switchTo().frame("TreeWin");
  	driver.findElement(By.linkText("Email Notification")).click();
		Wait.seconds(5);
		driver.findElement(By.linkText("Survey Emails")).click();
		for (String handle : driver.getWindowHandles()) {
  		driver.switchTo().window(handle);
  	}
  	driver.switchTo().frame("MainWin");
  	driver.switchTo().frame("ContentWin");
  	Wait.seconds(5);
		new Select(driver.findElement(By.name("Status"))).selectByVisibleText("Assigned");
		new Select(driver.findElement(By.name("ContactType"))).selectByVisibleText("Inspector");
		Wait.seconds(10);
		WebElement element = driver.findElement(By.xpath("//*[contains(@name,'MainForm')]"));
		WebElement tabela=element.findElements(By.xpath("//table/tbody")).get(1);
		List<WebElement> tr = tabela.findElements(By.xpath("//tr"));
		WebElement element1 = tr.get(4).findElement(By.xpath("//td/input"));
		element1.clear();
		element1.sendKeys(notification);
		driver.findElement(By.linkText("Save")).click();
		////assertEquals("The email addresses have been saved.", closeAlertAndGetItsText());
		 Alert alert = driver.switchTo().alert();
		 String alertCon=alert.getText();
		 AssertJUnit.assertTrue("Email is not saved",alertCon.contains("The email addresses have been saved"));
		 alert.accept(); 
		 for (String handle : driver.getWindowHandles()) {
	    		driver.switchTo().window(handle);
	    	}
	    	Wait.seconds(10);
		 driver.switchTo().frame("MainWin");
		driver.switchTo().frame("TreeWin");
		driver.findElement(By.linkText("Survey Emails")).click();
		for (String handle : driver.getWindowHandles()) {
  		driver.switchTo().window(handle);
  	}
  	driver.switchTo().frame("MainWin");
		driver.switchTo().frame("ContentWin");
		new Select(driver.findElement(By.name("Status"))).selectByVisibleText("Assigned");
		new Select(driver.findElement(By.name("ContactType"))).selectByVisibleText("Inspector");
		Wait.seconds(10);
		WebElement element2 = driver.findElement(By.xpath("//*[contains(@name,'MainForm')]"));
		WebElement tabela1=element2.findElements(By.xpath("//table/tbody")).get(1);
		List<WebElement> tr1 = tabela1.findElements(By.xpath("//tr"));
		WebElement element3= tr1.get(4).findElement(By.xpath("//td/input"));
		String notificationtext=element3.getAttribute("value");
		AssertJUnit.assertEquals("Notification is not the same !", notificationtext, notification);
		System.out.println(notificationtext);
  }
  @BeforeTest
  public void beforeTest() {
	  notification="test@test.com";
  }

  
}
