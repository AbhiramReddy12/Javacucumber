package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Hrmlogin {
	  WebDriver driver;
	 public Hrmlogin(WebDriver  rdriver) {
		 driver =rdriver;
		 PageFactory.initElements(rdriver,this);
	 }
//	 By abhi = By.id("username");  //another way remember this 
//	 public void login(String uname) {
//		 driver.findElement(abhi).sendKeys(uname);
//	 }
	 //this is page factory implementation 
	@FindBy(xpath= "//*[@name='username']")
	@CacheLookup    ///this is used to instruct the initlele() method to cache the element once its located and so that it will not be searched over and over again 
	WebElement userid;
	@FindBy(xpath="//input[@name='password']")
	WebElement passworddummy;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")
	WebElement profile;
	@FindBy(linkText = "Logout")
	WebElement logout;
	public void  setusername(String uname) {
		userid.clear();
		userid.sendKeys(uname);
	}
	public void setpassword(String pwd) {
		passworddummy.clear();
		passworddummy.sendKeys(pwd);
	}
	public void clicklogin() {
		loginbutton.click();
	}
	public void profiletext() {
		profile.click();
		}
	public void logout() {
		logout.click();
	}
	
}