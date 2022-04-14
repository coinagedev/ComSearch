package CommTests;

import CommPageObjects.RunAnalysisPage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.ProjectFinalizationPage;
import CommPageObjects.ProjectManagementPage;
import CommPageObjects.BasePage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.ESAnalysisResultsPage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathDataBasePage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.TerrAnalysisResultsAFSPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import java.util.Random;

public class ProjectFinalizationTest extends BaseTest {
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private LoginPage loginPage;
	private PathDataBasePage pdatabase;
	private TerrAnalysisResultsAFSPage analysis;
	private RunAnalysisPage analysisRun;
	private PathDetailPage pathDetail;
	private PathDataBasePage pathDBpage;
	private ProjectManagementPage projManagemnt;

	private ProjectFinalizationPage finalizationPage;
	private ESAnalysisResultsPage esResults;

	private static final String COMPANYCODE = "VERONA";
	private static final String MANUFACTURERNAME = "VERONA CABLEVISION";
	private static final String RCN = "21062354";
	private static final String RCN2 = "19103021";
	private static final String RCN3 = "21031911";
	private static final String RCN4 = "21012222";
	private static final String PCN_EMAIL = "temp@gmail.com";
	private static final String COORD_CODE = "03BLIM";
	private static final String JOB_CODE = "1234567";
	private static final String COMPANY_NAME = "sprint";
	private static final String RCN1 = "20060300";
	private static final String JOB_NUMBER = "M2013902";
	private static final String CONTACT_CODE = "DIGISL";
	private static final String JOB_CODE1 = "NS";
	private static final String PROCESSED_DATE = "2022/02/17";

