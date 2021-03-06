package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author nshaji
 *
 */
public class PathDetailsRadioPage extends BasePage {


	//Path Data Fields - Element is read only and can use getFieldText method

	//Headings
	By radioImage = By.id("path-details-section-header-radio-icon");


	//Buttons
	By radioCopyArrowButton = By.id("path-details-section-header-radio-copy-button");
	By radioModelLeftButton1 = By.cssSelector(".lookup-trigger-icon.margin-left-half.pointer.pull-right.flex-child-1-0-auto.cursor-not-allowed");
	By radioAutoTransmitPowerControlLeftAddButton1 = By.id("path-details-radios-0-atpc-trigger");
	By radioAutoTransmitPowerControlLeftAddButton1Fox = By.cssSelector(".atpc-settings-trigger.uppercase.pointer");
	By radioAutoTransmitPowerControlLef1Xpath = By.id("path-details-radios-0-trigger-atpc");
	By radioAtpcEnabledTrue =By.id("atpc-and-acm-settings-atpcEnabled-true-label");
	By radioAtpcEnabledFalse =By.id("atpc-and-acm-settings-atpcEnabled-false-label");
	By radioAtpcSubmitButton =By.id("atpc-and-acm-settings-submit");

	By atpcModalRampButton = By.id("atpc-and-acm-settings-power-increase-Ramp");
	By atpcModalStepButton = By.id("atpc-and-acm-settings-power-increase-Step");
	By atpcModalFiveMinAlarmOnButton = By.id("atpc-and-acm-settings-five-minute-alarm-true");
	By atpcModalFiveMinAlarmOffButton = By.id("atpc-and-acm-settings-five-minute-alarm-false");
	By atpcModalSaveButton = By.cssSelector(".btn.btn-md.bg-green.hover-inverse.margin-left-half");
	By atpcLightingBoltButtonLeft = By.id("path-details-radios-0-atpc-trigger");
	By atpcModalRampOnButton = By.id("atpc-and-acm-settings-power-increase-Ramp");
	By atpcModal5MinAlarmOnButton = By.id("atpc-and-acm-settings-five-minute-alarm-true");
	By saveFavButton = By.cssSelector(".fa.fa-lg.fa-heart ");
	By radioCodeLookupICon = By.id("path-details-radio-0-lookup-trigger");
	By radioLookupSearchButton = By.id("radio-lookup-submit");


	//Path DropDown Fields -- Does it contain a list that has options that can be selected

	//Drop down options
	//Path Entry Fields - Able to use the type method
	By radioModelFieldLeft = By.id("path-details-radios-0-radio-model");
	By radioCodeFieldLeft = By.id("path-details-radios-0-radio-code");
	By passiveSiteName = By.id("path-details-passive-repeaters-0-siteName");
	By radioMaxPowerLeft = By.id("path-details-radios-0-max-power");
	By radioModelFieldRight = By.id("path-details-radios-1-radio-model");
	By siteName1PathDetail =By.id("path-details-site-0-siteName");
	By radioCodeFieldRight = By.id("path-details-radios-1-radio-code");

	By radioMaxPowerRight = By.id("path-details-radios-1-max-power");

	By atpcModalTriggerLevelField = By.id("atpc-settings-trigger-level");
	By atpcModalNominalPowerLevelField = By.id("atpc-settings-nominal-power");
	By atpcModalCoordinatedPowerField = By.id("atpc-settings-coordinated-power");
	By atpcNominalErrorMsg = By.id("atpc-settings-nominal-power-error-message");



	By commonLossFieldLeft = By.id("path-details-losses-0-common-loss");
	By transmitLossFieldLeft = By.id("path-details-losses-0-transmit-loss");
	By recieveLossFieldLeft = By.id("path-details-losses-0-receive-loss");
	By commonLossFieldRight = By.id("path-details-losses-1-common-loss");
	By transmitLossFieldRight = By.id("path-details-losses-1-transmit-loss");
	By recieveLossFieldRight = By.id("path-details-losses-1-receive-loss");


