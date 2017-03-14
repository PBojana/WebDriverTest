package example1;

 
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestClass {
	 public  WebDriver driver;
	 public String baseUrl;
	 private Boolean newItemExsist=false,newItemExsist1=true;
	    @SuppressWarnings("unused")
		private StringBuffer verificationErrors = new StringBuffer();

	    @BeforeMethod
	
		public void setUp() throws Exception {

	    	   baseUrl ="http://test.inspectionhost.com/rcibase4.5.4dev/Portal.bsd";
	    	  
	    }
	  
	    
	    @Test
	public void test() { 
	    	WebDriver driver = new FirefoxDriver();
	    	 
	             driver.manage().window().maximize();
	        
	    	driver.get("http://test.inspectionhost.com/rcibase4.5.4dev/Portal.bsd");


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
	    	driver.findElement(By.linkText("Surveys")).click();
	    	Wait.seconds(15);
	    	for (String handle : driver.getWindowHandles()) {
	    		driver.switchTo().window(handle);
	    	}

	    	driver.switchTo().frame("MainWin");
	    	Wait.seconds(5);
	    	driver.findElement(By.xpath("//tr[25]/td[6]/a")).click();
	    	String ContentWin = driver.getWindowHandle();
	    	driver.switchTo().frame("TreeWin");
	    	Wait.seconds(5);
	    	driver.findElement(By.linkText("Add Item")).click();
	    	Wait.seconds(5);
	       	Integer newItem=driver.findElements(By.xpath("//div[@id='LeftNavWrap']/ul/li")).size();
	    	for (int i=1; i<= newItem;i++)
	    	{
	    		String getText=driver.findElement(By.xpath("//li["+i+"]/a")).getText();
	    		System.out.println(getText);
	    		if  (getText.equals("(New Item)"))
	    		{
	    		//	System.out.println("vleze vo if"+getText);
	    			newItemExsist=true;
	    			break;
	    		}
	    	}
	    	AssertJUnit.assertTrue("New Item dosen't exsist",newItemExsist);
	    	
	    	driver.switchTo().window(ContentWin);
	    	driver.switchTo().frame("MainWin");
	    	driver.switchTo().frame("ContentWin");
	    	driver.findElement(By.linkText("Exit")).click();
	    	Integer newItem1=driver.findElements(By.xpath("//div[@id='LeftNavWrap']/ul/li")).size();
	    	System.out.println(newItem1);
	    	for (int i=1; i<=newItem1-3;i++)
	    	{
	    		String getText1=driver.findElement(By.xpath("//li["+i+"]/a")).getText();
	    		System.out.println(getText1);
	    		if  (getText1== "(New Item)")
	    		{
	    			newItemExsist1=false;
	    			break;
	    		}
	    	}
	    	/////
	    	AssertJUnit.assertTrue("New Item still exsist",newItemExsist1);
	    	Wait.seconds(20);
	    	driver.switchTo().window(ContentWin);
			driver.switchTo().frame("MainWin");
	    	driver.switchTo().frame("TreeWin");
	    	driver.findElement(By.linkText("Add Item")).click();
	    	Wait.seconds(10);
	    	driver.switchTo().window(ContentWin);
	    	driver.switchTo().frame("MainWin");
	    	driver.switchTo().frame("ContentWin");
	    	WebElement tableForm = driver.findElement(By.cssSelector("select[name='FormID']")); 
	    	WebElement optionForm =tableForm.findElement(By.cssSelector("option:nth-child(2)"));
			String form = optionForm.getText();
			new Select(driver.findElement(By.xpath("//select[@name='FormID']"))).selectByVisibleText(form);
	    	driver.findElement(By.linkText("Select Address")).click();
	    	String Address = null;
	    	Set<String> handles1 = driver.getWindowHandles(); // get all window handles
			    Iterator<String> iterator1 = handles1.iterator();
			    while (iterator1.hasNext()){
			    	Address = iterator1.next();
			    }
			    driver.switchTo().window(Address);
			    Wait.seconds(5);
			    driver.manage().window().maximize();
			    driver.findElement(By.xpath("//tr[5]/td[2]/a")).click();
	    	driver.switchTo().window(ContentWin);
	    	driver.switchTo().frame("MainWin");
	    	driver.switchTo().frame("ContentWin");
			Wait.seconds(5);
			driver.findElement(By.linkText("New")).click();
			String AddLocation = null;
	    	Set<String> handles2 = driver.getWindowHandles(); // get all window handles
			    Iterator<String> iterator2 = handles2.iterator();
			    while (iterator2.hasNext()){
			    	AddLocation = iterator2.next();
			    }
			    driver.switchTo().window(AddLocation);
			    driver.switchTo().frame("MainWin");
			    Wait.seconds(10);
			    driver.manage().window().maximize();
			driver.findElement(By.id("LocationDescription"));
			driver.findElement(By.linkText("Exit")).click();
			driver.switchTo().window(ContentWin);
		    driver.switchTo().frame("MainWin");
		    driver.switchTo().frame("ContentWin");  
	    	driver.findElement(By.xpath("(//a[contains(text(),'Save')])[2]")).click();
	    	Wait.seconds(10);
	    	driver.switchTo().window(ContentWin);
	    	driver.switchTo().frame("MainWin");
	    	driver.switchTo().frame("ContentWin");
	    	driver.findElement(By.id("item_action_buttons"));
	    	Wait.seconds(20);
	    	driver.switchTo().window(ContentWin);
			driver.switchTo().frame("MainWin");
	    	driver.switchTo().frame("TreeWin");
	    	Wait.seconds(5);
	    	driver.findElement(By.xpath("//li/a")).click();
	    	Wait.seconds(5);
	    	driver.findElement(By.linkText("Add Item")).click();
	    	Wait.seconds(10);
	    	driver.switchTo().window(ContentWin);
	    	driver.switchTo().frame("MainWin");
	    	driver.switchTo().frame("ContentWin");
	    	WebElement tableForm1 = driver.findElement(By.cssSelector("select[name='FormID']")); 
	    	WebElement optionForm1 =tableForm1.findElement(By.cssSelector("option:nth-child(2)"));
			String form1 = optionForm1.getText();
			
	    	new Select(driver.findElement(By.name("FormID"))).selectByVisibleText(form1);
	    	driver.findElement(By.linkText("Save & Add Item")).click();
	    	Wait.seconds(5);
	    	driver.findElement(By.linkText("Save & Add Item"));
	    	System.out.println("Stigna do kraj ");
	    	
}}
