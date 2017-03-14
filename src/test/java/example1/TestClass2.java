package example1;

 
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestClass2 {
	
	 public  WebDriver driver;
	 public String baseUrl;
	    private boolean acceptNextAlert = true;
	    @SuppressWarnings("unused")
		private StringBuffer verificationErrors = new StringBuffer();
	 
	    @BeforeMethod
		public void setUp() throws Exception {
	    	
	   baseUrl ="http://test.inspectionhost.com/Base4.5.4/Portal.bsd";
             
	    } 
	    @Test
		public void test() {
	    	 WebDriver driver = new FirefoxDriver();
	    	 driver.manage().window().maximize();
		    driver.get("http://test.inspectionhost.com/Base4.5.4QA/Portal.bsd");
		    driver.switchTo().frame("MainWin");
		    driver.findElement(By.id("UserName")).clear();
	    	driver.findElement(By.id("UserName")).sendKeys("admin");
	    	driver.findElement(By.id("Password")).clear();
	    	driver.findElement(By.id("Password")).sendKeys("password");
	    	driver.findElement(By.linkText("Login")).click();
	    	Wait.seconds(5);
	   	 for (String handle : driver.getWindowHandles()) {
	         driver.switchTo().window(handle);
		 }
	   	 driver.switchTo().frame("HeaderWin");
	   	driver.findElement(By.linkText("Recs")).click();

		  for (String handle : driver.getWindowHandles()) {
	          driver.switchTo().window(handle);
			} 
		    driver.switchTo().frame("MainWin");
		    Wait.seconds(10);
		    new Select(driver.findElement(By.name("ItemsPerPage"))).selectByVisibleText("75");
		    Wait.seconds(10);
		    //Search by Ref#
		    driver.findElement(By.name("Search0")).sendKeys("111");
		    driver.findElement(By.linkText("Search")).click();
		    Wait.seconds(5);
		   driver.findElement(By.name("Search0")).clear();
		   /*
		    driver.findElement(By.name("Search0")).sendKeys("a");
		    driver.findElement(By.linkText("Search")).click();
		    driver.findElement(By.name("Search0")).clear();*/
		    Wait.seconds(5);
		    //Search by Policy No.
		    driver.findElement(By.name("Search1")).sendKeys("231");
		    driver.findElement(By.linkText("Search")).click();
		    Wait.seconds(2);
		    driver.findElement(By.name("Search1")).clear();
		    
		     System.out.println("Test 2 test 2");
		   //Search by Risk Control Professional Start
		    
		    driver.findElement(By.id("Search2Select")).click();
		    driver.findElement(By.xpath("(//input[@name='Search2Select[]'])[7]")).click();
		    driver.findElement(By.xpath("(//input[@name='Search2Select[]'])[8]")).click();
		    driver.findElement(By.xpath("(//input[@name='Search2Select[]'])[9]")).click();
		    driver.findElement(By.linkText("Search")).click();
		     Wait.seconds(10);
		    driver.findElement(By.id("Search2Select")).click();
		    driver.findElement(By.xpath("(//input[@name='Search2Select[]'])[7]")).click();
		    driver.findElement(By.xpath("(//input[@name='Search2Select[]'])[8]")).click();
		    driver.findElement(By.xpath("(//input[@name='Search2Select[]'])[9]")).click();
		  //Search by Risk Control Professional End

		    // Underwriter Start
		    driver.findElement(By.id("Search3Select")).click();
		    driver.findElement(By.xpath("(//input[@name='Search3Select[]'])[3]")).click();
		    driver.findElement(By.xpath("(//input[@name='Search3Select[]'])[4]")).click();
		    driver.findElement(By.xpath("(//input[@name='Search3Select[]'])[5]")).click();
		    driver.findElement(By.linkText("Search")).click(); 
		    Wait.seconds(10); 
		    driver.findElement(By.id("Search3Select")).click();
		    driver.findElement(By.xpath("(//input[@name='Search3Select[]'])[3]")).click();
		    driver.findElement(By.xpath("(//input[@name='Search3Select[]'])[4]")).click();
		    driver.findElement(By.xpath("(//input[@name='Search3Select[]'])[5]")).click();
		     
		    // Underwriter End
		    // Number Start
		    driver.findElement(By.name("Search4")).sendKeys("03-01");
		    driver.findElement(By.linkText("Search")).click();
		    driver.findElement(By.name("Search4")).clear();
		    //Number End
		    
		    //Severity Start
		    driver.findElement(By.id("Search5Select")).click();
		    driver.findElement(By.xpath("(//input[@name='Search5Select[]'])[1]")).click();
		    driver.findElement(By.linkText("Search")).click();
		    Wait.seconds(10);
		    driver.findElement(By.id("Search5Select")).click();
		    driver.findElement(By.xpath("(//input[@name='Search5Select[]'])[1]")).click();
		    //Severity End
		    
		    //Status Start
		    driver.findElement(By.id("Search6Select")).click();
		    driver.findElement(By.xpath("(//input[@name='Search6Select[]'])[1]")).click();
		    driver.findElement(By.linkText("Search")).click();
		    Wait.seconds(10);
		    driver.findElement(By.id("Search6Select")).click();
		    driver.findElement(By.xpath("(//input[@name='Search6Select[]'])[1]")).click();
	 

	 
		    
		    //Category Start ne raboti
 		    /* driver.findElement(By.id("Search13DropDown")).click();
		    driver.findElement(By.xpath("(//input[@id='Search13DropDown[]'])[1]")).click();
		    driver.findElement(By.linkText("Search")).click(); 
		    
		    WebDriverWait wait = new WebDriverWait(driver,30);
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Search13DropDown[]'])[1]")));      
		   */ //Category End
		    driver.findElement(By.linkText("Reset")).click();
		    // Sort
		    driver.findElement(By.linkText("Ref #")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Ref #")).click();
		    driver.findElement(By.linkText("Policy No.")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Policy No.")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Risk Control Professional")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Risk Control Professional")).click();
		    driver.findElement(By.linkText("Underwriter")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Underwriter")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Number")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Number")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Severity")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Severity")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Status")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Status")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Complete By")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Complete By")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Date Completed")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Date Completed")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Section")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Section")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Recommendation")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Recommendation")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Recommendation Title")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Recommendation Title")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Category")).click();
		    Wait.seconds(5);
		    driver.findElement(By.linkText("Category")).click();
		    System.out.println("Stigna do kraj vtora ");
	    }
}
