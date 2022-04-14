package CommPageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.DriverFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import CommPageObjects.BasePage.*;
public class PathSummaryPage extends BasePage {

	//Path Headings
	By projectTitleName = By.id("project-summary-project-name");
	By projectTitle = By.className("project-summary-overview");
	By totalPathAmount = By.id("project-summary-project-total-paths");
	By deleteConfirmationTitle = By.id("delete-paths-modal-success-heading");
	By deleteConfirmationSubText = By.id("delete-paths-modal-success-message");

	By deletePathPopupTitle = By.xpath(".//*[@id='delete-paths-modal-details']/h3");
	By siteHeader =  By.id("project-summary-path-summary-header-siteName-heading");

	//Path Buttons
	By searchButton = By.id("project-summary-filter-apply");
	By selectAllcheckbox = By.id("project-management-highlight-all");
	By deselectAllcheckbox =By.id("project-management-highlight-all");
	By selectAllLabel =By.id("project-summary-select-all-paths-label");
	By SortPathNum = By.id("project-summary-path-summary-header-pathInfo-path-index");
	By SortBand = By.id("project-summary-path-summary-header-siteName-path-band");
	By SortPath = By.id("project-summary-path-summary-header-pathInfo-path-name");
	By actionArrow = By.xpath("//*[contains(@id,'-pathInfo-path-menu-trigger')]");
	By deleteButton = By.id("delete-paths-modal-delete-apply");
	By deselectPathForDeletion = By.xpath("//*[contains(@id,'project-summary-modal-remove-path-')]");
	By hamburgerSettings = By.id("project-summary-settings-trigger");
	By uSUnit = By.id("project-summary-settings-unit-US-label-bottom");
	By sIUnit = By.id("project-summary-settings-unit-SI-label-bottom");
	By showSiteLocationCheckBox = By.id("project-summary-settings-summary-display-show");
	//TODO the current Id is making tests flaky
	By closeSettings = By.id("project-summary-menu-closed");
	By saveButton = By.id("project-summary-settings-submit");
	By pathsNoFreqCheckBox = By.id("project-summary-filter-checkbox");
	//TODO need locator that will see the text of Show all check box under the filter box
	By pathsNoFreqCheckBoxText = By.id("project-summary-filter-checkbox-label");
	By deselectSplitPath = By.xpath("//*[contains(@id,'project-summary-modal-remove-path-')]");
	By splitProjectButton = By.id("project-summary-modal-split-project-apply");
	By pathDetailButton = By.id("project-summary-quick-add-path-details");
	By intraPathDetailButton = By.xpath("//*[contains(@id, 'project-summary-path-summary-data-pathId-') and contains(@id, 'siteName-site-1')]");

	//Drop down options
	By deleteOptionForPath1 = By.id("path-menu-delete-0");
	By deleteOption = By.xpath(""+PROJECT_SUMMARY_PATHID +" '-pathInfo-path-menu-delete')]");
	//TODO refactor
	By copyOption = By.xpath("//*[contains(@id,'-pathInfo-path-menu-copy')]");
	By deletePopup = By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open");
	By hamburgerDeletePaths = By.id("project-settings-delete-paths-modal-trigger");
	By hamburgerSplitPathsDisabled = By.xpath("//*[@id='project-settings-delete-paths-modal-trigger' and @class='disable-button']");
	By hamburgerSplitPathsEnabled = By.xpath("//*[@id='project-settings-split-project-modal-trigger']");

	//Path Entry Fields - Able to use the type method
	By targetAvailability = By.id("project-summary-settings-target-availability");
	By filterSelectionInput = By.id("project-summary-filter-input");
	By defaultLicenseeField = By.id("project-summary-settings-default-contact");
	By fresnelZoneRadiusPercentField = By.id("project-summary-settings-freznel-zone-radius");
	By kFactorField = By.id("project-summary-settings-k-factor");
	By minClearence = By.id("project-summary-settings-minimum-clearance");
	By fieldChange = By.xpath("//*[contains(@placeholder, 'Minimum Clearance (m)')]");
	By splitProjectModalNewProjectNameField = By.id("split-project-project-name");//split-project-project-name


	//Path hovers -- Able to use the hover method
	By passiveRepeaterIcon = By.xpath("//*[contains(@id, '-pathInfo-tooltip-trigger')]");

	By defaultCompanyName = By.id("project-summary-project-default-company");
	By passiveRepeaterHoverSiteNameField = By.xpath("//*[text() = 'Site Name' and @class = 'uppercase']");
	By passiveRepeaterHoverLatitudeField = By.xpath("//*[text() = 'Latitude' and @class = 'uppercase']");
	By passiveRepeaterHoverLongitudeField = By.xpath("//*[text() = 'Longitude' and @class = 'uppercase']");
	By passiveRepeaterHoverAntennaField = By.xpath("//*[text() = 'Antennas' and @class = 'uppercase']");
	By bandValue = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-pathInfo-path-band')]");

	By allPathsNew = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-pathInfo-path-name')]");
	//project-summary-path-summary-data-pathId-20531779-pathInfo-path-index
	By allPaths = By.xpath("//*[contains(@id, 'project-summary-path-summary-data-pathId-') and contains(@id, '-pathInfo-path-index')]");
	//By allPaths = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-pathInfo-path-index')]");

	By pathsSelectedByArray = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-pathInfo')]");
	By deleteCandidate = By.tagName("td");//Need more specific locator
	By paths = By.className("pull-left");
	By groundElevation = By.xpath("//*[contains(@title, 'Ground Elevation')]");
	By errorFresnelZoneRadius = By.id("project-summary-settings-freznel-zone-radius-error-message");
	By errorkFactor = By.id("project-summary-settings-k-factor-error-message");
	By errorTargetAvailability = By.id("project-summary-settings-target-availability-error-message");
	By errorMinClearance = By.id("project-summary-settings-minimum-clearance-error-message");
	By rcnFieldImportPage = By.id("path-database-import-rcn-number");
	By radioFieldImportPage = By.id("path-database-import-radio-code");
	//By totalPathsCount = By.xpath("//*[@id=\"project-summary-project-total-paths\"]");
	By minimumClearance = By.id("project-summary-settings-minimum-clearance-label");
	By remainingDeletePaths = By.xpath("//*[contains(@id, 'project-summary-modal-path-')]");
	By remainingSlipPaths =By.xpath("//*[contains(@id, 'project-summary-modal-path-')]");
	By splitProjectModalTitle = By.xpath("//*[text() = 'Split Project' and @class = 'uppercase']");
	By splitProjectModalSubTitle = By.xpath("//*[text() = 'Move selected Paths to a New Project.' and @class = 'padding-top-1']");
	By pathDetailSiteNameField1 =By.id("path-details-site-0-siteName");
	By blankPage=By.cssSelector("div.ReactModal__Overlay.ReactModal__Overlay--after-open.modal-overlay-default");

	By pathNameArrayProjectSummaryResults =  By.xpath(""+PROJECT_SUMMARY_PATHID+" '-pathInfo-path-name')]");   //Path DropDown Fields -- Does it contain a list that has options that can be selected

	By filterSelection = By.id("project-summary-filter-select");
	By hamburgerDropDownInactive = By.id("project-summary-menu-closed");
	By hamburgerDropDownActive = By.xpath("//*[@id='project-summary-menu-toggle' and @class='pointer pull-right active']");
	//Index List -- Can you used an array to select item
	By pathNameIndexValues = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-pathInfo-path-name')]");
	By pathNumberIndexValues = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-pathInfo-path-index')]");
	By pathSiteIndex = By.id("path-2-site-1-siteName");
	By site1 = By.id("quick-add-site[0]-siteName");
	By site2 = By.id("quick-add-site[1]-siteName");
	By siteName1 = By.xpath(""+PATH_VAL+" '-site-1-siteName')]");
	By siteName2 = By.xpath(""+PATH_VAL+" '-site-2-siteName')]");
	By importPathFromHamburger=By.id("project-import-paths-modal-trigger");
	By importFromPathDatabase = By.id("project-import-modal--menu-option-database-import");
	By importPathSearchResults = By.xpath("//*[contains(@id, 'path-database-import-modal-table-data-pathId-') and contains(@id, '-pathInfo-path-name')]");
	By clearPathImportPage = By.id("path-database-import-clear");
	By pathSiteIndex1 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-siteName-site-1')]");