	//Path hovers -- Able to use the hover method
	By radioCompanyFieldLeft = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[1]/li[1]/ul/li[3]/div/p");
	By radioFamilyFieldLeft1 = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[1]/li[1]/ul/li[4]/div/p/span[1]");
	By radioFamilyFieldLeft2 = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[1]/li[1]/ul/li[4]/div/p/span[2]");
	By radioBandwidthFieldLeft = By.id("path-details-radios-0-bandwidth");

	By radioCompanyFieldRight = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[2]/li[1]/ul/li[3]/div/p");
	By radioFamilyFieldRight1 = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[2]/li[1]/ul/li[4]/div/p/span[1]");
	By radioFamilyFieldRight2 = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div/form/div[4]/div/ul[2]/li[1]/ul/li[4]/div/p/span[2]");
	By radioBandwidthFieldRight = By.id("path-details-radios-1-bandwidth");

	By radioCoordinatedPowerFieldLeft = By.id("path-details-radios-0--0-coordinated-power");
	By radioModulationArrayRowsLeft = By.xpath("//*[contains(@id, 'path-details-radios-0-modulations-') and contains(@id, '-modulationSchemeDescription')]");
	By radioModulationArrayRowsLeftSelection = By.cssSelector(".modulation-row position-relative enabled");
	By radioModulationArrayRowsLeftSelectionOfDisabled = By.cssSelector(".modulation-row.position-relative");


	By radioMbpsArrayRowsLeft = By.xpath("//*[contains(@id, 'path-details-radios-0-modulations-') and contains(@id, '-throughput')]");
	By radioModulationMaxPowerArrayRowsLeft = By.xpath("//*[contains(@id, 'path-details-radios-0-modulations-') and contains(@id, '-power')]");

	By radioCoordinatedPowerFieldRight = By.id("path-details-radios-1--1-coordinated-power");
	By radioModulationArrayRowsRight = By.xpath("//*[contains(@id, 'path-details-radios-1-modulations-') and contains(@id, '-modulationSchemeDescription')]");
	By radioMbpsArrayRowsRight = By.xpath("//*[contains(@id, 'path-details-radios-1-modulations-') and contains(@id, '-throughput')]");
	By radioModulationMaxPowerArrayRowsRight = By.xpath("//*[contains(@id, 'path-details-radios-1-modulations-') and contains(@id, '-power')]");
	By radioRadioErrorLeft = By.id("path-details-radios-0-radio-code-error-message");
	By radioRadioErrorRight = By.id("path-details-radios-1-radio-code-error-message");
	By radioRadioErrorExceedsModLeft = By.id("path-details-radios-0-max-power-error-message");
	By radioRadioErrorExceedsNegTwentyModLeft = By.id("path-details-radios-0-max-power-error-message");
	By atpcCoordinatedErrorMsg = By.id("atpc-settings-coordinated-power-error-message");

	By xClearPoint = By.cssSelector(".clear-input-button.pointer");

	By radioLookupRadioCode = By.id("radio-lookup-radio-code");
	By radioLookupClearButton = By.id("clearValues");
	By radioLookupRadioCompany = By.id("radio-lookup--radio-company");
	By radioLookupRadioFamily = By.id("radio-lookup--radio-family");
	By radioLookupRadioModel = By.id("radio-lookup--model-number");
	By radioLookupEmissionBandwidth = By.id("radio-lookup-emission-bandwidth");
	By radioLookupModulationType = By.id("radio-lookup-modulation-type");
	By radioLookupRight= By.id("path-details-radio-1-lookup-trigger");
	By radioLookupModulation = By.id("radio-lookup-modulationSchemeDescriptiont");;
	By radioLookupThroughput = By.id("radio-lookup-throughput");
	By radioLookupPower = By.id("radio-lookup-power");
	By radioLookupArchitecture = By.id("radio-lookup-architecture-type");
	By radioLookupRows = By.id("radio-lookup-modal-table");
	By aCMToolTip = By.cssSelector(".__react_component_tooltip.place-bottom.type-light.project-summary-tooltip.tooltip-wrapper");//.place-bottom.type-light.project-summary-tooltip.tooltip-wrapper
	By aCMToolTip1 = By.cssSelector(".tooltip-trigger-decoration.show-decoration.acm-tooltip-decoration");//.place-bottom.type-light.project-summary-tooltip.tooltip-wrapper


