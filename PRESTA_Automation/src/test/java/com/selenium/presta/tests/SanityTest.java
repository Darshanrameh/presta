package com.selenium.presta.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.presta.CommonCode;
import com.selenium.presta.MyAccount;

public class SanityTest extends TestngAnnotationsTest {
	public MyAccount account;

	public SanityTest() {

		commons = new CommonCode();
		account = new MyAccount();
	}

	@Test(testName = "login_Positive", description = "login_Positive", timeOut = 190000, enabled = true, groups = {
			"sanity", "1" })
	public void alogin_Positive() {
		Assert.assertTrue(true);

	}

	@Test(testName = "login_Negative", description = "login_Negative", timeOut = 190000, enabled = true, groups = {
			"sanity", "2" })
	public void login_Negative() {

		account.ifLogoutExists();
		home.login();
		login.emailaddress(read.readData("InvalidEmail"));
		login.password(read.readData("password"));
		login.login();
		Assert.assertEquals(read.readData("Login_Error"),
				login.invalidEmailAddress(),
				"Invalid email address test case failed");
		home.login();
		login.emailaddress(read.readData("Email"));
		login.password(read.readData("password"));
		login.login();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(testName = "searchProduct", description = "searchProduct", timeOut = 190000, enabled = true, groups = {
			"sanity", "3" })
	public void searchProduct() {
		account.verifyProduct(read.readData("Product_ipod"),
				read.readData("ResultsDisplayed"), read.readData("iPod"));

	}

	@Test(testName = "add2Cart", description = "add2Cart", timeOut = 190000, enabled = true, groups = {
			"sanity", "4" })
	public void add2Cart() {
		account.cartData(read.readData("Product_ipod"),
				read.readData("ResultsDisplayed"), read.readData("iPod"),
				read.readData("Shoppingcartsummary"),
				read.readData("CartEmpty"));
	}

	@Test(testName = "deleteFromCart", description = "deleteFromCart", timeOut = 190000, enabled = true, groups = {
			"sanity", "5" })
	public void deleteFromCart() {
		account.deleteFromCart(read.readData("Product_ipod"),
				read.readData("ResultsDisplayed"), read.readData("iPod"),
				read.readData("Shoppingcartsummary"),
				read.readData("CartEmpty"));
	}

	@Test(testName = "addtoAddress", description = "addtoAddress", timeOut = 190000, enabled = true, groups = {
			"sanity", "6" })
	public void addtoAddress() {
		account.cartAddress(read.readData("Product_ipod"),
				read.readData("ResultsDisplayed"), read.readData("iPod"),
				read.readData("Shoppingcartsummary"));
	}

	@Test(testName = "cartShipping", description = "cartShipping", timeOut = 190000, enabled = true, groups = {
			"sanity", "7" })
	public void cartShipping() {
		account.cartShipping(read.readData("Product_ipod"),
				read.readData("ResultsDisplayed"), read.readData("iPod"),
				read.readData("Shoppingcartsummary"));
	}

	@Test(testName = "cartPayMent", description = "cartPayMent", timeOut = 190000, enabled = true, groups = {
			"sanity", "8" })
	public void cartPayMent() {
		account.cartPayMent(read.readData("Product_ipod"),
				read.readData("ResultsDisplayed"), read.readData("iPod"),
				read.readData("Shoppingcartsummary"), read.readData("iPod"),
				read.readData("ProductAmount"));
	}

	@Test(testName = "cartSubmission", description = "cartSubmission", timeOut = 190000, enabled = true, groups = {
			"sanity", "9" })
	public void cartSubmission() {
		account.cartSumbission(read.readData("Product_ipod"),
				read.readData("ResultsDisplayed"), read.readData("iPod"),
				read.readData("Shoppingcartsummary"), read.readData("iPod"),
				read.readData("ProductAmount"));
	}

}
