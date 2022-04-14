package CommPageObjects;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage{


	//Buttons
	By userRoleSelect = By.id("login-form-user-select");
	By loginHolder=By.xpath(".//*[@id=\"app\"]/div/div[1]/div/div/div/form/button");
	By logoutIcon=By.id("header-user-menu-trigger");
	By logoutHolder=By.id("user-menu-logout");
	By commHome = By.id("home-cta-database-management-path");
	By loginPage = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div/div/h1");
	By usernameField=By.id("login-form-user-name");
	By passwordField=By.id("login-form-user-password");
	By loginButton=By.id("login-form-submit");


	/**
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
		visit("");
	}


	/**
	 * Allows user to login based on selected role
	 * @param String - User to login 
	 */    
	public void selectUserAndLogin(String user) {
		InputStream fStream = null;
		Properties loginProperties = new Properties();
		String user_name=null;
		String password = null;

		fStream = getClass().getClassLoader().getResourceAsStream("UsernameProperties");
		try {
			loginProperties.load(fStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user=="admin") {
			user_name = loginProperties.getProperty("USERNAME_ADMIN");
			password = loginProperties.getProperty("PASSWORD_ADMIN");
		}
		else if(user=="engineer") {
			user_name = loginProperties.getProperty("USERNAME_ENGINEER");
			password = loginProperties.getProperty("PASSWORD_ENGINEER");
		}
		else if (user=="DB") {
			user_name = loginProperties.getProperty("USERNAME_DB");
			password = loginProperties.getProperty("PASSWORD_DB");
		}
		
		slowDown(1);
		assertTrue("Username field is missing ",isDisplayed(usernameField,200));
		click(usernameField);
		type(user_name,usernameField);
		type(password,passwordField);
		assertTrue("login Button  is missing ",isDisplayed(loginButton,200));
		click(loginButton);
		slowDown(2);
	}

	/**
	 * Allows user to logout from any given page
	 */
	public void logout(){
		isDisplayed(logoutIcon);
		assertTrue("logoutIcon is missing ",isDisplayed(logoutIcon,200));
		click(logoutIcon);
		assertTrue("logoutIcon is missing ",isDisplayed(logoutHolder,200));
		clickJS(logoutHolder);
		assertTrue("can't find the login fields ",isDisplayed(usernameField,150));

	}

}