	By aCMToolTip5 = By.cssSelector(".__react_component_tooltip.place-bottom.type-light.project-summary-tooltip.tooltip-wrapper");
	By aCMToolTip6 = By.xpath("//*[contains(@data-class, 'project-summary-tooltip tooltip-wrapper')]");//-modulation-rowclass="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"

	//radio-lookup-modal-table


	//Index List -- Can you used an array to select item
	By referrencePosition1 = By.xpath("//*[@id=\"path-details-radios-0-modulations-0-label\"]");
	By referrencePosition2 = By.xpath("//*[@id=\"path-details-radios-0-modulations-1-label\"]");
	By activeModLeft = By.xpath("//*[contains(@class, 'modulation-row position-relative enabled') and contains(@id, 'path-details-radios-0-modulations-')]");//-modulation-rowclass="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"
	By activeModRight = By.xpath("//*[contains(@class, 'modulation-row position-relative enabled') and contains(@id, 'path-details-radios-1-modulations-')]");//-modulation-rowclass="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"

	By inactiveModLeft = By.xpath("//*[@class='modulation-row position-relative') and contains(@id, 'path-details-radios-0-modulations-')]");//-modulation-rowclass="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"

	//Modal -- Does it pop up over current window
	By atpcErrorMsg = By.id("atpc-settings-trigger-level-error-message");


	By atpcModalTitle = By.cssSelector("padding-left-half margin-left-half");

	By commonLossErrorMsgLeft = By.id("path-details-losses-0-common-loss-error-message");
	By transmitLossErrorMsgLeft = By.id("path-details-losses-0-transmit-loss-error-message");
	By recieveLossErrorMsgLeft = By.id("path-details-losses-0-receive-loss-error-message");
	By commonLossErrorMsgRight = By.id("path-details-losses-1-common-loss-error-message");
	By transmitLossErrorMsgRight = By.id("path-details-losses-1-transmit-loss-error-message");
	By recieveLossErrorMsgRight = By.id("path-details-losses-1-receive-loss-error-message");

	By toolTipValidation = By.id("//*[@id='radio-lookup-modal-table-data-radioCode-M11988-modulationName']/span");
	By radioCodeListResult = By.xpath("//*[contains(@id, 'radio-lookup-modal-table-data-radioCode-')]");

	public PathDetailsRadioPage(WebDriver driver) {
		super(driver);
		visit("");
	}



	public void hoverAndValidate(){
		//select the radio search button
		assertTrue("cant find radio code lookup icon",isDisplayed(radioCodeLookupICon,10));
		//scroll(radioModelSearchButton);
		clickJS(radioCodeLookupICon);
		//validate the radio search opened
		assertTrue("cant find radioLookupRadioCode",isDisplayed(radioLookupRadioCode,10));
		//select the search button
		assertTrue("cant find radioLookupRadioCode",isDisplayed(radioLookupSearchButton,5));
		clickJS(radioLookupSearchButton);
		//find the row
		isDisplayed(radioLookupRows,10);
		String radioRow = getText(radioLookupRows);
		//hover acm
		assertTrue("cant find aCMToolTip",isDisplayed(aCMToolTip1,30));
		if(chrome.equals("chrome")){
			hoverElement(aCMToolTip6);
		}
		else{clickJS(aCMToolTip6);}

	}




	public void clearAllLossFields() {
		clear(commonLossFieldRight);
		click(transmitLossFieldRight);

		clear(transmitLossFieldRight);
		click(recieveLossFieldRight);

		clear(recieveLossFieldRight);
		click(commonLossFieldLeft);

		clear(commonLossFieldLeft);
		click(transmitLossFieldRight);

		clear(transmitLossFieldLeft);
		click(transmitLossFieldRight);

		clear(recieveLossFieldLeft);
		click(transmitLossFieldRight);

	}

