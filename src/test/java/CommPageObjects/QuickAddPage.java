package CommPageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotSame;
import static junit.framework.TestCase.assertTrue;


/**
 * @author ns1023
 *
 */
public class QuickAddPage extends BasePage {

	String[] array = {"!","@","$","%","=",";",":","~"};

	//Headings

	//Buttons

	//By addPathButton = By.cssSelector(".btn.bg-green.hover-inverse");
	By addPathButton = By.id("project-summary-quick-add-submit");

	//project-summary-quick-add-submit
	By addPathDetails = By.cssSelector(".btn.bg-blue.hover-inverse");
	By cancelButton = By.cssSelector(".btn.text-red.inverse-default");
	By validationdrawerPathMessage=By.id("path-validations-drawer-path-id-0-messages-error-0");

	By addButton2 = By.xpath("//span[@class='btn bg-green hover-inverse' and contains(text(), 'Add Path')]");
	By quickAddButton = By.id("project-summary-quick-add-open");
	By leaveWithoutSavingConfirmButton = By.cssSelector(".bg-blue.btn.btn-md.hover-inverse.margin-left-1.margin-right-1.heading-font");
	By site2Suggestion = By.id("react-autowhatever-quick-add-site[1]-siteName--item-0");

	//Path DropDown Fields -- Does it contain a list that has options that can be selected
	By optionanBandDropDown = By.id("quick-add-path-band");

	//Drop down options
	//By option =By.className("suggestion-element");
	By option = By.xpath("//*[contains(@class, 'react-autosuggest__suggestions-list')]");

	//Path Entry Fields - Able to use the type method
	///Path 1
	By clearAllValidationDrawer = By.id("path-validations-drawer-clear-all");
	By pathName = By.id("quick-add-path-path-name");
	By latitude = By.id("quick-add-site[0]lat");
	By longitude = By.xpath("//*[contains(@name, 'sites[0]longitude') and contains(@id, 'quick-add-site[0]long')]");
	By asrSite1 = By.id("quick-add-site[0]asr");//Had to correct this had wrong
	By elevation = By.id("quick-add-site[0]elevation");
	By siteField = By.id("quick-add-site[0]-siteName");

	///Path2
	By siteField2 = By.id("quick-add-site[1]-siteName");
	By latitude2 = By.id("quick-add-site[1]lat");
	By longitude2 = By.id("quick-add-site[1]long");
	By asrSite12 = By.id("quick-add-site[1]asr");//Had to correct this had wrong
	By elevation2 = By.id("quick-add-site[1]elevation");

	//Path hovers -- Able to use the hover method

	//Path Data Fields - Element is read only and can use getFieldText method
	By errorMessage = By.className("error-message");
	By errorMessage2 = By.className("error-message");
	By leaveWithoutSavingText = By.cssSelector(".padding-half.center-text");
	By quickAddMatchingOnLatAndLongiWarning = By.id("quick-add-error-list-0-message-0");
	By quickAddSavedSiteName1 = By.xpath("//*[contains(@id, 'project-summary-path-summary-data-pathId-') and contains(@id, '-siteName-site-1')]");
	By copiedPaths = By.xpath("//*[contains(@id, 'project-summary-path-summary-data-pathId-') and contains(@id, '-pathInfo-path-name')]");
	By pathRadio = By.xpath("//span[@title=\"Radio Code: undefined\"]");

	By pathRadioBand = By.id("path-0-site-1-bandwidth");
	By fireFoxHoverCompanyList = By.id("project-summary-project-default-company");
	By companyList = By.xpath("//*[@id=\"project-summary-project-default-company\"]/span/span");
	By companyListVeronaCable = By.xpath(".//*[@id='project-summary-companies-list-Loudoun, County of']");
	By companyList2 = By.id("project-summary-companies-list-VERO BEACH CITY FLORIDA");
	By companyList1 = By.id("project-summary-companies-list-Loudoun, County of");
	
	By companyListVerele = By.xpath(".//*[@id='project-summary-companies-list-VERMONT ELECTRIC COOPERATIVE INC']");
	By companyListVerbch = By.xpath(".//*[@id='project-summary-companies-list-VERO BEACH CITY FLORIDA']");
	//Index List -- Can you used an array to select item

	By optionSiteName =By.id("react-autowhatever-quick-add-site[0]-siteName--item-1");
	//Modal -- Does it pop up over current window
	By addNewPathSlideOutClosed = By.className("quick-add-container ");
	By addNewPathSlideOutClosedFox = By.cssSelector(".quick-add-start.heading-font");

	By doYouWantToLeaveModal = By.className("path-details-footer-modal");

