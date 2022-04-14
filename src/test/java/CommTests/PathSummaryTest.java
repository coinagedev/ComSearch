package CommTests;

import CommPageObjects.BasePage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.QuickAddPage;
import CommPageObjects.PathDataBasePage;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class PathSummaryTest extends BaseTest {
	private PathSummaryPage pathSummary;
	private PathDataBasePage pathDBpage;
	private CreateNewPathPage createPath;
	private QuickAddPage quickAdd;
	private LoginPage login;
	private static final String STR_CO_CODE = "BRAINS";
	private static final String BAND_DESCRIPTION_23 = "23 GHz (21200-23600 MHz) US";
	private static final String BAND_DESCRIPTION_4 = "4 GHz (3700-4200 MHz) US";
	private static final String STR_SITENAME_PARTIAL = "ASR-Call";
	private static final String STR_SITENAME_1 = "ASR-Call1";
	private static final String STR_SITENAME_2 = "ASR-Call2";
	private static final String CALLSIGN1 = "RXONLY";
	private static final String CALLSIGN3 = "KA2049";
	private static final String ASR1 = "1000036";
	private static final String LATITUDE1 = "40 44 54.0 N";
	private static final String LONGITUDE1 = "73 59 09.0 W";
	private static final String LATITUDE2 = "40 42 46.8 N";
	private static final String LONGITUDE2 = "74 00 47.3 W";
	private static final String ELEVATION1 = "47.6";
	private static final String ELEVATION2 = "6.62";
	private static final String EXISTINGSITE_PARTIAL = "Bluemo";
	private static final String EXISTINGSITE_LAT = "39 8 16.4 N";
	private static final String EXISTINGSITE_LONG = "77 49 57.6 W";
	private static final String EXISTINGSITE_ELEV = "1349.08";
	private static final String LATITUDE3 = "39 08 17.0 N";
	private static final String LONGITUDE3 = "77 49 56.6 W";
	private static final String ELEVATION3 = "1349.08";
	private static final String RCN = "20020530";

	@Before
	public void Setup() {

		if (host != "localhost") {}

		pathSummary = new PathSummaryPage(driver);
		pathDBpage = new PathDataBasePage(driver);
		createPath = new CreateNewPathPage(driver);
		quickAdd = new QuickAddPage(driver);
		login = new LoginPage(driver);
		login.selectUserAndLogin("admin");

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/*
	 * COM-240
	 */

	@Test
	public void copyPath() {
		createPath.createBrandNewProjectPath("Project A" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, "");
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, STR_SITENAME_1, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.selectCopyFromPath();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, STR_SITENAME_1, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.viewSiteCallSignLatLongGeColumns2(0, STR_SITENAME_2, LATITUDE1, LONGITUDE1, ELEVATION1);
		pathSummary.sceenNotInactiveWhileSaving();
	}

	// Given that user is viewing the Project Summary header,
	// When user views the filter,
	// Then Site Frequency Band will be the default dropdown input.
	@Test
	public void valDefaultFilterValue() {
		createPath.createBrandNewProjectPath("Project A" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, "");
		pathSummary.sceenNotInactiveWhileSaving();
		assertEquals("Band is not the default dropdown input", "band", pathSummary.defaultFilterValue());
	}
	// COM 102

	/**
	 * COM 125
	 */
	@Test
	public void valFilterResultSet() {
		createPath.enterProjectForCompany("valFilterResultSet" + randomNumber + "f", "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION1, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 2", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION1, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 3", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION1, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 4", BAND_DESCRIPTION_4, "KGO-TV", LATITUDE2, LONGITUDE2, ELEVATION1,
				STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, ASR1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 5", BAND_DESCRIPTION_4, "KGO-TV", LATITUDE2, LONGITUDE2, ELEVATION1,
				STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, ASR1);
		quickAdd.closeWarning();
		pathSummary.sceenNotInactiveWhileSaving();
		pathSummary.filter("Band", "23");
		pathSummary.showAllPathsWithNoAssignedFrequencyBandsPresent();
		assertEquals(pathSummary.showAllCheckBoxText(), "Show all Paths with No Assigned Frequency Bands");
		pathSummary.validateBandFilteredResult("Test Path 1");
		pathSummary.filter("Path Name", "Test Path 3");
		pathSummary.validatePathNameFilteredResult("Test Path 3");
		pathSummary.filter("Antenna Code", "NOT READY");
		pathSummary.showAllPathsWithNoAssignedFrequencyBandsPresent();

		pathSummary.filter("Antenna Model", "NOT READY");
		pathSummary.showAllPathsWithNoAssignedFrequencyBandsPresent();

		pathSummary.filter("Radio Code", "NOT READY");
		pathSummary.showAllPathsWithNoAssignedRadio();

		pathSummary.filter("Radio Bandwidth", "NOT READY");
		pathSummary.showAllPathsWithNoAssignedRadio();

	}
	// COM 102
	// Project Filter - The Filter box gives the User the ability to limit the
	// project via 1 filter parameters. Filter Box input defaults to Band - User
	// types in desired characters and clicks search button to limit displayed
	// Paths.
	// COM 125

	@Test
	public void valBlankFilterResultSet() {
		createPath.createBrandNewProjectPath("Project B" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.filter("Band", "");
		pathSummary.validateBlankFilteredResult("Test Path 1");
		pathSummary.filter("Path Name", "");
		pathSummary.validateBlankFilteredResult("Test Path 1");
		pathSummary.filter("Site Name", "");
		pathSummary.validateBlankFilteredResult("Test Path 1");
		pathSummary.filter("Antenna Code", "");
		pathSummary.validateBlankFilteredResult("Test Path 1");
		pathSummary.filter("Antenna Model", "");
		pathSummary.validateBlankFilteredResult("Test Path 1");
		pathSummary.filter("Radio Code", "");
		pathSummary.validateBlankFilteredResult("Test Path 1");
		pathSummary.filter("Radio Bandwidth", "");
		pathSummary.validateBlankFilteredResult("Test Path 1");
		pathSummary.filter("Max Power", "");
		pathSummary.validateBlankFilteredResult("Test Path 1");
	}

	// COM 108
	/**
	 * LEGO-7777 : QA AUTO UI: move select all on project summary next to checkbox
	 * next to Hamburger menu LEGO-5384
	 */
	@Test
	public void valSelectAllPaths() {
		createPath.createBrandNewProjectPath("Project C" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 2", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 3", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 4", BAND_DESCRIPTION_4, "KGO-TV", LATITUDE2, LONGITUDE2, ELEVATION2,
				STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, ASR1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 5", BAND_DESCRIPTION_4, "KGO-TV", LATITUDE2, LONGITUDE2, ELEVATION2,
				STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, ASR1);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.checkThatSelectButtonIsAvailable();

	}

	@Test
	public void valDeletePaths() {
		createPath.createBrandNewProjectPath("Project D" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 2", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 3", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 4", BAND_DESCRIPTION_4, "KGO-TV", LATITUDE2, LONGITUDE2, ELEVATION2,
				STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, ASR1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 5", BAND_DESCRIPTION_4, "KGO-TV", LATITUDE2, LONGITUDE2, ELEVATION2,
				STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, ASR1);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.checkThatSelectButtonIsAvailable();
		pathSummary.checkForDeleteCandidates("Test Path 1", "Test Path 2", "Test Path 3");
		pathSummary.deleteSinglePath();
		pathSummary.checkForDeletedPath("First Path adding extra to test name length");
	}

	// COM 103
	@Test
	public void valSortingNumPathBand() {
		createPath.createBrandNewProjectPath("Project E" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 2", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 3", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 4", BAND_DESCRIPTION_4, "KGO-TV", LATITUDE2, LONGITUDE2, ELEVATION2,
				STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, ASR1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 5", BAND_DESCRIPTION_4, "KGO-TV", LATITUDE2, LONGITUDE2, ELEVATION2,
				STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, ASR1);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.checkPathNumForAscend();
		pathSummary.checkPathNumForDescend();
		pathSummary.checkBandForAcend();
		pathSummary.checkBandForDescend();
		pathSummary.checkPathNameForAcend();
		pathSummary.checkPathNameForDescend();
	}

	/*
	 * COM 105
	 */
	@Test
	public void deletePathFromHamburgerMenu() {
		createPath.createBrandNewProjectPath("Project F" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 2", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 3", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 4", BAND_DESCRIPTION_4, "KGO-TV", LATITUDE2, LONGITUDE2, ELEVATION2,
				STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, ASR1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 5", BAND_DESCRIPTION_4, "KGO-TV", LATITUDE2, LONGITUDE2, ELEVATION2,
				STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, ASR1);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.highlightPathAndSelectDeleteFromHamburger();
	}

	/*
	 * COM 102,COM 106
	 */
	@Test
	public void viewSettingsFromHamburgerMenu() {
		createPath.createBrandNewProjectPath("Project G" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.selectAndViewSettingsFromHamburgerMenu();
	}

	/*
	 * COM 107,COM-169,COM-169,COM-169,COM-169,COM-323
	 */
	@Test
	public void changeUnitsSettingsAndVal() {
		createPath.createBrandNewProjectPath("Project H" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		pathSummary.changeUnitsFromSiToUs("02", "6.56");
		pathSummary.changeUnitsFromSiToUs("03", "9.84");
		pathSummary.changeUnitsFromSiToUs("55", "180.45");
		pathSummary.changeUnitsFromSiToUs("90", "295.28");
		pathSummary.changeUnitsFromSiToUs("120", "393.7");
		pathSummary.changeUnitsFromSiToUs("1000", "3280.84");
		pathSummary.changeUnitsFromSiToUs("-02", "-6.56");
		pathSummary.changeUnitsFromSiToUs("-03", "-9.84");
		pathSummary.changeUnitsFromSiToUs("-55", "-180.45");
		pathSummary.changeUnitsFromSiToUs("-90", "-295.28");
		pathSummary.changeUnitsFromSiToUs("-120", "-393.7");
		pathSummary.changeUnitsFromSiToUs("-1000", "-3280.84");
		pathSummary.changeUnitsFromUsToSi("6.56", "1.999");
		pathSummary.changeUnitsFromUsToSi("9.84", "2.999");
		pathSummary.changeUnitsFromUsToSi("180.45", "55.001");
		pathSummary.changeUnitsFromUsToSi("295.28", "90.001");
		pathSummary.changeUnitsFromUsToSi("393.7", "120");
		pathSummary.changeUnitsFromUsToSi("3280.84", "1000");
		pathSummary.changeUnitsFromUsToSi("-6.56", "-1.999");
		pathSummary.changeUnitsFromUsToSi("-9.84", "-2.999");
		pathSummary.changeUnitsFromUsToSi("-180.45", "-55.001");
		pathSummary.changeUnitsFromUsToSi("-295.28", "-90.001");
		pathSummary.changeUnitsFromUsToSi("-393.7", "-120");
		pathSummary.changeUnitsFromUsToSi("-3280.84", "-1000");
	}

	/**
	 * COM-324 Quick Add Form COM-321
	 * 
	 */

	@Test
	public void quickAdd_shouldGiveWarning_whenElevationIsOutSideOfNeg304dot495And30479dot695Si() {
		createPath.createBrandNewProjectPath("QuickAddElevationBoundary" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		pathSummary.changeToSi();
		quickAdd.quickAddPathGeneral2("ElevLOWBoundarySuccess1", BAND_DESCRIPTION_23, EXISTINGSITE_PARTIAL, LATITUDE2,
				LONGITUDE2, ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("ElevHIGHBoundarySuccess2", BAND_DESCRIPTION_23, EXISTINGSITE_PARTIAL, LATITUDE2,
				LONGITUDE2, ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneralNoSave2("ElevLOWBoundaryWarn1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL,
				LATITUDE2, LONGITUDE2, "-305.495", CALLSIGN1);
		String elevationWarning2 = quickAdd.projectFieldError(0);
		assertEquals("Elevation warning not found or not correct", elevationWarning2,
				"Must be between -304.495 and 30,479.695 meters.");
		quickAdd.cancelPathCreation();
		quickAdd.quickAddPathGeneralNoSave2("ElevHIGHBoundaryWarn2", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL,
				LATITUDE2, LONGITUDE2, "-304.496", CALLSIGN1);
		String elevationWarning = quickAdd.projectFieldError(0);
		assertEquals("Elevation warning not found or not correct", elevationWarning,
				"Must be between -304.495 and 30,479.695 meters.");
	}

	/**
	 * COM-324 Quick Add Form
	 *
	 */
	@Test
	public void quickAdd_shouldGiveWarning_whenElevationIsOutSideOfNeg999And99999US() {
		createPath.createBrandNewProjectPath("QuickAddElevationBoundary" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("ElevLOWBoundarySuccess1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2,
				LONGITUDE2, ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("ElevHIGHBoundarySuccess2", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2,
				LONGITUDE2, ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneralNoSave2("ElevHIGHBoundaryWarn1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL,
				LATITUDE2, LONGITUDE2, "100000", CALLSIGN1);
		String elevationWarning2 = quickAdd.projectFieldError(0);
		assertEquals("Elevation warning not found or not correct", elevationWarning2,
				"Must be between -999 and 99,999 feet.");
		quickAdd.cancelPathCreation();
		quickAdd.quickAddPathGeneralNoSave2("ElevLOWBoundaryWarn2", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL,
				LATITUDE2, LONGITUDE2, "-1000", CALLSIGN1);
		String elevationWarning = quickAdd.projectFieldError(0);
		assertEquals("Elevation warning not found or not correct", elevationWarning,
				"Must be between -999 and 99,999 feet.");
	}

	/**
	 * COM-324 Quick Add Form
	 */
	@Test
	public void quickAdd_GEshouldPersistAndNotRecalculate_whenGEUsIsSetStored() {
		createPath.createBrandNewProjectPath("GEshouldPersistAndNotRecalculate" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		pathSummary.changeToSi();
		quickAdd.quickAddPathExistingSetup("SMETLER", BAND_DESCRIPTION_23, EXISTINGSITE_PARTIAL, "", "", "", "site2",
				"37 15 45 N", "107 53 31 W", "7611");
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.changeToUs();
		quickAdd.quickAddPathExistingSetup("SMETLER", BAND_DESCRIPTION_23, EXISTINGSITE_PARTIAL, "", "", "", "site2",
				"37 15 45 N", "107 53 31 W", "7611");
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "SMETLER", "37 15 45.6 N", "107 53 31.4 W", "7611.55");
	}

	/**
	 * COM 107 & 116
	 *
	 */

	@Test
	public void viewDefaultSettingsFromProjectSetting() {
		createPath.enterProjectForCompany("Project A" + randomNumber + "f", "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
	}

	/*
	 * COM 109 COM-100
	 */
	@Test
	public void viewPathBlueSection() {
		createPath.createBrandNewProjectPath("viewPathBlueSection" + randomNumber, "This is the Default");
		createPath.contactLookup(STR_CO_CODE, "", "", 0);
		quickAdd.quickAddPathGeneral2("Test Path 1", BAND_DESCRIPTION_23, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN1);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 2", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneral2("Test Path 3", BAND_DESCRIPTION_4, STR_SITENAME_PARTIAL, LATITUDE2, LONGITUDE2,
				ELEVATION2, STR_SITENAME_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1, CALLSIGN3);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.viewPathBlueSection(0, "Test Path 1", "1", "23");
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, STR_SITENAME_1, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.viewSiteCallSignLatLongGeColumns2(0, STR_SITENAME_1, LATITUDE1, LONGITUDE1, ELEVATION1);
	}

	/*
	 * COM-146 Site auto suggest
	 *
	 */

	@Test
	public void valQuickAddSuggestedText() {
		createPath.createBrandNewProjectPath("Project J" + randomNumber, "This is the Default");
		createPath.contactLookup("LOUCOU", "", "", 0);
		quickAdd.quickAddPathExistingSetup(EXISTINGSITE_PARTIAL, BAND_DESCRIPTION_23, "Path 1", "", "",
				EXISTINGSITE_ELEV, "site2", LATITUDE3, LONGITUDE3, ELEVATION3);
		quickAdd.closeWarning();
		quickAdd.quickAddPathExistingSetup(EXISTINGSITE_PARTIAL, BAND_DESCRIPTION_23, "Path 2", "", "",
				EXISTINGSITE_ELEV, "site2", LATITUDE3, LONGITUDE3, ELEVATION3);
		quickAdd.closeWarning();
	}

	/**
	 * COM-455 and COM 500
	 *
	 */
	/**
	 * LEGO-6278: QA AUTO UI: Updates for Validations Drawer + ID tags LEGO-6009
	 */
	// COM-545 (UI Tests) Sprint 13 Bugs
	@Test // COM-500
	public void quickAdd_shouldGiveWarning_whenLatAndLongAreTheSame() {
		createPath.createBrandNewProjectPath("QuickAddElevationBoundary" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		quickAdd.quickAddPathSameLatLon("SameLatLong", BAND_DESCRIPTION_23, "BLUE", LATITUDE1, LONGITUDE1, ELEVATION1,
				CALLSIGN3);
		quickAdd.validationdrawerMessage("Coordinates are the same on both sites.");
	}

	/**
	 * LEGO-3219 - AUTO UI: LEGO-3040 Project Path Import form and results LEGO-8028
	 * : QA AUTO UI - add clear button to Project Path Import LEGO-7894
	 */

	@Test
	public void pathImport_fromProject_verifyImport() {
		String rcn = "15112428";
		createPath.createBrandNewProjectPath("pathImport" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.clickHamburgerPathSummary();
		pathSummary.clickImportPathHamburgerPathSummary();
		String pathName = pathSummary.clickImportToPathPathSummary(rcn);
		pathSummary.verifyImportedPath(pathName);
	}

	/**
	 * LEGO-5906: QA Auto UI - ASR Check: refresh structure height and tower owner
	 * values after submitting an ASR: LEGO-5792
	 * 
	 * LEGO-5398: QA AUTO Task LEGO-4797: ASR Check: “Centerline / Tower Height”
	 * Clarification
	 */
	@Test
	public void asrCheck_submitAsr_VerifyAsrCheck() {
		createPath.createBrandNewProjectPath("pathImport asr" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.clickHamburgerPathSummary();
		pathSummary.clickImportPathHamburgerPathSummary();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathSummary.clickASRBox();
		pathSummary.verifyElementsAsrCheck();
		pathSummary.verifySubmitAsrCheck();
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}