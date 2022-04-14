package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * @author nshaji
 *
 */

public class TerrAnalysisResultsAFSPage extends BasePage {
	By pathIndex = By.id("path-details-path-index");
	By projectList = By.xpath("//*[contains(@id, 'project-management-modal-table-data-projectId-') and contains(@id, '-serviceContactCodes')]");
	By deselectAllButton = By.id("afs-grid-filter-select-all-paths");
	By selectAllButton = By.id("afs-grid-filter-select-all-paths");
	By selectAllCheckbox = By.id("afs-grid-filter-select-all");
	By analysisButton = By.id("project-summary-navigation-link-analysis");
	By summaryButton = By.id("project-summary-navigation-link-summary");
	By deactivate = By.id("afs-grid-footer-deactivate-button");
	By deselectResult = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-path-highlight')]");
	By saveButtonAFSGridAnalysisPage = By.id("afs-grid-footer-save-button");
	By FilterButtonAFSGridAnalysis = By.id("afs-grid-footer-result-filter-button");
	By FilterONToggle = By.id("afs-grid-footer-result-filter-toggle-true");
	By FilterOFFToggle = By.id("afs-grid-footer-result-filter-toggle-false");
	By FlipHiLoButton = By.id("afs-grid-filter-flip-hi-lo");
	By enivornmentAnalysisButton = By.id("afs-grid-filter-analysisTypeId--1-label-bottom");
	By IntraSystemAnalysisButton = By.id("afs-grid-filter-analysisTypeId--2-label-bottom");
	By TerrResultsLink = By.id("interference-analysis-navigation-link-terr_results");
	By RunAnalysisLink = By.id("interference-analysis-navigation-link-run_analysis");
	By ESResultsLink = By.id("interference-analysis-navigation-link-es_results");
	By ConfirmButtonPrompt = By.id("discard-confirmation-modal-discard");
	By CancelButtonPrompt = By.id("discard-confirmation-modal-cancel");
	By AFSGridChannelHeadingPair1= By.id("afs-grid-results-1");
	By AFSGridChannelHeadingPair2= By.id("afs-grid-results-2");
	By AFSGridChannelHeadingPair3= By.id("afs-grid-results-3");
	By AFSGridSite1Name = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-site1-site-name')]");
	By AFSGridSite2Name = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-site2-site-name')]");
	
	By terrResultsLinkOnAnalysisPage = By.id("interference-analysis-navigation-link-terr_results");
	By AFSGridResultPolarizationV = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-0-v')]");
	By AFSGridResultPolarizationH = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-0-h')]");
	
	By AFSGridLegendTrigger = By.id("afs-grid-legend-trigger");
	By AFSGridGreenNoCaseMarginIcon = By.xpath("//*[contains(@class, 'afs-result-disabled result-unfiltered afs-result-type-0')]");
	By AFSGridYellowOnlyOHLossIcon = By.xpath("//*[contains(@class, 'afs-result-disabled result-unfiltered afs-result-type-1')]");
	By AFSGridBlackExceptGrowthChannelsIcon = By.xpath("//*[contains(@class, 'afs-result-disabled result-unfiltered afs-result-type-2')]");
	By AFSGridRedCaseMarginNotMetIcon = By.xpath("//*[contains(@class, 'afs-result-disabled result-unfiltered afs-result-type-3')]");
	By AFSGridBlueCoChannelBuckCoPolarizedIcon = By.xpath("//*[contains(@class, 'afs-result-disabled result-unfiltered afs-result-type-4')]");
	By AFSGridLightblueCochannelBuckCrossPolarizedIcon = By.xpath("//*[contains(@class, 'afs-result-disabled result-unfiltered afs-result-type-5')]");

	By AFSGridSite1EnvironmentHi = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-site1-environment-hi')]");
	By AFSGridSite1EnvironmentLo = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-site1-environment-lo')]");
	By AFSGridSite2EnvironmentHi = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-site2-environment-hi')]");
	By AFSGridSite2EnvironmentLo = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-site2-environment-lo')]");

