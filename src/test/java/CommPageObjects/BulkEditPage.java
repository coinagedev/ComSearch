package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @author nshaji
 *
 */
public class BulkEditPage extends BasePage {
	By bulkEditButtonPathSummary = By.id("project-summary-bulk-edits");
	By quickAddbutton=By.id("project-summary-quick-add-open");

	By siteNameResultsOnSiteLookup = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-siteName')]");
	By pathNamePathSummary = By.xpath("//*[contains(@id, 'bulk-edit-path-table-data-pathId-') and contains(@id, '-pathInfo')]/div/div[2]");

	By selectMultipleSitesSelectBulkEditInPathSummary = By.xpath("//*[contains(@id, 'bulk-edit-path-table-data-pathId-') and contains(@id, '-segmentStatus')]/div/div[1]");

	By bulkEditSiteName = By.id("bulk-edits-form-site-0-siteName");
	By bulkEditSiteNAmeHamburger = By.id("bulk-edits-form-site-0-siteName-lookup-trigger");
	By siteNameFieldSiteLookup = By.id("site-lookup-site-name");
	By submitButtonOnSiteLookUpWindowFromBulkEdit = By.id("site-lookup-submit");
	By saveButtonOnBulkEditPage = By.id("bulk-edits-form-footer-save");
	By ContinueButtonConfirmationBulkEdit=By.xpath(".//div/div/div/div/p[2]");

	By saveMessageSite = By.xpath("//div[4]/div/div/div/p");
	By saveMessagePath = By.xpath("html/body/div[3]/div/div/div/p/span");

	By returnToPathSummaryButton = By.id("bulk-edit-path-table-footer--return");

	By editPathButtonBukEditPage = By.id("bulk-edits-filter-bulk-mode--path-label-bottom");
	By frequencyBandDropDown = By.id("bulk-edits-form-path-info--path-info-band-select");
	By site1FrequencyPlan = By.id("bulk-edits-form-frequency-info-0-frequency-plan");
	By site2FrequencyPlan = By.id("bulk-edits-form-frequency-info-1-frequency-plan");
	By site1FrequencyChannel10 = By.id("bulk-edits-form-frequency-info-0-0-polarization");
	By site2FrequencyChannel20 = By.id("bulk-edits-form-frequency-info-0-1-polarization");
	By bulkEditRCNField =By.id("bulk-edits-form-path-info--path-info-rcn-number");
	By bulkJobNumber = By.id("bulk-edits-form-path-info--path-info-job-code");
	By bulkEditWarningClearAll =By.id("path-validations-drawer-clear-all");

	public BulkEditPage(WebDriver driver) {
		super(driver);
		visit("/");
	}
	/**  
	 * This method is to click bulk edits button on path summary page
	 */
	public void clickBulkEditsButton(){
		assertTrue("Bulk Edits button in path summary page is missing",isDisplayed(bulkEditButtonPathSummary,50));
		click(bulkEditButtonPathSummary);
		assertTrue("Bulk Edits Site name field in path summary page is missing",isDisplayed(bulkEditSiteName,50));
	}
	/**
	 * This method is to click sitename hamburger for bulk edit and fill in values and perform search
	 * @param sitename 
	 */
	public void clickSiteNameHamburgerAndPerformSiteSearch(String sitename) {
		slowDown(2);
		click(bulkEditSiteNAmeHamburger);
		assertTrue("Site Name field in site lookup window from bulk edit page is missing",isDisplayed(siteNameFieldSiteLookup,40));
		type(sitename,siteNameFieldSiteLookup);
		click(submitButtonOnSiteLookUpWindowFromBulkEdit);
		slowDown(5);
		click(siteNameResultsOnSiteLookup);
		assertTrue("Site Name field on bulk edit window is missing",isDisplayed(bulkEditSiteName));

	}
	/**
	 * This method is to save multiple sites from multiple path for bulk edit
	 */
	public void selectMultipleSitesFrommultiplepathOnPathSummary() {
		click(selectMultipleSitesSelectBulkEditInPathSummary,0);
		click(selectMultipleSitesSelectBulkEditInPathSummary,1);
		slowDown(2);

	}
	/**
	 * This method is to click Save button on bulk edit page
	 */
	public void clickSaveButtonOnBulkEditPage() {
		assertTrue("save button on bulk edit page is missing",isDisplayed(saveButtonOnBulkEditPage,40));
		click(saveButtonOnBulkEditPage);
		slowDown(2);

	}
	/**
	 * This method is to confinue and confirm bulk edit for site
	 *
	 */
	public void continueConfirmBulkEdit() {
		assertTrue("Continue button on confirmation modal is missing",isDisplayed(ContinueButtonConfirmationBulkEdit,240));
		click(ContinueButtonConfirmationBulkEdit);
		slowDown(2);
	}
	/**
	 * This method is to verify the save message for site bulk edit
	 * @ text
	 */
	public void bulkSaveSiteSuccessMessage(String text) {
		assertTrue("save message is missing",isDisplayed(saveMessageSite,60));
		assertEquals(text,getText(saveMessageSite));
	}
	/**
	 * This method is to verify the save message for path bulk edit
	 * @ text
	 */
	public void bulkSavePathSuccessMessage(String text) {
		assertEquals(text,getText(saveMessagePath));
	}

	/**
	 * This method is to click return to path summary button
	 */
	public void clickReturnToPathSummaryButton() {
		assertTrue("Return To PathSummary Button is missing",isDisplayed(returnToPathSummaryButton,20));
		click(returnToPathSummaryButton);
		slowDown(2);
	}
	/**
	 * This method is click and select Edit path in bulk edit window
	 */
	public void clickSelectEditPathButton() {
		assertTrue("Edit path button is missing in bulk edit window",isDisplayed(editPathButtonBukEditPage,20));
		click(editPathButtonBukEditPage);
		assertTrue("frequency Band DropDown is missing in bulk edit window",isDisplayed(frequencyBandDropDown,20));

	}
	/**
	 * This method is to chnage the frequency plan for multiple paths by path bulk edit
	 * @param plan1
	 * @param plan2
	 */
	public void changeFrequencyForBothPathBulkEdit(String plan1, String plan2) {
		assertTrue("frequency Band DropDown is missing in bulk edit window",isDisplayed(frequencyBandDropDown,20));
		type(plan1, site1FrequencyPlan);
		slowDown(2);
		click(editPathButtonBukEditPage);
		slowDown(1);
		type(plan2, site2FrequencyPlan);
		click(editPathButtonBukEditPage);
		selectFrequencyChannels();
		click(pathNamePathSummary,0);
		slowDown(2);
		click(pathNamePathSummary,1);
		slowDown(1);

	}
	/**
	 * This method is to select frequency channels
	 */
	public void selectFrequencyChannels() {
		slowDown(2);
		selectFromDropdown(site1FrequencyChannel10,"Both V/H");
		selectFromDropdown(site2FrequencyChannel20,"Both V/H");
		slowDown(3);
	}
	/**
	 * this method is to close warning if present
	 */
	public void closeWarning() {
		slowDown(2);
		if(isDisplayed(bulkEditWarningClearAll)) {
			click (bulkEditWarningClearAll);
			assertTrue("return to summary button missing",isDisplayed(returnToPathSummaryButton,50));
		}
	}

}
