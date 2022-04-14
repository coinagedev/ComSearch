package CommTests;

import CommPageObjects.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

/**
 * Created by ehend on 2/25/2017.
 */
public class AntennaDataBaseTest extends BaseTest {
	//private PathDetailAntennaPage pathDetailAnt;
	//private QuickAddPage quickAdd;
	//private PathSummaryPage pathSummary;
	//private CreateNewPathPage createPath;
	//private PathDetailPage pathDetail;
	//private PathDetailsRadioPage pathDetailRadio;
	private AntennaDataBasePage database;
	private LoginPage loginPage;
	private static final String[] antennaClassificationArray = { "Billboard", "Cassegrain Parabolic",
			"Corner Reflector", "Cylindrical Parabola", "Dipole", "Grid Parabolic", "Gaussian Lens", "Horn Parabolic",
			"Offset Feed Parabola", "Omnidirectional", "Panel", "Prime Focus Parabola", "Prime Focus Torus", "Sector",
			"Solid Parabolic", "Yagi" };
	private static final String[] polarizedList = { "Dual", "Single", "Circular" };

	private static final String ANTENNA_COMPANY = "CommScope";
	private static final String ANTENNA_MODEL = "P8F-9";
	private static final String ANTENNA_CLASSIFICATION = "Billboard";
	private static final String ANTENNA_STATUS = "Dual";
	private static final String ANTENNA_POLARIZATION = "Active";
	private static final String LOW_FREQUENCY = "200";
	private static final String HIGH_FREQUENCY = "300";
	private static final String MAINBEAM_GAIN = "3";
	private static final String BEAMWIDTH = "2";
	private static final String APPLICATION = "Point-to-Point";
	private static final String FCC_COMPLIANCE = "Compliant";

	private String antennaGainFor02306A = "24.3";
	private String antenna3DBBWFor02306A = "9.2";
	private String antenannaDiamaterFor02306A = "2.44 / 8.01";
	private String antennaCode1 = "02302A";
	private String antennaCode2 = "02306A";
	private String antennaCode3 = "77100A";
	private String antennaCode4 = "77206A";
	private String antennaCode5 = "02014N";

	@Before
	public void Setup() {

//		pathDetailAnt = new PathDetailAntennaPage(driver);
//		quickAdd = new QuickAddPage(driver);
//		pathSummary = new PathSummaryPage(driver);
//		createPath = new CreateNewPathPage(driver);
//		pathDetail = new PathDetailPage(driver);
//		pathDetailRadio = new PathDetailsRadioPage(driver);
		database = new AntennaDataBasePage(driver);
		loginPage = new LoginPage(driver);
		loginPage.selectUserAndLogin("admin");
	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * COM-589 (UI AUTO) Create routes to connect home page with Antenna DB
	 * Management View. COM-527 Open the Lego project Click "Database Management"
	 * Click "Antenna Database"
	 * 
	 * 
	 */
	@Test
	public void antDataBase_theAntennaDatabasePageShouldOpen_whenNavigatingToAntDataBase() {
		database.accessAntennaDataBase();
	}

	/**
	 * COM-657 Manufacturer search Enter a manufacturer name in the "Manufacturer"
	 * search field 1. Click "Search" 2. All of the antennas from that manufacturer
	 * are displayed. None of the displayed antennas are from other manufacturers.
	 */
	@Test
	public void antDataBase_AllAntennasFromThatCompanyAreDisplayed_whenInputValidCompanyNameAndSearch() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase(antennaCode1, "Commscope", "Standard Performance", "", "890");
		database.evaluateAntennaDataSearchResult1(0, antennaCode1, "Commscope", "Standard Performance", "P6F-9A", "S",
				"890 - 960");
		database.evaluateAntennaDataSearchResult2(0, "21.9", "13", "1.83 / 6.00", "A", "RPE 2302A", "1995/03/15");
		database.evaluateCompanyRow("Commscope");
	}

	/**
	 * COM-657 Model Family search Continuing: Make note of the model families of
	 * the displayed antennas. Pick one, preferably one that has its first three
	 * characters in common with another model family.
	 * 
	 * Clear the "Manufacturer" field Enter the model family you picked. Click
	 * "Search"
	 * 
	 * A list of model families with those first three digits is displayed.
	 * 
	 * All of the antennas from that model family are displayed. None of the
	 * displayed antennas are from other model families.
	 */
	@Test
	public void antDataBase_AllAntennasFromThatCompanyFamilyAreDisplayed_whenInputValidCompanyFamilyAndSearch1() {
		database.accessAntennaDataBase();
		if (firefox.equals("firefox")) {
			// The suggested list does not appear
		} else {
			database.submitAntennaDataBaseSearch("", "Commscope", "Standard Performance", "P8F-9", "");
			database.evaluateAntennaDataSearchResult1(0, antennaCode2, "Commscope", "Standard Performance", "P8F-9",
					"S", "890 - 960");
			database.evaluateAntennaDataSearchResult2(0, antennaGainFor02306A, antenna3DBBWFor02306A,
					antenannaDiamaterFor02306A, "A", "RPE 2306", "1972/02/29");
			database.evaluateCompanyFamilyRow("Standard Performance");
		}

	}