	By pathSiteIndex2 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-siteName-site-2')]");
	By pathBandValueIndex1 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-pathInfo-path-band')]");
	By pathBandValueIndex2 =By.xpath(""+PROJECT_SUMMARY_PATHID+" '-bandwidth-site-2')]");
	By pathCallsignValueIndex1 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-callSign-site-1')]");
	By pathCallsignValueIndex2 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-callSign-site-2')]");

	By pathLatitudeValueIndex1 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-latitude-site-1')]");
	By pathLatitudeValueIndex2 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-latitude-site-2')]");
	By pathLongitudeValueIndex1 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-longitude-site-1')]");
	By pathLongitudeValueIndex2 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-longitude-site-2')]");
	By pathGroundElevationValueIndex1 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-groundElevation-site-1')]");
	By pathGroundElevationValueIndex2 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-groundElevation-site-2')]");
	By pathAntennaValueIndex1 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-antennas-site-1-primary')]");
	By pathAntennaValueIndex2 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-antennas-site-2-primary')]");
	By pathAdditionalToolTipIndex1 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-antennas-site-1-tooltip-tooltip-trigger')]");
	By pathAdditionalToolTipIndex2 =  By.xpath(""+PROJECT_SUMMARY_PATHID+" '-antennas-site-2-tooltip-tooltip-trigger')]");
	By pathACMIndex1 = By.xpath("//*[contains(@id, 'acm-tooltip-trigger-path-') and contains(@id, '-site-1')]");
	By pathACMIndex2 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-radio-site-2-tooltip-trigger')]");
	By pathRadioIndex1 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-radio-site-1radio-code')]");
	By pathRadioIndex2 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-radio-site-2radio-code')]");
	By pathBandwidthIndex1 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-bandwidth-site-1')]");
	By pathBandwidthIndex2 = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-bandwidth-site-2')]");
	By pathFreqIndex1 = By.xpath("//*[contains(@id, 'path-') and contains(@id, '-site-1-frequencies')]");
	By pathFreqIndex2 = By.xpath(""+PROJECT_SUMMARY_PATHID+" 'numberOfFrequencies-site-2')]");
	By listNumPaths = By.xpath("//*[contains(@class, 'pull-left')]");
	By listNumBands = By.xpath("//*[contains(@class, 'path-band-value pull-right')]");
	By listNamePaths = By.xpath(""+PROJECT_SUMMARY_PATHID+" '-pathInfo-path-name')]");


	// By listNamePaths = By.xpath("//*[contains(@id, '-pathInfo-path-name')]");
	By allPathsNotSelected = By.xpath("//*[contains(@class, 'pointer.highlighted-row.path-summary-row')]");
	By pathsToBeDeletedFromModal = By.xpath("//*[contains(@class,'delete-paths-modal-path')]");

	//Modal -- Does it pop up over current window
	By deleteConfirmationNew = By.id("delete-paths-modal-success-heading");
	By projectSettingsPanel = By.id("project-summary-settings");
	By projectSettingsPanelNotClosed =By.cssSelector(".project-summary-settings.bg-grey-gadient");
	By splitProjectConfirmationModal = By.cssSelector(".ReactModal__Content.ReactModal__Content--after-open");
	By splitProjectConfirmationModalSubText = By.id("split-project-confirmation-heading");
	By stayInCurrentProjectButton =By.id("split-project-confirmation-stay-on-current");
	By goToNewProjectButton = By.id("split-project-confirmation-go-to-new");
	By option =By.cssSelector(".react-autosuggest__suggestions-list");

	By elevationQuickAddSite2=By.id("quick-add-site[1]elevation");
	By callSignCheckBox= By.id("project-summary-checks-call-sign");
	By asrCheckBox= By.id("project-summary-checks-asr");
	By warningsCheckBox = By.id("project-summary-checks-warnings");
	By checkDistanceFieldInCallSignCheckPage =By.id("project-check-call-sign-search-radius");
	By checkDistanceFieldInASRCheckPage =By.id("project-check-asr-search-radius");
	By searchButtonCallSignPage=By.id("project-check-call-sign-search-submit");
	By searchButtonAsrPage=By.id("project-check-asr-search-submit");
	By callSignResultsFromCallSignCheck = By.xpath("//*[contains(@id, 'project-check-call-sign-results-') and contains(@id, '-call-sign-results-')and contains(@id, '-call-sign')]");
	By asrResultsFromAsrCheck = By.xpath("//*[contains(@id, 'project-check-asr-results-') and contains(@id, '-asr-results-')and contains(@id, '-asr')]");
	By structureHeightHeaderAsrCheck = By.id("project-check-asr-results--structure-height");
	By centerlineHeaderAsrCheck = By.id("project-check-asr-results--centerline");
	By towerOwnerResultsFromAsrCheck = By.xpath("//*[contains(@id, 'project-check-asr-results-') and contains(@id, '-asr-results-')and contains(@id, '-tower-owner')]");
	By structureHeightResultsFromAsrCheck = By.xpath("//*[contains(@id, 'project-check-asr-results-') and contains(@id, '-asr-results-')and contains(@id, '-overall-height')]");
	By towerOwnerSelectedFromAsrCheck = By.xpath("//*[contains(@id, 'project-check-asr-results-') and contains(@id, '-segment-end-')and contains(@id, '-tower-owner')]");
	By structureHeightSelectedFromAsrCheck = By.xpath("//*[contains(@id, 'project-check-asr-results-') and contains(@id, '-segment-end-')and contains(@id, '-overall-height')]");
	By submitButtonAsrCheckPage = By.id("project-check-asr-submit");
	By asrDataButtonAsrCheckPage = By.xpath("//*[contains(@id, 'project-check-asr-results-') and contains(@id, '-asr-results-')and contains(@id, 'DATA-label-bottom')]");
	By asrOnlyButtonAsrCheckPage = By.xpath("//*[contains(@id, 'project-check-asr-results-') and contains(@id, '-asr-results-')and contains(@id, 'ONLY-label-bottom')]");
	By callSignCheckPageExit = By.id("project-check-call-sign-exit");
	By asrCheckPageExit = By.id("project-check-asr-exit");
	By bandPathDetail= By.id("path-details-band");
	By importFromProject = By.id("project-import-modal--menu-option-project-import");
	By usernamePathImport = By.id("project-path-import-create-user");
	By pathImportSearch =By.id("path-database-import-submit");
	By usernameAutoSuggest1=By.id("react-select-project-path-import-create-user-option-0");
	By pathImportResult = By.xpath("//*[contains(@id, 'path-database-import-modal-table-data-pathId-') and contains(@id, '-siteName-site-1')]");
	By importButtonProjectPathImportPage=By.id("project-path-import-import");
	By siteName = By.xpath("//*[contains(@id, 'path-database-import-modal-table-data-pathId-') and contains(@id, '-siteName-site-1')]");
	By siteNameSummary = By.xpath("//*[contains(@id, 'project-summary-path-summary-data-pathId-') and contains(@id, '-siteName-site-1')]");
	By pathSummaryHeaderLink = By.id("project-summary-navigation-link-summary");
	By projectStatusOnSummaryPage = By.id("project-summary-project-status");
	By PathDetailsPageReturn = By.id("path-details-discard-button");
	By deletePathDetails = By.id("path-details-footer-delete-button");
	By warningModalHeading = By.id("warnings-report-export-heading");
	By warningModalSubmitButton = By.id("warnings-report-export-submit");
	
