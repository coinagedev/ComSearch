package CommTests;

import CommPageObjects.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import java.util.Random;

/**
 * Created by ehend on 2/25/2017.
 */
public class PathDetailAntennaTest extends BaseTest {
	private PathDetailAntennaPage pathDetailAnt;
	private QuickAddPage quickAdd;
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private PathDetailPage pathDetail;
	private LoginPage loginPage;
	private static final String CALLSIGN1 = "KA20003";
	private static final String CALLSIGN2 = "KBY45";
	private static final String COMPANYCODE = "VERONA";
	private static final String MANUFACTURERNAME = "VERONA CABLEVISION";
	private static final String ANTENNACODE1 = "S16601";
	private static final String ASR1 = "1300000";
	private static final String ASR2 = "1200000";
	private static final String LATITUDE1 = "40 44 54 N";
	private static final String LONGITUDE1 = "73 59 9 W";
	private static final String LATITUDE2 = "40 42 46.8 N";
	private static final String LONGITUDE2 = "74 0 47.3 W";
	private static final String ELEVATION1 = "14";
	private static final String ELEVATION2 = "6.62";
	private static final String BAND_DESCRIPTION_ELEVEN = "11 GHz (10700-11700 MHz) US";

	@Before
	public void Setup() {
		pathDetailAnt = new PathDetailAntennaPage(driver);
		quickAdd = new QuickAddPage(driver);
		pathSummary = new PathSummaryPage(driver);
		createPath = new CreateNewPathPage(driver);
		pathDetail = new PathDetailPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.selectUserAndLogin("admin");
	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * COM-340 UX/UI: Antenna Section of Path Details
	 */

	@Test
	public void pathDetailAntenna_willAutoFill_whenThereIsAMatchOnAntennaCode() {
		createPath.createBrandNewProjectPath("Antenna Code onBlur" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Antenna", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Antenna1", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaDataAndonBlurRelatedFieldsPopulate("AM-8-11-R", "Tx/Rx", ANTENNACODE1, "0.8°", "46.2",
				"AM-8-11-R", "Tx/Rx", ANTENNACODE1, "0.8°", "46.2");
		pathDetailAnt.clickSaveDetails();
	}

	@Test
	public void pathDetailAntenna_willError_whenThereIsNotAMatchOnASR() {
		createPath.createBrandNewProjectPath("ASR onBlur" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailASR1Error("6fg6hg64");
	}

	/**
	 * COM-341 UI/UX: Antenna Lookup
	 *
	 */
	/**
	 * LEGO-8024
	 */
	@Test
	public void pathDetailAntModal_allRevisionsShouldAppear_pathSave() {
		createPath.createBrandNewProjectPath("Revision results" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Antenna", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Antenna1", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.clickAntennaLookup();
		pathDetail.verifyAntennaLookupAndSearch("R%", "All Manu%", "%");
		pathDetailAnt.clickSaveDetails();
	}

	/**
	 * COM-340 UX/UI: Antenna Section of Path Details
	 *
	 */
	@Test
	public void pathDetailAntenna_willError_whenThereIsNoAMatchOnAntennaCode() {
		createPath.createBrandNewProjectPath("ErrorNoAnt Match" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Antenna", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Antenna1", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterBadAntennaDataAndonBlurError("2145", "No match found for Antenna Code.", "5854",
				"No match found for Antenna Code.");
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}

}
