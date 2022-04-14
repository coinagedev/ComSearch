package CommTests;

import CommPageObjects.BasePage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.QuickAddPage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.PathDetailAntennaPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by ehend on 2/25/2017.
 */
public class QuickAddTest extends BaseTest {
	private QuickAddPage quickAdd;
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private PathDetailPage pathDetail;
	private PathDetailAntennaPage pathDetailAnt;
	private LoginPage login;
	private static final String BAND_DESCRIPTION_DOT_NINEFOUR = "0.94 GHz (944-952 MHz) US";
	private static final String BAND_DESCRIPTION_ELEVEN = "11 GHz (10700-11700 MHz) US";
	private static final String BAND_DESCRIPTION_FOUR = "4 GHz (3700-4200 MHz) US";
	private static final String ANTENNACODEBACKTOBACK = "A08200";
	private static final String ANTENNACODE1 = "02306A";
	private static final String COMPANYCODE = "LOUCOU";
	private static final String MANUFACTURERNAME = "Loudoun, County of";
	private static final String EXISTINGSITE = "Bluemont";
	private static final String EXISTINGSITE_PARTIAL = "Blue";
	private static final String EXISTINGSITE_LAT = "39 08 16.4 N";
	private static final String EXISTINGSITE_LONG = "77 49 57.6 W";
	private static final String EXISTINGSITE_ELEV = "1348.5";
	private static final String LATITUDE1 = "39 08 17.0 N";
	private static final String LONGITUDE1 = "77 49 56.6 W";
	private static final String LATITUDE2 = "39 00 31.4 N";
	private static final String LONGITUDE2 = "77 31 58.5 W";
	private static final String LATITUDE3 = "40 44 54.0 N";
	private static final String LONGITUDE3 = "73 59 09.0 W";
	private static final String LATITUDE4 = "40 44 53 N";
	private static final String LONGITUDE4 = "73 59 10 W";
	private static final String ELEVATION1 = "1349.08";
	private static final String ELEVATION2 = "312.01";
	private static final String ELEVATION3 = "47.67";
	private static final String ELEVATION4 = "46.88";
	private static final String ELEVATION5 = "1347.74";
	private static final String ELEVATION6 = "2663.02";
	private static final String ASR1 = "1234555";

	@Before
	public void Setup() {

		if (host != "localhost") {}

		quickAdd = new QuickAddPage(driver);
		pathSummary = new PathSummaryPage(driver);
		createPath = new CreateNewPathPage(driver);
		pathDetail = new PathDetailPage(driver);
		pathDetailAnt = new PathDetailAntennaPage(driver);
		login = new LoginPage(driver);
		login.selectUserAndLogin("admin");

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);
	int randomNumber1 = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/*
	 * COM-100, COM-148, COM-148, COM-148, COM-100, COM-100, COM-146, COM-146,
	 * COM-146
	 */
	@Test
	public void quickAddSiteNameSuggest() {
		boolean siteExist;
		createPath.createBrandNewProjectPath("SiteNameSuggest" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);

		siteExist = quickAdd.checkForExistingSite(EXISTINGSITE);
		if (siteExist == true) {
			quickAdd.cancelPathCreation();
		} else {
			quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", BAND_DESCRIPTION_DOT_NINEFOUR, EXISTINGSITE_PARTIAL, "",
					"", "", "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
			pathSummary.sceenNotInactiveWhileSaving();
			quickAdd.closeWarning();
		}
		quickAdd.quickAddPathExistingSetup(EXISTINGSITE_PARTIAL, BAND_DESCRIPTION_DOT_NINEFOUR, "Path", "", "",
				ELEVATION3, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, EXISTINGSITE, EXISTINGSITE_LAT, EXISTINGSITE_LONG, "1349.08");
	}

