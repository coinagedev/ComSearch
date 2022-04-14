package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class InterferenceCaseSummaryPage extends BasePage {
	By returnButton = By.id("case-summary-footer-return");
	By reportsButton = By.id("case-summary-footer-reports-modal-trigger");
	By showAllCasesOnToggle = By.id("case-summary-footer-on-label");
	By showAllCasesOffToggle = By.id("case-summary-footer-off-label");
	By filterButton = By.id("afs-grid-footer-result-filter-button");
	By filterOnToggle = By.id("afs-grid-footer-result-filter-toggle-true-label");
	By filterOffToggle = By.id("afs-grid-footer-result-filter-toggle-null-label");
	By chevronResultArrow = By.id("case-set-1-6-channel-index"); 
	By generateReportsSuccessMessage = By.xpath("//*[text()='Case Details Report Job Submitted']");
	
	By channelCaseListHeader = By.id("channel-case-list-header-top");
	By channelCaseListSubjectPathHeader = By.id("channel-case-list-header-middle-subject");
	By channelCaseListResult = By.xpath("//*[contains(@id, 'channel-case-list-') and contains(@id, '-case-number')]");	
	By channelCaseListAdditionalFilteredResult = By.xpath("//*[contains(@id, 'channel-case-list-') and contains(@id, '-grey')]");
	By channelCaseListContactCode = By.xpath("//*[contains(@id, 'channel-case-list-') and contains(@id, '-environment-contact')]");
	By channelCaseListContactCodeArray = By.xpath("//*[contains(@id, 'contact-lookup-modal-table-data-contactCode-')]");

	By channelCaseSelectAllCheckbox = By.id("channel-case-list-header-bottom-terr-case-select-all");
	By channelCaseCheckbox = By.xpath("//*[contains(@id, 'channel-case-list-') and contains(@id, '-terr-case-check-mark')]");

	By updateAntennaWindowAntennaCode = By.id("subjectAntenna-antenna-code");
	By updateAntennaWindowAntennaModel = By.id("subjectAntenna-antenna-model");
	
	By reportsWindowReportName = By.id("interference-analysis-case-summary-case-report-downloadreport-name");
	By openedChannelsOnlyToggle = By.id("interference-analysis-case-summary-case-report-downloadreportChannelScope-custom-label-bottom");
	By allChannelsOnlyToggle = By.id("interference-analysis-case-summary-case-report-downloadreportChannelScope-all-label-bottom");
	By reportsWindowAssignedChannelsOnToggle = By.id("interference-analysis-case-summary-case-report-downloadassigned-channel-toggle-true-label");
	By reportsWindowAssignedChannelsOffToggle = By.id("interference-analysis-case-summary-case-report-downloadassigned-channel-toggle-false-label");
	By reportsWindowDocxCheckbox = By.id("interference-analysis-case-summary-case-report-download-export-types-docx-icon");
	By reportsWindowPdfCheckbox = By.id("interference-analysis-case-summary-case-report-download-export-types-pdf-icon");
	By reportsWindowCancelButton = By.id("interference-analysis-case-summary-case-report-download-cancel");
	By reportsWindowSubmitButton= By.id("interference-analysis-case-summary-case-report-download-submit");
	By reportsWindowFormatErrorMessage = By.id("interference-analysis-case-summary-case-report-download-error");
	
	By filterPageCancelButton = By.id("afs-results-filter-footer-cancel");
	By filterPageApplyButton = By.id("afs-results-filter-footer-apply");
	By filterPageDefaultButton = By.id("afs-results-filter-footer-default");
	By filterPageContactLookupTrigger = By.id("afs-results-filtercontact-lookup-trigger");
	By filterPagePathLookupTrigger = By.id("afs-result-filter-ignore-path-lookup-trigger");
	By filterPageClearAllButton = By.id("afs-results-filter-clear-ignore-paths-table");
	By filterPageBuckRadiusField = By.id("afs-results-filter-buckDistanceKm");
	By filterPageBuckRadiusErrorMessage = By.id("afs-results-filter-buckDistanceKm-error-message");

	By contactLookupContactCodeField = By.id("contact-lookup-contact-code");
	By contactLookupSearchButton = By.id("contact-lookup-submit");
	By contactLookupResult = By.xpath("//*[contains(@id, 'contact-lookup-modal-table-data-contactCode-') and contains(@id, '-contactCode')]");

	//MW OH Drawer  
	By caseStatusOHTrigger = By.xpath("//*[contains(@id, 'channel-case-list-') and contains(@id, '-case-details-trigger')]");
	By addOHLossInDrawer = By.id("case-oh-details-drawer-profile-data-addRow-add");	
	By distanceFieldOHDrawer = By.id("case-oh-details-drawer-profile-data-addRow-distance");
	By elevationFieldOHDrawer = By.id("case-oh-details-drawer-profile-data-addRow-elevation");
	By clutterHeightField= By.id("case-oh-details-drawer-profile-data-addRow-clutter-height");
	By applyButtonOHDrawer = By.id("case-oh-details-drawer-profile-data-addRow-apply");
	By cancelButtonOHDrawer = By.id("case-oh-details-drawer-profile-data-addRow-apply-cancel");
	By caseReportButtonOHDrawer = By.id("case-oh-details-drawer-profile-data-export-case-report");
	By oHReportButtonOHDrawer = By.id("case-oh-details-drawer-profile-data-export-oh-report");
	By kmlKMZReportButtonOHDrawer = By.id("case-oh-details-drawer-profile-data-export-kml-report");
	By distanceFieldErrorMessageOHDrawer = By.id("case-oh-details-drawer-profile-data-addRow-distance-error-message");
	By elevationFieldOHDrawerErrorMessage = By.id("case-oh-details-drawer-profile-data-addRow-elevation-error-message");
	By clutterFieldOHDrawerErrorMessage = By.id("case-oh-details-drawer-profile-data-addRow-clutter-height-error-message");
	By deletePRofileData1Point = By.id("case-oh-details-drawer-profile-data-1-delete");
	By closeOHDrawer = By.id("case-status-drawer-close");
	By applyUpdateOHProfileData = By.xpath("//*[contains(@id, 'case-oh-details-drawer-profile-data-') and contains(@id, '-apply')]");
	By deleteRowConfirmButtonOHDrawerConfirmationPopup =  By.xpath("//*[contains(@id, 'case-oh-details-drawer-profile-data-') and contains(@id, '-delete-confirmation-confirm')]");
	By deleteRowCancelButtonOHDrawerConfirmationPopup =  By.xpath("//*[contains(@id, 'case-oh-details-drawer-profile-data-') and contains(@id, '-delete-confirmation-cancel')]");
	By elevationRow1 = By.id("case-oh-details-drawer-profile-data-1-elevation");
	By deleteRedXDatapoint1 = By.id("case-oh-details-drawer-profile-data-1-delete");
	By datapoint1DistanceValue = By.id("case-oh-details-drawer-profile-data-1-distance");
	By bandLabelOHDrawer = By.id("case-oh-details-drawer-bandDesignator-label");
	By climateLabelOHDrawer = By.id("case-oh-details-drawer-climateZone-label");
	By label20percentOHLoss = By.id("case-oh-details-drawer-ohLoss20-label");
	By labeldot01percentOHLoss= By.id("case-oh-details-drawer-ohLoss01-label");
	By longtermMarginLabel= By.id("case-oh-details-drawer-longTermMargin-label");
	By shortTermMargin = By.id("case-oh-details-drawer-shortTermMargin-label");
	By worstCaseReportButton = By.id("case-summary-footer-worst-case");
	By worstCaseDocx = By.id("worst-case-report-modal-export-types-docx-icon");
	By worstCasePdf = By.id("worst-case-report-modal-export-types-pdf-icon");
	By worstcaseSubmitButton = By.id("worst-case-report-modal-submit");
	By worstCaseReportNameField = By.id("worst-case-report-modalreport-name");
	
	
	public InterferenceCaseSummaryPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method verifies all AFS path case summary page elements are displayed
	 */
	public void verifyPathCaseSummaryPageElements() {
		assertTrue("Path case summary return button is missing", isDisplayed(returnButton,8));
		assertTrue("Path case summary reports button is missing", isDisplayed(reportsButton,8));
		assertTrue("Path case summary show all cases on button is missing", isDisplayed(showAllCasesOnToggle,8));
		assertTrue("Path case summary show all cases off button missing", isDisplayed(showAllCasesOffToggle,8));
		assertTrue("Path case summary filter on button is missing", isDisplayed(filterOnToggle,8));
		assertTrue("Path case summary filter off button is missing", isDisplayed(filterOffToggle,8));
		assertTrue("Path case summary filter button is missing", isDisplayed(filterButton,8));
	}

	/**
	 * This method clicks the chevron result arrow
	 */
	public void clickChevronResult() {
		slowDown(3);
		assertTrue("Can't find the chevron arrow button",isDisplayed(chevronResultArrow,5));
		clickJS(chevronResultArrow);
		slowDown(1);
	}
	
	/**
	 * This method clicks the select all checkbox from channel case list
	 */
	public void clickSelectAllCheckbox() {
		slowDown(3);
		assertTrue("Select All checkbox is missing", isDisplayed(channelCaseSelectAllCheckbox, 5));
		clickJS(channelCaseSelectAllCheckbox);
		slowDown(1);
	}
	
	/**
	 * This method clicks the reports button on path case summary page
	 */
	public void clickReportsButton() {
		slowDown(3);
		assertTrue("Reports Button is missing", isDisplayed(reportsButton, 5));
		clickJS(reportsButton);
		slowDown(1);
	}
	
	/**
	 * This method clicks the filter button on path case summary page
	 */
	public void clickFilterButton() {
		slowDown(3);
		assertTrue("Filter Button is missing", isDisplayed(filterButton, 5));
		clickJS(filterButton);
		slowDown(1);
	}

	/**
	 * This method verifies all elements are displayed on reports window pop up
	 */
	public void verifyReportsWindowElements() {
		assertTrue("Reports window report name field is missing", isDisplayed(reportsWindowReportName,8));
		assertTrue("Opened channels only toggle button is missing", isDisplayed(openedChannelsOnlyToggle,8));
		assertTrue("All channels only toggle button is missing", isDisplayed(allChannelsOnlyToggle,8));
		assertTrue("Report window DocX checkbox is missing", isDisplayed(reportsWindowDocxCheckbox,8));
		assertTrue("Report window Pdf checkbox is missing", isDisplayed(reportsWindowPdfCheckbox,8));
		assertTrue("Report window cancel button is missing", isDisplayed(reportsWindowCancelButton,8));
		assertTrue("Report window submit button is missing", isDisplayed(reportsWindowSubmitButton,8));
	}
	
	/**
	 * This method verifies that report is successfully generated after clicking submit
	 */
	public void verifyReportsGenerateReport() {
		slowDown(2);
		type("New Report", reportsWindowReportName);
		clickJS(reportsWindowSubmitButton);
		assertTrue("'Must export at least one format' error message not shown", isDisplayed(reportsWindowFormatErrorMessage,8));
		clickJS(reportsWindowDocxCheckbox);
		clickJS(reportsWindowPdfCheckbox);
		slowDown(2);
		clickJS(reportsWindowSubmitButton);
		assertTrue("generate report success popup message is not displayed", isDisplayed(generateReportsSuccessMessage,8));
	}

	/**
	 * This method verifies that check boxes are working properly for channel case list
	 */
	public void verifyCheckbox() {
		slowDown(3);
		assertTrue("Select All checkbox is missing", isDisplayed(channelCaseSelectAllCheckbox,8));
		assertTrue("Result checkbox is missing", isDisplayed(channelCaseCheckbox,8));
		click(channelCaseSelectAllCheckbox);
		assertTrue("Checkbox is not checked after clicking select all checkbox", checked(channelCaseCheckbox));	
		clickJS(chevronResultArrow);
		slowDown(3);
		clickJS(chevronResultArrow);
		slowDown(3);
		assertTrue("Checkbox is not cleared after closing channel list", !checked(channelCaseCheckbox));
		click(channelCaseCheckbox);
		clickJS(showAllCasesOnToggle);
		slowDown(3);
		clickJS(showAllCasesOffToggle);
		slowDown(3);
		assertTrue("Checkbox is not checked after clicking show all cases toggle", checked(channelCaseCheckbox));
	}

	/**
	 * This method verifies that all elements are displayed on the filter page
	 */
	public void verifyFilterPageElements() {
		assertTrue("filter page cancel button is missing", isDisplayed(filterPageCancelButton,8));
		assertTrue("filter page apply button is missing", isDisplayed(filterPageApplyButton,8));
		assertTrue("filter page default button is missing", isDisplayed(filterPageDefaultButton,8));
		assertTrue("filter page contact lookup trigger is missing", isDisplayed(filterPageContactLookupTrigger,8));
		assertTrue("filter page path lookup trigger is missing", isDisplayed(filterPagePathLookupTrigger,8));
	}

	/**
	 * This method creates a new filter that ignores specified contact
	 */
	public void filterByContactCode(String contactCode) {
		slowDown(3);
		clickJS(filterPageContactLookupTrigger);
		type(contactCode, contactLookupContactCodeField);
		slowDown(3);
		clickJS(contactLookupSearchButton);
		slowDown(3);
		clickJS(contactLookupResult);
		slowDown(3);
		clickJS(filterPageApplyButton);
		slowDown(3);
	}

	
	/**
	 * This method verifies filter toggle is working using contact code;after filtering the contact code shouldn't show up
	 */
	public void verifyResultsFilterToggle(String filteredContactCode) {
		slowDown(2);
		String a;
		int rows = getRows(channelCaseListContactCodeArray);
		clickJS(filterOnToggle);
		slowDown(1);
		//Then loop through and do your check
		for (int i = 0; i < rows; i++) {
			a = getTextPlural(channelCaseListContactCodeArray,i);//path-details-site-0-company-name
			if ( filteredContactCode==a ){
				assertEquals(a, filteredContactCode);
				assertTrue("This is not right and this line is supposed to fail if this line executes", isDisplayed(updateAntennaWindowAntennaModel,80));
			}else {
				assertTrue("this works", isDisplayed(filterOnToggle,40));
			}
		}
	}

	
	/**
	 * This method verifies all channel case list elements are displayed
	 */
	public void verifyChannelCaseListElements() {
		assertTrue("channel case list main header is missing", isDisplayed(channelCaseListHeader,80));
		assertTrue("channel case list subject path header is missing", isDisplayed(channelCaseListSubjectPathHeader,8));
		assertTrue("channel case list result", isDisplayed(channelCaseListResult,8));
		assertTrue("channel case list contact code is missing", isDisplayed(channelCaseListContactCode,8));
		assertTrue("channel case list select all checkbox is missing", isDisplayed(channelCaseSelectAllCheckbox,8));
		assertTrue("channel case list result checkbox is missing", isDisplayed(channelCaseCheckbox,8));
	}
	
	/**
	 * This method verifies additional results are displayed in channel case list after filter on toggle is clicked 
	 */
	public void verifyShowAllCasesToggle() {
		slowDown(5);
		click(filterOnToggle);
		slowDown(1);
		click(showAllCasesOnToggle);
		//double search
		if(!isDisplayed(channelCaseListAdditionalFilteredResult,80))
			clickJS(showAllCasesOnToggle);
		assertTrue("channel case list additional filtered results is missing", isDisplayed(channelCaseListAdditionalFilteredResult,120));
		clickJS(showAllCasesOffToggle);
		assertTrue("channel case list additional filtered results is displayed", !isDisplayed(channelCaseListAdditionalFilteredResult,120));
		assertTrue("channel case list result", isDisplayed(channelCaseListResult,8));
	}
	
	/**
	 * This method verifies elements do no exist for users that do not have edit permissions on AFS Path Case Summary page filter window
	 */
	public void verifyElementsUsersWithoutPermission() {
		assertTrue("filter window clear all button is displayed", !isDisplayed(filterPageClearAllButton,8));
		assertTrue("filter window apply button is displayed", !isDisplayed(filterPageApplyButton,8));
		assertTrue("filter window default button is displayed", !isDisplayed(filterPageDefaultButton,8));
		assertTrue("filter window path lookup button is displayed", !isDisplayed(filterPagePathLookupTrigger,8));	
	}
	
	/**
	 * This method verifies that AFS filter buck radius is less than the default
	 */
	public void verifyFilterBuckRadiusLessThanEqualDefault(String radius, String defaultRadius) {
		assertTrue("filter page buck radius field is missing", isDisplayed(filterPageBuckRadiusField,8));
		clear(filterPageBuckRadiusField);
		type(radius, filterPageBuckRadiusField);
		slowDown(3);
		if(Double.valueOf(radius) > Double.valueOf(defaultRadius)) {
			assertTrue("Buck radius error message is not displayed", isDisplayed(filterPageBuckRadiusErrorMessage,8));
		}
	}
	
	public void updateAntennaCaseDetailsDrawer(String antennaCode, String antennaModel) {
		slowDown(3);
		clickJS(channelCaseListContactCode, 1);
		slowDown(3);
		clear(updateAntennaWindowAntennaCode);
		type(antennaCode, updateAntennaWindowAntennaCode);
		click(channelCaseListHeader);
		slowDown(3);
		assertEquals(getAttributeValue(updateAntennaWindowAntennaModel), antennaModel);
	}
	/**
	 * This method is to click the oh drawer trigger
	 */
	public void clickMWOHDrawer() {
		slowDown(1);
		clickJS (caseStatusOHTrigger);
		assertTrue("OH Drawer is missing", isDisplayed(addOHLossInDrawer,80));

	}
	/**
	 * This method is to verify elements on OH Drawer
	 */
	public void verifyElementsInMWOHDrawer() {
		assertTrue("OH Drawer is missing", isDisplayed(addOHLossInDrawer,80));
		assertTrue("Case report button is missing", isDisplayed(caseReportButtonOHDrawer,80));
		assertTrue("OH report button is missing", isDisplayed(oHReportButtonOHDrawer,80));
		assertTrue("KML/KMZ report button is missing", isDisplayed(kmlKMZReportButtonOHDrawer,80));
		assertTrue("bandLabelOHDrawer is missing", isDisplayed(bandLabelOHDrawer,80));
		assertTrue("climateLabelOHDrawer is missing", isDisplayed(climateLabelOHDrawer,80));
		assertTrue("label20percentOHLoss is missing", isDisplayed(label20percentOHLoss,80));
		assertTrue("labeldot01percentOHLoss is missing", isDisplayed(labeldot01percentOHLoss,80));
		assertTrue("longtermMarginLabel is missing", isDisplayed(longtermMarginLabel,80));
		assertTrue("shortTermMargin is missing", isDisplayed(shortTermMargin,80));

	}
	/**
	 * This method is to add data points in oh drawer
	 * @param distance
	 * @param elevation
	 * @param clutter
	 */
	
	public void addRowMWOHDrawer(String distance,String elevation, String clutter) {
		assertTrue("Add OH Drawer is missing", isDisplayed(addOHLossInDrawer ,80));
		click(addOHLossInDrawer);
		assertTrue("Apply button OH Drawer is missing", isDisplayed(applyButtonOHDrawer,80));
		assertTrue("Cancel button OH Drawer is missing", isDisplayed(cancelButtonOHDrawer,80));
		type(distance,distanceFieldOHDrawer);
		type(elevation,elevationFieldOHDrawer);
		type(clutter,clutterHeightField);
		click(applyButtonOHDrawer);
		slowDown(1);
	}
	/**
	 * This method is for updating a row in OH Drawer
	 * @param elevation
	 */
	public void updateRowMWOHDrawer(String elevation) {
		assertTrue("elevation1 is missing",isDisplayed(elevationRow1,19));
		click(elevationRow1);
		clear(elevationRow1);
		type(elevation,elevationRow1);
		click(applyUpdateOHProfileData);
		assertTrue("Saving updates....", isDisplayed(elevationRow1,480));
		assertEquals(getFieldText(elevationRow1),elevation);
	}
	/**
	 * this method is to delete datapoint from oh drawer
	 */
	public void deleteDataPointOHDrawer() {
		assertTrue("delete icon for datapoint 1 is missing", isDisplayed(deleteRedXDatapoint1,20));
		String distance=getText(datapoint1DistanceValue);
		click(deleteRedXDatapoint1);
		assertTrue("confirmation dialog is missing",isDisplayed(deleteRowConfirmButtonOHDrawerConfirmationPopup,50));
		slowDown(1);
		if(getText(datapoint1DistanceValue)==distance)
		{
			//fail the test
			assertEquals(getText(datapoint1DistanceValue),distance);
		}

	}
	/**
	 * This method is to verify worst case report button is present or not
	 */
	public void verifyWorstCaseReportOption() {
		assertTrue("worst case report button is missing", isDisplayed(worstCaseReportButton,20));	
		click(worstCaseReportButton);
		assertTrue("worst Report docx option is missing", isDisplayed(worstCaseDocx,40));
		assertTrue("worst Report pdf option is missing", isDisplayed(worstCasePdf,40));
		assertTrue("worstCase submit button is missing", isDisplayed(worstcaseSubmitButton,40));
		assertTrue("WorstCase report name field is missing", isDisplayed(worstCaseReportNameField,40));
	}
}
