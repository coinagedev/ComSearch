package CommTests;

import CommPageObjects.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import static org.junit.Assert.assertTrue;

public class RadioDataBaseTest extends BaseTest {
	private AntennaDataBasePage database;
	private RadioDataBasePage rdatabase;
	private LoginPage loginPage;

	@Before
	public void Setup() {
		database = new AntennaDataBasePage(driver);
		rdatabase = new RadioDataBasePage(driver);
		loginPage = new LoginPage(driver);
		loginPage.selectUserAndLogin("admin");

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);
	String radioCode = "300136";
	String analogRadioCode = "2V4H01";

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	@Test
	public void radioDataBase_theRadioDatabasePageShouldOpen_whenNavigatingToRadioDataBase() {
		rdatabase.accessRadioDataBase();
	}

	/*
	 * LEGO-1638 :(AUTO UI) Implement Radio Search Auto- suggests -LEGO-672
	 * (Commenting out this test; ELSE THIS TEST WILL FAIL BECAUSE OF THE DATA ISSUE
	 * IN STAGING AND SANDBOX- MODEL FAMILY AND MODEL; AND POSSIBLY BECAUSE OF
	 * PERFORMANCE ISSUES) REVISIT THIS SECTION WHEN THE DATA ISSUE OR PERFORMANCE
	 * BUG IS FIXED
	 */
	@Test
	public void radioDataBaseSearchRadio_EnterTheFirstThreeDigitsOfTheManufacturer_verifyOtherBasicSearches() {
		rdatabase.accessRadioDataBase();
		rdatabase.radioBasicSearch_BasicSearchValidation();
	}

	// LEGO-1766
	/*
	 * LEGO-1758: (AUTO UI) Create and save new radios LEGO-775
	 */
	/*
	 * LEGO-1729: (AUTO UI) Delete existing radios LEGO-771
	 */
	/*
	 * LEGO-1887: (AUTO UI): Ability to edit existing radios LEGO-1785
	 */
	@Test
	public void createNewRadio_EditCreatedRadio_VerifyRadioDelete() {
		String lowFreq = "10700";
		String highFreq = "11700";
		rdatabase.accessRadioDataBase();
		String radioCode = rdatabase.createNewRadioInRadioDatabase_VerifySave(lowFreq, highFreq);
		rdatabase.editExistingRadioInRadioDatabase_VerifySave(radioCode, "T2", "128 QAM", "30", "100", "60M0D7W", "30");
		rdatabase.deleteRadioFromRadioDatabase(radioCode);
	}

	/*
	 * LEGO-1721:(AUTO UI) Create Radio Details Base Form and Validations - Main
	 * Form LEGO-771
	 */
	/*
	 * LEGO-1722: (AUTO UI) Create Radio Details Base Form and Validations -Basic
	 * Information- LEGO-771
	 */
	@Test
	public void radioDatabaseFieldValidation_RadoDetailsBasicInformation_FieldValidation() {
		rdatabase.accessRadioDataBase();
		rdatabase.clickCreateRadioButton();
		rdatabase.basicInformationRadioFormFieldValidation();
	}

	/*
	 * LEGO-1724- (AUTO UI) Create Radio Details Base Form and Validations
	 * -Technical Information- LEGO-771
	 */
	@Test
	public void radioDatabaseFieldValidation_RadioDetailsTechnicalInformation_FieldValidation() {
		rdatabase.accessRadioDataBase();
		rdatabase.clickCreateRadioButton();
		rdatabase.technicalInformationRadioFormFieldValidation();
	}

	/*
	 * LEGO-1725: (AUTO UI) Automatic Transmit Power Control LEGO-771
	 */
	@Test
	public void radioDataBase_RadioDetailsATPC_ATPCValidation() {
		rdatabase.accessRadioDataBase();
		rdatabase.clickCreateRadioButton();
		rdatabase.radioDetailsATPCValidation();
	}

	/*
	 * LEGO-1726: (AUTO UI) Modulation Information LEGO-771
	 */
	@Test
	public void radioDataBase_RadioDetailsModulation_VerifyModulationIformation() {
		rdatabase.accessRadioDataBase();
		rdatabase.clickCreateRadioButton();
		rdatabase.radioDetailsModulationInformationValidation();
	}

	/*
	 * LEGO-1727: (AUTO UI) Channel Restrictions LEGO-771
	 */
	@Test
	public void radioDataBase_RadioDetailsChannel_VerifyChannelRestriction() {
		rdatabase.accessRadioDataBase();
		rdatabase.clickCreateRadioButton();
		rdatabase.radioDetailsChannelRestrictionValidation();
	}