	public PathSummaryPage(WebDriver driver) {
		super(driver);
		visit("");
	}

	/**
	 * This method clicks the path summary link in the header
	 */
	public void clickSummaryLink() {
		assertTrue("Path Summary header link is not present", isDisplayed(pathSummaryHeaderLink,10));
		clickJS(pathSummaryHeaderLink);
	}


	public void openSettings()
	{
		assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
		click(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
		click(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
		assertTrue("Project K Factor field is not present", isDisplayed(kFactorField, 10));
	}
	public void checkSiteSuggestionQuickAdd(String site1val, String site2val){
		assertTrue("Sitename 1 field is not displayed",isDisplayed(site1,20));
		assertTrue("Sitename 2 field is not displayed",isDisplayed(site2,20));
		type(site1val,site1);
		assertFalse(isDisplayed(option,8));
		type(site2val,site2);
		assertFalse(isDisplayed(option,8));
	}

	public void openPathDetailForAddingPath(){
		slowDown(1);
		assertTrue("path Detail Button is not displayed",isDisplayed(pathDetailButton,140));
		click(pathDetailButton);
		assertTrue("path Detail SiteName Field 1 is not displayed",isDisplayed(pathDetailSiteNameField1,8));

	}

	public void openPathDetails(int i) {
		isDisplayed(intraPathDetailButton,20);
		click(intraPathDetailButton,i);
		slowDown(1);
		isDisplayed(pathDetailSiteNameField1,20);
	}

	public void openSettingMenuValDisabledSplitOption(){
		slowDown(1);
		click(hamburgerDropDownInactive);
		isDisplayed(hamburgerSplitPathsDisabled,20);
		click(closeSettings);
	}

	public void selectCopyFromPath() {
		assertTrue("Action arrow is missing", isDisplayed(actionArrow,80));
		click(actionArrow);
		isDisplayed(deleteOptionForPath1,10);
		isDisplayed(copyOption,3);
		assertTrue("copyOption is missing", isDisplayed(copyOption,80));
		click(copyOption);
	}
	//TODO antenna section is not complete at the moment will revisit once implemented
	public void pathWithSameConfig_OneRadio(){
		String ant1;
		String ant2;
		String oneRadio;
		String displayedRadio;
		assertTrue("path Ant1 Value is not present",isDisplayed(pathAntennaValueIndex1,8));
		ant1 = getTextPlural(pathAntennaValueIndex1,2);
		ant2 = getTextPlural(pathAntennaValueIndex2,2);
		assertEquals(ant2, ant1);
		oneRadio =  getTextPlural(pathRadioIndex1,1);
		assertEquals(oneRadio,"");
		displayedRadio = getTextPlural(pathRadioIndex2,1);
		assertEquals(displayedRadio,"3fsd");
	}

	public boolean showAllPathsWithNoAssignedFrequencyBandsPresent(){
		assertTrue("pathsNoFreqCheckBox is not present",isDisplayed(pathsNoFreqCheckBox,90));
		return isDisplayed(pathsNoFreqCheckBox);
	}

	public boolean showAllPathsWithNoAssignedRadio(){
		return isDisplayed(pathsNoFreqCheckBox);
	}

	public String showAllCheckBoxText() {
		return getText(pathsNoFreqCheckBoxText);
	}
	/**
	 * @param rowIndex -row index
	 * @param Name - name corresponding to the row index
	 * @param Num - row number
	 * @param Band - band corresponding to row index
	 * 
	 */
	public void viewPathBlueSection(int rowIndex, String Name, String Num,String Band){
		String rowOneName;
		String rowOneNum;
		String rowOneBand;

		assertTrue("path Name Value is not present",isDisplayed(pathNameIndexValues,8));
		assertTrue("path Number Value is not present",isDisplayed(pathNumberIndexValues,8));
		assertTrue("path band Value is not present",isDisplayed(bandValue,8));

		click(actionArrow);
		isDisplayed(deleteOptionForPath1,10);
		isDisplayed(copyOption,3);

		rowOneName = getTextPlural(pathNameIndexValues,rowIndex);
		rowOneNum = getTextPlural(pathNumberIndexValues,rowIndex);
		rowOneBand = getTextPlural(bandValue,rowIndex);

		assertEquals(rowOneName, Name);
		assertEquals(rowOneNum, Num);
		assertEquals(rowOneBand, Band);

	}

	public void splitProject(String projectName){
		assertTrue("There are no paths present Pleases adjust your preconditions to include the setting up of PATH test data",isDisplayed(allPathsNew,10));
		click(allPathsNew,3);
		click(allPathsNew,4);
		click(allPathsNew,5);
		assertTrue("The path is not selected", isDisplayedArray(pathsSelectedByArray,0));
		slowDown(1);
		clickJS(hamburgerSplitPathsEnabled);
		if(firefox.equals("firefox")){
			assertTrue(isDisplayedArray(deselectSplitPath,0));
			assertTrue(isDisplayedArray(deselectSplitPath,1));
			assertTrue(isDisplayedArray(deselectSplitPath,2));
		}else{
			assertTrue(isDisplayed(splitProjectModalTitle,30));
			assertTrue(isDisplayed(splitProjectModalSubTitle,30));
			assertTrue(isDisplayed(splitProjectModalNewProjectNameField,30));
			assertTrue(isDisplayedArray(remainingSlipPaths,0));
			assertTrue(isDisplayedArray(remainingSlipPaths,1));
			assertTrue(isDisplayedArray(remainingSlipPaths,2));
			assertTrue(isDisplayedArray(deselectSplitPath,0));
			assertTrue(isDisplayedArray(deselectSplitPath,1));
			assertTrue(isDisplayedArray(deselectSplitPath,2));
			assertTrue(isDisplayed(splitProjectButton,10));
		}
		type(projectName, splitProjectModalNewProjectNameField);
		click(splitProjectButton);
		assertTrue(isDisplayed(splitProjectConfirmationModal,160));//class="ReactModal__Content ReactModal__Content--after-open"
		assertTrue(isDisplayed(splitProjectConfirmationModalSubText,60));//class="padding-1"
		assertTrue(isDisplayed(stayInCurrentProjectButton,60));//class="display-flex justify-content-between"
		assertTrue(isDisplayed(goToNewProjectButton,60));//class="btn bg-green hover-inverse btn-md"
		click(goToNewProjectButton);
		String nameOfProject;
		isDisplayed(projectTitleName,20);
		nameOfProject = getText(projectTitleName);
		assertEquals("project name is not correct", nameOfProject, projectName);
	}
	public void splitProjectStay(String projectName){
		assertTrue("There are no paths present Pleases adjust your preconditions to include the setting up of PATH test data",isDisplayed(allPathsNew,10));
		click(allPathsNew,3);
		click(allPathsNew,4);
		click(allPathsNew,5);
		assertTrue("The path is not selected", isDisplayedArray(pathsSelectedByArray,0));
		clickJS(hamburgerDropDownInactive);
		if(!isDisplayed(hamburgerSettings)) {
			clickJS(hamburgerDropDownInactive);
		}
		clickJS(hamburgerSplitPathsEnabled);
		assertTrue(isDisplayed(splitProjectModalTitle,30));
		assertTrue(isDisplayed(splitProjectModalSubTitle,30));
		assertTrue(isDisplayed(splitProjectModalNewProjectNameField,30));
		assertTrue(isDisplayedArray(remainingSlipPaths,0));
		assertTrue(isDisplayedArray(remainingSlipPaths,1));
		assertTrue(isDisplayedArray(remainingSlipPaths,2));
		assertTrue(isDisplayedArray(deselectSplitPath,0));
		assertTrue(isDisplayedArray(deselectSplitPath,1));
		assertTrue(isDisplayedArray(deselectSplitPath,2));
		assertTrue(isDisplayed(splitProjectButton,10));
		type(projectName, splitProjectModalNewProjectNameField);
		click(splitProjectButton);
		assertTrue("Split confirmation model is missing",isDisplayed(splitProjectConfirmationModal,200));//class="ReactModal__Content ReactModal__Content--after-open"
		assertTrue(isDisplayed(splitProjectConfirmationModalSubText,30));//class="padding-1"
		assertTrue(isDisplayed(stayInCurrentProjectButton,30));//class="display-flex justify-content-between"
		assertTrue(isDisplayed(goToNewProjectButton,30));//class="btn bg-green hover-inverse btn-md"
		click(stayInCurrentProjectButton);
		String nameOfProject;
		isDisplayed(projectTitleName,20);
	}

	public void splitProjectStayAlt(String projectName){
		assertTrue("There are no paths present Pleases adjust your preconditions to include the setting up of PATH test data",isDisplayed(allPathsNew,10));
		click(allPathsNew,0);
		assertTrue("The path is not selected", isDisplayedArray(pathsSelectedByArray,0));
		clickJS(hamburgerDropDownInactive);
		if(!isDisplayed(hamburgerSettings)) {
			clickJS(hamburgerDropDownInactive);
		}
		clickJS(hamburgerSplitPathsEnabled);
		assertTrue(isDisplayed(splitProjectModalTitle,30));
		assertTrue(isDisplayed(splitProjectModalNewProjectNameField,30));
		assertTrue(isDisplayedArray(remainingSlipPaths,0));
		assertTrue(isDisplayedArray(deselectSplitPath,0));
		assertTrue(isDisplayed(splitProjectButton,10));

		type(projectName, splitProjectModalNewProjectNameField);
		click(splitProjectButton);
		assertTrue("splitProjectConfirmationModal is missing",isDisplayed(splitProjectConfirmationModal,230));//class="ReactModal__Content ReactModal__Content--after-open"
		assertTrue(isDisplayed(splitProjectConfirmationModalSubText,30));//class="padding-1"
		assertTrue(isDisplayed(stayInCurrentProjectButton,30));//class="display-flex justify-content-between"
		assertTrue(isDisplayed(goToNewProjectButton,30));//class="btn bg-green hover-inverse btn-md"
		click(stayInCurrentProjectButton);
		String nameOfProject;
		isDisplayed(projectTitleName,20);
	}


	public void viewSiteCallSignLatLongGeColumns1(int rowIndex, String siteIndex,  String lat, String longi, String elev){
		String rowOneSite;
		String rowOneCallsign;
		String rowOneLatitude;
		String rowOneLongitude;
		String rowOneGroundElevation;
		assertTrue("path Lat Value is not present",isDisplayed(pathLatitudeValueIndex2,98));
		assertTrue("path Long Value is not present",isDisplayed(pathLongitudeValueIndex2,8));
		assertTrue("path GE Value is not present",isDisplayed(pathGroundElevationValueIndex2,8));
		rowOneSite = getTextPlural(pathSiteIndex1,rowIndex);
		rowOneCallsign = getTextPlural(pathCallsignValueIndex1,rowIndex);
		rowOneLatitude = getTextPlural(pathLatitudeValueIndex1,rowIndex);
		rowOneLongitude = getTextPlural(pathLongitudeValueIndex1,rowIndex);
		rowOneGroundElevation = getTextPlural(pathGroundElevationValueIndex1,rowIndex);
		assertEquals(rowOneLatitude, lat);
		assertEquals(rowOneLongitude, longi);
		assertEquals(rowOneGroundElevation, elev);
	}

	public void viewSiteCallSignLatLongGeColumns2(int rowIndex, String siteIndex,  String lat, String longi, String elev){
		String rowOneSite;
		String rowOneCallsign;
		String rowOneLatitude;
		String rowOneLongitude;
		String rowOneGroundElevation;
		assertTrue("path Site Value is not present",isDisplayed(pathSiteIndex2,108));
		assertTrue("path Lat Value is not present",isDisplayed(pathLatitudeValueIndex2,108));
		assertTrue("path Long Value is not present",isDisplayed(pathLongitudeValueIndex2,108));
		assertTrue("path GE Value is not present",isDisplayed(pathGroundElevationValueIndex2,8));
		rowOneSite = getTextPlural(pathSiteIndex2,rowIndex);
		rowOneCallsign = getTextPlural(pathCallsignValueIndex2,rowIndex);
		rowOneLatitude = getTextPlural(pathLatitudeValueIndex2,rowIndex);
		rowOneLongitude = getTextPlural(pathLongitudeValueIndex2,rowIndex);
		rowOneGroundElevation = getTextPlural(pathGroundElevationValueIndex2,rowIndex);
		assertEquals(rowOneLatitude, lat);
		assertEquals(rowOneLongitude, longi);
	}

	public void viewAntennaRadioBandwidthFreq(){
		String rowOneAntenna;
		String rowOneRadio;
		String rowOneBandwidth;
		String rowOneFreq;
		assertTrue("path Band is not present",isDisplayed(pathBandValueIndex1,8));
		assertTrue("path Freq is not present",isDisplayed(pathFreqIndex1,8));
		rowOneBandwidth = getTextPlural(pathBandValueIndex1,0);
		rowOneFreq = getTextPlural(pathFreqIndex1,0);
		assertEquals(rowOneBandwidth, "");
		assertEquals(rowOneFreq, "0");
	}

	public void viewDiversityAntAmcPassFail(){
		String rowOneDiversityAntenna;
		String rowOneAcm;
		assertTrue("path Diversity Tool is not present",isDisplayed(pathAdditionalToolTipIndex2,8));
		assertTrue("path ACM is not present",isDisplayed(pathACMIndex1,8));
		rowOneDiversityAntenna = getTextPlural(pathAdditionalToolTipIndex2,0);
		rowOneAcm = getTextPlural(pathACMIndex1,0);
		assertEquals(rowOneDiversityAntenna, "D");
		assertEquals(rowOneAcm, "ACM");
	}
	/*
	 * This method validates the field values and error messages of
	 * the target availability field
	 */
	public void validateDefaultAvailabilityTargetSetting() {
		String targetAvailablityWarning;
		String targetVal;
		String defaultTargetAvailability;
		clickJS(hamburgerDropDownInactive);
		if(!isDisplayed(hamburgerSettings)) {
			clickJS(hamburgerDropDownInactive);
		}
		click(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
		assertTrue("Project Target Availability (%) is not present", isDisplayed(targetAvailability, 10));
		defaultTargetAvailability = getFieldText(targetAvailability);
		//COM-400 COM-387 - Bug Fix
		assertEquals("The Target Avail default val is not correct", defaultTargetAvailability, "99.999");
		clear(targetAvailability);
		type("w", targetAvailability);
		assertTrue("saveButton not present", isDisplayed(saveButton, 10));
		click(saveButton);
		assertTrue("Target availability vaildation message is not present",isDisplayed(errorTargetAvailability,30));
		targetAvailablityWarning = getText(errorTargetAvailability);
		assertEquals(targetAvailablityWarning, "MUST BE NUMERICAL VALUE.");
		clear(targetAvailability);
		type("1001", targetAvailability);
		click(saveButton);
		targetAvailablityWarning = getText(errorTargetAvailability);
		assertEquals(targetAvailablityWarning, "MUST BE BETWEEN 50 AND 100");
		clear(targetAvailability);
		type("-1001", targetAvailability);
		click(saveButton);
		targetAvailablityWarning = getText(errorTargetAvailability);
		assertEquals(targetAvailablityWarning, "MUST BE BETWEEN 50 AND 100");
		//COM-400 COM-388
		clear(targetAvailability);
		type("99.123456", targetAvailability);
		click(saveButton);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerDropDownInactive, 230));
		click(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 230));
		click(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
		assertTrue("Project Target Availability (%) is not present", isDisplayed(targetAvailability, 10));
		targetVal = getFieldText(targetAvailability);
		assertEquals(targetVal, "99.123456");
		clear(targetAvailability);
		type("100", targetAvailability);
		click(saveButton);
		assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 230));
		click(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 30));
		click(hamburgerSettings);
		defaultTargetAvailability = getFieldText(targetAvailability);
		assertEquals("The Target Avail default val is not correct", "100",defaultTargetAvailability);
	}

	public void valKMinClearanceSetting() {
		String minClearanceWarning;
		String defaultMinimumClearance;
		assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
		click(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
		click(hamburgerSettings);
		isDisplayed(minClearence,10);
		defaultMinimumClearance = getFieldText(minClearence);
		assertEquals("The defaultMinimumClearance default val is not correct", defaultMinimumClearance, "0");
		clear(minClearence);
		type("w", minClearence);
		assertTrue("saveButton is not present", isDisplayed(saveButton, 100));
		click(saveButton);
		minClearanceWarning = getText(errorMinClearance);
		assertEquals(minClearanceWarning, "MUST BE NUMERICAL VALUE.");
		clear(minClearence);
		type("3280.85", minClearence);
		click(saveButton);
		minClearanceWarning = getText(errorMinClearance);
		assertEquals(minClearanceWarning, "MUST BE BETWEEN -3,280.84 AND 3,280.84 FEET");
		clear(minClearence);
		type("-3280.85", minClearence);
		click(saveButton);
		minClearanceWarning = getText(errorMinClearance);
		assertEquals(minClearanceWarning, "MUST BE BETWEEN -3,280.84 AND 3,280.84 FEET");
		clear(minClearence);
		type("-3280.84", minClearence);
		clear(minClearence);
		type("3280.84", minClearence);
		click(saveButton);
	}

	public void valKFactorSetting() {
		String defaultKFactor;
		String kfactorError;
		assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
		click(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
		click(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 100));
		assertTrue("Project K Factor field is not present", isDisplayed(kFactorField, 10));
		defaultKFactor = getFieldText(kFactorField);
		assertEquals("The defaultKFactor default val is not correct", defaultKFactor, "1");
		clear(kFactorField);
		type("wuu ", kFactorField);
		click(minClearence);
		kfactorError = getText(errorkFactor);
		assertEquals(kfactorError, "MUST BE NUMERICAL VALUE.");
		clear(kFactorField);
		type("!", kFactorField);
		click(minClearence);
		kfactorError = getText(errorkFactor);
		assertEquals(kfactorError, "MUST BE NUMERICAL VALUE.");

		clear(kFactorField);
		type("100000", kFactorField);
		click(minClearence);
		kfactorError = getText(errorkFactor);
		assertEquals(kfactorError, "MUST BE BETWEEN 0.01 AND 10,000");
		clear(kFactorField);
		type("0", kFactorField);
		click(minClearence);
		kfactorError = getText(errorkFactor);
		assertEquals(kfactorError, "MUST BE BETWEEN 0.01 AND 10,000");
		clear(kFactorField);
		type("0.0003", kFactorField);
		click(minClearence);
		kfactorError = getText(errorkFactor);
		assertEquals(kfactorError, "MUST BE BETWEEN 0.01 AND 10,000");
		clear(kFactorField);
		type("10000", kFactorField);
		click(saveButton);
	}

	public void valFresnelZoneRadius() {
		String defaultCompany;
		String defaultFresnelZoneRadius;
		String a;
		assertTrue("Hamburger menu is not present", isDisplayed(hamburgerDropDownInactive, 10));
		click(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
		click(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
		assertTrue("Project Fresnel Zone Radius (%) is not present", isDisplayed(fresnelZoneRadiusPercentField, 10));
		assertTrue("Default Company is not present", isDisplayed(defaultLicenseeField, 10));
		defaultCompany = getFieldText(defaultLicenseeField);
		defaultFresnelZoneRadius = getFieldText(fresnelZoneRadiusPercentField);
		assertEquals("The defaultFresnelZoneRadius default val is not correct", defaultFresnelZoneRadius, "60");
		clear(fresnelZoneRadiusPercentField);
		type(".1", fresnelZoneRadiusPercentField);
		click(saveButton);
		a = getText(errorFresnelZoneRadius);
		assertEquals(a, "MUST BE A WHOLE NUMBER");
		clear(fresnelZoneRadiusPercentField);
		type("w", fresnelZoneRadiusPercentField);
		click(saveButton);
		a = getText(errorFresnelZoneRadius);
		assertEquals(a, "MUST BE NUMERICAL VALUE.");
		clear(fresnelZoneRadiusPercentField);
		type("1001", fresnelZoneRadiusPercentField);
		click(saveButton);
		a = getText(errorFresnelZoneRadius);
		assertEquals(a, "MUST BE BETWEEN 0 AND 1,000");
		clear(fresnelZoneRadiusPercentField);
		type("1000", fresnelZoneRadiusPercentField);
		click(saveButton);
	}

	public void changeUnitsFromSiToUs(String editValMinClearence, String valPostSiSwitch) {
		slowDown(1);
		click(hamburgerDropDownInactive);
		if(! isDisplayed(hamburgerDeletePaths,10)) 
			click(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings,60));
		click(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 40));
		assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
		assertTrue("sIUnit",isDisplayed(sIUnit,10));
		clickJS(sIUnit);
		assertTrue(isDisplayed(sIUnit));
		assertTrue(isDisplayed(saveButton,30));
		click(saveButton);
		slowDown(2);
		click(hamburgerDropDownInactive);
		if( !isDisplayed(hamburgerDeletePaths,10))
			clickJS(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
		slowDown(1);
		clickJS(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 20));
		assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
		assertTrue("sIUnit",isDisplayed(uSUnit,10));
		clickJS(uSUnit);
		assertTrue(isDisplayed(saveButton, 10));
	}


	public void changeUnitsFromUsToSi(String editValMinClearence, String valPostSiSwitch) {
		click(hamburgerDropDownInactive);
		if( !isDisplayed(hamburgerDeletePaths,10)) 
			clickJS(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
		clickJS(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 20));
		assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
		assertTrue("sIUnit",isDisplayed(uSUnit,70));
		slowDown(1);
		click(uSUnit);
		assertTrue("Can't find save button",isDisplayed(saveButton,8));
		click(saveButton);
		slowDown(2);
		click(hamburgerDropDownInactive);
		if(! isDisplayed(hamburgerDeletePaths,10))
			clickJS(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
		clickJS(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 20));
		assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
		assertTrue("sIUnit",isDisplayed(sIUnit,10));
		clickJS(sIUnit);
	}

	public void changeToSi(){
		slowDown(1);
		click(hamburgerDropDownInactive);
		if(! isDisplayed(hamburgerDeletePaths,10)) 
			clickJS(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 20));
		clickJS(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 20));
		assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 30));
		assertTrue("sIUnit",isDisplayed(sIUnit,70));
		click(sIUnit);
		click(saveButton);
		slowDown(1);
	}

	public void changeToUs(){
		slowDown(2);
		click(hamburgerDropDownInactive);
		if(! isDisplayed(hamburgerDeletePaths,10)) 
			clickJS(hamburgerDropDownInactive);
		slowDown(2);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
		clickJS(hamburgerSettings);
		assertTrue("Project US Unit is not present", waitForIsDisplayed(saveButton, 130));
		slowDown(1);
		click(uSUnit);
		click(saveButton);
		slowDown(1);
	}





	public void viewDefaultSettings() {

		String defaultLic;
		String defaultFresnelZoneRadius;
		String defaultKFactor;
		String defaultMinimumClearance;
		String defaultTargetAvailability;

		click(hamburgerDropDownInactive);
		if( !isDisplayed(hamburgerDeletePaths,10)) 
			clickJS(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
		click(hamburgerSettings);
		assertTrue("Project Panel is not present", isDisplayed(projectSettingsPanel, 10));
		assertTrue("Project US Unit is not present", isDisplayed(uSUnit, 10));
		assertTrue("Project SI unit is not present", isDisplayed(sIUnit, 10));
		assertTrue("Project Default Licensee is not present", isDisplayed(defaultLicenseeField, 10));
		//The below code is commented out because there is a chance that the kfcator clearance availabilty etc can come back in the future 
		/*
        assertTrue("Project Panel is not present", isDisplayed(showSiteLocationCheckBox, 10));
        assertTrue("Project Fresnel Zone Radius (%) is not present", isDisplayed(fresnelZoneRadiusPercentField, 10));
        assertTrue("Project K Factor field is not present", isDisplayed(kFactorField, 10));
        assertTrue("Project Target Availability (%) is not present", isDisplayed(targetAvailability, 10));
        defaultLic = getFieldText(defaultLicenseeField);
        defaultFresnelZoneRadius = getFieldText(fresnelZoneRadiusPercentField);
        defaultKFactor = getFieldText(kFactorField);
        defaultMinimumClearance = getFieldText(minClearence);
        defaultTargetAvailability = getFieldText(targetAvailability);
        assertEquals("The defaultFresnelZoneRadius default val is not correct", defaultFresnelZoneRadius, "60");
        assertEquals("The defaultKFactor default val is not correct", defaultKFactor, "1");
        assertEquals("The defaultMinimumClearance default val is not correct", defaultMinimumClearance, "0");
        assertEquals("The Target Avail default val is not correct", defaultTargetAvailability, "99.999");
		 */
	}



	public void selectAndViewSettingsFromHamburgerMenu() {
		click(hamburgerDropDownInactive);
		if(! isDisplayed(hamburgerDeletePaths,10)) 
			clickJS(hamburgerDropDownInactive);
		assertTrue("Settings menu option is not present", isDisplayed(hamburgerSettings, 10));
		clickJS(hamburgerSettings);
		slowDown(1);
		assertTrue("Project US Unit is not present", isDisplayed(uSUnit, 10));
		assertTrue("Project SI unit is not present", isDisplayed(sIUnit, 10));
		assertTrue("Project Default Company is not present", isDisplayed(defaultLicenseeField, 10));

	}

	public void highlightSinglePathDeselectAndValidate() {
		assertTrue("There are no paths present Pleases adjust your preconditions to include the setting up of PATH test data", isDisplayed(allPathsNew, 10));
		click(allPathsNew, 1);
		click(allPathsNew, 2);
		assertTrue("The path is not selected",isDisplayedArray(pathsSelectedByArray, 0));
		click(allPathsNew, 1);
		click(allPathsNew, 2);
		assertTrue("The path is not selected",isDisplayedArray(allPathsNotSelected, 0));
	}

	public void highlightPathAndSelectDeleteFromHamburger(){
		assertTrue("There are no paths present Pleases adjust your preconditions to include the setting up of PATH test data",isDisplayed(allPaths,10));
		slowDown(1);
		clickJS(allPaths,1);
		clickJS(allPaths,2);
		assertTrue("The path is not selected", isDisplayedArray(pathsSelectedByArray,0));
		click(hamburgerDropDownInactive);
		if(! isDisplayed(hamburgerDeletePaths,10))
			clickJS(hamburgerDropDownInactive);
		assertTrue("Delete Paths option is not present", isDisplayed(hamburgerDeletePaths,10));
		click(hamburgerDeletePaths);
		assertTrue("Delete modal is not present", isDisplayed(deletePopup,10));
		assertTrue("Delete button is not present", isDisplayed(deleteButton,10));
		assertTrue("Remove button for individual path is not present", isDisplayed(deselectPathForDeletion,10));
		click(deselectPathForDeletion);
		List<WebElement> remaingPath;
		remaingPath = finds(remainingDeletePaths);
		assertEquals("Path was not removed", remaingPath.size() ,1);
		click(deleteButton);
		assertTrue("Delete confirmation is not present", isDisplayed(deleteConfirmationNew,10));
		isDisplayed(allPaths);
		assertTrue("allPaths is not present", isDisplayed(allPaths, 90));
		List<WebElement> allPathsPresent;
		allPathsPresent = finds(allPaths);
		assertEquals("Path was not removed", allPathsPresent.size() ,4);
		String totalPaths;
		totalPaths = getText(totalPathAmount);
		//COM 102
		//TODO https://www.screencast.com/t/HYnxqaFam Sprint14
	}


	public void deleteSinglePath(){

		click(actionArrow);
		slowDown(1);
		assertTrue("Delete option did not appear for path 1", isDisplayed(deleteOption,3));
		clickJS(deleteOption,0);
		assertTrue("Delete pop up did not appear", isDisplayed(deletePopup,20));
		String deletePathPopupTitleq = getText(deletePathPopupTitle);

		assertTrue("Delete button is not present", isDisplayed(deleteButton,3));
		click(deleteButton);

		assertTrue("Delete confirmation not present", isDisplayed(deletePopup,30));
		assertTrue("deleteConfirmationTitle not present", isDisplayed(deleteConfirmationTitle,60));

		String DeleteConfirmationTitle = getText(deleteConfirmationTitle);
		assertEquals(DeleteConfirmationTitle, "Delete Path Confirmation");

		assertTrue("deleteConfirmationSubText not present", isDisplayed(deleteConfirmationSubText,60));
		String DeleteConfirmationSubtext = getText(deleteConfirmationSubText);
		assertEquals(DeleteConfirmationSubtext, "You have successfully deleted 1 path.");
	}

	public  void checkPathNumForAscend(){
		checkForAscend(SortPathNum);
		sortValidationAscending(listNumPaths);
	}

	public void checkBandForAcend() {
		checkForAscend(SortBand);
		sortValidationAscending(listNumBands);
	}

	public void checkPathNameForAcend() {
		checkForAscend(SortPath);
		sortValidationAscending(listNamePaths);
	}

	public  void checkPathNumForDescend(){
		checkForDescend(SortPathNum);
		sortValidationDescending(listNumPaths);
	}

	public void checkBandForDescend() {
		checkForDescend(SortBand);
		sortValidationDescending(listNumBands);
	}


	public void checkPathNameForDescend() {
		checkForDescend(SortPath);
		sortValidationDescending(listNamePaths);
	}


	public String defaultFilterValue() {
		String  band;
		isDisplayed(filterSelection);
		band = getFieldText(filterSelection);
		return  band;
	}

	public void hoverPassiveRepeaterValSiteInfo(){
		String filterEntryField;
		isDisplayed(passiveRepeaterIcon,10);
		hover(passiveRepeaterIcon);
		assertTrue("Can't Find Site Name",isDisplayed(passiveRepeaterHoverSiteNameField,3));
		assertTrue("Can't Find Site Lat",isDisplayed(passiveRepeaterHoverLatitudeField,3));
		assertTrue("Can't Find Site Long",isDisplayed(passiveRepeaterHoverLongitudeField,3));
		assertTrue("Can't Find Site Ant",isDisplayed(passiveRepeaterHoverAntennaField,3));
	}



	public int filterForTestData(String dropDown, String location){
		String pathReturnTotal;
		int pathcount;
		filter(dropDown,location);
		pathReturnTotal = getText(totalPathAmount);
		pathcount = Integer.parseInt(pathReturnTotal.toString());
		return pathcount;
	}


	public void filter(String dropDown, String location){
		isDisplayed(filterSelection,10);
		clear(filterSelectionInput);
		clear(filterSelectionInput);
		type(location, filterSelectionInput );
		selectFromDropdown(filterSelection, dropDown);
		click(searchButton);
		slowDown(3);
	}

	public void validateBandFilteredResult(String pathVal){
		String path;
		isDisplayed(bandValue,0);
		isDisplayed(pathNameArrayProjectSummaryResults,3);
		path = getTextPlural(pathNameArrayProjectSummaryResults,0);
		assertEquals(path, pathVal);
	}

	public void validatePathNameFilteredResult(String pathVal){
		String path;
		isDisplayed(pathNameArrayProjectSummaryResults,3);
		path = getTextPlural(pathNameArrayProjectSummaryResults,0);
		assertEquals(path, pathVal);
	}

	public void validateSiteNameFilteredResult(String pathVal){
		String path;
		isDisplayed(pathNameArrayProjectSummaryResults,3);
		path = getTextPlural(pathNameArrayProjectSummaryResults,2);
		assertEquals(path, pathVal);
	}

	public void validateLicenseeFilteredResult (String pathVal2,String pathVal3,String pathVal4,String pathVal5) {

		String path2;
		String path3;
		String path4;
		String path5;
		isDisplayed(pathNameArrayProjectSummaryResults,3);

		path2 = getTextPlural(pathNameArrayProjectSummaryResults,1);
		path3 = getTextPlural(pathNameArrayProjectSummaryResults,2);
		path4 = getTextPlural(pathNameArrayProjectSummaryResults,3);
		path5 = getTextPlural(pathNameArrayProjectSummaryResults,4);
		assertEquals(path2, pathVal2);
		assertEquals(path3, pathVal3);
		assertEquals(path4, pathVal4);
		assertEquals(path5, pathVal5);
	}

	public void checkThatSelectButtonIsAvailable() {
		slowDown(1);
		assertTrue("path Detail Button is not displayed",isDisplayed(pathDetailButton,40));
		assertTrue("Select All checkox not present",isDisplayed(selectAllLabel,25));
	}

	public void clickSelectButton_CheckForDeselectButton() {
		assertTrue("Select All button not present",isDisplayed(selectAllLabel,25));
		click(selectAllcheckbox);
		isDisplayed(selectAllcheckbox,3);
	}

	public void clickDeselectAllButton(){
		assertTrue("Select All button not present",isDisplayed(selectAllcheckbox,25));
	}

	public void checkForDeleteCandidates(String pathVal1, String pathVal2,String pathVal3){
		String path1;
		String path2;
		String path3;
		while(isDisplayed(elevationQuickAddSite2))
		{
			slowDown(3);
		}
		assertTrue("path 1 is not present",isDisplayed(pathNameArrayProjectSummaryResults));

		path1 = getTextPlural(pathNameArrayProjectSummaryResults,0);
		path2 = getTextPlural(pathNameArrayProjectSummaryResults,1);
		path3 = getTextPlural(pathNameArrayProjectSummaryResults,2);
		assertEquals(path1, pathVal1);
		assertEquals(path2, pathVal2);
		assertEquals(path3, pathVal3);
		List<WebElement> paths;
		paths = finds(allPaths);
		slowDown(3);
		System.out.println("paths.size() "+paths.size());
		assertEquals("Select All button not present", paths.size() ,5);
	}
	public void sceenNotInactiveWhileSaving() {
		while(isDisplayed(elevationQuickAddSite2))
		{
			slowDown(3);
		}
	}

	public void checkForDeletedPath(String pathVal1){

		List<WebElement> paths;
		paths = finds(allPaths);
		assertEquals("Select All button not present", paths.size() ,4);
	}

	/**
	 * 
	 * Given the user wants to search by an unassigned value in path summary page
	 * When searching by the path name,
	 * Then appropriate search results will come up:
	 *  • path (BLANK) Default
	 *  @param pathval1 -test path name
	 */
	public void validateBlankFilteredResult (String pathVal1) {
		String path1;
		isDisplayed(pathNameArrayProjectSummaryResults,3);
		slowDown(2);
		path1 = getTextPlural(pathNameArrayProjectSummaryResults,0);
		assertEquals(path1, pathVal1);

	}

	/**
	 * 
	 * Given the user wants to search/filter by an unassigned or assigned value in path summary page
	 * When searching by callsign
	 * Then appropriate search results will come up:
	 *  • callsign (BLANK) Default
	 *  @param pathval2 -test path name
	 */

	public void validateCallSignFilteredResult (String pathVal2) {
		String path2;
		isDisplayed(pathNameArrayProjectSummaryResults,3);
		path2 = getTextPlural(pathNameArrayProjectSummaryResults,0);
		assertEquals(path2, pathVal2);
	}

	/**
	 * 
	 * Given the user wants to search/filter by an unassigned or assigned value in path summary page
	 * When filtering by Antenna code
	 * Then appropriate search results will come up:
	 *  • Antenna code (BLANK) Default
	 *  @param pathval2 -test path name
	 */

	public void validateAntennaCodeFilteredResult(String pathVal2, String pathVal3, String pathVal5){
		String path2;
		String path3;
		String path5;
		isDisplayed(pathNameArrayProjectSummaryResults,3);
		path2 = getTextPlural(pathNameArrayProjectSummaryResults,1);
		path3 = getTextPlural(pathNameArrayProjectSummaryResults,2);
		path5 = getTextPlural(pathNameArrayProjectSummaryResults,4);
		assertEquals(path2, pathVal2);
		assertEquals(path3, pathVal3);
		assertEquals(path5, pathVal5);
	}

	public void validateAntennaModelFilteredResult (String pathVal5){
		String path5;
		isDisplayed(pathNameArrayProjectSummaryResults,3);
		path5 = getTextPlural(pathNameArrayProjectSummaryResults,4);
		assertEquals(path5, pathVal5);
	}
	public void validateRadioCodeFilteredResult (String pathVal4){
		String path4;
		isDisplayed(pathNameArrayProjectSummaryResults,3);
		path4 = getTextPlural(pathNameArrayProjectSummaryResults,3);
		assertEquals(path4, pathVal4);
	}
	/**
	 * 
	 * Given the user wants to search/filter by an unassigned or assigned value in path summary page
	 * When filtering by Bandwidth
	 * 
	 */
	public void validateRadioBandwidthFilteredResult (String pathVal5){
		String path5;
		isDisplayed(pathNameArrayProjectSummaryResults,3);
		path5 = getTextPlural(pathNameArrayProjectSummaryResults,4);
		assertEquals(path5, pathVal5);
	}
	public void validateMaxPowerFilteredResult (String pathVal5){
		String path5;
		isDisplayed(pathNameArrayProjectSummaryResults,3);
		path5 = getTextPlural(pathNameArrayProjectSummaryResults,4);
		assertEquals(path5, pathVal5);
	}


	public Boolean landedOnPathSummaryPage(){
		return waitForIsDisplayed(projectTitle,10);
	}

	public boolean projectName() {
		return isDisplayed(projectTitleName);
	}

	public String projectNameText() {
		return getText(projectTitleName);
	}

	public String projectNameSite1Site2Text(int i) {
		return getTextPlural(listNamePaths, i);
	}

	public String pathAmounts() {
		return getText(totalPathAmount);
	}

	public boolean disabledSplit() {
		return isDisplayed(hamburgerSplitPathsDisabled);
	}

	public String defaultCompanyName() {
		return getText(defaultCompanyName);
	}

	/**
	 * This method is to click callsign checkbox
	 */

	public void clickCallSignCheckBox() {
		slowDown(1);
		assertTrue("call sign checkbox is not displayed", isDisplayed(callSignCheckBox,60));
		click(callSignCheckBox); 
		slowDown(2);
		assertTrue("checkDistanceFieldInCallSignCheckPage is not displayed", isDisplayed(checkDistanceFieldInCallSignCheckPage,50));
		click(searchButtonCallSignPage);
	}

	/**
	 * This method is to click ASR checkbox
	 */

	public void clickASRBox() {
		slowDown(1);
		assertTrue("asr checkbox is not displayed", isDisplayed(asrCheckBox,60));
		click(asrCheckBox); 
		slowDown(2);
		assertTrue("checkDistanceFieldInASRCheckPage is not displayed", isDisplayed(checkDistanceFieldInASRCheckPage,50));
		click(searchButtonAsrPage);
	}
	
	/**
	 * This method is to click warnings check box
	 */
	public void clickWarningsCheckBox() {
		assertTrue("warnings checkbox is not displayed", isDisplayed(warningsCheckBox,60));
		clickJS(warningsCheckBox); 
		slowDown(2);
		assertTrue("warning modal is missing",isDisplayed(warningModalHeading,70));
		click(warningModalSubmitButton);
		assertTrue("path Summary HeaderLink is missing",isDisplayed(pathSummaryHeaderLink,70));
	}

	/**
	 * This method is to verify call sign results
	 */

	public void verifyCallSignResults() {
		slowDown(3);
		assertTrue("callsign results are not present", isDisplayed(callSignResultsFromCallSignCheck,50));
		click(callSignCheckPageExit);
	}

	/**
	 * This method is to verify ASR checkbox
	 */

	public void verifyASRResults() {
		slowDown(3);
		assertTrue("ASR results are not present", isDisplayed(asrResultsFromAsrCheck,50));
		click(asrCheckPageExit);
	}
	//This method click hamburger and then click import button
	public void clickImportPathFromHamburger() {
		clickJS(closeSettings);
		slowDown(1);
		clickJS(importPathFromHamburger);
		assertTrue("Import from path datbase option is not present", isDisplayed(importFromPathDatabase,50));

	}
	//This method click "import from database" icon from path summary page.
	public void clickImportFromPathDatabase() {
		assertTrue("Import from path datbase option is not present", isDisplayed(importFromPathDatabase,50));
		click(importFromPathDatabase);

	}
	/**
	 * This method is to click the first path from the project
	 */
	public void clickFirstPath() {
		assertTrue("Path is missing",isDisplayed(pathDetailButton,40));
		click(intraPathDetailButton,0);
		slowDown(3);
	}
	/**
	 * This method is to verify the control is in path summary page and open the path in the path summary page
	 */
	public void openPathInPathSummaryPage(){
		slowDown(1);
		assertTrue("Pathsummary page doesnt appear",isDisplayed(pathDetailButton,40));
		assertTrue("intraPathDetailButton doesnt appear",isDisplayed(intraPathDetailButton,140));
		click(intraPathDetailButton);
		assertTrue("Path details page doesnt appear",isDisplayed(bandPathDetail,200));
	}
	/**
	 * This method is to click hamburger  
	 */
	public void clickHamburgerPathSummary() {
		clickJS(closeSettings);
		slowDown(2);

	}
	/**
	 * This method id to click import path from hamburger- path summary
	 */
	public void clickImportPathHamburgerPathSummary() {
		assertTrue("Hamburger- import path in path summary  page is missing",isDisplayed(importPathFromHamburger,50));
		clickJS(importPathFromHamburger);
		slowDown(2);
	}
	/**
	 * This method is to select "Import from project" icon on import path of path summary screen
	 */
	public String clickImportToPathPathSummary(String rcn) {
		assertTrue("Import from project icon is missing",isDisplayed(importFromProject,40));
		click(importFromPathDatabase);
		assertTrue("Clear button on path import page is missing",isDisplayed(clearPathImportPage,140));
		click(clearPathImportPage);
		assertTrue("rcnFieldImportPagen  is missing",isDisplayed(rcnFieldImportPage,140));
		type(rcn,rcnFieldImportPage);
		assertTrue("pathImportSearch button  is missing",isDisplayed(pathImportSearch,140));
		//Double search
		clickJS(pathImportSearch);
		//double search
		if(!isDisplayed(importPathSearchResults,60))
			clickJS(pathImportSearch);
		//click(pathImportSearch);
		slowDown(1);
		assertTrue("pathImportResult  is missing",isDisplayed(pathImportResult,140));
		String sitename=getText(siteName);
		click(pathImportResult);
		slowDown(1);
		clickPage();
		return sitename;
	}
	/**
	 * This method is to click anywhere on a page after the path save message appaears
	 */
	public void clickPage() {
		slowDown(1);
		clickJS(blankPage);
		slowDown(2);
	}
	/**
	 * This method is to verify the imported path
	 * @param siteName2
	 */

	public void verifyImportedPath(String siteName2) {
		slowDown(1);
		assertTrue("Path summary page is missing", isDisplayed(siteNameSummary,60));
		String siteNamePart =getText(siteNameSummary);
		assertEquals(siteNamePart,siteName2);

	}

	/**
	 * This method is to open a path in a project
	 */

	public void openPath() {
		assertTrue("Path summary page is missing", isDisplayed(siteNameSummary,60));
		click(siteNameSummary);

	}
	
	/**
	 * This method is to verify all elements and table results on asr check page
	 */
	public void verifyElementsAsrCheck() {
		assertTrue("structure height header is missing", isDisplayed(structureHeightHeaderAsrCheck, 8));
		assertTrue("centerline header is missing", isDisplayed(centerlineHeaderAsrCheck, 8));
		assertEquals(getText(structureHeightHeaderAsrCheck), "Structure Height (m)");
		assertEquals(getText(centerlineHeaderAsrCheck), "Centerline (m)");
		assertTrue("asr results is missing", isDisplayed(asrResultsFromAsrCheck,8));
		assertTrue("tower owner results is missing", isDisplayed(towerOwnerResultsFromAsrCheck,8));
		assertTrue("structure height results is missing", isDisplayed(structureHeightResultsFromAsrCheck,8));
		assertTrue("tower owner header result is missing", isDisplayed(towerOwnerSelectedFromAsrCheck,8));
		assertTrue("structure height header result is missing", isDisplayed(structureHeightSelectedFromAsrCheck,8));
		assertTrue("asr data button is missing", isDisplayed(asrDataButtonAsrCheckPage,8));
		assertTrue("asr only button is missing", isDisplayed(asrOnlyButtonAsrCheckPage,8));
		assertTrue("asr data button is missing", isDisplayed(asrResultsFromAsrCheck,8));
		assertTrue("exit page button is missing", isDisplayed(asrCheckPageExit,8));
		assertTrue("submit button is missing", isDisplayed(submitButtonAsrCheckPage,8));
	}
	
	/**
	 * This method is to verify fields after submitting asr on asr check page
	 */
	public void verifySubmitAsrCheck() {
		slowDown(2);
		String towerOwnerValue = getTextPlural(towerOwnerResultsFromAsrCheck, 3);
		String structureHeightValue = getTextPlural(structureHeightResultsFromAsrCheck, 2);	
		assertTrue("asrDataButtonAsrCheckPage is missing", isDisplayed(asrDataButtonAsrCheckPage,180));
		click(asrDataButtonAsrCheckPage, 1);
		assertTrue("submitButtonAsrCheckPage is missing", isDisplayed(submitButtonAsrCheckPage,180));
		click(submitButtonAsrCheckPage);
		slowDown(2);
		String towerOwnerSelected = getText(towerOwnerSelectedFromAsrCheck);
		String structureHeightSelected = getText(structureHeightSelectedFromAsrCheck);	
		assertEquals(towerOwnerValue, towerOwnerSelected);
		assertEquals(structureHeightValue, structureHeightSelected);
	}
	/*
	 * Thos method is to check project status
	 * @Param status
	 */

	public void verifyProjectStatus(String status) {
		assertTrue("Project status is missing",isDisplayed(projectStatusOnSummaryPage,20));
		assertEquals(getText(projectStatusOnSummaryPage),status);
		
	}
	/**
	 * This method is to click the path after finalizing it and making sure delete button is not present
	 */
	public void clickPathAfterFinalize() {
		click(intraPathDetailButton,0);
		slowDown(3);
		assertTrue("Path detail page is missing",isDisplayed(PathDetailsPageReturn,20));
		if(isDisplayed(deletePathDetails, 8))
			//This should fail
			assertTrue("Path detail page is missing",isDisplayed(filterSelectionInput,20));
		click(PathDetailsPageReturn);
		slowDown(1);

	}
}