	By AFSGridSite1IntraHi = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-site1-project-hi')]");
	By AFSGridSite1IntraLo = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-site1-project-lo')]");
	By AFSGridSite2IntraHi = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-site2-project-hi')]");
	By AFSGridSite2IntraLo = By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-site2-project-lo')]");
	By AFSErrorMessage = By.id("error-errors-list-error-error-list-0-message-0");
	By AFSErrors = By.id("error-errors-list-error-error");
	By runAnalysisLink = By.id("interference-analysis-navigation-link-run_analysis");
	By frequencyWindowField = By.id("afs-parameters-bands[0]-frequency-window");
	By AFSGridPathIndex =  By.xpath("//*[contains(@id, 'afs-grid-results-') and contains(@id, '-path-highlight')]");
	By AFSNotificationErrorMessage = By.id("error-errors-list-error-error-list-0-message-0");
	By AFSHamburgerMenuAFSGridPage= By.id("afs-grid-filter-menu-toggle");
	By interferenceCaseReportButton = By.id("afs-grid-filter-terr-case-report");
	By interferenceCaseReportNameField = By.id("terr-case-report-export-report-name");
	By interferenceCaseReportShowAll = By.id("terr-case-report-export-show-all-cases-true-label");
	By cancelInterferenceReportUI = By.cssSelector(".heading-font.btn.btn-md.hover-inverse.bg-grey-dark.center-text");
	By propagationModalField = By.id("afs-parameters-bands[0]propagation-model");
	By propagationModalInput = By.id("react-select-afs-parameters-bands[0]propagation-model-input");
	By propagationModalValue = By.cssSelector(".react-select__single-value.css-1uccc91-singleValue");
	By propagationModalSelect = By.cssSelector(".react-select__control css-yk16xz-control");
	By propagationModalitm = By.cssSelector(".react-select__menu.css-2613gy-menu");
	By propagation = By.cssSelector(".react-select.indicator.react-select.dropdown-indicator.css-tlfecz-indicatorContainer");
	By propagationoptionITM = By.id("react-select-afs-parameters-bands[0]propagation-model-option-1");
	By propagationoptionOutdoor6 = By.id("react-select-afs-parameters-bands[0]propagation-model-option-2");
	By propagationoptionIndoor6 = By.id("react-select-afs-parameters-bands[0]propagation-model-option-3");
	By propagationoptionIndoorEff = By.id("react-select-afs-parameters-bands[0]propagation-model-option-4");
	By propagationoption = By.xpath("//*[contains(@className, 'react-select__option')]");
	
	public TerrAnalysisResultsAFSPage(WebDriver driver) {
		super(driver);
	}
	/**
	 * This method is to click on the Analysis page on path summary
	 */
	public void clickAnalysisButtonOnPathSummaryPage() {
		assertTrue("Analysis button is missing",isDisplayed(analysisButton,60));
		slowDown(2);
		click(analysisButton);
		//double search
				if(!isDisplayed(frequencyWindowField,20))
					clickJS(analysisButton);
		assertTrue("Ananlysis Run page is not displayed", isDisplayed(frequencyWindowField,120));
	}
	/**
	 * This method is to click the summary page on analysis
	 */
	public void clickSummaryButtonOnAnalyisPage() {
		assertTrue("Summary button is missing",isDisplayed(summaryButton,20));
		clickJS(summaryButton);
	}
	/**
	 * This method is to select/Deselect Polarization And Deactivate
	 */
	public void selectDeactivate() {
		assertTrue("Deactivate button is not displayed", isDisplayed(deactivate,60));
		slowDown(1);
		clickJS(deselectResult,0);
		clickJS(deselectResult,1);

	}
	/**
	 * This method is to verify the elements on the analysis page
	 */
	public void verifyElementsOnAnalysisPage() {
		assertTrue("Flip Hi Lo button is not displayed", isDisplayed(FlipHiLoButton,60));
		assertTrue("Environment button is not displayed", isDisplayed(enivornmentAnalysisButton,60));
		assertTrue("Intra-System button is not displayed", isDisplayed(IntraSystemAnalysisButton,60));
		assertTrue("Terr Results is not displayed", isDisplayed(TerrResultsLink,60));
		assertTrue("Run Analysis Link is not displayed", isDisplayed(RunAnalysisLink,60));
		assertTrue("Es Results link is not displayed", isDisplayed(ESResultsLink,60));
		assertTrue("Deactivate button is not displayed", isDisplayed(deactivate,60));
		assertTrue("Save button is not displayed", isDisplayed(saveButtonAFSGridAnalysisPage,60));
		assertTrue("Filter button is not displayed", isDisplayed(FilterButtonAFSGridAnalysis,60));
	}

