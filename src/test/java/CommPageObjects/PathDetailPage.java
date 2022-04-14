package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PathDetailPage extends BasePage {


	//Headings
	By pIcon = By.id("path-details-passive-repeater-tooltip-trigger");

	//Buttons
	By pathDetailNewButton = By.id("path-details-path-new-mod-icon");
	By pathDetailSaveDetailsButton = By.id("path-details-footer-save-path-button");
	By pathDetailDeleteDetailsButton = By.id("path-details-footer-delete-button");
	By pathDetailDeleteConfirmButton = By.id("path-details-modal-delete-confirmation-confirm");
	By pathDetailDeleteConfirmSaveButton = By.cssSelector(".btn.btn-sm.bg-green.hover-inverse.margin-top-1");
	By pathDeleteSucessHeading = By.id("path-details-modal-delete-success-heading");
	By pathDetailDiscardButton = By.id("path-details-discard-button");
	By quickAdd = By.id("project-summary-quick-add-open");
	By siteSearchLookUpButton1 = By.id("path-details-site-0-siteName-lookup-trigger");
	By siteSearchLookUpButton2 = By.id("path-details-site-1-siteName-lookup-trigger");
	By closeSiteLookUpMotal = By.id("site-lookup-modal-heading-close");
	By deleteCommentPathDB= By.id("db-details-comments-comment");
	By addDiversity = By.cssSelector(".fa.fa-plus-circle");
	By pathDetailAsrSearch1 = By.id("path-details-regulatory-0-asr-lookup-trigger");
	By pathDetailAsrSearch2 = By.id("path-details-regulatory-1-asr-lookup-trigger");
	By pathDetailCopyButton = By.id("path-details-footer-copy-path-button");
	By pathDetailFlipButton = By.id("path-details-footer-flip-button");
	//QA auto UI: LEGO-3199 Add ID tag in Path Details
	By leaveWithoutSavingConfirmButton = By.id("discard-confirmation-modal-discard");
	By activePathDetailNextArrowButton = By.id("path-details-footer-next-path-button");
	By passiveRepeaterTrigger = By.id("path-details-passive-repeater-trigger");

	By activePathDetailPreviousArrowButton = By.id("path-details-footer-prev-path-button");
	By pathDetailCloseContactLookup = By.id("contact-lookup-modal-heading-close");


	//DropDown Fields -- Does it contain a list that has options that can be selected

	By pathDetailFrequencyBandDropDownField1 = By.id("path-details-band");
	By pathSaveMessage=By.id("path-details-modal-save-success-heading");
	By pathSaveMessageNotification=By.id("notification-successful-path-save-message");
	By blankPage=By.cssSelector("div.ReactModal__Overlay.ReactModal__Overlay--after-open.modal-overlay-default");

	By pathDetailRadioServiceDropDownField2 = By.id("path-details-regulatory-1-radio-service");
	By pathDetailStationClassDropDownField2 = By.id("path-details-regulatory-1-station-class");
	By pathDetailLicenseBasisDropDownField2 = By.id("path-details-regulatory-1-license-basis");

	By licBasis1 = By.id("path-details-regulatory-0-license-basis");
	By licBasis2 = By.id("path-details-regulatory-1-license-basis");

	By overLay = By.cssSelector(".ReactModal__Overlay.ReactModal__Overlay--after-open");

	By bandDropDown=By.id("path-details-band");
	//Drop down options

	//Entry Fields - Able to use the type method
	By pathDetailSiteNameField1 = By.id("path-details-site-0-siteName");
	By pathDetailLatitudeField1 = By.id("path-details-site-0-latitude");
	By pathDetailLongitudeField1 = By.id("path-details-site-0-longitude");
	By pathDetailGroundElevationField1 = By.id("path-details-site-0-elevation");
	By PathDetailsContactField1 = By.id("path-details-site-0-contact");
	By pathDetailsConatctCompany = By.id("path-details-site-0-company");
	By PathDetailsContactLookup1 = By.id("path-details-site-0-contact-lookup-trigger");
	
	//contact lookup UI
	By contactCodeField = By.id("contact-lookup-contact-code");
	

	//Regulatory section
	By pathDetailCallSignField1 = By.id("path-details-regulatory-0-callSign");
	By pathDetailAsrField1 = By.id("#path-details-regulatory-0-asr");
	By pathDetailRadioServiceDropDownField1 = By.id("path-details-regulatory-0-radio-service");
	By pathDetailStationClassDropDownField1 = By.id("path-details-regulatory-0-station-class");
	By pathDetailLicenseBasisDropDownField1 = By.id("path-details-regulatory-0-license-basis");

	By pageNo = By.id("path-details-path-index");
	By pathDetailSiteNameField2 = By.id("path-details-site-1-siteName");
	By pathDetailLatitudeField2 = By.id("path-details-site-1-latitude");
	By pathDetailLongitudeField2 = By.id("path-details-site-1-longitude");
	By pathDetailGroundElevationField2 = By.id("path-details-site-1-elevation");
	By PathDetailsContactField2 = By.id("path-details-site-1-contact");
	By PathDetailsContactLookup2 = By.id("path-details-site-1-contact-lookup-trigger");
	By pathDetailCallSignField2 = By.id("path-details-regulatory-1-callSign");
	By pathDetailAsrField2 = By.id("path-details-regulatory-1-asr");
	By pathDetailSuggested1 = By.className("react-autosuggest__suggestion");
	By error = By.className("error-message");
	By errorCallSign = By.id("path-details-regulatory-0-callSign-error-message");
	By errorSiteName=By.id("path-details-site-0-siteName-error-message");
	By pathDetailSuccessfulCopyMessage = By.className("path-details-footer-modal");

	//Site Lookup UI
	By pathDetailSiteLookUpSiteName = By.id("site-lookup-site-name");
	By pathDetailSiteLookUpCallSign = By.id("site-lookup-call-sign");
	By pathDetailSiteLookUpAsr = By.id("site-lookup-asr");
	By pathDetailSiteLookUpLatitude = By.id("site-lookup-latitude");
	By pathDetailSiteLookUpLongitude = By.id("site-lookup-longitude");
	By pathDetailSiteLookUpRadius = By.id("site-lookup-radius");
	By siteLookUpSearchButtonModal = By.id("site-lookup-submit");
	By contactcodeSiteLookupResults = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-contactCode')]");
	By clearAllValidationDrawer = By.id("path-validations-drawer-clear-all");
	By XcloseAllValidationDrawer = By.xpath("//*[contains(@id, 'path-validations-drawer-path-id-') and contains(@id, '-remove-path-messages')]");

	//Primary Antenna 1and Antenna 2
	By antennaModel_1  = By.id("path-details-antennas-0-0-antenna-model");
	By antennaCenterline_1  = By.id("path-details-antennas-0-0-centerline");
	By antennaMode_1  = By.id("path-details-antennas-0-0-mode");
	By antennaCode_1  = By.id("path-details-antennas-0-0-antenna-code");
	By antennaGain_1  = By.id("path-details-antennas-0-0-gain");
	By antennaModel_2  = By.id("path-details-antennas-1-0-antenna-model");
	By antennaCenterline_2  = By.id("path-details-antennas-1-0-centerline");
	By antennaMode_2  = By.id("path-details-antennas-1-0-mode");
	By antennaCode_2  = By.id("path-details-antennas-1-0-antenna-code");
	By antennaGain_2  = By.id("path-details-antennas-1-0-gain");

	//ASR Lookup UI
	By asrLookUpAsrNumberField = By.id("asr-lookup-asr");
	By asrLookupLatitude = By.id("asr-lookup-latitude");
	By asrLookupLongitude =By.id("asr-lookup-longitude");
	By asrLookupSearchRadius = By.id("asr-lookup-radius");
	By asrLookupClearButton = By.id("clearValues");
	By asrLookupInvalidSearchRadiusMessage = By.id("asr-lookup-radius-error-message");
	By asrLookUpSearchButton = By.id("asr-lookup-submit");
	By asrLookupClose = By.id("asr-lookup-modal-heading-close");
	By asrNumberResults =  By.xpath("//*[contains(@id, 'asr-lookup-modal-table-data-asr-') and contains(@id, '-asr')]");
	By asrResultsNoMessage = By.cssSelector(".no-results-message");
	
	//RCN Lookup UI
	By rcnLookupTrigger = By.id("path-details-rcn-number-lookup-trigger");
	By rcnLookupRcnNumber = By.id("rcn-lookup-rcn");
	By rcnLookupJobNumber = By.id("rcn-lookup-job-number");
	By rcnLookupContactCode = By.id("rcn-lookup-contact-code");
	By rcnLookupSearchButton = By.id("rcn-lookup-submit");
	By rcnLookupClearButton = By.id("rcn-lookup-clear"); 
	By rcnLookupResults = By.xpath("//*[contains(@id, 'rcn-lookup-modal-table-data-rcnId-') and contains(@id, '-rcnNumber')]");
	//Passive Repeater UI                      
	By passiveRepeaterSiteNameField = By.id("path-details-passive-repeaters-0-siteName");
	By passiveRepeaterAsrField = By.id("path-details-passive-repeaters-0-asr");
	By passiveRepeaterTypeField = By.id("path-details-passive-repeaters-0-passive-repeater-type");
	By passiveRepeaterLatitudeField = By.id("path-details-passive-repeaters-0-latitude");
	By passiveRepeaterLongitudeField = By.id("path-details-passive-repeaters-0-longitude");
	By passiveRepeaterGroundElevField = By.id("path-details-passive-repeaters-0-elevation");
	By passiveRepeaterAntennaCodeFieldPlural = By.xpath("//*[contains(@id, 'path-details-passive-repeaters-0-antennas-') and contains(@id, '-antenna-code')]");

	By passiveRepeaterAntennaModelField = By.id("path-details-passive-repeaters-0-antennas-0-antenna-model");
	By passiveRepeaterAntennaModelFieldPlural = By.xpath("//*[contains(@id, 'path-details-passive-repeaters-0-antennas-') and contains(@id, '-antenna-model')]");

	By passiveRepeaterAntennaCodeField = By.id("path-details-passive-repeaters-0-antennas-0-antenna-code");
	By passiveRepeaterCenterlineField = By.id("path-details-passive-repeaters-0-antennas-0-centerline");
	By passiveRepeaterCenterlineField2 = By.id("path-details-passive-repeaters-0-antennas-1-centerline");

	By passiveRepeaterCenterlineFieldPlural = By.xpath("//*[contains(@id, 'path-details-passive-repeaters-0-antennas-') and contains(@id, '-centerline')]");
	By passiveRepeaterSiteSearchButton = By.id("path-details-passive-repeaters-0-siteName-lookup-trigger");
	By passiveRepeaterRemoveButton = By.id("path-details-passive-repeaters-0-remove");
	By passiveRepeaterSaveButton = By.id("path-details-passive-repeater-save");
	By passiveRepeaterAddPassiveRepeaterTrigger = By.id("path-details-passive-repeater-add-repeater");
	By passiveRepeaterAntennaModelSearchButton = By.id("path-details-passive-repeaters-0-antennas-0-antenna-lookup-trigger");
	By passiveRepeaterAntennaModelSearchButtonPlural = By.xpath("//*[contains(@id, 'path-details-passive-repeaters-0-antennas-') and contains(@id, '-antenna-lookup-trigger')]");
	By passiveRepeaterCommonLossField = By.id("path-details-passive-repeaters-0-back-to-back-0-commonLoss");
	By lookUpAntennaCode = By.id("antenna-lookup-antenna-code");
	By lookUpSearchButton = By.id("antenna-lookup-submit");
	By validationDrawerHeading = By.id("path-validations-drawer-heading");
	By passiveRepeaterAsrTooltip = By.xpath("//*[@id=\"path-details-passive-repeater-tooltip\"]/dl/dd/ul/li[5]/span[2]");
	
	By frequencyLookUpIConSite1 = By.xpath("//*[@id='path-details-frequency-plan-0--frequency-lookup-modal-trigger']/img");
	By frequencyLookUpIConSite2 = By.xpath("//*[@id='path-details-frequency-plan-1--frequency-lookup-modal-trigger']/img");
	By frequencyLookupPlanBandwidth= By.id("frequency-plans-lookup-form-bandwidth");
	By frequencyFieldInFrequencyLookup= By.id("frequency-plans-lookup-form-frequency");
	By frequencyMasterPlan= By.xpath("//*[@id='frequency-plan-lookup-form']/a");
	By frequencyBandInFrequencyLookup= By.id("frequency-plans-lookup-form-band");
	By frequencyplan6dot1CCHS= By.id(FREQUENCY_PLAN_TEXT +"36-frequencyPlan");
	By frequencyplan6dot1CCNA= By.id(FREQUENCY_PLAN_TEXT +"70-frequencyPlan");
	By frequencyplan6dot1CCN5= By.id(FREQUENCY_PLAN_TEXT +"65-frequencyPlan");
	By frequencyplan6dot1CCN1= By.id(FREQUENCY_PLAN_TEXT +"61-frequencyPlan");
	By frequencyplan6dot1CCGI= By.id(FREQUENCY_PLAN_TEXT +"55-frequencyPlan");
	By frequencyplan6dot1H6= By.id(FREQUENCY_PLAN_TEXT +"335-frequencyPlan");
	By frequencyplan6dot1L6= By.id(FREQUENCY_PLAN_TEXT +"338-frequencyPlan");
	By frequencyplan6dot1Lo =By.id(FREQUENCY_PLAN_TEXT +"339-frequencyPlan");
	By frequencyplan6dot1HC= By.id(FREQUENCY_PLAN_TEXT +"35-frequencyPlan");
	By frequencyplan6dot1LC= By.id(FREQUENCY_PLAN_TEXT +"56-frequencyPlan");
	By site1FrequencyPlanField = By.id("path-details-frequency-plan-0-frequency-plan");
	By site2FrequencyPlanField = By.id("path-details-frequency-plan-1-frequency-plan");

	By notificationMessage=By.cssSelector(".notification-message");

	By site1FrequencyChannel1 = By.name(FREQUENCY_CHANNEL_SITE1_TEXT + "[0]channelFrequency");
	By site1FrequencyChannel2 = By.name(FREQUENCY_CHANNEL_SITE1_TEXT + "[1]channelFrequency");
	By site1FrequencyChannel3 = By.name(FREQUENCY_CHANNEL_SITE1_TEXT + "[2]channelFrequency");
	By site1FrequencyChannel4 = By.name(FREQUENCY_CHANNEL_SITE1_TEXT + "[3]channelFrequency");
	By site1FrequencyChannel5 = By.name(FREQUENCY_CHANNEL_SITE1_TEXT + "[4]channelFrequency");
	By site1FrequencyChannel6 = By.name(FREQUENCY_CHANNEL_SITE1_TEXT + "[5]channelFrequency");
	By site1FrequencyChannel7 = By.name(FREQUENCY_CHANNEL_SITE1_TEXT + "[6]channelFrequency");
	By site1FrequencyChannel8 = By.name(FREQUENCY_CHANNEL_SITE1_TEXT + "[7]channelFrequency");
	By site1FrequencyChannel9 = By.name(FREQUENCY_CHANNEL_SITE1_TEXT + "[8]channelFrequency");

	By site1FrequencyPolarization1 = By.id("path-details-frequency-plan-0--frequencies-summary-data-channelNumber-1-polarizationId-polarization");

	By site2FrequencyChannel1 = By.name(FREQUENCY_CHANNEL_SITE2_TEXT + "[0]channelFrequency");
	By site2FrequencyChannel2 = By.name(FREQUENCY_CHANNEL_SITE2_TEXT + "[1]channelFrequency");
	By site2FrequencyChannel3 = By.name(FREQUENCY_CHANNEL_SITE2_TEXT + "[2]channelFrequency");
	By site2FrequencyChannel4 = By.name(FREQUENCY_CHANNEL_SITE2_TEXT + "[3]channelFrequency");
	By site2FrequencyChannel5 = By.name(FREQUENCY_CHANNEL_SITE2_TEXT + "[4]channelFrequency");
	By site2FrequencyChannel6 = By.name(FREQUENCY_CHANNEL_SITE2_TEXT + "[5]channelFrequency");
	By site2FrequencyChannel7 = By.name(FREQUENCY_CHANNEL_SITE2_TEXT + "[6]channelFrequency");
	By site2FrequencyChannel8 = By.name(FREQUENCY_CHANNEL_SITE2_TEXT + "[7]channelFrequency");
	By site2FrequencyChannel9 = By.name(FREQUENCY_CHANNEL_SITE2_TEXT + "[8]channelFrequency");

	By site2FrequencyPolarization1 = By.id("path-details-frequency-plan-1--frequencies-summary-data-channelNumber-1-polarizationId-polarization");
	By site1FrequencyDeselectAll = By.cssSelector(".margin-left-auto.uppercase.padding-half.bg-blue.pointer.text-white");

	By tansmitLoassSite1PathDetails=By.id("path-details-losses-0-transmit-loss");
	//hovers -- Able to use the hover method

	//Data Fields - Element is read only and can use getFieldText method
	By pathDetailSiteLookUpSiteNameResults = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-siteName')]/span");
	By pathDetailSiteLookUpCallSignResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-callSign')]/span");
	By pathDetailSiteLookUpAsrResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-asr')]/span");
	By pathDetailSiteLookUpLatitudeResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-latitude')]/span");
	By pathDetailSiteLookUpLongitudeResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-longitude')]/span");
	By pathDetailSiteLookUpRadiusResults  = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-') and contains(@id, '-distance')]/span");
	By asrLookUpResultRow  = By.xpath("//*[contains(@id, 'asr-lookup-modal-table-data-asr-') and contains(@id, '-entityName')]");

	By pdError = By.id("path-details-regulatory-0-asr-error-message");
	By successHeadingText = By.id("notification-successful-path-save-title");
	By sucessHeadingMessage = By.id("notification-successful-path-save-message");
	By editDetailsLink = By.xpath("//*[contains(@id, 'project-summary-path-summary-data-pathId-') and contains(@id, '-siteName')]");
	By leaveWithoutSavingText = By.id("discard-confirmation-heading");
	By siteRowItem = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-')]");
	By antResultListItem = By.xpath("//*[contains(@id, 'antenna-lookup-modal-table-data-antennaCode-') and contains(@id, 'antenna-lookup-modal-table-data-antennaCode-')]");

	//Index List -- Can you used an array to select item

	//Modal -- Does it pop up over current window
	By doYouWantToLeaveModal = By.className("path-details-footer-modal");
	By rowItems = By.xpath("//*[contains(@id, 'site-lookup-modal-table-data-siteId-')and contains(@id, '-siteName')]");
	//Toggle buttons in path detail page

	By groundElevationSite1Meter = By.id("path-details-site-0-elevationUnit-SI");
	By groundElevationSite1Feet = By.id("path-details-site-0-elevationUnit-US");
	By groundElevationSite2Meter = By.id("path-details-site-1-elevationUnit-SI");
	By groundElevationSite2Feet = By.id("path-details-site-1-elevationUnit-US");

	By antennaCenterlineSite1Meter = By.id("path-details-antennas-0-0-centerlineUnit-SI");
	By antennaCenterlineSite1Feet = By.id("path-details-antennas-0-0-centerlineUnit-US");
	By antennaCenterlineSite2Meter = By.id("path-details-site-1-elevationUnit-SI");
	By antennaCenterlineSite2Feet = By.id("path-details-site-1-elevationUnit-US");

	By site1AntennaCenterLine =By.id("path-details-antennas-0-0-centerline");
	By antennaCenterlineError = By.id("path-details-antennas-0-0-centerline-error-message");
	By commentIconPathDetailsPage = By.id("path-details-comments-new-comment-modal-toggle");
	By commentAddNewField = By.id("db-details-comments-comment");
	By commentSaveButton = By.xpath(".//*[@id='db-details-comments']/div[2]/button");
	By commentItem = By.xpath("//*[contains(@id, 'path-details-comments-comments-table-data-pathCommentId-') and contains(@id, '-comment')]/span");
	By attachmentFileLocation = By.xpath("//*[@id=\"db-details-comments\"]/div[2]/div/div/input"); 
	By attachmentRow = By.xpath("//*[contains(@id, 'path-details-comments-comments-table-data-pathCommentId-') and contains(@id,'-attachments')]"); 
	By site1DeselectButtonForPolarization= By.id("path-details-frequency-plan-0-deselect-all");
	By site2DeselectButtonForPolarization= By.id("path-details-frequency-plan-1-deselect-all");

	By pathDetailsReturnButton= By.id("path-details-discard-button");

	By pathNamefieldPathDetails = By.id("path-details-path-name");
	By rcnPathDetails = By.id("path-details-rcn-number");
	By jobNumberPathDetails = By.id("path-details-job-number");
	By previousPathLinkPathDetails = By.id("path-details-previous-path-link");

	By addAdditionalAntennaForSite1= By.id("path-details-antennas-0-add-additional-antenna");
	By addAdditionalAntennaForSite2= By.id("path-details-antennas-1-add-additional-antenna");
	By projectsLinkAtTheTop = By.id("header-menu-projects-list");
	By projectNameSearchFieldInProjectManagementPage = By.id("project-management-search-project-name");
	By passiveRepeaterelevationFeet = By.id("path-details-passive-repeaters-0-elevationUnit-US");
	By closeAddPassiveRepeaterWindow = By.id("path-details-passive-repeater-close");
	By passiveCenterlineFeet =By.id("path-details-passive-repeaters-0-antennas-0-centerlineUnit-US");

	By radioCode_1= By.id("path-details-radios-0-radio-code");
	By radioCode_2= By.id("path-details-radios-1-radio-code");

	By commonLoss1=By.id("path-details-losses-0-common-loss");
	By transmitLoss1=By.id("path-details-losses-0-transmit-loss");
	By receiveLoss1=By.id("path-details-losses-0-receive-loss");
	By commonLoss2=By.id("path-details-losses-1-common-loss");
	By transmitLoss2=By.id("path-details-losses-1-transmit-loss");
	By receiveLoss2=By.id("path-details-losses-1-receive-loss");

	By pathCalculationHeader=By.id("path-details-section-header-path-calculations");
	By pathCalcCoordinatedPower = By.xpath((".//*[@id='path-details-path-calculations-0-radio-calculations-data-label-Power (dBm)-coordinatedPower']/span"));
	By pathCalcEirp = By.xpath((".//*[@id='path-details-path-calculations-0-radio-calculations-data-label-EIRP (dBm)-coordinatedPower']/span"));
	By pathCalcRsl = By.xpath((".//*[@id='path-details-path-calculations-0-radio-calculations-data-label-RSL (dBm)-coordinatedPower']/span"));

	By customFrequencySite1 = By.xpath((".//*[@id='path-details-frequency-plan-0--toggle-custom-frequency-plan']/strong"));
	By customFrequencySite2 = By.xpath((".//*[@id='path-details-frequency-plan-1--toggle-custom-frequency-plan']/strong"));
	By site1CustomFrequency1 = By.name("frequencyPlans[0]frequencies[0]channelFrequency");
	By site1CustomPolarization1 = By.name("frequencyPlans[0]frequencies[0]polarizationId");
	By site2CustomFrequency1 = (By.name("frequencyPlans[1]frequencies[0]channelFrequency"));
	By site2CustomPolarization1 = By.name("frequencyPlans[1]frequencies[0]polarizationId");
	By errorMessageSite2Polarization=By.id("path-details-frequency-plan-1--frequencies-summary-data-channelNumber-undefined-polarizationId-polarization-error-message");

	By azimuth1PathDetailsPage= By.id("path-details-site-1-azimuth");
	By pathLengthPathDetailsPage=By.id("path-details-site-path-distance");
	By azimuth2PathDetailsPage= By.id("path-details-site-2-azimuth");
	By clickATPCsite1 =By.id("path-details-radios-0-trigger-atpc");
	By clcikATPCsite2 =By.id("path-details-radios-1-trigger-atpc");
	By ATPCenableYes = By.id("atpc-and-acm-settings-atpcEnabled-true-label");
	By ATPCDisableNo =By.id("atpc-and-acm-settings-atpcEnabled-false-label");
	By ACMCoordAdvantageEnableYes = By.id("atpc-and-acm-settings-acmCoordinationAdvantageFlag-true-label");
	By ACMCoordAdvantageDisableNo = By.id("atpc-and-acm-settings-acmCoordinationAdvantageFlag-false-label");
	By ATPCSubmitButton=By.id("atpc-and-acm-settings-submit");
	By ATPCNominal =By.id("atpc-and-acm-settings-nominal-power");
	By ATPCCoordPower = By.id("atpc-settings-coordinated-power");
	By ATPCCoordPowerErrorMessage = By.id("atpc-settings-coordinated-power-error-message");
	By ATPCTriggerLevel = By.id("atpc-and-acm-settings-trigger-level");
	By ATPCAlarmOn = By.id("atpc-and-acm-settings-five-minute-alarm-true-label");
	By ATPCPowerRamp = By.id("atpc-and-acm-settings-power-increase-Ramp-label");
	By ATPCPowerStep = By.id("atpc-and-acm-settings-power-increase-Step-label");
	By maxPowerPathDetails =By.id("path-details-radios-0-max-power");
	By resultNominalPowerPower =By.id("path-details-path-calculations-0-radio-calculations-data-label-Power (dBm)-nominalPowerLevel");
	By resultNominalPowerEIRP =By.id("path-details-path-calculations-0-radio-calculations-data-label-EIRP (dBm)-nominalPowerLevel");
	By resultNominalPowerRSL =By.id("path-details-path-calculations-0-radio-calculations-data-label-RSL (dBm)-nominalPowerLevel");

	By createdLabel = By.id("path-details-timestamps-created-date-label");
	By createdDate = By.id("path-details-timestamps-created-date-value");
	By lastUpdatedLabel = By.id("path-details-timestamps-updated-date-label");
	By lastUpdatedDate = By.id("path-details-timestamps-updated-date-value");
	By createdByLabel = By.id("path-details-timestamps-created-user-label");
	By createdByUser = By.id("path-details-timestamps-created-user-value");
	By modifiedByLabel = By.id("path-details-timestamps-updated-user-label");
	By modifiedByUser = By.id("path-details-timestamps-updated-user-value");
	By antennaLookupSite1 = By.id("path-details-antenna-0-0-lookup-trigger");
	By antennacodesite1AntennaLookup = By.id("antenna-lookup-antenna-code");
	By antennasite1LookupCompany = By.id("antenna-lookup-antenna-company");
	By antennasite1LookupModal= By.id("antenna-lookup-antenna-model");
	By antennasite1LookupClear = By.id("clearValues");
	By antennasite1LookupSearch = By.id("antenna-lookup-submit");
	By antennaSearchResult = By.xpath("//*[contains(@id, 'antenna-lookup-modal-table-data-antennaCode-') and contains(@id, '-antennaCode')]");
	
	By environmentSite1Hi = By.id("path-details-frequency-plan-0-environment-hi");
	By environmentSite1Lo = By.id("path-details-frequency-plan-0-environment-lo");
	By environmentSite2Hi = By.id("path-details-frequency-plan-1-environment-hi");
	By environmentSite2Lo = By.id("path-details-frequency-plan-1-environment-lo");
	By radiusASRLookupField = By.name("radius");

	By pathIndex = By.id("path-details-path-index");
	By projectList = By.xpath("//*[contains(@id, 'project-management-modal-table-data-projectId-') and contains(@id, '-serviceContactCodes')]");
	By deselectpathDetailSite1DeselectButton = By.id("path-details-frequency-plan-0-deselect-all");
	By deselectpathDetailSite2DeselectButton = By.id("path-details-frequency-plan-1-deselect-all");

	By site1FrequencyChannel10 = By.id("path-details-frequency-plan-0--frequencies-summary-data-channelNumber-1-polarizationId-polarization");
	By site2FrequencyChannel20 = By.id("path-details-frequency-plan-1--frequencies-summary-data-channelNumber-1-polarizationId-polarization");
	By groundElevationLookupIcon1 = By.id("path-details-site-0-elevation-lookup-trigger");
	By groundElevationApplyButton = By.cssSelector(".bg-orange.text-white.hover-inverse.btn.btn-md.margin-top-1");
	By groundElevationValue = By.id("path-details-site-0-elevation-lookup-modal-value");
	By legacyRadioCodePathDetails = By.cssSelector(".path-details-radio-favorite.pointer.active");
	
	By site1StatusAdminSection = By.id("path-details-administration-0-segment-status");
	By site2StatusAdminSection = By.id("path-details-administration-1-segment-status");
	By projectError1OnSaveDrawer = By.xpath("//*[contains(@id, 'path-validations-drawer-path-id-') and contains(@id, '-messages-error-0')]");
	By projectError2OnSaveDrawer = By.xpath("//*[contains(@id, 'path-validations-drawer-path-id-') and contains(@id, '-messages-error-1')]");
	By clickDrawerTriggerI=By.id("path-validations-drawer-trigger");
	By pathLengthError =  By.xpath("//*[contains(@id, 'path-validations-drawer-path-id-') and contains(@id, '-messages-error-0')]");
	//By deleteAttachmentComment=By.cssSelector(".fa.fa-times-circle-o.margin-left-half.pointer.text-red");
	By deleteAttachmentComment=By.xpath("//*[contains(@id, 'delete-trigger')]");
	By deletecommentConfirmation = By.xpath("//button[contains(text(),'Confirm')]");
	By deleteCommentnotificationMessage=By.cssSelector(".notification-message");
	By hiLoEnvironmentLink = By.id("path-details-frequency-plan-0-environment-label");
	By hiLoRadius = By.id("ENVIRONMENT_PATH_HI_LO_DETAILS_SEARCH-search-radius");
	By hiLoContactCode = By.id("ENVIRONMENT_PATH_HI_LO_DETAILS_SEARCH-contact-codes");
	By hiloSearch = By.cssSelector(".btn.btn-md.bg-blue.hover-inverse.heading-font");
	By site1HiLoCount = By.id("ENVIRONMENT_PATH_HI_LO_DETAILS_TABLE-site-1-hi-lo-count");
	By site2HiLoCount = By.id("ENVIRONMENT_PATH_HI_LO_DETAILS_TABLE-site-2-hi-lo-count");
	By hiloClose = By.cssSelector(".fa.fa-times");
	By siteLookupClearButton = By.id("site-lookup-clear");
	By sitenamePassive = By.id("path-details-passive-repeaters-0-siteName");
	By latpassive = By.id("path-details-passive-repeaters-0-latitude");
	By longitudePassive = By.id("path-details-passive-repeaters-0-longitude");
	By groundelevationPassive = By.id("path-details-passive-repeaters-0-elevation");
	By reportsButtonPathDetails = By.id("path-details-reports-button");
	By additionalAntennaCode = By.id("path-details-antennas-0-1-antenna-code");
	By additionalAntennaTransmitMode = By.id("path-details-antennas-0-1-mode");
	By diversitySquareChecked = By.cssSelector(".fa.fa-check-square-o.pointer");
	
	public PathDetailPage(WebDriver driver) {
		super(driver);
		visit("/");
	}

	public int getRows(){
		int rows =  finds(rowItems).size();
		return rows;
	}



	public void checkForBlankPassiveRepeaterFields(){
		click(passiveRepeaterTrigger);
		String blankAntCode = getFieldText(passiveRepeaterAntennaCodeField);
		String blankCommonLoss = getFieldText(passiveRepeaterCommonLossField);
		String blankAntennaModel = getFieldText(passiveRepeaterAntennaModelField);
		String blankAntennaModel2 = getFieldTextPlural(passiveRepeaterAntennaModelFieldPlural,1);
		String blankAntCode2 = getFieldTextPlural(passiveRepeaterAntennaCodeFieldPlural,1);
		String centerLine1 = getFieldTextPlural(passiveRepeaterCenterlineFieldPlural,1);
		String centerLine2 = getFieldTextPlural(passiveRepeaterCenterlineFieldPlural,1);
		assertEquals(blankAntCode,"");
		//assertEquals(blankCommonLoss,"");
		assertEquals(blankAntennaModel,"");
		assertEquals(blankAntennaModel2,"");
		assertEquals(blankAntCode2,"");
		//assertEquals(centerLine1,"");
		//assertEquals(centerLine2,"");


	}

	public void savePassiveRepeater(){
		isDisplayed(passiveRepeaterSaveButton,10);
		clickJS(passiveRepeaterSaveButton);
		isDisplayed(pIcon,7);
	}

	public void changeFrequency(String freq){
		assertTrue("No Drop down field",isDisplayed(pathDetailFrequencyBandDropDownField1,12));
		slowDown(2);
		selectFromDropdown(pathDetailFrequencyBandDropDownField1,freq);
	}


	/**COM-494
	 * When passive repeater is Billboard type, Antenna lookup in Passive Repeater modal should only show Billboard antenna options.
     When passive repeater is Back to Back type, Antenna lookup should NOT show Billboard antenna options.
	 */

	public void addBillboardPassiveRepeater(){
		//Is the Passive Repeater trigger pressent and active
		assertTrue(isDisplayed(passiveRepeaterTrigger,10));
		assertTrue(isDisplayedAndClickable(passiveRepeaterTrigger,10));
		//Click Passive Repeater trigger
		click(passiveRepeaterTrigger);
		//Change to Back to Back
		isDisplayed(passiveRepeaterTypeField,20);
		selectFromDropdown(passiveRepeaterTypeField, "Billboard");
		//Click the Site search button
		isDisplayed(passiveRepeaterSiteSearchButton,10);
		click(passiveRepeaterSiteSearchButton);
		//Wait for the Site Look Up popup
		isDisplayed(pathDetailSiteLookUpSiteName,10);
		//Enter Site Name
		type("New York",pathDetailSiteLookUpSiteName);
		click(siteLookUpSearchButtonModal);
		//Validate that at least one row
		isDisplayed(pathDetailSiteLookUpRadiusResults,10);
		click(pathDetailSiteLookUpLatitudeResults);
		//Click Antenna Model search button
		click(passiveRepeaterAntennaModelSearchButton);
	}

	public void removePassiveRepeater(){
		assertTrue(isDisplayed(passiveRepeaterTrigger,10));
		clickJS(passiveRepeaterTrigger);
		isDisplayed(passiveRepeaterRemoveButton,10);
		clickJS(passiveRepeaterRemoveButton);
		assertTrue(!isDisplayed(pIcon,7));

	}

	public void returnFromAntennaLookUp(String antModel, String antCode){
		isDisplayed(passiveRepeaterAntennaModelField, 10);
		String antModFieldText = getFieldText(passiveRepeaterAntennaModelField);
		String antModCodeText = getFieldText(passiveRepeaterAntennaCodeField);
		assertEquals(antModFieldText,antModel);
		assertEquals(antModCodeText,antCode);
		type("12",passiveRepeaterCenterlineField);
	}

	public void setAntennaOnPassiveRepeater(int i, String antCode){
		isDisplayed(passiveRepeaterAntennaModelSearchButton,10);
		isDisplayedArray(passiveRepeaterAntennaModelSearchButtonPlural,i);
		clickJS(passiveRepeaterAntennaModelSearchButtonPlural, i);
		assertTrue("cant find the antenna lookup",isDisplayed(lookUpAntennaCode,10));
		type(antCode, lookUpAntennaCode);
		isDisplayed(lookUpSearchButton,8);
		click(lookUpSearchButton);
		isDisplayed(antResultListItem,8);
		click(antResultListItem);
		/*        String antCodeTextPlural = getFieldTextPlural(passiveRepeaterAntennaCodeFieldPlural,i);
        assertEquals(antCode,antCodeTextPlural);*/
		type("12",passiveRepeaterCenterlineField2);
	}

	public void addBackToBackPassiveRepeater(){
		//Is the Passive Repeater trigger pressent and active
		assertTrue("cant find passiveRepeaterTrigger",isDisplayed(passiveRepeaterTrigger,10));
		assertTrue("cant find passiveRepeaterTrigger",isDisplayedAndClickable(passiveRepeaterTrigger,10));
		//Click Passive Repeater trigger
		clickJS(passiveRepeaterTrigger);
		//Change to Back to Back
		slowDown(2);
		assertTrue("cant find sitename field in add passive repeater window",isDisplayed(passiveRepeaterSiteNameField,80));
		selectFromDropdown(passiveRepeaterTypeField, "Back to Back");
		//Click the Site search button
		assertTrue("cant find passiveRepeaterSiteSearchButton",isDisplayed(passiveRepeaterSiteSearchButton,10));
		click(passiveRepeaterSiteSearchButton);
		//Wait for the Site Look Up popup
		assertTrue("cant find pathDetailSiteLookUpSiteName",isDisplayed(pathDetailSiteLookUpSiteName,10));
		//Enter Site Name
		type("New York",pathDetailSiteLookUpSiteName);
		assertTrue("cant find siteLookUpSearchButtonModal",isDisplayed(siteLookUpSearchButtonModal,10));
		click(siteLookUpSearchButtonModal);
		//Validate that at least one row
		assertTrue("cant find pathDetailSiteLookUpRadiusResults",isDisplayed(pathDetailSiteLookUpLatitudeResults,10));
		click(pathDetailSiteLookUpLatitudeResults);
		//Enter common loss
		type("12",passiveRepeaterCommonLossField);
		//Click Antenna Model search button
		click(passiveRepeaterAntennaModelSearchButton);
	}

	public void addBackToBackPassiveRepeater(String passiveType, String siteName ){
		//Is the Passive Repeater trigger pressent and active
		assertTrue(isDisplayed(passiveRepeaterTrigger,10));
		assertTrue(isDisplayedAndClickable(passiveRepeaterTrigger,10));
		//Click Passive Repeater trigger
		click(passiveRepeaterTrigger);
		//Change to Back to Back
		isDisplayed(passiveRepeaterTypeField,20);
		selectFromDropdown(passiveRepeaterTypeField,passiveType );//"Back to Back"
		//Click the Site search button
		isDisplayed(passiveRepeaterSiteSearchButton,10);
		click(passiveRepeaterSiteSearchButton);
		//Wait for the Site Look Up popup
		isDisplayed(pathDetailSiteLookUpSiteName,10);
		//Enter Site Name
		type(siteName,pathDetailSiteLookUpSiteName);//"New York"
		isDisplayed(siteLookUpSearchButtonModal,10);
		click(siteLookUpSearchButtonModal);
		//Validate that at least one row
		isDisplayed(pathDetailSiteLookUpRadiusResults,10);
		click(pathDetailSiteLookUpRadiusResults);
		//Enter common loss
		type("12",passiveRepeaterCommonLossField);
		//Click Antenna Model search button
		click(passiveRepeaterAntennaModelSearchButton);
	}


	public void openPassiveRepeaterAndValidateFieldsAndButtons(){
		//Is the Passive Repeater trigger pressent and active
		assertTrue(isDisplayed(passiveRepeaterTrigger,10));
		assertTrue(isDisplayedAndClickable(passiveRepeaterTrigger,10));
		//Click Passive Repeater trigger
		click(passiveRepeaterTrigger);
		//Validate all fields are available
		isDisplayed(passiveRepeaterSiteNameField,3);
		isDisplayed(passiveRepeaterAsrField,3);
		isDisplayed(passiveRepeaterTypeField,3);
		isDisplayed(passiveRepeaterLatitudeField,3);
		isDisplayed(passiveRepeaterLongitudeField,3);
		isDisplayed(passiveRepeaterGroundElevField,3);
		isDisplayed(passiveRepeaterAntennaModelField,3);
		isDisplayed(passiveRepeaterAntennaCodeField,3);
		isDisplayed(passiveRepeaterCenterlineField,3);
		//Validate All buttons and Triggers
		isDisplayed(passiveRepeaterSiteSearchButton,3);
		isDisplayed(passiveRepeaterRemoveButton,3);
		isDisplayed(passiveRepeaterSaveButton,3);
		isDisplayed(passiveRepeaterAddPassiveRepeaterTrigger,3);
		isDisplayed(passiveRepeaterAntennaModelSearchButton,3);
	}
	
	/**
	 * This method populates required fields in the Add Passive Repeater window
	 */
	public void populatePassiveRepeaterDetails(String siteName, String asr, String latitude, String longitude, String elevation, String centerline, String antCode) {
		openPassiveRepeaterAndValidateFieldsAndButtons();
		type(siteName, passiveRepeaterSiteNameField);
		type(asr, passiveRepeaterAsrField);
		type(latitude, passiveRepeaterLatitudeField);
		type(longitude, passiveRepeaterLongitudeField);
		type(elevation, passiveRepeaterGroundElevField);

		// NOTE - when antenna code fetches the antenna data, it will apply
		// the other antenna data (specifically centerline in this case)
		// which was applied before blurring the antenna code field.
		// if we put centerline after antCode here, it would clear the centerline
		// value because at the moment the antenna code async validator was triggered,
		// centerline would be empty.
		type(antCode, passiveRepeaterAntennaCodeField);
		click(passiveRepeaterCenterlineField);
		slowDown(1);
		type(centerline, passiveRepeaterCenterlineField);
		clickJS(passiveRepeaterSaveButton);
	}
	
	/**
	 * This method verifies the ASR field in the pop up tooltip after adding passive repeater
	 */
	public void verifyPassiveRepeaterSearchByASR(String asr) {
		slowDown(4);
		hoverElement(pIcon);
		slowDown(4);
		String asrResult = getTextInner(passiveRepeaterAsrTooltip);
		slowDown(1);
		assertEquals(asrResult, asr);
	}


	public void navBack() {
		goBack();
	}


	public void clickInactivePassiveRepeaterTrigger(){
		//p-icon not in place
		assertTrue(!isDisplayed(pIcon,6));
		//Passive repeater trigger inactive
		isDisplayed(passiveRepeaterTrigger,12);
		//Is not clickable
		click(passiveRepeaterTrigger);
		//Passive repeater does not appear
		assertTrue(!isDisplayed(passiveRepeaterLatitudeField,3));
	}

	public void flipPath(){
		//Are you on the Path Detail page?
		assertTrue("The Path Detail page did not appear",isDisplayed(pathDetailSiteNameField1,8));
		//Is the copy button present?
		assertTrue("pathDetailCopyButton did not appear",isDisplayed(pathDetailFlipButton,8));
		//Select the copy button
		click(pathDetailFlipButton);
		//A Modal will appear success
		slowDown(2);
	}


	public void copyPathViaPathDetails(String copyMessage){
		//Are you on the Path Detail page?
		assertTrue("The Path Detail page did not appear",isDisplayed(pathDetailSiteNameField1,8));
		//Is the copy button present?
		assertTrue("pathDetailCopyButton did not appear",isDisplayed(pathDetailCopyButton,20));
		//Select the copy button
		click(pathDetailCopyButton);
		//A Modal will appear success
		isDisplayed(pathDetailSuccessfulCopyMessage,10);
		String copySuccessMessage = getText(pathDetailSuccessfulCopyMessage);
		assertEquals(copySuccessMessage,copyMessage);
		//Click away
		isDisplayed(overLay,30);
		click(overLay);
		//retun to original
		isDisplayed(pathDetailAsrField1,8);
		slowDown(2);
	}

	public void nextArrow(){
		isDisplayed(activePathDetailNextArrowButton,8);//path-details-footer-next-path-button
		clickJS(activePathDetailNextArrowButton);
		closeConfirmation();
	}

	public void previousArrow(){
		isDisplayed(activePathDetailPreviousArrowButton,8);//path-details-footer-next-path-button
		slowDown(3);
		clickJS(activePathDetailPreviousArrowButton);

	}

	public void saveAndValidateRequiredMessage(String requiredMessage){
		//Are you on the Path Detail page
		assertTrue("The Path Detail page did not appear",isDisplayed(pathDetailSiteNameField1,8));
		//Is the save button present
		assertTrue("Save button is not present", isDisplayed(pathDetailSaveDetailsButton));
		//click the save button
		click(pathDetailSaveDetailsButton);
		//validate that all required fields Warn required
		isDisplayed(error,5);
		String pathDetailSiteRequiredError1 = getTextPlural(error ,0);
		String pathDetailLatError1 = getTextPlural(error ,1);
		String pathDetailLongRequiredError1 = getTextPlural(error ,2);
		String pathDetailElevRequiredError1 = getTextPlural(error ,3);
		String pathDetailSiteRequiredError2 = getTextPlural(error ,4);
		String pathDetailLatError2 = getTextPlural(error ,5);
		String pathDetailLongRequiredError2 = getTextPlural(error ,6);
		String pathDetailElevRequiredError2 = getTextPlural(error ,7);
		assertEquals(pathDetailSiteRequiredError1,requiredMessage);
		assertEquals(pathDetailLatError1,requiredMessage);
		assertEquals(pathDetailLongRequiredError1,requiredMessage);
		assertEquals(pathDetailElevRequiredError1,requiredMessage);
		assertEquals(pathDetailSiteRequiredError2,requiredMessage);
		assertEquals(pathDetailLatError2,requiredMessage);
		assertEquals(pathDetailLongRequiredError2,requiredMessage);
		assertEquals(pathDetailElevRequiredError2,requiredMessage);
	}
	/**
	 * This method is to click save button on path details page
	 *
	 */
	public void clickSaveButtonOnPathDetails(){
		assertTrue("Save button is not present", isDisplayed(pathDetailSaveDetailsButton,50));
		slowDown(1);
		click(pathDetailSaveDetailsButton);
		slowDown(3);
	}
	
	/**
	 * This method is to click delete button on path details page
	 */
	public void clickDeleteButtonOnPathDetails() {
		assertTrue("Delete button is not present", isDisplayed(pathDetailDeleteDetailsButton,50));
		slowDown(1);
		click(pathDetailDeleteDetailsButton);
		slowDown(3);
		assertTrue("Path delete-reason text field is not displeyed",isDisplayed(deleteCommentPathDB,50));
		type("QA Testing Path Deletion",deleteCommentPathDB);
		slowDown(1);
		clickJS(pathDetailDeleteConfirmSaveButton);
		assertTrue("Path delete heading not displayed",isDisplayed(pathDeleteSucessHeading,150));
		assertEquals("Path not deleted","PATH DELETED SUCCESSFULLY",getText(pathDeleteSucessHeading));

	}

	public void savedPathInfoPersists1(String siteName, String callSign, String latitude,String longitude, String elevation, String frequencyBand){
		assertTrue("path detail asr not displayed",isDisplayed(pathDetailAsrField1,100));
		String siteNameValue = getFieldText(pathDetailSiteNameField1);
		String callSignValue = getFieldText(pathDetailCallSignField1);
		String latitudeValue = getFieldText(pathDetailLatitudeField1);
		String longitudeValue = getFieldText(pathDetailLongitudeField1);
		String elevationValue = getFieldText(pathDetailGroundElevationField1);
		assertEquals("call Sign is incorrect",callSignValue,callSign);
		assertEquals("latitude is incorrect",latitudeValue,latitude);
		assertEquals("longitude is incorrect",longitudeValue,longitude);
		assertEquals("elevation is incorrect",elevationValue,elevation);
	}

	public void savedPathInfoPersists2(String siteNameVal2,String asr2,String latitude2,String longitude2,String elevation2){
		isDisplayed(pathDetailAsrField1,10);
		String asrValue2 = getFieldText(pathDetailCallSignField2);
		String latitudeValue2 = getFieldText(pathDetailLatitudeField2);
		String longitudeValue2 = getFieldText(pathDetailLongitudeField2);
		String elevationValue2 = getFieldText(pathDetailGroundElevationField2);
		assertEquals("asr2 is incorrect",asrValue2,asr2);
		assertEquals("latitudeValue2 is incorrect",latitudeValue2,latitude2);
		assertEquals("longitudeValue2 is incorrect",longitudeValue2,longitude2);
		assertEquals("elevationValue2 is incorrect",elevationValue2,elevation2);

	}

	public void openPathDetailViaDetails(){
		slowDown(1);
		//Make sure that the Details link is present
		assertTrue("DetailsLink is not present",isDisplayed(editDetailsLink,90));
		slowDown(1);
		//Click the Details link from the saved path
		clickJS(editDetailsLink);
		//Verify that the path detail form opens
		assertTrue("The path details form did not open",isDisplayed(pathDetailAsrField1,50));

	}

	public void saveAndValidateSuccessMessage(String saveSuccessMessage){
		//Verify that the save button is present
		assertTrue("save on path detail is missing", isDisplayed(pathDetailSaveDetailsButton, 65));
		//Click the Save button
		click(pathDetailSaveDetailsButton);
		//Validate that the success message appears
		assertTrue("save notification is missing", isDisplayed(successHeadingText, 300));
		String saveSuccessVal = getText(sucessHeadingMessage);
		String saveSuccessVal1 = saveSuccessVal.substring(0,27);
		assertEquals(saveSuccessVal1,saveSuccessMessage);
		//Validate that the success message disappears after 3 seconds
	}

	/*    public void saveAndValidateRequiredMessage(String reqiredMessage){
        //Verify that the save button is present
        isDisplayed(pathDetailSaveDetailsButton,6);
        //Click the Save button
        click(pathDetailSaveDetailsButton);
        //Validate that the success message appears
        assertTrue(isDisplayed(successHeadingText,5));
        String saveSuccessVal = getText(successHeadingText);
        assertEquals(saveSuccessVal,reqiredMessage);
        //Validate that the success message disappears after 3 seconds
        //validate that the user is returned to the
    }*/

	public void addPathViaPathDetailASR1(String asr, String latitude, String longitude, String elevation, String siteNameVal) {
		//Prove that you've arrived on the PathDetail page
		assertTrue("Did not land on path detail", isDisplayed(pathDetailCallSignField1, 25));
		//Verify that the ASR search button is present
		assertTrue("Can't find the ASR search button", isDisplayed(pathDetailAsrSearch1, 5));//path-details-asr-0-lookup-trigger
		//Click the ASR search button
		clickJS(pathDetailAsrSearch1);
		//Verify that the ASR look up appears
		assertTrue("Can't find the asrLookUpAsrNumberField", isDisplayed(asrLookUpAsrNumberField, 5));
		//Enter 1300000 in the ASR Number field
		type(asr,asrLookUpAsrNumberField);//asr-lookup-asr
		//Click the search button
		clickJS(asrLookUpSearchButton);//asr-lookup-submit
		//Click the result row
		assertTrue("Can't find the asrLookUpAsrNumberField", isDisplayed(asrLookUpResultRow, 20));

		click(asrLookUpResultRow, 0);
		//validate that the appropriate fields1 are populated
		String asrValue = getFieldText(pathDetailAsrField1);
		String latitudeValue = getFieldText(pathDetailLatitudeField1);
		String longitudeValue = getFieldText(pathDetailLongitudeField1);
		String elevationValue = getFieldText(pathDetailGroundElevationField1);
		String bandValue = getFieldText(pathDetailFrequencyBandDropDownField1);
		assertEquals("call Sign is incorrect", asrValue, asr);
		assertEquals("latitudeValue is incorrect", latitudeValue, latitude);
		assertEquals("longitudeValue is incorrect", longitudeValue, longitude);
		//enter a site name
		type(siteNameVal,pathDetailSiteNameField1);
	}

	public void addPathViaPathDetailASR1Error(String asr) {
		//Prove that you've arrived on the PathDetail page
		assertTrue("Did not land on path detail", isDisplayed(pathDetailCallSignField1, 5));
		//Verify that the ASR search button is present
		assertTrue("Can't find the ASR search button", isDisplayed(pathDetailAsrSearch1, 5));//path-details-asr-0-lookup-trigger
		type(asr, pathDetailAsrField1);//asr-lookup-asr
		//Click the search button
		click(pathDetailCallSignField1);
		slowDown(5);
		String invalidInput = getText(pdError);
		assertEquals(invalidInput,"Invalid input.");
	}

	public void addPathViaPathDetailASR2(String asr2,String latitude2,String longitude2,String elevation2,String siteNameVal2){
		assertTrue("Can't find the ASR search button",isDisplayed(pathDetailAsrSearch2,5));
		//Click the ASR2 search button
		clickJS(pathDetailAsrSearch2);//path-details-asr-1-lookup-trigger
		//Verify that the ASR look up appears
		assertTrue("Can't find the asrLookUpAsrNumberField", isDisplayed(asrLookUpAsrNumberField, 5));

		//Enter 1200000 in the ASR Number field
		type(asr2, asrLookUpAsrNumberField);
		//Click the search button
		clickJS(asrLookUpSearchButton);
		//Click the result row
		assertTrue("Can't find the asrLookUpAsrNumberField", isDisplayed(asrLookUpResultRow, 20));
		click(asrLookUpResultRow, 0);
		//validate that the appropriate fields2 are populated
		String asrValue2 = getFieldText(pathDetailAsrField2);
		String latitudeValue2 = getFieldText(pathDetailLatitudeField2);
		String longitudeValue2 = getFieldText(pathDetailLongitudeField2);
		String elevationValue2 = getFieldText(pathDetailGroundElevationField2);
		assertEquals("asr2 is incorrect",asrValue2,asr2);
		assertEquals("latitudeValue2 is incorrect",latitudeValue2,latitude2);
		assertEquals("longitudeValue2 is incorrect",longitudeValue2,longitude2);
		assertEquals("elevationValue2 is incorrect",elevationValue2,elevation2);
		//enter a site name2
		type(siteNameVal2, pathDetailSiteNameField2);
	}
	
	/**
	 * This method is to click RCN lookup Hamburger in path Details PAge
	 */
	public void clickRCNHamburgerLookup() {
		slowDown(3);
		assertTrue("Can't find the RCN Lookup button",isDisplayed(rcnLookupTrigger,5));
		clickJS(rcnLookupTrigger);
	}
	
	/**
	 * This method is to verify all RCN lookup window elements are displayed
	 */
	public void verifyRcnLookupElements() {
	    assertTrue("RCN lookup number field is missing", isDisplayed(rcnLookupRcnNumber,8));
	    assertTrue("RCN job number field is missing", isDisplayed(rcnLookupJobNumber,8));
	    assertTrue("RCN lookup contact code field is missing", isDisplayed(rcnLookupContactCode,8));
	    assertTrue("RCN lookup search button is missing", isDisplayed(rcnLookupSearchButton,8));
	    assertTrue("RCN lookup clear button is missing", isDisplayed(rcnLookupClearButton,8));
	}
	

	/**
	 * This method verifies RCN fields are correctly populated after RCN lookup search
	 * @param rcn
	 * @param jobNumber
	 * @param contactCode
	 */
	public void verifyRcnLookupSearch(String rcn, String jobNumber, String contactCode) {
		assertTrue("rcn lookup is missing",isDisplayed(rcnLookupClearButton));
		type(rcn, rcnLookupRcnNumber);
		type(jobNumber, rcnLookupJobNumber);
		type(contactCode, rcnLookupContactCode);
		click(rcnLookupSearchButton);
		slowDown(3);
		clickJS(rcnLookupResults);
		slowDown(3);
		assertEquals(getFieldText(rcnPathDetails), rcn);
		assertEquals(getFieldText(jobNumberPathDetails), jobNumber);
	}

	public void antennaFieldValidation(){
		assertTrue(isDisplayed(antennaModel_1,8));
		assertTrue(isDisplayed(antennaCenterline_1,8));
		assertTrue(isDisplayed(antennaMode_1,8));
		assertTrue(isDisplayed(antennaCode_1,8));
		assertTrue(isDisplayed(antennaGain_1,8));
		assertTrue(isDisplayed(antennaModel_2,8));
		assertTrue(isDisplayed(antennaCenterline_2,8));
		assertTrue(isDisplayed(antennaMode_2,8));
		assertTrue(isDisplayed(antennaCode_2,8));
		assertTrue(isDisplayed(antennaGain_2,8));
		assertTrue(isDisplayed(addDiversity,8));
	}

	public void antennaFieldFieldEntry1(){
		assertTrue(isDisplayed(antennaModel_1,8));
		assertTrue(isDisplayed(antennaCenterline_1,8));
		assertTrue(isDisplayed(antennaMode_1,8));
		assertTrue(isDisplayed(antennaCode_1,8));
		assertTrue(isDisplayed(antennaGain_1,8));
		assertTrue(isDisplayed(addDiversity,8));
	}

	public void antennaFieldFieldEntry2(){
		assertTrue(isDisplayed(antennaModel_2,8));
		assertTrue(isDisplayed(antennaCenterline_2,8));
		assertTrue(isDisplayed(antennaMode_2,8));
		assertTrue(isDisplayed(antennaCode_2,8));
		assertTrue(isDisplayed(antennaGain_2,8));
		assertTrue(isDisplayed(addDiversity,8));
	}

	public void closeSiteLookup(){
		isDisplayed(closeSiteLookUpMotal,8);
		clickJS(closeSiteLookUpMotal);
		isDisplayed(pathDetailSiteLookUpLatitude,8);
	}

	public void siteSearchResults(int i,String siteName,String callSign,String asr,String lat,String longi,String radius){

		String siteNameResults;
		String callSignResults;
		String asrResults;
		String latResults;
		String longiResults;
		String radiusResults;

		slowDown(4);
		siteNameResults = getTextPlural(pathDetailSiteLookUpSiteNameResults,i);
		callSignResults = getTextPlural(pathDetailSiteLookUpCallSignResults,i);
		//asrResults = getTextPlural(pathDetailSiteLookUpAsrResults,i);
		latResults = getTextPlural(pathDetailSiteLookUpLatitudeResults,i);
		longiResults = getTextPlural(pathDetailSiteLookUpLongitudeResults,i);
		radiusResults = getTextPlural(pathDetailSiteLookUpRadiusResults,i);
		//TODO can't search by latitude

		assertEquals("Site callSignResults is not correct",callSignResults,callSign);
		//assertEquals("Site asrResults is not correct",asrResults,asr);
		assertEquals("Site latResults is not correct",latResults,lat);
		assertEquals("Site longiResults is not correct",longiResults,longi);
		assertEquals("Site radiusResults is not correct",radiusResults,radius);

	}

	/**
	 *
	 * @param i selects the row to validate
	 * @param siteName validates that the site entered in search is present in the search result
	 * @param callSign validates that the callSign entered in search is present in the search result
	 * @param asr validates that the asr entered in search is present in the search result
	 * @param lat validates that the latitude entered in search is present in the search result
	 * @param longi validates that the longitude entered in search is present in the search result
	 * @param radius validates that the radius entered in search is present in the search result
	 */

	public void siteSearchResultWithASR(int i,String siteName,String callSign,String asr,String lat,String longi,String radius){

		String siteNameResults;
		String callSignResults;
		String asrResults;
		String latResults;
		String longiResults;
		String radiusResults;

		slowDown(4);
		siteNameResults = getTextPlural(pathDetailSiteLookUpSiteNameResults,i);
		callSignResults = getTextPlural(pathDetailSiteLookUpCallSignResults,i);
		asrResults = getTextPlural(pathDetailSiteLookUpAsrResults,i);
		latResults = getTextPlural(pathDetailSiteLookUpLatitudeResults,i);
		longiResults = getTextPlural(pathDetailSiteLookUpLongitudeResults,i);
		radiusResults = getTextPlural(pathDetailSiteLookUpRadiusResults,i);

		assertEquals("Site callSignResults is not correct",callSignResults,callSign);
		assertEquals("Site asrResults is not correct",asrResults,asr);
		assertEquals("Site latResults is not correct",latResults,lat);
		assertEquals("Site longiResults is not correct",longiResults,longi);
		assertEquals("Site radiusResults is not correct",radiusResults,radius);
	}

	public void siteSearch1(String siteName,String callSign,String asr,String lat,String longi,String radius){
		assertTrue("Cannot find path detail site look up search button",isDisplayed(siteSearchLookUpButton1,8));
		slowDown(2);
		click(siteSearchLookUpButton1);
		assertTrue("Cannot find Site Lookup modal",isDisplayed(pathDetailSiteLookUpSiteName,28));
		click(siteLookupClearButton);
		type(siteName,pathDetailSiteLookUpSiteName);
		type(callSign, pathDetailSiteLookUpCallSign);
		type(lat, pathDetailSiteLookUpLatitude);
		type(longi, pathDetailSiteLookUpLongitude);
		slowDown(2);
		clickJS(siteLookUpSearchButtonModal);
		slowDown(3);

	}



	public void siteSearch2(String siteName,String callSign,String asr,String lat,String longi,String radius){
		assertTrue("Cannot find path detail site look up search button",isDisplayed(siteSearchLookUpButton1,8));
		click(siteSearchLookUpButton2);
		assertTrue("Cannot find Site Lookup modal",isDisplayed(pathDetailSiteLookUpSiteName,8));
		type(siteName,pathDetailSiteLookUpSiteName);
		type(callSign, pathDetailSiteLookUpCallSign);
		type(lat,pathDetailSiteLookUpLatitude);
		clickJS(siteLookUpSearchButtonModal);
		slowDown(3);
	}

	public void radioService1(String defaultRadio, String radioSelection){
		String radio;
		assertTrue("Can't find Path Details (1) Radio field",isDisplayed(pathDetailRadioServiceDropDownField1,30));
		radio = getFieldText(pathDetailRadioServiceDropDownField1);
		assertEquals(radio,defaultRadio);
		selectFromDropdown(pathDetailRadioServiceDropDownField1,radioSelection );
	}
	public void radioService2(String defaultRadio, String radioSelection){
		assertTrue("Can't find Path Details (2) Radio field",isDisplayed(pathDetailRadioServiceDropDownField2,30));
		selectFromDropdown(pathDetailRadioServiceDropDownField2,radioSelection );
	}

	public void radioServiceLoop1( String radioSelection){
		String radio;
		assertTrue("Can't find Path Details (1) Radio field",isDisplayed(pathDetailRadioServiceDropDownField1,30));

		radio = getFieldText(pathDetailRadioServiceDropDownField1);
		selectFromDropdown(pathDetailRadioServiceDropDownField1,radioSelection );
	}
	public void radioServiceLoop2( String radioSelection){
		assertTrue("Can't find Path Details (2) Radio field",isDisplayed(pathDetailRadioServiceDropDownField2,30));
		selectFromDropdown(pathDetailRadioServiceDropDownField2,radioSelection );

	}
	/**
	 * This method is to verify the field in the top of path details form
	 */
	public void verifyPathDetailsFormUpperSection() {
		assertTrue("The band dropdown in path details page is not present",isDisplayed(bandDropDown,20));
		assertTrue("The Path Name field in path details page is not present",isDisplayed(pathNamefieldPathDetails ,20));

	}

	public void saveDetails(){
		assertTrue("The Save button is not present",isDisplayed(pathDetailSaveDetailsButton,5));
		click(pathDetailSaveDetailsButton);
		slowDown(3);
	}

	public void licSelection1(String defaultLic, String licSelection){
		String lic;

		lic = getFieldText(licBasis1);assertEquals("Default Lic is not correct",lic,defaultLic);
		selectFromDropdown(licBasis1,licSelection);
		lic = getFieldText(licBasis1);
		assertEquals("Default Lic is not correct",lic,"2");

	}

	public void licSelection2(String defaultLic, String licSelection){
		String lic;
		lic = getFieldText(licBasis2);
		assertEquals("Default Lic is not correct",lic,defaultLic);
		selectFromDropdown(licBasis2,licSelection);
		lic = getFieldText(licBasis2);
		assertEquals("Default Lic is not correct",lic,"2");

	}
	public void pathDetailErrors(String errorText ){
		String errors = getText(error);
		assertTrue(errors.equalsIgnoreCase(errorText));
	}

	/**
	 * This method is to check the callsign field error message verification
	 * @param errorText
	 */
	public void pathDetailErrorsCallsign(String errorText ){
		String errors = getText(errorCallSign);
		assertTrue(errors.equalsIgnoreCase(errorText));
	}
	/**
	 * This method is to check the sitename field error message verification
	 * @param errorText
	 */
	public void pathDetailErrorsSiteName(String errorText ){
		String errors = getText(errorSiteName);
		assertTrue(errors.equalsIgnoreCase(errorText));
	}

	public void closeDetailsOpenQuickAdd(){
		isDisplayed(pathDetailDiscardButton,10);
		click(pathDetailDiscardButton);
		closeConfirmation();
		assertTrue(isDisplayed(quickAdd,12));
		click(quickAdd);
	}

	public void closeConfirmation(){
		assertTrue(isDisplayed(doYouWantToLeaveModal,8));
		String leaveWithoutSavingPathMessageText = getText(leaveWithoutSavingText);
		assertEquals(leaveWithoutSavingPathMessageText,"DO YOU WANT TO LEAVE?");
		click(leaveWithoutSavingConfirmButton);
	}

	public void checkSiteSuggestion(String siteName,String siteName2 ){
		isDisplayed(pathDetailSiteNameField1,8);
		type(siteName,pathDetailSiteNameField1);
		click(pathDetailLatitudeField1);
		type(siteName2,pathDetailSiteNameField2);
		click(pathDetailLatitudeField2);
	}



	public void checkCallSignEntry(String callsign1,String callsign2 ){
		isDisplayed(pathDetailCallSignField1,8);
		type(callsign1,pathDetailCallSignField1);
		click(pathDetailSiteNameField1);
		type(callsign2,pathDetailCallSignField2);
		click(pathDetailSiteNameField2);
	}


	public void checkSiteSuggestionTrue(String siteName,String siteName2 ){
		isDisplayed(pathDetailSiteNameField1,20);
		type(siteName,pathDetailSiteNameField1);
		if (ie.equals("IE")){
			click(pathDetailAsrField1);
			click(pathDetailSiteNameField1);
		}
		assertTrue("suggested dropdown did not appear",isDisplayed(pathDetailSuggested1,40));
		hover(pathDetailSuggested1);
		slowDown(3);
		type(siteName2,pathDetailSiteNameField2);
		assertTrue(isDisplayed(pathDetailSuggested1,20));

	}

	public void addCallSignPathViaPathDetail1(String siteName, String callSign, String latitude,String longitude, String elevation, String frequencyBand){
		isDisplayed(pathDetailSiteNameField1,20);
		type(siteName,pathDetailSiteNameField1);
		assertTrue(isDisplayed(pathDetailCallSignField1,10));
		type(callSign,pathDetailCallSignField1);
		assertTrue(isDisplayed(pathDetailLatitudeField1,10));
		assertTrue(isDisplayed(pathDetailLongitudeField1,10));
		assertTrue(isDisplayed(pathDetailGroundElevationField1,10));
		assertTrue(isDisplayed(pathDetailSiteNameField1,10));
		assertTrue(isDisplayed(pathDetailFrequencyBandDropDownField1,10));
		selectFromDropdown(pathDetailFrequencyBandDropDownField1,frequencyBand);
		String siteNameValue = getFieldText(pathDetailSiteNameField1);
		String callSignValue = getFieldText(pathDetailCallSignField1);
		slowDown(2);
		clear(pathDetailGroundElevationField1);
		slowDown(2);
		type(longitude,pathDetailLongitudeField1);
		type(latitude,pathDetailLatitudeField1);
		type(elevation,pathDetailGroundElevationField1);
	}
	/**
	 * This method is to create a path from path details page
	 */
	/**
	 * @param siteName - Site name 1
	 * @param callSign - Callsign for site 1
	 * @param latitude - Latitude for site 1
	 * @param longitude - Longitude for site 1
	 * @param elevation - Elevation for site 1
	 * @param frequencyBand  - Band for path
	 */

	public void addPathViaPathDetailBasicSetup1(String siteName, String callSign, String latitude,String longitude, String elevation, String frequencyBand){
		isDisplayed(pathDetailSiteNameField1,20);
		type(callSign,pathDetailCallSignField1);
		click(pathDetailAsrField1);
		slowDown(2);
		clear(pathDetailSiteNameField1);
		clear(pathDetailSiteNameField1);
		type(siteName,pathDetailSiteNameField1);
		type(latitude,pathDetailLatitudeField1);
		type(longitude,pathDetailLongitudeField1);

		clear(pathDetailGroundElevationField1);
		type(elevation,pathDetailGroundElevationField1);
		assertTrue(isDisplayed(pathDetailCallSignField1,10));
		selectFromDropdown(pathDetailFrequencyBandDropDownField1,frequencyBand);
		click(pathDetailLatitudeField1);

	}


	public void changeBand(String band){
		selectFromDropdown(pathDetailFrequencyBandDropDownField1,band);
	}

	public void addPathPathDetailWithAsrAndCall1(String siteName, String callSign, String asr, String latitude,String longitude, String elevation, String frequencyBand){
		isDisplayed(pathDetailSiteNameField1,20);
		type(callSign,pathDetailCallSignField1);

		slowDown(4);
		clear(pathDetailGroundElevationField1);
		clear(pathDetailLatitudeField1);
		clear(pathDetailLongitudeField1);
		clear(pathDetailSiteNameField1);

		type(latitude,pathDetailLatitudeField1);
		type(longitude,pathDetailLongitudeField1);
		type(elevation,pathDetailGroundElevationField1);
		type(siteName,pathDetailSiteNameField1);

		assertTrue(isDisplayed(pathDetailCallSignField1,10));
		selectFromDropdown(pathDetailFrequencyBandDropDownField1,"0.94 GHz (944-952 MHz) US");
		click(pathDetailLatitudeField1);
	}

	public void addPathPathDetailWithAsrAndCall2(String siteName2, String callSign2, String asr2,String latitude2,String longitude2, String elevation2){
		isDisplayed(pathDetailSiteNameField2,20);
		type(callSign2,pathDetailCallSignField2);
		clear(pathDetailSiteNameField2);
		clear(pathDetailGroundElevationField2);
		clear(pathDetailLatitudeField2);
		clear(pathDetailLongitudeField2);

		type(latitude2,pathDetailLatitudeField2);
		type(longitude2,pathDetailLongitudeField2);
		type(elevation2,pathDetailGroundElevationField2);
		type(siteName2,pathDetailSiteNameField2);

		assertTrue(isDisplayed(pathDetailCallSignField2,10));
		selectFromDropdown(pathDetailFrequencyBandDropDownField1,"0.94 GHz (944-952 MHz) US");
		click(pathDetailLatitudeField1);
		//double click
		click(pathDetailSaveDetailsButton);
		slowDown(2);
		if(!isDisplayed(pathSaveMessage,5))
			clickJS(pathDetailSaveDetailsButton);
	}

	public void addPathViaPathDetailBasicSetup2(String siteName2, String callSign2, String latitude2,String longitude2, String elevation2){
		isDisplayed(pathDetailSiteNameField2,20);
		type(callSign2,pathDetailCallSignField2);
		click(pathDetailAsrField2);
		clear(pathDetailSiteNameField2);
		clear(pathDetailSiteNameField2);
		type(siteName2,pathDetailSiteNameField2);
		type(latitude2,pathDetailLatitudeField2);
		type(longitude2,pathDetailLongitudeField2);
		type(elevation2,pathDetailGroundElevationField2);
		assertTrue(isDisplayed(pathDetailCallSignField2,10));
		click(pathDetailLatitudeField1);

	}




	public void addCallSignPathViaPathDetail2(String siteName2, String callSign2, String latitude2,String longitude2, String elevation2){
		type(siteName2,pathDetailSiteNameField2);
		assertTrue(isDisplayed(pathDetailCallSignField2,10));
		type(callSign2,pathDetailCallSignField2);
		click(pathDetailLongitudeField2);
		slowDown(3);
		type(latitude2,pathDetailLatitudeField2);
		type(longitude2,pathDetailLongitudeField2);
		type(elevation2,pathDetailGroundElevationField2);
		assertTrue(isDisplayed(pathDetailLatitudeField2,10));
		assertTrue(isDisplayed(pathDetailLongitudeField2,10));
		assertTrue(isDisplayed(pathDetailGroundElevationField2,10));
		assertTrue(isDisplayed(pathDetailSiteNameField2,10));
		click(pathDetailCallSignField2);
		slowDown(3);
	}

	public void addAsrPathViaPathDetail1(String siteName, String asr, String latitude,String longitude, String elevation, String frequencyBand){
		type(siteName,pathDetailSiteNameField1);
		assertTrue(isDisplayed(pathDetailCallSignField1,10));
		type(asr,pathDetailAsrField1);
		type(latitude,pathDetailLatitudeField1);
		type(longitude,pathDetailLongitudeField1);
		type(elevation,pathDetailGroundElevationField1);
		click(pathDetailLongitudeField1);
		slowDown(2);
		selectFromDropdown(bandDropDown, frequencyBand);

	}

	public void addAsrPathViaPathDetail2(String siteName2, String asr2,  String latitude2,String longitude2, String elevation2){
		type(siteName2,pathDetailSiteNameField2);
		assertTrue(isDisplayed(pathDetailCallSignField2,10));
		type(asr2,pathDetailAsrField2);
		type(latitude2,pathDetailLatitudeField2);
		type(longitude2,pathDetailLongitudeField2);
		type(elevation2,pathDetailGroundElevationField2);
		slowDown(3);

	}
	public void closePathDetails(){
		assertTrue(isDisplayed(pathDetailDiscardButton,10));
		click(pathDetailDiscardButton);
		slowDown(2);
	}

	public void viewPathDetailValue1(String siteName, String callSign,  String latitude,String longitude, String elevation, String frequencyBand){
		String site = getFieldText(pathDetailSiteNameField1);
		String longi = getFieldText(pathDetailLongitudeField1);
		String lati = getFieldText(pathDetailLatitudeField1);
		String elev = getFieldText(pathDetailGroundElevationField1);


		assertTrue(isDisplayed(pathDetailRadioServiceDropDownField1,6));
		assertTrue(isDisplayed(pathDetailStationClassDropDownField1,6));
		assertTrue(isDisplayed(pathDetailLicenseBasisDropDownField1,6));
		assertTrue(isDisplayed(pathDetailFrequencyBandDropDownField1,6));
		assertTrue(isDisplayed(pathDetailSiteNameField1,6));
		assertTrue(isDisplayed(pathDetailLatitudeField1,6));
		assertTrue(isDisplayed(pathDetailLongitudeField1,6));
		assertTrue(isDisplayed(pathDetailGroundElevationField1,6));
		assertTrue(isDisplayed(PathDetailsContactField1,6));
		assertTrue(isDisplayed(pathDetailCallSignField1,6));
		assertTrue(isDisplayed(pathDetailAsrField1,6));

		assertEquals(longi,longitude);
		assertEquals(lati,latitude);
		assertEquals(elev,elevation);

	}

	public void viewPathDetailValues2(String siteName, String callSign, String longitude, String latitude, String elevation, String frequencyBand){
		assertTrue(isDisplayed(pathDetailRadioServiceDropDownField2,6));
		assertTrue(isDisplayed(pathDetailStationClassDropDownField2,6));
		assertTrue(isDisplayed(pathDetailLicenseBasisDropDownField2,6));
		assertTrue(isDisplayed(pathDetailFrequencyBandDropDownField1,6));
		assertTrue(isDisplayed(pathDetailSiteNameField2,6));
		assertTrue(isDisplayed(pathDetailLatitudeField2,6));
		assertTrue(isDisplayed(pathDetailLongitudeField2,6));
		assertTrue(isDisplayed(pathDetailGroundElevationField2,6));
		assertTrue(isDisplayed(PathDetailsContactField2,6));
		assertTrue(isDisplayed(pathDetailCallSignField2,6));
		assertTrue(isDisplayed(pathDetailAsrField2,6));

	}

	/**
	 * This method is to click the frequency lookup icon in path details page and verify the frequency lookup window appears
	 */
	public void clickFrequencyLookupICon(){
		assertTrue("Frequency lookup icon is not present in path details page",isDisplayed(frequencyLookUpIConSite1,5));
		clickJS(frequencyLookUpIConSite1);
		assertTrue("Frequency lookup window doesn't open",isDisplayed(frequencyLookupPlanBandwidth ,5));

	}
	/**
	 * This method is to verify frequency plan filtering in frequency lookup window.
	 * This method will fail if the frequency filtering functionality in the frequency
	 * lookup up window fails.
	 */
	public void verifyFrequencyPlanFiletringInFrequencyLookup(){
		slowDown(2);
		assertTrue("Plan bandwidth field is missing in frequency lookup",isDisplayed(frequencyLookupPlanBandwidth  ,5));
		assertTrue("Frequency field is missing in frequency lookup",isDisplayed(frequencyFieldInFrequencyLookup  ,5));
		assertTrue("Frequency master plan is missing in frequency lookup",isDisplayed(frequencyMasterPlan  ,5));
		assertTrue("Frequency Band is missing in frequency lookup",isDisplayed(frequencyBandInFrequencyLookup,5));
		assertTrue("Frequency Band HC is missing in frequency lookup",isDisplayed(frequencyplan6dot1HC ,10));
		assertTrue("Frequency Band LC is missing in frequency lookup",isDisplayed(frequencyplan6dot1LC ,5));
		type("6189.8275" ,frequencyFieldInFrequencyLookup);
		click(frequencyLookupPlanBandwidth);
		assertTrue("Frequency Band HC is missing in frequency lookup",isDisplayed(frequencyplan6dot1HC ,5));
		if (isDisplayed(frequencyplan6dot1HC, 10)) {
			// The next code to make the script fail when the frequency filtering functionality fails
			assertTrue("Frequency filtering functionality in Frequency lookup window is not working", isDisplayed(siteSearchLookUpButton1, 2));
		}

	}
	/**
	 * This method is to verify frequency plan filtering in frequency lookup window.
	 * This method will fail if the frequency filtering functionality in the frequency
	 * lookup up window fails.
	 */
	public void verifyFrequencyPlanFiletringInFrequencyLookupUsingPlanBandwidth(){
		slowDown(2);
		clear(frequencyFieldInFrequencyLookup);
		assertTrue("Plan bandwidth field is missing in frequency lookup",isDisplayed(frequencyLookupPlanBandwidth  ,5));
		type("30" ,frequencyLookupPlanBandwidth);
		click(frequencyFieldInFrequencyLookup);
		assertTrue("Frequency Band LC is missing in frequency lookup",isDisplayed(frequencyplan6dot1LC ,10));
		if (isDisplayed(frequencyplan6dot1LC, 10)) {
			// The next code to make the script fail when the frequency filtering functionality fails
			assertTrue("Frequency filtering functionality in Frequency lookup window is not working", isDisplayed(siteSearchLookUpButton1, 2));
		}
		click(frequencyplan6dot1LC);
		slowDown(2);
		assertEquals("5937.7875",getFieldText(site1FrequencyChannel1));
	}

	/**
	 * This function is to enter frequency plan.
	 * @param frequencyPlanSite1
	 * @param frequencyPlanSite1
	 */
	public void enterFrequencyPlanInPathDetailsPage(String frequencyPlanSite1, String frequencyPlanSite2) {
		enterFrequencyPlan1(frequencyPlanSite1);
		enterFrequencyPlan2(frequencyPlanSite2);

	}
	/**
	 * This method is to set Frequency plan 1
	 * @param frequencyPlanSite1
	 */
	public void enterFrequencyPlan1(String frequencyPlanSite1) {
		slowDown(2);
		assertTrue("Site 1 Frequency Plan Field is not present in path details page",isDisplayed(site1FrequencyPlanField,5));
		clear(site1FrequencyPlanField);
		type(frequencyPlanSite1, site1FrequencyPlanField);
		click(tansmitLoassSite1PathDetails);
		slowDown(2);
	}
	/**
	 * This method is to set Frequency plan 2
	 * @param frequencyPlanSite2
	 */
	public void enterFrequencyPlan2(String frequencyPlanSite2) {
		clear(site2FrequencyPlanField);
		type(frequencyPlanSite2, site2FrequencyPlanField);
		click(tansmitLoassSite1PathDetails);
		slowDown(2);
	}
	/**
	 * This function is to verify the channel frequencies for HS plan
	 */
	public void verifyFrequenciesForHSPlan() {
		assertEquals("6182.415",getFieldText(site1FrequencyChannel1));
		assertEquals("6212.065",getFieldText(site1FrequencyChannel2));
		assertEquals("6241.715",getFieldText(site1FrequencyChannel3));
		assertEquals("6271.365",getFieldText(site1FrequencyChannel4));

		selectFromDropdown(site1FrequencyPolarization1,"Both V/H");
	}
	/**
	 * This function is to verify the channel frequencies for LS plan
	 */
	public void verifyFrequenciesForLSPlan() {
		assertEquals("5930.375",getFieldText(site2FrequencyChannel1));
		assertEquals("5960.025",getFieldText(site2FrequencyChannel2));
		assertEquals("5989.675",getFieldText(site2FrequencyChannel3));
		assertEquals("6019.325",getFieldText(site2FrequencyChannel4));

		selectFromDropdown(site2FrequencyPolarization1,"Growth-Horizontal");
	}
	
	/**
	 * This method verifies path has selected frequencies and polarizations assigned
	 */
	public void verifyFrequencyAndPolarization(String site1Frequency, String site2Frequency, String site1Polarization, String site2Polarization) {
		assertEquals(site1Frequency, getFieldText(site1FrequencyChannel1));
		assertEquals(site2Frequency, getFieldText(site2FrequencyChannel1));
		assertEquals(site1Polarization, getTextDropdown(site1FrequencyPolarization1));
		assertEquals(site2Polarization, getTextDropdown(site2FrequencyPolarization1));
	}
	
	/**
	 * This function is to verify how UI respond to invalid plan
	 */
	public void invalidFrequencyPlan() {
		clear(site1FrequencyPlanField);
		click(tansmitLoassSite1PathDetails);
		type("CH",site1FrequencyPlanField);
		click(tansmitLoassSite1PathDetails);
		assertTrue("Error message for invalid frequency plan is not displaying in the path details page",isDisplayed(notificationMessage,20));
		assertEquals("No match was found for frequency plan code: CH",getText(notificationMessage));
	}
	/**
	 * This function is to select ground elevation in meter for site 1
	 */
	public void clickMeterSite1GroundElevation() {
		assertTrue("Path details page is not displayed",isDisplayed(pathDetailSiteNameField1,40));
		clickJS(groundElevationSite1Meter );
		slowDown(3);

	}
	/**
	 * This function is to enter or type in ground elevation for site 1
	 */
	public void typeGroundElevationValueSite1(String elevationValue) {
		assertTrue("Path details page is not displayed",isDisplayed(pathDetailGroundElevationField1,20));
		type(elevationValue,pathDetailGroundElevationField1 );
	}
	/**
	 * This function is to convert ground elevation from meter to feet
	 * @param elevation
	 * @param conversionValue
	 */
	public void verifyConversionSite1GroundElevationMeterToFeet(String elevation, String verifyConversionValue) {
		assertTrue("Path details page is not displayed",isDisplayed(pathDetailSiteNameField1,40));
		clickJS(groundElevationSite1Feet );
		slowDown(3);
		String convertedElevationValue= getFieldText(pathDetailGroundElevationField1);
		assertEquals(convertedElevationValue,verifyConversionValue);
	}
	/**
	 * This function is to convert ground elevation from feet to meter
	 * @param elevation
	 * @param conversionValue
	 */
	public void verifyConversionSite1GroundElevationFeetToMeter(String elevation, String verifyConversionValue) {
		assertTrue("Path details page is not displayed",isDisplayed(pathDetailSiteNameField1,20));
		clickJS(groundElevationSite1Meter );
		slowDown(2);
		String convertedElevationValue= getFieldText(pathDetailGroundElevationField1);
		assertEquals(convertedElevationValue,verifyConversionValue);
	}
	/**
	 * This function is to convert antenna centerline from feet to meter
	 * @param centerline
	 * @param conversionValue
	 */
	public void verifyConversionSite1AntennaCenterlineFeetToMeter(String centerline, String verifyConversionValue) {
		assertTrue("Path details page is not displayed",isDisplayed(pathDetailSiteNameField1,20));
		type(centerline,site1AntennaCenterLine);
		clickJS(antennaCenterlineSite1Meter);
		slowDown(2);
		String convertedCenterlineValue= getFieldText(site1AntennaCenterLine);
		assertEquals(convertedCenterlineValue,verifyConversionValue);
	}
	/**
	 * This function is to verify  antenna centerline  allows negatives
	 * @param centerline
	 */
	public void verifySystemAccepstNegativeCenterline(String centerline) {
		assertTrue("Path details page is not displayed",isDisplayed(pathDetailSiteNameField1,20));
		slowDown(1);
		type(centerline,site1AntennaCenterLine);
		clickJS(antennaCenterlineSite1Meter);
		
		if(!isDisplayed(antennaCenterlineError,20)) 
			assertTrue("negative values are allowed in centerline- FAIL",isDisplayed(successHeadingText,20));
		slowDown(1);
		
	}
	/**
	 * This function is to click return button in path details page and click Confirm
	 */
	public void clickReturnButtonInPathDetailsPage() {
		assertTrue("Path details page is not displayed",isDisplayed(pathDetailSiteNameField1,60));
		slowDown(1);
		click(pathDetailDiscardButton );
		slowDown(1);
	}
	/**
	 * This function is to click Confirm in path details page and
	 */
	public void clickConfirmInPathDetailsPage() {
		assertTrue("Path details page is not displayed",isDisplayed(pathDetailSiteNameField1,20));
		click(leaveWithoutSavingConfirmButton );
		slowDown(1);
	}
	/*
	 * This method check path saved message
	 */
	public void verifyPathSaveMessage() {
		assertTrue("save notification is missing", isDisplayed(successHeadingText, 125));
		assertTrue(isDisplayed(successHeadingText,30));
		String saveSuccessVal = getText(sucessHeadingMessage);
		String saveSuccessVal1 = saveSuccessVal.substring(0,27);
		assertEquals(saveSuccessVal1,"You have successfully saved");
		slowDown(2);
		click(pathDetailsReturnButton);
		slowDown(2);

	}
	/**
	 * This method click 'Projects' link in the top bar to go to project management page
	 *
	 */
	public void clickProject() {
		assertTrue("Project link at the top of Path summary page is not displayed",isDisplayed(projectsLinkAtTheTop,20));
		click(projectsLinkAtTheTop);
		assertTrue("projectName Field In ProjectManagementPage is not displayed",isDisplayed(projectNameSearchFieldInProjectManagementPage,30));

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
	 * This method is to verify the control is in the path Details Page
	 *
	 */
	public void verifyControlIsInPathDetailsPage(String asr) {
		assertTrue("control is not in path details page",isDisplayed(pathDetailSiteNameField1,20));
		assertEquals("updated values are fetched in pathdetails page",getFieldText(pathDetailAsrField1),asr);
	}
	/**
	 * This method is to click contact lookup of site 1 and verify the contact lookup page appears
	 */
	public void clickContactLookupForSite1() {
		slowDown(2);
		assertTrue("Contact lookup for site 1 is missing", isDisplayed(PathDetailsContactLookup1,10));
		click(PathDetailsContactLookup1);
		slowDown(3);
		assertTrue("Contact lookup page is missing", isDisplayed(contactCodeField,10));

	}
	/**
	 * This method is to verify the contact code is pre-populated
	 */
	public void verifyPrepopulationOfContactCode() {
		assertTrue("Contact lookup page is missing", isDisplayed(contactCodeField,10));
		String contact =getFieldText(contactCodeField);
		if (contact !="")
		{
			assertTrue("Contact is prepopulated", isDisplayed(contactCodeField,20));
		}else {
			assertTrue("Contact is NOT prepopulated", isDisplayed(quickAdd,20));
		}
		click(pathDetailCloseContactLookup);
		assertTrue("path details page is missing", isDisplayed(PathDetailsContactLookup2,10));
	}
	
	
	/**
	 * This method is to click contact lookup of site 2 and verify the contact lookup page appears
	 */
	public void clickContactLookupForSite2() {
		slowDown(2);
		assertTrue("Contact lookup for site 2 is missing", isDisplayed(PathDetailsContactLookup2,10));
		click(PathDetailsContactLookup2);
		slowDown(3);
		assertTrue("Contact lookup page is missing", isDisplayed(contactCodeField,10));

	}
	/**
	 * This function is to verify the conversion of values meter/feet toggle for ground elevation 1  in path details page
	 * @param elevation
	 * @param verifyConversionValue
	 */
	public void verifyConversionGroundElevation1MeterToFeet(String elevation, String verifyConvertedValue) {
		assertTrue("Path details page is not displayed",isDisplayed(pathNamefieldPathDetails,20));
		type(elevation,pathDetailGroundElevationField1);
		clickJS(groundElevationSite1Feet);
		slowDown(1);
		String convertedElevationValue=getFieldText(pathDetailGroundElevationField1);
		slowDown(2);
		assertEquals(convertedElevationValue,verifyConvertedValue);


	}
	/**
	 * This function is to verify the conversion of values meter/feet toggle for antenna centerline 1 in path details page
	 * @param centerline
	 * @param verifyConversionValue
	 */
	public void verifyConversionAntennaCenterline1MeterToFeet(String centerline, String verifyConvertedValue) {
		assertTrue("Path details page is not displayed",isDisplayed(pathNamefieldPathDetails,20));
		selectFromDropdown(pathDetailFrequencyBandDropDownField1,"0.94 GHz (944-952 MHz) US");
		type(centerline,antennaCenterline_1);
		slowDown(2);
		clickJS(antennaCenterlineSite1Feet);
		String convertedCenterLineValue=getFieldText(antennaCenterline_1);
		slowDown(2);
		assertEquals(convertedCenterLineValue,verifyConvertedValue);

	}
	/**
	 * This function is to verify the conversion of values meter/feet toggle
	 *  for ground elevation  in passive repeater page of  path details page
	 * @param elevation
	 * @param verifyConvertedValue
	 */
	public void verifyPassiveRepeaterGEConversionMeterToFeet(String elevation, String verifyConvertedValue) {
		clickJS(passiveRepeaterTrigger);
		assertTrue("passive repeater in Path details page is not displayed",isDisplayed(passiveRepeaterGroundElevField,30));
		type(elevation,passiveRepeaterGroundElevField);
		slowDown(2);
		clickJS(passiveRepeaterelevationFeet);
		slowDown(2);
		String convertedElevationValue=getFieldText(passiveRepeaterGroundElevField);
		slowDown(2);
		assertEquals(verifyConvertedValue,convertedElevationValue);
		click(closeAddPassiveRepeaterWindow);
		slowDown(1);
	}
	/**
	 * This function is to verify the conversion of values meter/feet toggle
	 * for centerline  in passive repeater page of  path details page
	 * @param centerline
	 * @param verifyConvertedValue
	 */
	public void verifyPassiveRepeaterCenterlineConversionMeterToFeet(String centerline, String verifyConvertedValue) {
		click(passiveRepeaterTrigger);
		assertTrue("passive repear in Path details page is not displayed",isDisplayed(passiveRepeaterGroundElevField,30));
		slowDown(1);
		type(centerline,passiveRepeaterCenterlineField);
		clickJS(passiveCenterlineFeet);
		String convertedElevationValue=getFieldText(passiveRepeaterCenterlineField);
		slowDown(2);
		assertEquals(verifyConvertedValue,convertedElevationValue);

	}
	/**
	 * Add primary antenna for site 1 and site 2
	 * @param antenna1
	 * @param antenna2
	 */
	public void addPrimaryAntennaForSite1AndSite2(String antenna1, String antenna2) {
		assertTrue("Antenna code 2 field is not present",isDisplayed(antennaCode_1,8));
		type(antenna1,antennaCode_1);
		slowDown(1);
		click(antennaCenterline_1);
		slowDown(1);
		type("12",antennaCenterline_1);
		assertTrue("Antenna code 2 field is not present",isDisplayed(antennaCode_2,8));
		type(antenna2,antennaCode_2);
		click(antennaCenterline_2);
		slowDown(1);
		type("40",antennaCenterline_2);

	}

	/**
	 * Add Radio for site 1 and site 2
	 * @param radio1
	 * @param radio2
	 */
	public void addRadioForSite1AndSite2(String radio1, String radio2) {
		setSite1Radio(radio1);
		setSite2Radio(radio2);
	}
	/**
	 * This method is to set radio1
	 * @param radio1
	 */
	public void setSite1Radio(String radio1) {
		assertTrue("radio code 2 field is not present",isDisplayed(radioCode_1,8));
		clickJS(antennaCode_1);
		type(radio1,radioCode_1);
		click(antennaCenterline_1);
		slowDown(3);
	}
	/**
	 * This method is to set radio2
	 * @param radio2
	 */
	public void setSite2Radio(String radio2) {
		assertTrue("Radio code 2 field is not present",isDisplayed(radioCode_2,8));
		type(radio2,radioCode_2);
		click(antennaCenterline_2);
		slowDown(2);

	}

	/**
	 * This function is to add losses to site 1 and site 2
	 * @param comloss1
	 * @param transLoss1
	 * @param receiveloss1
	 */
	public void addLossForSite1AndSite2(String comloss1, String transLoss1, String receiveloss1) {
		assertTrue("Common Loss 1 field is missing", isDisplayed(commonLoss1,8));
		type(comloss1,commonLoss1);
		type(transLoss1,transmitLoss1);
		type(receiveloss1,receiveLoss1);
		type(comloss1,commonLoss2);
		type(transLoss1,transmitLoss2);
		type(receiveloss1,receiveLoss2);


	}
	/**
      This function is to Custom Frequency For Site1 And Site2
	 * @param frequencysite1
	 * @param frequencysite2
	 */
	public void addCustomFrequencyForSite1AndSite2(String frequencysite1, String frequencysite2) {
		assertTrue("Custom Frequency link for site 1 is missing", isDisplayed(customFrequencySite1,18));
		clickJS(customFrequencySite1 );
		slowDown(2);
		assertTrue("Custom Frequency1 for site 1 is missing", isDisplayed(site1CustomFrequency1 ,40));
		type(frequencysite1 ,site1CustomFrequency1 );
		selectFromDropdown(site1CustomPolarization1 , "Both V/H");
		clickJS(customFrequencySite2 );
		slowDown(2);
		assertTrue("Custom Frequency2 for site 2 is missing", isDisplayed(site2CustomFrequency1 ,40));
		type(frequencysite2 ,site2CustomFrequency1 );
		selectFromDropdown(site2CustomPolarization1 , "Both V/H");

	}
	/**
	 * This method check path saved message and path calculations
	 * @param coordinatedPower
	 * @param eirp
	 * @param rsl
	 */
	public void verifyPathSaveMessageAndVerifyCalculation(String coordinatedPower, String eirp, String rsl) {
		slowDown(1);
		assertTrue("path saved message is missing", isDisplayed(pathSaveMessage ,200));
		String saveMessage=getText(pathSaveMessage);
		assertEquals("PATH SAVED SUCCESSFULLY",saveMessage );
		click(blankPage);
		slowDown(2);
		verifyPathCalculations(coordinatedPower,eirp,rsl);

	}
	/**
	 * This method is to verify path calculations
	 */
	public void verifyPathCalculations(String coordinatedPower, String eirp, String rsl) {
		assertTrue("Path calculations arent displayed",isDisplayed(pathCalculationHeader));
		String pathCal=getText(pathCalculationHeader);
		assertEquals(pathCal,"PATH CALCULATIONS");
		String coordinatedPwr=getText(pathCalcCoordinatedPower);
		String calculatedEirp=getText(pathCalcEirp );
		String calculatedRsl=getText(pathCalcRsl );
		assertEquals(coordinatedPower,coordinatedPwr);
		assertEquals(eirp,calculatedEirp);
		assertEquals(rsl,calculatedRsl);
	}
	/**
	 * This method is verify azimuth and path length
	 *
	 * @param azimuth1
	 * @param pathLength
	 * @param azimuth2
	 */
	public void verifyAzimuthPathLength(String azimuth1, String pathLength, String azimuth2) {
		String azimuthValue1=getText(azimuth1PathDetailsPage );
		String pathLengthValue=getText(pathLengthPathDetailsPage );
		String azimuthValue2=getText(azimuth2PathDetailsPage );
		assertEquals(azimuthValue1,azimuth1);
		assertEquals(pathLengthValue,pathLength);
		assertEquals(azimuthValue2,azimuth2);


	}
	/**
	 * This method is to verify contact code is present in sitelookup search results instead of comapany
	 */
	public void siteLookupVerifyContact(String contactCode) {
		click(siteSearchLookUpButton1);
		assertTrue("Site lookup isnt displayed",isDisplayed(pathDetailSiteLookUpSiteName));
		click(siteLookUpSearchButtonModal);
		slowDown(3);
		String contactCodeValueFromResults= getText(contactcodeSiteLookupResults);
		assertEquals(contactCodeValueFromResults,contactCode);

	}
	/**
	 * This method is to click ASR Hamburger in path Details PAge
	 */
	public void clickASRHamburgerLookup() {
		slowDown(3);
		click(pathDetailAsrSearch1);
		assertTrue("ASR lookup isnt displayed",isDisplayed(asrLookUpAsrNumberField,20));

	}
	/**
	 * This method is to verify ASR lookup window functionality with a specific latitude/longitude <5 degreee from the ASR
	 * @param asr
	 * @param latitude
	 * @param longitude
	 */
	public void verifyASRookupSearchLessThanFiveDegreeFromASR(String asr, String latitude,String longitude) {
		assertTrue("ASR lookup isnt displayed",isDisplayed(asrLookUpAsrNumberField,20));
		type(latitude,asrLookupLatitude);
		type(longitude,asrLookupLongitude);
		type("15",radiusASRLookupField);
		click(asrLookUpSearchButton);
		slowDown(2);
		String asrNumberResultFromLookup=getTextPlural(asrNumberResults,1);
		assertEquals(asr,asrNumberResultFromLookup);
		click(asrNumberResults);


	}
	/**
	 * This method is to verify ASR lookup window functionality with a specific latitude/longitude >5 degreee from the ASR
	 */
	public void verifyASRookupSearchWhenLongitudeGreaterThanFiveDegree() {
		assertTrue("ASR lookup isnt displayed",isDisplayed(asrLookUpAsrNumberField,20));
		clear(asrLookUpAsrNumberField);
		clear(asrLookupLatitude);
		click(asrLookupClearButton);
		slowDown(1);
		type("39 26 18 N",asrLookupLatitude);
		clear(asrLookupLongitude);
		type("91 4 34 W",asrLookupLongitude);
		slowDown(1);
		click(asrLookUpSearchButton);
		slowDown(1);
		String asrNumberResultNoresultsMessage=getText(asrResultsNoMessage);
		assertEquals(asrNumberResultNoresultsMessage,"There are no results to display.");
	}
	
	/**
	 * This method is to verify ASR Lookup window functionality relating to search radius
	 */
	public void verifyASRlookupSearchRadius() {
		clickJS(pathDetailAsrSearch1);	
		slowDown(2);
		assertTrue("ASR Search Radius field isnt displayed", isDisplayed(asrLookupSearchRadius,20));
		assertTrue("clear button field isnt displayed", isDisplayed(asrLookupClearButton,20));
		click(asrLookupClearButton);
		slowDown(1);
		type("1240000", asrLookUpAsrNumberField);
		click(asrLookUpSearchButton);
		assertTrue("Search Result Entry is not displayed", isDisplayed(asrNumberResults,20));
		clear(asrLookupSearchRadius);
		type("60", asrLookupSearchRadius);
		slowDown(2);
		String invalidSearchRadiusMessage = getText(asrLookupInvalidSearchRadiusMessage);
		assertEquals(invalidSearchRadiusMessage, "Value cannot be greater than 59");
		clear(asrLookupSearchRadius);
		type("-1", asrLookupSearchRadius);
		slowDown(2);
		invalidSearchRadiusMessage = getText(asrLookupInvalidSearchRadiusMessage);
		assertEquals(invalidSearchRadiusMessage, "Value cannot be less than 0");
		clear(asrLookupSearchRadius);
		type("a", asrLookupSearchRadius);
		slowDown(2);
		invalidSearchRadiusMessage = getText(asrLookupInvalidSearchRadiusMessage);
		assertEquals(invalidSearchRadiusMessage, "Must be numerical value.");
	}
	
	/**
	 * This method verifies site coordinates are PrePopulated for ASR Lookup
	 * @param asr
	 * @param searchRadius
	 * @param latitude
	 * @param longitude
	 */
	public void verifyASRLookupPrePopulate(String asr, String searchRadius, String latitude, String longitude) {
		clickJS(pathDetailAsrSearch1);	
		assertTrue("ASR lookup isnt displayed",isDisplayed(asrLookUpAsrNumberField,20));
		clear(asrLookUpAsrNumberField);
		type(asr, asrLookUpAsrNumberField);
		clear(asrLookupSearchRadius);
		type(searchRadius, asrLookupSearchRadius);
		click(asrLookUpSearchButton);
		slowDown(2);
		click(asrNumberResults);
		slowDown(2);
		String resultLatitude = getFieldText(pathDetailLatitudeField1);
		String resultLongitude = getFieldText(pathDetailLongitudeField1);
		assertEquals(latitude, resultLatitude);
		assertEquals(longitude, resultLongitude);
		clickJS(pathDetailAsrSearch1);
		slowDown(2);
		assertEquals(getFieldText(asrLookupLatitude), resultLatitude);
		assertEquals(getFieldText(asrLookupLongitude), resultLongitude);
	}
	/**
	 * This method is to verify elements in the regulatory section of path details
	 */
	public void verifyPathDetailsRegulatorySection() {
		assertTrue("Call sign 1 isnt displayed",isDisplayed(pathDetailCallSignField1 ,20));
		assertTrue("ASR field 1 isnt displayed",isDisplayed(pathDetailAsrField1 ,20));
		assertTrue("Radio service dropdown 1 isnt displayed",isDisplayed(pathDetailRadioServiceDropDownField1 ,20));
		assertTrue("Station class dropdown 1 isnt displayed",isDisplayed(pathDetailStationClassDropDownField1 ,20));
		assertTrue("License basic 1 isnt displayed",isDisplayed(pathDetailLicenseBasisDropDownField1 ,20));
		assertTrue("Call sign 2 isnt displayed",isDisplayed(pathDetailCallSignField2,20));
		assertTrue("ASR field 2 isnt displayed",isDisplayed(pathDetailAsrField2 ,20));
		assertTrue("Radio service dropdown 2 isnt displayed",isDisplayed(pathDetailRadioServiceDropDownField2 ,20));
		assertTrue("Station class dropdown 2 isnt displayed",isDisplayed(pathDetailStationClassDropDownField2 ,20));
		assertTrue("License basic 2 isnt displayed",isDisplayed(pathDetailLicenseBasisDropDownField2 ,20));

	}

	/**
	 * This method is to verify azimuth and path
	 */
	public void verifyPathlengthAndAzimuth(String azimuth1, String azimuth2, String pathLength) {
		assertTrue("Azimuth 1 isnt displayed on path details page",isDisplayed(azimuth1PathDetailsPage,20));
		assertTrue("Azimuth 2 isnt displayed on path details page",isDisplayed(azimuth2PathDetailsPage,20));
		assertTrue("Path Length isnt displayed on path details page",isDisplayed(pathLengthPathDetailsPage,20));
		String azimuthText1=getText(azimuth1PathDetailsPage);
		String azimuthText2=getText(azimuth2PathDetailsPage);
		String pathLengthText=getText(pathLengthPathDetailsPage);
		assertEquals(azimuthText1,azimuth1);
		assertEquals(azimuthText2,azimuth2);
		assertEquals(pathLengthText,pathLength);

	}
	/**
	 * This method is to click site lookup icon on path details
	 */
	public void clickSiteLookup() {
		assertTrue("site 1 lookup icon doesnt appear",isDisplayed(siteSearchLookUpButton1,20));
		click(siteSearchLookUpButton1);
		assertTrue("Site Lookup window doesnt appaer ",isDisplayed(pathDetailSiteLookUpSiteName ,20));
		assertTrue("Callsign field in site Lookup window doesnt appaer ",isDisplayed(pathDetailSiteLookUpCallSign ,20));
		assertTrue("ASR field in site Lookup window doesnt appaer",isDisplayed(pathDetailSiteLookUpAsr ,20));
		assertTrue("Latitude field in site Lookup window doesnt appaer",isDisplayed(pathDetailSiteLookUpLatitude ,20));
		assertTrue("Longitude field in site Lookup window doesnt appaer",isDisplayed(pathDetailSiteLookUpLongitude ,20));
		assertTrue("Radius field in site Lookup window doesnt appaer",isDisplayed(pathDetailSiteLookUpRadius,20));
		assertTrue("Search icon in site Lookup window doesnt appaer",isDisplayed(siteLookUpSearchButtonModal ,20));
	}
	/**
	 * This method is to perform search in site lookup on path details page using latitude
	 * and longitude
	 * @param latitude
	 * @param longitude
	 * @Param radius
	 *
	 */
	public void searchByLatitudeLongitude(String latitude, String longitude,String radius) {
		assertTrue("Latitude field in site Lookup window doesnt appaer",isDisplayed(pathDetailSiteLookUpLatitude ,20));
		clear(pathDetailSiteLookUpLatitude);
		slowDown(1);
		type(latitude,pathDetailSiteLookUpLatitude );
		clear(pathDetailSiteLookUpLongitude);
		type(longitude,pathDetailSiteLookUpLongitude  );
		clear(pathDetailSiteLookUpRadius );
		type(radius,pathDetailSiteLookUpRadius);
		click(siteLookUpSearchButtonModal );
		assertTrue("search result doesnt appear for site search by lat/long",isDisplayed(contactcodeSiteLookupResults,40));
	}
	/**
	 * This method is to enable ATPC and verify max power is disabled
	 */
	public void enableATPCThenDisableVerifyMaxPower() {
		assertTrue("ATPC button for site 1 is missing",isDisplayed(clickATPCsite1 ,40));
		slowDown(3);
		clickJS(clickATPCsite1);
		assertTrue("ATPC enable button is missing",isDisplayed(ATPCenableYes ,60));
		slowDown(2);
		click(ATPCenableYes);
		assertTrue("Nominal power button is missing",isDisplayed(ATPCNominal, 40));
		type("37", ATPCNominal);
		click(ATPCSubmitButton);
		slowDown(2);
		Boolean b = enabled(maxPowerPathDetails);
		String bool=b+"";
		assertEquals("false", bool); /*Validates whether the button is Disabled*/
	}
	/**
	 * This method is to enable ATPC and verify max power is enabled
	 */

	public void disableATPCThenEnableVerifyMaxPower() {
		assertTrue("ATPC button for site 1 is missing",isDisplayed(clickATPCsite1 ,40));
		slowDown(3);
		clickJS(clickATPCsite1);
		assertTrue("ATPC disable button is missing",isDisplayed(ATPCDisableNo ,40));
		slowDown(2);
		click(ATPCDisableNo);
		click(ATPCSubmitButton);
		slowDown(2);
		Boolean b = enabled(maxPowerPathDetails);
		String bool2 = b+"";
		assertEquals("true", bool2); /*Validates whether the button is enabled*/

	}
	
	/**
	 * This method clicks button to open coordination advantage parameters window
	 */
	public void clickATPCTriggerButton() {
		assertTrue("ATPC button for site 1 is missing",isDisplayed(clickATPCsite1 ,40));
		slowDown(3);
		clickJS(clickATPCsite1);
	}
	
	/**
	 * This method clicks the ATPC enabled button on coordination advantage parameters window
	 */
	public void clickATPCEnabledButton() {
		assertTrue("ATPC enable button is missing",isDisplayed(ATPCenableYes ,60));
		slowDown(2);
		click(ATPCenableYes);
	}
	
	/**
	 * This method is to verify additional ATPC settings elements are present when ATPC is enabled
	 */
	public void verifyATPCSettingsElements() {
		assertTrue("ATPC coordination power field is missing", isDisplayed(ATPCCoordPower,8));
		assertTrue("ATPC Nominal power level field is missing", isDisplayed(ATPCNominal,8));
		assertTrue("ATPC trigger level field is missing", isDisplayed(ATPCTriggerLevel,8));
		assertTrue("ATPC Alarm button is missing", isDisplayed(ATPCAlarmOn,8));
		assertTrue("ATPC power ramp button is missing", isDisplayed(ATPCPowerRamp,8));
		assertTrue("ATPC power step button is missing", isDisplayed(ATPCPowerStep,8));
	}
	
	/**
	 * This method verifies coordinated power functionality when ATPC is enabled
	 * the Coordinated Power is allowed to be:
	 * 		Minimum: (Max Power of All Enabled Modulations - 10) 
	 * 		Maximum: (Max Power of All Enabled Modulations) 
	 */
	public void verifyCoordPowerATPCEnabled(String coordPower, String maxPower) {
		clickJS(ATPCenableYes);
		slowDown(3);
		int minimumCoordPower = Integer.valueOf(maxPower) - 10;
		int maximumCoordPower = Integer.valueOf(maxPower);
		int coordinationPower = Integer.valueOf(coordPower);
		clear(ATPCCoordPower);
		type(coordPower, ATPCCoordPower);
		if(coordinationPower > maximumCoordPower) {
			assertTrue("Error message not thrown when coord power greater max power", isDisplayed(ATPCCoordPowerErrorMessage));
		}
		if(coordinationPower < minimumCoordPower) {
			assertTrue("Error message not thrown when coord power less than minimum power", isDisplayed(ATPCCoordPowerErrorMessage));
		}
		slowDown(3);
		clear(ATPCCoordPower);
		clickJS(ATPCDisableNo);
	}
	
	/**
	 * This method verifies coordinated power functionality when ACM Coordination advantage is enabled
	 * the Coordinated Power is allowed to be:
	 * 		Minimum: EITHER (Max Power of All Modulations - 3) 
	 * 		OR (Lowest Power of All Enabled Modulations), whichever is higher
	 * 		Maximum: (Max Power of All Enabled Modulations) 
	 */
	public void verifyCoordPowerACMCoordAdvantageEnabled(String coordPower, String maxPower, String lowestPower) {
		clickJS(ACMCoordAdvantageEnableYes);
		slowDown(3);
		int maximumCoordPower = Integer.valueOf(maxPower);
		int minimumCoordPower = Integer.valueOf(lowestPower);
		int coordinationPower = Integer.valueOf(coordPower);
		if(minimumCoordPower < maximumCoordPower - 3) {
			minimumCoordPower = maximumCoordPower - 3;
		}
		clear(ATPCCoordPower);
		type(coordPower, ATPCCoordPower);
		if(coordinationPower > maximumCoordPower) {
			assertTrue("Error message not thrown when coord power greater max power", isDisplayed(ATPCCoordPowerErrorMessage));
		}
		if(coordinationPower < minimumCoordPower) {
			assertTrue("Error message not thrown when coord power less than minimum power", isDisplayed(ATPCCoordPowerErrorMessage));
		}
		slowDown(3);
		clear(ATPCCoordPower);
		clickJS(ACMCoordAdvantageDisableNo);
	}
	
	/**
	 * This method is to verify Nominal Power EIRP and RSL values are Present
	 */
	/**
	 *
	 * @param power
	 * @param eirp
	 * @param rsl
	 */

	public void verifyNominalPowerEIRPandRSLPresent(String power,String eirp, String rsl) {
		assertTrue("path calculation result is missing",isDisplayed(resultNominalPowerPower ,20));
		String resultPower=getText(resultNominalPowerPower );
		assertEquals(resultPower,power);
		String resultEIRP=getText(resultNominalPowerEIRP );
		assertEquals(resultEIRP,eirp);
		String resultRSL=getText(resultNominalPowerRSL );
		assertEquals(resultRSL,rsl);

	}
	/**
	 * This method is to verify the path details created /updated dates and users labels in the path details footer
	 */
	public void verifyCreatedUpdatedUSerDatesLabel() {
		assertTrue("Created Date label is missing",isDisplayed(createdLabel ,20));
		assertTrue("Last updated Date label is missing",isDisplayed(lastUpdatedLabel,20));
		assertTrue("Created by label is missing",isDisplayed(createdByLabel ,20));
		assertTrue("Modidfied by label is missing",isDisplayed(modifiedByLabel ,20));

	}
	/**
	 * This method is to verify the created date is the current date
	 * @param todaysDate
	 */

	public void verifyCreatedDate(String todaysDate) {
		assertTrue("Created Date label is missing",isDisplayed(createdLabel ,20));
		assertEquals(todaysDate, getText(createdDate));
	}
	/**
	 * This method is to verify the Last updated date is the current date
	 * @param date
	 */

	public void verifyLastUpdatedDate(String date) {
		assertTrue("Created Date label is missing",isDisplayed(createdLabel ,20));
		assertEquals(date, getText(lastUpdatedDate));
	}
	/**
	 * This method is to verify the created user
	 * @param user
	 */

	public void verifyCreatedByUser(String user) {
		assertTrue("Created Date label is missing",isDisplayed(createdLabel ,20));
		assertEquals(user, getText(createdByUser));
	}
	/**
	 * This method is to verify the Last updated user
	 * @param user
	 */

	public void verifyUpdatedByUser(String user) {
		assertTrue("Created Date label is missing",isDisplayed(createdLabel ,20));
		assertEquals(user, getText(modifiedByUser));
	}
	/**
	 * This method is to open the first item from the project results
	 */

	public void clickFirstProjectFromProjectResults() {
		slowDown(4);
		click(projectList,0);

	}
	/**
	 * This method ois to verify site 1 values
	 * @param site1
	 * @param asr1
	 * @param lat1
	 * @param long1
	 * @param ele1
	 * @param bandDescriptionDotNinethree
	 */

	public void verifySite1Values(String site1, String asr1, String lat1, String long1, String ele1,String bandDescriptionDotNinethree) {
		slowDown(2);
		String siteName1=getFieldText(pathDetailSiteNameField1);
		assertEquals(siteName1,site1);
		String latitude1=getFieldText(pathDetailLatitudeField1);
		assertEquals(latitude1,lat1);
		String longitude1=getFieldText(pathDetailLongitudeField1);
		assertEquals(long1,longitude1);
		String elevation1=getFieldText(pathDetailGroundElevationField1);
		assertEquals(ele1,elevation1);
		String asrSite1=getFieldText(pathDetailAsrField1);
		assertEquals(asrSite1,asr1);
	}
	/**
	 *
	 * @param site2
	 * @param asr2
	 * @param lat2
	 * @param long2
	 * @param ele2
	 */

	public void verifySite2Values(String site2, String asr2, String lat2, String long2, String ele2) {
		String siteName2=getFieldText(pathDetailSiteNameField2);
		assertEquals(siteName2,site2);
		String latitude2=getFieldText(pathDetailLatitudeField2);
		assertEquals(latitude2,lat2);
		String longitude2=getFieldText(pathDetailLongitudeField2);
		assertEquals(long2,longitude2);
		String elevation2=getFieldText(pathDetailGroundElevationField2);
		assertEquals(ele2,elevation2);
		String asrSite2=getFieldText(pathDetailAsrField2);
		assertEquals(asrSite2,asr2);

	}
	/**
	 * This method id to click the Flip sites button
	 */
	public void clickFlipButtonOnPathDetails() {
		assertTrue("Flip button is missing on path details page", isDisplayed(pathDetailFlipButton));
		click(pathDetailFlipButton);
		slowDown(3);
	}
	
	/**
	 * This method is to click the add comment button
	 */
	public void clickAddCommentButton() {
		assertTrue("Add Comment Button is missing on path details page", isDisplayed(commentIconPathDetailsPage));
		clickJS(commentIconPathDetailsPage);
		slowDown(3);
	}
	
	/**
	 * This method is to create a new comment with attachment
	 * @param comment
	 * @param attachment
	 */
	public void createNewCommentWithAttachment(String comment, String attachment) {
		assertTrue(isDisplayed(commentAddNewField, 10));
		type(comment, commentAddNewField);
		assertTrue(isDisplayed(commentSaveButton, 10));
		uploadFile(attachment, attachmentFileLocation, commentSaveButton);
	}
	
	/**
	 * This method verifies the comment and attachment exists
	 * @param comment
	 * @param attachment
	 */
	public void verifyCommentAndAttachment(String comment, String attachment) {
		String commentNew = getText(commentItem);
		assertEquals(comment, commentNew);
		String attachmentNew = getText(attachmentRow);
		assertEquals(attachmentNew, attachment.toLowerCase());
		slowDown(1);
	}
	
	/**
	 * This method is to verify frequency plan of site1
	 * @param site1FreqPlan
	 */
	public void veryfyFrequencyPlanSite1(String site1FreqPlan) {
		String frequencyPlan1=getFieldText(site1FrequencyPlanField);
		assertEquals(site1FreqPlan,frequencyPlan1);

	}
	/**
	 * This method is to verify frequency plan of site2
	 * @param site2FreqPlan
	 */
	public void veryfyFrequencyPlanSite2(String site2FreqPlan) {
		String frequencyPlan2=getFieldText(site2FrequencyPlanField);
		assertEquals(site2FreqPlan,frequencyPlan2);

	}
	/**
	 * This method is see the number of sites in the environment on hi side
	 */
	public void numberOfSitesInEnvironmentOnhi () {
		String numberSitesHiSite1=getText(environmentSite1Hi );
		String numberSitesLoSite1=getText(environmentSite1Lo );
		String numberSitesHiSite2=getText(environmentSite2Hi );
		String numberSitesLoSite2=getText(environmentSite2Lo );
		assertEquals(numberSitesHiSite1,"0");
		assertEquals(numberSitesLoSite1,"0");
		assertEquals(numberSitesHiSite2,"0");
		assertEquals(numberSitesLoSite2,"0");



	}
	/**
	 * This method is to verify copying a path should bring the user to the new, Copied path
	 * @param index
	 */
	public void verifyCopyBringsTheUserToNewCopiedPath(String index) {
		assertTrue("Path details page is not displayed", isDisplayed(pathDetailSaveDetailsButton));
		slowDown(5);
		assertEquals(index,getAttributeValue(pathIndex));
	}
	/**
	 * This method is to open path
	 */
	public void openPath(){
		assertTrue("Path summary page isnt displayed",isDisplayed(editDetailsLink,40));
		click(editDetailsLink);
		assertTrue("Path detail page isnt displayed",isDisplayed(pathDetailSiteNameField1,40));

	}
	/**
	 * This method is to select frequency channels
	 */
	public void selectFrequencyChannels() {
		slowDown(5);
		selectFromDropdown(site1FrequencyChannel10,"Both V/H");
		selectFromDropdown(site2FrequencyChannel20,"Both V/H");
		slowDown(3);
	}
	/**
	 * This method is to make Site2AntennaRecive only for simplex path
	 */
	public void makeSite2AntennaRxForSimplexPath(String receiveMode) {
		assertTrue("Antenna mode in path details page isn't displayed",isDisplayed(antennaMode_2,40));
		selectFromDropdown(antennaMode_2,receiveMode);
		slowDown(1);
	}
	/**
	 * This method is to clear up validation drawer if present
	 * @return 
	 */
	public boolean isClearAllPresent(){
		slowDown(1);
		boolean clearall =isDisplayed(clearAllValidationDrawer,90);
		return clearall;
	}
	/**
	 * This method is to clear up validation drawer if present
	 * @return 
	 */
	public boolean isDrawerTriggerPresent(){
		slowDown(2);
		boolean drawerPresent =isDisplayed(clickDrawerTriggerI,90);
		return drawerPresent;
	}

	/**
	 * This method is to click clear all in validation drawer
	 */
	public void clickClearAll() {
		slowDown(1);
		assertTrue("Clear All in validation drawer is not present",isDisplayed(clearAllValidationDrawer,60));
		click(clearAllValidationDrawer);

	}
	/**
	 * This method is to click the drawer trigger
	 * 
	 */
	public void clickDrawerTrigger() {
		slowDown(1);
		assertTrue("validation drawer trigger i is not present",isDisplayed(clickDrawerTriggerI,60));
		click(clickDrawerTriggerI);
		slowDown(1);
	}
	/**
	 * This method is to verify user is on the new copied path
	 */
	public void verifyUserISOnTheNewCopiedPath() {
		slowDown(2);
		assertTrue("The Path Detail page did not appear",isDisplayed(pathDetailSiteNameField1,60));
		assertEquals("2",getFieldText(pageNo));

	}
	/**
	 * This method is to click Antenna lookup
	 */
	public void clickAntennaLookup() {
		assertTrue("The Path Detail page did not appear",isDisplayed(pathDetailSiteNameField1,60));
		clickJS(antennaLookupSite1);
		assertTrue("The antenna lookup page did not appear",isDisplayed(antennacodesite1AntennaLookup,120));
		assertTrue("Clear button in antenna lookup is missing",isDisplayed(antennasite1LookupClear,60));

	}
	/**
	 * This is for antenna lookup search
	 * @param code
	 * @param company
	 * @param modal
	 */
	public void verifyAntennaLookupAndSearch(String code, String company, String modal) {
		assertTrue("The antenna lookup page did not appear",isDisplayed(antennacodesite1AntennaLookup,60));
		assertTrue("The antenna lookup page did not appear",isDisplayed(antennasite1LookupCompany,60));
		assertTrue("The antenna lookup page did not appear",isDisplayed(antennasite1LookupModal,60));
		assertTrue("search button in lookup did not appear",isDisplayed(antennasite1LookupSearch,60));
		click(antennasite1LookupClear);
		type(code,antennacodesite1AntennaLookup);
		type(company,antennasite1LookupCompany);
		type(modal,antennasite1LookupModal);
		slowDown(2);
		clickJS(antennasite1LookupSearch);
		slowDown(1);
		assertTrue("Results didnt appear",isDisplayed(antennaSearchResult));
		click(antennaSearchResult,0);
		
	}
	  /**
     * This method is to verify the ground elevation lookup
     */
	public void clickGroundElevationLookupSite1() {
       assertTrue("path details page is missing", isDisplayed(commonLoss1,8));
       click(groundElevationLookupIcon1);
       slowDown(1);
       assertTrue("ground elevation lookup is missing", isDisplayed(groundElevationApplyButton,120));

	}
	/**
	 * This method is to verify the elevation value
	 * @param elevationValue
	 */
	public void verifyGroundElevationLookupValue(String elevationValue) {
       assertTrue("ground elevation lookup is missing", isDisplayed(groundElevationApplyButton,120));
       assertEquals(getText(groundElevationValue),elevationValue);
	}
	/**
	 * This method is to clear site status for site1
	 */
	public String clearSiteStatusFromAdministartiveSectionSite1() {
		assertTrue("Site 1 status field from administative section is missing",isDisplayed(site1StatusAdminSection,60));
		selectFromDropdown(site1StatusAdminSection,"-Select-");
		slowDown(1);
		//Can't depend on site name as the order of error is random each time, so changing site names to same name
		clear(pathDetailSiteNameField1);
		type("A",pathDetailSiteNameField1);
		String sitename1 =getFieldText(pathDetailSiteNameField1);
		return sitename1;
	}
	/**
	 * This method is to clear site status for site1
	 */
	public String clearSiteStatusFromAdministartiveSectionSite2() {
		assertTrue("Site 2 status field from administative section is missing",isDisplayed(site2StatusAdminSection,60));
		selectFromDropdown(site2StatusAdminSection,"-Select-");
		slowDown(1);
		//Can't depend on site name as the order of error is random each time, so changing site names to same name
		clear(pathDetailSiteNameField2);
		type("A",pathDetailSiteNameField2);
		String sitename2 =getFieldText(pathDetailSiteNameField2);
		return sitename2;
	}
	/**
	 * This method is to verify the validation drawer
	 * 
	 */
	public void validationDrawerWarning(String drawerHeading) {
		assertTrue("validation drawer is missing",isDisplayed(clearAllValidationDrawer,66));
		assertEquals(getText(validationDrawerHeading),drawerHeading);
	}
	/**
	 * This method is to verify the path save constraint error
	 * @param site1name
	 * @param site2Name
	 */
	public void verifyPathSaveConstraintError(String site2name, String site1name) {
		assertTrue("Error message is missing",isDisplayed(clearAllValidationDrawer,66));
		assertEquals(getText(projectError1OnSaveDrawer),site2name+" Site Status cannot be null");
		assertEquals(getText(projectError2OnSaveDrawer),site1name+" Site Status cannot be null");
	}
	
	/**
	 * This method verifies path save error validations 
	 */
	public void verifyPathSaveErrorValidations(String groundElevation, String groundElevation2, String latitude) {
		String originalGroundElevation = getFieldText(pathDetailGroundElevationField1);
		String errorMessage1 = "Ground Elevation must be within +0.5 or -3.0 meters of the ASR Ground Elevation.";
		String errorMessage2 = "Coordinates are greater than 1 second away from the ASR Coordinates.";
		clear(pathDetailGroundElevationField1);
		type(groundElevation, pathDetailGroundElevationField1);
		click(pathDetailSaveDetailsButton);
		slowDown(4);
		assertTrue("Ground elevation error message is missing", getText(projectError1OnSaveDrawer).contains(errorMessage1));
		slowDown(3);
		clickJS(clearAllValidationDrawer);
		clear(pathDetailGroundElevationField1);
		type(groundElevation2, pathDetailGroundElevationField1);
		click(pathDetailSaveDetailsButton);
		slowDown(3);
		assertTrue("Ground elevation error message is missing", getText(projectError1OnSaveDrawer).contains(errorMessage1));
		slowDown(3);
		clickJS(clearAllValidationDrawer);
		clear(pathDetailGroundElevationField1);
		type(originalGroundElevation, pathDetailGroundElevationField1);
		click(pathDetailSaveDetailsButton);
		assertTrue("Path saved success message is missing",isDisplayed(pathSaveMessageNotification,19));
		slowDown(2);
		clear(pathDetailLatitudeField1);
		type(latitude, pathDetailLatitudeField1);
		click(pathDetailSaveDetailsButton);
		slowDown(3);
		assertTrue("Coordinates error message is missing", getText(projectError1OnSaveDrawer).contains(errorMessage2));
	}
	
	
	/**
	 * This method is to verify company name on path details page
	 * @param contactCode
	 * @param CompanyName
	 */
	public void verifyCompanyNameOnPathDetailPage(String contactCode,String CompanyName) {
	    assertTrue("path details page is missing", isDisplayed(PathDetailsContactField1,20));
	    clear(PathDetailsContactField1);
	    clear(PathDetailsContactField1);
	    type(contactCode,PathDetailsContactField1);
	    click(pathDetailSiteNameField1);
	    slowDown(1);
	    assertTrue("Company name for contact on path details page is missing", isDisplayed(pathDetailsConatctCompany,40));
	    assertEquals(CompanyName,getText(pathDetailsConatctCompany));
		
	}
	/**
	 * This method is to make the site 2 anatenna Rx only
	 */
	public void makePathSimplexAndSave() {
	    assertTrue("path details page is missing", isDisplayed(PathDetailsContactField1,20));
	    assertTrue("Antenne mode for site 2 radio is missing", isDisplayed(antennaMode_2,20));
		selectFromDropdown(antennaMode_2, "RX Only");
		click(pathDetailSaveDetailsButton);
		slowDown(4);
		
	}
	/**
	 * This method is to verify the hover over message
	 * @param message
	 */
	public void verifyMessageOnHoverOverFlipSitesSimplexPath(String message) {
	    assertTrue("Flip button on path details page is missing", isDisplayed(pathDetailFlipButton,20));
	    assertEquals(message,getFieldTextTitle(pathDetailFlipButton));
	}
	/**
	 * this method is to add ASR and click save
	 */
	public void addASRAndClickSave(String ASR2) {
	    assertTrue("ASR field is missing", isDisplayed(pathDetailAsrSearch2,20));
	    slowDown(1);
	    click(pathDetailAsrSearch2);
	    assertTrue("ASR Lookup is missing",isDisplayed(asrLookupClearButton,50));
	    click(asrLookupClearButton);
		type(ASR2,asrLookUpAsrNumberField);
		click(asrLookUpSearchButton);
		assertTrue("ASR results are missing",isDisplayed(asrNumberResults,60));
		click(asrNumberResults);
		assertTrue("path details page is missing",isDisplayed(pathDetailGroundElevationField1));
		click(pathDetailSaveDetailsButton);
	}
	/**
	 * this method is to verify the error 
	 */
	public void verifyPathLengthError( String error) {
	    assertTrue("path length error is missing", isDisplayed(pathLengthError,120));
	    assertEquals((getText(pathLengthError)),error);

	}

	/**
	 * This method is to delete attachment
	 */
	public void deleteAttachment() {
		assertTrue("comment is not added",isDisplayed(deleteAttachmentComment,70));
		clickJS(deleteAttachmentComment);
		assertTrue("Delete confirmation modal is missing",isDisplayed(deletecommentConfirmation,50));
		click(deletecommentConfirmation);
		assertTrue("comment is not deleted sucessfully",isDisplayed(deleteCommentnotificationMessage,40));
		assertEquals(getText(deleteCommentnotificationMessage),"Path Comment File deleted successfully");

	}
	/**
	 * This method is to verify legacy radio code
	 * @param legacyRadioCode1
	 */
	public void verifyLegacyRadioCode(String legacyRadioCode1) {
		assertTrue("Legacy radio code is missing", isDisplayed(legacyRadioCodePathDetails,40));
		assertEquals(getText(legacyRadioCodePathDetails),legacyRadioCode1+"Favorited");
		
	}
	/**
	 * This method is to close the warning in path details
	 */
	public void closeWarning() {
		slowDown(2);
		if(isDisplayed(clearAllValidationDrawer)) {
			click(clearAllValidationDrawer);
			assertTrue("path detals missing",isDisplayed(pathDetailSiteNameField1,40));
		}
	}
	/**
	 * this method is to click return button from path details page without save
	 */

	public void clickReturnButtonInPathDetailsPageWithoutSave() {
		assertTrue("Path details page is not displayed",isDisplayed(pathDetailSiteNameField1,60));
		slowDown(1);
		click(pathDetailDiscardButton );
		slowDown(1);
		click(leaveWithoutSavingConfirmButton);
		slowDown(1);
	}
	/**
	 * This method is to click Hi Lo
	 */
	public void clickHiLo() {
		assertTrue("path details hi lo link is missing", isDisplayed(hiLoEnvironmentLink,20));
		clickJS(hiLoEnvironmentLink);
		assertTrue("Hi-Lo environment modal is missing",isDisplayed(hiLoRadius,20));
		
	}
	/**
	 * this method is to verify the elements in hi lo modal
	 */
	public void verifyHiLoModal() {
		assertTrue("Hi-Lo environment modal is missing",isDisplayed(hiLoRadius,20));
		assertTrue("Hi Lo contact code is missing", isDisplayed(hiLoContactCode,20));
		assertTrue("Hi lo search button is missing",isDisplayed(hiloSearch,20));
		assertTrue("site 1 hi lo count is missing",isDisplayed(site1HiLoCount,20));
		assertTrue("site 2 hi lo count is missing",isDisplayed(site2HiLoCount,20));
		assertTrue("hi lo close icon missing",isDisplayed(hiloClose,20));
	}
	/**
	 * This method is to add site info in passive window
	 * @param siteName
	 * @param lat
	 * @param longitude
	 * @param ge 
	 */
	public void passiveSiteInfo(String siteName, String lat, String longitude, String ge) {
		assertTrue("passive window is not displayed",isDisplayed(sitenamePassive,20));
		type(siteName,sitenamePassive);
		type(lat,latpassive);
		type(longitude,longitudePassive);
		type(ge,groundelevationPassive);

		
		
	}
	/**
	 * This method is to verify report button is present on path details page
	 */

	public void verifyReportButtonPresent() {
		assertTrue("reports button is not displayed",isDisplayed(reportsButtonPathDetails,20));
		
	}
	/**
	 * This method is to verify the bandwidth field is populated on frequency lookup moadal
	 */
	public void verifyBandwidthFieldInFrequencyLookupModal(String bandwidth) {
		assertTrue("frequency Lookup Plan Bandwidth is not displayed",isDisplayed(frequencyLookupPlanBandwidth,20));
		assertEquals(getFieldText(frequencyLookupPlanBandwidth),bandwidth);
		
	}
	/**

	 * This method is to add path name to path name field
	 * @param string
	 */
	public void addPathName(String pathname) {
		assertTrue("path name field is not displayed",isDisplayed(pathNamefieldPathDetails,20));
		type(pathname,pathNamefieldPathDetails);
	}
	/**
	 * this method is to click additional anatenna link in path details page
	 */
	public void clickAdditionalaAntenna() {
		assertTrue("Additional antenna link missing",isDisplayed(addAdditionalAntennaForSite1,30));
		clickJS(addAdditionalAntennaForSite1);
		assertTrue("Additional antenna code is missing", isDisplayed(additionalAntennaCode,40));
	}
	/**
	 * this method is to verify rx mode for additional antenna and diversity flag is checked
	 */
	
	public void verifyAdditionalDiversityModel() {
		assertTrue("Additional antenna code is missing", isDisplayed(additionalAntennaCode,40));
		assertTrue("Diversity flag is not checked", isDisplayed(diversitySquareChecked,30));
		assertEquals(getTextDropdown(additionalAntennaTransmitMode),"RX Only");
	}
	
	

}

