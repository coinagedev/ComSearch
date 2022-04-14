package CommTests;

import CommPageObjects.RunAnalysisPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.ProjectManagementPage;
import CommPageObjects.BasePage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.ESAnalysisResultsPage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathDataBasePage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.TerrAnalysisResultsAFSPage;
import CommPageObjects.InterferenceCaseSummaryPage;
import CommPageObjects.BasePage.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

/**
 * @author nshaji
 *
 */
public class TerrAnalysisResultsAFSTest extends BaseTest {
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private PathDetailPage pathDetail;
	private LoginPage loginPage;
	private TerrAnalysisResultsAFSPage analysis;
	private PathDataBasePage pathDatabase;
	private RunAnalysisPage analysisRun;
	private InterferenceCaseSummaryPage interferenceCaseSummary;
	private ProjectManagementPage projectManagement;
	private ESAnalysisResultsPage esResults;

	private static final String BAND_DESCRIPTION_DOT_NINETHREE = "0.93 GHz (932.5-944 MHz) US";

	private static final String COMPANYCODE = "VERONA";
	private static final String MANUFACTURERNAME = "VERONA CABLEVISION";
	private static final String ASR1 = "1241006";
	private static final String ASR2 = "1208837";
	private static final String LATITUDE1 = "40 44 54.0 N";
	private static final String LONGITUDE1 = "73 59 09.0 W";
	private static final String LATITUDE2 = "40 42 46.8 N";
	private static final String LONGITUDE2 = "74 00 47.3 W";
	private static final String ELEVATION1 = "14";
	private static final String ELEVATION2 = "6.62";
	// RCN="19102904" for "Path-20026842
	private static final String RCN = "19102904";
	private static final String FREQUENCY1 = "17740";
	private static final String FREQUENCY2 = "19300";
	private static final String POLARIZATION1 = "Both V/H";
	private static final String RCN1 = "19110466";
	private static final String RCN2 = "20072426";

	@Before
	public void Setup() {
		createPath = new CreateNewPathPage(driver);
		pathSummary = new PathSummaryPage(driver);
		pathDatabase = new PathDataBasePage(driver);
		analysisRun = new RunAnalysisPage(driver);
		interferenceCaseSummary = new InterferenceCaseSummaryPage(driver);
		projectManagement = new ProjectManagementPage(driver);
		pathDetail = new PathDetailPage(driver);
		loginPage = new LoginPage(driver);
		analysis = new TerrAnalysisResultsAFSPage(driver);
		esResults = new ESAnalysisResultsPage(driver);
		loginPage.selectUserAndLogin("admin");

		if (host != "localhost") {}

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * LEGO-4421 : QA AUTO UI: Create Grid View (pre-analysis) LEGO-4289
	 */
	/**
	 * LEGO-8012 : QA AUTO UI Validation: Project Name LEGO-7855
	 */

	@Test
	public void pathAnalysis_Analysis_VerifyAnalysisButtons() {
		String projectName = "Project Analysis NS" + randomNumber;
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
		pathDetail.enterFrequencyPlanInPathDetailsPage("H}", "L}");
		pathDetail.clickSaveButtonOnPathDetails();
		pathDetail.closeWarning();
		pathDetail.clickFlipButtonOnPathDetails();
		pathDetail.verifySite2Values("CAMSLANT STATION", "", LATITUDE1, LONGITUDE1, ELEVATION1);
		pathDetail.verifySite1Values("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, ELEVATION2, "");
		pathDetail.veryfyFrequencyPlanSite1("L}");
		pathDetail.veryfyFrequencyPlanSite2("H}");
		pathDetail.selectFrequencyChannels();
		pathDetail.clickSaveButtonOnPathDetails();
		pathDetail.closeWarning();
		pathDetail.clickReturnButtonInPathDetailsPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.clickTerResultLinkOnAnalysisPageToGoToAFSGrid();
		analysis.verifyElementsOnAnalysisPage();
		analysis.verifyPreAnalysisGrid();

	}

	/**
	 * LEGO-4800 - AUTO UI 4492: Save channel/polarization selections:
	 * 
	 * LEGO-4750 - QA AUTO UI LEGO-4490: Render colors in AFS Grid
	 */
	@Test
	public void pathAnalysis_SavePolarization_VerifyPolarizationSelection() {
		String projectName = "Project Polarization NS" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDatabase.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDatabase.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
		analysisRun.clickSaveButtonOnRunAnalysisPage();
		analysis.clickTerrResultsLinkOnAFSPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.clickTerResultLinkOnAnalysisPageToGoToAFSGrid();
		analysis.verifyColorsAFSGrid();
		analysis.savePolarizationSelections();
		analysis.clickSummaryButtonOnAnalyisPage();
		pathDetail.openPathDetailViaDetails();
		pathDetail.verifyFrequencyAndPolarization(FREQUENCY1, FREQUENCY2, POLARIZATION1, POLARIZATION1);
	}

	/**
	 * LEGO-5294 - QA AUTO UI LEGO-5036: Permission for AFS grid
	 */
	@Test
	public void pathAnalysis_editPermissions_VerifyUserPermissions() {
		String projectName = "Unique" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDatabase.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDatabase.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.runAnalysisDisplayedOnAFSPage();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
		analysisRun.clickSaveButtonOnRunAnalysisPage();
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		createPath.accessProjectManagement();
		projectManagement.searchProjectWithUsername(projectName, "default_admin");
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.verifyElementsUsersWithoutPermission();
		analysisRun.verifyElementsUsersWithoutPermission();
		analysis.clickTerrResultsLinkOnAFSPage();
		analysis.clickFilterButton();
		interferenceCaseSummary.verifyElementsUsersWithoutPermission();
	}

	/**
	 * LEGO-4748 - QA AUTO API LEGO-4653: API - Throw errors when user requests
	 * simplex paths to flip
	 */
	@Test
	public void pathDetails_SimplexPath_validateNoFlipOnPathsaveAndAnalysis() {
		createPath.createProjectPath("SimplexProject" + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDatabase.searchPathDatabaseBasedOnImportFromDatabase(RCN1);
		pathDatabase.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathDetail.openPathDetailViaDetails();
		pathDetail.makePathSimplexAndSave();
		pathDetail.verifyMessageOnHoverOverFlipSitesSimplexPath("Cannot flip simplex paths.");
		pathDetail.closeWarning();
		pathDetail.clickReturnButtonInPathDetailsPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.clickTerResultLinkOnAnalysisPageToGoToAFSGrid();
		analysis.clickHiLoFlipAnalysisGridPage("- Cannot flip frequencies when path is a simplex path");
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
