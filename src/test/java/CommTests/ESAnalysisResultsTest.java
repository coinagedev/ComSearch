package CommTests;

import CommPageObjects.RunAnalysisPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.BasePage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.ESAnalysisResultsPage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathDataBasePage;
import CommPageObjects.TerrAnalysisResultsAFSPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

/**
 * @author nshaji
 *
 */
public class ESAnalysisResultsTest extends BaseTest {
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private LoginPage loginPage;
	private TerrAnalysisResultsAFSPage analysis;
	private PathDataBasePage pathDatabase;
	private RunAnalysisPage analysisRun;
	private ESAnalysisResultsPage esResults;

	private static final String COMPANYCODE = "VERONA";
	private static final String MANUFACTURERNAME = "VERONA CABLEVISION";
	private static final String RCN2 = "20072426";

	@Before
	public void Setup() {
		createPath = new CreateNewPathPage(driver);
		pathSummary = new PathSummaryPage(driver);
		pathDatabase = new PathDataBasePage(driver);
		analysisRun = new RunAnalysisPage(driver);
		loginPage = new LoginPage(driver);
		analysis = new TerrAnalysisResultsAFSPage(driver);
		esResults = new ESAnalysisResultsPage(driver);
		loginPage.selectUserAndLogin("admin");
		if (host != "localhost") {
			// driver.manage().window().maximize();
		}

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * LEGO-7776 : QA AUTO UI Create Earth Station Page LEGO-7466 LEGO-9304 : QA
	 * AUTO UI : ES Analysis status completion LEGO-9328 : QA AUTO UI: ES Check
	 * document generation wiring LEGO-9209 LEGO-9534 : QA AUTO UI ES Case Report
	 * document generation LEGO-9451 LEGO-9326 : QA AUTO UI: Copy P2P OH Loss drawer
	 * over to ES Check LEGO-9208
	 */
	@Test
	public void pathAnalysis_RunESAnalysis_VerifyESResultsPageAndESOHDrawer() {
		String projectName = "Project ES NS" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDatabase.searchPathDatabaseBasedOnImportFromDatabase(RCN2);
		pathDatabase.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
		analysisRun.verifyESAnalysisCompletion();
		analysisRun.clickSaveButtonOnRunAnalysisPage();
		esResults.clickESResults();
		esResults.verifyESCasesNotNull();
		esResults.verifyReportsButtonPresent();
		esResults.clickESCaseDropdownAndSelectCase1();
		esResults.verifyESOHLossDrawerReportsButtons();
		esResults.verifyESOHLossDrawerElements();
		esResults.addRowESOHDrawer("1", "1", "1");
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
