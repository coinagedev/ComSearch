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

public class RunAnalysisPage extends BasePage {
	By EnvironmentTypeCheckbox = By.id("afs-parameters-bands[0]-1");
	By IntraSystemTypeCheckbox = By.id("afs-parameters-bands[0]-2");
	By SarthStationTypeCheckbox = By.id("afs-parameters-bands[0]-3");

	By TerrResultsLink = By.id("interference-analysis-navigation-link-terr_results");
	By RunAnalysisLink = By.id("interference-analysis-navigation-link-run_analysis");
	By ESResultsLink = By.id("interference-analysis-navigation-link-es_results");
	By ConfirmButtonPrompt = By.id("discard-confirmation-modal-discard");
	By CancelButtonPrompt = By.id("discard-confirmation-modal-cancel");
	By frequencyWindowField = By.id("afs-parameters-bands[0]-frequency-window");
	By searchRadiusField = By.id("afs-parameters-bands[0]search-radius");
	By KeyHoleSearchRadius = By.id("afs-parameters-bands[0]keyhole-radius");
	By MinProfileDistance = By.id("afs-parameters-bands[0]-min-profile-distance");
	By MarginToObjective = By.id("afs-parameters-bands[0]-margin-to-objective");
	By SaveAnalysisPage = By.id("afs-parameters-footer-save");
	By RunAnalysisButton = By.id("afs-parameters-footer-run-analysis");
	By StartTimeEnvironmentAnalysis = By.id("afs-parameters-bands[0]-bands[0]status[0]-start-time");
	By ElaspedTimeEnvironmentAnalysis = By.id("afs-parameters-bands[0]-bands[0]status[0]-elapsedTime");
	By EndTimeEnvironmentAnalysis = By.id("afs-parameters-bands[0]-bands[0]status[0]-end-time");
	By notificationMessage = By.id("interference-analysis-grid-notification-analysis-status");
	By EnvironmentAnalysisRunStatusIcon = By.id("afs-parameters-bands[0]-bands[0]status[0]-analysis-status-icon"); //title=Running"; Failed etc
	By runAnalysisButton = By.id("afs-parameters-footer-run-analysis");
	By analysisStatus = By.id("afs-parameters-bands[0]-bands[0]status[0]-analysis-status-icon");
	By ESanalysisStatus = By.id("afs-parameters-bands[0]-bands[0]status[2]-analysis-status-icon");
	By elaspedTimeEnvironment = By.id("afs-parameters-bands[0]-bands[0]status[0]-elapsedTime");
	By endTime = By.id("afs-parameters-bands[0]-bands[0]status[0]-end-time");
	By ESResultLink= By.id("interference-analysis-navigation-link-es_results");
	By ESResultStatus = By.id("EARTH_STATION_RESULTS_FORM-analysis-status");
	By ESEndTime = By.id("afs-parameters-bands[0]-bands[0]status[2]-end-time");
	By caseNumberField = By.id("EARTH_STATION_RESULTS_FORM-caseNumbers");
	By esCaseCount = By.id("EARTH_STATION_RESULTS_FORM-total-case-numbers-count");
	By selectAllESCase = By.id("EARTH_STATION_RESULTS_FORM-select-all");
	By esReports = By.id("EARTH_STATION_RESULTS_FORM-submit");
	By defaultBandParameter = By.id("afs-parameters-bands[0]-band-reset");
	public RunAnalysisPage(WebDriver driver) {
		super(driver);
	}
	/**
	 * This method is to Save the analys on run analysis page
	 */
	public void clickSaveButtonOnRunAnalysisPage() {
		assertTrue("Save button is missing on run analysis page",isDisplayed(SaveAnalysisPage,20));
		click(SaveAnalysisPage);
	}
	/**
	 * This method is to click the run analysis button
	 */

	public void clickAnalysisRunButton() {
		assertTrue("Ananlysis Run page is not displayed", isDisplayed(frequencyWindowField,120));
		click(runAnalysisButton);
		slowDown(4);
	}
	/**
	 * Verify Analysis Completion
	 */
	public void verifyAnaysisCompletion() {
		assertTrue("Ananlysis Run page is not displayed", isDisplayed(frequencyWindowField,120));
		while(getText(endTime).contains("-"))
			slowDown(5);
		slowDown(3);
		assertEquals("Completed",getFieldTextTitle(analysisStatus));
		slowDown(1);
	}
	/**
	 * Verify analysis end time for ES 
	 */
	public void verifyESAnalysisCompletion() {
		
		assertTrue("Ananlysis Run page is not displayed", isDisplayed(frequencyWindowField,120));
		while(getText(ESEndTime).contains("-"))
			slowDown(5);
		slowDown(3);
		assertEquals("Completed",getFieldTextTitle(ESanalysisStatus));
		slowDown(1);
	}
	
	/**
	 * This method verifies elements do no exist for users that do not have edit permissions on AFS Run Analysis page 
	 */
	public void verifyElementsUsersWithoutPermission() {
		assertTrue("Save Button is displayed", !isDisplayed(SaveAnalysisPage,8));
		assertTrue("Run Analysis Button is displayed", !isDisplayed(RunAnalysisButton,8));
	}
	/**
	 * This method is to click default band parameters icon on run analysis page
	 */
	public void clickDefaultBandParametersIconAndValidates() {
		assertTrue("default band button is not displayed", isDisplayed(defaultBandParameter,15));
		String frequencyWindow= getFieldText(frequencyWindowField);
		clear(frequencyWindowField);
		type("55",frequencyWindowField);
		click(defaultBandParameter);
		slowDown(2);
		String defaultfrequencyWindow= getFieldText(frequencyWindowField);
		assertEquals(defaultfrequencyWindow,frequencyWindow);

		
	}

}

