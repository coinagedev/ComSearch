package CommTests;

import CommPageObjects.QuickAddPage;
import CommPageObjects.RadioDataBasePage;
import CommPageObjects.PathSummaryPage;
import CommPageObjects.BasePage;
import CommPageObjects.CreateNewPathPage;
import CommPageObjects.HomePage;
import CommPageObjects.LoginPage;
import CommPageObjects.PathDataBasePage;
import CommPageObjects.PathDetailPage;
import CommPageObjects.PathDetailAntennaPage;
import CommPageObjects.PathDetailsRadioPage;
import org.openqa.selenium.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class PathDetailsRadioTest extends BaseTest {
	private PathDetailAntennaPage pathDetailAnt;
	private QuickAddPage quickAdd;
	private PathSummaryPage pathSummary;
	private CreateNewPathPage createPath;
	private PathDetailPage pathDetail;
	private PathDetailsRadioPage pathDetailRadio;
	private RadioDataBasePage rdatabase;
	private HomePage homepage;
	private PathDataBasePage pathDBpage;
	private LoginPage loginPage;
	private static final String BAND_DESCRIPTION_ELEVEN = "11 GHz (10700-11700 MHz) US";
	private static final String BAND_DESCRIPTION_DOT_NINEFOUR = "0.94 GHz (944-952 MHz) US";
	private static final String BAND_DESCRIPTION_DOT_NINETHREE = "0.93 GHz (932.5-944 MHz) US";
	private static final String ASR1 = "1241006";
	private static final String ASR2 = "1208837";
	private static final String LATITUDE1 = "40 44 54 N";
	private static final String LONGITUDE1 = "73 59 9 W";
	private static final String LATITUDE2 = "40 42 46.8 N";
	private static final String LONGITUDE2 = "74 0 47.3 W";
	private static final String LATITUDE3 = "35 30 42.1 N";
	private static final String LONGITUDE3 = "112 39 26.2 W";
	private static final String LATITUDE4 = "35 22 25 N";
	private static final String LONGITUDE4 = "112 30 20 W";
	private static final String ELEVATION1 = "14";
	private static final String ELEVATION2 = "6.62";
	private static final String RADIO_CODE = "M09002";
	private static final String RADIO_CODE1 = "M06101";
	private static final String RADIO_CODE2 = "M1198";
	private static final String RADIO_CODE3 = "M11988";
	private static final String ANTENNA_CODE1 = "77100A";
	private static final String LEGACYRADIO_CODE1 = "TENL01";
	private By commonLossErrorMsgLeft = By.id("path-details-losses-0-common-loss-error-message");

	@Before
	public void Setup() {
		pathDetailAnt = new PathDetailAntennaPage(driver);
		quickAdd = new QuickAddPage(driver);
		pathSummary = new PathSummaryPage(driver);
		createPath = new CreateNewPathPage(driver);
		pathDetail = new PathDetailPage(driver);
		pathDetailRadio = new PathDetailsRadioPage(driver);
		homepage = new HomePage(driver);
		pathDBpage = new PathDataBasePage(driver);
		rdatabase = new RadioDataBasePage(driver);
		loginPage = new LoginPage(driver);
		loginPage.selectUserAndLogin("admin");
	}

	Random rndNum = new Random();
	int randomNumber = rndNum.nextInt(100000);

	@Rule
	public RetryTest.Retry retry = new RetryTest.Retry(1);

	/**
	 * COM-486,COM-490
	 */
	@Test
	public void pathDetailRadio_shouldCreateRadio_whenEnteringValidRadioData() {
		createPath.createBrandNewProjectPath("Add Radio" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", LATITUDE3, LONGITUDE3, "66",
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", LATITUDE4, LONGITUDE4, "160.86");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);

		pathDetailRadio.leftModulationValidation(0, "256 QAM", "262", "20");
		pathDetailRadio.leftModulationValidation(1, "128 QAM", "229", "21");
		pathDetailRadio.leftModulationValidation(2, "64 QAM", "196", "21");
		pathDetailRadio.leftModulationValidation(3, "32 QAM", "163", "23");
		pathDetailRadio.leftModulationValidation(4, "16 QAM", "130", "24");
		pathDetailRadio.leftModulationValidation(5, "QPSK", "65", "26");

		pathDetailRadio.rightModulationValidation(0, "256 QAM", "262", "20");
		pathDetailRadio.rightModulationValidation(1, "128 QAM", "229", "21");
		pathDetailRadio.rightModulationValidation(2, "64 QAM", "196", "21");
		pathDetailRadio.rightModulationValidation(3, "32 QAM", "163", "23");
		pathDetailRadio.rightModulationValidation(4, "16 QAM", "130", "24");
		pathDetailRadio.rightModulationValidation(5, "QPSK", "65", "26");
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailAnt.clickSaveDetails();

	}

	/**
	 * COM-490
	 */
	@Test
	public void pathDetailRadio_shouldError_whenEnteringLessThanSixCharsLeft() {
		createPath.createBrandNewProjectPath("6 characters" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", "KBY45", LATITUDE3, LONGITUDE3, "66",
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", "KA20003", LATITUDE4, LONGITUDE4, "160.86");
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE2);
		pathDetailRadio.addLossLeft("22", "33", "44");
		pathDetailRadio.errorCorrectionLeft("No match found for Radio Code.");
	}

	@Test
	public void pathDetailRadio_shouldError_whenEnteringLessThanSixCharsRight() {
		createPath.createBrandNewProjectPath("6 characters" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupRightRadio(RADIO_CODE2);
		pathDetailRadio.addLossRight("22", "33", "44");
		pathDetailRadio.errorCorrectionRight("No match found for Radio Code.");
	}

	/**
	 * COM-490
	 * 
	 */
	@Test
	public void pathDetailRadio_GreatestPowerOfActiveModulationsWillUpdateToMaxPower_whenChangingModulation() {
		createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		pathDetailRadio.maxPowerDefault("26");
		pathDetailRadio.changeGreatestPower("25");
		String maxPower = pathDetailRadio.findMaxPower();
		assertEquals(maxPower, "25");
		pathDetailRadio.leftModulationValidation(1, "128 QAM", "229", "21");
		pathDetailRadio.leftModulationValidation(3, "32 QAM", "163", "23");
		pathDetailRadio.leftModulationValidation(5, "QPSK", "65", "25");

		pathDetailRadio.changeGreatestPower("24");

		maxPower = pathDetailRadio.findMaxPower();
		assertEquals(maxPower, "24");
		pathDetailRadio.leftModulationValidation(4, "16 QAM", "130", "24");
		pathDetailRadio.leftModulationValidation(2, "64 QAM", "196", "21");
		pathDetailRadio.leftModulationValidation(1, "128 QAM", "229", "21");
		pathDetailRadio.leftModulationValidation(3, "32 QAM", "163", "23");
		pathDetailRadio.leftModulationValidation(5, "QPSK", "65", "24");
		pathDetailRadio.leftModulationValidation(0, "256 QAM", "262", "20");

		pathDetailRadio.changeGreatestPower("22");
		maxPower = pathDetailRadio.findMaxPower();
		assertEquals(maxPower, "22");
		pathDetailRadio.leftModulationValidation(4, "16 QAM", "130", "22");
		pathDetailRadio.leftModulationValidation(2, "64 QAM", "196", "21");
		pathDetailRadio.leftModulationValidation(1, "128 QAM", "229", "21");
		pathDetailRadio.leftModulationValidation(3, "32 QAM", "163", "22");
		pathDetailRadio.leftModulationValidation(5, "QPSK", "65", "22");
		pathDetailRadio.leftModulationValidation(0, "256 QAM", "262", "20");

		pathDetailRadio.changeGreatestPower("26");
		pathDetailRadio.errorCorrectionLeftModExceeded("Cannot exceed enabled modulations' greatest power: 22dBm");
		pathDetailRadio.changeGreatestPower("22");
		pathDetailAnt.clickSaveDetails();
	}

	/**
	 * COM-490
	 * 
	 */

	@Test
	public void pathDetailRadio_EngineeringReferencePlacedOnModulation1_whenEngRefJumpToModulation2() {
		createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		for (int i = 0; i < 4; i++) {
			pathDetailRadio.deactivateModulationNew(2);
		}
		pathDetailRadio.checkRefPosition1();
		pathDetailRadio.deactivateModulationNew(0);
		pathDetailRadio.checkRefPosition2();
		pathDetailAnt.clickSaveDetails();
	}

	/*
	 * COM-490
	 *
	 **/
	@Test
	public void pathDetailRadio_DisabledModEnabledNewMaxWillBeTheNewllyEnabled_whenDisabledModWithHigherMaxPowerThanCurrMax() {
		createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToUs();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		pathDetailRadio.deactivateModulationNew(5);
		pathDetailRadio.deactivateModulationNew(4);
		pathDetailRadio.validateCurrentMaxPowerLeft("23");
		pathDetailRadio.resetModulation();

		pathDetailRadio.validateCurrentMaxPowerLeft("26");
	}

	/**
	 * COM-490
	 */
	@Test
	public void pathDetailRadio_UserWillRecieveErrorMessageMaxPowerCannotBeLessThanNegTwenty_whenMaxPowerNegTwenty() {
		createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		pathDetailRadio.changeGreatestPower("27");
		pathDetailRadio
				.errorCorrectionLeftModExceededNegTwenty("Cannot exceed enabled modulations' greatest power: 26dBm");
	}

	/**
	 * COM-490
	 */
	@Test
	public void pathDetailRadio_LeftRadioWillBeCopiedOverRightRadio_whenRightRadioDiffThanLeftAndTheCopyRadioIsTriggered() {
		createPath.createBrandNewProjectPath("Copy Radio" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		pathDetailRadio.deactivateModulationNew(0);
		pathDetailRadio.deactivateModulationNew(1);
		pathDetailRadio.deactivateModulationNew(2);
		pathDetailRadio.copyRadio();
		pathDetailAnt.clickBlurAntennaCode();
		pathDetailRadio.rightModulationValidation(1, "128 QAM", "229", "21");
		pathDetailRadio.rightModulationValidation(3, "32 QAM", "163", "23");
		pathDetailRadio.rightModulationValidation(5, "QPSK", "65", "26");
	}

	/**
	 * COM-491 *
	 * 
	 */

	@Test
	public void pathDetailRadio_ATPCModalWillOpen_whenClickingATPCButton() {
		createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		pathDetailRadio.openATPC();
	}

	/**
	 * COM-491
	 */
	@Test
	public void pathDetailRadio_RadioSectionWillBeDisabled_whenPassiveRepeaterModalOpen() {
		createPath.createBrandNewProjectPath("Copy Radio" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetail.openPassiveRepeaterAndValidateFieldsAndButtons();
		pathDetailRadio.isRadioSectionAvailable();
	}

	/**
	 * COM-491
	 */

	@Test
	public void pathDetailRadio_ATPCModal_whenATPCIsEnabled() {
		createPath.createBrandNewProjectPath("Copy Radio" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		pathDetailRadio.openATPC();
	}

	/**
	 * Given Radio Code X06356 is selected AND the first modulation is enabled AND
	 * the radio's "minAtpcTrigger" = -64.5 AND the ATPC modal is open When a
	 * Trigger Level -66.4 is entered, Then a graceful error is displayed indicating
	 * that the Trigger Level "Cannot be less than -64.5".
	 */
	@Test
	public void pathDetailRadio_VerifyATPCButtons_ATPCModal() {
		createPath.createBrandNewProjectPath("5MinONAndRampOFF" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		pathDetailRadio.openATPC();
	}

	@Test
	public void pathDetailRadio_VerifyATPCButton_ATPCModal() {
		createPath.createBrandNewProjectPath("5MinONAndRampOFF" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("5 Min OFF", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Ramp ON", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		pathDetailRadio.openATPC();
	}

	@Test
	public void pathDetailRadio_ModulationsShouldBeCopied_whenDerivedFromFavorites() {
		createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio("");
		for (int i = 0; i < 3; i++) {
			pathDetailRadio.deactivateModulationNew(0);
		}
		pathDetailRadio.saveFavRadioCodeEnterNewCode();
		pathDetailRadio.activeModItemsLeft(0);
		pathDetailRadio.activeModItemsLeft(1);
		pathDetailRadio.activeModItemsLeft(2);

		pathDetailRadio.activeModItemsRight(0);
		pathDetailRadio.activeModItemsRight(1);
		pathDetailRadio.activeModItemsRight(2);
	}

	@Test // COM-646
	public void pathDetailRadio_LossValuesIncluded_whenLossIsEntered() {
		createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio("27DL01");
		pathDetailRadio.setupRightRadio("27DL01");
		pathDetailRadio.addLossLeft("11", "13", "14");
		pathDetailRadio.addLossRight("11", "13", "14");
		pathDetailAnt.clickSaveDetails();
		pathDetail.closeWarning();
		pathDetail.clickReturnButtonInPathDetailsPage();
		pathDetail.openPathDetailViaDetails();
		pathDetailRadio.validateLossLeft("11", "13", "14");
		pathDetailRadio.validateLossRight("11", "13", "14");
	}

	/**
	 * COM-533
	 */
	@Test
	public void pathDetailRadio_LossValuesFieldValidate_whenIncorrectInputIsEnterered() {
		createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		pathDetailRadio.addLossLeft("wwww", "www", "www");
		pathDetailRadio.addLossRight("www", "www", "www");
		pathDetailRadio.click(commonLossErrorMsgLeft);
		pathDetailRadio.lossErrorLeft("Must be numerical value.", "Must be numerical value.",
				"Must be numerical value.");
		pathDetailRadio.lossErrorRight("Must be numerical value.", "Must be numerical value.",
				"Must be numerical value.");
		pathDetailRadio.clearAllLossFields();
		pathDetailRadio.addLossLeft("-77", "-88", "-99");
		pathDetailRadio.addLossRight("-44", "-11", "-55");
		pathDetailRadio.click(commonLossErrorMsgLeft);
		pathDetailRadio.lossErrorLeft("Cannot be less than 0(dB).", "Cannot be less than 0(dB).",
				"Cannot be less than 0(dB).");
		pathDetailRadio.lossErrorRight("Cannot be less than 0(dB).", "Cannot be less than 0(dB).",
				"Cannot be less than 0(dB).");
		pathDetailRadio.clearAllLossFields();
		pathDetailRadio.addLossLeft("4444", "4444", "4444");
		pathDetailRadio.addLossRight("4444", "4444", "4444");
		pathDetailRadio.click(commonLossErrorMsgLeft);
		pathDetailRadio.lossErrorLeft("Cannot be greater than 999.9(dB).", "Cannot be greater than 999.9(dB).",
				"Cannot be greater than 999.9(dB).");
		pathDetailRadio.lossErrorRight("Cannot be greater than 999.9(dB).", "Cannot be greater than 999.9(dB).",
				"Cannot be greater than 999.9(dB).");
	}

	/**
	 * COM-534 (UI AUTO) UI/UX: Radio Look up
	 */
	@Test // COM-646
	public void pathDetailRadio_RadioLookUp_hoverAdaptiveModulation() {
		createPath.createBrandNewProjectPath("ChangingModulation" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailRadio.setupRightRadio(RADIO_CODE3);
		pathDetailRadio.addLossLeft("22", "33", "44");
		pathDetailRadio.addLossRight("22", "33", "44");
		pathDetailRadio.slowDown(2);
		pathDetailAnt.clickSaveDetails();
		pathDetail.clickReturnButtonInPathDetailsPage();
		pathDetail.openPathDetailViaDetails();
		pathDetailRadio.hoverAndValidate();
	}

	/**
	 * COM-656
	 * 
	 */
	@Test
	public void pathDetailRadio_NoErrorShouldAppear_whenDerivedFromFavorites() {
		createPath.createBrandNewProjectPath("FAVCreatedMods" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.changeToSi();
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_ELEVEN);
		pathDetail.addPathViaPathDetailBasicSetup2("Add Radio2", ASR2, LATITUDE2, LONGITUDE2, ELEVATION2);
		pathDetailRadio.setupLeftRadio(RADIO_CODE3);
		pathDetailAnt.clickBlurAntennaCode();
		for (int i = 0; i < 4; i++) {
			pathDetailRadio.deactivateModulationNew(2);
		}
		pathDetailRadio.saveFavRadioCodeEnterSameFavCode();
		pathDetailRadio.activeModItemsLeft(0);
		pathDetailRadio.activeModItemsLeft(1);
		pathDetailRadio.activeModItemsRight(0);
		pathDetailRadio.activeModItemsRight(1);
		pathDetailAnt.enterAntennaCodeAndBlur(ANTENNA_CODE1, "12");
		pathDetailAnt.clickSaveDetails();

	}

	/**
	 * AUTO UI: Radio Details - display radio favorites LEGO-773
	 */
	@Test
	public void pathDetailRadio_addFavorite_VerifyFavorite() {
		createPath.createBrandNewProjectPath("add radio favorite" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.openPathDetailForAddingPath();
		pathDetail.addPathViaPathDetailBasicSetup1("Add Radio1", ASR1, LATITUDE1, LONGITUDE1, ELEVATION1,
				BAND_DESCRIPTION_DOT_NINETHREE);
		pathDetail.setSite1Radio(RADIO_CODE);
		pathDetailRadio.clickAddFavoriteRadio();
		String radioCodeFavorited = pathDetailRadio.getRadioFavorite();
		pathDetail.clickReturnButtonInPathDetailsPageWithoutSave();
		homepage.clickHomeMenuLink();
		rdatabase.accessRadioDataBase();
		rdatabase.searchRadioDatabase(RADIO_CODE, "", "", "", "", "");
		rdatabase.clickSearchResultsFromRadioDatabaseSearch();
		rdatabase.verifyRadioFavorite(radioCodeFavorited);
	}

	/**
	 * LEGO-7387 : QA AUTO UI : UI: Path Details - add legacy radio code to the left
	 * of Radio Favorite icon. LEGO-7117
	 */
	@Test
	public void pathDetailRadio_radioFavorite_VerifyLegacyRadioCode() {
		String siteName = "MITCHELL";
		createPath.createBrandNewProjectPath("add radio favorite" + randomNumber, "This is the Default");
		createPath.contactLookup("VERONA", "VERONA CABLEVISION", "", 0);
		pathSummary.clickImportPathFromHamburger();
		pathSummary.clickImportFromPathDatabase();
		pathDBpage.searchPathDatabaseBasedOnRadioImportFromDatabase(RADIO_CODE1, siteName);
		pathDBpage.clickPathDatabaseSearchResult();
		pathSummary.clickPage();
		pathDetail.openPathDetailViaDetails();
		pathDetail.verifyLegacyRadioCode(LEGACYRADIO_CODE1);
	}

	@After
	public void tearDown() {
		BasePage.quit();
	}
}
