package CommTests;

import CommPageObjects.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import java.util.Random;

/**
 * Created by nshaji on 7/3/2018
 */
public class PathDatabaseTest extends BaseTest {

	private LoginPage loginPage;
	private PathDataBasePage pdatabase;
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private PathDetailPage pathDetail;
	private PathDetailsRadioPage pathDetailRadio;
	private PathDetailAntennaPage pathDetailAnt;
	private static final String COMPANYCODE = "VERONA";
	private static final String MANUFACTURERNAME = "VERONA CABLEVISION";
	private static final String BAND_DESCRIPTION_ELEVEN = "11 GHz (10700-11700 MHz) US";
	private static final String BAND_DESCRIPTION_SIX_DOT_SEVEN = "6.7 GHz (6525-6875 MHz) US";
	private static final String ASR1 = "1241006";
	private static final String LATITUDE1 = "35 12 26.7 N";
	private static final String LATITUDE2 = "47 24 23.3 N";
	private static final String LONGITUDE1 = "78 3 21.3 W";
	private static final String LONGITUDE2 = "111 17 21.8 W";
	private static final String ELEVATION1 = "159.78";
	private static final String ELEVATION2 = "3593.01";
	private static final String RCN1 = "20052815";
	private static final String JOB_CODE1 = "200528COMSCT01";
	private static final String RCN2 = "21010755";
	private static final String ANALOG_RADIOCODE = "TEMP20";
	private static final String RCN3 = "20093061";
	private static final String RCN4 = "19091210";
	private static final String COORDINATE_SITE2_LONGITUDE = "81 47 53.1 E";

	@Before
	public void Setup() {
		createPath = new CreateNewPathPage(driver);
		pathSummary = new PathSummaryPage(driver);
		pathDetail = new PathDetailPage(driver);
		pathDetailRadio = new PathDetailsRadioPage(driver);
		pathDetailAnt = new PathDetailAntennaPage(driver);
		pdatabase = new PathDataBasePage(driver);
		loginPage = new LoginPage(driver);
		loginPage.selectUserAndLogin("admin");
	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);
	int randomNumber1 = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	@Test
	public void pathDataBase_thepathDatabasePageShouldOpen_whenNavigatingToPathDataBase() {
		pdatabase.accessPathDataBase();
	}

	/**
	 * LEGO-2562:AUTO UI: Path Database Search Form LEGO-2312
	 */
	@Test
	public void pathDataBase_AllPathFromThatBandAreDisplayed_whenInputValidStateAndSearch() {
		pdatabase.accessPathDataBase();
		pdatabase.verifyElementsInPathDatabasePage();
		pdatabase.searchPathDatabaseBasedOnSiteNameAndMultiBand("Site 1", "site 2", BAND_DESCRIPTION_SIX_DOT_SEVEN,
				BAND_DESCRIPTION_ELEVEN);

	}

