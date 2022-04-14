package CommTests;

import CommPageObjects.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class ModelFamilyAdditionAntennaDBTest extends BaseTest {
	private AntennaDataBasePage database;
	private BasePage basePage;
	private LoginPage loginPage;

	@Before
	public void Setup() {

		database = new AntennaDataBasePage(driver);
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
	 * LEGO-704 or COM-709: UI Add Model Family addition workflow UI in Antenna
	 * Details
	 */
	@Test
	public void addModelFamily_AntennaDatabase_ModelFamilyNameValidation() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.openModelFamily();
		database.createNewAntennaModelFamily_validateSave(randomNumber,
				"The Model Family name you have entered already exists.");
		String existingFamilyRow1 = database.getAnExistingSaveModelFamily();
		database.validateExistingModelFamily(existingFamilyRow1,
				"The Model Family name you have entered already exists.");
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}

}