	/*
	 * LEGO-1641(AUTO UI) UI: Radio Comments- LEGO-774 rewritten by @author nshaji
	 * LEGO-8157 : QA AUTO LEGO-8009: UI: Ability to delete attachments across the
	 * whole application
	 */
	@Test
	public void radioDataBase_addCommentaddAttachment_CheckCommentsAppearsOnTheList() {
		String lowFreq = "10700";
		String highFreq = "11700";
		rdatabase.accessRadioDataBase();
		rdatabase.createRadio(lowFreq, highFreq);
		rdatabase.openComments();
		rdatabase.enterComments("This comment field is new can be used for lots of comments");
		if (host.equals("cloud")) {
		} else {
			rdatabase.selectAndUploadFile("commentattachment.txt");
			rdatabase.evaluateAttachmentList(0, "commentattachment.txt");
		}
		rdatabase.evaluateCommentPresence();
		rdatabase.deleteAttachment();
		rdatabase.clickDeleteRadio();
	}

	/*
	 * LEGO-1594: Radio Database Search Fields. LEGO-669
	 */
	@Test
	public void radioDataBaseSearchRadio_BasicAndAdvanceSearchScreen_FieldValidation() {
		rdatabase.accessRadioDataBase();
		rdatabase.checkSearcFieldsInRadioDataBase();
	}

	/**
	 * LEGO-1856 (AUTO UI/UX) Radio DB Search to render based on user role LEGO-671
	 * LEGO-1757 (AUTO UI) UI: Radio Details - Rendering based on user role LEGO-781
	 */
	@Test
	public void radioDataBaseSearchRadio_createButtonWillAppear_BasedOnUserRole() {
		// access radio database as admin user role
		rdatabase.accessRadioDataBase();
		rdatabase.evaluateCreateButtonIsPresent();

		// access radio database as engineering user role
		loginPage.logout();
		loginPage.selectUserAndLogin("engineer");
		rdatabase.accessRadioDataBase();
		rdatabase.evaluateCreateButtonIsNotPresent();

		// access radio database as database user role
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		rdatabase.accessRadioDataBase();
		rdatabase.evaluateCreateButtonIsPresent();
	}

	/**
	 * LEGO-1857 (AUTO UI) UI/UX: Radio Database Search Results Table - LEGO-670
	 */
	@Test
	public void radioDataBaseSearchRadio_EnterAdvnaceSearchFields_CheckForResults() {
		rdatabase.accessRadioDataBase();
		rdatabase.searchRadioDatabase("", "ABE Elettronica", "", "", "", "");
		rdatabase.advanceSearchInRadioDatabase("", "", "QPSK", "20");
		rdatabase.checkColumnNamesInSearchResultTable();
		rdatabase.checkForRadioCodeAscend();
		rdatabase.checkForRadioCodeDescend();
		rdatabase.checkForRadioModelAscend();
		rdatabase.checkForRadioModelDescend();
		rdatabase.checkForRadioPowerAscend();
		rdatabase.checkForRadioPowerDescend();
		rdatabase.checkForRadioThresholdAscend();
		rdatabase.checkForRadioThresholdDescend();
		rdatabase.checkForRadioFreqAscend();
		rdatabase.checkForRadioFreqDescend();
		rdatabase.checkForRadioSpecDateAscend();
		rdatabase.checkForRadioSpecDateDescend();
	}

	/**
	 * LEGO-1728:(AUTO UI) Bottom Navigation Bar LEGO-771 LEGO-1757 : Radio Details
	 * - Rendering based on user role create, update, delete when logged in as admin
	 */
	@Test
	public void createNewRadio_EditCreatedRadio_VerifyBottomNNavigationBar() {
		String lowFreq = "10700";
		String highFreq = "11700";
		rdatabase.accessRadioDataBase();
		String radioCode = rdatabase.createNewRadioInRadioDatabase_VerifySave(lowFreq, highFreq);
		rdatabase.editExistingRadioInRadioDatabase_VerifySave(radioCode, "T2", "128 QAM", "30", "100", "60M0D7W", "30");
		rdatabase.verifyBottomNavigationBar("default_admin");
		rdatabase.deleteRadioFromRadioDatabase(radioCode);
	}

	/**
	 * LEGO-2977 : AUTO UI: Give user a modal to change the radio code before
	 * completing the Copy LEGO-2792 LEGO-1757 : copy as admin user
	 */