	/**
	 * COM-255 Split Project handling in UI
	 */
	@Test
	public void splitProjectGoToNewProject() {
		boolean siteExist;
		createPath.createBrandNewProjectPath("splitProjectNEW" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		siteExist = quickAdd.checkForExistingSite(EXISTINGSITE);
		if (siteExist == true) {
			quickAdd.cancelPathCreation();
		} else {
			quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", BAND_DESCRIPTION_DOT_NINEFOUR, EXISTINGSITE, "", "", "",
					"Tonto Mtn2", "40 44 54 N", "73 59 9 W", "1530");
			quickAdd.closeWarning();
		}
		quickAdd.quickAddPath("Tonto Mtn", BAND_DESCRIPTION_DOT_NINEFOUR, "Stay 1", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		quickAdd.quickAddPath("STAY2", BAND_DESCRIPTION_DOT_NINEFOUR, "Stay 2", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "Tonto Mtn2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		quickAdd.quickAddPath("STAY3", BAND_DESCRIPTION_DOT_NINEFOUR, "Stay 3", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "Site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		quickAdd.quickAddPath("Tonto Mtn", BAND_DESCRIPTION_DOT_NINEFOUR, "Go To New 1", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		quickAdd.quickAddPath("NEW2", BAND_DESCRIPTION_DOT_NINEFOUR, "Go To New 2", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		quickAdd.quickAddPath("NEW3", BAND_DESCRIPTION_DOT_NINEFOUR, "Go To New 3", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "Site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.splitProject("Splitting Half of Project " + randomNumber);
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(0, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.viewSiteCallSignLatLongGeColumns1(1, "NEW2", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.viewSiteCallSignLatLongGeColumns1(2, "NEW3", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(2, "Site2", LATITUDE2, LONGITUDE2, ELEVATION2);
	}

	/**
	 * COM-255 Split Project handling in UI
	 */
	/**
	 * LEGO-6278: QA AUTO UI: Updates for Validations Drawer + ID tags LEGO-6009
	 */
	@Test
	public void splitProjectStayInCurrentProject() {
		createPath.createBrandNewProjectPath("splitProjectStay" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("Ton", BAND_DESCRIPTION_DOT_NINEFOUR, "Path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Blue2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.quickAddPath("SPLIT-C1", BAND_DESCRIPTION_DOT_NINEFOUR, "Path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(1, "SPLIT-C1", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(1, "Blue2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.quickAddPath("SPLIT-C2", BAND_DESCRIPTION_DOT_NINEFOUR, "Path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "Site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(2, "SPLIT-C2", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(2, "Blue2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.quickAddPath("Ton", BAND_DESCRIPTION_DOT_NINEFOUR, "Path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(3, "Tonto Mtn", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(3, "Blue2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.quickAddPath("SPLIT-C3", BAND_DESCRIPTION_DOT_NINEFOUR, "Path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(4, "SPLIT-C3", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(4, "Blue2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.quickAddPath("SPLIT-C4", BAND_DESCRIPTION_DOT_NINEFOUR, "Path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "Site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(5, "SPLIT-C4", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(5, "Blue2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.splitProjectStay("Splitting Half of Project " + randomNumber);
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Blue2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.viewSiteCallSignLatLongGeColumns1(1, "SPLIT-C1", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(1, "Blue2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.viewSiteCallSignLatLongGeColumns1(2, "SPLIT-C2", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(2, "Blue2", LATITUDE2, LONGITUDE2, ELEVATION2);
	}

	/**
	 * COM-255 Split Project handling in UI
	 */

	@Test
	public void splitProjectAlt() {
		boolean siteExist;
		createPath.createBrandNewProjectPath("splitProject" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		siteExist = quickAdd.checkForExistingSite("Tonto Mtn");
		if (siteExist == true) {
			quickAdd.cancelPathCreation();
		} else {
			quickAdd.quickAddPathDataSetup("TM SUPPORT DATA", BAND_DESCRIPTION_DOT_NINEFOUR, "Tonto Mtn",
					EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
			quickAdd.closeWarning();
		}
		quickAdd.quickAddPath("Ton", BAND_DESCRIPTION_DOT_NINEFOUR, "Path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Tonto Mtn", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		quickAdd.quickAddPath("SPLIT-ALT", BAND_DESCRIPTION_DOT_NINEFOUR, "Path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(1, "SPLIT-ALT", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.openSettingMenuValDisabledSplitOption();
		pathSummary.splitProjectStayAlt("Splitting Half of Project " + randomNumber);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "SPLIT-ALT", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(0, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
	}

	/*
	 * COM-97
	 */
	@Test
	public void createNewProjectWithCompanyByCode_shouldPass_whenDefaultCompanyCodeIsUsedtoFillOutCompanyField() {
		createPath.enterProjectForCompany("withCompanyByCode" + randomNumber + "f", "This is the Default");
		createPath.contactLookup(COMPANYCODE, "", "", 0);
		quickAdd.quickAddPath("ByCode1", BAND_DESCRIPTION_DOT_NINEFOUR, "", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV, "site2", LATITUDE1, LONGITUDE1, ELEVATION1);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "ByCode1", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV);
		pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Blue2", LATITUDE1, LONGITUDE1, ELEVATION1);
	}

	@Test
	public void createNewProjectWithCompanyByName_shouldSave_whenDefaultCompanyNameIsUsedtoFillOutCompanyField() {
		createPath.enterProjectForCompany("withCompanyByName" + randomNumber + "f", "This is the Default");
		createPath.contactLookup("", MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("NY SUPPORT DATA", BAND_DESCRIPTION_DOT_NINEFOUR, "site", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		quickAdd.quickAddPath("New", BAND_DESCRIPTION_DOT_NINEFOUR, "path", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Blue", EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1);
		pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Blue", LATITUDE2, LONGITUDE2, ELEVATION2);
	}

	@Test
	public void createNewProjectNameDoesNoteExist() {
		createPath.enterProjectForCompany("ProjectNameDoesNoteExist" + randomNumber + "f", "This is the Default");
		createPath.contactLookupOnlySearch("", "WWEEERWWER", "", 0);
		createPath.verifyContactLookupSearchWhenWrongConatct();
	}

	/*
	 * COM-100
	 */
	@Test
	public void quickAddProjectNoName() {
		createPath.createBrandNewProjectPath("ProjectNoName" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("NY SUPPORT DATA", BAND_DESCRIPTION_DOT_NINEFOUR, "site", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		quickAdd.quickAddPath("NoName", BAND_DESCRIPTION_DOT_NINEFOUR, "", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		quickAdd.quickAddPath("CAM SUPPORT DATA", BAND_DESCRIPTION_DOT_NINEFOUR, "CAMSLANT STATION", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "Site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		quickAdd.quickAddPath("NoName2", BAND_DESCRIPTION_DOT_NINEFOUR, "", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "Site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
	}

	/*
	 * COM-100, COM-148, COM-148
	 */
	@Test
	public void quickAddProjectName43Char() {
		String pathError;
		createPath.createBrandNewProjectPath("ProjectName43Char" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("Name43", BAND_DESCRIPTION_DOT_NINEFOUR, "12345678912345678912345678912345678912345678",
				EXISTINGSITE_LAT, EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathError = quickAdd.projectFieldError(0);
		assertEquals(pathError, "Path Name cannot be longer than 43 characters.");
	}

	/*
	 * COM-100
	 */
	@Test
	public void quickAddNoBand() {
		createPath.createBrandNewProjectPath("NoBand" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPathNoBand(EXISTINGSITE_PARTIAL, "", EXISTINGSITE_PARTIAL, LATITUDE1, LONGITUDE1, ELEVATION1);
	}

	/*
	 * COM-100
	 */
	@Test
	public void quickAddInvalidChars() {
		createPath.createBrandNewProjectPath("quickAddInvalidChars" + randomNumber + randomNumber1,
				"This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPathInvalidChar();
	}

	@Test
	public void quickAddInvalidCharsCallSign() {
		createPath.createBrandNewProjectPath("InvalidCharsCallSign" + randomNumber + randomNumber1,
				"This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPathasrSite1InvalidChar();
		quickAdd.quickAddPathasrSite1InvalidChar2();
	}

	/*
	 * COM-100
	 */
	@Test
	public void quickAddCreatePath_shouldFailwithErrorMessage_whenSiteNameExeeds21charachters() {
		createPath.createBrandNewProjectPath("Site21PlusChars" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPathSiteName21Plus("VEUBDEKSKHIHSKHKSKHOOIJD");
	}

	/*
	 * COM-100
	 */
	@Test
	public void quickAddWithLatOrLong() {
		String pathError;
		String pathError2;
		createPath.createBrandNewProjectPath("WithLatOrLong" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPathGeneral1("Path name without Lat and longitude", BAND_DESCRIPTION_FOUR,
				EXISTINGSITE_PARTIAL, "", "", "98");
		pathError = quickAdd.projectFieldError(0);
		pathError2 = quickAdd.projectFieldError(1);
		assertEquals(pathError, "Required.");
		assertEquals(pathError2, "Required.");
	}

	/*
	 * COM-100 "35-30-4.683 N", "110-9-35.684 W" "35 30 4.683", "-110 9 35.684"
	 * "35.5013009N", "110.1599121W" "35.5013009", "-110.1599121"
	 * 
	 * COM-129 DD MM SS.SS N/S or DDD MM SS.SS E/W DD MM SS.SSN/S or DDD MM SS.SSE/W
	 * DD MM SS.SS or DDD MM SS.SS DD°MM'SS.SS" N/S or DDD°MM'SS.SS" E/W DD° MM'
	 * SS.SS" N/S or DDD° MM' SS.SS" E/W N/S DD MM SS.SS or E/W DDD MM SS.SS
	 * DD-­MM-­SS.SS N/S or DDD-­MM-­SS.SS E/W DD-­MM-SS and DDD-­MM­-SS.SS N/S
	 * DD-MM-SS.SS or E/W DDD-­MM-­SS.SS DD-­MM-­SS.SSN/S or DDD-­MM-­SS.SSE/W
	 * DD.DDDDDD or DDD.DDDDDD DD.DDDDDD N/S or DDD.DDDDDD E/W N/S DD.DDDDDD or E/W
	 * DDD.DDDDDD
	 * 
	 * Given that a user wants to enter lat/long values, When they are entered in
	 * the following formats, Then they are accepted AND they are understood as
	 * intended: • DD-MM-SS.SS N/S, DDD-MM-SS.SS E/W -No negative sign allowed • DD
	 * MM SS.SS N/S, DDD MM SS.SS E/W DD-MM-SS.SS, DDD-MM-SS.SS -A negative sign in
	 * front of lat value implies S, otherwise N -A negative sign in front of long
	 * value implies W, otherwise E • DD.DDDDDD N/S, DDD.DDDDDD E/W -No negative
	 * sign allowed • DD.DDDDDD, DDD.DDDDDD -A negative sign in front of lat value
	 * implies S, otherwise N -A negative sign in front of long value implies W,
	 * otherwise E
	 */
	@Test
	public void quickAddLatOrLongFormat0() {
		createPath.createBrandNewProjectPath("quickAddLatOrLongFormat" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("NS DD MM SSdotSS", BAND_DESCRIPTION_FOUR, "First", "N 43°38 19.39", "W 116° 14 28.86",
				ELEVATION6, "site1", "43°38 19.00", "116° 14 28.76W", ELEVATION6);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "NS DD MM SSdotSS", "43 38 19.39 N", "116 14 28.86 W",
				ELEVATION6);
		quickAdd.quickAddPath("DD-MM-SSdotSS NS", BAND_DESCRIPTION_FOUR, "Second", "43-38-19.39 N", "116-14-28 W",
				ELEVATION6, "site2", "43 38 18", "116 14 54 W", ELEVATION6);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(1, "DD-MM-SSdotSS NS", "43 38 19.39 N", "116 14 28.0 W",
				ELEVATION6);
		quickAdd.quickAddPath("DD-MM-SS", BAND_DESCRIPTION_FOUR, "third", "43-38-19.39", "-116-14-27", ELEVATION6,
				"site3", "43 38 19.5 N", "116 14 53.7 W", ELEVATION6);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(2, "DD-MM-SS", "43 38 19.39 N", "116 14 27.0 W", ELEVATION6);
		quickAdd.quickAddPath("NS DD-MM-SSdotSS", BAND_DESCRIPTION_FOUR, "forth", "N 43-38-19.39", "W 116-14-26",
				"2468.75", "site4", "43 38 19.6 N", "116 44 54.7 W", "2468.75");
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(3, "NS DD-MM-SSdotSS", "43 38 19.39 N", "116 14 26.0 W",
				"2468.75");
	}

	@Test
	public void quickAddLatOrLongFormat1() {
		createPath.createBrandNewProjectPath("quickAddLatOrLongFormat" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("DD-MM-SSdotSSNS", BAND_DESCRIPTION_FOUR, "fifth", "43-38-19.39 N", "116-14-28.86 W",
				ELEVATION6, "site2", "43 38 19.6 N", "116 14 55.8 W", ELEVATION6);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "DD-MM-SSdotSSNS", "43 38 19.39 N", "116 14 28.86 W",
				ELEVATION6);
		quickAdd.quickAddPath("DDdotDDDDDD", BAND_DESCRIPTION_FOUR, "sixth", "43.638611", "-116.241111", ELEVATION6,
				"site2", "43 38 19.6 N", "116 14 55.8 W", ELEVATION6);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(1, "DDdotDDDDDD", "43 38 19.0 N", "116 14 28.0 W", ELEVATION6);
		quickAdd.quickAddPath("DDdotDDDDDD NS", BAND_DESCRIPTION_FOUR, "seventh", "43.638611 N", "116.241111 W",
				ELEVATION6, "site2", "43 38 19.6 N", "116 14 55.8 W", ELEVATION6);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(2, "DDdotDDDDDD NS", "43 38 19.0 N", "116 14 28.0 W", ELEVATION6);
		quickAdd.quickAddPath("NS DDdotDDDDDD", BAND_DESCRIPTION_FOUR, "eighth", "N 43.638611", "W 116.241111",
				ELEVATION6, "site2", "43 38 19.6 N", "116 14 55.8 W", ELEVATION6);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(3, "NS DDdotDDDDDD", "43 38 19.0 N", "116 14 28.0 W", ELEVATION6);
	}

	@Test
	public void quickAddLatOrLongFormat2() {
		createPath.createBrandNewProjectPath("quickAddLatOrLongFormat" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPathGeneral1("Path name", BAND_DESCRIPTION_FOUR, "BLUE", "39-08-16 N", "77-49-57 W",
				ELEVATION5);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "BLUE", "39 08 16.0 N", "77 49 57.0 W", ELEVATION5);
		quickAdd.quickAddPathGeneral1("Path name A", BAND_DESCRIPTION_FOUR, "BLUE", "39.137778", "-77.832667",
				ELEVATION5);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(1, "BLUE", "39 08 16.0 N", "77 49 57.6 W", ELEVATION5);
		quickAdd.quickAddPathGeneral1("Path name B", BAND_DESCRIPTION_FOUR, "BLUE", "39.137778", "W 77 49 57",
				ELEVATION5);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(2, "BLUE", "39 08 16.0 N", "77 49 57.0 W", ELEVATION5);
	}

	@Test
	public void quickAddLatOrLongFormat3() {
		createPath.createBrandNewProjectPath("quickAddLatOrLongFormat" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPathGeneral1("Path name", BAND_DESCRIPTION_FOUR, "BLUE", "39.137878", "-77.836667", "1180.14");
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "BLUE", "39 08 16.36 N", "77 50 12.0 W", "1180.14");
		quickAdd.quickAddPathGeneral1("path 1", BAND_DESCRIPTION_FOUR, "BLUE", "39°8'16 N", "77°49'57 W", ELEVATION5);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(1, "BLUE", "39 08 16.0 N", "77 49 57.0 W", ELEVATION5);
		quickAdd.quickAddPathGeneral1("path 2", BAND_DESCRIPTION_FOUR, "BLUE", "39°8'16 N", "W 77°49'57", ELEVATION5);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(2, "BLUE", "39 08 16.0 N", "77 49 57.0 W", ELEVATION5);
		quickAdd.quickAddPathGeneral1("path 3", BAND_DESCRIPTION_FOUR, "BLUE", "39°8'33.80", "-77°49'57", ELEVATION5);
		pathSummary.viewSiteCallSignLatLongGeColumns1(3, "BLUE", "39 08 33.8 N", "77 49 57.0 W", ELEVATION5);
	}

	/*
	 * COM-100 GPS: dd:mm:ss.ss[N,S] dd:mm:ss.ss[W,E] 35:30:4.683N 110:9:35.684W
	 * Would like a list of non-preferred formats that will convert, also the rules
	 * as to which of the 3 accepted formats that the non-preferred will predictably
	 * convert
	 */
	@Test
	public void quickAddLatOrLongNotPerferredFormatConvertToPerferred() {
		createPath.createBrandNewProjectPath("AddLatOrLongNotPerferredFormat" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("NY SUPPORT DATA", BAND_DESCRIPTION_DOT_NINEFOUR, "site", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		quickAdd.quickAddPath("SITE1 SUPPORT DATA", BAND_DESCRIPTION_DOT_NINEFOUR, "SITE1", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		quickAdd.quickAddPath("Not Perferd to Perfd", BAND_DESCRIPTION_FOUR, "SITE1", "39.812", "-77.426584",
				ELEVATION3, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathSummary.sceenNotInactiveWhileSaving();
	}

	/*
	 * COM-100
	 */
	@Test
	public void quickAddLatOrLongNotPerferredWillNotConvert() {
		String invalidFormat1;
		String invalidFormat2;
		createPath.createBrandNewProjectPath("NotPerferredWillNotConvert" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPathGeneral1("Path name", BAND_DESCRIPTION_FOUR, "SITE1", "35:30:4.683N", "110:9:35.684W",
				ELEVATION3);
		invalidFormat1 = quickAdd.projectFieldError(0);
		invalidFormat2 = quickAdd.projectFieldError(1);
		assertEquals(invalidFormat1, "Invalid latitude format");
		assertEquals(invalidFormat2, "Invalid longitude format");
	}

	/*
	 * COM-100 Auto-suggest now works for only finalized sites/paths
	 */
	@Test
	public void quickAddElevationAutofillUserCanOverwrite() {
		createPath.createBrandNewProjectPath("ElevationCanOverwrite" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("BTM SUPPORT DATA", BAND_DESCRIPTION_DOT_NINEFOUR, "BLACKTAIL MTN", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		quickAdd.quickAddPathGeneralNoSave("Elevation Autofill User Can Overwrite", BAND_DESCRIPTION_FOUR, EXISTINGSITE,
				LATITUDE1, LONGITUDE1, ELEVATION1, "Td5G43s");
		quickAdd.closeWarning();
		quickAdd.changeLatLong("39 8 16.3 N", "77 49 57.4 W");
		quickAdd.savePath();
	}

	/**
	 * COM-148,COM-148,COM-148,COM-148,COM-148,COM-148,COM-147,147
	 */
	@Test
	public void quickAddASRSuggest() {
		String FCCError1;
		createPath.createBrandNewProjectPath("Project" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("ASR field Autofill", "6.4 GHz (6425-6525 MHz) US", "KSTU Transmitter", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "KSTU Transmitter1", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1);
		quickAdd.quickAddPathGeneralError2("ASR field Autofill", BAND_DESCRIPTION_FOUR, "ASR-Call", "", "", "4",
				"NoFound");
		FCCError1 = quickAdd.projectFieldError(1);
		assertEquals(FCCError1, "Required.");
	}

	/**
	 * COM-452 Given a path is created in Path Details or Quick Add, When space " "
	 * character(s) are used before or after a path or site name, Then they will be
	 * trimmed off of the Path and Site names in the both the Path Summary list AND
	 * the Path Detail screen.
	 */
	@Test
	public void creatingQuickAddPath_WhenThereIsSpace_TrimSpaceOnBlur() {
		createPath.createBrandNewProjectPath("TrimSpaceOnBlur" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("TrailingSpace ", BAND_DESCRIPTION_DOT_NINEFOUR, "TrailingSpace ", EXISTINGSITE_LAT,
				"77 49 57" + ".01W", ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		quickAdd.compareText("TrailingSpace ", "TrailingSpace", 0);
		quickAdd.quickAddPath(" PreSpace", BAND_DESCRIPTION_DOT_NINEFOUR, "PreSpace", EXISTINGSITE_LAT,
				"77 49 57" + ".01W", ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		quickAdd.compareText(" PreSpace", "PreSpace", 1);
	}

	/**
	 * COM-454
	 */
	@Test
	public void passiveRepeater_OpenPassiveRepeaterForm_ValidateAllFieldsAndButtons() {
		createPath.createBrandNewProjectPath("OPEN Passive Repeater" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("Passive Repeater", BAND_DESCRIPTION_DOT_NINEFOUR, "Passive Repeater", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathDetail.openPathDetailViaDetails();
		pathDetail.openPassiveRepeaterAndValidateFieldsAndButtons();
	}

	/**
	 * COM-454
	 */
	@Test
	public void passiveRepeater_NoFrequencyBAND_DESCRIPTION_PassiveRepeaterTriggerInactive() {
		createPath.createBrandNewProjectPath("Inactive Passive Repeater" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("Passive Repeater", "Band", "Passive Repeater", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathDetail.openPathDetailViaDetails();
		pathDetail.clickInactivePassiveRepeaterTrigger();
	}

	/**
	 * COM-454
	 * 
	 */
	@Test
	public void passiveRepeater_AllValidData_PassiveRepeaterRecordIsCreated() {
		createPath.createBrandNewProjectPath("Inactive Passive Repeater" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("Passive Repeater", BAND_DESCRIPTION_DOT_NINEFOUR, "Passive Repeater", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathDetail.openPathDetailViaDetails();
		pathDetail.addBackToBackPassiveRepeater();
		pathDetailAnt.antennaLookUpFromPassiveRepeater(ANTENNACODE1);
		pathDetail.returnFromAntennaLookUp("P8F-9", ANTENNACODE1);
		pathDetail.setAntennaOnPassiveRepeater(1, ANTENNACODE1);
		pathDetail.savePassiveRepeater();
	}

	/**
	 * COM-454
	 */
	@Test
	public void passiveRepeaterBackToBack_SelectRemoveButton_PassiveRepeaterRecordWillBeRemoved() {
		createPath.createBrandNewProjectPath("Inactive Passive Repeater" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("Passive Repeater", BAND_DESCRIPTION_DOT_NINEFOUR, "Passive Repeater", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathDetail.openPathDetailViaDetails();
		pathDetail.addBackToBackPassiveRepeater();
		pathDetailAnt.antennaLookUpFromPassiveRepeater(ANTENNACODE1);
		pathDetail.returnFromAntennaLookUp("P8F-9", ANTENNACODE1);
		pathDetail.setAntennaOnPassiveRepeater(1, ANTENNACODE1);
		pathDetail.savePassiveRepeater();
		pathDetail.removePassiveRepeater();
	}

	/**
	 * COM-454
	 */
	@Test
	public void passiveRepeater_AddBillboardPassiveRepeater_RecordWillBeAdded() {
		createPath.createBrandNewProjectPath("Inactive Passive Repeater" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("Passive Repeater", BAND_DESCRIPTION_DOT_NINEFOUR, "Passive Repeater", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, EXISTINGSITE_ELEV, "site2", LATITUDE1, LONGITUDE1, ELEVATION1);
		quickAdd.closeWarning();
		pathDetail.openPathDetailViaDetails();
		pathDetail.addBillboardPassiveRepeater();
		pathDetailAnt.antennaLookUpFromPassiveRepeater("020%");
		pathDetail.returnFromAntennaLookUp("2.4X3.7 FT PASSIVE", "0203RF");
		pathDetail.savePassiveRepeater();
	}

	/**
	 * COM-487
	 *
	 */
	/**
	 * LEGO-10223 : QA AUTO UI Allow underscore in Path Name LEGO-10051
	 */
	@Test
	public void passiveRepeaterQuickAdd_SelectNextButton_WillDisplayCorrectRepeaterInformation() {
		createPath.createBrandNewProjectPath("Next and Previous Passive Repeater" + randomNumber,
				"This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("Passive Repeater", BAND_DESCRIPTION_DOT_NINEFOUR, "path_1", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		quickAdd.quickAddPath("No Passive Repeater", BAND_DESCRIPTION_DOT_NINEFOUR, "path_2", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathDetail.openPathDetailViaDetails();
		pathDetail.addBackToBackPassiveRepeater();
		pathDetailAnt.antennaLookUpFromPassiveRepeater(ANTENNACODE1);
		pathDetail.returnFromAntennaLookUp("P8F-9", ANTENNACODE1);
		pathDetail.setAntennaOnPassiveRepeater(1, ANTENNACODE1);
		pathDetail.savePassiveRepeater();
		pathDetail.nextArrow();
		pathDetail.previousArrow();
	}

	// COM-493
	@Test
	public void passiveRepeaterantennacode_Willautofillblocks_WhenSavingnewpath() {
		createPath.createBrandNewProjectPath("Inactive Passive Repeater" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("Passive Repeater", BAND_DESCRIPTION_ELEVEN, "Passive Repeater", LATITUDE1, LONGITUDE1,
				ELEVATION1, "site2", LATITUDE2, LONGITUDE2, ELEVATION2);
		quickAdd.closeWarning();
		pathDetail.openPathDetailViaDetails();
		pathDetail.addBackToBackPassiveRepeater("Back to Back", "Bluemont");
		pathDetailAnt.antennaLookUpFromPassiveRepeater(ANTENNACODEBACKTOBACK);
		pathDetail.returnFromAntennaLookUp("HPX10-107C", ANTENNACODEBACKTOBACK);
		pathDetail.setAntennaOnPassiveRepeater(1, "73222M");
		pathDetail.savePassiveRepeater();
		pathDetailAnt.enterAntennaDataAndonBlurRelatedFieldsPopulate("VHLPX2-11", "Tx/Rx", "77100A", "3.4°", "34.4",
				"VHLPX2-11", "Tx/Rx", "77100A", "3.4°", "34.4");
		pathDetailAnt.clickSaveDetails();
	}

	/**
	 * COM-654
	 */
	@Test
	public void defectVal_searchCThenSearchAntCode_WhenAntShouldAppearInSearch() {
		createPath.createBrandNewProjectPath("Quick add" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPath("Quick add", BAND_DESCRIPTION_ELEVEN, "quick add 1", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV, "site2", LATITUDE1, LONGITUDE1, ELEVATION1);
		quickAdd.closeWarning();
		pathDetail.openPathDetailViaDetails();
		pathDetailAnt.companySelect("Comm");
		pathDetailAnt.addAntennaToPath("77100A", "Tx/Rx", "VHLPX2-11", "3.4°", "34.4", "VHLPX2-11", "Tx/Rx", "77100A",
				"3.4°", "34.4");
	}

	// COM-708 OR COM-463
	/*
	 * Quick Add: Long1===Long2 causes unexpected error
	 * 
	 */
	@Test
	public void addPath_ShouldSucceed_withSameLongitudeButDiffrentLatitude() {
		String randomProjectName;
		randomProjectName = "project" + randomNumber + "";
		createPath.createBrandNewProjectPath(randomProjectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		quickAdd.quickAddPathSite1Site2Save("TestPath", BAND_DESCRIPTION_DOT_NINEFOUR, "Site1Name", EXISTINGSITE_LAT,
				EXISTINGSITE_LONG, EXISTINGSITE_ELEV, "Site2Name", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "Site1Name", EXISTINGSITE_LAT, EXISTINGSITE_LONG,
				EXISTINGSITE_ELEV);
		pathSummary.viewSiteCallSignLatLongGeColumns2(0, "Site2Name", LATITUDE2, LONGITUDE2, ELEVATION2);
	}

	/*
	 * LEGO-3377: AUTO UI: Call Sign Check form selection and submission LEGO-3165
	 */
	@Test
	public void quickAddCallSignCheck() {
		createPath.createBrandNewProjectPath("Project" + randomNumber, "This is the Default");
		createPath.contactLookup("LOUCOU", "", "", 0);
		quickAdd.quickAddSite1Setup("callcheck", BAND_DESCRIPTION_DOT_NINEFOUR, "KDFW Studio", LATITUDE3, LONGITUDE3,
				ELEVATION3);
		quickAdd.quickSite2Setup("callsignCheck", LATITUDE4, LONGITUDE4, ELEVATION4);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "asrcheck", LATITUDE3, LONGITUDE3, ELEVATION3);
		quickAdd.quickAddSite1Setup("callcheck1", BAND_DESCRIPTION_DOT_NINEFOUR, "KDFW Studio", LATITUDE3, LONGITUDE3,
				ELEVATION3);
		quickAdd.quickSite2Setup("callsignCheck1", LATITUDE4, LONGITUDE4, ELEVATION4);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		quickAdd.quickAddSite1Setup("Ashburn", "6.1 GHz (5925-6425 MHz) US", "PathName", LATITUDE3, LONGITUDE3,
				ELEVATION3);
		quickAdd.quickSite2Setup("DULLES EXIT7", LATITUDE4, LONGITUDE4, ELEVATION4);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.clickCallSignCheckBox();
		pathSummary.verifyCallSignResults();
	}

	/*
	 * LEGO-3375: AUTO UI: AUTO UI: ASR Check Form search and search results
	 * LEGO-3108
	 */
	@Test
	public void quickAddASRCheck() {
		createPath.createBrandNewProjectPath("Project" + randomNumber1, "This is the Default");
		createPath.contactLookup("LOUCOU", "", "", 0);
		quickAdd.quickAddSite1Setup("asrcheck", BAND_DESCRIPTION_DOT_NINEFOUR, "Studio", LATITUDE3, LONGITUDE3,
				ELEVATION3);
		quickAdd.quickSite2Setup("asrCheck2", LATITUDE4, LONGITUDE4, ELEVATION4);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.viewSiteCallSignLatLongGeColumns1(0, "asrcheck", LATITUDE3, LONGITUDE3, ELEVATION3);
		quickAdd.quickAddSite1Setup("asrcheck1", BAND_DESCRIPTION_DOT_NINEFOUR, "Studio", LATITUDE3, LONGITUDE3,
				ELEVATION3);
		quickAdd.quickSite2Setup("asrCheck11", LATITUDE4, LONGITUDE4, ELEVATION4);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		quickAdd.quickAddSite1Setup("asr", "6.1 GHz (5925-6425 MHz) US", "PathName", LATITUDE3, LONGITUDE3, ELEVATION3);
		quickAdd.quickSite2Setup("asr2", LATITUDE4, LONGITUDE4, ELEVATION4);
		pathSummary.sceenNotInactiveWhileSaving();
		quickAdd.closeWarning();
		pathSummary.clickASRBox();
		pathSummary.verifyASRResults();
	}

	/**
	 * LEGO-7157 : QA AUTO UI: Site Data Entry Bug in Quick Add LEGO-6674
	 */
	@Test
	public void quickAdd_enterSiteNAmeAndThenASR_VerifyAsrDoNotWipesOutSiteNamesEntered() {
		String siteName1 = "Site Test1";
		String siteName2 = "Site Test2";
		createPath.createBrandNewProjectPath("QuickAdd ASR" + randomNumber1, "This is the Default");
		createPath.contactLookup("LOUCOU", "", "", 0);
		quickAdd.quickAddSite1Site2Names(siteName1, siteName2, BAND_DESCRIPTION_DOT_NINEFOUR);
		quickAdd.quickAddASR1ASR2(ASR1, siteName1);
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}