package CommPageObjects;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AntennaDataBasePage extends BasePage {


	public AntennaDataBasePage(WebDriver driver) {
		super(driver);
		visit("/");
	}

	private static final String REQUIRED_ERROR_MESSAGE = "Required.";

	//Path Data Fields - Element is read only and can use getFieldText method
	By antCodeListResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"')]");
	By antDbAntCodeResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-antennaCode')]");
	By antDatabaseExportButton = By.id("antenna-db-search-export");
	By exportMessage = By.id("search-and-select-export-results-warning");
	By blankPage=By.cssSelector("div.ReactModal__Overlay.ReactModal__Overlay--after-open");


	By antDbAntCompanyResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-company')]");
	By antDbAntModelFamilyResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-antennaFamily')]");
	By antDbAntModelResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-modelNumberAndFeedDir')]");
	By antDbAntPolResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-pol')]");
	By antDbAntFreqResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-frequencyRange')]");
	By antDbAntGainResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-gain')]");
	By antDbAnt3dBBWResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-beamwidth')]");
	By antDbAntDiameterResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-diameterMandFt')]");
	By antDbAntComplianceResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-compliance')]");
	By antDbAntRPEResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-rpeNumber')]");
	By antDbAntPatternDateResult = By.xpath("//*[contains(@id, '"+ANTENNA_DB_MODAL+"') and contains(@id, '-patternDate')]");
	By antDbAntStatusResultGreeen = By.cssSelector(".database-search-status-icon.bg-green");
	By antDbAntStatusResultOrange = By.cssSelector(".database-search-status-icon.bg-orange");
	By antDbAntStatusResultRed = By.cssSelector(".database-search-status-icon.bg-red");

	By basicInformationClassification = By.id("antenna-details-classification");

	By antDbbasicInformationAntennaCode = By.id("antenna-details-antenna-code");
	By antDbbasicInformationCompany = By.id("antenna-details-antenna-company");
	By antDbbasicInformationModelFamily = By.id("antenna-details-antenna-model-family");
	By antDbbasicInformationAntennaModel = By.id("antenna-details-antenna-model");
	By antDbbasicInformationClassification = By.id("antenna-details-classification");

	By antDbbasicInformationAssociatedAntennaCode = By.id("antenna-details-associated-antenna-code");
	By antDbbasicInformationPolarized = By.id("antenna-details-polarization");
	By antDbbasicInformationStatus = By.id("antenna-details-status");

	By antDbTechnicalInformationLowFrequency = By.id("antenna-details-low-frequency");
	By antDbTechnicalInformationHighFrequency = By.id("antenna-details-high-frequency");
	By antDbTechnicalInformationMainbeamGain = By.id("antenna-details-main-beam-gain");
	By antDbTechnicalInformationDiameter= By.id("antenna-details-diameter");
	By antDbTechnicalInformation3dBeamwidth = By.id("antenna-details-beamwidth");
	By antDbTechnicalInformationFrontToBackRadio  = By.id("antenna-details-front-to-back");
	By antDbbasicInformationApplication = By.id("antenna-details-antenna-application");
	By antDbbasicInformationFCCCompliance = By.id("antenna-details-antenna-compliance");
	By antDbbasicInformationSubreflectorDiameter = By.id("antenna-details-subreflector-diameter");
	By antDbbasicInformationFeedFlangeDiameter = By.id("antenna-details-feed-flange-diameter");

	By antDbbasicInformationDiameterMeter = By.id("antenna-details-diameterUnit-SI-label-bottom");
	By antDbbasicInformationDiameterFeet = By.id("antenna-details-diameterUnit-US-label-bottom");


	By antDbbasicInformationAntCodeError = By.id("antenna-details-antenna-code-error-message");
	By antDbbasicInformationCompanyError = By.id("antenna-details-antenna-company-error-message");
	By antDbbasicInformationAntModelError = By.id("antenna-details-antenna-model-error-message");
	By antDbbasicInformationClassificationError = By.id("antenna-details-classification-error-message");
	By antDbbasicInformationStatusError = By.id("antenna-details-status-error-message");

	By antDbTechInformationLowFreqError = By.id("antenna-details-low-frequency-error-message");
	By antDbTechInformationHighFreqError = By.id("antenna-details-high-frequency-error-message");
	By antDbTechInformationMainbeamGainError = By.id("antenna-details-main-beam-gain-error-message");
	By antDbTechInformation3DBeamwidthError = By.id("antenna-details-beamwidth-error-message");

	By antDbRegInformationApplicationError = By.id("antenna-details-antenna-application-error-message");
	By errorUniqueAntCodeField = By.id("antenna-details-antenna-code-error-message");
	By errorUniqueAntCode = By.id("antenna-details-antenna-code-error-message");
	By errorLowFrequency = By.id("antenna-details-low-frequency-error-message");
	By errorHighFrequency = By.id("antenna-details-high-frequency-error-message");
	By errorMainbeamGain = By.id("antenna-details-main-beam-gain-error-message");
	By errorDiameter = By.id("antenna-details-diameter-error-message");
	By error3dBeamwidth = By.id("antenna-details-beamwidth-error-message");
	By errorFrontToBackRadio = By.id("antenna-details-front-to-back-error-message");

	By manufaturerFieldSuggestion = By.xpath("//*[contains(@id, 'antenna-details-antenna-company-suggestion-')]");//antenna-details-antenna-company-suggestion-Commscope
	By modelFamilyFieldSuggestion = By.xpath("//*[contains(@id, 'antenna-details-antenna-model-family-suggestion-')]");//antenna-details-antenna-company-suggestion-Commscope
	By modelFamilyFieldSuggestionCommscopeFamily = By.xpath("//*[contains(@id, 'antenna-db-search-antenna-model-family-suggestion-')and contains(text(), 'Commscope')]");//antenna-details-antenna-company-suggestion-Commscope

	//By.xpath( "//li[contains(text(), 'Second')]" )
	//antenna-details-front-to-back-error-message
	By basicInforStatusGreen = By.cssSelector(".database-search-status-icon.margin-left-1.bg-green");
	By basicInforStatusYellow = By.cssSelector(".database-search-status-icon.margin-left-1.bg-yellow");
	By basicInforStatusRed = By.cssSelector(".database-search-status-icon.margin-left-1.bg-red");
	By selMeter = By.id("antenna-details-diameterUnit-SI-label-bottom");
	By selFeet = By.id("antenna-details-diameterUnit-US-label-bottom");
	By modelFamilyFieldError = By.id("antenna-details-antenna-model-error-message");

	//Headings
	By radioImage = By.id("path-details-section-header-radio-icon");

	//Buttons
	By dataBaseManagementButton = By.id("database-management-link");
	By antennaDataBaseLink = By.id("antenna-database-summary-link");
	By antennaPlaceHolder = By.id("antennaDb-modal-heading");
	By createAntButton = By.id("antenna-db-search-create");

	By saveAntenna = By.id("antenna-details-save");
	By associatedAntCodeLookUpButton = By.id("antenna-details-associated-antenna-code-antenna-lookup-trigger");

	By antDbAdvancedDiameterUnitSIButton = By.id("antenna-db-search-create");
	By antDbAdvancedDiameterUnitUSButton = By.id("antenna-db-search-create");

	By antDbCreateButton = By.id("antenna-db-search-create");
	By antCreateButtonInCopyPrompt = By.id("discard-confirmation-modal-discard");
	By antDbSearchButton = By.xpath("//button[@id='antenna-db-search-submit']");

	By antDbExportButton = By.id("antenna-db-search-export");
	By antDbExportButtonDisabled = By.cssSelector(".btn.search-button.big-button.cursor-not-allowed.bg-grey-dark");

	By antDbAntModelLeftRadioDial = By.id("project-summary-settings-unit-Left Feed-label-bottom");
	By antDbAntModelRightRadioDial = By.id("project-summary-settings-unit-Right Feed-label-bottom");
	By antDbAntModelAnyRadioDial = By.id("project-summary-settings-unit-(none)-label-bottom");

	By antDbAdvancedSearchLink = By.xpath("//*[@id=\"antenna-db-search\"]/div[1]/div/label/span");
	By antDbDiscriminationCalcLink = By.id("disc-calc-modal-trigger");
	By antDbDiscriminationCalculateButon=By.id("discrimination-calculator-submit");
	By antDbDiscriminationCalcCloseXButton = By.id("discrimination-calculator-modal-close");
	By antDbDiscriminationAngleField = By.id("discrimination-calculator-discrimination-angle");
	By antDbDiscriminationErrorMessage=By.id("discrimination-calculator-error");

	By createAntennaButton = By.id("antenna-details-save");
	//Drop down options
	//Path Entry Fields - Able to use the type method
	By antDbAntCodeField = By.id("antenna-db-search-antenna-code");
	By antDbAntCompanyField = By.id("antenna-db-search--antenna-company");
	By antDbModelFamilyField = By.id("antenna-db-search-antenna-model-family");
	By antDbAntModelField = By.id("antenna-db-search-antenna-model");
	By antDbFrequencyField = By.id("antenna-db-search-frequency");

	By antDbAdvancedSearchStatusField = By.id("antenna-db-search-status");
	By antDbAdvancedSearchGainField = By.id("antenna-db-search-gain");
	By antDbAdvancedSearchApplicationField = By.id("antenna-db-search-antenna-application");
	By antDbAdvancedSearchDiameterField = By.id("antenna-db-search-diameter");
	By antDbAdvancedSearchRPEField = By.id("antenna-db-search-rpe-number");
	By antDbAdvancedSearchClassificationField = By.id("antenna-db-search-classification");
	By antDbAdvancedSearch3dbBeamwidthField = By.id("antenna-db-search-beam-width");
	By antDbAdvancedSearchFCCComplianceField = By.id("antenna-db-search--antenna-compliance");
	By antDbDiscriminationCalcFieldAngle = By.id("discrimination-calculator-discrimination-angle");
	By lookUpAntennaCode = By.id("antenna-lookup-antenna-code");
	By lookUpSearchButton = By.id("antenna-lookup-submit");
	By antResultListItem = By.xpath("//*[contains(@id, 'antenna-lookup-modal-table-data-antennaCode-') and contains(@id, 'antenna-lookup-modal-table-data-antennaCode-')]");

	By newAntennaCompanyErrorMessage =By.id("antenna-details-antenna-company-error-message");
	By newAntennaModelErrorMessage =By.id("antenna-details-antenna-model-error-message");
	By newAntennaClassificationErrorMessage =By.id("antenna-details-classification-error-message");
	By newAntennaLowFrequencyErrorMessage =By.id("antenna-details-low-frequency-error-message");
	By newAntennaHighFrequencyErrorMessage =By.id("antenna-details-high-frequency-error-message");
	By newAntennaGainErrorMessage =By.id("antenna-details-main-beam-gain-error-message");
	By newAntennaBeamwidthErrorMessage =By.id("antenna-details-beamwidth-error-message");
	By newAntennaComplianceErrorMessage =By.id("antenna-details-antenna-compliance-error-message");

	By copyPatterns = By.cssSelector(".fa.fa-files-o");
	By commentsIcon = By.id("antenna-details-new-comment-modal-toggle");
	By commentsField = By.id("db-details-comments-comment");
	By saveCommentsButton = By.xpath(".//*[@id='db-details-comments']/div[2]/button");
	By commentsListItem = By.xpath("//*[contains(@id, 'antenna-details-comments-table-data-antennaSpecCommentId-') and contains(@id, '-attachments')]");
	By firstAntField = By.id ("antenna-details-patterns[VV][0]-angle");
	By secondAntField = By.id ("antenna-details-patterns[VV][1]-angle");
	By thirdAntField = By.id ("antenna-details-patterns[VV][2]-angle");
	By fourthAntField = By.id ("antenna-details-patterns[VV][3]-angle");
	By fifthAntField = By.id ("antenna-details-patterns[VV][4]-angle");
	By sixthAntField = By.id ("antenna-details-patterns[VV][5]-angle");


	By firstDiscriminationField = By.id ("antenna-details-patterns[VV][0]-discrimination");
	By secondDiscriminationField = By.id ("antenna-details-patterns[VV][1]-discrimination");
	By thirdDiscriminationField = By.id ("antenna-details-patterns[VV][2]-discrimination");
	By fourthDiscriminationField = By.id ("antenna-details-patterns[VV][3]-discrimination");
	By fifthDiscriminationField = By.id ("antenna-details-patterns[VV][4]-discrimination");
	By sixthDiscriminationField = By.id ("antenna-details-patterns[VV][5]-discrimination");

	By deletePaternButton = By.cssSelector(".btn.btn-sm.hover-inverse.bg-white.btn-border.text-blue-dark");
	By angleFieldValue = By.xpath("//*[contains(@id, 'antenna-details-patterns[VV][') and contains(@id, ']-angle')]");
	By discriminationFieldValue = By.xpath("//*[contains(@id, 'antenna-details-patterns[VV][') and contains(@id, ']-discrimination')]");
	By flipPatternButton = By.id("antenna-details-footer-flip");
	By flipWarning= By.className("padding-left-half");
	By flipWarningButton= By.cssSelector(".btn.btn-md.bg-blue.margin-top-1.heading-font.hover-inverse.display-inline-block");

	By commentRow = By.xpath("//*[contains(@id, 'antenna-details-comments-table-data-antennaSpecCommentId-') and contains(@id, '-comment')]");
	By fileLocation = By.xpath("//*[@id=\"db-details-comments\"]/div[2]/div/div/input");
	By dropareaa = By.xpath("//*[@id=\"db-details-comments\"]/div[2]/div/div/input");
	By attachmentRow1 = By.xpath("//*[contains(@id, 'antenna-details-comments-table-data-antennaSpecCommentId-') and contains(@id,'-attachments')]");
	By attachmentRow0 = By.xpath("//*[contains(@id, 'antenna-details-comments-table-data-antennaSpecCommentId-') and contains(@id,'-attachments-0')]");
	By attachmentRows = By.xpath("//*[contains(@id, 'antenna-details-comments-table-data-antennaSpecCommentId-') and contains(@id,'-attachments')]");
	By attachmentRow2 = By.cssSelector(".drop-zone-list > dd:nth-child(3)");
	By deleteAttachmentComment=By.cssSelector(".fa.fa-times-circle-o.margin-left-half.pointer.text-red");
	//By deletecommentConfirmation=By.linkText("Confirm");
	By deletecommentConfirmation = By.xpath("//button[contains(text(),'Confirm')]");

	By deleteCommentnotificationMessage=By.cssSelector(".notification-message");
	By closeCommentsButton = By.cssSelector("h4.display-flex > span:nth-child(3)");

	//Manufacturer autosuggest
	By manufacturerAutoSuggest = By.cssSelector(".react-autosuggest__suggestions-list");
	By manufacturerAutoSuggestList = By.xpath("//*[contains(@id, 'antenna-db-search--antenna-company-suggestion-')]");
	By antennaReferenceCodeInAntennaDetails=By.id("antenna-details-rpe-code");
	By returnButtonOnAntennaDetails=By.id("antenna-details-close-form");
	By antDbAdvancedSearchRefCode = By.id("antenna-db-search-reference-code");

	//Antenna model Family
	By addModelFamilyIcon=By.id("antenna-details-new-model-family-trigger");
	By newModelFamilyNameField=By.id("new-model-family-antenna-company");
	By savedAntennaModelFamilies = By.xpath("//*[contains(@id, 'react-autowhatever-new-model-family-antenna-company--item-')]");
	//By saveNewModelFamily = By.cssSelector(".btn.btn-sm.bg-green.hover-inverse");
	By saveNewModelFamily = By.xpath("//div[3]/button");

	By modelFamilyErrorMessage =By.id("new-model-family-antenna-company-error-message");
	By copyAntennaDbButton = By.id("antenna-details-copy");
	By copyNewAntennaCode = By.id("copy-new-antenna-new-code");
	By copyNewAntennaCodeErrorMessage = By.id("copy-new-antenna-new-code-error-message");
	By antennaDelete= By.id("antenna-details-delete");
	By antennaDeleteConfirmation= By.id("delete-confirmation-modal-delete");
	By antennaDeleteMessage= By.id("delete-success-modal-heading");
	By copySuccess =  By.id("success-modal-message");
	//Role Selector Page

	By databaseUnchecked = By.cssSelector("#app > div > main > div > div > h3:nth-child(2) > i");
	By roleSelectField = By.className("margin-left-half");

	By readOnly =By.id("antenna-details-antenna-code");

	//Antenna search Results

	By antennaSearchResults =By.xpath("//*[contains(@id, 'antennaDb-modal-table-data-antennaCode-') and contains(@id, '-antennaCode')]");

	//pattern info Fields
	By rpeDate=By.id("antenna-details-rpe-date");
	By rpeField=By.id("antenna-details-rpe");
	By referenceCodeField=By.id("antenna-details-rpe-code");
	By referenceCodeLookupICon=By.id("antenna-details-rpe-code-antenna-lookup-trigger");
	By antennaRPEDateErrorMessage=By.id("antenna-details-rpe-date-error-message");
	By antennaReferenceCodeErrorMessage=By.id("antenna-details-rpe-code-error-message");
	By antennaRPEErrorMessage=By.id("antenna-details-rpe-error-message");

	By antennaLink = By.id("home-cta-database-management-antenna");

	By discriminationVV=By.id(ANTENNA_DISCRIMINATION_TEXT+"VV");
	By discriminationVH=By.id(ANTENNA_DISCRIMINATION_TEXT+"VH");
	By discriminationHH=By.id(ANTENNA_DISCRIMINATION_TEXT+"HH");
	By discriminationHV=By.id(ANTENNA_DISCRIMINATION_TEXT+"HV");
	By gainVV=By.id(ANTENNA_DISCRIMINATION_GAIN__TEXT+"VV");
	By gainVH=By.id(ANTENNA_DISCRIMINATION_GAIN__TEXT+"VH");
	By gainHH=By.id(ANTENNA_DISCRIMINATION_GAIN__TEXT+"HH");
	By gainHV=By.id(ANTENNA_DISCRIMINATION_GAIN__TEXT+"HV");
	By logoutMenu=By.id("header-user-menu-trigger");
	By logout =By.id("user-menu-logout");
	By discriminationCalculatorVVDiscriminationResult= By.id("discrimination-calculator-results-disc-VV");
	By discriminationCalculatorVVGainResult= By.id("discrimination-calculator-results-gain-VV");

	By antennaUpdateMessage = By.id("success-modal-heading");

	By antennaReturnButtonInAntennaDetailsPage =  By.id("antenna-details-close-form");
	By leaveWithoutSavingConfirmButton= By.id("discard-confirmation-modal-discard");
	By discriminationCalculatorCloseButton = By.id("discrimination-calculator-modal-close");

	By createAntennaButtonInCopyAntennaModel= By.id("discard-confirmation-modal-discard");
	By copySuccessMessage=By.cssSelector(".center-text.uppercase.padding-half");
	By patternVVButton = By.id("antenna-details-patterns-VV-label-bottom");
	By patternVVFirstAngleValue =By.id("antenna-details-patterns[VV][0]-angle");

	By clearVV= By.xpath("//div[@id='app']/div/div/div/form/div[2]/div[3]/div[2]/div/footer/p");
	By vvPatternErrorMessage =By.xpath(".//*[@id='app']/div/div[1]/div/form/p");

	By antennaBeamWidth =By.id("antenna-details-fifteen-beamwidth");


	By paginationPageDropDown = By.id("antenna-db-search-pagination");
	By paginationPageCount = By.id("antenna-db-search-pagination-page-count");

	/**
	 * Verifies the Antenna Page availability
	 */
	public void verifyAntennaPageReadOnly(){
		assertTrue("Antenna details page is not read only and its not displayed",isDisplayed(readOnly,9));
	}


	public void evaluateCreateButtonIsNotPresentAndExprortIsDisabled(){
		slowDown(1);
		assertTrue("Antenna create button is present", waitUntilNotPresent(createAntButton,5));
		assertTrue("Antenna search button is missing", isDisplayed(antDbSearchButton,5));
		assertTrue("Issue with export button", isDisplayed(antDbExportButtonDisabled,5));
	}

	public void evaluateCreateButtonIsNotPresent(){
		slowDown(1);
		assertTrue("Create Butoon is present in the Antenna Database page", waitUntilNotPresent(createAntButton,5));
		assertTrue("Search button is missing in the antenna database page", isDisplayed(antDbSearchButton,5));
		assertTrue("Export button is missing in the antenna database page", isDisplayed(antDbExportButton,5));
	}

	public void evaluateCreateButtonIsPresent(){
		slowDown(1);
		assertTrue(isDisplayed(createAntButton,5));
		isDisplayed(antDbSearchButton,5);
		isDisplayed(antDbExportButton,5);
	}

	public void selectDesiredRole(String roleSelection){
		selectFromDropdown(roleSelectField,roleSelection);
		assertTrue(isDisplayed(databaseUnchecked,16));
	}

	/**
	 * compares the comment field value to whats passed via the commentText parameter
	 * @param commentText
	 */
	public void evaluateComment(String commentText) {
		isDisplayed(commentsField,19);
		String commentsFieldValue = getFieldText(commentsField);
		assertEquals(commentsFieldValue, commentText);
	}


	/**
	 * Method clicks the copy Antenna button
	 */
	public void copyAntenna(){
		assertTrue(isDisplayed(copyAntennaDbButton,15));
		slowDown(2);
		click(copyAntennaDbButton);
		slowDown(1);
	}
	/**
	 * Method clicks create antenna button 
	 */
	public void clickCreateAntennaButton() {
		assertTrue("Create antenna button is missing",isDisplayed(antDbCreateButton ,45));
		click(antDbCreateButton );
		slowDown(1);
	}
	public void clickCreateAntennaButtonInCopyPrompt() {
		assertTrue("Create antenna button in copy prompt is missing",isDisplayed(antCreateButtonInCopyPrompt ,45));
		click(antCreateButtonInCopyPrompt );
		slowDown(2);
	}

	/**
	 *
	 * @param row
	 * @param attachmentName
	 */
	public void evaluateAttachmentList(int row,String attachmentName){
		String attachmentText = getTextPlural(attachmentRow1,row);
		assertEquals(attachmentText,attachmentName);
	}
	/**
	 * This method checks the new added and saved attachment is added to the end of the list in the comments section
	 * @param attachmentName
	 */
	public void evaluateAttachmentListEnd(String attachmentName){

		int rowEnd = finds(attachmentRows).size()-1;
		String attachmentText = getText(attachmentRow0);
		assertEquals(attachmentText,attachmentName);
	}

	public void evaluateAttachmentList2(int row,String attachmentName){
		String attachmentText = getTextPlural(attachmentRow2,row);
		assertEquals(attachmentText,attachmentName);
	}

	public void dragAndDropFile(){
		// locate the drop area
		isDisplayed(dropareaa,30);
		WebElement droparea = find(dropareaa);

		String filename = "some-filecopy.txt";
		File file = new File(filename);
		String path = file.getAbsolutePath();

		// drop the file
		DropFile(new File(path), droparea, 0, 0);
	}

	public void selectAndUploadFile(String fileName){
		uploadFile(fileName, fileLocation, saveCommentsButton);
	}

	public void selectAndUploadFiles(String fileName){
		uploadFileMulti(fileName, fileLocation, saveCommentsButton);
	}
	/**
	 * This method takes in a string to compare the comment to the actual comment field value
	 * @param CommentTitle
	 */
	public void evaluateComments(String CommentTitle){
		assertTrue(isDisplayed(commentRow,1));
		isDisplayedArray(commentRow,1);
		String comment = getText(commentRow);
		assertEquals(CommentTitle, comment);
	}

	/**
	 * This method will flip the pattern and interact with the warning message
	 */
	public void submitFlipPattern(){
		assertTrue(isDisplayed(flipPatternButton,5));
		clickJS(flipPatternButton);
		assertTrue(isDisplayed(flipWarning,15));
		assertTrue(isDisplayed(flipWarningButton,5));
		clickJS(flipWarningButton);
	}

	/**
	 * Takes an integer that selects the row, also discrimination and angle string values for comparison to actual field values
	 * @param patRow
	 * @param angle
	 * @param discrimination
	 */
	public void evaluatePattern(int patRow, String angle, String discrimination){
		String angleVal = getFieldTextPlural(angleFieldValue, patRow);
		String discriminationVal = getFieldTextPlural(discriminationFieldValue, patRow);

		assertEquals(angle, angleVal);
		assertEquals(discrimination,discriminationVal);

	}


	/**
	 * Opens the comments tool
	 */
	public void openComments(){
		assertTrue("Comments icon is missing",isDisplayed(commentsIcon,20));
		click(commentsIcon);
		assertTrue(isDisplayed(commentsField,10));
		slowDown(2);
	}

	/**
	 * Takes the copied pattern (String)and enters it into the given location
	 * @param pattern
	 */
	public void enterPaternInComments(String pattern) throws HeadlessException{
		assertTrue(isDisplayed(commentsField,10));
		type(pattern,commentsField);
		
	}

	/**
	 * copies a given pattern into systems clipboard
	 */
	public void copyPatternText(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		clipboard.setContents(new StringSelection(find(commentsField).getAttribute("value")), null);
	}

	/**
	 * Save the comment
	 */
	public void saveComments(){
		assertTrue(isDisplayed(saveCommentsButton,20));
		click(saveCommentsButton);
		//  assertTrue(isDisplayed(commentsListItem));
	}

	public void evaluateCommentPresence(){
		assertTrue(isDisplayed(commentsListItem));
	}

	public void closeCommentsWithX(){
		assertTrue(isDisplayed(closeCommentsButton,20));
		click(closeCommentsButton);
		//assertTrue(isDisplayed(commentsListItem));
	}

	/**
	 * selects the copy button
	 */
	public void copyPattern(){
		assertTrue(isDisplayed(copyPatterns,40));
		clickJS(copyPatterns);
		slowDown(2);
	}

	/**
	 * Highlights the first cell and pastes the pattern
	 */
	public void pastePattern(){
		pasteText(firstAntField);
	}

	/**
	 * Selects the resulting Antenna row
	 * @param row
	 */
	public void selectAntennaRow(int row){
		assertTrue("Antenna search results not displayed",isDisplayed(antCodeListResult,20));
		slowDown(2);
		clickJS(antCodeListResult,row);
		slowDown(2);
		assertTrue("Antenna details page is missing",isDisplayed(readOnly,15));
		slowDown(2);
	}

	/**
	 * clears the content of a pattern
	 */
	public void clearPattern(){
		slowDown(2);
		clickJS(deletePaternButton);
		slowDown(2);
	}

	public void selectPolarizedEntryFromAntennaDatabase(String antPolarizedText){
		selectFromDropdown(antDbbasicInformationPolarized,antPolarizedText);
	}

	/**
	 * validates associated antenna text
	 * @param antCodeTextA
	 * @param antCodeTextB
	 */
	public void associateAntennaCode(String antCodeTextA, String antCodeTextB ){
		isDisplayed(antDbbasicInformationAntennaCode,30);
		clear(antDbbasicInformationAntennaCode);
		type(antCodeTextA,antDbbasicInformationAntennaCode);
		clear(antDbbasicInformationAntennaCode);
		clear(antDbbasicInformationAssociatedAntennaCode);
		clickJS(associatedAntCodeLookUpButton);
		isDisplayed(lookUpAntennaCode,6);
		clear(lookUpAntennaCode);
		type(antCodeTextB,lookUpAntennaCode);
		clickJS(lookUpSearchButton);
		isDisplayed(antResultListItem,8);
		clickJS(antResultListItem);
	}



	public void evaluateFieldValue(String field){
		String fieldValue = getFieldText(antDbbasicInformationClassification);
		assertEquals(field,fieldValue);
	}

	public void evaluateAntennaDatabaseModelFamilyError(String err){
		type("1",antDbTechnicalInformationLowFrequency);
		clickJS(antDbTechnicalInformationLowFrequency);
		assertTrue(isDisplayed(modelFamilyFieldError,5));
		String getErr = getText(modelFamilyFieldError);
		assertEquals(err,getErr);
	}


	public void submitModelFamilyAntennaDatabaseEntry(String antModFamText){
		isDisplayed(antDbbasicInformationAntennaModel,20);
		type(antModFamText, antDbbasicInformationAntennaModel);
		click(antDbbasicInformationCompany);

	}

	public void evaluateModelFamilySuggestionListDatabaseBasicInformation(String antModelFamilyText, String isModelFamilySuggestion){
		slowDown(2);
		isDisplayed(antDbbasicInformationAntennaCode,20);
		clear(antDbbasicInformationModelFamily);
		clear(antDbbasicInformationModelFamily);
		waitForFieldText("",antDbbasicInformationModelFamily);
		type(antModelFamilyText, antDbbasicInformationModelFamily);
		slowDown(3);
		isDisplayed(modelFamilyFieldSuggestion,20);
		String getSuggestion = getText(modelFamilyFieldSuggestion);
		assertEquals(getSuggestion, isModelFamilySuggestion);
	}

	public void evaluateAntennaManufacturerSuggestionDatabaseBasicInformation(String antManufacturerText, String isManufacturerSuggestion){
		isDisplayed(antDbbasicInformationAntennaCode,20);
		clear(antDbbasicInformationCompany);
		type(antManufacturerText, antDbbasicInformationCompany);
		String getSuggestion = getText(manufaturerFieldSuggestion);//antenna-details-antenna-company-suggestion-Commscope
		assertEquals(getSuggestion, isManufacturerSuggestion);
	}

	public void enterDiscriminationAngle(String discriminationAngleValue){
		assertTrue("antDbDiscriminationCalcLink did not appear",isDisplayed(antDbDiscriminationCalcLink,30));
		clickJS(antDbDiscriminationCalcLink);
		slowDown(2);
		typeDisciminationAngleInCalculator(discriminationAngleValue);
		// DealWithTheAlert();
	}
	public void typeDisciminationAngleInCalculator( String discriminationAngleValue) {
		assertTrue("antenna Discrimination Calculator did not appear",isDisplayed(antDbDiscriminationCalcFieldAngle,10));
		type(discriminationAngleValue,antDbDiscriminationCalcFieldAngle);
		slowDown(1);
		click(antDbDiscriminationCalculateButon);
		slowDown(2);
	}
	public void closeDiscriminationAngleForm(){
		assertTrue(isDisplayed(antDbDiscriminationCalcCloseXButton,6));
		clickJS(antDbDiscriminationCalcCloseXButton,0);
		waitUntilNotPresent(antDbDiscriminationCalcCloseXButton,10);

	};
	public void changeDiameterMeter(){
		isDisplayed(selMeter,3);//antenna-details-diameter-unit-SI-label-bottom
		click(selMeter);
	}
	public void checkDiameterMeter(String diameter){
		isDisplayed(antDbTechnicalInformationDiameter,3);
		String informationDiameterTxt = getFieldText(antDbTechnicalInformationDiameter);
		assertEquals(diameter,informationDiameterTxt);
	}

	public void changeDiameterFeet(){
		isDisplayed(selFeet,3);
		click(selFeet);
	}

	public void changeStatusGreen() {
		isDisplayed(basicInforStatusGreen, 3);
	}

	public void changeStatusYellow(){
		isDisplayed(basicInforStatusYellow,3);//database-search-status-icon margin-left-1 bg-yellow
	}

	public void changeStatusred(){
		isDisplayed(basicInforStatusRed,3);//database-search-status-icon margin-left-1 bg-red
	}

	/**
	 * Method allows the passing of error literals and compares them to form errors on the Tech information section
	 * @param errLowFrequencyTxt
	 * @param errHighFrequencyTxt
	 * @param errMainbeamGainTxt
	 * @param errDiameterTxt
	 * @param err3dBeamwidthTxt
	 * @param errFrontToBackRadioTxt
	 */
	public void evaluateErrorTextOnTechnicalInformation(String errLowFrequencyTxt, String errHighFrequencyTxt, String errMainbeamGainTxt, String errDiameterTxt, String err3dBeamwidthTxt, String errFrontToBackRadioTxt){
		isDisplayed(errorLowFrequency,7);
		String errLowFrequencyTxtMsg = getText(errorLowFrequency);
		String errHighFrequencyTxtMsg = getText(errorHighFrequency);
		String errMainbeamGainTxtMsg = getText(errorMainbeamGain);
		String errDiameterTxtMsg = getText(errorDiameter);
		String err3dBeamwidthTxtMsg = getText(error3dBeamwidth);
		String errFrontToBackRadioTxtMsg = getText(errorFrontToBackRadio);

		assertEquals(errLowFrequencyTxtMsg,errLowFrequencyTxt);
		assertEquals(errHighFrequencyTxtMsg,errHighFrequencyTxt);
		assertEquals(errMainbeamGainTxtMsg,errMainbeamGainTxt);
		assertEquals(errDiameterTxtMsg,errDiameterTxt);
		assertEquals(err3dBeamwidthTxtMsg,err3dBeamwidthTxt);
		assertEquals(errFrontToBackRadioTxtMsg,errFrontToBackRadioTxt);
	}

	/**
	 * Method allows the passing of error literals and compares it to form errors on the Antenna Code field

	 * @param errTxt
	 */
	public void evaluateErrorUniqueness(String errTxt){
		slowDown(2);
		assertTrue("Antenna error message is missing",isDisplayed(errorUniqueAntCode,50));
		assertEquals(getText(errorUniqueAntCode),errTxt);
	}

	/**
	 * Method is designed to click away from a field to allow blurring
	 */
	public void blurAntennaDatabase(){
		isDisplayed(antDbTechnicalInformationLowFrequency,10);
		click(antDbTechnicalInformationLowFrequency);
		slowDown(3);
	}

	/**
	 * Method is designed to click away from a field to allow blurring
	 */
	public void blurTechAntennaDatabase(){
		isDisplayed(antDbbasicInformationCompany,10);
		click(antDbbasicInformationCompany);
	}

	/**
	 * Method enterstext into earth station fields by passing strings  via parameters
	 * @param antDbbasicInformationSubreflectorText
	 * @param antDbbasicInformationFeedFlangeText
	 */
	public void enterAntennaDatabaseEarthStationFieldValues(String antDbbasicInformationSubreflectorText, String antDbbasicInformationFeedFlangeText){
		isDisplayed(antDbbasicInformationSubreflectorDiameter,20);
		type(antDbbasicInformationSubreflectorText,antDbbasicInformationSubreflectorDiameter);
		type(antDbbasicInformationFeedFlangeText,antDbbasicInformationFeedFlangeDiameter);
	}

	/**
	 * Method enters text into Reg Infomation fields by passing strings  via parameters
	 * @param regInfoApplicationText
	 * @param regInfoFCCComplianceText
	 */
	public void enterAntennaDatabaseRegInformationEntry(String regInfoApplicationText, String regInfoFCCComplianceText){
		isDisplayed(antDbbasicInformationAntennaCode,20);
		type(regInfoApplicationText,antDbbasicInformationApplication);
		type(regInfoFCCComplianceText,antDbbasicInformationFCCCompliance);
	}
	/**
	 * This method is to enter basic pattern point
	 * @param angle1
	 * @param angle2
	 * @param angle3
	 * @param disc1
	 * @param disc2
	 * @param disc3
	 */
	public void enterPatternPoints(String angle1, String angle2, String angle3, String disc1, String disc2, String disc3) {
		type(angle1,firstAntField);
		type(angle2,secondAntField);
		type(angle3,thirdAntField);
		type(disc1,firstDiscriminationField);
		type(disc2,secondDiscriminationField);
		type(disc3,thirdDiscriminationField);

	}
	public void enterPatternPoints(String angle1, String angle2, String angle3,String angle4, String angle5,String angle6, String disc1, String disc2, String disc3, String disc4, String disc5, String disc6) {
		type(angle1,firstAntField);
		type(angle2,secondAntField);
		type(angle3,thirdAntField);
		type(angle4,fourthAntField);
		type(angle5,fifthAntField);
		type(angle6,sixthAntField);
		type(disc1,firstDiscriminationField);
		type(disc2,secondDiscriminationField);
		type(disc3,thirdDiscriminationField);
		type(disc4,fourthDiscriminationField);
		type(disc5,fifthDiscriminationField);
		type(disc6,sixthDiscriminationField);

	}
	/**
	 * This method is to click create antenna button
	 */
	public void clickAntennaButton() {
		assertTrue("Create Antenna button is missing in antenna details page", isDisplayed(createAntennaButton,30));
		click(createAntennaButton);
		slowDown(2);
	}

	/**
	 * Method enters text into Tech Infomation fields by passing strings via parameters
	 * @param techInfoLowFreqText
	 * @param techInfoHighFreqText
	 * @param techInfoMainbeamGainText
	 * @param techInfoDiameterText
	 * @param techInfo3dBeamwidthText
	 * @param techInfoFrontToBackRadioText
	 */
	public void enterAntennaDatabTechnicalInformationEntry(String techInfoLowFreqText, String techInfoHighFreqText, String techInfoMainbeamGainText, String techInfoDiameterText, String techInfo3dBeamwidthText, String techInfoFrontToBackRadioText ){
		isDisplayed(antDbbasicInformationAntennaCode,20);
		type(techInfoLowFreqText,antDbTechnicalInformationLowFrequency);
		type(techInfoHighFreqText,antDbTechnicalInformationHighFrequency);
		type(techInfoMainbeamGainText,antDbTechnicalInformationMainbeamGain);
		type(techInfoDiameterText,antDbTechnicalInformationDiameter);
		type(techInfo3dBeamwidthText,antDbTechnicalInformation3dBeamwidth);
		type(techInfoFrontToBackRadioText,antDbTechnicalInformationFrontToBackRadio);
	}

	/**
	 * Method clicks the dropdown form the field and selects the item passed via parameter
	 * @param antStatusText
	 */
	public void selectAntennaDatabaseBasicInformationChangeStatus(String antStatusText){
		isDisplayed(antDbbasicInformationAntennaCode,20);
		selectFromDropdown(antDbbasicInformationStatus,antStatusText);

	}

	/**
	 * Method enters text into Basic Infomation fields by passing strings via parameters
	 * @param antCodeText
	 * @param antCompanyText
	 * @param antModFamText
	 * @param antModText
	 * @param antClassificationText
	 * @param antAssociatedAntennaCodeText
	 * @param antPolarizedText
	 * @param antStatusText
	 */
	public void enterAntennaDatabaseBasicInformationEntry(String antCodeText, String antCompanyText, String antModFamText, String antModText, String antClassificationText, String antAssociatedAntennaCodeText, String antPolarizedText, String antStatusText){
		isDisplayed(antDbbasicInformationAntennaCode,20);
		clear( antDbbasicInformationAntennaCode);
		clear( antDbbasicInformationCompany);
		clear( antDbbasicInformationModelFamily);
		clear( antDbbasicInformationAntennaModel);
		type(antCodeText, antDbbasicInformationAntennaCode);
		type(antCompanyText, antDbbasicInformationCompany);
		type(antModFamText, antDbbasicInformationModelFamily);
		type(antModText, antDbbasicInformationAntennaModel);
		selectFromDropdown(antDbbasicInformationClassification,antClassificationText);
		type(antAssociatedAntennaCodeText, antDbbasicInformationAssociatedAntennaCode);
		selectFromDropdown(antDbbasicInformationPolarized,antPolarizedText);
		selectFromDropdown(antDbbasicInformationStatus,antStatusText);
	}
	/**
	 * Method enters text into Basic Infomation fields by passing strings via parameters
	 * @param antCompanyText
	 * @param antModFamText
	 * @param antModText
	 * @param antClassificationText
	 * @param antAssociatedAntennaCodeText
	 * @param antPolarizedText
	 * @param antStatusText
	 */
	public void enterAntennaDatabaseBasicInformationEntryWithoutAntennaCode(String antCompanyText, String antModFamText, String antModText, String antClassificationText, String antAssociatedAntennaCodeText, String antPolarizedText, String antStatusText){
		isDisplayed(antDbbasicInformationAntennaCode,20);
		clear( antDbbasicInformationCompany);
		clear( antDbbasicInformationModelFamily);
		clear( antDbbasicInformationAntennaModel);
		type(antCompanyText, antDbbasicInformationCompany);
		type(antModFamText, antDbbasicInformationModelFamily);
		type(antModText, antDbbasicInformationAntennaModel);
		selectFromDropdown(antDbbasicInformationClassification,antClassificationText);
		type(antAssociatedAntennaCodeText, antDbbasicInformationAssociatedAntennaCode);
		selectFromDropdown(antDbbasicInformationPolarized,antPolarizedText);
		selectFromDropdown(antDbbasicInformationStatus,antStatusText);
	}

	public void saveCreatedAntenna(){
		isDisplayed(saveAntenna,6);
		click(saveAntenna);
	}

	/**
	 * This method verifies if an error is present
	 */
	public void evaluateAntennaCodeError(){
		assertTrue(isDisplayed(antDbbasicInformationAntCodeError,5));
	}
	/**
	 * This method verifies if an error is present
	 */
	public void evaluateAntennaCompanyError(){
		assertTrue(isDisplayed(antDbbasicInformationCompanyError,5));
	}
	/**
	 * This method verifies if an error is present
	 */
	public void evaluateAntennaModelError(){
		assertTrue(isDisplayed(antDbbasicInformationAntModelError,5));
	}
	/**
	 * This method verifies if an error is present
	 */
	public void evaluateAntennaClassificationError(){
		assertTrue(isDisplayed(antDbbasicInformationClassificationError,5));
	}
	/**
	 * This method verifies if an error is present
	 */
	public void evaluateAntennaStatusError(){
		slowDown(1);
		assertTrue(isDisplayed(antDbbasicInformationStatusError,5));
	}
	/**
	 * This method verifies if an error is present
	 */
	public void createAntLoFreqError(){
		assertTrue(isDisplayed(antDbTechInformationLowFreqError,5));
	}
	/**
	 * This method verifies if an error is present
	 */
	public void createAntHiFreqError(){
		assertTrue(isDisplayed(antDbTechInformationHighFreqError,5));
	}
	/**
	 * This method verifies if an error is present
	 */
	public void createAntMainbeamGainError(){
		assertTrue(isDisplayed(antDbTechInformationMainbeamGainError,5));
	}
	/**
	 * This method verifies if an error is present
	 */
	public void createAnt3DBeamwidthError(){
		assertTrue(isDisplayed(antDbTechInformation3DBeamwidthError,5));
	}

	/**
	 * This method verifies if an error is present
	 */
	public void createAntApplicationError(){
		assertTrue(isDisplayed(antDbRegInformationApplicationError,5));
	}




	/**
	 * This method clicks the Create Antenna button
	 */
	public void createAnt(){
		isDisplayed(createAntButton,6);
		clickJS(createAntButton);
	}


	/**
	 * Method takes in strings via parameters and compares text to field values
	 * @param regInfoApplicationText
	 * @param regInfoFCCComplianceText
	 */
	public void antDbEarthStationVal(String regInfoApplicationText, String regInfoFCCComplianceText){
		isDisplayed(antDbbasicInformationSubreflectorDiameter,20);

		String earthStationSubreflectorDiameter = getFieldText(antDbbasicInformationSubreflectorDiameter);
		String earthStationFeedFlangeDiameter = getFieldText(antDbbasicInformationFeedFlangeDiameter);

		assertEquals(regInfoApplicationText,earthStationSubreflectorDiameter);
		assertEquals(regInfoFCCComplianceText,earthStationFeedFlangeDiameter);
	}


	/**
	 * Method takes in strings via parameters and compares text to field values
	 * @param regInfoApplicationText
	 * @param regInfoFCCComplianceText
	 */
	public void evaluateAntennaDatabaseRegInformation(String regInfoApplicationText, String regInfoFCCComplianceText){
		isDisplayed(antDbbasicInformationAntennaCode,20);

		String regInfoApplication = getFieldText(antDbbasicInformationApplication);
		String regInfoFCCCompliance = getFieldText(antDbbasicInformationFCCCompliance);

		if(firefox.equals("firefox")){
			//TODO FIX DROPDOWNS
		}else {
			assertEquals(regInfoApplicationText,regInfoApplication);
			assertEquals(regInfoFCCComplianceText,regInfoFCCCompliance);
		}
	}

	/**
	 * Method takes in strings via parameters and compares text to field values
	 *
	 * @param techInfoLowFreqText
	 * @param techInfoHighFreqText
	 * @param techInfoMainbeamGainText
	 * @param techInfoDiameterText
	 * @param techInfo3dBeamwidthText
	 * @param techInfoFrontToBackRadioText
	 */
	public void evaluateAntennaDatabaseTechecnicalInformation(String techInfoLowFreqText, String techInfoHighFreqText, String techInfoMainbeamGainText, String techInfoDiameterText, String techInfo3dBeamwidthText, String techInfoFrontToBackRadioText ){
		isDisplayed(antDbbasicInformationAntennaCode,20);

		String techInfoLowFrequency = getFieldText(antDbTechnicalInformationLowFrequency);
		String techInfoHighFrequency = getFieldText(antDbTechnicalInformationHighFrequency);
		String techInfoMainbeamGain = getFieldText(antDbTechnicalInformationMainbeamGain);
		String techInfoDiameter = getFieldText(antDbTechnicalInformationDiameter);
		String techInfo3dBeamwidth = getFieldText(antDbTechnicalInformation3dBeamwidth);
		String techInfoFrontToBackRadio = getFieldText(antDbTechnicalInformationFrontToBackRadio);

		assertEquals(techInfoLowFreqText,techInfoLowFrequency);
		assertEquals(techInfoHighFreqText,techInfoHighFrequency);
		assertEquals(techInfoMainbeamGainText,techInfoMainbeamGain);
		assertEquals(techInfoDiameterText,techInfoDiameter);
		assertEquals(techInfo3dBeamwidthText,techInfo3dBeamwidth);
		assertEquals(techInfoFrontToBackRadioText,techInfoFrontToBackRadio);
	}


	/**
	 *      * Method takes in strings via parameters and compares text to field values
	 * @param antCodeText
	 * @param antCompanyText
	 * @param antModFamText
	 * @param antModText
	 * @param antClassificationText
	 * @param antAssociatedAntennaCodeText
	 * @param antPolarizedText
	 * @param antStatusText
	 */
	public void antDbBasicInfoVal(String antCodeText, String antCompanyText, String antModFamText, String antModText, String antClassificationText, String antAssociatedAntennaCodeText, String antPolarizedText, String antStatusText){
		isDisplayed(antDbbasicInformationAntennaCode,20);
		String antCode = getFieldText(antDbbasicInformationAntennaCode);
		String antCompany = getFieldText(antDbbasicInformationCompany);
		String antModFam = getFieldText(antDbbasicInformationModelFamily);
		String antMod = getFieldText(antDbbasicInformationAntennaModel);
		String antClassification = getFieldText(antDbbasicInformationClassification);
		String antAssociatedAntennaCode = getFieldText(antDbbasicInformationAssociatedAntennaCode);
		String antPolarized = getFieldText(antDbbasicInformationPolarized);
		String antStatus= getFieldText(antDbbasicInformationStatus);

		assertEquals(antCode,antCodeText);
		assertEquals(antCompany,antCompanyText);
		assertEquals(antModFam,antModFamText);
		assertEquals(antMod,antModText);
		assertEquals(antClassification,antClassificationText);
		assertEquals(antAssociatedAntennaCode,antAssociatedAntennaCodeText);
		assertEquals(antPolarized,antPolarizedText);
		assertEquals(antStatus,antStatusText);
	}

	/**
	 * Method clicks the export button
	 */
	public void export(){
		isDisplayed(antDbExportButton,20);
		clickJS(antDbExportButton);
		slowDown(2);
	}

	/**
	 * Method clears the Diameter field
	 */
	public void clearDiameter(){
		clear(antDbAdvancedSearchDiameterField);
		slowDown(2);
		clear(antDbAdvancedSearchDiameterField);
	}

	/**
	 * Method compares RPE to string passed via parameter
	 * @param rpeNumber
	 */
	public void RPEVal(String rpeNumber){
		isDisplayed(antDbAntRPEResult,5);
		String rPE = getText(antDbAntRPEResult);
		assertEquals(rPE,rpeNumber);
	}

	/**
	 * Compares field value to the text being passed via  parameter
	 * @param classifications
	 */
	public void clickAndVal(String classifications){
		slowDown(2);
		isDisplayed(antDbAntCodeResult,3);
		click(antDbAntCodeResult);
		isDisplayed(basicInformationClassification,10);
		String classification = getFieldText(basicInformationClassification);
		assertEquals(classifications,classification);

	}

	/**
	 * Method opens the Advanced search section
	 */
	public void openAdvancedSearch(){
		isDisplayed(antDbAdvancedSearchLink,5);
		slowDown(3);
		click(antDbAdvancedSearchLink);
		slowDown(3);
		//double search
		if(!isDisplayed(antDbAdvancedSearchStatusField,20))
			clickJS(antDbAdvancedSearchLink);
		
	}

	/**
	 * Method enters text into advanced search fields via parameters
	 * @param statusText
	 * @param gainText
	 * @param applicationText
	 * @param diameterText
	 * @param rPEText
	 * @param classificationText
	 * @param search3dbBeamwidthFieldText
	 * @param fCCComplianceFieldText
	 */
	public void submitAdvanceSearch(String statusText, String gainText, String applicationText, String diameterText, String rPEText, String classificationText, String search3dbBeamwidthFieldText, String fCCComplianceFieldText ){
		slowDown(1);  
		assertTrue("antDbAdvancedSearchGainField is not present",isDisplayed(antDbAdvancedSearchGainField,50));
		assertTrue("antDbAdvancedSearchApplicationField is not present",isDisplayed(antDbAdvancedSearchApplicationField,5));
		assertTrue("antDbAdvancedSearchDiameterField is not present",isDisplayed(antDbAdvancedSearchDiameterField,5));
		assertTrue("antDbAdvancedSearchRPEField is not present",isDisplayed(antDbAdvancedSearchRPEField,5));
		assertTrue("antDbAdvancedSearchClassificationField is not present",isDisplayed(antDbAdvancedSearchClassificationField,5));
		assertTrue("antDbAdvancedSearch3dbBeamwidthField is not present",isDisplayed(antDbAdvancedSearch3dbBeamwidthField,5));
		assertTrue("antDbAdvancedSearchFCCComplianceField is not present",isDisplayed(antDbAdvancedSearchFCCComplianceField,5));
		assertTrue("antDbAdvancedSearchStatusField is not present",isDisplayed(antDbAdvancedSearchStatusField,45));

		selectFromDropdown(antDbAdvancedSearchStatusField,statusText);
		type(gainText,antDbAdvancedSearchGainField);
		selectFromDropdown(antDbAdvancedSearchApplicationField,applicationText);
		type(diameterText,antDbAdvancedSearchDiameterField);
		type(rPEText,antDbAdvancedSearchRPEField);
		selectFromDropdown(antDbAdvancedSearchClassificationField,classificationText);
		type(search3dbBeamwidthFieldText,antDbAdvancedSearch3dbBeamwidthField);
		selectFromDropdown(antDbAdvancedSearchFCCComplianceField,fCCComplianceFieldText);
		click(antDbSearchButton);
		//double search
		if(!isDisplayed(antCodeListResult,5))
			clickJS(antDbSearchButton);
	}

	/**
	 * Opens the Antenna Db module
	 */
	public void accessAntennaDataBase(){
		assertTrue("can't find the home page ",isDisplayed(antennaLink,90));
		slowDown(1);
		click(antennaLink);
		//double search
				if(!isDisplayed(antDbAntCodeField,65))
					clickJS(antennaLink);
		assertTrue("Antenna Database Search page is missing",isDisplayed(antDbAntCodeField,20));
	}

	/**
	 * Method takes in search strings and enters in to search field and executes the search
	 * @param antCodeText
	 * @param antCompanyText
	 * @param antModelFamilyText
	 * @param antModelText
	 * @param antFreqText
	 */
	public void searchAntennaDatabase(String antCodeText, String antCompanyText, String antModelFamilyText, String antModelText, String antFreqText){
		assertTrue("Antenna databse search page is missing",isDisplayed(antDbAntCodeField,12));
		clear(antDbAntCodeField);
		clear(antDbAntCompanyField);
		clear(antDbModelFamilyField);
		clear(antDbAntModelField);
		clear(antDbAntModelField);
		clear(antDbFrequencyField);
		type(antCodeText,antDbAntCodeField);
		type(antCompanyText,antDbAntCompanyField);
		type(antModelFamilyText,antDbModelFamilyField);
		type(antModelText,antDbAntModelField);
		type(antFreqText,antDbFrequencyField);
		slowDown(2);
		clickJS(antDbSearchButton);
		slowDown(2);
		if(!isDisplayed(antCodeListResult,5))
			clickJS(antDbSearchButton);
		slowDown(2);
	}

	/**
	 * Method takes in search strings and enters in to search field and executes the search then selects suggested by text
	 * @param antCodeText
	 * @param antCompanyText
	 * @param antModelFamilyText
	 * @param antModelText
	 * @param antFreqText
	 */
	public void submitAntennaDataBaseSearch(String antCodeText, String antCompanyText, String antModelFamilyText, String antModelText, String antFreqText){
		assertTrue(isDisplayed(antDbAntCodeField,5));
		type(antCodeText,antDbAntCodeField);
		type(antCompanyText,antDbAntCompanyField);
		type(antModelFamilyText,antDbModelFamilyField);
		type(antModelText,antDbAntModelField);
		type(antFreqText,antDbFrequencyField);
		click(antDbSearchButton);
		//double search
		if(!isDisplayed(antCodeListResult,5))
			click(antDbSearchButton);
		slowDown(3);
	}

	/**
	 * Method takes in search strings and enters in to search field and executes the search
	 * @param row
	 * @param antCode
	 * @param antCompany
	 * @param antModelFamily
	 * @param antModel
	 * @param antPol
	 * @param antFrequency
	 */
	public void evaluateAntennaDataSearchResult1(int row, String antCode, String antCompany, String antModelFamily, String antModel, String antPol, String antFrequency){
		assertTrue("Antenna Code list result is missing",isDisplayed(antDbAntCodeResult,50));
		String rawAntCode = getTextPlural(antDbAntCodeResult,row);
		String antCodeValue = rawAntCode.substring(0,6);
		assertEquals(antCode,antCodeValue);
		assertTrue(isDisplayed(antDbAntCompanyResult,5));
		String antCompanyValue = getTextPlural(antDbAntCompanyResult,row);
		assertEquals(antCompany,antCompanyValue);
		assertTrue("Model family result is not present",isDisplayed(antDbAntModelFamilyResult,5));
		String antModelFamilyValue = getTextPlural(antDbAntModelFamilyResult,row);
		assertEquals(antModelFamily,antModelFamilyValue);
		assertTrue(isDisplayed(antDbAntModelResult,5));
		String antModelValue = getTextPlural(antDbAntModelResult,row);
		assertEquals(antModel,antModelValue);
		assertTrue(isDisplayed(antDbAntPolResult,5));
		String antPolValue = getTextPlural(antDbAntPolResult,row);
		assertEquals(antPol,antPolValue);
		assertTrue(isDisplayed(antDbAntFreqResult,5));
		String antFrequencyValue = getTextPlural(antDbAntFreqResult,row);
		assertEquals(antFrequency,antFrequencyValue);
	}

	/**
	 * Method takes in search strings and enters in to search field and executes the search
	 * @param row
	 * @param antGain
	 * @param ant3dBBW
	 * @param antDiameter
	 * @param antCompliance
	 * @param antRPE
	 * @param antPatternDate
	 */
	public void evaluateAntennaDataSearchResult2(int row, String antGain, String ant3dBBW, String antDiameter, String antCompliance, String antRPE, String antPatternDate){
		assertTrue(isDisplayed(antDbAntGainResult,5));
		String antGainValue = getTextPlural(antDbAntGainResult,row);
		assertEquals(antGain,antGainValue);
		assertTrue(isDisplayed(antDbAnt3dBBWResult,5));
		String ant3dBBWValue = getTextPlural(antDbAnt3dBBWResult,row);
		assertEquals(ant3dBBW,ant3dBBWValue);
		assertTrue(isDisplayed(antDbAntDiameterResult,5));
		String antDiameterValue = getTextPlural(antDbAntDiameterResult,row);
		assertEquals(antDiameter,antDiameterValue);
		assertTrue(isDisplayed(antDbAntComplianceResult,5));
		String antComplianceValue = getTextPlural(antDbAntComplianceResult,row);
		assertEquals(antCompliance,antComplianceValue);
		assertTrue(isDisplayed(antDbAntRPEResult,5));
		String antRPEValue = getTextPlural(antDbAntRPEResult,row);
		assertEquals(antRPE,antRPEValue);
		assertTrue(isDisplayed(antDbAntPatternDateResult,5));
		String antPatternDateValue = getTextPlural(antDbAntPatternDateResult,row);
	}

	/**
	 * Method loops though a list of antennas and validates that the value passed via the parameter is represented for the given column
	 * @param antCompany
	 */
	public void evaluateCompanyRow(String antCompany) {
		int rows = getRows(antDbAntCompanyResult);

		for (int i = 0; i < rows; i++){
			assertTrue(isDisplayed(antDbAntCompanyResult, 5));
			String antCompanyValue = getTextPlural(antDbAntCompanyResult, i);
			assertEquals(antCompany, antCompanyValue);}
	}

	/**
	 * Method loops though a list of antennas and validates that the value passed via the parameter is represented for the given column
	 * @param antModelFamily
	 */
	public void evaluateCompanyFamilyRow(String antModelFamily) {
		int rows = getRows(antDbAntModelFamilyResult);
		for (int i = 0; i < rows; i++) {
			assertTrue(isDisplayed(antDbAntModelFamilyResult,5));
			String antModelFamilyValue = getTextPlural(antDbAntModelFamilyResult,i);
			assertEquals(antModelFamily,antModelFamilyValue);

		}
	}

	/**
	 * Method loops though a list of antennas and validates that the value passed via the parameter is represented for the given column
	 * @param low
	 * @param high
	 */
	public void evaluateCompanyFreqRow(int low, int high) {
		int rows = getRows(antDbAntFreqResult);
		for (int i = 0; i < rows; i++) {
			assertTrue(isDisplayed(antDbAntFreqResult,5));
			String antFreqValue = getTextPlural(antDbAntFreqResult,i);
			int numLow = NumberUtils.toInt(antFreqValue.substring(0,3));
			int numHigh = NumberUtils.toInt(antFreqValue.substring(6));
			assertTrue(numLow <=  low);
			assertTrue(numHigh <=  high);}
	}


	/**
	 * Selects the Left Radio dialon Antenna Database
	 */
	public void selectsLeftRadioDialAntennaDatabase() {
		slowDown(3);
		click(antDbAntModelLeftRadioDial);
	}

	/**
	 * validates that the correct status is displayed for all search results
	 */
	public void evaluateAntennaDataActiveStatusResults(){
		int rows = getRows(antDbAntStatusResultGreeen);
		for (int i = 0; i < rows; i++) {
			isDisplayed(antDbAntStatusResultGreeen,5);
			assertTrue(isDisplayedArray(antDbAntStatusResultGreeen, i));
		}
	}

	/**
	 * validates that the correct status is displayed for all search results
	 */
	public void evaluateAntennaDataObsoleteStatusResults(){
		int rows = getRows(antDbAntStatusResultOrange);
		for (int i = 0; i < rows; i++) {
			isDisplayed(antDbAntStatusResultOrange,5);
			assertTrue(isDisplayedArray(antDbAntStatusResultOrange, i));
		}
	}

	/**
	 * validates that the correct status is displayed for all search results
	 */
	public void evaluateAntennaDataInvalidStatusResults(){
		int rows = getRows(antDbAntStatusResultRed);
		for (int i = 0; i < rows; i++) {
			isDisplayed(antDbAntStatusResultRed,5);
			assertTrue(isDisplayedArray(antDbAntStatusResultRed, i));
		}
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antCode
	 * @param row
	 */
	public void evaluateAntennaDataSearchResults(String antCode, int row){
		assertTrue(isDisplayed(antCodeListResult,5));
		String rawAntCode = getTextPlural(antDbAntCodeResult,row);
		String antCodeValue = rawAntCode.substring(0,6);
		assertEquals(antCode,antCodeValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antCompany
	 * @param row
	 */
	public void evaluateAntennaDataBaseCompanySearchResults(String antCompany, int row){
		assertTrue(isDisplayed(antDbAntCompanyResult,5));
		String antCompanyValue = getTextPlural(antDbAntCompanyResult,row);
		assertEquals(antCompany,antCompanyValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antModelFamily
	 * @param row
	 */
	public void evaluateAntennaDataBaseModelFamilySearchResults(String antModelFamily, int row){
		assertTrue(isDisplayed(antDbAntModelFamilyResult,5));
		String antModelFamilyValue = getTextPlural(antDbAntModelFamilyResult,row);
		assertEquals(antModelFamily,antModelFamilyValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antModel
	 * @param row
	 */
	public void compareAntennaDatabaseModelSearchResults(String antModel, int row){
		assertTrue(isDisplayed(antDbAntModelResult,5));
		String antModelValue = getTextPlural(antDbAntModelResult,row);
		assertEquals(antModel,antModelValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antPol
	 * @param row
	 */
	public void evaluateAntennaDatabasePolSearchResults(String antPol, int row){
		assertTrue(isDisplayed(antDbAntPolResult,5));
		String antPolValue = getTextPlural(antDbAntPolResult,row);
		assertEquals(antPol,antPolValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antFrequency
	 * @param row
	 */
	public void evaluateAntennaDatabaseFrequencySearchResults(String antFrequency, int row){
		assertTrue(isDisplayed(antDbAntFreqResult,5));
		String antFrequencyValue = getTextPlural(antDbAntFreqResult,row);
		assertEquals(antFrequency,antFrequencyValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antGain
	 * @param row
	 */
	public void evaluateAntennaDatabaseGainSearchResults(String antGain, int row){
		assertTrue(isDisplayed(antDbAntGainResult,5));
		String antGainValue = getTextPlural(antDbAntGainResult,row);
		assertEquals(antGain,antGainValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param ant3dBBW
	 * @param row
	 */
	public void evaluateAntennaDataBase3dBBWSearchResults(String ant3dBBW, int row){
		assertTrue(isDisplayed(antDbAnt3dBBWResult,5));
		String ant3dBBWValue = getTextPlural(antDbAnt3dBBWResult,row);
		assertEquals(ant3dBBW,ant3dBBWValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antDiameter
	 * @param row
	 */
	public void evaluateAntennaDataBaseDiameterSearchResults(String antDiameter, int row){
		assertTrue(isDisplayed(antDbAntDiameterResult,5));
		String antDiameterValue = getTextPlural(antDbAntDiameterResult,row);
		assertEquals(antDiameter,antDiameterValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antCompliance
	 * @param row
	 */
	public void evaluateAntennaDataBaseComplianceSearchResults(String antCompliance, int row){
		assertTrue(isDisplayed(antDbAntComplianceResult,20));
		String antComplianceValue = getTextPlural(antDbAntComplianceResult,row);
		assertEquals(antCompliance,antComplianceValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antRPE
	 * @param row
	 */
	public void evaluateAntennaDataBaseRPESearchResults(String antRPE, int row){
		assertTrue(isDisplayed(antDbAntRPEResult,5));
		String antRPEValue = getTextPlural(antDbAntRPEResult,row);
		assertEquals(antRPE,antRPEValue);
	}

	/**
	 * takes in the row array and compare text and validates that the actual field value matches
	 * @param antPatternDate
	 * @param row
	 */
	public void evaluateAntennaDataBasePatternDateSearchResult(String antPatternDate, int row){
		assertTrue(isDisplayed(antDbAntPatternDateResult,5));
		String antPatternDateValue = getTextPlural(antDbAntPatternDateResult,row);
		assertEquals(antPatternDate,antPatternDateValue);
	}





	/**
	 * This method takes in a string to compare the comment to the actual comment field value
	 * @param CommentTitle
	 */

	/**
	 * Takes an integer that selects the row, also discrimination and angle string values for comparison to actual field values
	 * @param patRow
	 * @param angle
	 * @param discrimination
	 */
	public void valPattern(int patRow, String angle, String discrimination){
		String angleVal = getFieldTextPlural(angleFieldValue, patRow);
		String discriminationVal = getFieldTextPlural(discriminationFieldValue, patRow);

		assertEquals(angle, angleVal);
		assertEquals(discrimination,discriminationVal);

	}

	/**
	 * This method clicks the + icon in create antenna page of Antenna button
	 */
	public void openModelFamily(){
		assertTrue("Add new model family icon is not present",isDisplayed(addModelFamilyIcon,10));
		click(addModelFamilyIcon);
		assertTrue("Add new model family Name field is not present",isDisplayed(newModelFamilyNameField,5));
		click(newModelFamilyNameField);

	}

	/**
	 * This method gets the first one from the list of saved model families
	 */
	public String getAnExistingSaveModelFamily(){
		assertTrue("Saved Antenna Model Family list is not present",isDisplayed(savedAntennaModelFamilies,5));
		String savedModelFamilyRow1=getTextPlural(savedAntennaModelFamilies, 0);
		return savedModelFamilyRow1;

	}

	/**
	 * 
	 * This method check for existing model family and validates the model family field
	 * 
	 */
	public void validateExistingModelFamily(String ExitingFamilyRow1, String ModelFamilyNameError){
		assertTrue("Add new model family Name field is not present",isDisplayed(newModelFamilyNameField,5));
		type(ExitingFamilyRow1, newModelFamilyNameField);
		click(saveNewModelFamily);

		String partialExistingModelFamilyText=ExitingFamilyRow1.substring(0,1).toUpperCase();
		assertTrue("Error message missing",isDisplayed(modelFamilyErrorMessage,5));

		String ModelFamilyErrorMessageValue = getText(modelFamilyErrorMessage);
		assertEquals(ModelFamilyNameError,ModelFamilyErrorMessageValue);

		clear(newModelFamilyNameField);
		type(partialExistingModelFamilyText,newModelFamilyNameField );
		//verify the saved antenna model list updates with the families starting with the partial text.
		int rows = getRows(savedAntennaModelFamilies);
		for (int i = 0; i < rows; i++) {
			String lineItemInList;
			String partialLineItemList;
			//try and catch would be inside the for loop
			try
			{
				lineItemInList = getTextPlural(savedAntennaModelFamilies,i);
				partialLineItemList=lineItemInList.substring(0,1).toUpperCase();
				assertEquals(partialLineItemList,partialExistingModelFamilyText);
			}
			catch (java.lang.AssertionError failure)
			{
				throw failure;
			}
		}
		clear(newModelFamilyNameField);
	}

	/**
	 * 
	 * This method creates new model family
	 * 
	 */
	public void createNewAntennaModelFamily_validateSave(int randomNum,String ModelFamilyNameError){
		String newFamilyName="Z"+randomNum;
		assertTrue("Add new model family Name field is not present",isDisplayed(newModelFamilyNameField,5));
		type(newFamilyName, newModelFamilyNameField);
		assertTrue("Save button is not present",isDisplayed(saveNewModelFamily,5));
		click(saveNewModelFamily);
		if(isDisplayed(saveNewModelFamily)) {
			click(saveNewModelFamily);
		}
		slowDown(3);
		assertTrue("Model family field is not present",isDisplayed(antDbbasicInformationModelFamily,50));
		slowDown(2);
		String modelFamilyFieldValueAntennaDetailsPage=getFieldText(antDbbasicInformationModelFamily);
		assertEquals(newFamilyName,modelFamilyFieldValueAntennaDetailsPage);
		openModelFamily();

		//check if the previously saved model family got saved properly or exists
		type(newFamilyName, newModelFamilyNameField);
		assertTrue("Save button is not present",isDisplayed(saveNewModelFamily,5));
		click(saveNewModelFamily);
		slowDown(3);
		assertTrue("Error message is not present",isDisplayed(modelFamilyErrorMessage,5));

		String ModelFamilyErrorMessageValue = getText(modelFamilyErrorMessage);
		assertEquals(ModelFamilyNameError,ModelFamilyErrorMessageValue);

		clear(newModelFamilyNameField);

	}

	/**
	 * This method picks the available manufacturer name from the Manufacturer field auto suggest
	 * from Antenna Database search
	 */
	public String getManufacturer(){
		assertTrue("Manufactuyrer field is not displayed in Antenna search screen",isDisplayed(antDbAntCompanyField));
		click(antDbAntCompanyField);
		slowDown(2);
		assertTrue("Manufacturer autosuggest List is missing",isDisplayed(manufacturerAutoSuggestList));
		String manufacturerDataValue=getTextPlural(manufacturerAutoSuggestList, 0);
		return manufacturerDataValue;

	}
	/**
	 * This method click the first antenna code from the search results result 
	 * 
	 */
	public void clickFirstAntennaResultFromAntennaSearchResulst(){
		assertTrue("Antenna Database search Results missing",isDisplayed(antDbAntCodeResult,2));
		click(antDbAntCodeResult,0);
		slowDown(2);
		assertTrue("Antenna Details page did not open" ,isDisplayed(antDbbasicInformationCompany,5));

	}
	/**
	 * This method verifies the antenna discrimination values 
	 * 
	 */
	public void verifyAntennaDiscriminationValueFromAntennaDetailsPage(){
		assertTrue("Antenna Discrimination link is missing",isDisplayed(antDbDiscriminationCalcLink,4));
		slowDown(2);
		clickJS(antDbDiscriminationCalcLink);
		slowDown(2);
		assertTrue("Antenna discrimination pop up doesnt appear" ,isDisplayed(antDbDiscriminationAngleField,5));
		type("60",antDbDiscriminationAngleField);
		click(antDbDiscriminationCalculateButon);
		slowDown(2);
		String vvDiscrimination=getText(discriminationVV );
		assertEquals("-39", vvDiscrimination);
		String vhDiscrimination=getText(discriminationVH );
		assertEquals("-57.33",vhDiscrimination);
		String hhDiscrimination=getText(discriminationHH );
		assertEquals("-41", hhDiscrimination);
		String hvDiscrimination=getText(discriminationHV );
		assertEquals("-57.5", hvDiscrimination);
		String vvGain=getText(gainVV );
		assertEquals("-4.3", vvGain);
		String vhGain=getText(gainVH );
		assertEquals("-22.63", vhGain);
		String hhGain=getText(gainHH );
		assertEquals("-6.3", hhGain);
		String hvGain=getText(gainHV );
		assertEquals("-22.8", hvGain);


	}
	/**
	 * This method perform a search by manufacturer field and grabs the first antenna code from the result
	 * @return 
	 * 
	 */
	public String searchManufacturer_getAntennaCodeFromResults(String Manufacturer){
		assertTrue("Manufactuyrer field is not displayed in Antenna search screen",isDisplayed(antDbAntCompanyField));
		clear(antDbAntCompanyField);
		type(Manufacturer, antDbAntCompanyField);
		slowDown(3);
		clickJS(antDbSearchButton);
		//double search
		if(!isDisplayed(antCodeListResult,5))
			click(antDbSearchButton);
		slowDown(5);
		assertTrue("Antenna Database search Results missing",isDisplayed(antDbAntCodeResult,2));
		click(antDbAntCodeResult,0);
		slowDown(2);
		assertTrue("Antenna Details page did not open" ,isDisplayed(antDbbasicInformationCompany,5));
		String antenna_code=getAttributeValue(antDbbasicInformationAntennaCode);
		click(returnButtonOnAntennaDetails);
		return(antenna_code);
	}
	
	/**
	 * This method gets the antenna code from antenna details page
	 */
	public String getAntennaCodeFromAntennaDetails() {
		return getFieldText(antDbbasicInformationAntennaCode);
	}
	
	/**
	 * This method is to grab referenceCode from AntennaCode
	 */
	public String getReferenceCodeFromAntennaCode(String antennaCode){
		slowDown(2);
		assertTrue("Manufacturer field is not displayed in Antenna search screen",isDisplayed(antDbAntCompanyField,6));
		clear(antDbAntCodeField);
		type(antennaCode, antDbAntCodeField);     
		click(antDbSearchButton);
		slowDown(2);
		//double search
		if(!isDisplayed(antCodeListResult,5))
			click(antDbSearchButton);
		assertTrue("Antenna search results are missing" ,isDisplayed(antDbAntCodeResult,5));
		click(antDbAntCodeResult,0);
		slowDown(2);
		String referenceCode=getFieldText(antennaReferenceCodeInAntennaDetails);
		click(returnButtonOnAntennaDetails);
		return referenceCode;

	}
	/**
	 * This method is to perform advanced searchWithReferenceCode
	 */
	public void advancedSearchReferenceCode(String referenceCode, String antennaCode){
		assertTrue("Antenna search Link is missing" ,isDisplayed(antDbAdvancedSearchLink,5));
		slowDown(3);
		assertTrue("Advanced search reference code is not present",isDisplayed(antDbAdvancedSearchRefCode,5));
		clear(antDbAdvancedSearchRefCode);
		type(referenceCode, antDbAdvancedSearchRefCode);
		clear(antDbAntCodeField);
		type(antennaCode, antDbAntCodeField);     
		click(antDbSearchButton);
		//double search
		if(!isDisplayed(antCodeListResult,5))
			click(antDbSearchButton);
		assertTrue("Antenna Database search Results missing",isDisplayed(antCodeListResult,2));
		click(antDbAntCodeResult,0);
		slowDown(2);
		assertTrue("Reference code field missing",isDisplayed(antennaReferenceCodeInAntennaDetails,2));

		String ReferenceFieldValue=getFieldText(antennaReferenceCodeInAntennaDetails);
		assertEquals(referenceCode,ReferenceFieldValue);

	}
	/**
	 * 
	 * Basic Antenna search using manufacturer, model family and model
	 */
	public void antennaBasicSearch_BasicSearchValidation(String antennaManufacturerText, String modelFamilyText, String antennaModelText){
		isDisplayed(antDbAntCodeField,20);
		clear( antDbAntCodeField);
		clear( antDbAntCompanyField);
		clear( antDbModelFamilyField);
		clear( antDbAntModelField);
		click( antDbAntCompanyField);
		assertTrue("Manufacturer auto suggest list is missing",isDisplayed(manufacturerAutoSuggestList,3));
		String antennaManufacturerPartialText=antennaManufacturerText.substring(0,3).toLowerCase();
		//Type in the first 3 letters of the manufacturer company.
		type(antennaManufacturerPartialText, antDbAntCompanyField);
		//verifying whether the auto-suggest list is filtered based on the manufacturer value typed in the field
		int rows = getRows(manufacturerAutoSuggestList);
		for (int i = 0; i < rows; i++) {
			String lineItemInList;
			String partialLineItemList;
			//try and catch would be inside the for loop
			try
			{
				lineItemInList = getTextPlural(manufacturerAutoSuggestList,i).toLowerCase();
				partialLineItemList=lineItemInList.substring(0,3).toLowerCase();
				assertEquals(partialLineItemList,antennaManufacturerPartialText);
			}
			catch (java.lang.AssertionError failure)
			{
				throw failure;
			}
		}
		clear( antDbAntCompanyField);        
		type(antennaManufacturerText, antDbAntCompanyField);
		type("%", antDbModelFamilyField);
		assertTrue("Search button is not Displayed",isDisplayed(antDbSearchButton,20));
		click(antDbSearchButton);
		//double search
		if(!isDisplayed(antCodeListResult,5))
			click(antDbSearchButton);
		assertTrue("Search Results is not Displayed",isDisplayed(antennaSearchResults,20));

		click(antennaSearchResults);
		slowDown(3);
		String antennaManufacturerFieldValue=getFieldText(antDbbasicInformationCompany);
		assertEquals(antennaManufacturerText,antennaManufacturerFieldValue);

		//get the next search parameter from the existing data
		String antennaModelFamilyFieldValue=getFieldText(antDbbasicInformationModelFamily);
		click( returnButtonOnAntennaDetails);
		slowDown(2);
		clear( antDbAntCompanyField);        
		clear( antDbModelFamilyField);
		clear(antDbModelFamilyField);
		type(antennaModelFamilyFieldValue, antDbModelFamilyField);
		type("%", antDbAntModelField);
		slowDown(2);
		clickJS(antDbSearchButton);
		//double search
		if(!isDisplayed(antCodeListResult,5))
			click(antDbSearchButton);
		assertTrue("Search Results is not Displayed",isDisplayed(antennaSearchResults,2));
		click(antennaSearchResults);
		slowDown(2);
		String antennaModelFamilyFieldValue2=getFieldText(antDbbasicInformationModelFamily);
		assertEquals(antennaModelFamilyFieldValue,antennaModelFamilyFieldValue2);
		click( returnButtonOnAntennaDetails);
		slowDown(2);
		clear(antDbAntCodeField);
		clear(antDbAntCompanyField);
		clear(antDbModelFamilyField);
		clear(antDbAntModelField);

	}
	/**
	 * verify antenna pattern field validation
	 */
	public void verifyAntennaPatterInfoFieldValidation() {
		assertTrue("RPE Date field is missing",isDisplayed(rpeDate,3));
		clear(rpeDate);
		clear(rpeField);
		clear(referenceCodeField);
		type("20171212", rpeDate);
		click(referenceCodeField);
		slowDown(1);
		String errorMessage=getText(antennaRPEDateErrorMessage);
		assertEquals("Invalid date format: YYYY/MM/DD",errorMessage);
		clear(rpeDate);
		type("4411/11/55", rpeDate);
		click(referenceCodeField);
		slowDown(1);
		String errorMessage1=getText(antennaRPEDateErrorMessage);
		assertEquals("Invalid Date",errorMessage1);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.add(Calendar.DATE, +1);
		Date tomorrow = cal.getTime(); 
		String futureDate = dateFormat.format(tomorrow);
		System.out.println("Date = "+ futureDate);
		clear(rpeDate);
		type(futureDate, rpeDate);
		click(referenceCodeField);
		slowDown(1);
		String errorMessage2=getText(antennaRPEDateErrorMessage);
		assertEquals("Cannot be in the future.",errorMessage2);
		Date currentDate = cal2.getTime(); 
		String todaysDate = dateFormat.format(currentDate);
		System.out.println("currentDay = "+ todaysDate);

		clear(rpeDate);
		type(todaysDate, rpeDate);
		click(referenceCodeField);
		slowDown(1);
		String sampleReferenceCode="44111155";
		type(sampleReferenceCode,referenceCodeField);
		click(rpeDate);
		slowDown(2);
		String errorMessageRefCode=getText(antennaReferenceCodeErrorMessage);
		assertEquals("Antenna Code "+sampleReferenceCode+" not found",errorMessageRefCode);
		String rdpTextMoreThan40Characters="12345678901234567890123456789012345678901";
		clear(rpeField);
		type(rdpTextMoreThan40Characters,rpeField);
		click(referenceCodeField);
		slowDown(1);
		String errorMessage3=getText(antennaRPEErrorMessage);
		assertEquals("40 characters max",errorMessage3);
	}
	/**
	 * This function is to verify the conversion of values meter/feet toggle in antenna database
	 * @param diameter
	 * @param verifyConversionValue
	 */
	public void verifyConversionSite1AntennaCenterlineFeetToMeter(String diameter, String verifyConvertedValue) {
		assertTrue("Antenna details page is not displayed",isDisplayed(antDbbasicInformationAntennaCode,20));
		click(antDbbasicInformationDiameterMeter);
		type(diameter,antDbTechnicalInformationDiameter);
		click(antDbbasicInformationDiameterFeet);
		slowDown(2);
		String convertedCenterlineValue1= getFieldText(antDbTechnicalInformationDiameter);
		assertEquals(convertedCenterlineValue1,verifyConvertedValue);
		click(antDbbasicInformationDiameterMeter);
		String convertedCenterlineValue2= getFieldText(antDbTechnicalInformationDiameter);
		assertEquals(diameter,convertedCenterlineValue2);


	}
	/**
	 * This method click save button
	 */
	public void clickSaveButton() {
		slowDown(2);
		click(createAntennaButton);
		slowDown(3);
	}
	/**
	 * This method check antenna update message and verify it stays on details page
	 */
	public void verifyAntennaUpdateMessage() {
		slowDown(5);
		String saveMessage=getText(antennaUpdateMessage);
		assertEquals("SUCCESSFULLY UPDATED ANTENNA",saveMessage );
		click(blankPage);
		slowDown(2);
		click(antennaReturnButtonInAntennaDetailsPage);
		slowDown(1);


	}
	/**
	 * This method is to click anywhere on a page after the path save message appaears
	 */
	public void clickPage() {
		slowDown(2);
		clickJS(blankPage);
		slowDown(2);
	}
	/**
	 * This method is to verify the copy message
	 * @param message
	 */

	public void verifyCopyMessage(String message) {
		assertTrue("Copy sucess message is not displayed",isDisplayed(copySuccessMessage ,20));
		String copyMesssage= getText(copySuccessMessage);
		assertEquals(message,copyMesssage );

	}
	/**
	 * This method is to verify VV patter is present
	 */

	public void verifyVVPattern() {
		assertTrue("VV pattern is not present", isDisplayed(patternVVButton));
		click(patternVVButton);
		String vvPatternAngleValue=getFieldText(patternVVFirstAngleValue);
		if (vvPatternAngleValue==null)
		{
			assertTrue("VV pattern is not present", isDisplayed(antDbAntCodeField));

		}
		click(clearVV);
		click(createAntennaButton);
		slowDown(3);
		assertTrue("vv pattern error message doesnt appear", isDisplayed(vvPatternErrorMessage));
		slowDown(3);
		String errorMessageVVPAttern=getText(vvPatternErrorMessage);
		assertEquals("Validation Error while updating Antenna Spec",errorMessageVVPAttern);
	}

	/**
	 * Method clicks the verify copy antenna modal
	 * @return 
	 */
	public String verifyCopyAntennaModal(){
		assertTrue("Copy Antenna modal didnt appear", isDisplayed(copyNewAntennaCode,20));
		slowDown(3);
		String newAntennaCode=getFieldText(copyNewAntennaCode);
		clear(copyNewAntennaCode);
		clear(copyNewAntennaCode);
		type("testABC",copyNewAntennaCode);
		clear(copyNewAntennaCode);
		clear(copyNewAntennaCode);
		type(newAntennaCode,copyNewAntennaCode);
		slowDown(1);
		return newAntennaCode;

	}
	/**
	 * This method is to click on return button on path details page
	 */

	public void clickReturnAntennaDetails() {
		assertTrue("Return button on antenna details page is missing", isDisplayed(returnButtonOnAntennaDetails,60));
		click (returnButtonOnAntennaDetails );
		slowDown(2);

	}
	/**
	 * this method is to click delete
	 */
	public void clickDeleteAntenna() {
		assertTrue("Delete button on antenna details page is missing", isDisplayed(antennaDelete,80));
		click(antennaDelete);
		assertTrue("Antenna delete confirmation modal didnt appaer", isDisplayed(antennaDeleteConfirmation,90));
		click(antennaDeleteConfirmation);
		assertTrue("antennaDeleteMessage didnt appaer", isDisplayed(antennaDeleteMessage,90));
		String deleteMessage=getText(antennaDeleteMessage);
		assertEquals("DELETE SUCCESS",deleteMessage);
	}
	/**
	 * This method is to delete the copied antenna
	 */
	public void deleteCopiedAntenna() {
		clickDeleteAntenna();
	}
	public void verifyAntennaDetailsInAntennaDatabase() {
		String errorMessageCompany = getText( newAntennaCompanyErrorMessage );
		String errorMessageAntennaModel = getText( newAntennaModelErrorMessage );
		String errorMessageClassification = getText( newAntennaClassificationErrorMessage );
		String errorMessageLoFrequency = getText( newAntennaLowFrequencyErrorMessage );
		String errorMessageHiFrequency = getText( newAntennaHighFrequencyErrorMessage );
		String errorMessageGain = getText( newAntennaGainErrorMessage );
		String errorMessageBeamwidth = getText( newAntennaBeamwidthErrorMessage );
		String errorMessageCompliance = getText( newAntennaComplianceErrorMessage );
		assertEquals(errorMessageCompany, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageAntennaModel, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageClassification, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageLoFrequency, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageHiFrequency, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageGain, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageBeamwidth, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageCompliance, REQUIRED_ERROR_MESSAGE);

	}

	public String getCurrentDate() {
		//getting a date in the future
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.add(Calendar.DATE, +1);
		Date currentDate = cal2.getTime(); 
		String todaysDate = dateFormat.format(currentDate);
		System.out.println("currentDay = "+ todaysDate);
		return todaysDate;
	}

	/**
	 * Verify antenna 15db beamwidth
	 */
	public void verifyAntenna15dbBeamwidth() {
		slowDown(2);
		assertTrue("Antenna details is not displayed",isDisplayed(antDbTechnicalInformation3dBeamwidth,40));
		assertEquals("225.5625",getFieldText(antennaBeamWidth));
	}


	public void verifyAntennaCreateSuccessMessage() {
		slowDown(2);
		String saveMessage=getText(antennaUpdateMessage);
		assertEquals("SUCCESSFULLY CREATED NEW ANTENNA",saveMessage );
		click(blankPage);
		slowDown(3);
	}

	/**
	 * This method is to verify pagination
	 */
	public void verifyPagination() {
		assertTrue("Antenna Database search Results missing", isDisplayed(antDbAntCodeResult,60));
		assertTrue("Pagination is missing", isDisplayed(paginationPageDropDown,60));
		assertTrue("Pagination page count is missing", isDisplayed(paginationPageCount,60));


	}

	/**
	 * This method is to click expert and verify export message
	 */
	public void clickExportAndVerifyExportMessage() {

		assertTrue("Export button is missing", isDisplayed(antDatabaseExportButton,60));
		click(antDatabaseExportButton);
		assertTrue("export message is missing", isDisplayed(exportMessage,90));
		assertEquals("Note: this will only export the visible page of search results. Navigate to another page to export those contents", getText(exportMessage));
	}

	/**
	 * This method is to click antenna discrimination icon in antenna details page
	 */
	public void clickAntennaDiscrimination() {
		assertTrue("Antenna discrimination button is missing", isDisplayed(antDbDiscriminationCalcLink,60));
		click(antDbDiscriminationCalcLink);
		slowDown(2);
		assertTrue("antenna Discrimination Calculator did not appear",isDisplayed(antDbDiscriminationCalcFieldAngle,30));
	}
	/**
	 * This method is to verify the antenna discrimination error message
	 * @param error
	 */
	public void verifyDiscriminationErrorMessage(String error) {
		assertTrue("antenna Discrimination Calculator did not appear",isDisplayed(antDbDiscriminationCalcFieldAngle,30));
		slowDown(1);
		String errorMessage=getText(antDbDiscriminationErrorMessage);
		assertEquals(errorMessage,error);
	}
	/**
	 * This method is to enter gain in antenna details page
	 * @param gain
	 */
	public void enterAntennaDatabaseGain(String gain) {
		assertTrue("Mainbeam Gain field in antenna details page is missing",isDisplayed(antDbTechnicalInformationMainbeamGain,30));
		type(gain,antDbTechnicalInformationMainbeamGain);
	}
	/**
	 * This method is to verify antenna discrimination and gain
	 * @param gain
	 * @param disc
	 */
	public void verifyDiscriminationAndGain(String disc, String gain) {
		slowDown(1);
		assertEquals(disc,getText(discriminationCalculatorVVDiscriminationResult));
		assertEquals(gain,getText(discriminationCalculatorVVGainResult));

	}

	/**
	 * This method is to delete attachment
	 */
	public void deleteAttachment() {
		assertTrue("comment is not added",isDisplayed(deleteAttachmentComment,40));
		click(deleteAttachmentComment);
		assertTrue("Delete confirmation modal is missing",isDisplayed(deletecommentConfirmation,50));
		click(deletecommentConfirmation);
		assertTrue("comment is not deleted sucessfully",isDisplayed(deleteCommentnotificationMessage,40));
		assertEquals(getText(deleteCommentnotificationMessage),"AntennaSpec Comment File deleted successfully");

	}

}
