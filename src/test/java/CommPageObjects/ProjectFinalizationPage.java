package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProjectFinalizationPage extends BasePage {
	By headerHome = By.id("header-menu-home");
	By finalizationButton = By.id("project-summary-navigation-link-finalization");
	By coordinatorInfoCoordinatorCodeField = By.id("project-finalization-settings-coordinator-code");
	By mailOptionsPCNEmailField = By.id("project-finalization-settings-pcn-and-renewal-emails");
	By priorRCNValues = By.id("project-finalization-settings-prior-rcns");
	By RCNValues = By.id("project-finalization-settings-rcns");
	By JobCodeValue = By.id("project-finalization-settings-job-code");
	By generatedRCN = By.id("project-finalization-settings-rcns");
	
	By sendPCNButton= By.id("project-finalization-settings-send-pcn");
	By finalizationConfirmButton = By.id("project-finalization-finalize-confirmation-modal-confirm");
	By finalizationCancelButton = By.id("project-finalization-finalize-confirmation-modal-cancel");
	By notificationmanualExportFinalizationPage = By.xpath("//*[contains(@id, 'project-') and contains(@id, '-finalization-settings-manual-export-success')]");
	By notificationmanualPendingDBuserFinalizationPage = By.xpath("//*[contains(@id, 'project-') and contains(@id, '-finalization-settings-pending-project-success')]");
	By notificationmanualSaveFinalizationPage = By.xpath("//*[contains(@id, 'project-') and contains(@id, '-finalization-settings-save')]");
	By modifyPathDatasheetsButton = By.id("project-finalization-settings-modify-path-datasheet-modal-toggle");
	By modifyPCNEmailButton = By.id("project-finalization-settings-modify-pcn-email-modal-toggle");
	By manualExportButton = By.id("project-finalization-settings-manual-export");
	By pendingButton = By.id("project-finalization-settings-pending");
	By saveButton = By.id("project-finalization-settings-save");
	By finalizeButton = By.id("project-finalization-settings-finalize");
	By additionalLicenseeLookup = By.id("project-finalization-settings-additional-licensees-lookup-trigger");
	
	//Coodinator code lookup
	By coodinatorLookupIcon = By.id("project-finalization-settings-coordinator-code-lookup-trigger");
	By contactCodeContactLookup = By.id("contact-lookup-contact-code");
	By contactNameContactLookup = By.id("contact-lookup-contact-name");
	By contactCompanyContactLookup = By.id("contact-lookup-company-name");
	By SearchContactLookup = By.id("contact-lookup-submit");
	By contactCodeResults =  By.xpath("//*[contains(@id, 'contact-lookup-modal-table-data-contactCode-') and contains(@id, '-contactCode')]");
	By pcnNotes = By.id("project-finalization-settings-pcnNotes");
	
	By modifyPCNDatasheetsCreatePreviewLink = By.id("project-finalization-settings-modify-path-datasheet-modal-create-preview");
	By modifyPCNDatasheetsCloseButton = By.id("project-finalization-settings-modify-path-datasheet-modal-close");
	By modifyPCNDatasheetsHeader = By.id("project-finalization-settings-modify-path-datasheet-modal-header");
	By modifyPCNDatasheetsUploadButton = By.xpath("//*[@class='upload-decoration uppercase' and contains(text(),'Upload File')]");
	By modifyPCNDatasheetsUploadedFile = By.id("project-finalization-settings-modify-path-datasheet-modal-download");
	By modifyPCNDatasheetsDeleteFileButton = By.id("project-finalization-settings-modify-path-datasheet-modal-delete");
	By modifyPCNDatasheetsUploadFile = By.xpath(".//input[@type='file']");
	
	By modifyPCNEmailGeneratePreviewLink = By.id("project-finalization-settings-modify-pcn-email-modal-generate-preview-text");
	By modifyPCNEmailTextBox = By.xpath("//*[@class='jodit-wysiwyg']");
	By modifyPCNEmailExitButton = By.id("project-finalization-settings-modify-pcn-email-modal-close");
	By modifyPCNEmailSaveButton = By.id("PROJECT_FINALIZATION_MODIFY_PCN_LETTER-submit");
	By modifyPCNEmailCloseButton = By.id("PROJECT_FINALIZATION_MODIFY_PCN_LETTER-close-form");
	By modifyPCNEmailDeleteButton = By.id("PROJECT_FINALIZATION_MODIFY_PCN_LETTER-delete-saved-pcn-letter");
	
	//RCN Lookup UI
	By rcnLookupTrigger = By.id("path-details-rcn-number-lookup-trigger");
	By rcnLookupRcnNumber = By.id("rcn-lookup-rcn");
	By rcnLookupJobNumber = By.id("rcn-lookup-job-number");
	By rcnLookupContactCode = By.id("rcn-lookup-contact-code");
	By rcnLookupSearchButton = By.id("rcn-lookup-submit");
	By rcnLookupClearButton = By.id("rcn-lookup-clear"); 
	By overrideRCNLookupIconFinalizationPage = By.id("project-finalization-settings-override-prior-rcns-lookup-trigger");
	By rcnLookuppriorRCNResults = By.xpath("//*[contains(@id, 'rcn-lookup-modal-table-data-rcnId-') and contains(@id, '-rcnNumber')]");

	By expeditedResponseYes = By.id("project-finalization-settings-expedited-response-true-label-bottom");
	By responseDueDateField = By.id("project-finalization-settings-response-due-date");
	By responseDueDateErrorMessage = By.id("project-finalization-settings-response-due-date-error-message");
	By expeditedResponseNo = By.id("project-finalization-settings-expedited-response-false-label-bottom");
	By bandValueDisplayedOnFinalizationPage = By.id("project-finalization-settings-band-path-counts-0-band");
	By pcnDate = By.id("project-finalization-settings-pcn-date");
	
	By systemFilesSuppShow = By.xpath("//*[contains(@id, 'project-finalization-settings-system-files-data-projectFileId-') and contains(@id, '_SuppShow.docx')]");
	By systemFilesPCNLetterhtml = By.xpath("//*[contains(@id, 'project-finalization-settings-system-files-data-projectFileId-') and contains(@id, '_PCNLetter.html')]");
	By systemFilesPCNLetterpdf = By.xpath("//*[contains(@id, 'project-finalization-settings-system-files-data-projectFileId-') and contains(@id, '_PCNLetter.pdf')]");
	By systemFilesPathDatasheetdocx = By.xpath("//*[contains(@id, 'project-finalization-settings-system-files-data-projectFileId-') and contains(@id, '_PathDatasheet.docx')]");
	By systemFilesPathDatasheetpdf = By.xpath("//*[contains(@id, 'project-finalization-settings-system-files-data-projectFileId-') and contains(@id, '_PathDatasheet.pdf')]");
	By systemFilesMailingList = By.xpath("//*[contains(@id, 'project-finalization-settings-system-files-data-projectFileId-') and contains(@id, '_MailingList.csv')]");
	By summaryBreadcrumb = By.id("project-summary-navigation-link-summary");
	By pathSummaryCheckbox = By.id("project-summary-select-all-paths");
	By projectsLinkHeader = By.id("header-menu-projects-list");
	By processedDateField = By.id("project-finalization-settings-processed-date");
	By finalization_error = By.xpath("//*[contains(@id, 'project-finalization-settings-finalization-job-') and contains(@id, '-error')]");

	
	public ProjectFinalizationPage(WebDriver driver) {
		super(driver);
		visit("/");
	}
	
	/**
	 * This method clicks the finalization button on path summary page
	 */
	public void clickFinalizationBreadcrumb() {
		slowDown(3);
		assertTrue("project finalization button is missing", isDisplayed(finalizationButton, 5));
		clickJS(finalizationButton);
		
	}
	
	/**
	 * This finalizes the project by entering required fields clicks send PCN button
	 */
	public void finalizeAndSendPCN(String PCNEmail, String coordCode) {
		slowDown(3);
		focusAndType(coordinatorInfoCoordinatorCodeField, coordCode);
		slowDown(3);
		sendKeyEnter();
		type(PCNEmail, mailOptionsPCNEmailField);
		assertTrue("sendPCNButton is missing", isDisplayed(sendPCNButton, 300));
		clickSendPCN();
	}
	/**
	 * This method is to click send pcn
	 */
	public void clickSendPCN() {
		clickJS(sendPCNButton);
		assertTrue("project finalization confirm button is missing", isDisplayed(finalizationConfirmButton, 145));
		assertTrue("project finalization Cancel button is missing", isDisplayed(finalizationCancelButton, 145));
		click(finalizationConfirmButton);
		slowDown(1);
	}
	/**
	 * This fill in all required fields and click finalize button for database user
	 */
	public void fillinRequiredFieldsClickPendingAndClickFinalize(String JobCode, String coordCode) {
		slowDown(3);
		focusAndType(coordinatorInfoCoordinatorCodeField, coordCode);
		slowDown(3);
		sendKeyEnter();
		type(JobCode, JobCodeValue);
		slowDown(3);
		clickJS(pendingButton);
		slowDown(1);
		assertTrue("project finalization confirm button is missing", isDisplayed(finalizationConfirmButton, 145));
		assertTrue("project finalization Cancel button is missing", isDisplayed(finalizationCancelButton, 45));
		click(finalizationConfirmButton);
		slowDown(2);
		assertTrue("finalizeButton button is missing", isDisplayed(finalizeButton, 80));
		clickJS(finalizeButton);
		assertTrue("project finalization confirm button is missing", isDisplayed(finalizationConfirmButton, 145));
		assertTrue("project finalization Cancel button is missing", isDisplayed(finalizationCancelButton, 45));
		slowDown(1);
		click(finalizationConfirmButton);
	}
	
	
	
	/**
	 * This method verifies one RCN value appear when project is finalized
	 */
	public void verifyRCNValues() {
		slowDown(3);
		assertTrue("rcn values is missing", isDisplayed(RCNValues, 480));
		String values = getText(RCNValues);
		assertTrue("RCN contains duplicated values", !values.contains(","));
	}
	
	/**
	 * This method clicks the modify PCN email button
	 */
	public void clickModifyPCNEmail() {
		slowDown(3);
		assertTrue("modify pcn email button is missing", isDisplayed(modifyPCNEmailButton, 8));
		clickJS(modifyPCNEmailButton);
	}
	
	/**
	 * This method verifies functionality for modify pcn email
	 */
	public void verifyModifyPCNEmail() {
		slowDown(3);
		clickJS(modifyPCNEmailGeneratePreviewLink);
		slowDown(3);
		driver.switchTo().frame(0);
		clear(modifyPCNEmailTextBox);
		type("sample text", modifyPCNEmailTextBox);
		String expectedText = getText(modifyPCNEmailTextBox);
		driver.switchTo().defaultContent();
		clickJS(modifyPCNEmailSaveButton);
		slowDown(3);
		clickJS(modifyPCNEmailButton);
		slowDown(3);
		driver.switchTo().frame(0);
		assertEquals(expectedText, getText(modifyPCNEmailTextBox));
		driver.switchTo().defaultContent();
		clickJS(modifyPCNEmailGeneratePreviewLink);
		slowDown(3);
		driver.switchTo().frame(0);
		assertNotEquals(expectedText, getText(modifyPCNEmailTextBox));
		clear(modifyPCNEmailTextBox);
		type("more sample text", modifyPCNEmailTextBox);
		driver.switchTo().defaultContent();
		clickJS(modifyPCNEmailCloseButton);
		slowDown(3);
		clickJS(modifyPCNEmailButton);
		slowDown(3);
		driver.switchTo().frame(0);
		assertEquals(expectedText, getText(modifyPCNEmailTextBox));
		driver.switchTo().defaultContent();
		clickJS(modifyPCNEmailDeleteButton);
		slowDown(3);
		assertEquals("preview is not deleted", driver.findElements(By.tagName("iframe")).size(), 0);
		clickJS(modifyPCNEmailExitButton);
	}
	
	/**
	 * This method verifies elements on modify PCN datasheets window
	 */
	public void verifyElementsModifyPCNDatasheetsWindow() {
		slowDown(3);
		clickJS(modifyPathDatasheetsButton);
		assertTrue("modify datasheets create preview link is missing", isDisplayed(modifyPCNDatasheetsCreatePreviewLink, 5));
		assertTrue("modify datasheets close button is missing", isDisplayed(modifyPCNDatasheetsCloseButton, 5));
		assertTrue("modify datasheets header title is missing", isDisplayed(modifyPCNDatasheetsHeader, 5));
		assertTrue("modify datasheets upload button is missing", isDisplayed(modifyPCNDatasheetsUploadButton, 5));
	}
	
	/**
	 * This method verifies upload and download file functionality in modify PCN datasheets window
	 */
	public void verifyUploadFilePCNDatasheetsWindow(String fileName) {
		slowDown(3);
		clickJS(modifyPCNDatasheetsCreatePreviewLink);
		slowDown(3);
		uploadFile(fileName, modifyPCNDatasheetsUploadFile);
		slowDown(3);
		assertTrue("file link does not appear after uploading file", isDisplayed(modifyPCNDatasheetsUploadedFile,5));
		assertTrue("delete file button does not appear after uploading file", isDisplayed(modifyPCNDatasheetsDeleteFileButton,5));
		clickJS(modifyPCNDatasheetsDeleteFileButton);
		slowDown(3);
		assertTrue("file not deleted after clicking delete button", !isDisplayed(modifyPCNDatasheetsUploadedFile,5));
		clickJS(modifyPCNDatasheetsCloseButton);
	}
	/**
	 * This method is to get jobcode
	 * @return
	 */
	public String getJobCodeValue() {
		slowDown(3);
		assertTrue("jobCode values is missing", isDisplayed(JobCodeValue, 180));
		String jobCode = getAttributeValue(JobCodeValue);
		return jobCode;
	}
	/**
	 * This method is to get rcn
	 * @return
	 */
	public String getRCN() {
		slowDown(3);
		assertTrue("RCN values is missing", isDisplayed(generatedRCN, 180));
		String rcn = getText(generatedRCN);
		return rcn;
	}

	public void clickHeaderHome() {
		assertTrue("Header Home is missing", isDisplayed(headerHome, 5));
		click(headerHome);
		
	}
	/**
	 * This method is to verify the finalization elements for database user
	 */

	public void verifyDBuserFinalizationButtons() {
		assertTrue("Manual Export button is missing", isDisplayed(manualExportButton, 8));
		assertTrue("Save button is missing", isDisplayed(saveButton, 8));
		assertTrue("Pending button is missing", isDisplayed(pendingButton, 8));
		assertTrue("finalizeButton button is missing", isDisplayed(finalizeButton, 8));
		
	}
	/**
	 * This method is to verify the Additional Licensee Lookup
	 * @companyNAme
	 */

	public void verifyAdditionalLicenseeLookup(String companyName) {
		assertTrue("modify pcn email button is missing", isDisplayed(modifyPCNEmailButton, 8));
		assertTrue("modify pcn email button is missing", isDisplayed(additionalLicenseeLookup, 8));
		clickJS(additionalLicenseeLookup);
		assertTrue("modify pcn email button is missing", isDisplayed(contactCodeContactLookup, 40));
		type(companyName,contactCompanyContactLookup);
		slowDown(1);
		click(SearchContactLookup);
		assertTrue("modify pcn email button is missing", isDisplayed(contactCodeResults, 120));
		click (contactCodeResults,0);
		slowDown(2);
		assertTrue("coordinator code button is missing", isDisplayed(coordinatorInfoCoordinatorCodeField, 40));
			
	}
	/**
	 * This method is to do manual export on finalization page
	 */
	public void clickManualExport() {
		assertTrue("Manual Export button is missing", isDisplayed(manualExportButton, 8));
		slowDown(1);
		click(manualExportButton);
		assertTrue("project finalization confirm button is missing", isDisplayed(finalizationConfirmButton, 145));
		assertTrue("project finalization Cancel button is missing", isDisplayed(finalizationCancelButton, 45));
		click(finalizationConfirmButton);
		assertTrue("project export message is missing", isDisplayed(notificationmanualExportFinalizationPage, 145));
		assertEquals("Path didn't get exported","The project was Manually Exported successfully.",getText(notificationmanualExportFinalizationPage));
	}
	/**
	 * this method is to click RCN lookup from finalization page
	 */
	public void clickOverrideRCNLookup() {
		assertTrue("Override RCN lookup missing",isDisplayed(overrideRCNLookupIconFinalizationPage,20));
		click(overrideRCNLookupIconFinalizationPage);

	}
	/**
	 * This method verifies RCN fields are correctly populated after RCN lookup search
	 * @param rcn
	 * @param jobNumber
	 * @param contactCode
	 */
	public void verifyOverrideRcnLookupSearch(String rcn, String jobNumber, String contactCode) {
		assertTrue("rcn lookup is missing",isDisplayed(rcnLookupClearButton));
		type(rcn, rcnLookupRcnNumber);
		type(jobNumber, rcnLookupJobNumber);
		type(contactCode, rcnLookupContactCode);
		click(rcnLookupSearchButton);
		slowDown(3);
		clickJS(rcnLookuppriorRCNResults);
		slowDown(3);
		
	}
	/** 
	 * this method is to click coordinator code looup icon
	 */

	public void clickCoodinatorCodeLookup() {
		assertTrue("coordinator looup is missing", isDisplayed(coodinatorLookupIcon,15));
		click(coodinatorLookupIcon);
		assertTrue("Contact lookup is missing",isDisplayed(contactCodeContactLookup,15));
		
	}
	/**
	 * This method fills out company information
	 * 
	 * @param contactCode - company code
	 * @param contactName - contact name
	 * @param company - company
	 */
	public void contactLookup(String contactCode, String contactName,String companyName) {
		assertTrue("contact code in contact lookup is missing",isDisplayed(contactCodeContactLookup,60));
		type(contactCode, contactCodeContactLookup);
		type(contactName, contactNameContactLookup);
		type(companyName, contactCompanyContactLookup);
		assertTrue("Can't find Search Button",isDisplayed(SearchContactLookup,30));
		click(SearchContactLookup);
		isDisplayed(contactCodeResults,160);
		click(contactCodeResults);
		assertTrue("Finalization page is not displayed",isDisplayed(pcnNotes,30));


	}
	/**
	 * this method is validation for response due date
	 * @param error
	 */
	public void verifyResponseDueDateCantBeMoreThan35Days(String error) {
		assertTrue("Finalization page is not displayed",isDisplayed(pcnNotes,30));
		click(expeditedResponseYes);
		String responseDate = getFieldText(responseDueDateField);
		clear(responseDueDateField);
		type("2040/05/11",responseDueDateField);
		click(pcnNotes);
		assertTrue("Response due date error is not displayed for a date more than 35 days from todays date",isDisplayed(responseDueDateErrorMessage,60));
		assertEquals(error,getText(responseDueDateErrorMessage));
		clear(responseDueDateField);
		type(responseDate,responseDueDateField);
		click(expeditedResponseNo);
	}
	/**
	 * This method is to verify band value
	 */
	public void verifyBandValueDisplayed() {
		assertTrue("band value is not displayed on the finalization page",isDisplayed(bandValueDisplayedOnFinalizationPage,30));
		
	}
	/**
	 * This method is to verify the pcn date is filled up
	 */
	public void verifyPCNDate() {
		assertTrue("PCN date is displayed",isDisplayed(pcnDate,30));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime(); 
		String todaysDate = dateFormat.format(currentDate);
		String pcnDateValue = getFieldText(pcnDate);
		assertEquals(todaysDate,pcnDateValue);
		
	}
	/**
	 * This method is to verify the system files
	 */

	public void verifySystemFiles() {
		assertTrue("suppshow is not generated",isDisplayed(systemFilesSuppShow,20));
		assertTrue("pcn letter html is not generated",isDisplayed(systemFilesPCNLetterhtml,20));
		assertTrue("pcn letter pdf is not generated",isDisplayed(systemFilesPCNLetterpdf,20));
		assertTrue("systemFiles PathDatasheet docx is not generated",isDisplayed(systemFilesPathDatasheetdocx,20));
		assertTrue("systemFiles PathDatasheet pdf is not generated",isDisplayed(systemFilesPathDatasheetpdf,20));
		assertTrue("systemFiles MailingList is not generated",isDisplayed(systemFilesMailingList,20));
		
	}
	/**
	 * This method is to verify the previous RCN is populated correctly
	 * @param previousRcn 
	 */
	public void verifyPreviousRCN(String previousRcn) {
		assertTrue("Finalization page is not displayed",isDisplayed(pcnNotes,30));
		assertTrue("Prior RCN in Finalization page is not displayed",isDisplayed(priorRCNValues,30));
		assertEquals(getText(priorRCNValues),previousRcn);
		
	}
	/**
	 * This method is to click the summary from breadcrumb
	 * @return
	 */
	public void clickSummaryBreadCrumb() {
		assertTrue("Summary breadcrumb in Finalization page is not displayed",isDisplayed(pcnNotes,30));
		clickJS(summaryBreadcrumb);
		assertTrue("path summary page is not displayed", isDisplayed(pathSummaryCheckbox,30));
	}
	/**
	 * This methos is to click project link from header
	 */
	public void clickProjectsFromHeader() {
		assertTrue("project link in header is missing",isDisplayed(projectsLinkHeader,20));
		click(projectsLinkHeader);
	}
	/**
	 * This method is to fill in processed date
	 * @param processedDate 
	 */
	public void fillinProcessedDate(String processedDate) {
		assertTrue("Processed date field is missing", isDisplayed(processedDateField, 15));
		type(processedDate,processedDateField);
	}
	/**
	 * this method is to verify RCN values matches processed date
	 */
	public void verifyRCNValuesMatchesProcesedDate(String procesedDate) {
		assertTrue("rcn values is missing", isDisplayed(RCNValues, 380));
		String rcnGenaratedBasedOnProcessedDate = procesedDate.substring(2,4)+procesedDate.substring(5,7)+procesedDate.substring(8,10);
		String processedDateRCN = getText(RCNValues);;
		assertEquals(rcnGenaratedBasedOnProcessedDate,processedDateRCN.substring(0,6));
	}
	/**
	 * This method is to verify the system files as db user
	 */

	public void verifySystemFilesAsDBuser() {
		assertTrue("systemFiles PathDatasheet docx is not generated",isDisplayed(systemFilesPathDatasheetdocx,20));
		assertTrue("systemFiles PathDatasheet pdf is not generated",isDisplayed(systemFilesPathDatasheetpdf,20));
		
	}
	/**
	 * this method is to retry if there is cloud convert error
	 */
	public void retryIfCloudConvertError() {
		
		int i = 0;
		//retry 2 more time since we already tried once
		while (i < 2)
		{
			if(isDisplayed(finalization_error, 180)&& getText(finalization_error).contains("fails more than 3 times")) {
				clickSendPCN();
				 if(isDisplayed(RCNValues, 60)) {
						assertTrue("rcn values is missing", isDisplayed(RCNValues, 60));
						break;
				}
			}
			
			i++;
		}

		if ( i == 2){
			assertTrue("cloud convert error is present even after trying thrice", isDisplayed(RCNValues,30));
			
		}
			
	}
}
