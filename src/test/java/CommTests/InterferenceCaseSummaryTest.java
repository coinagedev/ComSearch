package CommTests;

import CommPageObjects.RunAnalysisPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.BasePage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathDataBasePage;
import CommPageObjects.TerrAnalysisResultsAFSPage;
import CommPageObjects.InterferenceCaseSummaryPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import java.util.Random;

public class InterferenceCaseSummaryTest extends BaseTest {
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private InterferenceCaseSummaryPage AfsPathSummary;
	private LoginPage loginPage;
	private TerrAnalysisResultsAFSPage analysis;
	private RunAnalysisPage analysisRun;
	private PathDataBasePage pathDBpage;

	private static final String COMPANYCODE = "VERONA";
	private static final String MANUFACTURERNAME = "VERONA CABLEVISION";
	private static final String RCN = "19102904";
	private static final String RCN2 = "20020530";
	private static final String RCN3 = "20070819";
	private static final String CONTACT_CODE = "WLTJFM";
	private static final String BUCK_DISTANCE = "0.76";
	private static final String BUCK_DISTANCE_DEFAULT_NINE_FOUR = "0.75";
	private static final String ANTENNA_CODE = "SB1000";
	private static final String ANTENNA_MODEL = "ASK-24/1";

	@Before
	public void Setup() {
		createPath = new CreateNewPathPage(driver);
		pathSummary = new PathSummaryPage(driver);
		AfsPathSummary = new InterferenceCaseSummaryPage(driver);
		loginPage = new LoginPage(driver);
		analysis = new TerrAnalysisResultsAFSPage(driver);
		analysisRun = new RunAnalysisPage(driver);
		pathDBpage = new PathDataBasePage(driver);
		loginPage.selectUserAndLogin("admin");

		if (host != "localhost") {
		}
	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * LEGO:6129 - QA AUTO UI: Add check box for selecting cases to Channel Case
	 * List on Path Case Summary LEGO-5981 LEGO-8247 : QA AUTO UI: Add "show all
	 * cases" as an option for interference case csv output LEGO-7460
	 */
	@Test
	public void pathCaseSummary_selectCheckBox_VerifyCheckBox() {
		String projectName = "Project PathCase Summary NS" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.runAnalysisDisplayedOnAFSPage();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
		analysisRun.clickSaveButtonOnRunAnalysisPage();
		analysis.clickTerrResultsLinkOnAFSPage();
		analysis.selectPathAFSGrid();
		analysis.clickHamburgerOnAFSGridScreen();
		analysis.verfyInterferenceCaseReportGenerationUI();
		analysis.clickPathResult();
		AfsPathSummary.verifyPathCaseSummaryPageElements();
		AfsPathSummary.clickChevronResult();
		AfsPathSummary.verifyCheckbox();
	}

	/**
	 * LEGO:6130 - QA AUTO UI: Add Reports button to Path Case Summary LEGO-5935
	 * 
	 * LEGO:6053 - UI: Add Reports button to Case Details Drawer
	 */
	@Test
	public void pathCaseSummary_reportButton_VerifyReportButton() {
		String projectName = "Project report NS" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.runAnalysisDisplayedOnAFSPage();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
		analysisRun.clickSaveButtonOnRunAnalysisPage();
		analysis.clickTerrResultsLinkOnAFSPage();
		analysis.clickPathResult();
		AfsPathSummary.clickChevronResult();
		AfsPathSummary.clickSelectAllCheckbox();
		AfsPathSummary.clickReportsButton();
		AfsPathSummary.verifyReportsWindowElements();
		AfsPathSummary.verifyReportsGenerateReport();
		AfsPathSummary.updateAntennaCaseDetailsDrawer(ANTENNA_CODE, ANTENNA_MODEL);
		AfsPathSummary.clickReportsButton();
		AfsPathSummary.verifyReportsGenerateReport();
	}

	/**
	 * LEGO-5907 - QA Auto- UI: Channel Case List support for AFS Results Filter
	 * toggle LEGO-5630
	 * 
	 * LEGO-6041 - QA Auto UI: Limit AFS Filter buck radius to be <= default
	 * LEGO-5899 LEGO-8843 : QA AUTO UI: AFS filter toggle test LEGO-8781 LEGO-8607
	 * : QA AUTO UI: OH Loss - add row LEGO-8300
	 */
	@Test
	public void pathCaseSummary_filterToggle_VerifyFilterToggle() {
		String projectName = "Project FilterToggle NS" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN2);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.runAnalysisDisplayedOnAFSPage();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
		analysisRun.clickSaveButtonOnRunAnalysisPage();
		analysis.clickTerrResultsLinkOnAFSPage();
		analysis.clickPathResult();
		AfsPathSummary.clickFilterButton();
		AfsPathSummary.verifyFilterPageElements();
		AfsPathSummary.verifyFilterBuckRadiusLessThanEqualDefault(BUCK_DISTANCE, BUCK_DISTANCE_DEFAULT_NINE_FOUR);
		AfsPathSummary.verifyFilterBuckRadiusLessThanEqualDefault(BUCK_DISTANCE_DEFAULT_NINE_FOUR,
				BUCK_DISTANCE_DEFAULT_NINE_FOUR);
		AfsPathSummary.filterByContactCode(CONTACT_CODE);
		AfsPathSummary.clickChevronResult();
		AfsPathSummary.verifyResultsFilterToggle(CONTACT_CODE);
		AfsPathSummary.clickMWOHDrawer();
		AfsPathSummary.verifyElementsInMWOHDrawer();
		AfsPathSummary.addRowMWOHDrawer("1", "1", "1");
	}

