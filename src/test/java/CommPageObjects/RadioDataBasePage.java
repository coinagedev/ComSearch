package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author nshaji
 *
 */
public class RadioDataBasePage extends BasePage {


	public RadioDataBasePage(WebDriver driver) {
		super(driver);
		visit("/");
	}
	private static final String REQUIRED_ERROR_MESSAGE = "Required.";
	// Buttons
	By dataBaseManagementButton = By.id("database-management-link");
	By radioDataBaseLink = By.id("home-cta-database-management-radio");
	By copyRadioDbButton =By.id("radio-details-copy");
	By copyNewRadioModal= By.id("COPY_RADIO_FORM-new-radio-code");
	By createRadioCopyModal = By.id("COPY_RADIO_FORM-submit");
	By copySuccessMessage=By.id("success-modal-heading");
	By returnButtonOnRadioDetails =By.id("radio-details-close-form");

	// Drop down options
	// Path Entry Fields - Able to use the type method
	By radioDbRadioCodeField = By.id("radio-db-search-radio-code");
	By radioDbRadioCompanyField = By.id("radio-db-search--radio-company");
	By radioDbModelFamilyField = By.id("radio-db-search--radio-family");
	By radioDbRadioModelField = By.id("radio-db-search--model-number");
	By radioEmissionBandwidthField = By.id("radio-db-search-bandwidth");
	By radioDbFrequencyField = By.id("radio-db-search-bandwidth");

	By radioDbStatus = By.id("radio-db-search-status");
	By radioDbModulationTypeAll = By.id("radio-db-search-modulation-type--label-bottom");
	By radioDbModulationTypeAdap = By.id("radio-db-search-modulation-type-1-label-bottom");
	By radioDbModulationTypeFxd = By.id("radio-db-search-modulation-type-2-label-bottom");
	By radioDbModulation = By.id("radio-db-search-modulation");
	By radioDbModulationDetail = By.id("radio-db-search-modulation-detail");
	By radioDbThroughPut = By.id("radio-db-search-throughput");
	By radioDbArchitecture = By.id("radio-db-search-architectures");
	By radioDbPowerOption = By.id("radio-db-search-power-option");
	By radioDbPower = By.id("radio-db-search-power");
	By radioDbRadioType = By.id("radio-db-search-radio-type");
	By radioDbFilterReferenceCode = By.id("radio-db-search-filter-reference-code");

	// buttons on the search field

	By radioSearchButton = By.id("radio-db-search-submit");
	By radioCreateButton = By.id("radio-db-search-create");
	By radioExportButton = By.id("radio-db-search-export");