	By asrSite1Error1= By.id("quick-add-site[0]asr-error-message");
	By asrSite1Error2= By.id("quick-add-site[1]asr-error-message");
	By site1ErrorMessage = By.id("quick-add-site[0]-siteName-error-message");
	By site2ErrorMessage = By.id("quick-add-site[1]-siteName-error-message");
	By clickDrawerTriggerI=By.id("path-validations-drawer-trigger");
	By clearWarningQuickAdd = By.id("path-validations-drawer-clear-all");
	public QuickAddPage(WebDriver driver) {
		super(driver);
		visit("");
	}
	public void quickNavigationToProjectForDebugging(String projectUrl){
		visit(projectUrl);
	}

	/**
	 * This function is verify the companies in the default company list of a project
	 * @param co1 - company name 1
	 * @param co2 - company name 2
	 * @param co3 - company name 3
	 */
	public void valCompaniesThree(String co1,String co2,String co3){
		isDisplayed(companyList,10);
		if(chrome.equals("chrome")){
			hoverElement(companyList);
			isDisplayed(companyListVeronaCable ,5);
			String currentCompanies = getText(companyListVeronaCable );
			String currentCompanies1 = getText(companyListVerbch );
			String currentCompanies2 = getText(companyListVerele );

			assertEquals(currentCompanies,co1);
			assertEquals(currentCompanies1,co2);
			assertEquals(currentCompanies2,co3);
		} else {
			hoverElement(fireFoxHoverCompanyList);
			isDisplayed(companyListVeronaCable ,5);
			String currentCompanies = getText(companyListVeronaCable );
			String currentCompanies1 = getText(companyListVerbch );
			String currentCompanies2 = getText(companyListVerele );
			assertEquals(currentCompanies,co1);
			assertEquals(currentCompanies1,co2);
			assertEquals(currentCompanies2,co3);
		}
	}


	public void valCompanies(String pathRadioBandValue){
		isDisplayed(companyList,10);
		String currentCompany1 = getText(companyList1);
		String currentCompany2 = getText(companyList2);
		assertEquals(currentCompany1+ " , "+currentCompany2,pathRadioBandValue);

	}
	public void valCompanies1(String pathRadioBandValue){
		isDisplayed(companyList,10);
		String currentCompany1 = getText(companyList1);
		assertEquals(currentCompany1,pathRadioBandValue);

	}

	public void validatedRadioValues(String pathRadioText, String pathBandwidthText ){
		assertTrue("quick add button is missing",isDisplayed(quickAddButton,85));
		String pathRadioBandValue = getFieldTextTitle(pathRadioBand);
		assertEquals(pathBandwidthText,pathRadioBandValue);

	}

	public void validateCopiedPaths(int i, String pathNameText){
		String copiedPath = getText(copiedPaths);
		assertEquals(copiedPath, pathNameText);
	}

	/**
	 * This method is used to compare text
	 * @param i - index
	 */
	public void compareText(String isNot, String is, int i){
		String trimmed = getTextPlural(quickAddSavedSiteName1,i);
		assertEquals(is,trimmed);
		assertNotSame(isNot,trimmed);
	}
	public void quickAddPathInvalidChar( ){
		assertTrue("quick add button is missing",isDisplayed(quickAddButton,85));
		click(quickAddButton);
		for (String value : array) {
			waitForIsDisplayed(pathName, 6);
			clear(siteField);
			slowDown(1);
			type(value, siteField);
			//waitForFieldText(value,siteField);
			click(pathName);
			assertTrue("error message is missing",isDisplayed(site1ErrorMessage,10));
			String invalCharFieldText1 = getFieldText(siteField);
			assertEquals(value,invalCharFieldText1);
			assertEquals(getText(site1ErrorMessage), "Characters must be A-Z 0-9 ( ) # _ - / & or (space)");
			slowDown(1);
			
		}
	}