	/**
	 * This method is to verify pre-Analysis grid
	 */
	public void verifyPreAnalysisGrid() {
		System.out.println(getText(AFSGridChannelHeadingPair1));
		assertEquals("941.7\n" + 
				"932.7\n" + 
				"V\n" + 
				"H",getText(AFSGridChannelHeadingPair1));
		assertEquals("941.75\n" + 
				"932.75\n" + 
				"V\n" + 
				"H",getText(AFSGridChannelHeadingPair2));
		assertEquals("943.8\n" + 
				"934.8\n" + 
				"V\n" + 
				"H",getText(AFSGridChannelHeadingPair3));
		assertEquals("0H",getText(AFSGridSite1EnvironmentHi));
		assertEquals("0L",getText(AFSGridSite1EnvironmentLo));
		assertEquals("0H",getText(AFSGridSite2EnvironmentHi));
		assertEquals("0L",getText(AFSGridSite2EnvironmentLo));
		assertEquals("0H",getText(AFSGridSite1IntraHi));
		assertEquals("0L",getText(AFSGridSite1IntraLo));
		assertEquals("0H",getText(AFSGridSite2IntraHi));
		assertEquals("0L",getText(AFSGridSite2IntraLo));

	}
	
	/**
	 * This method is to click on a path result to open the path case summary page
	 */
	public void clickPathResult() {
		assertTrue("path result is not displayed", isDisplayed(AFSGridSite1IntraHi, 60));
		slowDown(3);
		clickJS(AFSGridSite1IntraHi);
	}
	
	public void clickFlipPathButton() {
		assertTrue("Ananlysis page is not displayed", isDisplayed(FlipHiLoButton,60));
		click(deselectResult,0);
		slowDown(1);
		click(FlipHiLoButton);
		assertTrue("error message is not displayed", isDisplayed(AFSErrors,60));

	}
	/**
	 * This method is to validate error message on simplex path
	 * @param errorMessage
	 */
	public void validateErrorOnSimplexPath(String errorMessage) {
		assertEquals(getText(AFSErrorMessage),errorMessage);
		slowDown(1);
	}
	/**
	 * This method is to click Run analysis link on AFS screen
	 * 
	 */
	public void runAnalysisDisplayedOnAFSPage() {
		slowDown(3);
		assertTrue("Ananlysis Run page is not displayed", isDisplayed(frequencyWindowField,120));
	}
	
	/**
	 * This method is to click Terr results link on AFS screen
	 */
	public void clickTerrResultsLinkOnAFSPage() {
		assertTrue("Terr Results link is not displayed", isDisplayed(TerrResultsLink, 60));
		slowDown(3);
		clickJS(TerrResultsLink);
		assertTrue("Analysis Page is not displayed", isDisplayed(FilterButtonAFSGridAnalysis,120));
	}
	
