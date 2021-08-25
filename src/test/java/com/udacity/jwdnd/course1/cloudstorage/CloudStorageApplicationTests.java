package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {
	@LocalServerPort
	private int port;

	WebDriver driver;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");
		assertEquals("Login", driver.getTitle());
	}

	@Test
	public void unAuthorisedUserAccess(){
		driver.get("http://localhost:" + this.port + "/home");
		assertFalse(driver.getTitle() == "Home");

		driver.get("http://localhost:"+this.port+"/login");
		assertEquals("Login",driver.getTitle() );

		driver.get("http://localhost:"+this.port+"/signup");
		assertEquals("Sign Up",driver.getTitle() );
	}


	@Test
	public void testUserSignupAndLogin() throws InterruptedException {

		signup();
		login();
		assertEquals("Home", driver.getTitle());

		HomePage homePage = new HomePage(driver);
		Thread.sleep(2000);
		homePage.logout();

		driver.get("http://localhost:" + this.port + "/home");
		assertFalse(driver.getTitle() == "Home");
		assertEquals("Login", driver.getTitle());

	}

	public void signup(){
		driver.get("http://localhost:" + this.port + "/signup");

		SignupPage signupPage = new SignupPage(driver);
		signupPage.signUp("Motasem","Ahmed","Mo3ts","Pa21");
	}
	public void login(){
		driver.get("http://localhost:" + this.port + "/login");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("Mo3ts","Pa21");
	}
	public HomePage getHomePage(){
		signup();
		login();
		return new HomePage(driver);
	}

}