	public void quickAddInitPathDataSetup1(String setupSiteName, String BandDropDown, String PathNameText,String LatitudeText, String Longitude, String ElevationText,  String Asr){
		assertTrue("Can't Find quickAddButton",isDisplayed(quickAddButton,80));
		isDisplayedAndClickable(quickAddButton,80);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 200));
		isDisplayedAndClickable(quickAddButton,80);
		click(quickAddButton);
		isDisplayed(pathName,6);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(PathNameText, pathName);
		clear(siteField);
		type(setupSiteName,siteField);
		type(LatitudeText,latitude);
		type(Longitude, longitude);
		type(ElevationText, elevation);
		isDisplayed(addPathButton,6);
	}

	public void quickAddInitPathDataSetup2(String setupSiteName2, String LatitudeText2, String Longitude2, String ElevationText2,  String Asr){
		isDisplayed(asrSite1,10);
		type(setupSiteName2,siteField2);
		type(LatitudeText2,latitude2);
		type(Longitude2, longitude2);
		type(ElevationText2, elevation2);
		isDisplayed(addPathButton,6);
		click(addPathButton);
	}

	public void closeConfirmation(){
		Assert.assertTrue(isDisplayed(doYouWantToLeaveModal,8));
		click(leaveWithoutSavingConfirmButton);
	}

	public void quickAddPathExistingSetup(String setupSiteName, String BandDropDown, String PathNameText,String LatitudeText, String Longitude, String ElevationText, String setupSiteName2, String LatitudeText2, String Longitude2, String ElevationText2){
		if (isDisplayed(doYouWantToLeaveModal,8)==  true){
			closeConfirmation();
		}
		assertTrue("Can't Find quickAddButton",isDisplayed(quickAddButton,80));
		isDisplayedAndClickable(quickAddButton,10);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 100));
		click(quickAddButton);
		isDisplayed(pathName,6);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(PathNameText, pathName);
		clear(siteField);
		type(setupSiteName,siteField);
		isDisplayed(option,20);
		click(option);
		slowDown(1);
		click(pathName);
		type(setupSiteName2,siteField2);
		type(LatitudeText2,latitude2);
		type(Longitude2, longitude2);
		type(ElevationText2, elevation2);
		click(addPathButton);
		isDisplayed(addPathDetails,6);
		isDisplayed(quickAddButton,60);
	}

	public void quickAddPath(String setupSiteName, String BandDropDown, String PathNameText,String LatitudeText, String Longitude, String ElevationText, String setupSiteName2, String LatitudeText2, String Longitude2, String ElevationText2){
		if (isDisplayed(doYouWantToLeaveModal,8)==  true){
			closeConfirmation();
		}
		assertTrue("Can't Find quickAddButton",isDisplayed(quickAddButton,80));
		click(quickAddButton);
		isDisplayed(pathName,6);
		slowDown(1);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(PathNameText, pathName);
		clear(siteField);
		type(setupSiteName,siteField);
		slowDown(1);
		type(LatitudeText,latitude);
		type(Longitude, longitude);
		type(ElevationText, elevation);
		type(setupSiteName2,siteField2);
		type(LatitudeText2,latitude2);
		type(Longitude2, longitude2);
		type(ElevationText2, elevation2);
		click(addPathButton);
		isDisplayed(addPathDetails,6);

	}
	/**
	 * This method is to setup the site information for site 1 of a path
	 * @param setupSiteName
	 * @param bandDropDown
	 * @param pathNameText
	 * @param latitudeText
	 * @param longitudeText
	 * @param elevationText
	 */
	public void quickAddSite1Setup(String setupSiteName, String bandDropDown, String pathNameText,String latitudeText, String longitudeText, String elevationText){
		if (isDisplayed(doYouWantToLeaveModal,8)==  true){
			closeConfirmation();
		}
		assertTrue("Can't Find quickAddButton",isDisplayed(quickAddButton,80));
		isDisplayedAndClickable(quickAddButton,40);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 200));
		isDisplayedAndClickable(quickAddButton,40);
		click(quickAddButton);
		isDisplayed(pathName,6);
		selectFromDropdown(optionanBandDropDown, bandDropDown);
		click(pathName);
		type(pathNameText, pathName);
		clear(siteField);
		type(setupSiteName,siteField);
		click(pathName);
		type(latitudeText,latitude);
		type(longitudeText, longitude);
		type(elevationText, elevation);
		isDisplayed(addPathButton,6);
	}
	/**
	 * This method is type in site1 and site 2 names, band and elevations
	 * @param site1Name
	 * @param site2Name
	 * @param band
	 */
	public void quickAddSite1Site2Names(String site1Name, String site2Name, String band){
		if (isDisplayed(doYouWantToLeaveModal,8)==  true){
			closeConfirmation();
		}
		assertTrue("Can't Find quickAddButton",isDisplayed(quickAddButton,80));
		isDisplayedAndClickable(quickAddButton,40);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 200));
		isDisplayedAndClickable(quickAddButton,40);
		click(quickAddButton);
		isDisplayed(pathName,10);
		selectFromDropdown(optionanBandDropDown, band);
		clear(siteField);
		type(site1Name,siteField);
		type(site2Name,siteField2);

	}
	/**
	 * This method is to setup the site information for site 2 of a path
	 * @param setupSiteName
	 * @param latitudeText
	 * @param longitudeText
	 * @param elevationText
	 */
	public void quickSite2Setup(String setupSiteName,String latitudeText, String longitudeText, String elevationText){
		clear(siteField2);
		type(setupSiteName,siteField2);
		type(latitudeText,latitude2);
		type(longitudeText, longitude2);
		type(elevationText, elevation2);
		assertTrue("addPathButton button is missing",isDisplayed(addPathButton, 200));
		click(pathName);
		click(addPathButton);
		isDisplayed(addPathDetails,6);
		isDisplayed(quickAddButton,60);
	}

	public void quickAddPathExistingSetupNoVal(String setupSiteName, String BandDropDown, String PathNameText,String LatitudeText, String Longitude, String ElevationText,  String Asr){
		assertTrue("Can't Find quickAddButton",isDisplayed(quickAddButton,40));
		isDisplayedAndClickable(quickAddButton,10);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 200));
		isDisplayedAndClickable(quickAddButton,10);
		click(quickAddButton);
		isDisplayed(pathName,6);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(Asr,asrSite1);
		click(pathName);
		waitForFieldToBeNotNull(latitude);
		type(PathNameText, pathName);
		clear(siteField);
		type(setupSiteName,siteField);
		type(LatitudeText,latitude);
		type(Longitude, longitude);
		type(ElevationText, elevation);
		assertTrue("addPathButton button is missing",isDisplayed(addPathButton, 200));
		isDisplayed(addPathButton,6);
		type("BLUE",siteField2);
		isDisplayed(option,11);
		click(option);
		click(pathName);
		click(addPathButton);
		isDisplayed(addPathDetails,6);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 20));
	}

	public void quickAddPath(String sitePartialText, String BandDropDown, String PathNameText,String LatitudeText, String Longitude, String ElevationText,  String Asr){
		String lat;
		String longs;
		String asr;
		String elev;

		assertTrue("Can't Find quickAddButton",isDisplayed(quickAddButton,40));
		isDisplayedAndClickable(quickAddButton,10);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 200));
		isDisplayedAndClickable(quickAddButton,10);
		click(quickAddButton);
		isDisplayed(pathName,6);
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(sitePartialText,siteField);
		isDisplayed(option,20);
		click(option);
		lat = getFieldText(latitude);
		longs = getFieldText(longitude);
		asr = getFieldText(asrSite1);
		slowDown(4);
		elev = getFieldText(elevation);
		assertEquals(lat, LatitudeText);
		assertEquals(elev, ElevationText);
		assertEquals(longs,Longitude);
		assertEquals(asr,Asr);
		isDisplayed(addPathButton,6);
		type("BLUE",siteField2);
		isDisplayed(option,11);
		click(option);
		click(pathName);
		click(addPathButton);
		isDisplayed(addPathDetails,6);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 20));
	}

	public void quickAddPathSimple(String sitePartialText, String BandDropDown, String PathNameText,String LatitudeText, String Longitude, String ElevationText,  String Asr){
		assertTrue("Can't Find quickAddButton",isDisplayed(quickAddButton,40));
		isDisplayedAndClickable(quickAddButton,10);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 200));
		isDisplayedAndClickable(quickAddButton,10);
		click(quickAddButton);
		isDisplayed(pathName,6);
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		clear(siteField);
		type(sitePartialText,siteField);
		assertTrue("option is missing",isDisplayed(option, 200));
		click(option);
		type(ElevationText,elevation);
		type(ElevationText,elevation2);
		type(Asr,asrSite12);
		slowDown(2);
		click(latitude2);
		assertTrue("elevation2 is missing",isDisplayed(elevation2, 200));
		clear(elevation2);
		type(ElevationText,elevation2);
		isDisplayed(addPathButton,6);
		clear(siteField2);
		type("BLUE",siteField2);
		isDisplayed(option,11);
		click(pathName);
		click(addPathButton);
		isDisplayed(addPathDetails,6);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 20));
	}

	public void quickAddPathNoBand(String sitePartialText, String BandDropDown, String PathNameText,String LatitudeText, String Longitude, String ElevationText){
		waitForIsDisplayed(quickAddButton,60);
		isDisplayed(quickAddButton,6);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 200));
		isDisplayedAndClickable(quickAddButton,10);
		click(quickAddButton);
		waitForIsDisplayed(pathName,6);
		type(PathNameText, pathName);
		type(sitePartialText,siteField);
		isDisplayed(option,6);
		hover(option);
		click(option);
		isDisplayed(addPathButton,6);
		type("site2",siteField2);
		type(LatitudeText,latitude2);
		type(Longitude,longitude2);
		type(ElevationText,elevation2);
		click(addPathButton);
		isDisplayed(addPathDetails,6);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 20));
	}

	public void quickAddPathasrSite1InvalidChar(){
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 60));
		click(quickAddButton);
		slowDown(2);
		for (String invalidChars : array) {
			quickAddInvalidCharChecker(invalidChars,asrSite1,asrSite12,pathName);
		}
	}

	public void quickAddPathasrSite1InvalidChar2(){

		for (String invalidChars : array) {
			quickAddInvalidCharChecker2(invalidChars,asrSite1,asrSite12,pathName);
		}
	}

	private void quickAddInvalidCharChecker(String invalidChars,By field1, By field2, By field3){
		String pathError;
		waitForIsDisplayed(field3, 6);
		type(invalidChars, field1);
		click(longitude);
		slowDown(1);
		pathError = getText(asrSite1Error1);
		assertEquals(pathError, "Invalid input.");
		clear(field1);
		clear(field1);
		click(field3);
		clear(field1);
	}

	private void quickAddInvalidCharChecker2(String invalidChars,By field1, By field2, By field3){
		String pathError1;
		waitForIsDisplayed(field3, 6);
		type(invalidChars, field2);
		click(longitude);
		pathError1 = getText(asrSite1Error2);
		assertEquals(pathError1, "Invalid input.");
		clear(field2);
		clear(field2);
		click(field3);
		clear(field2);
	}

	public void asrSite1ErrorChecking(String badEntry1,String badEntry2,String Error1, String Error2){
		quickAddErrorChecking(badEntry1, badEntry2, asrSite1, asrSite12, Error1,  Error2);
	}

	private void quickAddErrorChecking(String invalidEntry1, String invalidEntry2, By element1, By element2, String Error1, String Error2 ){
		if(firefox.equals("firefox")){
			assertTrue(isDisplayed(addNewPathSlideOutClosedFox,10));
		}else{
			slowDown(1);
			assertTrue(isDisplayed(addNewPathSlideOutClosed,20));
			assertTrue(isDisplayedAndClickable(quickAddButton,20));
		}
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 100));
		click(quickAddButton);
		waitForIsDisplayed(pathName, 6);
		slowDown(2);
		type(invalidEntry1, element1);
		type(invalidEntry2, element2);
		assertTrue(isDisplayedAndClickable(pathName,10));
		click(pathName);
		String asrError1 = getText(asrSite1Error1);
		String asrError2 = getText(asrSite1Error2);
		assertEquals(asrError1, Error1);
		assertEquals(asrError2, Error2);
		clear(element2);
		clear(element1);
		click(cancelButton);
		assertTrue(isDisplayed(addPathDetails,10));
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 20));
	}

	public void updateElevation(String feet){
		updateExistingValueGeneric(feet,elevation);
		updateExistingValueGeneric(feet,elevation2);
	}

	private void updateExistingValueGeneric(String textUpdate, By fieldLocator){
		String postChangeFieldValue;
		clear(fieldLocator);
		type(textUpdate,fieldLocator);
		postChangeFieldValue = getFieldText(fieldLocator);
		assertEquals(postChangeFieldValue,textUpdate);
	}

	public void savePath(){
		isDisplayed(addPathButton);
		click(addPathButton);
		isDisplayed(addPathDetails,26);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 20));
	}

	/**
	 * This methods validates sitename error messages
	 * @param error1
	 */
	public void quickAddPathSiteName21Plus(String siteName){
		waitForIsDisplayed(quickAddButton,60);
		isDisplayed(quickAddButton,60);
		click(quickAddButton);
		waitForIsDisplayed(pathName, 6);
		type(siteName, siteField);
		type(siteName, siteField2);
		click(pathName);
		validateSiteErrorMessage("Site Name cannot be longer than 20 characters.","Site Name cannot be longer than 20 characters.");
	}

	/**
	 * This methods validates site 1 and site 2 error messages
	 * @param error1
	 * @param error2
	 */
	public void validateSiteErrorMessage(String error1, String error2) {
		waitForIsDisplayed(pathName, 60);
		click(pathName);
		String siteError1 = getText(site1ErrorMessage);
		String siteError2 = getText(site2ErrorMessage);
		assertEquals(siteError1, error1);
		assertEquals(siteError2, error2);
		click(cancelButton);
		assertTrue(isDisplayed(addPathDetails,10));
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 20));
	}


	public boolean checkForExistingSite(String sitePartialText) {
		waitForIsDisplayed(quickAddButton, 60);
		isDisplayedAndClickable(quickAddButton, 10);
		isDisplayed(quickAddButton, 10);
		slowDown(6);
		click(quickAddButton);
		waitForIsDisplayed(pathName, 6);
		type(sitePartialText, siteField);
		isDisplayed(option, 10);
		return isDisplayed(option, 6);
	}


	public void cancelPathCreation(){
		isDisplayed(cancelButton,10);
		click(cancelButton);
		slowDown(1);
	}

	public void quickAddPathDataSetup(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String sitePartialText2,String LatitudeText2, String Longitude2, String ElevationText2){
		if(isDisplayed(cancelButton,40))
			clickJS(cancelButton);
		waitForIsDisplayed(quickAddButton,10);
		isDisplayedAndClickable(quickAddButton,10);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 200));
		isDisplayedAndClickable(quickAddButton,10);
		click(quickAddButton);
		waitForIsDisplayed(pathName,6);
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(sitePartialText,siteField);
		type(LatitudeText,latitude);
		type(Longitude,longitude);
		type(ElevationText,elevation);
		isDisplayed(addPathButton,8);
		type(sitePartialText2,siteField2);
		type(LatitudeText2,latitude2);
		type(Longitude2,longitude2);
		type(ElevationText2,elevation2);
		click(addPathButton);
		isDisplayed(addPathDetails,6);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 20));
		slowDown(6);
	}
	/**
	 * This method is to set a path with quick add
	 */

	/**
	 * @param PathNameText - path name
	 * @param BandDropDown- band
	 * @param sitePartialText -sitename partial text for getting the suggestion list
	 * @param LatitudeText - latitude
	 * @param Longitude - longitude
	 * @param ElevationText- elevation
	 * @param Asr -asr
	 */
	public void quickAddPathGeneral1(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText){
		waitForIsDisplayed(quickAddButton,70);
		isDisplayedAndClickable(quickAddButton,10);
		isDisplayed(quickAddButton,10);
		clickJS(quickAddButton );
		assertTrue("path name field is not displayed",isDisplayed(pathName,40));
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(sitePartialText,siteField);
		assertTrue("latitude is missing",isDisplayed(latitude, 200));
		type(LatitudeText,latitude);
		type(Longitude,longitude);
		click(elevation);
		assertTrue("elevation is missing",isDisplayed(elevation, 200));
		type(ElevationText,elevation);
		click(elevation2);
		assertTrue("add path button is missing",isDisplayed(addPathButton, 200));
		isDisplayed(addPathButton,6);
		slowDown(1);
		type("BLUE",siteField2);
		slowDown(3);
		clickJS(site2Suggestion);
		click(elevation2);
		click(siteField2);
		isDisplayed(option,6);
		if(isDisplayed(option,10)== false){
			clickJS(siteField2);
			isDisplayed(option,10);
		}
		slowDown(2);
		click(latitude);
		click(longitude);
		click(pathName);
		slowDown(1);
		click(addPathButton);
		if (isDisplayed(quickAddMatchingOnLatAndLongiWarning,20)== true){
			longLatMatchingWarning();
		}
		isDisplayed(addPathDetails,6);
		isDisplayed(quickAddButton,6);
	}

	/**
	 * @param PathNameText - path name
	 * @param BandDropDown- band
	 * @param sitePartialText -sitename partial text for getting the suggestion list
	 * @param LatitudeText - latitude
	 * @param Longitude - longitude
	 * @param ElevationText- elevation
	 * @param Asr -asr
	 */
	public void quickAddPathSameLatLon(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr){
		waitForIsDisplayed(quickAddButton,70);
		isDisplayedAndClickable(quickAddButton,10);
		isDisplayed(quickAddButton,10);
		clickJS(quickAddButton );
		assertTrue("path name field is not displayed",isDisplayed(pathName,30));
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(sitePartialText,siteField);
		slowDown(3);
		type(LatitudeText,latitude);
		type(Longitude,longitude);
		click(elevation);
		assertTrue("elevation is missing",isDisplayed(elevation, 200));
		type(ElevationText,elevation);
		click(elevation2);
		assertTrue("elevation2 is missing",isDisplayed(elevation2, 200));
		type(ElevationText, elevation2);
		isDisplayed(addPathButton,6);
		slowDown(1);
		type("BLUE",siteField2);
		clear(latitude2);
		clear(longitude2);
		type(LatitudeText,latitude2);
		type(Longitude,longitude2);
		click(addPathButton);
		if (isDisplayed(quickAddMatchingOnLatAndLongiWarning,20)== true){
			longLatMatchingWarning();
		}
		isDisplayed(addPathDetails,6);
		isDisplayed(quickAddButton,6);
	}

	private void longLatMatchingWarning(){
		isDisplayed(quickAddMatchingOnLatAndLongiWarning,20);//id="quick-add-error"
		String matchingLatLongText = getText(quickAddMatchingOnLatAndLongiWarning);
		assertEquals(matchingLatLongText,"- Segment Ends values for latitude / longitude on segment number 1 cannot be the same values");
	}


	public void quickAddPathValidateSite(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr){
		String elevationStored;
		waitForIsDisplayed(quickAddButton,70);
		isDisplayedAndClickable(quickAddButton,10);
		isDisplayed(quickAddButton,40);
		click(quickAddButton);
		isDisplayed(pathName,30);
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(sitePartialText,siteField);
		isDisplayed(option,6);
		if(isDisplayed(option,10)== false){
			click(siteField2);
			isDisplayed(option,10);
		}
		click(option);
		click(latitude);
		elevationStored = getFieldText(elevation);
		assertEquals("Is not the stored value",elevationStored, "55");
	}

	public void quickAddPathGeneralNoSave1(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr){
		waitForIsDisplayed(quickAddButton,70);
		isDisplayedAndClickable(quickAddButton,10);
		isDisplayed(quickAddButton,40);
		click(quickAddButton);
		isDisplayed(pathName,30);
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type((sitePartialText+"1"), siteField);
		type(LatitudeText,latitude);
		type(Longitude,longitude);
		type(Asr,asrSite1);
		type(ElevationText,elevation);
		isDisplayed(addPathButton,6);
		type("BLUE",siteField2);
		isDisplayed(option,6);
		if(isDisplayed(option,10)== false){
			click(siteField2);
			isDisplayed(option,10);
		}
		click(option);
		click(latitude);
		clear(elevation);
		type(ElevationText,elevation);
		click(longitude);
		click(pathName);
		slowDown(2);
	}

	public void quickAddPathGeneral2(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,String sitePartialText2,String LatitudeText2, String Longitude2, String ElevationText2,String asrSite11) {
		waitForIsDisplayed(quickAddButton,70);
		isDisplayedAndClickable(quickAddButton,10);
		isDisplayed(quickAddButton,10);
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 200));
		isDisplayedAndClickable(quickAddButton,20);
		click(quickAddButton);
		isDisplayed(siteField, 60);
		assertTrue("Path name field is not displayed",isDisplayed(pathName, 30));
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		click(pathName);
		type(LatitudeText, latitude);
		type(Longitude, longitude);
		isDisplayed(addPathButton, 5);
		clear(siteField);
		slowDown(1);
		clear(siteField);
		slowDown(1);
		type((sitePartialText+"1"), siteField);
		assertTrue("path name is missing",isDisplayed(pathName, 200));
		click(pathName);
		isDisplayed(errorMessage, 6);
		type(ElevationText, elevation);
		clear(siteField2);
		clear(siteField2);
		type((sitePartialText+"2"), siteField2);
		slowDown(3);
		click(pathName);
		type(LatitudeText2, latitude2);
		type(Longitude2, longitude2);
		type(ElevationText2, elevation2);
		click(addPathButton);
		if (isDisplayed(addPathDetails, 10) == false) {
			slowDown(3);
			isDisplayed(addPathDetails, 10);
		} else {
			isDisplayed(addPathDetails,50);
		}
	}

	public void quickAddPathGeneralNoSave2(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr) {
		assertTrue("quick add button is missing",isDisplayed(quickAddButton, 40));
		click(quickAddButton);
		assertTrue("site name is missing",isDisplayed(siteField, 41));
		assertTrue(isDisplayed(pathName, 6));
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type((sitePartialText+"1"), siteField);
		assertTrue("path name is missing",isDisplayed(pathName, 40));
		click(pathName);
		type(LatitudeText, latitude);
		type(Longitude, longitude);
		isDisplayed(addPathButton, 5);
		click(elevation2);
		assertTrue("Elevation is missing",isDisplayed(elevation2, 40));
		type(ElevationText, elevation2);
		click(pathName);
		clear(elevation);
		type(ElevationText, elevation);
		click(elevation2);
		assertTrue("Error message is not displayed",isDisplayed(errorMessage, 6));
		slowDown(3);
		type((sitePartialText+"2"), siteField2);
		click(pathName);
	}


	public void quickAddPathGeneralError2(String PathNameText,String BandDropDown,String sitePartialText,String LatitudeText, String Longitude, String ElevationText,  String Asr) {
		assertTrue(isDisplayed(quickAddButton, 20));
		switchBackToDefaultContent();
		click(quickAddButton);
		assertTrue(isDisplayed(pathName, 40));
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(sitePartialText, siteField);
		click(pathName);
		type(LatitudeText, latitude);
		type(Longitude, longitude);
		isDisplayed(addPathButton, 6);
		type("new", siteField2);
		isDisplayed(errorMessage, 6);
		type(ElevationText, elevation);
		assertTrue("path name is missing",isDisplayed(pathName, 200));
		click(pathName);
		click(addPathButton);
	}

	public void siteSuggestValidation(String PathNameText,String BandDropDown,String sitePartialText, String Longitude, String ElevationText,  String Asr){
		quickAddPathSuggested(PathNameText,BandDropDown,sitePartialText, siteField, Longitude, ElevationText, Asr);
	}

	private void quickAddPathSuggested(String PathNameText,String BandDropDown,String sitePartialText,By suggestedField, String Longitude, String ElevationText,  String Asr){
		waitForIsDisplayed(quickAddButton,60);
		isDisplayed(quickAddButton,6);
		click(quickAddButton);
		waitForIsDisplayed(pathName,6);
		type(PathNameText, pathName);
		selectFromDropdown(optionanBandDropDown, BandDropDown);
		type(sitePartialText,suggestedField);
		isDisplayed(option,6);
		click(option);
		isDisplayed(addPathButton,6);
		type("App",siteField2);
		isDisplayed(option,6);
		click(option);
	}

	public void quickAddPathGeneralNoSave(String pathNameText,String bandDropDown,String sitePartialText,String latitudeText, String longitudeText, String elevationText,  String asr){
		waitForIsDisplayed(quickAddButton,60);
		isDisplayed(quickAddButton,6);
		clickJS(quickAddButton);
		waitForIsDisplayed(pathName,6);
		type(pathNameText, pathName);
		slowDown(1);
		selectFromDropdown(optionanBandDropDown, bandDropDown);
		type(sitePartialText,siteField);
		isDisplayed(option,6);
		click(option);
		isDisplayed(addPathButton,6);
		type("ASH",siteField2);
		isDisplayed(option,6);
		click(option);
		click(siteField);
		slowDown(2);
	}

	public void changeLatLong(String latVal, String longiVal){
		clear(latitude);
		type(latVal, latitude);
		clear(longitude);
		type(longiVal, longitude);
	}

	public String projectFieldError(int i){
		assertTrue("error message is missing",isDisplayed(errorMessage,10));
		return getTextPlural(errorMessage,i);
	}
	public void quickAddPathSite1Site2Save(String PathName, String Band, String Site1Name,String Site1Latitude, String Site1Long, String Elevation1, String Site2Name,String Site2Latitude, String Site2Long, String Elevation2){
		assertTrue("Can't Find quickAddButton",isDisplayed(quickAddButton,40));
		click(quickAddButton);
		waitForIsDisplayed(pathName,6);
		type(PathName,pathName);
		selectFromDropdown(optionanBandDropDown, Band);
		assertTrue("siteField  is missing",isDisplayed(siteField, 200));
		type(Site1Name,siteField);
		type(Site1Latitude,latitude);
		type(Site1Long,longitude);
		type(Elevation1,elevation);
		type(Site2Name,siteField2);
		type(Site2Latitude,latitude2);
		type(Site2Long,longitude2);
		type(Elevation2,elevation2);
		assertTrue("Can't Find Add Path button",isDisplayed(addPathButton,40));
		click(addPathButton);
	}
	/**
	 * This method is to clear up validation drawer if present
	 * @return 
	 */
	public boolean isClearAllPresent(){
		slowDown(1);
		boolean clearall =isDisplayed(clearAllValidationDrawer,70);
		return clearall;
	}
	
	/**
	 * This method is to click clear all in validation drawer
	 */
	public void clickClearAll() {
		assertTrue("Clear All in validation drawer is not present",isDisplayed(clearAllValidationDrawer,60));
		click(clearAllValidationDrawer);
	}
	/**
	 * This method is to clear up validation drawer if present
	 * @return 
	 */
	public boolean isDrawerTriggerPresent(){
		boolean drawerPresent =isDisplayed(clickDrawerTriggerI,90);
		return drawerPresent;
	}