	/**
	 * LEGO-2704 : AUTO UI: Path DB search by radio favorite LEGO-2513 Radio Lookup
	 * LEGO-8025 - add clear button to Radio Lookup LEGO-7891
	 */
	@Test
	public void pathDetail_createRadioFavorite_SearchRadioFavoriteInPathDatabaseSearch() {
		String projectName1 = "Best Project" + randomNumber1;
		createPath.createBrandNewProjectPath(projectName1, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetailRadio.setupLeftRadio("M11988");
		pathDetailAnt.clickBlurAntennaCode();
		for (int i = 0; i < 4; i++) {
			pathDetailRadio.deactivateModulationNew(2);
		}
		pathDetailRadio.saveFavRadioCodeEnterSameFavCode();
		String radioFavorite = pathDetailRadio.getRadioFavorite();
		pathDetailRadio.setupRightRadio(radioFavorite);
		pathDetailRadio.clickRightRadioLookup();
		pathDetailRadio.performRadioLookupSearch(radioFavorite, "40");

	}

	/**
	 * LEGO-3055 : AUTO UI: LEGO-2939: Prevent path creation through database
	 */
	@Test
	public void pathDetail_preventPathCreationviaPathDB_VerifyPathDB() {
		pdatabase.accessPathDataBase();
		pdatabase.verifyCreateButtonNotPresent();
	}

	/**
	 * LEGO-3157 - QA UI Auto: Import paths from Path Database into new Project
	 * LEGO-3106
	 */

	@Test
	public void pathDatabase_newProject_VerifyImportPath() {
		String newProject = "New Project" + randomNumber1;
		String pathCount = "2";
		pdatabase.accessPathDataBase();
		pdatabase.searchPathDatabaseBasedOnSiteNameAndMultiBand("Site 1", "site 2", BAND_DESCRIPTION_SIX_DOT_SEVEN,
				BAND_DESCRIPTION_ELEVEN);
		pdatabase.selectTwoFromResults();
		pdatabase.clickHamburgerPathDatabase();
		pdatabase.clickCreateNewProjectButtonFromHamburgerMenu();
		pdatabase.createNewProject(newProject);
		pdatabase.verifyProjectAndPath(newProject, pathCount);

	}

	/**
	 * LEGO-6826 : QA AUTO UI LEGO-6610 : Add COPY button to Path Details - database
	 * mode
	 */
	/**
	 * LEGO-7856 : QA AUTO UI - Add a reason for deletion of a path LEGO-7442
	 * LEGO-8014
	 *
	 */
	@Test
	public void pathDatabase_CopyPath_VerifyCopiedPath() {
		pdatabase.accessPathDataBase();
		pdatabase.searchPathDatabaseBasedOnSiteNameAndMultiBand("Site 1", "Site 2", BAND_DESCRIPTION_SIX_DOT_SEVEN,
				BAND_DESCRIPTION_ELEVEN);
		pdatabase.copyPathViaPathDetails();
		pathDetail.clickDeleteButtonOnPathDetails();
	}

	/**
	 * LEGO-6353: QA AUTO UI- Latitude & Longitude Search with blank radius is not
	 * producing correct results LEGO-6186
	 */
	/**
	 * LEGO-3757 : Minor fixes for Path Details View Only LEGO-3522
	 */
	@Test
	public void pathDataBase_latitudeLongitudeSearchWithBlankRadius_VerifyResults() {
		loginPage.logout();
		loginPage.selectUserAndLogin("engineer");
		pdatabase.accessPathDataBase();
		pdatabase.searchPathDatabaseBasedOnSiteNameAndMultiBand("site 1", "site 2", BAND_DESCRIPTION_SIX_DOT_SEVEN,
				BAND_DESCRIPTION_ELEVEN);
		pdatabase.openSearchResult();
		String latitude = pdatabase.getLatitudeFromPathDetails();
		String longitude = pdatabase.getLongitudeFromPathDetails();
		pdatabase.verifyAzimuthDegree();
		pdatabase.verifyBandwidthUnit();
		pdatabase.navigateToPathDatabaseSearchPageFromHeader();
		pdatabase.searchPathDatabaseBasedOnLatLongEmptyRadius(latitude, longitude);
	}

	/**
	 * LEGO-8250 : QA AUTO UI: Refine verbiage of job code and rcn number errors to
	 * match UI LEGO-7888
	 */

	@Test
	public void pathDataBase_jobCodeRCN_VerifyError() {
		String error = "Job Number cannot exists without an RCN Number";
		String jobcodeError = "Job Number 'null' is not associated with RCN Number '" + RCN1 + "'";
		pdatabase.accessPathDataBase();
		pdatabase.searchPathDatabaseBasedOnRCN(RCN1);
		pdatabase.removeRCNSavePathVerifyError(error, jobcodeError);
	}

	/**
	 * LEGO-7015 : QA AUTO UI: Modify Min Throughput warnings module to bypass
	 * analog radios LEGO-6879
	 */
	@Test
	public void pathDataBase_pathWarning_VerifyNoMiniumumTroughPutError() {
		boolean warningFlag = false;
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		pdatabase.accessPathDataBase();
		pdatabase.searchPathDatabaseBasedOnRCN(RCN2);
		pdatabase.removeAndApplyRadio(ANALOG_RADIOCODE);
		pdatabase.savePathDetailsForm();
		pdatabase.verifyMinTroughputErrorNotDisplayedInWarnings(warningFlag);
	}

	/**
	 * LEGO-5913 : QA Auto UI: Refactor Path Validation: include Finalization
	 * validation LEGO-5783
	 */
	@Test
	public void pathDataBase_pathValidation_VerifyPathLengthViolation() {
		boolean errorPathLength = true;
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		pdatabase.accessPathDataBase();
		pdatabase.searchPathDatabaseBasedOnRCN(RCN3);
		pdatabase.changeSite2ToEasternHemisphere(COORDINATE_SITE2_LONGITUDE);
		pdatabase.savePathDetailsForm();
		pdatabase.verifyPathLengthViolationError(errorPathLength);
	}

	/**
	 * LEGO-5913 : QA Auto UI: Refactor Path Validation: include Finalization
	 * validation LEGO-5783
	 */
	@Test
	public void pathDataBase_pathValidation_VerifyErrorMessageASRGEDoNotShowForDBUser() {
		String ge_site1 = "434.77";
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		pdatabase.accessPathDataBase();
		pdatabase.searchPathDatabaseBasedOnRCN(RCN3);
		String existing_ge = pdatabase.clearGEandTypein(ge_site1);
		pdatabase.savePathDetailsForm();
		pdatabase.clickCancelIfCallsignCascadeWindowAppears();
		pdatabase.updateWithOriginalGEValue(existing_ge);
		pdatabase.savePathDetailsForm();
		pdatabase.clickCancelIfCallsignCascadeWindowAppears();
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