	@Before
	public void Setup() {
		createPath = new CreateNewPathPage(driver);
		pathSummary = new PathSummaryPage(driver);
		loginPage = new LoginPage(driver);
		analysis = new TerrAnalysisResultsAFSPage(driver);
		analysisRun = new RunAnalysisPage(driver);
		pdatabase = new PathDataBasePage(driver);
		pathDBpage = new PathDataBasePage(driver);
		esResults = new ESAnalysisResultsPage(driver);
		pathDetail = new PathDetailPage(driver);
		finalizationPage = new ProjectFinalizationPage(driver);
		projManagemnt = new ProjectManagementPage(driver);
		loginPage.selectUserAndLogin("engineer");

		if (host != "localhost") {}

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);
	int randomNumber1 = rndNum.nextInt(100000);
	int randomNumber2 = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * LEGO-6973 - QA Auto UI: De-Duplicate RCN on Project Finalization Settings
	 * LEGO-6817 LEGO-6841 : QA AUTO UI:Save All associated PCN data values and
	 * return PCN and RcnNumberBandMapper LEGO-6688 LEGO-7152 - QA AUTO UI :
	 * Finalization Settings > Mail Options > Modify PCN Email LEGO-6557 LEGO-7490 :
	 * LEGO-6969 - QA AUTO UI: Finalization Settings > Mail Options > Modify Path
	 * Datasheet LEGO-6556 LEGO-7657 : QA AUTO UI: Modify project create modal to
	 * show UNITS LEGO-7457 LEGO-7153 : QA AUTO UI: Permissions for Finalization
	 * Settings page (as engineering/defalt_admin) LEGO-7151 : QA UI Auto : UI:
	 * Finalization Settings > Mail Options > Additional Licensees Lookup LEGO-6554
	 * LEGO-8011 : QA AUTO UI Need a confirm / cancel message for Send PCN button on
	 * Finalization page LEGO-7762 LEGO-7857 : QA AUTO UI UAT Finalization: The
	 * Response date field allows any date in the future LEGO-7404 LEGO-7158 : QA
	 * AUTO UI- Generate pdf version of PCN email and add to finalization documents
	 * LEGO-7040 LEGO-9304 : QA Auto UI : ES Analysis status completion LEGO-7778 :
	 * QA AUTO UI: Populate job number and RCN on Project Management Search page
	 * (finalized projects) LEGO-7412 LEGO-10734 : QA AUTO UI : Add logic to try it
	 * 3 more times to avoid cloud converter error in UI
	 */
	@Test
	public void projectFinalization_finalizationSettings_VerifyFinalizationSettings() {
		String error = "Cannot be more than 35 days in the future.";
		String projectName = "Eng-ProjFinalizationSetting";
		createPath.createBrandNewProjectPath(projectName + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN3);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN4);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathSummary.clickASRBox();
		pathSummary.clickSummaryLink();
		pathSummary.clickCallSignCheckBox();
		pathSummary.clickSummaryLink();
		pathSummary.clickWarningsCheckBox();
		pathSummary.clickSummaryLink();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysisRun.clickAnalysisRunButton();
		analysisRun.verifyAnaysisCompletion();
		analysisRun.verifyESAnalysisCompletion();
		analysisRun.clickSaveButtonOnRunAnalysisPage();
		esResults.clickESResults();
		finalizationPage.clickFinalizationBreadcrumb();
		finalizationPage.verifyResponseDueDateCantBeMoreThan35Days(error);
		finalizationPage.verifyElementsModifyPCNDatasheetsWindow();
		finalizationPage.verifyAdditionalLicenseeLookup(COMPANY_NAME);
		finalizationPage.verifyUploadFilePCNDatasheetsWindow("ProjectFinalizationSettings_DataSheetPreview.docx");
		finalizationPage.clickModifyPCNEmail();
		finalizationPage.verifyModifyPCNEmail();
		finalizationPage.finalizeAndSendPCN(PCN_EMAIL, COORD_CODE);
		finalizationPage.retryIfCloudConvertError();
		finalizationPage.verifyRCNValues();
		finalizationPage.verifyBandValueDisplayed();
		finalizationPage.verifyPCNDate();
		finalizationPage.verifySystemFiles();
		String generatedRcn = finalizationPage.getRCN();
		String generatedJobCode = finalizationPage.getJobCodeValue();
		finalizationPage.clickProjectsFromHeader();
		projManagemnt.clickFinalizedToggle();
		projManagemnt.searchProject(projectName + randomNumber);
		projManagemnt.verifyProjectManagementjobCodeandRCNvalues(generatedJobCode, generatedRcn);
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		pdatabase.accessPathDataBase();
		pdatabase.searchPathDatabaseBasedOnRCN(generatedRcn);
		pdatabase.deletePathFromPathDetailsFromDatabase();
	}

	/**
	 * LEGO-7153 : QA AUTO UI: Permissions for Finalization Settings page (as
	 * database user)) LEGO-8013 : QA AUTO UI Need a confirm / cancel message for
	 * Pending button on Finalization page (external pcn projects) LEGO-7764
	 * LEGO-8001 : QA AUTO UI : Need a confirm / cancel message for Finalize button
	 * on Finalization page (external pcn projects)LEGO-7763 LEGO-8122 : QA AUTO
	 * Validation (UI): Users should not be able to delete or edit Paths of
	 * Finalized Projects LEGO-7884 LEGO-10734 : QA AUTO UI : Add logic to try it 3
	 * more times to avoid cloud converter error in UI LEGO-10706 : QA AUTO UI :
	 * LEGO-10661 and LEGO-10660
	 */
	@Test
	public void projectFinalization_DatabaseuserPermission_VerifyFinalizationSettings() {
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		String projectName = "DB-ProjectFinalizationSettings NS";
		createPath.createBrandNewProjectPathAsDBUSer(projectName + randomNumber1, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN1);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathSummary.clickASRBox();
		pathSummary.clickSummaryLink();
		pathSummary.clickCallSignCheckBox();
		pathSummary.clickSummaryLink();
		pathSummary.clickWarningsCheckBox();
		pathSummary.clickSummaryLink();
		finalizationPage.clickFinalizationBreadcrumb();
		finalizationPage.verifyDBuserFinalizationButtons();
		finalizationPage.fillinRequiredFieldsClickPendingAndClickFinalize(JOB_CODE, COORD_CODE);
		finalizationPage.retryIfCloudConvertError();
		finalizationPage.verifyRCNValues();
		String generatedRcn = finalizationPage.getRCN();
		finalizationPage.clickSummaryBreadCrumb();
		pathSummary.clickPathAfterFinalize();
		finalizationPage.clickFinalizationBreadcrumb();
		finalizationPage.clickHeaderHome();
		pdatabase.accessPathDataBase();
		pdatabase.searchPathDatabaseBasedOnRCN(generatedRcn);
		pdatabase.deletePathFromPathDetailsFromDatabase();
	}

	/**
	 * LEGO-8010 : QA AUTO UI Need a confirm / cancel message for Manual Export
	 * button on Finalization pageLEGO-7765 LEGO-6596 : QA AUTO UI Add Project
	 * Status to Project Summary Header LEGO-6494 LEGO-10734 : QA AUTO UI : Add
	 * logic to try it 3 more times to avoid cloud converter error in UI LEGO-6842 :
	 * QA AUTO UI: Change "ppl_rcn" on path table to "ppl_rcn_id", update prior
	 * RCN's in Finalization Settings to match LEGO-6699
	 */
	@Test
	public void projectFinalization_DatabaseuserPermission_VerifyManualExport() {
		String projectStatus1 = "In Progress";
		String projectStatus2 = "Finalized";
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		String projectName = "DB-Manual Export";
		createPath.createBrandNewProjectPathAsDBUSer(projectName + randomNumber2, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathSummary.verifyProjectStatus(projectStatus1);
		finalizationPage.clickFinalizationBreadcrumb();
		finalizationPage.verifyPreviousRCN(RCN);
		finalizationPage.verifyDBuserFinalizationButtons();
		finalizationPage.clickManualExport();
		pathSummary.verifyProjectStatus(projectStatus2);
	}

	/**
	 * LEGO-7154 : QA AUTO UI: Finalization Settings > PCN Info Section > RCN Lookup
	 * LEGO-6551 LEGO-7155 : QA AUTO UI: Finalization Settings > Coordinator Info >
	 * Coordinator Code Lookup LEGO-6552 LEGO-10734 : QA AUTO UI : Add logic to try
	 * it 3 more times to avoid cloud converter error in UI
	 */
	@Test
	public void projectFinalization_RCNLookup_VerifyRCNLookupOnFinalizationForDBUSer() {
		String projectStatus1 = "In Progress";
		String projectStatus2 = "Finalized";
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		String projectName = "DB-Manual Export1";
		createPath.createBrandNewProjectPathAsDBUSer(projectName + randomNumber2, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathSummary.verifyProjectStatus(projectStatus1);
		finalizationPage.clickFinalizationBreadcrumb();
		finalizationPage.clickOverrideRCNLookup();
		pathDetail.verifyRcnLookupElements();
		finalizationPage.verifyOverrideRcnLookupSearch(RCN1, JOB_NUMBER, CONTACT_CODE);
		finalizationPage.clickCoodinatorCodeLookup();
		finalizationPage.contactLookup(COMPANYCODE, "", MANUFACTURERNAME);
		finalizationPage.verifyDBuserFinalizationButtons();
		finalizationPage.clickManualExport();
		pathSummary.verifyProjectStatus(projectStatus2);
	}

	/**
	 * LEGO-8675 : QA AUTO UI Add Propagation Model pick-list to Analysis Options:
	 * LEGO-8612 LEGO-9751 : QA AUTO UI Add Propagation Model Selections for 6 GHz
	 * AFC LEGO-9460
	 */
	@Test
	public void projectFinalization_propagationModal_VerifyAnalysisOptions() {
		String projectName = "AnalysisOption";
		String ohLoss = "OH Loss";
		String itm = "ITM / P.2108";
		String sixGhzOutdoor = "6 GHz Outdoor Model";
		String sixGhzIndoor = "6 GHz Indoor Traditional";
		String sixGhzInEff = "6 GHz Indoor Efficient";
		createPath.createBrandNewProjectPath(projectName + randomNumber, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		analysis.clickAnalysisButtonOnPathSummaryPage();
		analysis.verifyPropagationModalAnalysisOptions(ohLoss, itm, sixGhzOutdoor, sixGhzIndoor, sixGhzInEff);
	}

	/**
	 * LEGO-8938 : QA AUTO UI: Add new Processed Date field to Finalization page -
	 * External PCNs only LEGO-8880 LEGO-10734 : QA AUTO UI : Add logic to try it 3
	 * more times to avoid cloud converter error in UI
	 */
	@Test
	public void projectFinalization_databaseuserPermission_VerifyRCNWithProcessedDate() {
		loginPage.logout();
		loginPage.selectUserAndLogin("DB");
		String projectName = "DB-ProcessedDate_NS";
		createPath.createBrandNewProjectPathAsDBUSer(projectName + randomNumber2, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase(RCN1);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathSummary.clickASRBox();
		pathSummary.clickSummaryLink();
		pathSummary.clickCallSignCheckBox();
		pathSummary.clickSummaryLink();
		pathSummary.clickWarningsCheckBox();
		pathSummary.clickSummaryLink();
		finalizationPage.clickFinalizationBreadcrumb();
		finalizationPage.verifyDBuserFinalizationButtons();
		finalizationPage.fillinProcessedDate(PROCESSED_DATE);
		finalizationPage.fillinRequiredFieldsClickPendingAndClickFinalize(JOB_CODE1 + randomNumber2, COORD_CODE);
		finalizationPage.retryIfCloudConvertError();
		finalizationPage.verifyRCNValues();
		finalizationPage.verifyRCNValuesMatchesProcesedDate(PROCESSED_DATE);
		finalizationPage.verifySystemFilesAsDBuser();

	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