/**
	 * This method is to click the drawer trigger
	 * 
	 */
	public void clickDrawerTrigger() {
		assertTrue("validation drawer trigger i is not present",isDisplayed(clickDrawerTriggerI,90));
		click(clickDrawerTriggerI);
		slowDown(1);
	}
	public void validationdrawerMessage(String Error) {
		String errorMessage;
		assertTrue("Validation error message is missing",isDisplayed(validationdrawerPathMessage,70));
		errorMessage = getText(validationdrawerPathMessage);
		assertEquals(Error, errorMessage);
	}
	/**
	 * This method is to type in asr values and verify existing sitename is not wiped out after applying asr
	 * @param asr1
	 * @param existingSiteName
	 */
	public void quickAddASR1ASR2(String asr1, String existingSiteName) {
		assertTrue("ASR field is missing",isDisplayed(asrSite1,70));
		type(asr1,asrSite1);
		click(elevation);
		assertEquals((getFieldText(siteField)),existingSiteName);
		
	}
	/**
	 * this method is to close warning if present
	 */
	public void closeWarning() {
		slowDown(2);
		if(isDisplayed(clearWarningQuickAdd)) {
			click (clearWarningQuickAdd);
			assertTrue("quick add missing",isDisplayed(quickAddButton,150));
		}
	}
}