	/**
	 * LEGO-5908 - QA Auto UI: Channel Case List table LEGO-5629 LEGO-4742 - QA AUTO
	 * UI LEGO-4292 Analysis Grid Hi/Lo Flip LEGO-9234 - QA AUTO UI: Worst Cases
	 * Report LEGO-9085
	 */
	@Test
	public void pathCaseSummary_channelCaseTable_VerifyChannelCaseTable() {
		String projectName = "Project channelcase NS" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.clickTerrResultsLinkOnAFSPage();
		analysis.verifyHiLoButton();
		analysis.clickAnalysisLinkWithoutConfirmChanges();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
		analysisRun.clickSaveButtonOnRunAnalysisPage();
		analysis.clickTerrResultsLinkOnAFSPage();
		analysis.clickPathResult();
		AfsPathSummary.clickChevronResult();
		AfsPathSummary.verifyChannelCaseListElements();
		AfsPathSummary.verifyShowAllCasesToggle();
		AfsPathSummary.verifyWorstCaseReportOption();

	}

	/**
	 * LEGO-8607 : QA AUTO UI: OH Loss Drawer - add row LEGO-8300 LEGO-8608 : QA
	 * AUTO UI: OH Loss - edit row LEGO-8301 LEGO-8673 : QA AUTO UI: OH Loss -
	 * delete row LEGO-8299 LEGO-8672 : QA AUTO UI: Create OH Loss drawer contents
	 * LEGO-8298
	 */
	@Test
	public void pathCaseSummary_ohDrawer_VerifyOHDrawer() {
		String projectName = "Project mw ohdrawer NS" + randomNumber;
		String distance = "1";
		String elevation = "1";
		String clutter = "1";
		String elevation2 = "2";
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN2);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.runAnalysisDisplayedOnAFSPage();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
		analysisRun.clickSaveButtonOnRunAnalysisPage();
		analysis.clickTerrResultsLinkOnAFSPage();
		analysis.clickPathResult();
		AfsPathSummary.clickChevronResult();
		AfsPathSummary.clickMWOHDrawer();
		AfsPathSummary.verifyElementsInMWOHDrawer();
		AfsPathSummary.addRowMWOHDrawer(distance, elevation, clutter);
		AfsPathSummary.updateRowMWOHDrawer(elevation2);
		AfsPathSummary.deleteDataPointOHDrawer();
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
