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

public class ESAnalysisResultsPage extends BasePage {
	By SaveAnalysisPage = By.id("afs-parameters-footer-save");
	By endTime = By.id("afs-parameters-bands[0]-bands[0]status[0]-end-time");
	By ESResultLink= By.id("interference-analysis-navigation-link-es_results");
	By ESResultStatus = By.id("EARTH_STATION_RESULTS_FORM-analysis-status");
	By caseNumberField = By.id("EARTH_STATION_RESULTS_FORM-caseNumbers");
	By esCaseCount = By.id("EARTH_STATION_RESULTS_FORM-total-case-numbers-count");
	By selectAllESCase = By.id("EARTH_STATION_RESULTS_FORM-select-all");
	By reportsButton = By.id("EARTH_STATION_RESULTS_FORM-submit");
	By esCaseDropdown = By.id("es-check-case-select-select");
	By esOHDrawerCaseReportButton = By.id("earth-station-oh-details-drawer-profile-data-export-case-report");
	By esOHDrawerOHReportButton = By.id("earth-station-oh-details-drawer-profile-data-export-oh-report");
	By esOHDrawerKMLReportButton = By.id("earth-station-oh-details-drawer-profile-data-export-kml-report");
	By esOHDrawerBand = By.id("earth-station-oh-details-drawer-bandDesignator-label");
	By esDrawerClimate = By.id("earth-station-oh-details-drawer-climateZone-label");
	By esOHDrawer20Percent = By.id("earth-station-oh-details-drawer-ohLoss20-label");
	By esOHDrawerPointNotOnePErcent = By.id("earth-station-oh-details-drawer-ohLoss01-label");
	By esOHDrawerLongTermMargin = By.id("earth-station-oh-details-drawer-longTermMargin-label");
	By esOHDrawerShortTermMargin = By.id("earth-station-oh-details-drawer-shortTermMargin-label");
	By esOHDrawerDelete = By.id("earth-station-oh-details-drawer-profile-data-1-delete");
	By esReports = By.id("EARTH_STATION_RESULTS_FORM-submit");
	By addOHLossInDrawer = By.id("earth-station-oh-details-drawer-profile-data-addRow-add");
	By cancelButtonOHDrawer = By.id("earth-station-oh-details-drawer-profile-data-addRow-apply-cancel");
	By distanceFieldOHDrawer = By.id("earth-station-oh-details-drawer-profile-data-addRow-distance");
	By elevationFieldOHDrawer = By.id("earth-station-oh-details-drawer-profile-data-addRow-elevation");
	By clutterHeightField = By.id("earth-station-oh-details-drawer-profile-data-addRow-clutter-height");
	By applyButtonOHDrawer = By.id("earth-station-oh-details-drawer-profile-data-addRow-apply");
	public ESAnalysisResultsPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method is to open Es results link
	 */
	public void clickESResults() {
		assertTrue("ES Results link is not displayed", isDisplayed(ESResultLink,120));
		clickJS(ESResultLink);
		slowDown(1);
		assertTrue("ES Results UI is not displayed", isDisplayed(ESResultStatus,120));
		assertEquals(getText(ESResultStatus),"Completed");
		assertTrue("case number field is not displayed", isDisplayed(caseNumberField,120));
		
	}
	/**
	 * This method is to verify es cases not null
	 * Report generation not covered here- as sleneium doesnt support that.
	 */
	public void verifyESCasesNotNull() {
		assertTrue("ES Results UI is not displayed", isDisplayed(ESResultStatus,120));
		assertEquals(getText(ESResultStatus),"Completed");
		assertTrue("case number field is not displayed", isDisplayed(caseNumberField,120));
		if(getText(esCaseCount)!="0")
		{
			assertTrue("case number are not created", isDisplayed(caseNumberField,120));
		} else {
			assertTrue("case number is not displayed", isDisplayed(SaveAnalysisPage,120));
		}
		clickSelectAllCheckbox();
	}
	/**
	 * this method is to click select all checkbox on es results page
	 */
	public void clickSelectAllCheckbox() {
		assertTrue("ES select all checkbox is not displayed", isDisplayed(selectAllESCase,20));
		click(selectAllESCase);
		
	}
	/**
	 * this method is to verify Reports button is Present or not on es results page
	 */
	public void verifyReportsButtonPresent() {
		assertTrue(" reports button is missing on ES results page", isDisplayed(reportsButton,20));
	}
	/**
	 * This method is to click ES Case dropdown and Select Case 1
	 */
	public void clickESCaseDropdownAndSelectCase1() {
		assertTrue("ES case dropdown is missing on ES results page", isDisplayed(esCaseDropdown,20));
		selectFromDropdown(esCaseDropdown,"Case 1");
		assertTrue("ES oh drawer doesntshow up", isDisplayed(esOHDrawerCaseReportButton,300));

	}
	/**
	 * This method is to verify ES oh loss drawer report buttons
	 */
	public void verifyESOHLossDrawerReportsButtons() {
		assertTrue("Case report button on ES oh loss drawer is missing", isDisplayed(esOHDrawerCaseReportButton,20));
		assertTrue("OH report button on ES oh loss drawer is missing", isDisplayed(esOHDrawerCaseReportButton,20));
		assertTrue("KML or KMZ report button on ES oh loss drawer is missing", isDisplayed(esOHDrawerCaseReportButton,20));

	}
	/**
	 * This method is to verify elements on ES oh drawer
	 */

	public void verifyESOHLossDrawerElements() {
		assertTrue("bandLabelOHDrawer is missing", isDisplayed(esOHDrawerBand,80));
		assertTrue("climateLabelOHDrawer is missing", isDisplayed(esDrawerClimate,80));
		assertTrue("label20percentOHLoss is missing", isDisplayed(esOHDrawer20Percent,80));
		assertTrue("labeldot01percentOHLoss is missing", isDisplayed(esOHDrawerPointNotOnePErcent,80));
		assertTrue("longtermMarginLabel is missing", isDisplayed(esOHDrawerLongTermMargin,80));
		assertTrue("esOHDrawerShortTermMargin is missing", isDisplayed(esOHDrawerShortTermMargin,80));
		
	}
	/**
	 * This method is to add data points in ES oh drawer
	 * @param distance
	 * @param elevation
	 * @param clutter
	 */
	
	public void addRowESOHDrawer(String distance,String elevation, String clutter) {
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
	
}