	@Test
	public void antDataBase_AllAntennasFromThatCompanyFamilyAreDisplayed_whenInputValidCompanyFamilyAndSearch2() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase(antennaCode3, "", "ValuLine High Performance", "", "");
		database.evaluateAntennaDataSearchResult1(0, antennaCode3, "Commscope", "ValuLine High Performance",
				"VHLPX2-11", "D", "10500 - 11700");
		database.evaluateAntennaDataSearchResult2(0, "34.4", "3.4", "0.61 / 2.00", "B1", "7100", "2006/10/24");
		database.evaluateCompanyFamilyRow("ValuLine High Performance");
	}

	/**
	 * COM-657 COM-701 Model search with left and right feed. Continuing: Make note
	 * of the model names of the displayed antennas. Pick one that has left and
	 * right feeds. Clear all search fields. Enter the model name Click "Search"
	 * Select "Left Feed" and search again Select "Right Feed" and search again 4.
	 * All versions of that model (left and right feed) appear in the search
	 * results. 5. Only the left feed version of that antenna is returned. 6. Only
	 * the right feed version of that antenna is returned.
	 */

	@Test
	public void antDataBase_AllAntModelOfTypeAreDisplayed_whenInputValidAntModelAnyAndSearch() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase("02", "", "Standard Performance", "", "");
		database.evaluateAntennaDataSearchResult1(0, antennaCode1, "Commscope", "Standard Performance", "P6F-9A", "S",
				"890 - 960");
		database.evaluateAntennaDataSearchResult2(0, "21.9", "13", "1.83 / 6.00", "A", "RPE 2302A", "1995/03/15");
		database.evaluateCompanyFamilyRow("Standard Performance");

	}

	@Test
	public void antDataBase_AllAntModelOfTypeAreDisplayed_whenInputValidAntModelLFAndSearch() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase("", "", "Standard Performance", "P8F", "");
		database.evaluateAntennaDataSearchResult1(0, antennaCode2, "Commscope", "Standard Performance", "P8F-9", "S",
				"890 - 960");
		database.evaluateAntennaDataSearchResult2(0, antennaGainFor02306A, antenna3DBBWFor02306A,
				antenannaDiamaterFor02306A, "A", "RPE 2306", "1972/02/29");
		database.evaluateCompanyFamilyRow("Standard Performance");
	}

	/**
	 * COM-657 Frequency search Continuing: Make note of the frequency range of the
	 * antenna you searched for. Clear all search fields. Enter the manufacturer
	 * name (in order to limit results) in the Manufacturer field Enter a frequency
	 * in the middle of the frequency range Click "Search" Enter a frequency at the
	 * high bound of the frequency range, and click "Search" Enter a frequency at
	 * the low bound of the frequency range, and click "Search" 5. The selected
	 * radio (along with others from the same manufacturer) appears in the search
	 * results. None of the returned radios cover a range that does not include that
	 * frequency. 6. The selected radio (along with others from the same
	 * manufacturer) appears in the search results. None of the returned radios
	 * cover a range that does not include that frequency. 7. The selected radio
	 * (along with others from the same manufacturer) appears in the search results.
	 * None of the returned radios
	 */
	/*
	 * LEGO-1681 - (AUTO UI) Create Antenna DB Search form and Lookup table COM-528
	 */
	@Test
	public void antDataBase_AllAntsWithGivenFrequencyAreDisplayed_whenInputValidLowFrequencyAndSearch() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase("", "Commscope", "Standard Performance", "P8F", "");
		database.evaluateAntennaDataSearchResult1(0, antennaCode2, "Commscope", "Standard Performance", "P8F-9", "S",
				"890 - 960");
		database.evaluateAntennaDataSearchResult2(0, antennaGainFor02306A, antenna3DBBWFor02306A,
				antenannaDiamaterFor02306A, "A", "RPE 2306", "1972/02/29");
		database.evaluateCompanyFamilyRow("Standard Performance");
	}

	@Test
	public void antDataBase_AllAntsWithGivenFrequencyAreDisplayed_whenInputValidHighFrequencyAndSearch() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase("", "Commscope", "Standard Performance", "P8F", "890");
		database.evaluateAntennaDataSearchResult1(0, antennaCode2, "Commscope", "Standard Performance", "P8F-9", "S",
				"890 - 960");
		database.evaluateAntennaDataSearchResult2(0, antennaGainFor02306A, antenna3DBBWFor02306A,
				antenannaDiamaterFor02306A, "A", "RPE 2306", "1972/02/29");
		database.evaluateCompanyFreqRow(890, 960);
	}

	/**
	 * COM-657 COM-701 Advanced Search 1. Click "Advanced Search" 2. The search bar
	 * expands to display the following additional fields: Status Gain (dBi)
	 * Application Diameter RPE Classification 3dB BW FCC Compliance
	 */

	@Test
	public void antDataBaseAdvancedSearch_NewAdvancedSearchFieldsWillDisplay_whenAdvancedSearchIsSelected() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("Active", "", "Point-to-Point", "", "", "All", "", "Select Compliance");

	}

	/**
	 * COM-657 Search by Status Run a search that will have a wide variety of
	 * results. A company with a large number of entries in the DB (Comsearch) or a
	 * commonly used frequency should give good results. Make a general note of the
	 * "Status" fields of the available antennas. Sorting by Status might help
	 * (Ideally, all three statuses will be represented.) Select "Active" status and
	 * search Select "Obsolete" status and search Select "Invalid" status and search
	 * 3. All "Active" antennas are displayed. 4. All "Obsolete" antennas are
	 * displayed. 5. All "Invalid" antennas are displayed.
	 */

	@Test
	public void antDataBaseAdvancedSearch_ActiveStatusWillBeReturnd_whenASearchByActive() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("Active", "25", "Point-to-Point", "", "", "All", "", "Select Compliance");
		database.evaluateAntennaDataActiveStatusResults();
	}

	@Test
	public void antDataBaseAdvancedSearch_InactiveStatusWillBeReturnd_whenASearchByObsolete() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("Inactive", "", "Point-to-Point", "", "", "All", "", "Select Compliance");
		database.evaluateAntennaDataObsoleteStatusResults();
	}

	@Test
	public void antDataBaseAdvancedSearch_InvalidStatusWillBeReturnd_whenASearchByInvalid() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("Invalid", "", "Point-to-Point", "", "", "All", "", "Select Compliance");
		database.evaluateAntennaDataInvalidStatusResults();
	}

	/**
	 * COM-657 Search by Classification Run the previous search again. Make note of
	 * the Classifications of the antennas available. (Ideally, all nine
	 * classifications will be represented, but that's not likely.) 1. Select each
	 * of the available classifications, one by one, and search for them. 2. Go into
	 * Swagger and verify that the same antennas are returned there.
	 */

	@Test
	public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByBillboard() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "", "Billboard", "", "Select Compliance");
		database.clickAndVal("1");
	}

	@Test
	public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByCylindricalParabola() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "", "Cassegrain Parabolic", "", "Select Compliance");
		database.clickAndVal("2");
	}

	@Test
	public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByHornParabolic() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "", "Horn Parabolic", "", "Select Compliance");
		database.clickAndVal("8");
	}

	/**
	 * COM-657 Search by RPE (Radio Pattern Envelope) Run the previous search again.
	 * Make note of the RPE field for the antennas available. 1. Pick one of the
	 * available RPE's and search for it. 2. The search results are the antennas
	 * that match that RPE.
	 */

	@Test
	public void antDataBaseAdvancedSearch_RBEWillBeReturnd_whenASearchByRBE() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "2319", "All", "", "Select Compliance");
		database.RPEVal("2319");
		database.evaluateAntennaDataBaseRPESearchResults("2319", 0);
	}

	/**
	 * COM-657 Search by Gain Run the previous search again. Make note of the gain
	 * values for the antennas available. Pick one of the available gain values and
	 * search for it. 1. Enter a range of gain values (such as 30:40) 2. The search
	 * results are the antennas that have that gain value.
	 */

	@Test
	public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByGain1() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "24.9", "All", "", "", "All", "", "Select Compliance");
		database.evaluateAntennaDatabaseGainSearchResults("24.9", 0);
	}

	@Test
	public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByGain2() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "20", "All", "", "", "All", "", "Select Compliance");
		database.evaluateAntennaDatabaseGainSearchResults("20", 0);
	}

	@Test
	public void antDataBaseAdvancedSearch_ClassificationWillBeReturnd_whenASearchByGain3() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "34.4", "All", "", "", "All", "", "Select Compliance");
		database.evaluateAntennaDatabaseGainSearchResults("34.4", 0);
	}

	/**
	 * COM-657 Search by Application and FCC Compliance Run the previous search
	 * again. Make note of the Compliance values for the antennas available. Pick
	 * one of the available Compliance values and search for it. Change
	 * "Application" to "ES Earth Station" Change "FCC Compliance" to "Select
	 * Compliance" Search Make note of the Compliance values for the antennas
	 * available. Pick one of the available Compliance values and search for it. 2.
	 * The search results are the antennas that have that Compliance value. 5. Earth
	 * Station antennas are returned in the search. 7. The search results are the
	 * antennas that have that Compliance value.
	 */

	@Test
	public void antDataBaseAdvancedSearch_AntWillBeReturnd_whenASearchByFCCCompliance1() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "Point-to-Point", "", "", "All", "", "A");
		database.evaluateAntennaDataBaseComplianceSearchResults("A", 0);
	}

	/**
	 * COM-657 Search by Diameter Change "Application" to "MW PtP Microwave
	 * PointtoPoint" and run the previous search again. Make note of the Diameter
	 * values for the antennas available. 1. Pick one of the available Diameter
	 * values and search for it. 2. The search results are the antennas that have
	 * that Diameter value.
	 */
	@Test
	public void antDataBaseAdvancedSearch_AntWillBeReturnd_whenASearchByDiameter() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "Point-to-Point", "8.01", "", "All", "", "Select Compliance");
		database.evaluateAntennaDataBaseDiameterSearchResults("2.44 / 8.01", 0);
		database.clearDiameter();
		database.submitAdvanceSearch("All", "", "All", "8.00", "", "All", "", "Select Compliance");
		database.evaluateAntennaDataBaseDiameterSearchResults("2.44 / 8.01", 0);
		database.clearDiameter();
		database.submitAdvanceSearch("All", "23", "All", "2", "", "All", "", "Select Compliance");
		database.evaluateAntennaDataBaseDiameterSearchResults("0.61 / 2.00", 0);
	}

	/**
	 * COM-653 Antenna Export COM-579 Navigate to Antenna Database Run a search (see
	 * above test cases for possible search criteria) Sort the results Click
	 * "Export" Open the resulting file 5. Data in the downloaded file matches the
	 * data on the screen.
	 */

	@Test
	public void antDataBaseAdvancedSearch_AntWillCreateCSVFile_whenAExportIsSelected() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "Point-to-Point", "8.01", "", "All", "", "Select Compliance");
		database.export();

	}

	/**
	 * COM-664 COM-582 Viewing Antenna Information Open the Lego project Click
	 * "Database Management" Click "Antenna Database" Search for any antenna code
	 * (Make a note of this antenna code for future test) Click on the antenna code
	 * from the search results to view the antenna info. Click "X" to close the
	 * antenna information window 5. The antenna information appears with the
	 * following details/sections for that particular antenna code: Basic
	 * Information Technical Information Regulatory Information Earth station
	 * Information Pattern Information Comments & Attachments 6. The window closes
	 * and will go back to search results page.
	 */

	@Test
	public void antDataBaseAdvancedSearch_AppropriateAntennaDataWillAppear_whenViewAntennaInfo() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase(antennaCode2, "Commscope", "Standard Performance", "", "950");
		database.evaluateAntennaDataSearchResult1(0, antennaCode2, "Commscope", "Standard Performance", "P8F-9", "S",
				"890 - 960");
		database.evaluateAntennaDataSearchResult2(0, antennaGainFor02306A, antenna3DBBWFor02306A,
				antenannaDiamaterFor02306A, "A", "RPE 2306", "1972/02/29");
	}

	@Test
	public void antDataBaseAdvancedSearch_antDetailSameAsOnAntDB_whenAAntCodeIsSelected() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "", "Omnidirectional", "", "Select Compliance");
		database.clickAndVal("10");
		database.antDbBasicInfoVal("00003L", "L-Com Global Connectivity", "", "HG72107U-PRO", "10", "", "2", "1");
		database.evaluateAntennaDatabaseTechecnicalInformation("698", "960", "4", "0.13", "55", "");
		database.evaluateAntennaDatabaseRegInformation("1", "6");
		database.antDbEarthStationVal("", "");
	}

	/**
	 * COM-664 Creating Antenna Continuing.. 1. Click "Create" button on the antenna
	 * database search window. 2. Click "Save" button 3. Click "X" to close the
	 * window and go back to search results page. 4. Click "Create" button again. 1.
	 * Antenna database window appears for creating new antenna. 2. The system
	 * should show error message or highlight all mandatory fields Antenna code
	 * Manufacturer Model Classification
	 */

	@Test
	public void antDataBaseAdvancedSearch_ErrorsWillAppear_whenClickCreate() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase(antennaCode2, "Commscope", "", "", "950");
		database.createAnt();
		database.saveCreatedAntenna();
		database.evaluateAntennaCompanyError();
		database.evaluateAntennaModelError();
		database.evaluateAntennaClassificationError();
		database.createAntLoFreqError();
		database.createAntHiFreqError();
		database.createAntMainbeamGainError();
		database.createAnt3DBeamwidthError();
	}

	/**
	 * COM-655 Form can populate from any selected antenna DB search result. Simply
	 * just click on the result to see its details.
	 * 
	 * Validation is in place for all present inputs.
	 * 
	 * Status Icon changes with status change.
	 * 
	 * Diameter value changes on unit change with logic in place to ensure values
	 * don't diminish on conversion.
	 * 
	 * Form footer buttons dynamically change if the antenna exists or not.
	 */

	@Test
	public void antDataBaseAdvancedSearch_StatusIconChangesWithStatushange_whenStatusIsChanged() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "", "Horn Parabolic", "", "Select Compliance");
		database.clickAndVal("8");
		database.antDbBasicInfoVal("07300E", "Troll Systems Corporation", "", "E-073-0032-00", "8", "", "", "1");
		database.evaluateAntennaDatabaseTechecnicalInformation("6425", "7200", "17", "", "30", "");
		database.evaluateAntennaDatabaseRegInformation("1", "6");
		database.antDbEarthStationVal("", "");
		database.selectAntennaDatabaseBasicInformationChangeStatus("Invalid");
		database.changeStatusred();
		database.selectAntennaDatabaseBasicInformationChangeStatus("Inactive");
		database.changeStatusYellow();
		database.selectAntennaDatabaseBasicInformationChangeStatus("Active");
		database.changeStatusGreen();

	}

	/**
	 * Creating Antenna Continuing.. Click "Create" button on the antenna database
	 * search window. Click "Save" button Click "X" to close the window and go back
	 * to search results page. Click "Create" button again. Antenna database window
	 * appears for creating new antenna. The system should show error message or
	 * highlight all mandatory fields Antenna code Manufacturer Model Classification
	 */
	@Test
	public void antDataBaseCreateAnt_antRequiredFieldsNotSatisfied_whenSaveIsSelected() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.saveCreatedAntenna();
		database.evaluateAntennaCompanyError();
		database.evaluateAntennaModelError();
		database.evaluateAntennaClassificationError();
		database.createAntLoFreqError();
		database.createAntHiFreqError();
		database.createAntMainbeamGainError();
		database.createAnt3DBeamwidthError();
	}

	/**
	 * Creating AntennaField validation Basic Information Continuing.. Antenna code
	 * field:
	 * 
	 * 
	 * Enter 6 characters Clear antenna code and enter a code with special
	 * characters Clear antenna code and enter antenna code with only numbers
	 * Antenna code should be restricted to 8 characters for 70-90 antennas
	 * 
	 * code."
	 * 
	 * System accept the value without any errors The system should allow antenna
	 * code with special characters. The system should show validation error on
	 * blur, At least one letter should be present in Antenna code
	 *
	 * Enter an antenna code that already exists in the database. It should check
	 * for uniqueness on blur. If the antenna code is not unique, validation error
	 * message should appear Error text: "Code is required to be unique. Please
	 * enter a unique
	 */

	@Test
	public void antDataBaseCreateAnt_EnterAntennaCodeThatAlreadyExists_whenUniqueError() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		String antennaCode = antennaCode2;
		database.enterAntennaDatabaseBasicInformationEntry(antennaCode, "Commscope", "Standard Performance", "P8F-9",
				"Billboard", "", "Dual", "Active");
		database.blurAntennaDatabase();
		database.enterAntennaDatabTechnicalInformationEntry("200", "300", "3", "3", "2.5", "2");
		database.enterAntennaDatabaseRegInformationEntry("Point-to-Point", "Select Compliance");
		database.enterPatternPoints("-180", "0", "180", "-2", "0", "-2");
		database.clickAntennaButton();
		database.evaluateErrorUniqueness("Antenna Code is not unique.");
	}

	/**
	 * COM-664 Enter an antenna code more than 6 characters The system should show
	 * an error message, entry field length should be restricted to 6 characters
	 */

	@Test
	public void antDataBaseCreateAnt_EnterAntennaCodeThatsMoreThan6_when6CharError() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.enterAntennaDatabaseBasicInformationEntry("02306AWAW", "", "", "", "Billboard", "", "Dual", "Active");
		database.blurAntennaDatabase();
		database.evaluateErrorUniqueness("6 characters max");
	}

	/**
	 * COM-655 Antenna Details Form - UI and Validation
	 */
	/**
	 * LEGO-3687 QA UI automation Calculate the 15dB Beamwidth upon Antenna Create
	 * (already happens upon update) LEGO-2793
	 */
	@Test
	public void antDataBaseCreateAnt_CreateAntenna_recordIsCreated() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.enterAntennaDatabaseBasicInformationEntryWithoutAntennaCode("Commscope", "Standard Performance",
				"P6F-9A", "Solid Parabolic", "", "Dual", "Active");
		database.enterAntennaDatabTechnicalInformationEntry("890", "960", "21.9", "6", "13", "24");
		database.enterAntennaDatabaseRegInformationEntry("Point-to-Point", "A");
		database.enterPatternPoints("-180", "-3", "-2.5", "0", "1.5", "180", "-24", "-0.4", "-0.3", "0", "0", "-24");
		database.clickAntennaButton();
		database.verifyAntennaCreateSuccessMessage();
		database.verifyAntenna15dbBeamwidth();
	}

	/**
	 * COM-700
	 */
	@Test
	public void antDataBaseCreateAnt_CreateAntennaTechInfoFieldValidationAlpha_MustBeNumericalValue() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.enterAntennaDatabTechnicalInformationEntry("AAA", "AAA", "AAA", "AAA", "AAA", "AAA");
		database.blurTechAntennaDatabase();
		database.evaluateErrorTextOnTechnicalInformation("Must be numerical value.", "Must be numerical value.",
				"Must be numerical value.", "Must be numerical value.", "Must be numerical value.",
				"Must be numerical value.");

	}

	@Test
	public void antDataBaseCreateAnt_CreateAntennaTechInfoFieldValidationSpecial_MustBeNumericalValue() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.enterAntennaDatabTechnicalInformationEntry("!@#", "!@#", "!@#", "!@#", "!@#", "!@#");
		database.blurTechAntennaDatabase();
		database.evaluateErrorTextOnTechnicalInformation("Must be numerical value.", "Must be numerical value.",
				"Must be numerical value.", "Must be numerical value.", "Must be numerical value.",
				"Must be numerical value.");
	}

	@Test
	public void antDataBaseCreateAnt_CreateAntennaTechInfoFieldValidationNegativeNum_MustBeNumericalValue() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.enterAntennaDatabTechnicalInformationEntry("-22", "-22", "-22", "-22", "-22", "-22");
		database.blurTechAntennaDatabase();
		database.evaluateErrorTextOnTechnicalInformation("Must be greater than or equal zero.",
				"Must be greater than or equal zero.", "Must be greater than or equal zero.",
				"Must be greater than or equal zero.", "Must be greater than or equal zero.",
				"Must be greater than or equal zero.");
	}

	/**
	 * COM-700
	 *
	 */

	@Test
	public void antDataBaseCreateAnt_CreateAntennaRegulatoryInformationt_FieldValidationDefaul() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.enterAntennaDatabaseRegInformationEntry("Point-to-Point", "Category A");
		database.blurAntennaDatabase();
		database.enterAntennaDatabaseRegInformationEntry("Point-to-Point", "Category B");
		database.blurAntennaDatabase();
		database.enterAntennaDatabaseRegInformationEntry("Point-to-Point", "Category B1");
		database.blurAntennaDatabase();
		database.enterAntennaDatabaseRegInformationEntry("Point-to-Point", "Category B2");
		database.blurAntennaDatabase();
		database.enterAntennaDatabaseRegInformationEntry("Earth Station", "S, Super Restricted");
		database.blurAntennaDatabase();
		database.enterAntennaDatabaseRegInformationEntry("Earth Station", "U, Useable but Questionable");
		database.blurAntennaDatabase();
		database.enterAntennaDatabaseRegInformationEntry("Earth Station", "R, Restricted");

		database.evaluateAntennaDatabaseRegInformation("2", "8");
	}

	/**
	 * Manufacturer auto-suggest COM-632 Continuing: 1. Enter the first three digits
	 * of the manufacturer in the "Manufacturer" field 2. Pick a manufacturer 1. A
	 * dropdown appears with all of the manufacturers that start with those three
	 * characters 2. The field is populated with that maunfacturer
	 */
	@Test
	public void antDataBaseCreateAnt_EnterTheFirstThreeDigitsOfTheManufacturer_ADropdownAppearsWithAllOfTheManufacturersThatStart() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.enterAntennaDatabaseBasicInformationEntry("656541", "Com", "Commscope Family", "P8F-9",
				"Horn Parabolic", "YYYYYY", "Dual", "Active");

	}

	/**
	 * COM-696 Discrimination Calculator (Sprint 16) COM-574 Continuing: 1. Click
	 * "Discrimination Calculator" in the lower right. 2. Enter alpha characters in
	 * the discrimination angle field and click the calculate button 3. Enter an
	 * angle in the discrimination angle field and click the calculate button 4.
	 * Click the "X" in the upper right 1. The Discrimination Calculator window
	 * opens. 2. The field does not accept non-numeric information 3. The
	 * discrimination values (in dB) are calculated from the antenna pattern and
	 * populate the table. The total gain (antenna gain minus discrimination) is
	 * also populated. 4. The Discrimination Calculator window closes. Close Antenna
	 * Pattern Continuing: 1. On the Antenna Pattern window, click "X" in the upper
	 * right 1. The Antenna Pattern window closes.
	 */
	@Test
	public void antDataBaseCreateAnt_EnterInvalidChars_ValidateThatAppropriateErrorsAreReturned() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "2319", "All", "", "Select Compliance");
		database.RPEVal("2319");
		database.selectAntennaRow(0);
		database.enterDiscriminationAngle("DKD");
		database.closeDiscriminationAngleForm();
		database.enterDiscriminationAngle("777");
		database.closeDiscriminationAngleForm();
	}

	/**
	 * COM-700 Continuing.. Manufacturer field: 1. Put the cursor on this field 2.
	 * As user types, filter down the list in a scrollable window 3. Support
	 * wildcard characters 1. Show a list of all possible manufacturers (scrollable)
	 * 2. Require user to choose a manufacturer from the list, auto suggest works
	 */
	@Test
	public void antDataBaseCreateAnt_SelectManufacturers_WithClicksWildCardsAndPartials() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.evaluateAntennaManufacturerSuggestionDatabaseBasicInformation("%sco%", "Commscope");
		database.evaluateAntennaManufacturerSuggestionDatabaseBasicInformation("%sco%", "Commscope");
		database.evaluateAntennaManufacturerSuggestionDatabaseBasicInformation("Comms", "Commscope");
		database.evaluateAntennaManufacturerSuggestionDatabaseBasicInformation("%ope", "Commscope");

	}

	/**
	 * COM-700 Continuing.. Model family field: 1. Put the cursor on this field 2.
	 * As user types, filter down the list in a scrollable window 3. Support
	 * wildcard characters 4. Click "+" icon to add a new model family <incomplete -
	 * visit later> 1. Show a list of all possible model families (scrollable) 2.
	 * Require user to choose a model family from the list; not editable
	 */
	@Test
	public void antDataBaseCreateAnt_SelectModelFamily_WithClicksWildCardsAndPartials() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.evaluateModelFamilySuggestionListDatabaseBasicInformation("Com", "CompactLine Ultra High Performance");
		database.evaluateModelFamilySuggestionListDatabaseBasicInformation("Standard", "Standard Performance");

	}

	/**
	 * COM-700 Continuing.. Model field: 1. Enter more than 30 characters 2. Enter
	 * 30 characters 3. This should be an editable field. 1. Entry field length
	 * should be restricted to 30 characters 2. System accepts without any errors
	 */

	@Test
	public void antDataBaseCreateAnt_Enter30CharsModelFamily_ErrorCannotExceed30Characters() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.submitModelFamilyAntennaDatabaseEntry("Thirty Is the Limit  Thirty Is the Limit Thirty Is the Limit");
		database.evaluateAntennaDatabaseModelFamilyError("30 characters max");
	}

	/**
	 * COM-700 Continuing.. Classification dropdown field should have the following
	 * options 1. Billboard 2. Cassegrain Parabolic 3. Corner Reflector 4.
	 * Cylindrical Parabola 5. Dipole 6. Grid Parabolic 7. Gaussian Lens 8. Horn
	 * Parabolic 9. Offset Feed Parabola 10. Omnidirectional 11. Panel 12. Prime
	 * Focus Parabola 13. Prime Focus Torus 14. Sector 15. Solid Parabolic 16. Yagi
	 */
	@Test
	public void antDataBaseCreateAnt_EnterClassifications_ADropdownAppearsWithAllOfTheClassifications() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		for (String value : antennaClassificationArray) {
			database.enterAntennaDatabaseBasicInformationEntry("", "", "", "", value, "", "Dual", "Active");
		}

	}

	/**
	 * Continuing..COM-700 Feed Direction field: The user should be able to select
	 * options: LF - Left Feed, RF - Right Feed and "None". (None should be the
	 * default) Continuing.. Associated Antenna Code field: 1. Type in an antenna
	 * code. 2. Clear Associated Antenna Code field and click the lookup icon 1. The
	 * antenna code should exist in the database else system will throw an error
	 * message. 2. User should be able to find antennas and the antennas are not
	 * restricted by band Continuing.. 1. Polarized field should be a dropdown,
	 * withe the following options. D - Dual S - Single C - Circular None 2. Click
	 * "Save" 3. Click cancel or discard
	 * 
	 * 1. The default should be null 2. Validate that a polarization is entered and
	 * give user a warning: "You have not set a polarization for this antenna. Are
	 * you sure you want to proceed?"
	 */

	@Test
	public void antDataBaseCreateAnt_EnterAssociatedAntennaCode_AntennaCodeShouldExistInTheDatabaseElseSystemWillError() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.associateAntennaCode("06970D", "06970R");
		for (String value : polarizedList) {
			database.selectPolarizedEntryFromAntennaDatabase(value);
		}

	}

	@Test
	public void antDataBaseCreateAnt_EnterValidInputs_AntennaCreated() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.createAnt();
		database.associateAntennaCode("06970D", "06970R");
		database.enterAntennaDatabaseBasicInformationEntry("06970D", "DRAGONWAVE INC", "", "A-ANT-23G-36-C-R",
				"Solid Parabolic", "YYYYYY", "Single", "Active");
		database.enterAntennaDatabTechnicalInformationEntry("21200", "23600", "43.7", "2.99", "1.1", "68");
		database.enterAntennaDatabaseRegInformationEntry("Point-to-Point", "Category A");
		database.enterAntennaDatabaseEarthStationFieldValues("", "");
		database.saveCreatedAntenna();

	}

	/**
	 * COM-700 Verify copy paste for antenna patterns for data separated with only
	 * partial commas COM-625 Continuing.. 1. Download the attachment for antenna
	 * info with partial comma from this confluence page 2. Copy the antenna
	 * discrimination value section from it and paste it onto the last cell of the
	 * pattern. 3. The value should get populated correctly in the respective cells.
	 */

	@Test
	public void antDataBasePattern_valueShouldGetPopulatedInRespectiveCells_whenCopyAntennaDiscrimination() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "2319", "All", "", "Select Compliance");
		database.RPEVal("2319");
		database.selectAntennaRow(0);
		database.copyPattern();
	}

	/**
	 * COM-698 Antenna Pattern Entry/Edit Verify copy paste for antenna patterns for
	 * data separated with commas. COM-625 Continuing.. 1. Clear the antenna pattern
	 * value. 2. Download the attachment for antenna info with comma from this
	 * confluence page 3. Copy the antenna discrimination value section from it and
	 * paste it onto the first cell of the pattern. 3. The value should get
	 * populated correctly in the respective cells.
	 * 
	 * Verify copy paste for antenna patterns for data separated with spaces. -space
	 * - delimited COM-625 Continuing.. 1. Clear the antenna pattern value. 2.
	 * Download the attachment for antenna info with space from this confluence page
	 * 3. Copy the antenna discrimination value section from it and paste it to the
	 * third cell of the pattern. 3. The value should get populated correctly in the
	 * respective cells.
	 */

	@Test
	public void antDataBasePattern_valueShouldGetPopulatedInRespectiveCells_whenCopyAntennaDiscriminationValue() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "2319", "All", "", "Select Compliance");
		database.RPEVal("2319");
		database.selectAntennaRow(0);
		database.openComments();
		database.enterPaternInComments("0   0\n" + "0.23    0\n" + "0.65    -1.7\n" + "1   -5\n" + "1.2 -8\n"
				+ "1.5 -13.5\n" + "2.5 -13.5\n" + "3   -16\n" + "3.5 -22\n" + "5   -25.5\n" + "15  -46\n" + "18  -46\n"
				+ "45  -85\n" + "100 -73\n" + "180 -73");
		database.copyPatternText();
		database.saveComments();
		database.clearPattern();
		if (firefox.equals("firefox")) {
			// https://github.com/SeleniumHQ/selenium/issues/2285
			// https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/5919
			database.pastePattern();
			database.evaluatePattern(0, "0", "0");
			database.evaluatePattern(1, "0.23", "0");
			database.evaluatePattern(2, "0.65", "-1.7");
			database.evaluatePattern(3, "1", "-5");
			database.evaluatePattern(4, "1.2", "-8");
			database.evaluatePattern(5, "1.5", "-13.5");
			database.evaluatePattern(6, "2.5", "-13.5");
			database.evaluatePattern(7, "3", "-16");
			database.evaluatePattern(8, "3.5", "-22");
			database.evaluatePattern(9, "5", "-25.5");
			database.evaluatePattern(10, "15", "-46");
			database.evaluatePattern(11, "18", "-46");
			database.evaluatePattern(12, "45", "-85");
			database.evaluatePattern(13, "100", "-73");
			database.evaluatePattern(14, "180", "-73");
		} else {
		}

	}

	@Test
	public void antDataBasePattern_valueShouldGetPopulatedInRespectiveCells_whenCopyAntennaDiscriminationValueWith() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "2319", "All", "", "Select Compliance");
		database.RPEVal("2319");
		database.selectAntennaRow(0);
		database.openComments();
		database.enterPaternInComments("0   0\n" + "0.23    0\n" + "0.65    -1.7\n" + "1   -5\n" + "1.2 -8\n"
				+ "1.5 -13.5\n" + "2.5 -13.5\n" + "0   0\n" + "3.5 -22\n" + "5   -25.5\n" + "15  -46\n" + "18  -46\n"
				+ "45  -85\n" + "100 -73\n" + "180 -73");
		database.copyPatternText();
		database.closeCommentsWithX();
		database.clearPattern();
		if (firefox.equals("firefox")) {
			// https://github.com/SeleniumHQ/selenium/issues/2285
			// https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/5919
			database.pastePattern();
			database.evaluatePattern(0, "0", "0");
			database.evaluatePattern(1, "0.23", "0");
			database.evaluatePattern(2, "0.65", "-1.7");
			database.evaluatePattern(3, "1", "-5");
			database.evaluatePattern(4, "1.2", "-8");
			database.evaluatePattern(5, "1.5", "-13.5");
			database.evaluatePattern(6, "2.5", "-13.5");
			database.evaluatePattern(7, "0", "0");
			database.evaluatePattern(8, "3.5", "-22");
			database.evaluatePattern(9, "5", "-25.5");
			database.evaluatePattern(10, "15", "-46");
			database.evaluatePattern(11, "18", "-46");
			database.evaluatePattern(12, "45", "-85");
			database.evaluatePattern(13, "100", "-73");
			database.evaluatePattern(14, "180", "-73");
		} else {
		}

	}

	@Test
	public void antDataBasePattern_valueShouldGetPopulatedInRespectiveCells_whenCopyPasteAntennaCommas() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "2319", "All", "", "Select Compliance");
		database.RPEVal("2319");
		database.selectAntennaRow(0);
		database.openComments();
		database.enterPaternInComments("-180,-54,\n" + "-110,-54,\n" + "-79,-46,\n" + "-18,-43,\n" + "-1,-25,\n"
				+ "1,-25, \n" + "18,-43,\n" + "79,-46, \n" + "110,-54,\n" + "180,-54");
		database.copyPatternText();
		database.closeCommentsWithX();
		database.clearPattern();
		if (chrome.equals("chrome")) {

		} else {
			database.pastePattern();
			database.evaluatePattern(0, "-180", "-54");
			database.evaluatePattern(1, "-110", "-54");
			database.evaluatePattern(2, "-79", "-46");
			database.evaluatePattern(3, "-18", "-43");
			database.evaluatePattern(4, "-1", "-25");
			database.evaluatePattern(5, "1", "-25");
			database.evaluatePattern(6, "18", "-43");
			database.evaluatePattern(7, "79", "-46");
			database.evaluatePattern(8, "110", "-54");
			database.evaluatePattern(9, "180", "-54");
		}
	}

	/**
	 * COM-698 Verify copy paste for antenna patterns for data separated with only
	 * partial commas COM-625 Continuing.. 1. Download the attachment for antenna
	 * info with partial comma from this confluence page 2. Copy the antenna
	 * discrimination value section from it and paste it onto the last cell of the
	 * pattern. 3. The value should get populated correctly in the respective cells.
	 * Copying the antenna points from the Antenna pattern table COM-625
	 * Continuing.. 1. Click on the copy icon at the bottom pf pattern points table.
	 * 2. (Import into a new antenna?) 1. The pattern points are exported to a file.
	 * 
	 */

	@Test
	public void antDataBasePattern_valueShouldGetPopulatedInRespectiveCells_whenCopyPasteAntennaPartialCommas() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "2319", "All", "", "Select Compliance");
		database.RPEVal("2319");
		database.selectAntennaRow(0);
		database.openComments();
		database.enterPaternInComments("-180,-54,\n" + "-110,-54\n" + "-79,-46\n" + "-18,-43\n" + "-1,-25\n"
				+ "1,-25 \n" + "18,-43\n" + "79,-46 \n" + "110,-54\n" + "180,-54");
		database.copyPatternText();
		database.closeCommentsWithX();
		database.clearPattern();

		if (firefox.equals("firefox")) {
			// https://github.com/SeleniumHQ/selenium/issues/2285
			// https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/5919
			database.pastePattern();
			database.evaluatePattern(0, "-180", "-54");
			database.evaluatePattern(1, "-110", "-54");
			database.evaluatePattern(2, "-79", "-46");
			database.evaluatePattern(3, "-18", "-43");
			database.evaluatePattern(4, "-1", "-25");
			database.evaluatePattern(5, "1", "-25");
			database.evaluatePattern(6, "18", "-43");
			database.evaluatePattern(7, "79", "-46");
			database.evaluatePattern(8, "110", "-54");
			database.evaluatePattern(9, "180", "-54");
		} else {
		}
	}

	/**
	 * COM-694 Flip Pattern COM-634 Continuing.. 1. Click "Flip Pattern" button. 2.
	 * Click "X" 3. Click "Flip Pattern" button again and click "Flip pattern" on
	 * the confirmation screen. 1. Flip Pattern Warning Confirmation window appears.
	 * 2. The Flip Pattern Warning Confirmation window closes and the patters will
	 * not be flipped. 3. Reverse signs on all entered angles for all four pat_pols
	 * and reorder in ascending order
	 */
	@Test
	public void antDataBasePattern_valueShouldGetPopulatedInRespectiveCells_whenFlipPattern() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "2319", "All", "", "Select Compliance");
		database.RPEVal("2319");
		database.selectAntennaRow(0);
		database.openComments();
		database.enterPaternInComments("0   0\n" + "0.23    0\n" + "0.65    -1.7\n" + "1   -5\n" + "1.2 -8\n"
				+ "1.5 -13.5\n" + "2.5 -13.5\n" + "0   0\n" + "3.5 -22\n" + "5   -25.5\n" + "15  -46\n" + "18  -46\n"
				+ "45  -85\n" + "100 -73\n" + "180 -73");
		database.copyPatternText();
		database.closeCommentsWithX();
		database.clearPattern();
		if (firefox.equals("firefox")) {
			// https://github.com/SeleniumHQ/selenium/issues/2285
			// https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/5919
			database.pastePattern();
			database.evaluatePattern(0, "0", "0");
			database.evaluatePattern(1, "0.23", "0");
			database.evaluatePattern(2, "0.65", "-1.7");
			database.evaluatePattern(3, "1", "-5");
			database.evaluatePattern(4, "1.2", "-8");
			database.evaluatePattern(5, "1.5", "-13.5");
			database.evaluatePattern(6, "2.5", "-13.5");
			database.evaluatePattern(7, "0", "0");
			database.evaluatePattern(8, "3.5", "-22");
			database.evaluatePattern(9, "5", "-25.5");
			database.evaluatePattern(10, "15", "-46");
			database.evaluatePattern(11, "18", "-46");
			database.evaluatePattern(12, "45", "-85");
			database.evaluatePattern(13, "100", "-73");
			database.evaluatePattern(14, "180", "-73");
			database.submitFlipPattern();
			database.evaluatePattern(14, "0", "0");
			database.evaluatePattern(13, "-0.23", "0");
			database.evaluatePattern(12, "-0.65", "-1.7");
			database.evaluatePattern(11, "-1", "-5");
			database.evaluatePattern(10, "-1.2", "-8");
			database.evaluatePattern(9, "-1.5", "-13.5");
			database.evaluatePattern(8, "-2.5", "-13.5");
			database.evaluatePattern(7, "0", "0");
			database.evaluatePattern(6, "-3.5", "-22");
			database.evaluatePattern(5, "-5", "-25.5");
			database.evaluatePattern(4, "-15", "-46");
			database.evaluatePattern(3, "-18", "-46");
			database.evaluatePattern(2, "-45", "-85");
			database.evaluatePattern(1, "-100", "-73");
			database.evaluatePattern(0, "-180", "-73");
		} else {

		}
	}

	/**
	 * COM-665
	 */
	@Test
	public void antDataBasePattern_CommentsShouldSave_whenEnteringComments() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		database.submitAdvanceSearch("All", "", "All", "", "2319", "All", "", "Select Compliance");
		database.RPEVal("2319");
		database.selectAntennaRow(0);
		database.openComments();

		database.enterPaternInComments(
				"This comment field can be used for lots of comments field can be used for lots of commentsThis commen");
		// database.saveComments();
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		// LocalDate localDate = LocalDate.now();
		// String gotDate = dtf.format(localDate);
		// database.evaluateComments("2017/09/21\n" +
		// "Test Comment Lego Admin");

	}

	/**
	 * rewritten by @author nshaji LEGO-765 LEGO-8157 : QA AUTO LEGO-8009: UI:
	 * Ability to delete attachments across the whole application
	 */
	@Test
	public void antDataBaseComment_attachementShouldSave_whenAddingOneFileToComment() {
		String antennaCode = "Test12";
		database.accessAntennaDataBase();
		database.createAnt();
		database.enterAntennaDatabaseBasicInformationEntry(antennaCode, ANTENNA_COMPANY, "", ANTENNA_MODEL,
				ANTENNA_CLASSIFICATION, "", ANTENNA_STATUS, ANTENNA_POLARIZATION);
		database.enterAntennaDatabTechnicalInformationEntry(LOW_FREQUENCY, HIGH_FREQUENCY, MAINBEAM_GAIN, "", BEAMWIDTH,
				"");
		database.enterAntennaDatabaseRegInformationEntry(APPLICATION, FCC_COMPLIANCE);
		database.enterPatternPoints("-180", "-3", "-2.5", "0", "1.5", "180", "-24", "-0.4", "-0.3", "0", "0", "-24");
		database.clickSaveButton();
		database.clickPage();
		database.openComments();
		database.enterPaternInComments("This comment");
		if (host.equals("cloud")) {
		} else {
			String commentFileName = "commentAttachment1.txt";
			database.selectAndUploadFile(commentFileName);
			database.evaluateAttachmentListEnd(commentFileName.toLowerCase());
		}
		database.deleteAttachment();
		database.clickDeleteAntenna();
	}

	/*
	 * LEGO-707 or COM-648: UI/UX Add Reference Code to Antenna DB advanced search
	 */
	@Test
	public void antReferenceCode_ShouldReturnAntennas_WhenSearchByReferenceCode() {
		database.accessAntennaDataBase();
		database.openAdvancedSearch();
		// get the required data to validate reference code search by using the
		// manufacturer field
		String manufacturerValue = database.getManufacturer();
		String antennaCode = database.searchManufacturer_getAntennaCodeFromResults(manufacturerValue);
		String referenceCode = database.getReferenceCodeFromAntennaCode(antennaCode);
		database.advancedSearchReferenceCode(referenceCode, antennaCode);

	}

	/**
	 * LEGO-718 Test Procedure: Open Lego Dev site Open Antenna DB Search for
	 * antenna code 31216S Click to open it Add a comment Save Return to Summary
	 * Reopen in Antenna Details to confirm that the comment is still there Click
	 * "Copy" Antenna Details opens with the copy of the antenna (in my case, code
	 * 58050A) Scroll down and check comments ERROR: The comment is not present.
	 */
	@Test
	public void antDataBaseComment_commentShouldCopyToNewAntenna_whenCopyAntenna() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase(antennaCode5, "", "", "", "");
		database.selectAntennaRow(0);
		database.openComments();
		database.enterPaternInComments("D");
		database.saveComments();
		database.copyAntenna();
		database.clickPage();
		database.openComments();
		database.evaluateComment("");

	}

	/**
	 * LEGO-721
	 */
	@Test
	public void antDataBaseComment_createButtonWillDisAppear_whenOnlyDataBaseaSelected() {
		loginPage.logout();
		loginPage.selectUserAndLogin("engineer");
		database.accessAntennaDataBase();
		database.evaluateCreateButtonIsNotPresent();
		database.searchAntennaDatabase(antennaCode5, "", "", "", "");
		database.selectAntennaRow(0);
		database.verifyAntennaPageReadOnly();

	}

	@Test
	public void antDataBaseComment_createButtonWillAppear_whenDataBaseaAndManagementIsSelected() {
		database.accessAntennaDataBase();
		database.evaluateCreateButtonIsPresent();
	}

	@Test
	public void antDataBaseComment_createButtonWillDisAppear_whenDataBaseaAndManagementIsSelected() {
		loginPage.logout();
		loginPage.selectUserAndLogin("engineer");
		database.accessAntennaDataBase();
		database.evaluateCreateButtonIsNotPresentAndExprortIsDisabled();
	}

	/*
	 * LEGO-1593:(AUTO UI) UI/UX: Add AutoSuggest functionality to Antenna Summary
	 * Search COM-632
	 */
	@Test
	public void antDataBaseSearchAnt_EnterTheFirstThreeDigitsOfTheManufacturer_verifyOtherBasicSearches() {
		database.accessAntennaDataBase();
		database.antennaBasicSearch_BasicSearchValidation("Commscope", "", "");
	}

	/*
	 * LEGO-1599 : (AUTO UI) UI/UX: Reference Code Lookup and functionality
	 * LEGO-1017
	 */
	@Test
	public void antDataBaseDetails_PatternInfoFieldValidation_ReferenceCodeLookup() {
		database.accessAntennaDataBase();
		database.createAnt();
		database.verifyAntennaPatterInfoFieldValidation();

	}

	/*
	 * LEGO-2027 : (AUTO UI) Integrate Antenna Discrimination Calculation API
	 * LEGO-792
	 */
	@Test
	public void antennaDatabase_AntennaDetails_VerifyAntennaDiscrimination() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase(antennaCode4, "", "", "", "");
		database.clickFirstAntennaResultFromAntennaSearchResulst();
		database.verifyAntennaDiscriminationValueFromAntennaDetailsPage();
	}

	/*
	 * LEGO-2163 : AUTO UI: Add unit toggle between meters and feet in Antenna
	 * Database LEGO-2012
	 */
	@Test
	public void antDataBaseDetails_MeterFeetToggle_VerifyMeterToFeetConversion() {
		database.accessAntennaDataBase();
		database.createAnt();
		database.verifyConversionSite1AntennaCenterlineFeetToMeter("12", "39.37");
	}

	/*
	 * LEGO-2795:AUTO UI: On antenna save, stay on the Antenna Details page and
	 * fetch the updated antenna data LEGO-2657
	 */
	@Test
	public void antennaDatabase_AntennaDetails_VerifyAntennaSaveStaysOnDetailsPage() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase(antennaCode4, "", "", "", "");
		database.clickFirstAntennaResultFromAntennaSearchResulst();
		database.clickSaveButton();
		database.verifyAntennaUpdateMessage();
	}

	/**
	 * LEGO-2612 : Validate that the VV pattern is always populated for an antenna
	 */

	@Test
	public void antennaDatabase_VVPatternShouldExist_VerifyVVPatternPopulates() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase(antennaCode4, "", "", "", "");
		database.clickFirstAntennaResultFromAntennaSearchResulst();
		database.copyAntenna();
		database.clickCreateAntennaButtonInCopyPrompt();
		database.verifyCopyMessage("COPY SUCCESS");
		database.clickPage();
		database.verifyVVPattern();

	}

	/**
	 * LEGO-2976 : Give user a modal to change the antenna code before completing
	 * the Copy LEGO-2790
	 * 
	 * @param copyAntennaErrorMsg - copy antenna code error message
	 */

	@Test
	public void antennaDatabase_CopyAntenna_VerifyAntennaCodeChangeModal() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase(antennaCode1, "", "", "", "");
		database.clickFirstAntennaResultFromAntennaSearchResulst();
		database.copyAntenna();
		String newAntennaCode = database.verifyCopyAntennaModal();
		database.clickCreateAntennaButtonInCopyPrompt();
		database.verifyCopyMessage("COPY SUCCESS");
		database.clickPage();
		database.clickSaveButton();
		database.clickPage();
		database.clickReturnAntennaDetails();
		database.searchAntennaDatabase(newAntennaCode, "", "", "", "");
		database.clickFirstAntennaResultFromAntennaSearchResulst();
		database.deleteCopiedAntenna();
	}

	/**
	 * LEGO-2979 : AUTO UI: Show required fields upon opening a form (update all
	 * input components to display errors when pristine)LEGO-2753 AntennaDetails
	 * form
	 */
	/**
	 * LEGO-3913 : QA Automation UI: Make Antenna Application and Compliance
	 * required LEGO-3267
	 */
	@Test
	public void antennaDatabase_AntennaDetailsForm_VerifyRequiredFields() {
		database.accessAntennaDataBase();
		database.clickCreateAntennaButton();
		database.verifyAntennaDetailsInAntennaDatabase();
	}

	/**
	 * LEGO-3686 : 2018 QA UI automation: UI: Add pagination to antenna search +
	 * messaging for radio and antenna csv's LEGO-3506
	 */
	/**
	 * LEGO-3691 :QA UI automation for API: Add pagination to antenna database
	 * search LEGO-3507
	 */
	@Test
	public void antennaDatabase_AddPagination_VerifyPagination() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase("", "", "", "", "6100");
		database.verifyPagination();
		database.clickExportAndVerifyExportMessage();

	}

	/**
	 * LEGO-3914 : QA Automation UI: Allow Discrimination Pattern to be calculated
	 * before save, change to supply pattern points instead of antenna_spec ID
	 * LEGO-3786
	 */
	@Test
	public void antennaDatabase_AntennaDiscrimination_CalculateDiscriminationBeforeSave() {
		database.accessAntennaDataBase();
		database.clickCreateAntennaButton();
		database.clickAntennaDiscrimination();
		database.typeDisciminationAngleInCalculator("40");
		database.verifyDiscriminationErrorMessage("Antenna must have a gain defined to calculate.");
		database.closeDiscriminationAngleForm();
		database.enterAntennaDatabaseGain("3");
		database.clickAntennaDiscrimination();
		database.typeDisciminationAngleInCalculator("40");
		database.verifyDiscriminationErrorMessage("Antenna must have pattern information defined to calculate.");
		database.closeDiscriminationAngleForm();
		database.enterPatternPoints("-180", "-3", "-2.5", "0", "1.5", "180", "-24", "-0.4", "-0.3", "0", "0", "-24");
		database.clickAntennaDiscrimination();
		database.typeDisciminationAngleInCalculator("40");
		database.verifyDiscriminationAndGain("-5.18", "-2.18");

	}

	/**
	 * QA AUTO UI Remove uniqueness constraint on Antenna Code LEGO-6656
	 */
	@Test
	public void antennaDatabase_deleteAndCreateAntenna_checkAntennaCodeIsUnique() {
		database.accessAntennaDataBase();
		database.searchAntennaDatabase(antennaCode1, "", "", "", "");
		database.clickFirstAntennaResultFromAntennaSearchResulst();
		database.copyAntenna();
		database.clickCreateAntennaButtonInCopyPrompt();
		database.clickPage();
		String copiedAntennaCode = database.getAntennaCodeFromAntennaDetails();
		database.deleteCopiedAntenna();
		database.createAnt();
		database.enterAntennaDatabaseBasicInformationEntry(copiedAntennaCode, ANTENNA_COMPANY, "", ANTENNA_MODEL,
				ANTENNA_CLASSIFICATION, "", ANTENNA_STATUS, ANTENNA_POLARIZATION);
		database.enterAntennaDatabTechnicalInformationEntry(LOW_FREQUENCY, HIGH_FREQUENCY, MAINBEAM_GAIN, "", BEAMWIDTH,
				"");
		database.enterAntennaDatabaseRegInformationEntry(APPLICATION, FCC_COMPLIANCE);
		database.enterPatternPoints("-180", "-3", "-2.5", "0", "1.5", "180", "-24", "-0.4", "-0.3", "0", "0", "-24");
		database.clickSaveButton();
		database.clickPage();
		database.clickReturnAntennaDetails();
		database.createAnt();
		database.enterAntennaDatabaseBasicInformationEntry(copiedAntennaCode, ANTENNA_COMPANY, "", ANTENNA_MODEL,
				ANTENNA_CLASSIFICATION, "", ANTENNA_STATUS, ANTENNA_POLARIZATION);
		String uniqueErrorMessage = "Antenna Code is not unique.";
		database.evaluateErrorUniqueness(uniqueErrorMessage);
	}

	/**
	 * LEGO-3691 : QA UI automation for API: Add pagination to antenna database
	 * search LEGO-3507
	 */

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