	@Test
	public void radioDatabase_CopyRadio_VerifyRadioCodeChangeModal() {
		rdatabase.accessRadioDataBase();
		rdatabase.searchRadioDatabase(radioCode, "", "", "", "", "");
		rdatabase.clickSearchResultsFromRadioDatabaseSearch();
		rdatabase.copyRadio();
		String newCopiedRadioCode = rdatabase.verifyCopyRadioModal();
		rdatabase.clickCreateRadioButtonInCopyModal();
		rdatabase.verifyCopyMessage("COPY SUCCESS");
		database.clickPage();
		rdatabase.clickSaveButton();
		database.clickPage();
		rdatabase.clickReturnRadioDetails();
		rdatabase.searchRadioDatabase(newCopiedRadioCode, "", "", "", "", "");
		rdatabase.clickSearchResultsFromRadioDatabaseSearch();
		rdatabase.deleteCopiedRadio();
	}

	/**
	 * LEGO-2979 : AUTO UI: Show required fields upon opening a form (update all
	 * input components to display errors when pristine)LEGO-2753 RadioDetails form
	 * Modulation Form
	 * 
	 */

	@Test
	public void radioDatabase_radioDetailsForm_VerifyRequiredFields() {
		rdatabase.accessRadioDataBase();
		rdatabase.clickCreateRadioButton();
		rdatabase.verifyRadioDetailsInRadioDatabase();
		rdatabase.clickAddModulationOnRadioDetails();
		rdatabase.verifyRadioDetailsModulationFormInRadioDB();
		rdatabase.closeAddRadioModulationForm();

	}

	/**
	 * LEGO-1757 : (AUTO UI) UI: Radio Details - Rendering based on user role
	 * LEGO-781 Database user can create edit delete
	 */
	@Test
	public void createNewRadio_EditCreatedRadio_VerifyBottomNNavigationBarAsBDuser() {
		String lowFreq = "10700";
		String highFreq = "11700";
		rdatabase.accessRadioDataBase();
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		rdatabase.accessRadioDataBase();
		rdatabase.evaluateCreateButtonIsPresent();
		String radioCode1 = rdatabase.createNewRadioInRadioDatabase_VerifySave(lowFreq, highFreq);
		rdatabase.editExistingRadioInRadioDatabase_VerifySave(radioCode1, "T2", "128 QAM", "30", "100", "60M0D7W",
				"30");
		rdatabase.verifyBottomNavigationBar("test_database");
		rdatabase.deleteRadioFromRadioDatabase(radioCode1);
	}

	/**
	 * LEGO-1757 : (AUTO UI) UI: Radio Details - Rendering based on user role
	 * LEGO-781 Database user can create edit delete
	 */
	@Test
	public void createNewRadio_EditCreatedRadio_VerifyBottomNNavigationBarAsEngineerUser() {
		rdatabase.accessRadioDataBase();
		loginPage.logout();
		loginPage.selectUserAndLogin("engineer");
		rdatabase.accessRadioDataBase();
		rdatabase.evaluateCreateButtonIsNotPresent();
		rdatabase.searchRadioDatabase("M18L21", "", "", "", "", "");
		rdatabase.clickResultsRadioDB();
		rdatabase.verifySaveButtonNotPresent();
		rdatabase.verifyDeleteButtonNotPresent();
	}

	/**
	 * LEGO-8002 : QA AUTO UI - 70-90 Legacy Radio Codes for modulations LEGO-7901
	 */
	@Test
	public void createRadio_7090Radio_verifyLegacyRadioCode() {
		String lowFreq = "71000";
		String highFreq = "81000";
		rdatabase.accessRadioDataBase();
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		rdatabase.accessRadioDataBase();
		rdatabase.evaluateCreateButtonIsPresent();
		rdatabase.clickCreateRadioButton();
		rdatabase.fillInHighAndLowFrequency(lowFreq, highFreq);
		rdatabase.clickAddModulationOnRadioDetails();
		rdatabase.verifyLegacyRadioCodeFor7090Radio();

	}

	/**
	 * LEGO-8123 : QA AUTO UI: Validate Radio Modulation Emission Designator
	 * LEGO-7805
	 */
	@Test
	public void createRadio_emissionDesignator_verifyEmissionDesignator() {
		String lowFreq = "10700";
		String highFreq = "11700";
		String emissionError = "Alphanumeric characters except I, O, S, U, Y, Z of length between 3-5 or 7-9.";
		rdatabase.accessRadioDataBase();
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		rdatabase.accessRadioDataBase();
		rdatabase.evaluateCreateButtonIsPresent();
		rdatabase.clickCreateRadioButton();
		rdatabase.fillInHighAndLowFrequency(lowFreq, highFreq);
		rdatabase.clickAddModulationOnRadioDetails();
		rdatabase.verifyEmissionDesignator("N0", emissionError);
		rdatabase.verifyEmissionDesignator("123I30", emissionError);
		rdatabase.verifyEmissionDesignator("123O123458", emissionError);
		rdatabase.verifyEmissionDesignator("123S567", emissionError);

	}

