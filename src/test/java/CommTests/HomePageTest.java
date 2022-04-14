package CommTests;

import CommPageObjects.RadioDataBasePage;
import CommPageObjects.BasePage;
import CommPageObjects.AntennaDataBasePage;
import CommPageObjects.HomePage;
import CommPageObjects.LoginPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by nshaji 
 */
public class HomePageTest extends BaseTest{
	private HomePage homePage;
	private AntennaDataBasePage database;
	private RadioDataBasePage rdatabase;
	private LoginPage loginPage;
	private BasePage basePage;


	@Before
	public void Setup() {

		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		rdatabase = new RadioDataBasePage(driver);
		database = new AntennaDataBasePage(driver);
		basePage =new BasePage(driver);
		loginPage.selectUserAndLogin("admin"); 
	}

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);


	/**
	 * LEGO-1884 : AUTO UI : UI: Lego Home Page LEGO-1666
	 * 
	 */
	@Test
	public void legoHomePage_NoElementsShouldBeMissing_VerifyElementsPresent() {
		homePage.evaluateLinksAndButtonsInHomePage();
		database.accessAntennaDataBase();
		basePage.goBack();
		rdatabase.accessRadioDataBase();
		basePage.goBack();

	}
	/**
	 * LEGO-2981 : Auto UI: Integrate Interactive Solutions link LEGO-2866
	 */
	@Test
	public void legoHomePage_shouldNotBeMissing_VerifyPresenceOfCISLink() {
		homePage.verifyCISLink();
	}
	
	@After
	public void tearDown() {
		BasePage.quit();
	}
}