	/**
	 * This method is to click on the filter button on AFS analysis page
	 */
	public void clickFilterButton() {
		assertTrue("filter button is not displayed", isDisplayed(FilterButtonAFSGridAnalysis, 60));
		slowDown(6);
		clickJS(FilterButtonAFSGridAnalysis);
	}
	
	/**
	 * This method deselects and selects new frequencies on AFS results grid 
	 */
	public void savePolarizationSelections() {
		assertTrue("Deactivate button is not displayed", isDisplayed(deactivate,60));
		clickJS(deactivate);
		slowDown(3);
		clickJS(AFSGridResultPolarizationV);
		slowDown(3);
		clickJS(AFSGridResultPolarizationH);
		slowDown(3);
		clickJS(saveButtonAFSGridAnalysisPage);
		slowDown(3);
	}
	/*
	 * This method selects path in afs grid
	 */
	public void selectPathAFSGrid() {
		slowDown(2);
		clickJS(deselectResult);
		slowDown(2);
	}
	
	/**
	 * This method verifies HI-LO button functionality
	 */
	public void verifyHiLoButton() {
		clickJS(FlipHiLoButton);
		slowDown(3);
		assertEquals(getAttributeStyle(AFSGridSite1Name), "font-weight: normal;");
		assertEquals(getAttributeStyle(AFSGridSite2Name), "font-weight: bold;");	
		clickJS(deselectResult);
		slowDown(3);
		clickJS(selectAllCheckbox);
		slowDown(3);
		clickJS(FlipHiLoButton);
		slowDown(3);
		assertEquals(getAttributeStyle(AFSGridSite2Name), "font-weight: bold;");
		assertEquals(getAttributeStyle(AFSGridSite1Name), "font-weight: normal;");	
	}
	
	/**
	 * This method clicks the analysis link with confirm changes prompt
	 */
	public void clickAnalysisLinkWithConfirmChanges() {
		assertTrue("Ananlysis page is not displayed", isDisplayed(FlipHiLoButton,60));
		slowDown(3);
		clickJS(runAnalysisLink);
		assertTrue("Confirm changes button is not displayed", isDisplayed(ConfirmButtonPrompt,60));
		slowDown(3);
		clickJS(ConfirmButtonPrompt);
		assertTrue("Ananlysis Run page is not displayed", isDisplayed(frequencyWindowField,120));
	}
	/**
	 * This method clicks the analysis link 
	 */
	public void clickAnalysisLinkWithoutConfirmChanges() {
		assertTrue("Ananlysis page is not displayed", isDisplayed(FlipHiLoButton,60));
		slowDown(3);
		clickJS(runAnalysisLink);
		assertTrue("Ananlysis Run page is not displayed", isDisplayed(frequencyWindowField,120));
	}


	
	/**
	 * This method verifies elements do no exist for users that do not have edit permissions on AFS Analysis page 
	 */
	public void verifyElementsUsersWithoutPermission() {
		assertTrue("FlipHiLoButton is displayed", !isDisplayed(FlipHiLoButton,8));
		assertTrue("deactivate button is displayed", !isDisplayed(deactivate,8));
		assertTrue("save button is displayed", !isDisplayed(saveButtonAFSGridAnalysisPage,8));	
	}
	