	public void lossErrorLeft(String commonLossErrorLeft,String transmitLossErrorLeft,String recieveLossErrorLeft){
		isDisplayed(commonLossFieldLeft,6);
		slowDown(2);
		String commonLossErrorValue = getText(commonLossErrorMsgLeft);
		String transmitLossErrorValue = getText(transmitLossErrorMsgLeft);
		String recieveLossErrorValue = getText(recieveLossErrorMsgLeft);
		assertEquals(commonLossErrorLeft,commonLossErrorValue);
		assertEquals(transmitLossErrorLeft,transmitLossErrorValue);
		assertEquals(recieveLossErrorLeft,recieveLossErrorValue);
	}

	public void lossErrorRight(String commonLossErrorRight,String transmitLossErrorRight,String recieveLossErrorRight){
		isDisplayed(commonLossFieldRight,6);
		slowDown(2);
		String commonLossErrorValue = getText(commonLossErrorMsgRight);
		String transmitLossErrorValue = getText(transmitLossErrorMsgRight);
		String recieveLossErrorValue = getText(recieveLossErrorMsgRight);
		assertEquals(commonLossErrorRight,commonLossErrorValue);
		assertEquals(transmitLossErrorRight,transmitLossErrorValue);
		assertEquals(recieveLossErrorRight,recieveLossErrorValue);
	}

	public void validateLossLeft(String commonLossLeft,String transmitLossLeft,String recieveLossLeft){
		assertTrue("Cant find Common Loss field",isDisplayed(commonLossFieldLeft));
		assertTrue("Cant find Common Loss field",isDisplayed(transmitLossFieldLeft));
		assertTrue("Cant find Common Loss field",isDisplayed(recieveLossFieldLeft));
		String commonLossFieldValue = getFieldText(commonLossFieldLeft);
		String transmitLossFieldValue = getFieldText(transmitLossFieldLeft);
		String recieveLossFieldValue = getFieldText(recieveLossFieldLeft);
		assertEquals(commonLossLeft,commonLossFieldValue);
		assertEquals(transmitLossLeft,transmitLossFieldValue);
		assertEquals(recieveLossLeft,recieveLossFieldValue);
	}

	public void validateLossRight(String commonLossRight,String transmitLossRight,String recieveLossRight){
		assertTrue("Cant find Common Loss field",isDisplayed(commonLossFieldRight));
		assertTrue("Cant find Common Loss field",isDisplayed(transmitLossFieldRight));
		assertTrue("Cant find Common Loss field",isDisplayed(recieveLossFieldRight));
		String commonLossFieldValue = getFieldText(commonLossFieldRight);
		String transmitLossFieldValue = getFieldText(transmitLossFieldRight);
		String recieveLossFieldValue = getFieldText(recieveLossFieldRight);
		assertEquals(commonLossRight,commonLossFieldValue);
		assertEquals(transmitLossRight,transmitLossFieldValue);
		assertEquals(recieveLossRight,recieveLossFieldValue);
	}

	public void addLossLeft(String commonLossLeft,String transmitLossLeft,String recieveLossLeft){
		assertTrue("Cant find Common Loss field",isDisplayed(commonLossFieldLeft));
		assertTrue("Cant find transmit Loss field",isDisplayed(transmitLossFieldLeft));
		assertTrue("Cant find recieve Loss field",isDisplayed(recieveLossFieldLeft));
		clear(commonLossFieldLeft);
		clear(transmitLossFieldLeft);
		clear(recieveLossFieldLeft);
		type(commonLossLeft,commonLossFieldLeft);
		type(transmitLossLeft,transmitLossFieldLeft);
		type(recieveLossLeft,recieveLossFieldLeft);

	}

	public void addLossRight(String commonLossRight,String transmitLossRight,String recieveLossRight){
		assertTrue("Cant find Common Loss field",isDisplayed(commonLossFieldRight));
		assertTrue("Cant find Common Loss field",isDisplayed(transmitLossFieldRight));
		assertTrue("Cant find Common Loss field",isDisplayed(recieveLossFieldRight));
		clear(commonLossFieldRight);
		clear(transmitLossFieldRight);
		clear(recieveLossFieldRight);
		type(commonLossRight,commonLossFieldRight);
		type(transmitLossRight,transmitLossFieldRight);
		type(recieveLossRight,recieveLossFieldRight);

	}