	By radioAdvanceSearch = By.xpath("//*[@id=\"radio-db-search\"]/div[1]/div/label/span");
	By radioCodeListResult = By.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "')]");
	By radioDbRadioCodeResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-radioCode')]");
	By radioDbRadioCompanyResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-companyName')]");
	By radioDbRadioModelFamilyResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-radioFamilyName')]");
	By radioDbRadioModelResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-modelNumberConcatenated')]");
	By radioDbRadioEmissBandResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-bandwidth')]");
	By radioDbRadioPowerResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-txPowerMax')]");
	By radioDbRadioMbpsResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-radioModulations')]");
	By radioDbRadioModulationResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-modulationSchemeDescription')]");
	By radioDbRadioModulationDetailResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-modulationSchemeDescription')]");
	By radioDbRadioThresholdResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-modulationDetail')]");
	By radioDbRadioFreqResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-frequencyRange')]");
	By radioDbRadioSpecResult = By
			.xpath("//*[contains(@id, '" + RADIO_DB_MODAL + "') and contains(@id, '-frequencyRange')]");

	By antDbAntStatusResultGreeen = By.cssSelector(".database-search-status-icon.bg-green");
	By antDbAntStatusResultOrange = By.cssSelector(".database-search-status-icon.bg-orange");
	By antDbAntStatusResultRed = By.cssSelector(".database-search-status-icon.bg-red");

	// Manufacturer autosuggest
	By manufacturerAutoSuggest = By.xpath("//*[contains(@id, 'radio-db-search--radio-company-suggestion-')]");

	By modelFamilyAutoSuggest = By.xpath("//*[contains(@id, 'radio-db-search--radio-family-suggestion-')]");
	By modelFieldAutoSuggest = By.xpath("//*[contains(@id, 'radio-db-search--model-number-suggestion-')]");

	By radioDbbasicInformationCompany = By.id("radio-details-radio-company");

	By radioDbbasicInformationModelFamily = By.id("radio-details-radio-model-family");
	By radioDbbasicInformationAddNewModelFamilyIcon = By.id("radio-details-new-model-family-trigger");
	By radioDbbasicInformationStatusIconGreen = By.cssSelector(".database-search-status-icon.margin-left-1.bg-green");
	By radioDbbasicInformationStatusIconYellow = By.cssSelector(".database-search-status-icon.margin-left-1.bg-yellow");
	By radioDbbasicInformationStatusIconRed = By.cssSelector(".database-search-status-icon.margin-left-1.bg-red");
	By radioDbAdvancedSearchLink = By.xpath("//*[@id=\"radio-db-search\"]/div[1]/div/label/span");

	// Radio details create page fields and buttons
	By newRadioDbbasicInformationCode = By.id("radio-details-radio-code");
	By newRadioDbbasicInformationHiddenCode = By.cssSelector(".labeled-input hide-input-styles");
	By newRadioDbbasicInformationCompany = By.id("radio-details-radio-company");
	By newRadioDbbasicInformationModelFamily = By.id("radio-details-radio-model-family");
	By newRadioDbbasicInformationSpecDate = By.id("radio-details-spec-date");
	By newRadioDbbasicInformationStatus = By.id("radio-details-status");
	By newRadioDbbasicInformationATPCYes = By.id("radio-details-atpc-flag-true-label-bottom");
	By newRadioDbbasicInformationATPCNo = By.id("radio-details-atpc-flag-false-label-bottom");
	By newRadioDbbasicInformationATPCNA = By.id("radio-details-atpc-flag--label-bottom");

	By newRadioDbbasicInformationATPCTypeRamp = By.id("radio-details-atpc-type-1-label-bottom");
	By newRadioDbbasicInformationATPCTypeStep = By.id("radio-details-atpc-type-2-label-bottom");
	By newRadioDbbasicInformationATPCTypeNA = By.id("radio-details-atpc-type--label-bottom");

	By newRadioDbtechnicalInformationAnalog = By.id("radio-details-radio-type-1-label-bottom");
	By newRadioDbtechnicalInformationDigital = By.id("radio-details-radio-type-2-label-bottom");
	By newRadioDbtechnicalInformationTypeRepeater = By.id("radio-details-radio-type-3-label-bottom");

	By newRadioDbTechnicalInformationArchitecture = By.id("radio-details-architecture");
	By newRadioDbTechnicalInformationPowerOption = By.id("radio-details-power-type");
	By newRadioDbTechnicalInformationStability = By.id("radio-details-stability");
	By newRadioDbTechnicalInformationLowFrequency = By.id("radio-details-lo-frequency");
	By newRadioDbTechnicalInformationHighFrequency = By.id("radio-details-hi-frequency");
	By newRadioDbTechnicalInformationDuplexMode = By.id("radio-details-duplex-mode");
	By newRadioDbTechnicalInformationNarrowBWRFFilterYes = By
			.id("radio-details-ext-narrow-bw-filter-true-label-bottom");
	By newRadioDbTechnicalInformationNarrowBWRFFilterNo = By
			.id("radio-details-ext-narrow-bw-filter-false-label-bottom");
	By newRadioDbTechnicalInformationNarrowBWRFFilteNA = By.id("radio-details-ext-narrow-bw-filter--label-bottom");

	By radioDeleteButtonRadioDetailsPage = By.id("radio-details-delete");

	By newRadioDbModulationInformationModulationType = By.id("radio-details-modulationTypeId");
	By newRadioDbModulationInformationModulationLimit = By.id("radio-details-modulation-limit");
	By newRadioDbModulationInformatioDynamicACMPowerYes = By.id("radio-details-dynamic-power-flag-true-label-bottom");
	By newRadioDbModulationInformatioDynamicACMPowerNo = By.id("radio-details-dynamic-power-flag-false-label-bottom");
	By newRadioDbModulationInformatioDynamicACMPowerNA = By.id("radio-details-dynamic-power-flag--label-bottom");
	By newRadioDbModulationInformatioModulationLimitErrorMessage = By
			.id("radio-details-modulation-limit-error-message");

	By newRadioDbAddModulationButton = By.id("radio-details-add-modulation-trigger");
	By createNewRadioButton = By.id("radio-details-save");
	By radioSummaryButtonInRadioDetailsPage = By.id("radio-details-close-form");

	By newRadioDbbasicInformationCompanyErrorMessage = By.id("radio-details-radio-company-error-message");
	By newRadioDbbasicInformationSpecDateErrorMessage = By.id("radio-details-spec-date-error-message");
	By newRadioDbbasicInformationStabilityErrorMessage = By.id("radio-details-stability-error-message");
	By newRadioDbbasicInformationLowFrequencyErrorMessage = By.id("radio-details-lo-frequency-error-message");
	By newRadioDbbasicInformationHighFrequencyErrorMessage = By.id("radio-details-hi-frequency-error-message");
	By newRadioDbbasicInformationModulationTypeErrorMessage = By.id("radio-details-modulationTypeId-error-message");

	By newRadioModulationDetailsModelErrorMessage = By.id("modulation-details-model-number-error-message");
	By newRadioModulationDetailsModulationSchemeErrorMessage = By
			.id("modulation-details-modulation-scheme-error-message");
	By newRadioModulationDetailsThroughputErrorMessage = By.id("modulation-details-throughput-error-message");
	By newRadioModulationDetailsBandwidthErrorMessage = By.id("modulation-details-emission-bandwidth-error-message");

	By manufacturerAutoSuggestRadioDetails = By.xpath("//*[contains(@id, 'radio-details-radio-company-suggestion-')]");
	By modelFamilyAutoSuggestRadioDetails = By
			.xpath("//*[contains(@id, 'radio-details-radio-model-family-suggestion-')]");
	// Modulation Details page fields and buttons
	By modulationDetailsModel = By.id("modulation-details-model-number");
	By modulationDetailsModulationScheme = By.id("modulation-details-modulation-scheme");
	By modulationDetailsModulationDescription = By.id("modulation-details-modulation-description");
	By modulationDetailsModulationMaxPower = By.id("modulation-details-max-power");
	By modulationDetailsThroughput = By.id("modulation-details-throughput");
	By modulationDetailsEmissionDesignator = By.id("modulation-details-emission-designator");
	By modulationDetailsEmissionBandwidth = By.id("modulation-details-emission-bandwidth");
	By modulationDetailsSaveModulationButton = By.id("modulation-details-save");
	By modulationRadioSummary = By.id("modulation-details-close-form");
	By removeRadioModulation= By.xpath("//*[contains(@id, 'radio-details-modulations-details-table-data-radioModulationId')and contains(@id, '-remove-remove')]");
	By notification = By.id("notifications-wrapper");
	By radioDbModulationDetailsSavedModulation = By
			.xpath("//*[contains(@id, 'radio-details-modulations-details-table-data-radioModulationId-')and contains(@id, '-index')]");
	By channelRestrictionXPICYes = By.id("radio-details-xpic-true-label-bottom");
	By channelRestrictionXPICNo = By.id("radio-details-xpic-false-label-bottom");
	By channelRestrictionXPICNA = By.id("radio-details-xpic--label-bottom");
	By channelRestrictionACCPYes = By.id("radio-details-accp-true-label-bottom");
	By channelRestrictionACCPNo = By.id("radio-details-accp-false-label-bottom");
	By channelRestrictionACCPNA = By.id("radio-details-accp--label-bottom");
	By channelRestrictionACAPYes = By.id("radio-details-acap-true-label-bottom");
	By channelRestrictionACAPNo = By.id("radio-details-acap-false-label-bottom");
	By channelRestrictionACAPNA = By.id("radio-details-acap--label-bottom");

	// Role Selector Page

	By databaseUnchecked = By.cssSelector("#app > div > main > div > div > h3:nth-child(2) > i");
	By roleSelectField = By.className("margin-left-half");

	// pattern info Fields
	By rpeDate = By.id("antenna-details-rpe-date");
	By rpeField = By.id("antenna-details-rpe");
	By referenceCodeField = By.id("antenna-details-rpe-code");
	By referenceCodeLookupICon = By.xpath(".//*[@id='antenna-details-lookup-trigger']/img");
	By radioRPEDateErrorMessage = By.id("antenna-details-rpe-date-error-message");
	By radioReferenceCodeErrorMessage = By.id("antenna-details-rpe-code-error-message");
	By radioRPEErrorMessage = By.id("antenna-details-rpe-error-message");

	By deleteConfirmButton = By.id("delete-confirmation-modal-delete");
	By radioDeleteMessage= By.id("delete-success-modal-heading");
	By cancelDeleteConfirmButton = By.id("delete-confirmation-modal-cancel");

	By summaryButtonOnRadioDetails = By.id("radio-details-close-form");

	By radioCommentsIcon = By.id("radio-details-new-comment-modal-toggle");

	By radioCommentsField = By.xpath(".//*[@id='db-details-comments-comment']");
	By saveCommentsButton = By.xpath(".//*[@id='db-details-comments']/div[2]/button");

	By fileLocation = By.xpath("//*[@id=\"db-details-comments\"]/div[2]/div/div/input");
	By attachmentRow1 = By.xpath("//*[contains(@id, 'radio-details-comments-table-data-radioCommentId-') and contains(@id,'-attachments')]");

	By attachmentRow2 = By.cssSelector(".drop-zone-list > dd:nth-child(3)");
	By commentsListItem = By.xpath(
			"//*[contains(@id, 'radio-details-comments-table-data-radioCommentId-') and contains(@id,  'radio-details-comments-table-data-radioCommentId-')]");
	By commentItem = By.xpath(
			"//*[contains(@id, 'radio-details-comments-table-data-radioCommentId-') and contains(@id, '-comment')]/span");
	By listRadioCode = By.cssSelector(".radioDb-modal-table-data-radioCode-");
	By listRadioModel = By.cssSelector("#radioDb-modal-table-data-radioModel-");
	By listRadioPwr = By.cssSelector("#radioDb-modal-table-data-txPowerMax-");
	By listRadioThr = By.cssSelector("#radioDb-modal-table-data-rxThreshold-");
	By listRadioFrq = By.cssSelector("#radioDb-modal-table-data-frequency-");
	By listSpecDt = By.cssSelector("#radioDb-modal-table-data-specDate-");
	By radiosearchResultsColumnCode = By.xpath("//*[@id=\"radioDb-modal-table-header-radioCode\"]/div[2]");
	By radiosearchResultsColumnCompanyName = By.xpath("//*[@id=\"radioDb-modal-table-header-companyName\"]/div[2]");
	By radiosearchResultsColumnRadioFamName = By
			.xpath("//*[@id=\"radioDb-modal-table-header-radioFamilyName\"]/div[2]");
	By radiosearchResultsColumnModel = By
			.xpath("//*[@id=\"radioDb-modal-table-header-modelNumberConcatenated\"]/div[2]");
	By radiosearchResultsColumnBandwidth = By.xpath("//*[@id=\"radioDb-modal-table-header-bandwidth\"]/div[2]");
	By radiosearchResultsColumnTxPwrMax = By.xpath("//*[@id=\"radioDb-modal-table-header-txPowerMax\"]/div[2]");
	By radiosearchResultsColumnModulation = By.xpath("//*[@id=\"radioDb-modal-table-header-modulations\"]/div[2]");
	By radiosearchResultsColumnModulationSchDes = By
			.xpath("//*[@id=\"radioDb-modal-table-header-modulationSchemeDescription\"]/div[2]");
	By radiosearchResultsColumnModulationDetail = By
			.xpath("//*[@id=\"radioDb-modal-table-header-modulationDescription\"]/div[2]");
	By radiosearchResultsColumnRxThreshold = By.xpath("//*[@id=\"radioDb-modal-table-header-rxThreshold\"]/div[2]");
	By radiosearchResultsColumnFrequency = By.xpath("//*[@id=\"radioDb-modal-table-header-frequency\"]/div[2]");
	By radiosearchResultsColumnSpecDate = By.xpath("//*[@id=\"radioDb-modal-table-header-specDate\"]/div[2]");
	By radiosearchResultsColumnStatus = By.xpath("//*[@id=\"radioDb-modal-table-header-status\"]/div[2]");
	By sortRadioCode = By.xpath("//*[@id=\"radioDb-modal-table-header-radioCode\"]/div[2]");
	By sortRadioModel = By.xpath(".//*[@id='radioDb-modal-table-header-modelNumberConcatenated']/div[2]");
	By sortRadioPower = By.xpath("//*[@id=\"radioDb-modal-table-header-txPowerMax\"]/div[2]/div/span");
	By sortRadioMbps = By.xpath("//*[@id=\"radioDb-modal-table-header-radioCode\"]/div[2]");
	By sortRadioThreshold = By.xpath("//*[@id=\"radioDb-modal-table-header-rxThreshold\"]/div[2]/div/span");
	By sortRadioFrequency = By.xpath("//*[@id=\"radioDb-modal-table-header-frequency\"]/div[2]");
	By sortRadioSpecDate = By.xpath("//*[@id=\"radioDb-modal-table-header-specDate\"]/div[2]");
	By radioErrMsgSearch = By.id("radio-db-search-error");

	//Radio model Family
	By addModelFamilyIcon=By.id("radio-details-new-model-family-trigger");
	By newModelFamilyNameField=By.id("new-model-family-antenna-company");
	By savedRadioModelFamilies = By.xpath("//*[contains(@id, 'react-autowhatever-new-model-family-antenna-company--item-')]");
	By saveNewModelFamily = By.xpath(".//*[@id='new-model-family']/div[3]/button");
	By modelFamilyErrorMessage =By.id("new-model-family-antenna-company-error-message");
	By blankPage=By.cssSelector("div.ReactModal__Overlay.ReactModal__Overlay--after-open");
	By radioDetailsConfirmButton =By.id("discard-confirmation-modal-discard");
	By radioSaveMessage=By.id("success-modal-heading");
	By radioSaveMessage1=By.id("success-modal-message");
	//Modulation Form
	By modelNumberErrorMessage=By.id("modulation-details-model-number-error-message");
	By modulationSchemaErrorMessage=By.id("modulation-details-modulation-scheme-error-message");
	By maxPowerErrorMessage=By.id("modulation-details-max-power-error-message");
	By emissionDesignatorErrorMessage=By.id("modulation-details-emission-designator-error-message");
	By bandwidthErrorMessage=By.id("modulation-details-emission-bandwidth-error-message");
	By modulationDetailsForm =By.id("modulation-details-close-form");
	By legacyRadioCode = By.id("modulation-details-legacy-radio-code");
	By legacyRadioCodefavoritemodalRadioDetails = By.id("radio-details-legacy-radio-code");

	//Bottom navigation bar
	By createdDateValue=By.id("radio-details-created-date-value");
	By lastUpdatedDateValue=By.id("radio-details-updated-date-value");
	By createdByuserValue=By.id("radio-details-created-user-value");
	By modifiedByUserValue=By.id("radio-details-updated-user-value");
	By radioDelete = By.id("radio-details-delete");
	By radioDeleteConfirmation = By.id("delete-confirmation-modal-delete");
	By saveButton= By.xpath("//button[contains(text(),'save')]");
	By deleteButton= By.xpath("//button[contains(text(),'delete')]");
	By deleteAttachmentComment=By.cssSelector(".fa.fa-times-circle-o.margin-left-half.pointer.text-red");
	By deletecommentConfirmation = By.xpath("//button[contains(text(),'Confirm')]");
	By deleteCommentnotificationMessage=By.cssSelector(".notification-message");

	//Radio Favorites
	By radioFavoritesButton = By.id("radio-details-radio-favorites-modal-trigger");
	By radioFavoritesicon = By.cssSelector(".heading-font");
	By radioFavoritesFavoriteCode = By.xpath("//*[contains(@id, 'radio-details-favorite-sets-table-data-radioFavoriteId-') and contains(@id,'-favoriteRadioCode')]");
	By frequencyOffset3rdRow=By.id("modulation-details-curves[T/I][2]-frequencySep");
	By filterReferenceCodeField= By.id("modulation-details-filter-reference-code");
	By radioDatabaseClear= By.id("radio-db-search-clear");
	By advancedSearchLink =By.id("radio-db-search--advanced-search-show");
	By radioFavoriteModalCloseIcon = By.id("radio-details-close-modal");
	By radioFavoriteMaxPower = By.id("radio-details-max-power");
	By power =By.cssSelector(".display-flex");
	By legacyRadioCodeLabel = By.id("modulation-details-legacy-radio-code-label");
	By legacyRadioCodeField = By.id("modulation-details-legacy-radio-code");
	By errorListHeader = By.id("radio-details-error-list-0-header");
	By errorMessage0 = By.id("radio-details-error-list-0-message-0");
	By errorMessage1 = By.id("radio-details-error-list-0-message-1");
	By errorMessage2 = By.id("radio-details-error-list-0-message-2");

	public void evaluateCreateButtonIsNotPresentAndExprortIsDisabled() {
		slowDown(3);
		assertTrue(waitUntilNotPresent(radioCreateButton, 5));
		assertTrue(isDisplayed(radioSearchButton, 5));
		assertTrue(!isDisplayed(radioExportButton, 5));
	}

	public void evaluateCreateButtonIsNotPresent() {
		slowDown(3);
		assertTrue(waitUntilNotPresent(radioCreateButton, 5));
		assertTrue(isDisplayed(radioSearchButton, 5));
		assertTrue(isDisplayed(radioExportButton, 5));
	}

	public void evaluateCreateButtonIsPresent() {
		slowDown(3);
		assertTrue(isDisplayed(radioCreateButton, 5));
		isDisplayed(radioSearchButton, 5);
		isDisplayed(radioExportButton, 5);
	}

	/**
	 * Opens the Radio Db module
	 */
	public void accessRadioDataBase() {
		slowDown(4);
		assertTrue("Radio database link is not present", isDisplayed(radioDataBaseLink, 35));
		click(radioDataBaseLink);
		assertTrue(isDisplayed(radioDbRadioCodeField, 20));
	}

	/**
	 * This method gets the first one from the list of manufacturers from radio
	 * search page
	 */
	public String getAnExistingManufacturer() {
		assertTrue("Manufacturer autosuggest list is not present", isDisplayed(manufacturerAutoSuggest, 4));
		String existingManufacturerRow1 = getTextPlural(manufacturerAutoSuggest, 9);
		return existingManufacturerRow1;

	}

	/**
	 * This method gets the first one from the list of manufacturers from radio
	 * details page
	 */
	public String getAnExistingManufacturerFromRadioDetailsPageAutoSuggest() {
		assertTrue("Manufacturer autosuggest list is not present", isDisplayed(manufacturerAutoSuggestRadioDetails, 5));
		String existingManufacturerRow1 = getTextPlural(manufacturerAutoSuggestRadioDetails, 4);
		return existingManufacturerRow1;

	}

	/**
	 * This method gets the first one from the list of model family from radio
	 * details page
	 */
	public String getAnExistingModelFamilyFromRadioDetailsPageAutoSuggest() {
		assertTrue("Model Family autosuggest list is not present", isDisplayed(modelFamilyAutoSuggestRadioDetails, 5));
		String existingManufacturerRow1 = getTextPlural(modelFamilyAutoSuggestRadioDetails, 0);
		return existingManufacturerRow1;

	}

	/**
	 * 
	 * Basic Antenna search using manufacturer, model family and model and
	 * autosuggest functionality
	 */
	public void radioBasicSearch_BasicSearchValidation() {
		assertTrue("Radio code field in Radio database is missing", isDisplayed(radioDbRadioCodeField, 20));
		isDisplayed(radioDbRadioCodeField, 20);
		clear(radioDbRadioCodeField);
		clear(radioDbRadioCompanyField);
		clear(radioDbModelFamilyField);
		clear(radioDbRadioModelField);
		click(radioDbRadioCompanyField);
		assertTrue("Manufacturer auto suggest list is missing", isDisplayed(manufacturerAutoSuggest, 3));
		String radioManufacturerText = getAnExistingManufacturer();
		String radioManufacturerPartialText = radioManufacturerText.substring(0, 3);
		// Type in the first 3 letters of the manufacturer company.
		type(radioManufacturerPartialText, radioDbRadioCompanyField);
		// verifying whether the auto-suggest list is filtered based on the
		// manufacturer value typed in the field
		int rows = getRows(manufacturerAutoSuggest);
		for (int i = 0; i < rows; i++) {
			String lineItemInList;
			String partialLineItemList;
			// try and catch would be inside the for loop
			try {
				lineItemInList = getTextPlural(manufacturerAutoSuggest, i);
				partialLineItemList = lineItemInList.substring(0, 3);
				assertEquals(partialLineItemList, radioManufacturerPartialText);
			} catch (java.lang.AssertionError failure) {
				throw failure;
			}
		}
		clear(radioDbRadioCompanyField);
		type(radioManufacturerText, radioDbRadioCompanyField);
		slowDown(1);
		clickJS(manufacturerAutoSuggest);
		type("a", radioDbModelFamilyField);
		slowDown(3);
		//This functionality is currently not in place but will be in the future
		//assertTrue("Radio model family auto suggest list doesn't appears", isDisplayed(modelFamilyAutoSuggest, 4));
		clear(radioDbModelFamilyField);
		click(radioSearchButton);
		clickJS(radioSearchButton);
		assertTrue("Search Results is not Displayed", isDisplayed(radioDbRadioCodeResult, 30));
		click(radioDbRadioCodeResult);
		slowDown(3);
		String radioManufacturerFieldValue = getFieldText(radioDbbasicInformationCompany);
		assertEquals(radioManufacturerText, radioManufacturerFieldValue);
		// get the next search parameter from the existing data
		String radioModelFamilyFieldValue = getFieldText(radioDbbasicInformationModelFamily);
		click(summaryButtonOnRadioDetails);
		assertTrue("Search Results is not Displayed", isDisplayed(radioDbRadioCodeResult, 100));
		click(radioDatabaseClear);
		slowDown(1);
		type(radioManufacturerText, radioDbRadioCompanyField);
		slowDown(1);
		clickJS(manufacturerAutoSuggest);
		clear(radioDbModelFamilyField);
		type(radioModelFamilyFieldValue, radioDbModelFamilyField);
		click(radioSearchButton);
		clickJS(radioSearchButton);
		assertTrue("Search Results is not Displayed", isDisplayed(radioDbRadioCodeResult, 180));
		if ( isDisplayed(radioDbRadioCodeResult, 20)) {
		}else {
			click(radioSearchButton);
			assertTrue("Search Results is not Displayed", isDisplayed(radioDbRadioCodeResult, 180));
		}  
		assertTrue("Search Results is not Displayed", isDisplayed(radioDbRadioCodeResult, 20));
		clear(radioDbRadioCodeField);
		clear(radioDbRadioCompanyField);
		clear(radioDbRadioModelField);
		clear(radioDbRadioCompanyField);
		type(radioManufacturerText, radioDbRadioCompanyField);
		clear(radioDbModelFamilyField);
		type(radioModelFamilyFieldValue, radioDbModelFamilyField);
		type("a", radioDbRadioModelField);
		assertTrue("Radio model auto suggest list doesn't appears", isDisplayed(modelFieldAutoSuggest, 20));

	}
	/** 
	 * this method creates radio
	 * 
	 */
	public String createRadio(String lowfreq, String highFreq) {
		assertTrue("Radio code field in Radio database is missing", isDisplayed(radioDbRadioCodeField, 20));
		click(radioCreateButton);
		slowDown(2);
		assertTrue("Radio code field in Radio database details page is missing",isDisplayed(newRadioDbbasicInformationCode, 20));
		String radioCode = getFieldText(newRadioDbbasicInformationCode);
		// Verify error messages
		click(createNewRadioButton);
		slowDown(4);
		verifyRadioDetailsInRadioDatabase();
		click(newRadioDbbasicInformationCompany);
		assertTrue("Manufacturer auto suggest list is missing", isDisplayed(manufacturerAutoSuggestRadioDetails, 3));
		String radioManufacturerText = getAnExistingManufacturerFromRadioDetailsPageAutoSuggest();
		clear(newRadioDbbasicInformationCompany);
		type(radioManufacturerText, newRadioDbbasicInformationCompany);
		// manufacturer in the suggestion list
		clickJS(manufacturerAutoSuggestRadioDetails);
		// getting a date in the future
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		String todaysDate = dateFormat.format(today);
		type(todaysDate, newRadioDbbasicInformationSpecDate);
		click(newRadioDbTechnicalInformationStability);
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.000001");
		type(lowfreq, newRadioDbTechnicalInformationLowFrequency);
		type(highFreq, newRadioDbTechnicalInformationHighFrequency);
		selectFromDropdown(newRadioDbModulationInformationModulationType, "Adaptive");
		slowDown(2);
		addModulationInRadioDetailsPage("T1","128 QAM", "30", "180","30M0D7W","30");
		click(createNewRadioButton);
		return radioCode;
	}

	/**
	 * This method creates new radio in the radio database and verifies the
	 * radio gets created properly
	 * @param lowFreq
	 * @param highFreq
	 */
	public String createNewRadioInRadioDatabase_VerifySave(String lowfreq, String highFreq) {
		//LEGO-2796
		String radioCode=createRadio(lowfreq,highFreq);
		// Perform a search for the created radio in the radio database search
		// page.
		verifyRadioSaveMessageAndClickReturn();
		assertTrue("Radio code field is missing in the Radio Database search page", isDisplayed(radioDbRadioCodeField, 20));
		clear(radioDbRadioCodeField);
		clear(radioDbRadioCompanyField);
		clear(radioDbModelFamilyField);
		clear(radioDbRadioModelField);
		type(radioCode, radioDbRadioCodeField);
		click(radioSearchButton);
		slowDown(3);
		assertTrue("Search Results is not Displayed", isDisplayed(radioDbRadioCodeResult, 10));
		click(radioDbRadioCodeResult);
		slowDown(4);
		String radioCodeValue = getFieldText(newRadioDbbasicInformationCode);
		assertEquals(radioCodeValue, radioCode);
		click(radioSummaryButtonInRadioDetailsPage);
		assertTrue("Radio code field is missing in the Radio Database search page",
				isDisplayed(radioDbRadioCodeField, 4));
		return radioCodeValue;
	}
	
	
	/**
	 * This method is to edit existing radio
	 */
	/**
	 * 
	 * @param radioCode - Radio code
	 * @param modelModulation - Modulation Model
	 * @param modulationScheme - Modulation Schema
	 * @param modulationMaxPower - Modulation Max power
	 * @param throughput - Throughput
	 * @param emissionDesignatorMod - Emission Designator
	 * @param EmissionBandwidthMod - Emission Bandwidth
	 */

	public void editExistingRadioInRadioDatabase_VerifySave(String radioCode, String modelModulation,String modulationScheme, String modulationMaxPower,String throughput,String emissionDesignatorMod ,String EmissionBandwidthMod) {
		searchRadioDatabase(radioCode,"","","", "", "");
		clickSearchResultsFromRadioDatabaseSearch();
		slowDown(4);
		assertTrue("Radio details page is missing", isDisplayed(createNewRadioButton, 10));
		clickJS(removeRadioModulation);
		assertTrue("notification is missing", isDisplayed(notification, 20));
		assertEquals ("Modulation was deleted successfully.",getText(notification));
		addModulationInRadioDetailsPage(modelModulation,modulationScheme,modulationMaxPower, throughput,emissionDesignatorMod,EmissionBandwidthMod);
		assertTrue("Save radio is missing", isDisplayed(createNewRadioButton, 10));
		click(createNewRadioButton);
		verifyRadioUpdateMessage();
		assertTrue("Radio code field is missing in the Radio Database search page", isDisplayed(radioDbRadioCodeField, 4));
		clear(radioDbRadioCodeField);
		searchRadioDatabase(radioCode,"","","", "", "");
		clickSearchResultsFromRadioDatabaseSearch();
		slowDown(4);
		assertTrue("Save radio is missing", isDisplayed(createNewRadioButton, 3));
		//Click saved modulation
		click(radioDbModulationDetailsSavedModulation);
		slowDown(2);
		String modelModulationDetails=getFieldText(modulationDetailsModel);
		String emissionDesignator=getFieldText(modulationDetailsEmissionDesignator);
		String throughPut=getFieldText(modulationDetailsThroughput);
		assertEquals(modelModulationDetails,"T2");
		assertEquals(emissionDesignator,"60M0D7W");
		assertEquals(throughPut,"100");
		click(modulationRadioSummary);
		slowDown(4);
		assertTrue("create new radio button missing", isDisplayed(createNewRadioButton, 50));
		click(createNewRadioButton);
		slowDown(2);
	}

	/**
	 * This method is to Add modulation in Radio details page
	 */
	/**
	 * 
	 * @param type - modulation model
	 * @param modulationScheme - modulation scheme
	 * @param modulationMaxPower - max power
	 * @param throughput - Throughtput
	 * @param emissionDesignator - Emission Designator
	 * @param emissionBandwidthMod - modulation bandwidth
	 */
	public void addModulationInRadioDetailsPage(String type, String modulationScheme, String modulationMaxPower, String throughput, String emissionDesignator,  String emissionBandwidthMod ) {
		clickAddModulationOnRadioDetails();
		// Modulation Details
		assertTrue("Modulation details model field is missing", isDisplayed(modulationDetailsModel, 20));
		type(type, modulationDetailsModel);
		selectFromDropdown(modulationDetailsModulationScheme, modulationScheme);
		type(modulationMaxPower, modulationDetailsModulationMaxPower);
		type(throughput, modulationDetailsThroughput);
		type(emissionDesignator, modulationDetailsEmissionDesignator);
		click(modulationDetailsSaveModulationButton);
		slowDown(2);
	}
	/**
	 * This method is to click the first one from the radio database search results
	 *
	 */
	public void clickSearchResultsFromRadioDatabaseSearch() {
		assertTrue("Search Results is not Displayed", isDisplayed(radioDbRadioCodeResult, 10));
		click(radioDbRadioCodeResult);
		slowDown(1);
	}

	/**
	 * This method is to delete a Radio
	 */
	/**
	 * 
	 * @param radioCode - Radio Code
	 */
	public void deleteRadioFromRadioDatabase(String radioCode) {
		verifyRadioUpdateMessage();
		assertTrue("Radio code field is missing in the Radio Database search page",isDisplayed(radioDbRadioCodeField, 4));
		clear(radioDbRadioCodeField);
		type(radioCode, radioDbRadioCodeField);
		click(radioSearchButton);
		slowDown(2);
		assertTrue("Search Results is not Displayed", isDisplayed(radioDbRadioCodeResult, 10));
		click(radioDbRadioCodeResult);
		assertTrue("Manufacturer field in Radio details page is missing",isDisplayed(newRadioDbbasicInformationCompany, 100));
		click(radioDeleteButtonRadioDetailsPage);
		slowDown(2);
		click(deleteConfirmButton);
		assertTrue("radioDbRadioCodeField is missing",isDisplayed(radioDbRadioCodeField, 100));
		clear(radioDbRadioCodeField);
		type(radioCode, radioDbRadioCodeField);
		click(radioSearchButton);
		if (isDisplayed(radioDbRadioCodeResult, 10)) {
			// The next code to make the script fail when the radio deletion
			// fails
			assertTrue("Radio deletion failed", isDisplayed(newRadioDbbasicInformationCompany, 20));
		}

	}

	/**
	 * This method click 'Create' button on the radio database search page
	 */
	public void clickCreateRadioButton() {
		assertTrue("Radio code field in Radio database is missing", isDisplayed(radioDbRadioCodeField, 20));
		click(radioCreateButton);
		slowDown(2);
		assertTrue("Radio code field in Radio database details page is missing",isDisplayed(newRadioDbbasicInformationCode, 20));
	}
	/**
	 * this method is to fill in high and low frequency
	 * @Param highFreq
	 * @param  lowFreq
	 */
	public void fillInHighAndLowFrequency(String lowFreq, String highFreq) {
		assertTrue("Radio code field in Radio database details page is missing",isDisplayed(newRadioDbbasicInformationCode, 20));
		type(lowFreq, newRadioDbTechnicalInformationLowFrequency);
		type(highFreq, newRadioDbTechnicalInformationHighFrequency);
	}

	/**
	 * This method validates the fields in the basic information section of the
	 * Radio Details form
	 */
	public void basicInformationRadioFormFieldValidation() {
		// Radio code field validation
		assertTrue("Radio code field in Radio database details page is missing",isDisplayed(newRadioDbbasicInformationCode, 20));
		String radioCode = getFieldText(newRadioDbbasicInformationCode);
		if (radioCode == null) {
			// The next code to make the script fail when the radio code is
			// null.
			assertTrue("Radio code is null in radio details page", isDisplayed(radioCreateButton, 2));
		}
		int numberOFCharactersRadioCode = radioCode.length();
		assertEquals(numberOFCharactersRadioCode, RADIO_CODE_LENGTH);

		// manufacturer field validation
		click(newRadioDbbasicInformationCompany);
		assertTrue("Manufacturer auto suggest list is missing", isDisplayed(manufacturerAutoSuggestRadioDetails, 3));
		String radioManufacturerText = getAnExistingManufacturerFromRadioDetailsPageAutoSuggest();
		String radioManufacturerPartialText = radioManufacturerText.substring(0, 3).toLowerCase();
		// Type in the first 3 letters of the manufacturer company.
		type(radioManufacturerPartialText, newRadioDbbasicInformationCompany);
		// verifying whether the auto-suggest list is filtered based on the
		// manufacturer value typed in the field
		int rows = getRows(manufacturerAutoSuggestRadioDetails);
		for (int i = 0; i < rows; i++) {
			String lineItemInList;
			String partialLineItemList;
			// try and catch would be inside the for loop
			try {
				lineItemInList = getTextPlural(manufacturerAutoSuggestRadioDetails, i);
				partialLineItemList = lineItemInList.substring(0, 3).toLowerCase();
				assertEquals(partialLineItemList, radioManufacturerPartialText);
			} catch (java.lang.AssertionError failure) {
				throw failure;
			}
		}
		clear(newRadioDbbasicInformationCompany);
		type(radioManufacturerText, newRadioDbbasicInformationCompany);
		type("A", newRadioDbbasicInformationSpecDate);
		click(newRadioDbTechnicalInformationLowFrequency);
		String errorMessage1 = getText(newRadioDbbasicInformationSpecDateErrorMessage);
		assertEquals(errorMessage1, "Invalid date format: YYYY/MM/DD");
		clear(newRadioDbbasicInformationSpecDate);
		// getting a date in the future
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Date today = cal2.getTime();
		String todaysDate = dateFormat.format(today);
		cal.add(Calendar.DATE, +1);
		Date tomorrow = cal.getTime();
		String futureDate = dateFormat.format(tomorrow);
		type(futureDate, newRadioDbbasicInformationSpecDate);
		click(newRadioDbTechnicalInformationLowFrequency);
		String errorMessage2 = getText(newRadioDbbasicInformationSpecDateErrorMessage);
		assertEquals(errorMessage2, "Cannot be in the future.");
		clear(newRadioDbbasicInformationSpecDate);
		type(todaysDate, newRadioDbbasicInformationSpecDate);
		click(newRadioDbTechnicalInformationLowFrequency);

		// Status field validation
		assertTrue("Status dropdown is missing", isDisplayed(newRadioDbbasicInformationStatus, 3));
		selectFromDropdown(newRadioDbbasicInformationStatus, "Active");
		assertTrue("Radio status icon - Green in radio details page is missing",isDisplayed(radioDbbasicInformationStatusIconGreen, 3));

		selectFromDropdown(newRadioDbbasicInformationStatus, "Inactive");
		assertTrue("Radio status icon - Yellow in radio details page is missing",isDisplayed(radioDbbasicInformationStatusIconYellow, 3));

		selectFromDropdown(newRadioDbbasicInformationStatus, "Invalid");
		assertTrue("Radio status icon - Red in radio details page is missing",isDisplayed(radioDbbasicInformationStatusIconRed, 3));

	}

	/**
	 * Technical information form field validation in radio details page.
	 */
	public void technicalInformationRadioFormFieldValidation() {
		assertTrue("Radio type Analog button is missing", isDisplayed(newRadioDbtechnicalInformationAnalog, 20));
		assertTrue("Radio type Digital button is missing", isDisplayed(newRadioDbtechnicalInformationDigital, 20));
		assertTrue("Radio type Repeater button is missing",isDisplayed(newRadioDbtechnicalInformationTypeRepeater, 20));

		// Verify error messages
		click(createNewRadioButton);
		slowDown(4);
		String errorMessageStability = getText(newRadioDbbasicInformationStabilityErrorMessage);
		String errorMessageLoFrequency = getText(newRadioDbbasicInformationLowFrequencyErrorMessage);
		String errorMessageHiFrequency = getText(newRadioDbbasicInformationHighFrequencyErrorMessage);

		assertEquals(errorMessageStability, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageLoFrequency, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageHiFrequency, REQUIRED_ERROR_MESSAGE);

		selectFromDropdown(newRadioDbTechnicalInformationArchitecture, "IDU");
		selectFromDropdown(newRadioDbTechnicalInformationArchitecture, "ODU");
		selectFromDropdown(newRadioDbTechnicalInformationArchitecture, "Split");

		selectFromDropdown(newRadioDbTechnicalInformationPowerOption, "SP");
		selectFromDropdown(newRadioDbTechnicalInformationPowerOption, "HP");
		selectFromDropdown(newRadioDbTechnicalInformationPowerOption, "EHP");
		selectFromDropdown(newRadioDbTechnicalInformationPowerOption, "VHP");

		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.000001");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0000015");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.000005");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.00001");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0001");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.00015");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0002");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.00025");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0003");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.00035");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0004");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0005");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0006");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0007");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0008");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.001");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0015");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.002");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0025");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.003");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.004");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0045");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.005");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.0064");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.009");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.01");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.01");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.015");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.02");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.03");
		selectFromDropdown(newRadioDbTechnicalInformationStability, "0.05");

		type("10700", newRadioDbTechnicalInformationLowFrequency);
		click(newRadioDbTechnicalInformationHighFrequency);
		String errorMessageLowFrequency = getText(newRadioDbbasicInformationLowFrequencyErrorMessage);
		assertEquals("Must be <= High Frequency.", errorMessageLowFrequency);
		type("9000", newRadioDbTechnicalInformationHighFrequency);
		click(newRadioDbTechnicalInformationLowFrequency);
		String errorMessageHighFrequency = getText(newRadioDbbasicInformationHighFrequencyErrorMessage);
		assertEquals("Must be >= Low Frequency.", errorMessageHighFrequency);
		clear(newRadioDbTechnicalInformationHighFrequency);
		type("-9000", newRadioDbTechnicalInformationHighFrequency);
		click(newRadioDbTechnicalInformationLowFrequency);
		String errorMessageHighFrequencyNegativeValue = getText(newRadioDbbasicInformationHighFrequencyErrorMessage);
		assertEquals("Must be greater than or equal zero.", errorMessageHighFrequencyNegativeValue);
		clear(newRadioDbTechnicalInformationHighFrequency);

		assertTrue("Narrow BW RF filter Yes button is missing",
				isDisplayed(newRadioDbTechnicalInformationNarrowBWRFFilterYes, 20));
		assertTrue("Narrow BW RF filter No button is missing",
				isDisplayed(newRadioDbTechnicalInformationNarrowBWRFFilterNo, 20));
		assertTrue("Narrow BW RF filter NA button is missing",
				isDisplayed(newRadioDbTechnicalInformationNarrowBWRFFilteNA, 20));

		selectFromDropdown(newRadioDbTechnicalInformationDuplexMode, "Frequency Division");
		selectFromDropdown(newRadioDbTechnicalInformationDuplexMode, "Time Division");
		selectFromDropdown(newRadioDbTechnicalInformationDuplexMode, "Frequency or Time Division");


	}

	/**
	 * This method validates the ATPC section of Radio Details
	 */
	public void radioDetailsATPCValidation() {
		assertTrue("ATPC Flag 'Yes' is missing", isDisplayed(newRadioDbbasicInformationATPCYes, 3));
		assertTrue("ATPC Flag 'No' is missing", isDisplayed(newRadioDbbasicInformationATPCNo, 3));
		assertTrue("ATPC Flag 'N/A' is missing", isDisplayed(newRadioDbbasicInformationATPCNA, 3));
		assertTrue("ATPC Type 'Ramp' is missing", isDisplayed(newRadioDbbasicInformationATPCTypeRamp, 3));
		assertTrue("ATPC Type 'Step' is missing", isDisplayed(newRadioDbbasicInformationATPCTypeStep, 3));
		assertTrue("ATPC Type 'N/A' is missing", isDisplayed(newRadioDbbasicInformationATPCTypeNA, 3));
		click(newRadioDbbasicInformationATPCYes);
		click(newRadioDbbasicInformationATPCTypeRamp);

	}

	/**
	 * This method validates the Modulation Information section of Radio Details
	 */
	public void radioDetailsModulationInformationValidation() {
		assertTrue("Modulation Type dropdown is missing",
				isDisplayed(newRadioDbModulationInformationModulationType, 3));
		assertTrue("Modulation Limit field is missing", isDisplayed(newRadioDbModulationInformationModulationLimit, 3));
		assertTrue("Dynamic ACM Power 'Yes' button is missing",
				isDisplayed(newRadioDbModulationInformatioDynamicACMPowerYes, 3));
		assertTrue("Dynamic ACM Power 'No' button is missing",
				isDisplayed(newRadioDbModulationInformatioDynamicACMPowerNo, 3));
		assertTrue("Dynamic ACM Power 'N/A' button is missing",
				isDisplayed(newRadioDbModulationInformatioDynamicACMPowerNA, 3));
		selectFromDropdown(newRadioDbModulationInformationModulationType, "Adaptive");
		slowDown(1);
		String modulationLimit = getFieldText(newRadioDbModulationInformationModulationLimit);
		assertEquals("", modulationLimit);
		selectFromDropdown(newRadioDbModulationInformationModulationType, "Fixed");
		slowDown(1);
		String modulationLimitNew = getFieldText(newRadioDbModulationInformationModulationLimit);
		assertEquals("1", modulationLimitNew);
		selectFromDropdown(newRadioDbModulationInformationModulationType, "Adaptive");
		clear(newRadioDbModulationInformationModulationLimit);
		type("-21", newRadioDbModulationInformationModulationLimit);
		click(newRadioDbTechnicalInformationLowFrequency);
		String errorMEssageModulationLimit = getText(newRadioDbModulationInformatioModulationLimitErrorMessage);
		assertEquals("Must be greater than or equal zero.", errorMEssageModulationLimit);
		click(newRadioDbModulationInformatioDynamicACMPowerYes);
		click(newRadioDbModulationInformatioDynamicACMPowerNo);
		click(newRadioDbModulationInformatioDynamicACMPowerNA);

	}

	/**
	 * This method is to validate channel restrictions in radio details page
	 */
	public void radioDetailsChannelRestrictionValidation() {
		assertTrue("XPIC Yes button is missing", isDisplayed(channelRestrictionXPICYes, 3));
		assertTrue("XPIC No button is missing", isDisplayed(channelRestrictionXPICNo, 3));
		assertTrue("XPIC N/A button is missing", isDisplayed(channelRestrictionXPICNA, 3));
		assertTrue("ACCP Yes button is missing", isDisplayed(channelRestrictionACCPYes, 3));
		assertTrue("ACCP No button is missing", isDisplayed(channelRestrictionACCPNo, 3));
		assertTrue("ACCP N/A button is missing", isDisplayed(channelRestrictionACCPNA, 3));
		assertTrue("ACAP Yes button is missing", isDisplayed(channelRestrictionACAPYes, 3));
		assertTrue("ACAP No button is missing", isDisplayed(channelRestrictionACAPNo, 3));
		assertTrue("ACAP N/A button is missing", isDisplayed(channelRestrictionACAPNA, 3));
		click(channelRestrictionXPICYes);
		click(channelRestrictionXPICNo);
		click(channelRestrictionXPICNA);
		click(channelRestrictionACCPYes);
		click(channelRestrictionACCPNo);
		click(channelRestrictionACCPNA);
		click(channelRestrictionACAPYes);
		click(channelRestrictionACAPNo);
		click(channelRestrictionACAPNA);
	}

	/**
	 * Opens the comments tool
	 */
	public void openComments() {
		assertTrue("Add comment iscon is missing", isDisplayed(radioCommentsIcon,50));
		slowDown(3);
		clickJS(radioCommentsIcon);
		assertTrue(isDisplayed(radioCommentsField, 10));
	}

	/**
	 * @param commentText
	 *            String - Comment to be entered
	 */
	public void enterComments(String comment) {
		assertTrue(isDisplayed(radioCommentsField, 10));
		type(comment, radioCommentsField);
	}

	/**
	 * Save the comment
	 */
	public void saveComments() {
		assertTrue(isDisplayed(saveCommentsButton, 12));
		click(saveCommentsButton);
	}

	/**
	 * @param commentText
	 *            String - Comment to be evaluated
	 */
	public void evaluateComment(String commentText) {
		isDisplayed(radioCommentsField, 12);
		String commentsFieldValue = getFieldText(radioCommentsField);
		assertEquals(commentsFieldValue, commentText);
	}

	/**
	 * @param fileName
	 *            - File to upload
	 */
	public void selectAndUploadFile(String fileName) {
		uploadFile(fileName, fileLocation, saveCommentsButton);
	}

	/**
	 * @param fileNames
	 *            - Multiple Files to upload
	 */
	public void selectAndUploadFiles(String fileName) {
		uploadFileMulti(fileName, fileLocation, saveCommentsButton);
	}

	/**
	 * @param row
	 * @param attachmentName
	 */
	public void evaluateAttachmentList(int row, String attachmentName) {
		String attachmentText = getTextPlural(attachmentRow1, row);
		assertEquals(attachmentText, attachmentName);
	}

	/**
	 * Loops through the CommentList and compares the comment field value
	 */
	public void evaluateCommentPresence() {
		slowDown(5);
		int rows = finds(commentItem).size();
		// Then loop through and do your check
		for (int i = 0; i < rows; i++) {
			// try and catch would be inside the for loop
			try {
				checkCommentsList("This comment field is new can be used for lots of comments", i);
			} catch (org.junit.ComparisonFailure failure) {
				// in the catch you would check to see if there are any more
				// rows left.
				if (i >= rows) {
					throw failure;
				}
			}
			i++;
		}
	}

	/**
	 * @param comment
	 * @param row
	 */
	public void checkCommentsList(String comment, int i) {
		String listComment;
		listComment = getTextPlural(commentItem, i);
		assertEquals(comment, listComment);

	}

	/**
	 * @param radioCodeText
	 *            - String search by Radio Code
	 * @param radioCompanyText
	 *            - String search by Radio Company Text
	 * @param radioModelFamilyText
	 *            - String search by Radio Model Family Text
	 * @param radioModelText
	 *            - String search by Radio Model Text
	 * @param radioEmissBandwidth
	 *            - String search by Radio EmissionBandwidth Text
	 * @param radioFreqText
	 *            - String search by Radio Frequency Text
	 */
	public void searchRadioDatabase(String radioCodeText, String radioCompanyText, String radioModelFamilyText,
			String radioModelText, String radioEMiBand, String radioFreqText) {
		assertTrue(isDisplayed(radioDbRadioCodeField, 10));
		clear(radioDbRadioCodeField);
		clear(radioDbRadioCompanyField);
		clear(radioDbModelFamilyField);
		clear(radioDbRadioModelField);
		clear(radioEmissionBandwidthField);
		clear(radioDbFrequencyField);
		clear(radioDbRadioCodeField);
		slowDown(1);
		type(radioCodeText, radioDbRadioCodeField);
		type(radioCompanyText, radioDbRadioCompanyField);
		type(radioModelFamilyText, radioDbModelFamilyField);
		type(radioModelText, radioDbRadioModelField);
		type(radioEMiBand, radioEmissionBandwidthField);
		type(radioFreqText, radioDbFrequencyField);
		slowDown(2);
		click(radioSearchButton);
		assertTrue("Radio search results are missing", isDisplayed(radioDbRadioCompanyResult, 100));

	}

	/**
	 * @param radioThroughput
	 *            - String search by Radio Throughput Text
	 * @param radioFilterRefCode
	 *            - String search by Radio Filter Reference Text
	 * @param radioModulation
	 *            - String search by Radio Model Text
	 * @param radioPower
	 *            - String search by Radio Power Text
	 */
	public void advanceSearchInRadioDatabase(String radioThroughput, String radioFilterRefCode, String radioModulation,
			String radioPower) {
		slowDown(3);
		click(radioDbAdvancedSearchLink);
		slowDown(1);
		//double search
		if(!isDisplayed(radioDbStatus,20))
			clickJS(radioDbAdvancedSearchLink);	
		selectFromDropdown(radioDbStatus, "Active");
		type(radioThroughput, radioDbThroughPut);
		type(radioFilterRefCode, radioDbFilterReferenceCode);
		type(radioModulation, radioDbModulation);
		type(radioPower, radioDbPower);
		click(radioSearchButton);
		slowDown(2);
		assertTrue("Radio search results are missing", isDisplayed(radioDbRadioCompanyResult, 5));

	}

	/**
	 * This method looks for the basic and advance search fields in the Radio
	 * Database search screen
	 */
	public void checkSearcFieldsInRadioDataBase() {
		assertTrue("Radio code field in Radio database is missing", isDisplayed(radioDbRadioCodeField, 5));
		assertTrue("Radio Manufacturer field in Radio database is missing", isDisplayed(radioDbRadioCompanyField, 5));
		assertTrue("Radio Model Family field in Radio database is missing", isDisplayed(radioDbModelFamilyField, 5));
		assertTrue("Radio Model field in Radio database is missing", isDisplayed(radioDbRadioModelField, 5));
		assertTrue("Radio Emission Bandwidth field in Radio database is missing",
				isDisplayed(radioEmissionBandwidthField, 5));
		assertTrue("Radio Frequency field in Radio database is missing", isDisplayed(radioDbFrequencyField, 5));
		assertTrue("Create field in Radio database is missing", isDisplayed(radioCreateButton, 5));
		assertTrue("Search field in Radio database is missing", isDisplayed(radioSearchButton, 5));
		assertTrue("Export field in Radio database is missing", isDisplayed(radioExportButton, 5));
		assertTrue("Radio search Link is missing", isDisplayed(radioDbAdvancedSearchLink, 5));
		click(radioDbAdvancedSearchLink);
		slowDown(1);
		//double search
		if(!isDisplayed(radioDbStatus,20))
			clickJS(radioDbAdvancedSearchLink);
		slowDown(1);
		assertTrue("Status dropdown in Radio database is missing", isDisplayed(radioDbStatus, 5));
		assertTrue("Modulation Type All in Radio database is missing", isDisplayed(radioDbModulationTypeAll, 5));
		assertTrue("Modulation Type Adaptive in Radio database is missing", isDisplayed(radioDbModulationTypeAdap, 5));
		assertTrue("Modulation Type Fixed Radio database is missing", isDisplayed(radioDbModulationTypeFxd, 5));
		assertTrue("Modulation field in Radio database is missing", isDisplayed(radioDbModulation, 5));
		assertTrue("Modulation Detail field in Radio database is missing", isDisplayed(radioDbModulationDetail, 5));
		assertTrue("Throughput field in Radio database is missing", isDisplayed(radioDbThroughPut, 5));
		assertTrue("Architecture field in Radio database is missing", isDisplayed(radioDbArchitecture, 5));
		assertTrue("Power Option field in Radio database is missing", isDisplayed(radioDbPowerOption, 5));
		assertTrue("Power field in Radio database is missing", isDisplayed(radioDbPower, 5));
		assertTrue("Radio Type field in Radio database is missing", isDisplayed(radioDbRadioType, 5));
		assertTrue("Filter Reference Code field in Radio database is missing",
				isDisplayed(radioDbFilterReferenceCode, 5));
	}

	/**
	 * This method checks for the columns names in the radio search results
	 * table
	 */
	public void checkColumnNamesInSearchResultTable() {
		assertTrue("Results column Radio Code is missing", isDisplayed(radiosearchResultsColumnCode));
		assertTrue("Results column Manufacturer Name is missing", isDisplayed(radiosearchResultsColumnCompanyName));
		//assertTrue("Results column Radio Family Name is missing", isDisplayed(radiosearchResultsColumnRadioFamName));
		assertTrue("Results column Model is missing", isDisplayed(radiosearchResultsColumnModel));
		assertTrue("Results column Bandwidth is missing", isDisplayed(radiosearchResultsColumnBandwidth));
		assertTrue("Results column TxPwrMax is missing", isDisplayed(radiosearchResultsColumnTxPwrMax));
		assertTrue("Results column Modulation is missing", isDisplayed(radiosearchResultsColumnModulation));
		assertTrue("Results column Modulation Scheme Description is missing",
				isDisplayed(radiosearchResultsColumnModulationSchDes));
		assertTrue("Results column Modulation Detail is missing",
				isDisplayed(radiosearchResultsColumnModulationDetail));
		assertTrue("Results column RxThreshold is missing", isDisplayed(radiosearchResultsColumnRxThreshold));
		assertTrue("Results column Frequency is missing", isDisplayed(radiosearchResultsColumnFrequency));
		assertTrue("Results column Spec Date is missing", isDisplayed(radiosearchResultsColumnSpecDate));
		assertTrue("Results column Status is missing", isDisplayed(radiosearchResultsColumnStatus));
	}

	/**
	 * This method sorts and validates the order in ascending and throws an
	 * Assertion failure if the validation fails.
	 */
	public void checkForRadioCodeAscend() {
		checkForAscend(sortRadioCode);
		sortValidationAscending(listRadioCode);
	}

	/**
	 * This method sorts and validates the order in descending and throws an
	 * Assertion failure if the validation fails.
	 */
	public void checkForRadioCodeDescend() {
		checkForDescend(sortRadioCode);
		sortValidationDescending(listRadioCode);
	}

	/**
	 * This method sorts and validates the order in ascending and throws an
	 * Assertion failure if the validation fails.
	 */
	public void checkForRadioModelAscend() {
		checkForAscend(sortRadioModel);
		sortValidationAscending(listRadioModel);
	}

	/**
	 * This method sorts and validates the order in descending and throws an
	 * Assertion failure if the validation fails.
	 */
	public void checkForRadioModelDescend() {
		checkForDescend(sortRadioModel);
		sortValidationDescending(listRadioModel);
	}

	/**
	 * This method sorts and validates the order in ascending and throws an
	 * Assertion failure if the validation fails.
	 */
	public void checkForRadioPowerAscend() {
		checkForAscend(sortRadioPower);
		sortValidationAscending(listRadioPwr);
	}

	/**
	 * This method sorts and validates the order in descending and throws an
	 * Assertion failure if the validation fails.
	 */
	public void checkForRadioPowerDescend() {
		checkForDescend(sortRadioPower);
		sortValidationDescending(listRadioPwr);
	}

	/**
	 * This method sorts and validates the order in ascending and throws an
	 * Assertion failure if the validation fails.
	 */
	public void checkForRadioThresholdAscend() {
		checkForAscend(sortRadioThreshold);
		sortValidationAscending(listRadioThr);
	}

	/**
	 * This method sorts and validates the order in descending and throws an
	 * Assertion failure if the validation fails.
	 */
	public void checkForRadioThresholdDescend() {
		checkForDescend(sortRadioThreshold);
		sortValidationDescending(listRadioThr);
	}

	public void checkForRadioFreqAscend() {
		checkForAscend(sortRadioFrequency);
		sortValidationAscending(listRadioFrq);
	}

	/**
	 * This method sorts and validates the order in descending and throws an
	 * Assertion failure if the validation fails.
	 */
	public void checkForRadioFreqDescend() {
		checkForDescend(sortRadioFrequency);
		sortValidationDescending(listRadioFrq);
	}

	public void checkForRadioSpecDateAscend() {
		checkForAscend(sortRadioSpecDate);
		sortValidationAscending(listSpecDt);
	}

	/**
	 * This method sorts and validates the order in descending and throws an
	 * Assertion failure if the validation fails.
	 */
	public void checkForRadioSpecDateDescend() {
		checkForDescend(sortRadioSpecDate);
		sortValidationDescending(listSpecDt);
	}

	public void checkForErrMessage() {
		slowDown(5);
		String errorMessageRadioSearch = getText(radioErrMsgSearch);
		assertEquals("Too many results returned. Please refine your search.", errorMessageRadioSearch);
	}
	/**
	 * 
	 * This method clicks the + icon in create Radio page of Radio Database and 
	 * this method will fail if the icon for new model family is not present and the new family name field is not present
	 */
	public void openModelFamily(){
		assertTrue("Add new model family icon is not present",isDisplayed(addModelFamilyIcon,10));
		click(addModelFamilyIcon);
		assertTrue("Add new model family Name field is not present",isDisplayed(newModelFamilyNameField,5));
		click(newModelFamilyNameField);

	}
	/**
	 * 
	 * This method creates new model family for radio
	 */
	/**
	 * @param ModelFamilyNameError 
	 *            - error message on model family name field
	 * @param randomNum   
	 *            - random number 
	 */
	public void createNewRadioModelFamily_validateSave(int randomNum,String ModelFamilyNameError){
		String newFamilyName="Z"+randomNum;
		assertTrue("Add new model family Name field is not present",isDisplayed(newModelFamilyNameField,5));
		type(newFamilyName, newModelFamilyNameField);
		assertTrue("Save button is not present",isDisplayed(saveNewModelFamily,5));
		click(saveNewModelFamily);
		if(isDisplayed(saveNewModelFamily)) {
			click(saveNewModelFamily);
		}
		slowDown(3);
		assertTrue("Model family field is not present",isDisplayed(newRadioDbbasicInformationModelFamily ,5));

		String modelFamilyFieldValueRadioDetailsPage=getFieldText(newRadioDbbasicInformationModelFamily );
		assertEquals(newFamilyName,modelFamilyFieldValueRadioDetailsPage);
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
	 * This method gets the first one from the list of saved model families
	 */
	public String getAnExistingSaveModelFamily(){
		assertTrue("Saved Radio Model Family list is not present",isDisplayed(savedRadioModelFamilies ,5));
		String savedModelFamilyRow1=getTextPlural(savedRadioModelFamilies , 0);
		return savedModelFamilyRow1;

	}
	/**
	 * 
	 * This method check for existing model family and validates the model family field
	 * 
	 */
	public void validateExistingModelFamily(String ExitingFamilyRow1, String ModelFamilyNameError){
		assertTrue("Add new model family Name field is not present",isDisplayed(newModelFamilyNameField,5));
		clear(newModelFamilyNameField);
		type(ExitingFamilyRow1, newModelFamilyNameField);
		click(saveNewModelFamily);

		String partialExistingModelFamilyText=ExitingFamilyRow1.substring(0,1);
		assertTrue("Error message missing",isDisplayed(modelFamilyErrorMessage,5));

		String ModelFamilyErrorMessageValue = getText(modelFamilyErrorMessage);
		assertEquals(ModelFamilyNameError,ModelFamilyErrorMessageValue);

		clear(newModelFamilyNameField);
		type(partialExistingModelFamilyText,newModelFamilyNameField );
		//verify the saved radio model list updates with the families starting with the partial text.
		int rows = getRows(savedRadioModelFamilies);
		for (int i = 0; i < rows; i++) {
			String lineItemInList;
			String partialLineItemList;
			//try and catch would be inside the for loop
			try
			{
				lineItemInList = getTextPlural(savedRadioModelFamilies,i);
				partialLineItemList=lineItemInList.substring(0,1);
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
	 * this message verifies radio save is successfull
	 * 
	 */
	public void verifyRadioSaveMessage() {
		slowDown(1);
		assertTrue("Radio save message is not displayed",isDisplayed(radioSaveMessage1,90));
		String saveMessage=getText(radioSaveMessage);
		System.out.println("saveMessage "+saveMessage);
		assertEquals("SUCCESSFULLY CREATED NEW RADIO",saveMessage );
		slowDown(1);
		clickBlankPage();
	}
	
	public void clickBlankPage() {
		click(blankPage);
	}
	/*
	 * This method check radio saved message and LEGO-2796
	 */
	public void verifyRadioSaveMessageAndClickReturn() {
		verifyRadioSaveMessage();
		slowDown(2);
		clickReturnFromRadioDetailsPage();
	}
	/**
	 * this method click return from radio details page
	 * 
	 */
	public void clickReturnFromRadioDetailsPage() {
		clickJS(radioSummaryButtonInRadioDetailsPage);
		slowDown(1);
	}
	/**
	 * This method check radio update message and LEGO-2796
	 */
	public void verifyRadioUpdateMessage() {
		assertTrue("message is not displayed",isDisplayed(radioSaveMessage,200));
		String saveMessage=getText(radioSaveMessage);
		assertEquals("SUCCESSFULLY UPDATED RADIO",saveMessage );
		click(blankPage);
		slowDown(2);
		clickJS(radioSummaryButtonInRadioDetailsPage);
		slowDown(1);

	}
	/**
	 * This method is to verify bottom navigation bar in radio details page
	 * @param user
	 */
	public void verifyBottomNavigationBar(String user) {
		assertTrue("Radio details page is not displayed",isDisplayed(newRadioDbbasicInformationSpecDate,40));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal2 = Calendar.getInstance();
		Date currentDate = cal2.getTime(); 
		String todaysDate = dateFormat.format(currentDate);
		System.out.println("currentDay = "+ todaysDate);
		String createdDate= getText(createdDateValue );
		String lastUpdatedDate= getText(lastUpdatedDateValue  );
		String createdByuser= getText(createdByuserValue  );
		String modifiedUser= getText(modifiedByUserValue  );
		assertEquals(createdDate,todaysDate);
		assertEquals(lastUpdatedDate,todaysDate);
		assertEquals(createdByuser,user);
		assertEquals(modifiedUser,user);


	}

	/**
	 * Method clicks the copy Radio button
	 */
	public void copyRadio(){
		assertTrue("Radio button is missing in Radio details page",isDisplayed(copyRadioDbButton,15));
		slowDown(3);
		click(copyRadioDbButton);
		slowDown(2);
	}

	/**
	 * Method clicks the verify copy Radio modal
	 * @return 
	 */
	public String verifyCopyRadioModal(){
		assertTrue("Copy Radio modal didnt appear", isDisplayed(copyNewRadioModal,20));
		slowDown(3);
		String newRadioCode=getFieldText(copyNewRadioModal);
		clear(copyNewRadioModal);
		clear(copyNewRadioModal);
		type("testABC",copyNewRadioModal);
		clear(copyNewRadioModal);
		clear(copyNewRadioModal);
		type(newRadioCode,copyNewRadioModal);
		slowDown(1);
		return newRadioCode;

	}
	/**
	 * This method is to click "create radio in radio copy modal
	 */
	public void clickCreateRadioButtonInCopyModal() {
		assertTrue("Create radio button in radio copy modal is missing", isDisplayed(createRadioCopyModal));
		slowDown(3);
		click(createRadioCopyModal);
	}
	/**
	 * This method is to verify the copy message
	 * @param message
	 */

	public void verifyCopyMessage(String message) {
		assertTrue("Copy sucess message is not displayed",isDisplayed(copySuccessMessage ,30));
		String copyMesssage= getText(copySuccessMessage);
		assertEquals(message,copyMesssage );

	}
	/**
	 * This method click save button
	 */
	public void clickSaveButton() {
		clickSave();
		assertTrue("Save message is missing",isDisplayed(radioSaveMessage,70));
		
	}
	/**
	 * This method click save button
	 */
	public void clickSave() {
		slowDown(2);
		clickJS(createNewRadioButton);
		slowDown(1);
	}
	/**
	 * This method is to click on return button on path details page
	 */

	public void clickReturnRadioDetails() {
		assertTrue("Return button on antenna details page is missing", isDisplayed(returnButtonOnRadioDetails));
		click (returnButtonOnRadioDetails );
		slowDown(2);

	}
	/**
	 * This method is to delete the copied radio
	 */
	public void deleteCopiedRadio() {
		assertTrue("Delete button on radio details page is missing", isDisplayed(radioDelete,20));
		click(radioDelete);
		slowDown(2);
		assertTrue("Radio delete confirmation modal didnt appaer", isDisplayed(radioDeleteConfirmation));
		click(radioDeleteConfirmation);
		slowDown(1);
		assertTrue("Radio delete confirmation didnt appaer", isDisplayed(radioDeleteMessage,20));
		String deleteMessage=getText(radioDeleteMessage);
		assertEquals("DELETE SUCCESS",deleteMessage);
	}
	/**
	 * This method is to verify the mandatory fields in radio details page
	 */
	public void verifyRadioDetailsInRadioDatabase() {
		String errorMessageCompany = getText(newRadioDbbasicInformationCompanyErrorMessage);
		String errorMessageSpecDate = getText(newRadioDbbasicInformationSpecDateErrorMessage);
		String errorMessageStability = getText(newRadioDbbasicInformationStabilityErrorMessage);
		String errorMessageLoFrequency = getText(newRadioDbbasicInformationLowFrequencyErrorMessage);
		String errorMessageHiFrequency = getText(newRadioDbbasicInformationHighFrequencyErrorMessage);
		String errorMessageModulationType = getText(newRadioDbbasicInformationModulationTypeErrorMessage);

		assertEquals(errorMessageCompany, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageSpecDate, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageStability, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageLoFrequency, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageHiFrequency, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageModulationType, REQUIRED_ERROR_MESSAGE);

	}
	/**
	 * This method is to verify the mandatory fields in modulation form
	 */

	public void verifyRadioDetailsModulationFormInRadioDB() {
		String errorMessageModel = getText(modelNumberErrorMessage);
		String errorMessageModulationScheme = getText(modulationSchemaErrorMessage);
		String errorMessageMaxPower = getText(maxPowerErrorMessage );
		String errorMessageEmissionDesignator = getText(emissionDesignatorErrorMessage );

		assertEquals(errorMessageModel, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageModulationScheme, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageMaxPower, REQUIRED_ERROR_MESSAGE);
		assertEquals(errorMessageEmissionDesignator, REQUIRED_ERROR_MESSAGE);

	}
	/**
	 * This method is to close radio modulation form
	 */
	public void closeAddRadioModulationForm() {
		assertTrue("Radio Modulation form close button is not present", isDisplayed(modulationDetailsForm ,10));
		clickJS(modulationDetailsForm );
	}
	/**
	 * This method is to click add radio modulation button in radio details page
	 */
	public void clickAddModulationOnRadioDetails() {
		clickJS(newRadioDbAddModulationButton);
		slowDown(1);

	}
	/**
	 * This method is to click the search results from radio database
	 */
	public void clickResultsRadioDB() {
		assertTrue("Search Results is not Displayed", isDisplayed(radioDbRadioCodeResult, 30));
		click(radioDbRadioCodeResult);
		slowDown(3);
	}
	/**
	 * This method is to verify save button is not present in path database page
	 */
	public void verifySaveButtonNotPresent() {
		slowDown(3);
		String elementPresent="false";
		assertEquals(elementPresent, isElementPresent(saveButton)+"");

	}
	/**
	 * This method is to verify delete button is not present in path database page
	 */
	public void verifyDeleteButtonNotPresent() {
		slowDown(3);
		String elementPresent="false";
		assertEquals(elementPresent, isElementPresent(deleteButton)+"");

	}

	/**
	 * This method is to verify bottom navigation bar in radio details page for engineering user
	 */
	public void verifyBottomNavigationBarEngineerUser() {

	}
	
	
	/**
	 * This method verifies a favorited radio code exists in favorites table
	 */
	public void verifyRadioFavorite(String favoritedRadioCode) {
		assertTrue("radio favorites button is not displayed", isDisplayed(radioFavoritesButton, 30));
		clickJS(radioFavoritesButton);
		slowDown(3);
		String radioCode = getText(radioFavoritesFavoriteCode);
		assertEquals(favoritedRadioCode, radioCode);
	}
	/** 
	 * this method is to verify the legacy radioCode for a 70-90Radio
	 */

	public void verifyLegacyRadioCodeFor7090Radio() {
		String Radio7090StartPattern ="7RC";
		assertTrue("new modulation details page is not displayed", isDisplayed(legacyRadioCode, 60));
		String legacycode =getFieldText(legacyRadioCode);
		assertEquals(Radio7090StartPattern, legacycode.substring(0,3));
	}
	/*
	 * This method is to verify emission designator
	 * @param emissionDes
	 * @param error
	 */
	public void verifyEmissionDesignator(String emissionDes, String error) {
		assertTrue("new modulation details page is not displayed", isDisplayed(legacyRadioCode, 60));
		type(emissionDes,modulationDetailsEmissionDesignator);
		click(modulationDetailsModulationMaxPower);
		assertTrue("Error message is not displayed", isDisplayed(emissionDesignatorErrorMessage, 60));
		assertEquals(getText(emissionDesignatorErrorMessage),error);
		clear(modulationDetailsEmissionDesignator);
		clear(modulationDetailsEmissionDesignator);
	}
	/*
	 * this method is to verify analog radio has null throughput
	 */
	public void verifyThroughputForAnalogRadio() {
		assertTrue("new modulation details page is not displayed", isDisplayed(legacyRadioCode, 60));
		assertEquals(getText(modulationDetailsThroughput),"");
	}
	/*
	 * This method is to click existing modulation for a radio in radio details
	 */
	public void clickExistingModulationOnRadioDetails() {
		assertTrue("Radio details page is not displayed",isDisplayed(newRadioDbbasicInformationSpecDate,40));
		click(radioDbModulationDetailsSavedModulation);
		assertTrue("new modulation details page is not displayed", isDisplayed(modulationDetailsModulationDescription, 60));

	}
	/*
	 * This method is to click existing ith modulation for a radio in radio details
	 */
	public void clickExistingModulationOnRadioDetails(int i) {
		assertTrue("Radio details page is not displayed",isDisplayed(newRadioDbbasicInformationSpecDate,40));
		clickJS(radioDbModulationDetailsSavedModulation,i);
		assertTrue("new modulation details page is not displayed", isDisplayed(modulationDetailsModulationDescription, 60));
	}
	/*
	 * this method is to type offset
	 */
	public String typeOFfSet(String offset) {
		assertTrue("frequencyOffset3rdRow is not displayed", isDisplayed(frequencyOffset3rdRow, 60));
		String exixtingOffset=getFieldText(frequencyOffset3rdRow);
		clear(frequencyOffset3rdRow);
		clear(frequencyOffset3rdRow);
		type(offset,frequencyOffset3rdRow);
		slowDown(1);
		clickJS(modulationDetailsSaveModulationButton);
		slowDown(1);
		assertTrue("save radio is not displayed", isDisplayed(createNewRadioButton, 60));
		return exixtingOffset;
	}
	/*
	 * this method is to reset offset
	 */
	public void resetOFfSet(String existingoffset) {
		clear(frequencyOffset3rdRow);
		type(existingoffset,frequencyOffset3rdRow);
		slowDown(1);
		clickJS(modulationDetailsSaveModulationButton);
		slowDown(1);
	}
	/**
	 * this method is to verify offset
	 * @param offsetValue
	 */
	public void verifyOffset(String offsetValue) {
		assertTrue("new modulation details page is not displayed", isDisplayed(modulationDetailsModulationDescription, 60));
		assertEquals(offsetValue,getFieldText(frequencyOffset3rdRow));
	}
	
	/*
	 * this method is to get the filter reference code
	 */
	public String getFilterReferenceCodeAndApplySaveModulation() {
		assertTrue("new modulation details page is not displayed", isDisplayed(modulationDetailsModulationDescription, 60));
		String filterReferenceCode=getFieldText(filterReferenceCodeField);
		slowDown(1);
		clickJS(modulationDetailsSaveModulationButton);
		assertTrue("Radio details page is not displayed",isDisplayed(newRadioDbbasicInformationSpecDate,40));
		return filterReferenceCode;
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
		assertEquals(getText(deleteCommentnotificationMessage),"Radio Comment File deleted successfully");

	}

	/**
	 * this method is to click delete
	 */
	public void clickDeleteRadio() {
		assertTrue("Delete button on Radio details page is missing", isDisplayed(radioDeleteButtonRadioDetailsPage,80));
		click(radioDeleteButtonRadioDetailsPage);
		assertTrue("Radio delete confirmation modal didnt appaer", isDisplayed(deleteConfirmButton,90));
		click(deleteConfirmButton);
		assertTrue("radio DeleteMessage didnt appaer", isDisplayed(radioDeleteMessage,90));
		String deleteMessage=getText(radioDeleteMessage);
		assertEquals("DELETE SUCCESS",deleteMessage);
	}
	/** this method is to click clear button
	 * 
	 */
	public void clickClearOnRadioDatabaseSearchWindow() {
		click(radioDatabaseClear);
		clickJS(advancedSearchLink);
		assertTrue("advanced fields are missing", isDisplayed(radioDbFilterReferenceCode,80));
		
	}
	/**
	 * This method is to search by filter refernce code
	 * @param filterRefCode
	 */
	public void SearchByFilterReferenceCode(String filterRefCode) {
		type(filterRefCode,radioDbFilterReferenceCode);
		click(radioSearchButton);
		assertTrue("Search Results is not Displayed", isDisplayed(radioDbRadioCodeResult, 30));
		click(radioDbRadioCodeResult);
		assertTrue("Radio details page is not displayed",isDisplayed(newRadioDbbasicInformationSpecDate,140));
	}
	/**
	 * this method is to save modulation and save radio
	 */
	public void saveModulationAndSaveRadio() {
		clickJS(modulationDetailsSaveModulationButton);
		assertTrue("Radio details page is not displayed",isDisplayed(newRadioDbbasicInformationSpecDate,40));
		clickSaveButton();
		
	}
	/**
	 * This method is to click radio favorites
	 */

	public void clickRadioFavorites() {
		assertTrue("Radio favorites button on radio details page is missing",isDisplayed(radioFavoritesButton,20));
		slowDown(1);
		click(radioFavoritesButton);
		assertTrue("Radio favorite modal close icon is missing", isDisplayed(radioFavoriteModalCloseIcon,40));
	}
	/**
	 * this method is to verify radio favorite modal values
	 */
	public void verifyRadioFavoriteModalValues(String maxPower,String legacyCode) {
		assertTrue("Radio favorite modal close icon is missing", isDisplayed(radioFavoriteModalCloseIcon,40));
		assertEquals(getText(radioFavoriteMaxPower),"Max Power: "+ maxPower);
		assertEquals(getText(legacyRadioCodefavoritemodalRadioDetails),legacyCode);
	}
	/**
	 * This method id to verify the legacy radio code field
	 */
	public void verifyLegacyRadioCode(String legacyCode) {
		assertTrue("Legacy Radio Code is missing", isDisplayed(legacyRadioCodeLabel,70));
		assertEquals(getAttributeValue(legacyRadioCodeField),legacyCode);
	}
	/**
	 * This method is to set modulation limit for a radio
	 */
	public void setModulationLimit(String limit) {
		assertTrue("modulation limit is missing", isDisplayed(newRadioDbModulationInformationModulationLimit,70));
		type(limit,newRadioDbModulationInformationModulationLimit)
		;
	}
	/**
	 * This methos id to verify the error list shows up
	 */
	public void verifyErrorList() {
		assertTrue("Error list is missing",isDisplayed(errorListHeader,100));
		assertTrue("Error message 0 is missing",isDisplayed(errorMessage0,10));
		assertTrue("Error message 1 is missing",isDisplayed(errorMessage1,10));
		assertTrue("Error message 2 is missing",isDisplayed(errorMessage2,10));

	}

}
