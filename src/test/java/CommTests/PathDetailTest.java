package CommTests;

import CommPageObjects.QuickAddPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.TerrAnalysisResultsAFSPage;
import CommPageObjects.AntennaDataBasePage;
import CommPageObjects.BasePage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.PathDetailAntennaPage;
import CommPageObjects.PathDataBasePage;
import CommPageObjects.BasePage.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

/**
 * Created by ehend on 2/25/2017.
 */
public class PathDetailTest extends BaseTest {
	private QuickAddPage quickAdd;
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private PathDetailPage pathDetail;
	private PathDetailAntennaPage pathDetailAnt;
	private LoginPage loginPage;
	private AntennaDataBasePage database;
	private TerrAnalysisResultsAFSPage analysis;
	private PathDataBasePage pathDBpage;
	private static final String BAND_DESCRIPTION_DOT_NINEFOUR = "0.94 GHz (944-952 MHz) US";
	private static final String BAND_DESCRIPTION_ELEVEN = "11 GHz (10700-11700 MHz) US";
	private static final String BAND_DESCRIPTION_FIVE_DOT_EIGHT = "5.8 GHz (5725-5850 MHz) US";
	private static final String BAND_DESCRIPTION_DOT_NINETHREE = "0.93 GHz (932.5-944 MHz) US";
	private static final String BAND_DESCRIPTION_SIX_DOT_ONE = "6.1 GHz (5925-6425 MHz) US";
	private static final String CALLSIGN1 = "KA20003";
	private static final String CALLSIGN2 = "RXONLY";
	private static final String COMPANYCODE = "LOUCOU";
	private static final String COMPANYCODE2 = "SPRSPE";
	private static final String MANUFACTURERNAME = "Loudoun, County of";
	private static final String MANUFACTURERNAME_PARTIAL = "Lou";
	private static final String LATITUDE1 = "40 44 54.0 N";
	private static final String LONGITUDE1 = "73 59 09.0 W";
	private static final String LATITUDE2 = "40 42 46.8 N";
	private static final String LONGITUDE2 = "74 00 47.3 W";
	private static final String LATITUDE4 = "35 12 26.4 N";
	private static final String LONGITUDE4 = "78 3 21.3 W";
	private static final String LATITUDE5 = "35 12 26.5 N";
	private static final String LONGITUDE5 = "78 3 20.2 W";
	private static final String LATITUDE6 = "34 37 42.1 N";
	private static final String LONGITUDE6 = "112 39 26.2 W";
	private static final String LONGITUDE7 = "112 39 25.2 W";
	private static final String ELEVATION1 = "14";
	private static final String ELEVATION2 = "6.62";
	private static final String ELEVATION3 = "47.67";
	private static final String ELEVATION4 = "5280";
	private static final String ASR1 = "1007048";
	private static final String ASR3 = "1261154";
	private static final String ASR4 = "1236600";
	private static final String SEARCH_RADIUS = "1";
	private static final String EXISTINGSITE_PARTIAL = "Bluemo";
	private static final String EXISTINGSITE_LAT = "39 08 16.4 N";
	private static final String EXISTINGSITE_LONG = "77 49 57.6 W";
	private static final String EXISTINGSITE_ELEV = "1349.08";
	private static final String LATITUDE8 = "39 08 17.0 N";
	private static final String LONGITUDE8 = "77 49 56.6 W";
	private static final String ELEVATION8 = "1349.08";
	private static final String RCN = "19091058";
	private static final String JOB_NUMBER = "190910COMSDS03";
	private static final String CONTACT_CODE = "VIASAT";
	private static final String CALLSIGN3 = "WRDQ990";
	private static final String LONGITUDE9 = "95 47 5.9 W";
	private static final String LATITUDE9 = "44 25 3 N";
	private static final String RCN1 = "19110466";
	private static final String COMPANYCODE3 = "P9026";
	private static final String MANUFACTURERNAME3 = "sprint";
	private static final String RCN2 = "20071745";

	private static final String RADIO_CODE = "M09002";
	private static final String COORD_POWER1 = "38";
	private static final String COORD_POWER2 = "26";
	private static final String COORD_POWER3 = "33";
	private static final String MAX_POWER = "37";
	private static final String LOWEST_POWER = "34";

	private static final String CONTACT_CODE1 = "ADGENM";
	private static final String COMPANY_NAME1 = "ADVANCED GENERATION TELECOM GROUP INC";
	private static final String HEADING_DRAWER = "Validation Error while updating path";
	private static final String HEADING_DRAWER1 = "The following warnings were returned";