	public void isRadioSectionAvailable(){
		assertTrue(!isDisplayedAndClickable(siteName1PathDetail,10));
		;
	}


	public void enterValuesInATPCForm(String triggerLevel, String nominal, String coordinatedPower){
		assertTrue("ATPC is not open",isDisplayed(atpcModalTriggerLevelField,10));
		assertTrue("TriggerLeve is not open",isDisplayed(atpcModalTriggerLevelField,10));
		assertTrue("NominalPowerLevel is not open",isDisplayed(atpcModalNominalPowerLevelField,10));
		assertTrue("CoordinatedPower is not open",isDisplayed(atpcModalCoordinatedPowerField,10));
		clear(atpcModalTriggerLevelField);
		clear(atpcModalNominalPowerLevelField);
		clear(atpcModalCoordinatedPowerField);
		type(triggerLevel, atpcModalTriggerLevelField);
		click(atpcModalNominalPowerLevelField);
		if(isDisplayed(atpcErrorMsg,4)){
			System.out.println("Got Field error");
		}else {
			type(nominal, atpcModalNominalPowerLevelField);
			click(atpcModalCoordinatedPowerField);
			type(coordinatedPower, atpcModalCoordinatedPowerField);
			click(atpcModalTriggerLevelField);
		}

	}

	public void saveATPC(){
		isDisplayed(atpcModalSaveButton,10);
		click(atpcModalSaveButton);
		assertTrue("The Lightning bolt did no appear",isDisplayed(atpcLightingBoltButtonLeft,8));

	}

	public boolean atpcError(String errorMsg){
		slowDown(4);
		String bounderyError = getText(atpcErrorMsg);
		assertEquals(bounderyError,errorMsg);
		boolean error =isDisplayed(atpcErrorMsg,10);
		return error;
	}
	public boolean atpcErrorNominalPowerLevel(String errorMsg){
		String bounderyError = getText(atpcNominalErrorMsg);//atpc-settings-nominal-power-error-message
		assertEquals(bounderyError,errorMsg);
		boolean error =isDisplayed(atpcNominalErrorMsg,10);
		return error;
	}
	public boolean atpcErrorCoordinatedPowerLevel(String errorMsg){
		String bounderyError = getText(atpcCoordinatedErrorMsg);//atpc-settings-coordinated-power-error-message
		assertEquals(bounderyError,errorMsg);
		boolean error =isDisplayed(atpcCoordinatedErrorMsg,10);
		return error;
	}

	public void openATPCViaLighteningBolt(){
		assertTrue("The Lightning bolt did no appear",isDisplayed(atpcLightingBoltButtonLeft,10));
		clickJS(atpcLightingBoltButtonLeft);
		slowDown(1);
		assertTrue("TriggerLeve is not open",isDisplayed(atpcModalTriggerLevelField,10));
		assertTrue("NominalPowerLevel is not open",isDisplayed(atpcModalNominalPowerLevelField,10));
		assertTrue("CoordinatedPower is not open",isDisplayed(atpcModalCoordinatedPowerField,10));

	}

	public void createATPC(){
		assertTrue("ATPC is not open",isDisplayed(atpcModalTriggerLevelField,10));
		type("-2",atpcModalTriggerLevelField);
		type("1",atpcModalNominalPowerLevelField);
		click(atpcModalSaveButton);
		assertTrue("The ATPC Lightning bolt indicator did not appear",isDisplayed(atpcLightingBoltButtonLeft,8));
	}

	public void openATPC(){
		assertTrue("the ATPC add button is not present",isDisplayed(radioAutoTransmitPowerControlLef1Xpath,10));
		clickJS(radioAutoTransmitPowerControlLef1Xpath);
		slowDown(2);
		assertTrue("the ATPC modal Enabled True button is not present",isDisplayed(radioAtpcEnabledTrue,10));
		assertTrue("the ATPC modal Enabled False button is not present",isDisplayed(radioAtpcEnabledTrue,10));
		assertTrue("the ATPC modal submit button is not present",isDisplayed(radioAtpcSubmitButton,10));

	}

	public void setRampChecked() {
		isDisplayed(atpcModalRampButton,5);//atpc-settings-power-increase-Ramp
		click(atpcModalRampButton);
	}

