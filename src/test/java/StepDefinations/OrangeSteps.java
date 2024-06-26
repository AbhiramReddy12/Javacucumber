package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Hrmlogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeSteps {
	WebDriver driver;
	Hrmlogin hl;
	@Before(order=1)
//	@Given("user launches chrome browser")
	public void user_launches_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		hl = new Hrmlogin(driver);
		driver.manage().window().maximize();
		
	}
	@Before(order=0)// as per mentioned order this will execute and if we want to run for particular tags syntax @Before("@smoke") this tag mentioned in feature file.
	// if we want to use tags along with order synatax is @Before(value="@smoke",order="2")
	public void sethooks() {
		System.out.println("im in hooks");
	}
	@When("user opens url {string}")
	public void user_opens_url(String string) {
		driver.get(string);
	}

//	@When("user enter credentials")
//	public void user_enters_credentials() throws InterruptedException {
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
//		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
//		hl.setusername("username");
//		hl.setpassword("password");
//	}
	@When("user enters username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) throws InterruptedException {
		Thread.sleep(5000);
	    hl.setusername(username);
	    hl.setpassword(password);
	}

	@When("click on login")
	public void click_on_login() {
		hl.clicklogin();
	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String title) {
		
		if(driver.getTitle().equals(title)) {
			System.out.println("title is verified");
			System.out.println(driver.getTitle());
		}
		else
			System.out.println("tilte is not matching");
	}

	@When("user click on log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		Thread.sleep(3000);
		hl.profiletext();
		Thread.sleep(3000);
		hl.logout();
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}



}