	/**
	 * LEGO-8159 : QA AUTO LEGO-8072: UI: Analog Modulations - throughput must be
	 * null LEGO-7502 : QA AUTO UI: Radio Details - Modulation Details: Add Legacy
	 * Radio Code input field LEGO-7121
	 */
	@Test
	public void searchRadio_analogRadio_verifyThroughputIsNull() {
		rdatabase.accessRadioDataBase();
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		rdatabase.accessRadioDataBase();
		rdatabase.searchRadioDatabase(analogRadioCode, "", "", "", "", "");
		rdatabase.clickSearchResultsFromRadioDatabaseSearch();
		rdatabase.clickExistingModulationOnRadioDetails();
		rdatabase.verifyThroughputForAnalogRadio();
	}

	/**
	 * LEGO-8023 : QA AUTO UI : Radio Filter Reference Code: Last modulation curve
	 * set overrides other modulations LEGO-1937
	 * 
	 */
	@Test
	public void searchRadio_filterReferenceCode_verifyRefrenceCodeOverridesModulation() {
		String offsetValue = "-300";
		String radioCode1 = "M23003";
		rdatabase.accessRadioDataBase();
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		rdatabase.accessRadioDataBase();
		rdatabase.searchRadioDatabase(radioCode1, "", "", "", "", "");
		rdatabase.clickSearchResultsFromRadioDatabaseSearch();
		rdatabase.clickExistingModulationOnRadioDetails(0);
		String exixtingOffset = rdatabase.typeOFfSet(offsetValue);
		rdatabase.clickExistingModulationOnRadioDetails(0);
		rdatabase.verifyOffset(offsetValue);
		String filterRefCode = rdatabase.getFilterReferenceCodeAndApplySaveModulation();
		rdatabase.clickSaveButton();
		rdatabase.clickBlankPage();
		rdatabase.clickReturnFromRadioDetailsPage();
		rdatabase.clickClearOnRadioDatabaseSearchWindow();
		rdatabase.SearchByFilterReferenceCode(filterRefCode);
		rdatabase.clickExistingModulationOnRadioDetails(0);
		rdatabase.verifyOffset(offsetValue);
		rdatabase.resetOFfSet(exixtingOffset);
		rdatabase.saveModulationAndSaveRadio();
		rdatabase.verifyRadioUpdateMessage();
	}

	/**
	 * LEGO-7503 :QA AUTO UI: Radio Details - Radio Favorites Modal LEGO-7122
	 */
	@Test
	public void searchRadio_radioFaviorites_verifyRadioFavoritesModal() {
		String radioCode2 = "M06101";
		String MaxPower = "29.5 (dBm)";
		String legacyCode = "X06101";
		rdatabase.accessRadioDataBase();
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		rdatabase.accessRadioDataBase();
		rdatabase.searchRadioDatabase(radioCode2, "", "", "", "", "");
		rdatabase.clickSearchResultsFromRadioDatabaseSearch();
		rdatabase.clickRadioFavorites();
		rdatabase.verifyRadioFavoriteModalValues(MaxPower, legacyCode);

	}

	/**
	 * LEGO-7502 : QA AUTO UI: Radio Details - Modulation Details: Add Legacy Radio
	 * Code input field LEGO-7121
	 */
	@Test
	public void searchRadio_legacyRadioCode_verifyLegacyRadioCode() {
		String radioCode = "M23003";
		String legacyCodeM23003 = "TEMO87";
		rdatabase.accessRadioDataBase();
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		rdatabase.accessRadioDataBase();
		rdatabase.searchRadioDatabase(radioCode, "", "", "", "", "");
		rdatabase.clickSearchResultsFromRadioDatabaseSearch();
		rdatabase.clickExistingModulationOnRadioDetails(0);
		rdatabase.verifyLegacyRadioCode(legacyCodeM23003);

	}

	/**
	 * LEGO-7774 : QA AUTO UI Add errors list to radio details LEGO-7558
	 */
	@Test
	public void searchRadio_modulationLimit_verifyErrorListDisplays() {
		String radioCode = "M06883";
		String limit = "4";
		rdatabase.accessRadioDataBase();
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		rdatabase.accessRadioDataBase();
		rdatabase.searchRadioDatabase(radioCode, "", "", "", "", "");
		rdatabase.clickSearchResultsFromRadioDatabaseSearch();
		rdatabase.setModulationLimit(limit);
		rdatabase.clickSave();
		rdatabase.verifyErrorList();
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
