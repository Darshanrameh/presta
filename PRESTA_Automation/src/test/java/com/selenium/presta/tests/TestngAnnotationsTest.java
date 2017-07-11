package com.selenium.presta.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.selenium.presta.CommonCode;
import com.selenium.presta.Configuration;
import com.selenium.presta.Home;
import com.selenium.presta.LoginPage;
import com.selenium.presta.MyAccount;
import com.selenium.presta.ReadExcel;

public class TestngAnnotationsTest {

	public WebDriver driver = Configuration.browser();
	public LoginPage login;
	public Home home;
	public CommonCode commons;
	public MyAccount account;
	public ReadExcel read;

	public TestngAnnotationsTest() {

		read = new ReadExcel();
		login = new LoginPage();
		home = new Home();
		commons = new CommonCode();
		account = new MyAccount();
	}

	@BeforeClass(alwaysRun = true)
	public void invokeURL() {

		driver.manage().window().maximize();
		driver.get(Configuration.LoginURL());

	}

	@BeforeMethod(alwaysRun = true)
	public void login() {
		home.login();
		login.emailaddress(read.readData("Email"));
		login.password(read.readData("password"));
		login.login();
		System.out.println("Before Method loggedin");

	}

	@AfterMethod(alwaysRun = true)
	public void HomePage() {
		try {
			Thread.sleep(3000);
		
		home.navigate_to_Home();
		Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account.clickLogout();

	}

	@AfterSuite(alwaysRun = true)
	public void CloseBrowser() {
		driver.quit();

	}
}
