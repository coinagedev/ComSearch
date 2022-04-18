package CommTests;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import CommPageObjects.BasePage;
import CommPageObjects.BulkEditPage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathDetailAntennaPage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.PathSummaryPage;

/**
 * Created by nshaji
 */
public class BulkEditTest extends BaseTest {
	// private QuickAddPage quickAdd;
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private PathDetailPage pathDetail;
	private PathDetailAntennaPage pathDetailAnt;
	private BulkEditPage bulkEdit;
	private LoginPage login;
	private static final String BAND_DESCRIPTION_DOT_NINETHREE = "0.93 GHz (932.5-944 MHz) US";
	private static final String LATITUDE1 = "35 12 26.7 N";
	private static final String LONGITUDE1 = "78 3 21.2 W";
	private static final String LATITUDE2 = "35 12 25 N";
	private static final String LONGITUDE2 = "78 3 20 W";
	private static final String COMPANYCODE = "VERONA";
	private static final String MANUFACTURERNAME = "VERONA CABLEVISION";

	@Before
	public void Setup() {

		if (host != "localhost") {}

		// quickAdd = new QuickAddPage(driver);
		pathSummary = new PathSummaryPage(driver);
		createPath = new CreateNewPathPage(driver);
		pathDetail = new PathDetailPage(driver);
		pathDetailAnt = new PathDetailAntennaPage(driver);
		bulkEdit = new BulkEditPage(driver);
		login = new LoginPage(driver);
		login.selectUserAndLogin("admin");

	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);
	int randomNumber1 = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * LEGO-4282 : AUTO UI: Bulk Edit Site form LEGO-3728
	 */
	/**
	 * LEGO-4107 : QA Automation UI: Create Bulk Edits Wrapper / Table LEGO-3727
	 */
	@Test
	public void createPath_BulkEdit_VerifyBulkEditSite() {
		String projectName = "Project ABC" + randomNumber;
		createPath.createBrandNewProjectPath(projectName, "This is the Default");
		createPath.contactLookup(COMPANYCODE, MANUFACTURERNAME, "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addAsrPathViaPathDetail1("CAMSLANT STATION", "", LATITUDE1, LONGITUDE1, "159.78",
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.addAsrPathViaPathDetail2("SYNRAMS STATION", "", LATITUDE2, LONGITUDE2, "160.86");
		pathDetail.antennaFieldValidation();
		pathDetail.addPrimaryAntennaForSite1AndSite2("A02402", "A02402");
		pathDetail.addRadioForSite1AndSite2("M09002", "M09002");
		pathDetail.addLossForSite1AndSite2("1", "1", "1");
		pathDetail.enterFrequencyPlanInPathDetailsPage("H}", "L}");
		pathDetailAnt.clickSaveDetails();
		pathDetail.closeWarning();
		pathDetail.clickReturnButtonInPathDetailsPage();
		pathDetail.openPath();
		pathDetail.copyPathViaPathDetails("PATH COPIED SUCCESSFULLY\n" + "You have successfully copied the path.");
		pathDetail.closePathDetails();
		bulkEdit.clickBulkEditsButton();
		bulkEdit.clickSiteNameHamburgerAndPerformSiteSearch("990 N CENTER");
		bulkEdit.selectMultipleSitesFrommultiplepathOnPathSummary();
		bulkEdit.clickSaveButtonOnBulkEditPage();
		bulkEdit.continueConfirmBulkEdit();
		bulkEdit.closeWarning();
		bulkEdit.clickReturnToPathSummaryButton();
		bulkEdit.clickBulkEditsButton();
		bulkEdit.clickSelectEditPathButton();
		bulkEdit.changeFrequencyForBothPathBulkEdit("H<", "L<");
		bulkEdit.clickSaveButtonOnBulkEditPage();
		bulkEdit.continueConfirmBulkEdit();
		bulkEdit.closeWarning();
		bulkEdit.clickReturnToPathSummaryButton();
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
