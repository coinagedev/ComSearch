package CommTests;

import CommPageObjects.BasePage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathDetailAntennaPage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.PathDataBasePage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.ProjectManagementPage;
import CommPageObjects.QuickAddPage;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.assertEquals;

public class ProjectManagementTest extends BaseTest {
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private QuickAddPage quickAdd;
	private LoginPage login;
	private PathDetailPage pathDetail;
	private PathDetailAntennaPage pathDetailAnt;
	private PathDataBasePage pathDBpage;
	private ProjectManagementPage projectMngmnt;
	private static final String COMPANYCODE = "VERONA";
	private static final String MANUFACTURERNAME = "VERONA CABLEVISION";
	private static final String ASR1 = "1241006";
	private static final String ASR2 = "1208837";
	private static final String LATITUDE1 = "35 12 26.7 N";
	private static final String LONGITUDE1 = "78 03 21.2 W";
	private static final String LATITUDE2 = "35 12 25.0 N";
	private static final String LONGITUDE2 = "78 03 20.0 W";
	private static final String ELEVATION1 = "159.78";
	private static final String ELEVATION2 = "160.86";
	private static final String BAND_DESCRIPTION_DOT_NINETHREE = "0.93 GHz (932.5-944 MHz) US";

	@Before
	public void Setup() {

		if (host != "localhost") {}

		pathSummary = new PathSummaryPage(driver);
		createPath = new CreateNewPathPage(driver);
		pathDetail = new PathDetailPage(driver);
		quickAdd = new QuickAddPage(driver);
		pathDetailAnt = new PathDetailAntennaPage(driver);
		projectMngmnt = new ProjectManagementPage(driver);
		pathDBpage = new PathDataBasePage(driver);
		login = new LoginPage(driver);
		login.selectUserAndLogin("admin");

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);
	int randomNumber1 = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * LEGO-3148 : QA auto UI: Delete Projects LEGO-2946
	 */

	@Test
	public void pathDetailCreatePath_shouldPass_whenUserDeletesProject() {
		String projectName = "ProjectToDelete" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addAsrPathViaPathDetail2("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.clickSaveDetails();
		pathDetail.clickReturnButtonInPathDetailsPage();
		pathDetail.clickProject();
		projectMngmnt.searchProjectAndDeleteProject(projectName);
	}

	/**
	 * LEGO-3218 : AUTO UI: LEGO-3105 UI: Path import from path Database
	 */
	@Test
	public void projectDetails_shouldCreatePath_ByImportingPathFromPathDatabase() {
		String projectName = "Project" + randomNumber1;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnImportFromDatabase("", "KBY45");
		pathDBpage.clickPathDatabaseSearchResult();
	}

	/**
	 * LEGO-3156 - QA UI auto: Copy Project LEGO-2945
	 * 
	 * LEGO-2287 - Auto UI Set authenticated user on projects (created by/updated
	 * by) LEGO-2026
	 */
	@Test
	public void copyProject_shouldCopy_verifyCopyProjectCopyPath() {
		String projectName = "ProjectToCopy" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addAsrPathViaPathDetail2("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.clickSaveDetails();
		pathDetail.clickReturnButtonInPathDetailsPage();
		pathDetail.clickProject();
		projectMngmnt.searchProjectAndClickSelectProject(projectName);
		projectMngmnt.verifyCreatedByUserAndDate(projectName, "default_admin");
		String CopiedprojectName = projectMngmnt.copyProject(projectName);
		pathSummary.openPathInPathSummaryPage();
		pathDetail.verifySite1Values("CAMSLANT STATION", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.verifySite2Values("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, ELEVATION2);

	}

	/**
	 * LEGO-9840 : QA AUTO UI: Exclude soft deleted projects from the duplicate
	 * project name validation LEGO-9789
	 */
	@Test
	public void createProject_duplicateProjectCheck_verifyExcludeSoftDeletedProject() {
		String projectName = "ExcludeDeletedNS";
		String deleteSuccessMsg = "Successfully deleted the project(s).";
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		projectMngmnt.clickProjectsLink();
		projectMngmnt.searchProjectAndClickSelectProject(projectName);
		projectMngmnt.clickHamburger();
		projectMngmnt.clickDeleteProjectOption(deleteSuccessMsg);
		projectMngmnt.clickHome();
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		projectMngmnt.clickProjectsLink();
		projectMngmnt.searchProjectAndClickSelectProject(projectName);
		projectMngmnt.clickHamburger();
		projectMngmnt.clickDeleteProjectOption(deleteSuccessMsg);
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}