	@Before
	public void Setup() {
		createPath = new CreateNewPathPage(driver);
		quickAdd = new QuickAddPage(driver);
		pathSummary = new PathSummaryPage(driver);
		pathDetail = new PathDetailPage(driver);
		pathDetailAnt = new PathDetailAntennaPage(driver);
		loginPage = new LoginPage(driver);
		analysis = new TerrAnalysisResultsAFSPage(driver);
		database = new AntennaDataBasePage(driver);
		pathDBpage = new PathDataBasePage(driver);
		loginPage.selectUserAndLogin("admin");
		if (host != "localhost") {
			driver.manage().window().maximize();
		}

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * COM-316,COM-322 : Site Lookup
	 */

	@Test
	public void pathDetailSiteSearch_searchResultsShouldContainAppropriateSite_whenSearchingBySiteName() {
		createPath.createBrandNewProjectPath("Path Detail Site look up search" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToUs();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.siteSearch1("New York", "KA20003", "", LATITUDE1, LONGITUDE1, "-");
		// so you get the max number of rows
		int rows = pathDetail.getRows();
		// Then loop through and do your check
		for (int i = 0; i < rows; i++) {
			// try and catch would be inside the for loop
			try {
				pathDetail.siteSearchResults(0, "New York", CALLSIGN1, "-", "9 26 42.7 N", "8 7 9 W", "-");
				break;
			} catch (org.junit.ComparisonFailure failure) {
				// in the catch you would check to see if there are any more rows left.
				if (i >= rows) {
					throw failure;
				}
			}
		}
		pathDetail.closeSiteLookup();
		pathDetail.siteSearch2("New York", CALLSIGN1, "", LATITUDE1, "", "");
		// so you get the max number of rows
		rows = pathDetail.getRows();
		// Then loop through and do your check
		for (int i = 0; i < rows; i++) {
			// try and catch would be inside the for loop
			try {
				pathDetail.siteSearchResults(0, "New York", CALLSIGN1, "-", "9 26 42.7 N", "8 7 9 W", "-");
				break;
			} catch (org.junit.ComparisonFailure failure) {
				// in the catch you would check to see if there are any more rows left.
				if (i >= rows) {
					throw failure;
				}
			}
		}
	}

	@Test
	public void pathDetailSiteSearch_searchResultsShouldContainAppropriateSite_whenSearchingBySiteNameAndCallSign() {
		createPath.createBrandNewProjectPath("Path Detail Site look up search" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToUs();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.siteSearch1("New York", CALLSIGN1, "", "", "", "");
		int rows = pathDetail.getRows();
		// Then loop through and do your check
		for (int i = 0; i < rows; i++) {
			// try and catch would be inside the for loop
			try {
				pathDetail.siteSearchResults(0, "New York", CALLSIGN1, "-", LATITUDE1, LONGITUDE1, "-");
				break;
			} catch (org.junit.ComparisonFailure failure) {
				// in the catch you would check to see if there are any more rows left.
				if (i >= rows) {
					throw failure;
				}
			}
		}
		pathDetail.closeSiteLookup();
	}

	@Test
	public void pathDetailValidateExistingFieldValues() {
		createPath.createBrandNewProjectPath("Validate Path from Path details" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("site 1", BAND_DESCRIPTION_FIVE_DOT_EIGHT, "Ton", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV, "site 2", LATITUDE8, LONGITUDE8, ELEVATION8);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "site 1", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV);
		pathSummary.viewSiteCallSignLatLongGeColumns2(0, "site 2", LATITUDE8, LONGITUDE8, ELEVATION8);
		pathSummary.openPathDetails(0);
		pathDetail.viewPathDetailValue1("site 1", "", EXISTINGSITE_LAT, EXISTINGSITE_LONG, EXISTINGSITE_ELEV,
				BAND_DESCRIPTION_DOT_NINEFOUR);
		pathDetail.viewPathDetailValues2("site 2", "", LATITUDE8, LONGITUDE8, ELEVATION8,
				BAND_DESCRIPTION_DOT_NINEFOUR);
		pathDetail.closePathDetails();
		quickAdd.quickAddPath("site", BAND_DESCRIPTION_DOT_NINEFOUR, "Path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV, "site 3", LATITUDE8, LONGITUDE8, ELEVATION8);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(1, "site", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV);
		pathSummary.viewSiteCallSignLatLongGeColumns2(1, "site 3", LATITUDE8, LONGITUDE8, ELEVATION8);
		pathSummary.openPathDetails(1);
		pathDetail.viewPathDetailValue1("site", "", EXISTINGSITE_LAT, EXISTINGSITE_LONG, EXISTINGSITE_ELEV,
				BAND_DESCRIPTION_DOT_NINEFOUR);
		pathDetail.viewPathDetailValues2("site 3", "", LATITUDE8, LONGITUDE8, ELEVATION8,
				BAND_DESCRIPTION_DOT_NINEFOUR);
		pathDetail.closePathDetails();
		quickAdd.quickAddPath("site", BAND_DESCRIPTION_DOT_NINEFOUR, "Path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV, "site 4", LATITUDE8, LONGITUDE8, ELEVATION8);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(2, "site", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV);
		pathSummary.viewSiteCallSignLatLongGeColumns2(2, "site 4", LATITUDE8, LONGITUDE8, ELEVATION8);
		pathDetail.closeWarning();
		pathSummary.openPathDetails(2);
		pathDetail.viewPathDetailValue1("site", "", EXISTINGSITE_LAT, EXISTINGSITE_LONG, EXISTINGSITE_ELEV,
				BAND_DESCRIPTION_DOT_NINEFOUR);
		pathDetail.viewPathDetailValues2("site 4", "", LATITUDE8, LONGITUDE8, ELEVATION8,
				BAND_DESCRIPTION_DOT_NINEFOUR);
	}

	/**
	 * COM-396
	 */

	@Test
	public void pathDetailSiteSearch_searchResultsShouldContainAppropriateSite_whenSearchingForSiteUsingMultipleParameters() {
		createPath.createBrandNewProjectPath("Site" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToUs();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathPathDetailWithAsrAndCall1("ASRandCALL1", CALLSIGN2, "1000037", LATITUDE6, LONGITUDE6,
				"5065.05", BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathPathDetailWithAsrAndCall2("ASRandCALL2", CALLSIGN1, "1000038", LATITUDE6, LONGITUDE7,
				"5066.32");
		pathDetail.closeWarning();
		pathDetail.clickReturnButtonInPathDetailsPage();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.siteSearch1("", CALLSIGN1, "", LATITUDE1, LONGITUDE1, "");
		// so you get the max number of rows
		int rows = pathDetail.getRows();
		// Then loop through and do your check
		for (int i = 0; i < rows; i++) {
			// try and catch would be inside the for loop
			try {
				pathDetail.siteSearchResultWithASR(i, "New York2", CALLSIGN1, "", LATITUDE1, LONGITUDE1, "0.000");
				break;
			} catch (org.junit.ComparisonFailure failure) {
				// in the catch you would check to see if there are any more rows left.
				if (i >= rows) {
					throw failure;
				}
			}

		}
	}

	/**
	 * COM-325,COM-321
	 */

	@Test
	public void pathDetailElevation_shouldError_whenOutsideNeg304dot495And30479dot695Meters() {
		createPath.createBrandNewProjectPath("Path Detail elev SI range test" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("SYNRAMS STATION", CALLSIGN2, LATITUDE6, LONGITUDE6, "-305",
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.pathDetailErrors("Must be between -304.495 and 30,479.695 meters.");
		pathDetail.addPathViaPathDetailBasicSetup2("New York", CALLSIGN1, LATITUDE1, LONGITUDE1, "30479.696");
		pathDetail.pathDetailErrors("Must be between -304.495 and 30,479.695 meters.");
		pathDetail.viewPathDetailValue1("SYNRAMS STATION", CALLSIGN2, LATITUDE6, LONGITUDE6, "-305", "11");
		pathDetail.viewPathDetailValues2("New York", CALLSIGN1, LATITUDE1, LONGITUDE1, "30479.696", "1");
		pathDetail.closePathDetails();
	}

	/**
	 * LEGO-2293: Auto UI: Path Details - Regulatory and Administrative sections
	 * LEGO-2175
	 */
	@Test
	public void pathDetailLicBasis_shouldDisplayLicOptions_whenSelectingLicDropdown() {
		createPath.createBrandNewProjectPath("Path Detail Lic Basis" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.verifyPathDetailsRegulatorySection();
		pathDetail.addPathViaPathDetailBasicSetup1("SYNRAMS STATION", CALLSIGN2, LATITUDE6, LONGITUDE6, "-200.01",
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.licSelection1("1", "Secondary");
		pathDetail.licSelection2("1", "Secondary");
		pathDetail.addPathViaPathDetailBasicSetup2("New York", CALLSIGN1, "34 37 44.1 N", "112 39 24.2 W", "210.124");
		pathDetail.saveDetails();
	}

	@Test
	public void pathDetailRadioService_shouldSaveRecord_whenSelectingRadioEntries() {
		createPath.createBrandNewProjectPath("Path Detail Radio Service" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("SYNRAMS STATION", CALLSIGN2, LATITUDE6, LONGITUDE6, "-200.01",
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.licSelection1("1", "Secondary");
		pathDetail.licSelection2("1", "Secondary");
		pathDetail.radioService1("", "AB-Aural Microwave Booster");
		pathDetail.radioService2("", "MW-Microwave Public Safety Pool");
		pathDetail.addPathViaPathDetailBasicSetup2("New York", CALLSIGN1, "34 37 44.1 N", "112 39 24.2 W", "200.124");
		pathDetail.saveDetails();
	}

	/**
	 * COM-325
	 */

	@Test
	public void pathDetailElevation_shouldError_whenOutsideNeg999And99999Feet() {
		createPath.createBrandNewProjectPath("Path Detail elev US range test" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToUs();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("SYNRAMS STATION", CALLSIGN2, LATITUDE6, LONGITUDE6, "-1000",
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.pathDetailErrors("Must be between -999 and 99,999 feet.");
		pathDetail.addPathViaPathDetailBasicSetup2("New York", CALLSIGN1, "34 37 44.1 N", "112 39 24.2 W", "200.124");
		pathDetail.pathDetailErrors("Must be between -999 and 99,999 feet.");
		pathDetail.closePathDetails();
	}

	/**
	 * COM-276
	 */

	@Test
	public void addArsPathViaPathDetail() {
		createPath.createBrandNewProjectPath("Regression Project" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", ASR1, LATITUDE1, LONGITUDE1, ELEVATION3,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addAsrPathViaPathDetail2("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.saveAndValidateSuccessMessage("You have successfully saved");
	}

	@Test
	public void addCallSignPathViaPathDetail() {
		createPath.createBrandNewProjectPath("Regression Project" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.saveAndValidateSuccessMessage("You have successfully saved");
	}

	/**
	 * COM-276 Path Details - Site section UI
	 */

	@Test
	public void addCallSignPathViaPathDetailWithDefaultCompany() {
		createPath.createBrandNewProjectPath("PathDetailWithDefaultCompany" + randomNumber, "This is the Default");
		createPath.contactLookup("BRLNSF", "BNSF Railway Company", "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.checkSiteSuggestionTrue("brighton", "Tonto Mtn");
	}

	/**
	 * COM-276
	 */
	@Test
	public void siteWith21characters() {
		createPath.createBrandNewProjectPath("PathDetailWithDefaultCompany" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.checkSiteSuggestion("The Site has more than 21 char", "The Site has more than 21 char");
		pathDetail.pathDetailErrorsSiteName("SITE NAME CANNOT BE LONGER THAN 20 CHARACTERS.");
	}

	/**
	 * COM-276
	 */
	// This test will be changed from @ignore to @Test when call sign validation is
	// in place
	@Ignore
	public void CallSignWith9characters() {
		createPath.createBrandNewProjectPath("PathDetailWithDefaultCompany" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.checkCallSignEntry("455654655", "546546546546");
		pathDetail.pathDetailErrorsCallsign("CALL SIGN IS A MAXIMUM OF 8 CHARACTERS.");
	}

	// COM-335 Create UI pieces for Path Detail's Antenna section
	@Test
	public void pathDetail_whenOpening_ShouldSeeAntennaFields() {
		createPath.createBrandNewProjectPath("Regression Project" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", ASR1, LATITUDE1, LONGITUDE1, ELEVATION3,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addAsrPathViaPathDetail2("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, "820.21");
		pathDetail.antennaFieldValidation();
	}

	@Test
	// COM-397

	public void pathDetail_searchingTheFirstLetterOfAnExistingCompany_ResultSetShouldIncludeAppropriateCompanies() {
		createPath.createProjectPath("search1StCharOfCompany" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME_PARTIAL, "", 0);

	}

	/**
	 * LEGO-2979 ,COM-453
	 */

	@Test
	public void pathDetailMessage_SuccessMessage_WhenPathIsSavedAndValuesPersist() {
		createPath.createBrandNewProjectPath("Path Detail Success Message" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.saveAndValidateSuccessMessage("You have successfully saved");
		pathDetail.savedPathInfoPersists1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.savedPathInfoPersists2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
	}

	/**
	 * COM-453
	 */
	@Test
	public void pathDetailMessage_RequiredError_WhenNoRequiredFieldsHaveEntries() {
		createPath.createBrandNewProjectPath("Path Detail Required Error" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.saveAndValidateRequiredMessage("Required.");
	}

	/**
	 * COM-453
	 */
	@Test
	public void pathDetailCopy_NewPathIsCreatedAndUserRemainsOnOriginalPath_WhenPathIsCopied() {
		createPath.createBrandNewProjectPath("Path Copy Path" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.saveAndValidateSuccessMessage("You have successfully saved");
		pathDetail.copyPathViaPathDetails("PATH COPIED SUCCESSFULLY\n" + "You have successfully copied the path.");
		pathDetail.verifyUserISOnTheNewCopiedPath();
	}

	@Test
	public void pathDetailFlip_PathDetailWillFlip_WhenPathFlipButtonIsClicked() {
		createPath.createBrandNewProjectPath("Path Detail Flip Path" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addPathViaPathDetailBasicSetup2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.saveAndValidateSuccessMessage("You have successfully saved");
		pathDetail.savedPathInfoPersists1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1, "10");
		pathDetail.savedPathInfoPersists2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.flipPath();
		pathDetail.savedPathInfoPersists2("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1);
		pathDetail.savedPathInfoPersists1("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2, "10");
	}

	/**
	 * COM-455
	 */
	/**
	 * LEGO-2908 AUTO UI:Copying a path should bring the user to the new, Copied
	 * path LEGO-2471
	 */
	@Test
	public void pathDetailCopy_NextButtonShouldBeActive_WhenPathIsCopied() {
		String index = "2";
		createPath.createBrandNewProjectPath("Copy Next Button Active" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.saveAndValidateSuccessMessage("You have successfully saved");
		pathDetail.copyPathViaPathDetails("PATH COPIED SUCCESSFULLY\n" + "You have successfully copied the path.");
		pathDetail.verifyCopyBringsTheUserToNewCopiedPath(index);
		pathDetail.previousArrow();
		pathDetail.savedPathInfoPersists1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1, "10");
		pathDetail.savedPathInfoPersists2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
	}

	/**
	 * COM-487
	 */

	@Test
	public void passiveRepeaterPathDetail_SelectNextButton_WillDisplayCorrectRepeaterInformation() {
		createPath.createBrandNewProjectPath("NextPreviousPassive" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToUs();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathPathDetailWithAsrAndCall1("PassRepeater1", CALLSIGN2, "1000037", LATITUDE1, LONGITUDE1,
				ELEVATION1, BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathPathDetailWithAsrAndCall2("PassRepeater2", CALLSIGN1, "1000038", LATITUDE2, LONGITUDE2,
				ELEVATION2);
		pathDetail.verifyPathSaveMessage();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathPathDetailWithAsrAndCall1("NoPassRepeater1", "", "", "40 44 54.1 N", "73 59 9.1 W",
				ELEVATION1, "10");
		pathDetail.addPathPathDetailWithAsrAndCall2("NoPassRepeater2", "", "", "40 42 46.9 N", "74 0 47.4 W",
				ELEVATION2);
		pathDetail.verifyPathSaveMessage();
		pathDetail.openPathDetailViaDetails();
		pathDetail.addBackToBackPassiveRepeater();
		pathDetailAnt.antennaLookUpFromPassiveRepeater("02306A");
		pathDetail.returnFromAntennaLookUp("P8F-9", "02306A");
		pathDetail.setAntennaOnPassiveRepeater(1, "02306A");
		pathDetail.savePassiveRepeater();
		pathDetail.nextArrow();
		pathDetail.previousArrow();
	}

	/**
	 * COM-487
	 */
	@Test
	public void passiveRepeaterPathDetail_WhenFrequencyBandChangedPath_ThenPassiveRepeaterFieldsWillBeCleared() {
		createPath.createBrandNewProjectPath("WhenFrequencyBandChangedPath" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathPathDetailWithAsrAndCall1("PassRepeater1", CALLSIGN2, "1000037", LATITUDE1, LONGITUDE1,
				ELEVATION1, BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathPathDetailWithAsrAndCall2("PassRepeater2", CALLSIGN1, "1000038", LATITUDE2, LONGITUDE2,
				ELEVATION2);
		pathDetail.verifyPathSaveMessage();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathPathDetailWithAsrAndCall1("NoPassRepeater1", "", "", "40 44 54.1 N", "73 59 9.1 W",
				ELEVATION1, "10");
		pathDetail.addPathPathDetailWithAsrAndCall2("NoPassRepeater2", "", "", "40 42 46.9 N", "74 0 47.4 W",
				ELEVATION2);
		pathDetail.verifyPathSaveMessage();
		pathDetail.openPathDetailViaDetails();
		pathDetail.addBackToBackPassiveRepeater();
		pathDetailAnt.antennaLookUpFromPassiveRepeater("02306A");
		pathDetail.returnFromAntennaLookUp("P8F-9", "02306A");
		pathDetail.setAntennaOnPassiveRepeater(1, "02306A");
		pathDetail.savePassiveRepeater();
		pathDetail.changeFrequency("0.96 GHz (952.8-960 MHz) US");
		pathDetail.checkForBlankPassiveRepeaterFields();
	}

	/**
	 * LEGO-5841 : QA AUTO UI LEGO: Add ASR as an input field for Passive Repeaters
	 */
	@Test
	public void passiveRepeaterPathDetail_AddPassiveRepeater_VerifyASRField() {
		createPath.createBrandNewProjectPath("Project Repeater" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("site 1", BAND_DESCRIPTION_FIVE_DOT_EIGHT, "Ton", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV, "site 2", LATITUDE8, LONGITUDE8, ELEVATION8);
		quickAdd.closeWarning();
		pathDetail.openPathDetailViaDetails();
		pathDetail.populatePassiveRepeaterDetails("site 1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1, ELEVATION2,
				"1212RF");
		pathDetail.verifyPassiveRepeaterSearchByASR(ASR1);
	}

	/**
	 * COM-495 and COM-496 LEGO-2281 : Auto UI: Path Details form - Update Path
	 * Section LEGO-2076 LEGO-10223 - QA AUTO UI Allow underscore in Path Name
	 * LEGO-10051
	 */

	@Test
	public void pathDetailCopy_CopySamePathTwiceBrowserBack_OriginalShouldBeInPlace() {
		String path_name = "Path_name";
		createPath.createBrandNewProjectPath("Path Detail Copy Path" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.verifyPathDetailsFormUpperSection();
		pathDetail.addPathName(path_name);
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.saveAndValidateSuccessMessage("You have successfully saved");
		pathDetail.copyPathViaPathDetails(
				"PATH COPIED SUCCESSFULLY\n" + "You have successfully copied " + path_name + ".");
		pathDetail.copyPathViaPathDetails(
				"PATH COPIED SUCCESSFULLY\n" + "You have successfully copied " + path_name + ".");
		pathDetail.savedPathInfoPersists1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1, "10");
		pathDetail.savedPathInfoPersists2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.clickReturnButtonInPathDetailsPage();
		quickAdd.validateCopiedPaths(0, path_name);
		quickAdd.validateCopiedPaths(1, path_name);
		quickAdd.validateCopiedPaths(2, path_name);
	}
	// COM-535

	@Test
	public void pathDetail_AddDifferentCompanies_ResultShouldIncludeEachCompany() {
		createPath.createBrandNewProjectPath("search1StCharOfCompany" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		createPath.contactLookuprFromDetails("VERBCH", "", "");
		pathDetailAnt.clickSaveDetails();
		quickAdd.valCompanies("Loudoun, County of , VERO BEACH CITY FLORIDA");
	}

	/**
	 * COM-588,LEGO-3335 (UI AUTO) Companies list support in project header COM-503
	 */

	@Test
	public void pathDetail_AddDifferentCompanies_ResultShouldIncludeEachThreeCompanies() {
		createPath.createBrandNewProjectPath("Path Detail Company" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		createPath.contactLookuprFromDetails("VERBCH", "", "");
		pathDetailAnt.clickSaveDetails();
		pathDetail.verifyAzimuthPathLength("210.460 °", "4.552 km / 2.828 mi", "30.442 °");
		pathDetail.verifyControlIsInPathDetailsPage("");
		pathDetail.clickReturnButtonInPathDetailsPage();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		createPath.contactLookuprFromDetails("VERELE", "", "");
		pathDetailAnt.clickSaveDetails();
		pathDetail.closeWarning();
		pathDetail.clickReturnButtonInPathDetailsPage();
		quickAdd.valCompaniesThree("Loudoun, County of", "VERO BEACH CITY FLORIDA", "VERMONT ELECTRIC COOPERATIVE INC");
	}

	@Test
	public void pathDetail_AddSameCompanies_ResultShouldCompany() {
		createPath.createBrandNewProjectPath("search1StCharOfCompany" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.clickSaveDetails();
		pathDetail.clickReturnButtonInPathDetailsPage();
		quickAdd.valCompanies1("Loudoun, County of");
	}

	/**
	 * LEGO-2067: AUTO UI: Filter on discrete frequency in frequency plan lookup
	 * LEGO-1873 This test is to verify the frequency plans in the frequency look up
	 * from path details page
	 */
	/**
	 * LEGO-1890 :AUTO UI: Path Details Frequency Lookup LEGO-1661
	 */
	@Test
	public void pathDetail_FrequencyLookup_VerifyFrequencyPlan() {
		createPath.createBrandNewProjectPath("Path Detail Freq Plan" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Tonto Mtn", CALLSIGN2, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_SIX_DOT_ONE);
		pathDetail.addPathViaPathDetailBasicSetup2("New York", CALLSIGN1, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.clickFrequencyLookupICon();
		pathDetail.verifyFrequencyPlanFiletringInFrequencyLookup();
		pathDetail.verifyFrequencyPlanFiletringInFrequencyLookupUsingPlanBandwidth();
	}

	/**
	 * LEGO-1886: AUTO UI: Path Details Frequency Table LEGO-1660 This test is to
	 * verify the frequencies for a frequency plan
	 * 
	 * LEGO-1890 :AUTO UI: Path Details Frequency Lookup LEGO-1661
	 *
	 */
	@Test
	public void pathDetail_FrequencyPlan_VerifyFrequencies() {
		createPath.createBrandNewProjectPath("Path Details" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Tonto Mtn", CALLSIGN2, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_SIX_DOT_ONE);
		pathDetail.addPathViaPathDetailBasicSetup2("New York", CALLSIGN1, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.enterFrequencyPlanInPathDetailsPage("HS", "LS");
		pathDetail.verifyFrequenciesForHSPlan();
		pathDetail.verifyFrequenciesForLSPlan();
		pathDetail.invalidFrequencyPlan();
	}

	/**
	 * LEGO-2029: (AUTO UI) UI to support custom Frequency Plans LEGO-1866
	 */

	/**
	 * LEGO-3053: AUTO UI: LEGO-2822 UI: New Path Calculations
	 */
	/**
	 * LEGO-2028 : (AUTO UI) Setting Custom Frequencies in Path Details Frequency
	 * Section LEGO-1825 LEGO-9427 : QA AUTO UI Frequency Search Box: pre-populate
	 * bandwidth LEGO-8999
	 */

	@Test
	public void pathDetail_CustomFrequencyPlan_verifyFrequencies() {
		String projectName = "Regression Project" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", "", LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addAsrPathViaPathDetail2("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.antennaFieldValidation();
		pathDetail.addPrimaryAntennaForSite1AndSite2("A02402", "A02402");
		pathDetail.addRadioForSite1AndSite2("M09002", "M09002");
		pathDetail.addLossForSite1AndSite2("1", "1", "1");
		pathDetail.addCustomFrequencyForSite1AndSite2("933", "933");
		pathDetail.saveDetails();
		pathDetail.closeWarning();
		pathDetail.verifyPathCalculations("37", "54.1", "-33.86");

	}

	/**
	 * LEGO-9427 : QA AUTO UI Frequency Search Box: pre-populate bandwidth LEGO-8999
	 */

	@Test
	public void pathDetail_frequencyPlanBandwidth_verifyFrequenciesPrepopulated() {
		String projectName = "Regression ProjectFreq" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", "", LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addAsrPathViaPathDetail2("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.antennaFieldValidation();
		pathDetail.addPrimaryAntennaForSite1AndSite2("A02402", "A02402");
		pathDetail.addRadioForSite1AndSite2("M09002", "M09002");
		pathDetail.addLossForSite1AndSite2("1", "1", "1");
		pathDetail.clickFrequencyLookupICon();
		pathDetail.verifyBandwidthFieldInFrequencyLookupModal("0.0113");

	}

	/**
	 * LEGO-2064: AUTO UI: Component to toggle between meters and feet LEGO-1907
	 * LEGO-7156 : QA AUTO- UI: Change Antenna Centerline limits in Path Details
	 * (allow negatives) LEGO-5802
	 */
	@Test
	public void pathDetail_ToggleMetersFeet_VerifyConversion() {
		createPath.createBrandNewProjectPath("Path Detail ToggleMetersFeet" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.typeGroundElevationValueSite1("12");
		pathDetail.verifyConversionSite1GroundElevationMeterToFeet("12", "39.37");
		pathDetail.clickMeterSite1GroundElevation();
		pathDetail.clickReturnButtonInPathDetailsPage();
		pathDetail.clickConfirmInPathDetailsPage();
		pathSummary.changeToUs();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.typeGroundElevationValueSite1("12");
		pathDetail.verifyConversionSite1GroundElevationFeetToMeter("12", "3.658");
		pathDetail.changeBand(BAND_DESCRIPTION_SIX_DOT_ONE);
		pathDetail.verifyConversionSite1AntennaCenterlineFeetToMeter(ELEVATION1, "4.267");
		pathDetail.verifySystemAccepstNegativeCenterline("-10");
		pathDetail.clickReturnButtonInPathDetailsPage();

	}

	/**
	 * LEGO-2164 : AUTO UI: Add unit toggle between meters and feet in Path Details
	 * LEGO-1998 LEGO-9336 - QA AUTO UI : Issue with passive repeater window
	 * LEGO-8897
	 */
	@Test
	public void pathDetails_shouldPass_VerifyMeterToFeetConversion() {
		createPath.createBrandNewProjectPath("Path Detail MeterToFeetConversion" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", "", LATITUDE1, LONGITUDE1, "",
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addAsrPathViaPathDetail2("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.verifyConversionGroundElevation1MeterToFeet("70", "229.66");
		pathDetail.verifyConversionAntennaCenterline1MeterToFeet("45", "147.64");
		pathDetail.verifyPassiveRepeaterGEConversionMeterToFeet("20", "65.62");
		pathDetail.verifyPassiveRepeaterCenterlineConversionMeterToFeet("40", "131.23");
	}

	/**
	 * LEGO-2589 : 2018 QA S UI auto LEGO-2500: Allow ASR search by radius LEGO-7031
	 * - QA AUTO maintenance : Allow ASR search by radius LEGO-2589
	 */
	@Test
	public void pathDetails_shouldPass_VerifyASRSearchByRadius() {
		createPath.createBrandNewProjectPath("Path Detail ASR search" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.clickASRHamburgerLookup();
		pathDetail.verifyASRookupSearchLessThanFiveDegreeFromASR(ASR4, LATITUDE9, LONGITUDE9);
		pathDetail.clickASRHamburgerLookup();
		pathDetail.verifyASRookupSearchWhenLongitudeGreaterThanFiveDegree();

	}

	/**
	 * LEGO-2294 : Auto UI: Path details form - update Site section LEGO-2086
	 */
	/**
	 * LEGO-2160 : AUTO UI: Add Create and Update Dates and Users to Path Details
	 * LEGO-2101
	 */
	@Test
	public void pathDetails_CreateAndSavePath_VerifyAzimuthAndPathLengthAndVerifyCreatedUpdatedDateUserInFooterofPath() {
		createPath.createBrandNewProjectPath("newproject Azhimuth" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE2, "", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathPathDetailWithAsrAndCall1("ASRandCALL1", CALLSIGN2, ASR3, "44 34 6.8 N", "95 59 33.6 W",
				"353.86", BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathPathDetailWithAsrAndCall2("ASRandCALL2", CALLSIGN1, ASR4, "44 25 3 N", "95 47 5.9 W", "353");
		pathDetail.verifyPathlengthAndAzimuth("135.384 °", "315.530 °", "23.551 km / 14.634 mi");
		pathDetail.verifyCreatedUpdatedUSerDatesLabel();
		String todaysDate = database.getCurrentDate();
		pathDetail.verifyCreatedDate(todaysDate);
		pathDetail.verifyLastUpdatedDate(todaysDate);
		pathDetail.verifyCreatedByUser("default_admin");
		pathDetail.verifyUpdatedByUser("default_admin");
		loginPage.logout();

	}

	/**
	 * LEGO-2296 : Auto UI: Update Site Search to incorporate radius search API
	 * LEGO-2177
	 */
	@Test
	public void pathDetails_SiteSearch_VerifySiteSearchRadius() {
		createPath.createBrandNewProjectPath("Search Site" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathPathDetailWithAsrAndCall1("ASRandCALL1", CALLSIGN2, ASR3, "44 34 6.8 N", "95 59 33.6 W",
				"353.86", BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathPathDetailWithAsrAndCall2("ASRandCALL2", CALLSIGN1, ASR4, "44 25 3 N", "95 47 5.9 W", "353");
		pathDetail.clickReturnButtonInPathDetailsPage();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.clickSiteLookup();
		pathDetail.searchByLatitudeLongitude("39 8 16.5 N", " 77 49 57.6 W", "1");
	}

	/**
	 * QA UI auto: Hide EIRP and RSL Max Power results when ATPC is disabled
	 * LEGO-2765 Create a path, with full equipment, and ATPC turned off Max power
	 * EIRP and RSL are not displayed LEGO-9533 : QA AUTO UI : UAT: Add a new button
	 * on Path Details form footer to generate datasheet LEGO-9119
	 */
	@Test
	public void pathDetails_ATPCTurnedOff_VerifyMaxPowerRSLNotDisplayed() {
		String projectName = "Regression ATPC" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.antennaFieldValidation();
		pathDetail.addPrimaryAntennaForSite1AndSite2("A02402", "A02402");
		pathDetail.addRadioForSite1AndSite2("M09002", "M09002");
		pathDetail.addLossForSite1AndSite2("1", "1", "1");
		pathDetail.enableATPCThenDisableVerifyMaxPower();// enable ATPC so RSL and EIRP values will show up
		pathDetail.clickSaveButtonOnPathDetails();
		pathDetail.closeWarning();
		pathDetail.verifyNominalPowerEIRPandRSLPresent("37", "54.1", "-");
		pathDetail.disableATPCThenEnableVerifyMaxPower();
		pathDetail.clickSaveButtonOnPathDetails();
		pathDetail.closeWarning();
		pathDetail.verifyNominalPowerEIRPandRSLPresent("-", "-", "-");
		pathDetail.verifyReportButtonPresent();

	}

	/**
	 * LEGO-2238 : AUTO UI Hi-Lo summary on Path Details LEGO-1776
	 */
	/**
	 * LEGO-2295 : Auto UI: Update path FLIP to include all possible path fields
	 * LEGO-1877
	 */
	/**
	 * LEGO-4741 : QA AUTO UI LEGO-4491: Select/deselect polarizations, including
	 * "Deactivate" button
	 */
	/**
	 * LEGO-6008: QA AUTO UI: Standardize error messaging for Path Save LEGO-5925
	 */
	@Test
	public void pathDetails_FlipPath_VerifyHiLo() {
		String radio = "M09002";
		String antenna = "A02402";
		String site1Plan = "H}";
		String site2Plan = "L}";
		String projectName = "Project PathFilp HiLo" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", "", LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", "", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.antennaFieldValidation();
		pathDetail.addPrimaryAntennaForSite1AndSite2(antenna, antenna);
		pathDetail.addRadioForSite1AndSite2(radio, radio);
		pathDetail.addLossForSite1AndSite2("1", "1", "1");
		pathDetail.enterFrequencyPlanInPathDetailsPage(site1Plan, site2Plan);
		pathDetail.clickSaveButtonOnPathDetails();
		pathDetail.validationDrawerWarning(HEADING_DRAWER1);
		pathDetail.closeWarning();
		pathDetail.clickFlipButtonOnPathDetails();
		pathDetail.verifySite2Values("SITE1", "", LATITUDE1, LONGITUDE1, ELEVATION1);
		pathDetail.verifySite1Values("Tonto Mtn", "", LATITUDE2, LONGITUDE2, ELEVATION2, "");
		pathDetail.veryfyFrequencyPlanSite1(site2Plan);
		pathDetail.veryfyFrequencyPlanSite2(site1Plan);
		pathDetail.clickSaveButtonOnPathDetails();
		pathDetail.numberOfSitesInEnvironmentOnhi();

	}

	/**
	 * LEGO-4744 : QA AUTO UI LEGO-4647 : Path Details: Add error message if user
	 * flips Frequencies on simplex path
	 */

	@Test
	public void pathDetails_SimplexPath_VerifyErrorMessageOnFlippingFrequencyOnSimplexPath() {
		String antenna = "A02402";
		String radio = "M09002";
		String site1Plan = "H}";
		String projectName = "Project DYX" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", "", LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", "", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.antennaFieldValidation();
		pathDetail.addPrimaryAntennaForSite1AndSite2(antenna, antenna);
		pathDetail.makeSite2AntennaRxForSimplexPath("RX Only");
		pathDetail.setSite1Radio(radio);
		pathDetail.enterFrequencyPlan1(site1Plan);
		pathDetail.clickSaveButtonOnPathDetails();
		pathDetail.closeWarning();
		pathDetail.clickReturnButtonInPathDetailsPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.clickTerrResultsLinkOnAFSPage();
		analysis.clickFlipPathButton();
		analysis.validateErrorOnSimplexPath("- Cannot flip frequencies when path is a simplex path");

	}

	/**
	 * LEGO-6593 : QA UI Auto Regression Task: Ground elevation lookup from path
	 * details - verify terrain
	 */
	@Test
	public void pathDetail_GELookup_VerifyTerrain() {
		String groundElevationLookupValue = "145.798m / 478.34ft";
		createPath.createBrandNewProjectPath("Project GE" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", "", "40 34 10 N", "122 14 21.2 W", "",
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.clickGroundElevationLookupSite1();
		pathDetail.verifyGroundElevationLookupValue(groundElevationLookupValue);
	}

	/**
	 * LEGO-5295 : QA AUTO UI LEGO: ASR Lookup Radius Search LEGO-8026 : QA AUTO UI
	 * - add clear button to ASR Lookup LEGO-7892
	 */
	@Test
	public void ASRLookup_searchByRadius_VerifySearchByRadius() {
		createPath.createBrandNewProjectPath("Project SR NS" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.verifyASRlookupSearchRadius();
	}

	/**
	 * LEGO-5296 : QA AUTO UI LEGO: ASR Lookup PrePopulate Site Coordinates
	 */
	@Test
	public void ASRLookup_searchByRadius_VerifyPrePopulate() {
		createPath.createBrandNewProjectPath("Project Search Radius" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.verifyASRLookupPrePopulate(ASR1, SEARCH_RADIUS, "40 44 54 N", "73 59 9 W");
	}

	/**
	 * LEGO:6352 - QA AUTO UI: Path Details RCN Lookup LEGO-6108
	 */
	@Test
	public void RCNLookup_searchByRCN_VerifyRCNLookup() {
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		createPath.createProjectPath("Project RCN" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.clickRCNHamburgerLookup();
		pathDetail.verifyRcnLookupElements();
		pathDetail.verifyRcnLookupSearch(RCN, JOB_NUMBER, CONTACT_CODE);
	}

	/**
	 * LEGO-2162 : QA AUTO UI LEGO: Path Comments LEGO-8157 : QA AUTO LEGO-8009: UI:
	 * Ability to delete attachments across the whole application
	 */
	@Test
	public void pathDetail_addCommentWithAttachment_verifyComment() {
		createPath.createBrandNewProjectPath("Project attachment" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("site 1", BAND_DESCRIPTION_FIVE_DOT_EIGHT, "Ton", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV, "site 2", LATITUDE8, LONGITUDE8, ELEVATION8);
		pathDetail.openPathDetailViaDetails();
		pathDetail.clickAddCommentButton();
		String testComment = "Test Comment";
		String testAttachment = "commentAttachment.txt";
		pathDetail.createNewCommentWithAttachment(testComment, testAttachment);
		pathDetail.verifyCommentAndAttachment(testComment, testAttachment);
		pathDetail.deleteAttachment();

	}

	/**
	 * LEGO-6043 : QA AUTO UI: Modify path save constraint error messages LEGO-5987
	 */
	/**
	 * LEGO-6972 : QA UI Auto Task: UI: Add Company name to Path Details LEGO-4582
	 */
	/**
	 * LEGO-6877 : QA AUTO UI Task: UI: Pre-populate contact code in Contact Lookup
	 * LEGO-6510
	 */
	/**
	 * LEGO-6278: QA AUTO UI: Updates for Validations Drawer + ID tags LEGO-6009
	 */
	/**
	 * LEGO-6008 : QA AUTO UI: Standardize error messaging for Path Save LEGO-5925
	 * LEGO-8027 : QA AUTO UI - add clear button to Contact Lookup LEGO-7893
	 */
	@Test
	public void pathDetails_pathSave_verifyPathSaveConstraintError() {
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		createPath.createProjectPath("Project pathsave" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase("", CALLSIGN2);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathSummary.openPath();
		pathDetail.clickContactLookupForSite1();
		pathDetail.verifyPrepopulationOfContactCode();
		pathDetail.verifyCompanyNameOnPathDetailPage(CONTACT_CODE1, COMPANY_NAME1);
		String site1Name = pathDetail.clearSiteStatusFromAdministartiveSectionSite1();
		String site2Name = pathDetail.clearSiteStatusFromAdministartiveSectionSite2();
		pathDetail.saveDetails();
		pathDetail.validationDrawerWarning(HEADING_DRAWER);
		pathDetail.verifyPathSaveConstraintError(site2Name, site1Name);

	}

	/**
	 * LEGO-4201: QA AUTO UI: Coordination Advantage validation LEGO-4073
	 */
	@Test
	public void pathDetails_CoordinationAdvantage_ValidateAcmCoordAdvantage() {
		String projectName = "Project CoordinationAdvantage" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addCallSignPathViaPathDetail1("SITE1", CALLSIGN1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addCallSignPathViaPathDetail2("Tonto Mtn", CALLSIGN2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.addRadioForSite1AndSite2(RADIO_CODE, RADIO_CODE);
		pathDetail.clickATPCTriggerButton();
		pathDetail.clickATPCEnabledButton();
		pathDetail.verifyATPCSettingsElements();
		pathDetail.verifyCoordPowerATPCEnabled(COORD_POWER1, MAX_POWER);
		pathDetail.verifyCoordPowerATPCEnabled(COORD_POWER2, MAX_POWER);
		pathDetail.verifyCoordPowerACMCoordAdvantageEnabled(COORD_POWER1, MAX_POWER, LOWEST_POWER);
		pathDetail.verifyCoordPowerACMCoordAdvantageEnabled(COORD_POWER3, MAX_POWER, LOWEST_POWER);
	}

	/**
	 * LEGO: 5911 - QA Auto UI: Path Save Error Validation
	 */
	@Test
	public void pathDetails_ASRValidation_validatePathSaveError() {
		createPath.createProjectPath("Project ASR validation" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN1);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathDetail.openPathDetailViaDetails();
		pathDetail.verifyPathSaveErrorValidations(ELEVATION1, ELEVATION4, LATITUDE4);
	}

	/**
	 * LEGO-4743 - QA AUTO UI LEGO-4651: Path Details Simplex path updates.
	 */
	@Test
	public void pathDetails_SimplexPath_validateNoFlipOnPathsaveAndAnalysis() {
		createPath.createProjectPath("SimplexProject" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN1);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathDetail.openPathDetailViaDetails();
		pathDetail.makePathSimplexAndSave();
		pathDetail.verifyMessageOnHoverOverFlipSitesSimplexPath("Cannot flip simplex paths.");
	}

	/**
	 * 
	 * LEGO-5909 - QA auto UI- Path Save Error Validation: Path Length validation
	 * LEGO-5781
	 */
	@Test
	public void pathDetails_pathLength_VerifyPathSaveErrorValidation() {
		String pathLengthError = "Path length is greater than 200 miles.";
		createPath.createProjectPath("PathError" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN1);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathDetail.openPathDetailViaDetails();
		pathDetail.addASRAndClickSave(ASR1);
		pathDetail.verifyPathLengthError(pathLengthError);
	}

	/**
	 * 
	 * LEGO-7658 - QA AUTO UI: Create new Contact Detail pop-up LEGO-6530
	 */
	@Test
	public void pathDetails_contactLookup_VerifyContactLookupContactDetailspopup() {
		String contactName = "Garrie Losee";
		String email = "Garrie.Losee@t-mobile.com";
		String dba = "Sprint Nextel Corporation";
		String company = "Sprint Communications Company, LP";
		String protection = "COMS";
		createPath.createProjectPath("Contact Lookup" + randomNumber, "This is the Default");
		createPath.contactLookupSearch(COMPANYCODE3, MANUFACTURERNAME3, "", 0);
		createPath.clickViewContactDetailsFromContactLookup(COMPANYCODE3, contactName, email, dba, company, protection);
	}

	/**
	 * LEGO-8245 - QA AUTO LEGO-1854: UI: Hi-Lo Details
	 */
	@Test
	public void pathDetails_hiLoDetails_verifyHiLo() {
		createPath.createProjectPath("HiLoTestProject" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN2);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathDetail.openPathDetailViaDetails();
		pathDetail.clickHiLo();
		pathDetail.verifyHiLoModal();
	}

	/**
	 * LEGO-10135 : Diversity Flag Default
	 */

	@Test
	public void pathDetail_additionalAntenna_verifyDiversityFlag() {
		String projectName = "Additional Antenna" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("Additional", "", LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.clickAdditionalaAntenna();
		pathDetail.verifyAdditionalDiversityModel();
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