	public void set5MinChecked() {
		isDisplayed(atpcModalFiveMinAlarmOnButton,5);//atpc-settings-power-increase-Ramp
		click(atpcModalFiveMinAlarmOnButton);
	}

	public void setStepChecked() {
		isDisplayed(atpcModalStepButton,5);//atpc-settings-power-increase-Ramp
		click(atpcModalStepButton);
	}

	public void set5MinUnChecked() {
		isDisplayed(atpcModalFiveMinAlarmOffButton,5);//atpc-settings-power-increase-Ramp
		click(atpcModalFiveMinAlarmOffButton);
	}

	public boolean isRampCheckedDefault() {
		isDisplayed(atpcModalRampOnButton,5);//atpc-settings-power-increase-Ramp
		boolean selected = checked(atpcModalRampOnButton);
		return selected;
	}

	public boolean is5MinAlarmCheckedDefault() {
		isDisplayed(atpcModal5MinAlarmOnButton,5);//atpc-settings-five-minute-alarm-On
		boolean selected = checked(atpcModal5MinAlarmOnButton);
		return selected;
	}
	public void copyRadio(){
		assertTrue(isDisplayed(radioCopyArrowButton,30));
		clickJS(radioCopyArrowButton);
		slowDown(2);
		waitForFieldToBeNotNull(radioCodeFieldRight);
	}

	public void resetModulation(){
		type("1",commonLossFieldLeft);
		//LEGO-710
		type("",radioCodeFieldLeft);
		clickJS(radioCodeFieldLeft);
		slowDown(2);
		//LEGO-710
		type("2",commonLossFieldLeft);
		slowDown(2);
	}

	public void deactivateModulationNew(int i) {
		if(isDisplayed(activeModLeft, 10))
			clickJS(activeModLeft, i);
	}

	public void deactivateModulation(int i) {
		isDisplayed(radioModulationArrayRowsLeftSelection, 10);
		clickJS(radioModulationArrayRowsLeftSelection, i);
	}

	public void activateModulation(int i) {
		isDisplayed(radioModulationArrayRowsLeftSelectionOfDisabled, 10);
		clickJS(radioModulationArrayRowsLeftSelectionOfDisabled, i);
	}

	public void checkRefPosition1() {
		assertTrue(isDisplayed(referrencePosition1, 10));
	}

	public void checkRefPosition2() {
		assertTrue(isDisplayed(referrencePosition2, 10));
	}

	public void changeGreatestPower(String updateMax) {
		isDisplayed(radioMaxPowerLeft,4);
		clear(radioMaxPowerLeft);
		slowDown(4);
		clear(radioMaxPowerLeft);
		type(updateMax, radioMaxPowerLeft);
		slowDown(4);
		clickJS(radioCodeFieldRight);
		slowDown(2);
		clear(commonLossFieldLeft);
		type("1",commonLossFieldLeft);

	}

