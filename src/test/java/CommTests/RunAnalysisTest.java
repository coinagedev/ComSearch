package CommTests;

import CommPageObjects.RunAnalysisPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.BasePage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathDataBasePage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.TerrAnalysisResultsAFSPage;
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
public class RunAnalysisTest extends BaseTest {
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private PathDetailPage pathDetail;
	private LoginPage loginPage;
	private TerrAnalysisResultsAFSPage analysis;
	private RunAnalysisPage analysisRun;
	private PathDataBasePage pathDBpage;
	private PathSummaryPage pathSum;

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
	private static final String RCN = "19102904";

	@Before
	public void Setup() {
		createPath = new CreateNewPathPage(driver);
		pathSummary = new PathSummaryPage(driver);
		pathDetail = new PathDetailPage(driver);
		loginPage = new LoginPage(driver);
		analysis = new TerrAnalysisResultsAFSPage(driver);
		analysisRun = new RunAnalysisPage(driver);
		pathDBpage = new PathDataBasePage(driver);
		pathSum = new PathSummaryPage(driver);
		loginPage.selectUserAndLogin("admin");

		if (host != "localhost") {}

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * LEGO-4741 : QA AUTO UI LEGO-4491: Select/deselect polarizations, including
	 * "Deactivate" button
	 */
	@Test
	public void pathAnalysis_Analysis_VerifyAnalysisButtons() {
		String projectName = "Project SDA" + randomNumber;
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
		pathDetail.clickFlipButtonOnPathDetails();
		pathDetail.verifySite2Values("CAMSLANT STATION", "", LATITUDE1, LONGITUDE1, ELEVATION1);
		pathDetail.verifySite1Values("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, ELEVATION2, "");
		pathDetail.veryfyFrequencyPlanSite1("L}");
		pathDetail.veryfyFrequencyPlanSite2("H}");
		pathDetail.selectFrequencyChannels();
		pathDetail.clickSaveButtonOnPathDetails();
		pathDetail.copyPathViaPathDetails("PATH COPIED SUCCESSFULLY\n" + "You have successfully copied the path.");
		pathDetail.clickReturnButtonInPathDetailsPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.clickTerrResultsLinkOnAFSPage();
		analysis.selectDeactivate();

	}

	/**
	 * LEGO-6594 : QA AUTO Regression Test: Adding Analysis to UI Regression
	 */
	@Test
	public void pathAnalysis_Analysis_VerifyRunAnalysis() {
		String projectName = "Project regression NS" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSum.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.runAnalysisDisplayedOnAFSPage();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
	}

	/**
	 * LEGO-4676 : QA AUTO UI- handle reset of default band parameters LEGO-4476
	 */
	@Test
	public void pathAnalysis_defaultbandParameters_VerifyDefailuts() {
		String projectName = "Project Default band NS" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSum.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.runAnalysisDisplayedOnAFSPage();
		analysisRun.clickDefaultBandParametersIconAndValidates();
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
