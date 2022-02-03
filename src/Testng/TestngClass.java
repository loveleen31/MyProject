package Testng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestngClass {
	WebDriver driver;
	@BeforeSuite
	public void intialisation() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lovel\\SeleniumProject\\chromedriver.exe" );
	}
	@BeforeTest
	public void setup() throws InterruptedException{
		this.driver=new ChromeDriver();
		this.driver.get("https://www.demoblaze.com/");
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	public void signup() throws InterruptedException{
		driver.findElement(By.id("signin2")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username"))).sendKeys("kaurttbbff");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-password"))).sendKeys("sandhuttbbff");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#signInModal > div > div > div.modal-footer > button.btn.btn-primary"))).click();
	    Thread.sleep(3000);
	    Alert al = driver.switchTo().alert();
	    String aa=driver.switchTo().alert().getText();
	    System.out.println(aa);
	    Thread.sleep(3000);
	    al.accept();	
	    Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void login() {
	    driver.findElement(By.id("login2")).click();
	    WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("kaurttbbff");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))).sendKeys("sandhuttbbff");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary"))).click();	
	}
	
	@Test(priority=3)
	public void selectlaptop() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1300)");
	    Thread.sleep(3000);
	    WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("i5"))).click();
	    Thread.sleep(3000);}
	
   @Test(priority=4)
	public void AddtoCard() throws InterruptedException {
		driver.findElement(By.cssSelector("#tbodyid > div.row > div > a")).click();
	    Thread.sleep(3000);
	    Alert al = driver.switchTo().alert();
	    String gg=driver.switchTo().alert().getText();
	    System.out.println(gg);
	    Thread.sleep(3000);
	    al.accept();	}
	
	@AfterTest
	public void NavigatetoCart() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.navigate().to("https://www.demoblaze.com/cart.html");
	    Thread.sleep(3000);
	    boolean dd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#navbarExample > ul > li:nth-child(4) > a"))).isEnabled();
	    System.out.println(dd);	
	    driver.close();
	}}


