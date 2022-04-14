package CommTests;

import CommPageObjects.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class ModelFamilyAdditionRadioDBTest extends BaseTest {
	private AntennaDataBasePage database;
	private BasePage basePage;
	private LoginPage loginPage;
	private RadioDataBasePage radioPage;

	@Before
	public void Setup() {

		database = new AntennaDataBasePage(driver);
		radioPage = new RadioDataBasePage(driver);
		basePage = new BasePage(driver);
		loginPage = new LoginPage(driver);
		loginPage.selectUserAndLogin("admin");

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/*
	 * This particular test should NEVER be run on actual PRODUCTION, since we
	 * cannot delete the model families we create
	 */
	/*
	 * LEGO-1723: (AUTO UI) Create Radio Details Base Form and Validations -Add
	 * Model Families- LEGO-771
	 */
	@Test
	public void addModelFamily_RadioDatabase_ModelFamilyNameValidation() {
		radioPage.accessRadioDataBase();
		radioPage.clickCreateRadioButton();
		radioPage.openModelFamily();
		radioPage.createNewRadioModelFamily_validateSave(randomNumber,
				"The Model Family name you have entered already exists.");
		String existingFamilyRow1 = radioPage.getAnExistingSaveModelFamily();
		radioPage.validateExistingModelFamily(existingFamilyRow1,
				"The Model Family name you have entered already exists.");
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