	/** 
	 * This method verifies icon colors on AFS Grid and legend
	 */
	public void verifyColorsAFSGrid() {
		assertTrue("green no case margin icon is not displayed", isDisplayed(AFSGridGreenNoCaseMarginIcon,8));
		clickJS(AFSGridLegendTrigger);
		assertTrue("yellow only OH loss icon is not displayed", isDisplayed(AFSGridYellowOnlyOHLossIcon,8));
		assertTrue("black except growth channels icon is not displayed", isDisplayed(AFSGridBlackExceptGrowthChannelsIcon,8));
		assertTrue("red case margin not met icon is not displayed", isDisplayed(AFSGridRedCaseMarginNotMetIcon,8));
		assertTrue("blue co polarized icon is not displayed", isDisplayed(AFSGridBlueCoChannelBuckCoPolarizedIcon,8));
		assertTrue("light blue cross polarized icon is not displayed on AFS grid", isDisplayed(AFSGridLightblueCochannelBuckCrossPolarizedIcon,8));
	}
	/**
	 * This method is to click the hi-lo flip button
	 * @ error
	 */
	public void clickHiLoFlipAnalysisGridPage(String error) {
		assertTrue("Hi-Lo button is not displayed on AFS Grid page", isDisplayed(FlipHiLoButton,20));
		clickJS(AFSGridPathIndex);
		slowDown(1);
		click(FlipHiLoButton);
		assertTrue("Hi-Lo button is not displayed on AFS Grid page", isDisplayed(AFSNotificationErrorMessage,10));
		assertEquals(getText(AFSNotificationErrorMessage),error);

	}
	public void clickTerResultLinkOnAnalysisPageToGoToAFSGrid() {
		assertTrue("Terr Results link is missing on analysis page",isDisplayed(terrResultsLinkOnAnalysisPage,30));
		click(terrResultsLinkOnAnalysisPage);
		assertTrue("AFS page is missing", isDisplayed(saveButtonAFSGridAnalysisPage,40));
		
	}
	/**
	 * This method is to verify the ui for interference case report generation
	 */
	public void verfyInterferenceCaseReportGenerationUI() {
		click(interferenceCaseReportButton);
		assertTrue("Interference case report generation UI is missing from hamburger menu",isDisplayed(interferenceCaseReportNameField,60));
		assertTrue("Interference case Report generation UI showAll is missing ",isDisplayed(interferenceCaseReportShowAll,30));;
		click(cancelInterferenceReportUI);
	}
	/**
	 * This method is to click hamburger on afs screen
	 */
	public void clickHamburgerOnAFSGridScreen() {
		assertTrue("Hamburger on AFS grid screen is missing",isDisplayed(AFSHamburgerMenuAFSGridPage,30));
		click(AFSHamburgerMenuAFSGridPage);
		assertTrue("Interference case report button is missing from hamburger menu",isDisplayed(interferenceCaseReportButton,30));
	}
	/**
	 * This method id to verify propagation modal analysis options
	 * @param sixGhzInEff 
	 * @param sixGhzIndoor 
	 * @param sixGhzOutdoor 
	 */
	public void verifyPropagationModalAnalysisOptions(String ohloss,String itm, String sixGhzOutdoor, String sixGhzIndoor, String sixGhzInEff) {
		assertTrue("propagation modal field is missing on analysis page",isDisplayed(propagationModalField));
		click(propagationModalField);
		assertEquals(getText(propagationModalValue),ohloss);
		click(propagationModalField);
		type("IT",propagationModalInput);
		assertTrue("ITM is not displayed",isDisplayed(propagationoptionITM,30));
		click(propagationoptionITM);
		slowDown(1);
		assertEquals(getText(propagationModalValue),itm);
		
		type(sixGhzOutdoor,propagationModalInput);
		assertTrue("6 Ghz Outdoor is not displayed",isDisplayed(propagationoptionOutdoor6,30));
		click(propagationoptionOutdoor6);
		slowDown(1);
		assertEquals(getText(propagationModalValue),sixGhzOutdoor);
		
		type(sixGhzIndoor,propagationModalInput);
		assertTrue("6 Ghz Indoor is not displayed",isDisplayed(propagationoptionIndoor6,30));
		click(propagationoptionIndoor6);
		slowDown(1);
		assertEquals(getText(propagationModalValue),sixGhzIndoor);

		type(sixGhzInEff,propagationModalInput);
		assertTrue("6 Ghz InEff is not displayed",isDisplayed(propagationoptionIndoorEff,30));
		click(propagationoptionIndoorEff);
		slowDown(1);
		assertEquals(getText(propagationModalValue),sixGhzInEff);
	
		}
	
}
