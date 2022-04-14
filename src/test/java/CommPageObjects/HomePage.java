package CommPageObjects;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

	private static final String CIS_LINK_IN_COMSEARCH_CONNECT = "https://solutions.qa.comsearchaws.com/";

	//Links menu bar
	By homeLinkMenuBar = By.id("header-menu-home");
	By projectsLinkMenuBar = By.id("header-menu-projects-list");
	By databasesLinkMenuBar=By.id("header-database-management-menu-trigger");
	By pcnRenewalsLinkMenuBar=By.id("header-menu-pcn-renewals");
	By threeDotsMenuBar=By.id("header-user-menu-trigger");
	By usernameMenuBar = By.id("header-user-username");
	By logOutMenuBar = By.id("user-menu-logout");
	By interactiveSolutionsLinkMenuBar = By.id("user-menu-interactive-solutions");

	By pathLinkMenuBar=By.id("header-menu-database-management-path");
	By antennaLinkMenuBar=By.id("header-menu-database-management-antenna");
	By radioLinkMenuBar=By.id("header-menu-database-management-radio");

	//Database Management Links
	By pathLink=By.id("home-cta-database-management-path");
	By antennaLink=By.id("home-cta-database-management-antenna");
	By radioLink=By.id("home-cta-database-management-radio");

	By pcnRenewalsLink=By.xpath(".//a[@id='home-cta-pcn-renewals']/img");
	By pcnPageText=By.xpath(".//*[@id='app']/div/div[1]/div/div[3]/h1");
	By projectManagementLink=By.xpath(".//*[@id='home-cta-project-management']/h1");

	By newProjectButton=By.id("new-project-modal-trigger");


	/**
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		visit("/");
	}

	/**
	 * This method verifies all the elements in the home page
	 */
	public void evaluateLinksAndButtonsInHomePage() {
		assertTrue("Home Link in the menu bar is not present", isDisplayed(homeLinkMenuBar, 5));
		assertTrue("Projects Link in the menu bar is not present", isDisplayed(projectsLinkMenuBar, 5));
		assertTrue("Databases Link in the menu bar is not present", isDisplayed(databasesLinkMenuBar, 5));
		assertTrue("User name in menu bar is not present", isDisplayed(usernameMenuBar, 5));
		assertTrue("Three Dots icon in the menu bar is not present", isDisplayed(usernameMenuBar, 5));
		click(threeDotsMenuBar);
		assertTrue("Logout Link under dots icon in the menu bar is not present", isDisplayed(logOutMenuBar, 20));
		assertTrue("Interactive Solutions Link under dots icon in the menu bar is not present", isDisplayed(interactiveSolutionsLinkMenuBar, 5));
		click(databasesLinkMenuBar);
		assertTrue("Path Link in the home page is not present", isDisplayed(pathLink, 5));
		assertTrue("Antenna Link in the home page is not present", isDisplayed(antennaLink, 5));
		assertTrue("Radio Link in the home page is not present", isDisplayed(radioLink, 5));
		
	}

	/**
	 * This method verify CIS link
	 */
	public void verifyCISLink() {
		assertTrue("Home Link in the menu bar is not present", isDisplayed(homeLinkMenuBar, 5));
		assertTrue("Projects Link in the menu bar is not present", isDisplayed(projectsLinkMenuBar, 5));
		assertTrue("Threedots icon in the right corder of the menu bar is not present", isDisplayed(threeDotsMenuBar, 15));
		clickJS(threeDotsMenuBar);
		assertTrue("Interactive Solutions Link in Menu Bar is not present", isDisplayed(interactiveSolutionsLinkMenuBar, 30));
		click(interactiveSolutionsLinkMenuBar);
		slowDown(1);
		assertEquals(getHref(interactiveSolutionsLinkMenuBar),CIS_LINK_IN_COMSEARCH_CONNECT);



	}
	
	/**
	 * This method clicks the home menu link
	 */
	public void clickHomeMenuLink() {
		slowDown(3);
		assertTrue("Home Link in the menu bar is not present", isDisplayed(homeLinkMenuBar, 5));
		click(homeLinkMenuBar);
	}

}