	/**
	 * this method will return the max power from the given list of modulations of Site1 Radio
	 * Radio Code - M11988 used in RadioTest.java only has six modulations.
	 */
	public String findMaxPower() {
		List<String> radioModulationPowersList = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			String rows = getFieldTextPlural(radioModulationMaxPowerArrayRowsLeft, i);
			radioModulationPowersList.add(rows);
		}
		String i = Collections.max(radioModulationPowersList);
		return i;

	}
	private String getRows(){
		String rows =  getFieldText(radioModulationMaxPowerArrayRowsRight);
		return rows;
	}

	public void validateCurrentMaxPowerAndCoordinatedPower(String maxPower, String coordinatedPower){
		slowDown(2);
		assertTrue(isDisplayed(radioMaxPowerLeft));
		String currMaxPower = getFieldText(radioMaxPowerLeft);
		String currCoordinatedPower = getFieldText(radioCoordinatedPowerFieldLeft);
		assertEquals(currMaxPower,maxPower);
		assertEquals(currCoordinatedPower,coordinatedPower);
	}

	public void validateCurrentMaxPowerLeft(String maxPower){
		slowDown(2);
		assertTrue(isDisplayed(radioMaxPowerLeft));
		String currMaxPower = getFieldText(radioMaxPowerLeft);
		assertEquals(currMaxPower,maxPower);
	}

	public void maxPowerDefault(String autoUpdateMax){
		String maxPowerFieldVal = getFieldText(radioMaxPowerLeft);
		assertEquals(maxPowerFieldVal,autoUpdateMax);
	}

	public void errorCorrectionLeft(String radioErrorText) {
		isDisplayed(radioCodeFieldRight,10);
		click(radioCodeFieldRight);
		isDisplayed(radioRadioErrorLeft,20);
		String radioError = getText(radioRadioErrorLeft);
		assertEquals(radioErrorText, radioError);
	}

	public void saveFavRadioCodeEnterNewCode(){
		type("1",commonLossFieldLeft);
		assertTrue("cannot find fav button",isDisplayed(saveFavButton,5));
		click(saveFavButton);
		assertTrue("cannot find radioMaxPowerLeft",isDisplayed(radioMaxPowerLeft,5));
		//LEGO-710
		clickJS(radioMaxPowerLeft);
		clear(radioCodeFieldRight);
		clear(radioCodeFieldRight);
		slowDown(2);
		//LEGO-710
		clickJS(radioMaxPowerLeft);
		String getFavCode = getFieldText(radioCodeFieldLeft);
		type(getFavCode,radioCodeFieldRight);
		//LEGO-710
		clickJS(radioMaxPowerLeft);
	}

	/**
	 * This method is to save radio favorite
	 */

	public void saveFavRadioCodeEnterSameFavCode() {
		type("1", commonLossFieldLeft);
		assertTrue("cannot find fav button", isDisplayed(saveFavButton, 5));
		click(saveFavButton);
		slowDown(3);
		assertTrue("cannot find radioCodeFieldLeft", isDisplayed(radioCodeFieldLeft, 5));
		String getFavCode = getFieldText(radioCodeFieldLeft);
		type(getFavCode,radioCodeFieldRight);
	}

	/**
	 * This method is to get radio favorite
	 */
	public String getRadioFavorite() {
		slowDown(3);
		return getFieldText(radioCodeFieldLeft);

	}
	
	/**
	 * This method clicks the radio add favorite button 
	 */
	public void clickAddFavoriteRadio() {
		assertTrue("Radio add favorite button is not showing up",isDisplayed(saveFavButton,20));
		clickJS(saveFavButton);
	}

	/**
	 * pass an integer to the lineItem and it will validate if the radio mod in that position is active or not
	 * @param lineItem
	 */
	public void activeModItemsLeft(int lineItem) {
		assertTrue(isDisplayed(activeModLeft, 3));        //class="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"
		int rows =  finds(activeModLeft).size();
		assertTrue(isDisplayedArray(activeModLeft, lineItem));
	}

	/**
	 * pass an integer to the lineItem and it will validate if the radio mod in that position is active or not
	 * @param lineItem
	 */
	public void activeModItemsRight(int lineItem) {
		assertTrue(isDisplayed(activeModLeft, 3));        //class="modulation-row position-relative"id="path-details-radios-0-modulations-2-modulation-row"
		int rows =  finds(activeModLeft).size();
		assertTrue(isDisplayedArray(activeModLeft, lineItem));
	}

	/**
	 * Pass the error text to this method and if there is a radio mod error it will compare the error text and fail if i is not a match.
	 * @param radioErrorText
	 */
	public void errorCorrectionLeftModExceededNegTwenty(String radioErrorText) {
		isDisplayed(radioRadioErrorExceedsNegTwentyModLeft);
		clickJS(radioMaxPowerRight);
		String radioError = getText(radioRadioErrorExceedsNegTwentyModLeft);
		assertEquals(radioErrorText, radioError);
	}

	/**
	 *
	 * @param radioErrorText
	 */
	public void errorCorrectionLeftModExceeded(String radioErrorText) {
		isDisplayed(radioRadioErrorExceedsModLeft);
		String radioError = getText(radioRadioErrorExceedsModLeft);
		assertEquals(radioErrorText, radioError);
	}

	/**
	 * pass the text for the expected error and this method will compare to the actual.  If it matches the will be no error if it does not match it will error.
	 * @param radioErrorText
	 */
	public void errorCorrectionRight(String radioErrorText) {
		isDisplayed(radioCodeFieldLeft,10);
		click(radioCodeFieldLeft);
		isDisplayed(radioRadioErrorRight);
		String radioError = getText(radioRadioErrorRight);
		assertEquals(radioErrorText, radioError);
	}

	public void xClearText(){
		isDisplayed(xClearPoint,5);
		clickJS(radioCodeFieldLeft);
		assertTrue(isDisplayed(xClearPoint,5));
		clickJS(xClearPoint);
		click(radioAutoTransmitPowerControlLeftAddButton1);
	}

	/**
	 * this method will pass radio code text to the radio code field and click away from the field to burr
	 * @param radioCodeText
	 */


	public void setupLeftRadio(String radioCodeText){
		assertTrue(isDisplayed(radioCodeFieldLeft,6));
		type(radioCodeText.trim(), radioCodeFieldLeft);
		clickJS(radioMaxPowerLeft);
		slowDown(4);
	}

	public void blurRadio(){
		isDisplayed(radioMaxPowerLeft,8);
		clickJS(radioMaxPowerLeft);
	}

	/**
	 * this method will pass radio code text to the radio code field and click away from the field to burr
	 * @param radioCodeText
	 */
	public void setupRightRadio(String radioCodeText){
		assertTrue(isDisplayed(radioCodeFieldRight,6));
		type(radioCodeText, radioCodeFieldRight);
		slowDown(5);
		clear(commonLossFieldLeft);
		type("2",commonLossFieldLeft);
		slowDown(4);
	}
	/**
	 * This method is to click the right radio lookup
	 */
	public void clickRightRadioLookup() {
		slowDown(1);
		click(radioLookupRight);
		assertTrue("Radio lookup is not showing up",isDisplayed(radioLookupRadioCode,20));
	}
	/**
	 * This method is to perform search in radio lookup
	 * @param radioCode
	 * @param emissionBandwidth
	 */

	public void performRadioLookupSearch(String radioCode,String emissionBandwidth){
		assertTrue("Cannot find Radio Lookup modal",isDisplayed(radioLookupRadioCode,8));
		assertTrue("clear button is missing in radio lookup",isDisplayed(radioLookupClearButton,8));
		click(radioLookupClearButton);
		slowDown(1);
		type(radioCode,radioLookupRadioCode);
		clear(radioLookupRadioModel);
		clear(radioLookupEmissionBandwidth);
		slowDown(2);
		click(radioLookupSearchButton);
		assertTrue("Radio look up search is not working", isDisplayed(radioCodeListResult,20));

	}
	/**
	 *
	 * @param arrayPosition
	 * @param modVal
	 * @param mbpsVal
	 * @param maxPowerVal
	 */

	public void leftModulationValidation(int arrayPosition, String modVal, String mbpsVal,String maxPowerVal){
		isDisplayed(radioModulationArrayRowsLeft,5);
		String mod = getFieldTextPlural(radioModulationArrayRowsLeft, arrayPosition);
		assertEquals(modVal,mod);
		String mbps = getFieldTextPlural(radioMbpsArrayRowsLeft, arrayPosition);
		assertEquals(mbpsVal,mbps);
		slowDown(2);
		clickJS(radioMaxPowerLeft);
		String max = getFieldTextPlural(radioModulationMaxPowerArrayRowsLeft, arrayPosition);
		slowDown(2);
		assertEquals(maxPowerVal,max);
	}

	public void rightModulationValidation(int arrayPosition, String modVal, String mbpsVal,String maxPowerVal){

		isDisplayed(radioModulationArrayRowsRight,5);
		String mod = getFieldTextPlural(radioModulationArrayRowsRight, arrayPosition);
		assertEquals(modVal,mod);
		String mbps = getFieldTextPlural(radioMbpsArrayRowsRight, arrayPosition);
		assertEquals(mbpsVal,mbps);
		String max = getFieldTextPlural(radioModulationMaxPowerArrayRowsRight, arrayPosition);
		assertEquals(maxPowerVal,max);
	}


}
