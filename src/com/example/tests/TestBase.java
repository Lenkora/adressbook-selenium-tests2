package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.ui.Select;


public class TestBase {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	protected void openMainPage() {
	    driver.get(baseUrl + "/addressbookv4.1.4/");
	}
	
	protected void returnToGroupPage() {
		
	    driver.findElement(By.linkText("group page")).click();
	}

	protected void siubmitGroupCreation() {
		
	    driver.findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData group) {
		
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	protected void initGroupCreation() {
	    driver.findElement(By.name("new")).click();
	}

	protected void openGroupsPage() {
	    driver.findElement(By.linkText("groups")).click();
	}
	
	protected void returnToAddNext() {
		driver.findElement(By.linkText("add next")).click();
	}

	protected void submitAddNewCreation() {
		driver.findElement(By.name("submit")).click();
	}

	protected void fillAddNewForm(ZANewData addNew) {
		driver.findElement(By.name("firstname")).clear();
	    driver.findElement(By.name("firstname")).sendKeys(addNew.nameFirst1);
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(addNew.nameLaste1);
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(addNew.address1);
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(addNew.homa1);
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(addNew.mobile1);
	    driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys(addNew.work1);
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(addNew.email1);
	    driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys(addNew.email2);
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(addNew.day);
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(addNew.month);
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(addNew.year);
	    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(addNew.groupname1);
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(addNew.address2);
	    driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys(addNew.home2);
	}

	protected void addNew() {
		driver.findElement(By.linkText("add new")).click();
	}

	

	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
