package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateNewPathPage extends BasePage {

	//Buttons
	//By pathRadioButton = By.xpath("//span[text()='Path']");
	By pathRadioButton = By.id("newProjectForm-projectType-PATH-label-bottom");

	//newProjectForm-projectType-PATH-label-top

	By companyLookUp = By.id("new-project-default-contact-lookup-trigger");
	By pathDetailCompanyLookUp1 = By.id("path-details-site-0-contact-lookup-trigger");
	By pathDetailCompanyLookUp2 = By.id("path-details-site-1-contact-lookup-trigger");
	By authPOCSuccess = By.id("api-auth-success-poc");
	//path-details-company-lookup-trigger
	By companySearchButton = By.id("contact-lookup-submit");

	//Modal
	By companyModal = By.id("contact-lookup-contact-code");
	By newProject = By.id("new-project-modal-trigger");


	//Fields
	By contactCodeField = By.id("contact-lookup-contact-code");
	By contactNameField = By.id("contact-lookup-contact-name");
	By defaultContactField = By.id("new-project-default-contact");
	//By searchResultArray = By.cssSelector(".react-grid-Row.react-grid-Row--even");
	//react-grid-Cell
	By searchResultArray = By.xpath("//*[contains(@id, 'contact-lookup-modal-table-data-contactCode-')]");

	By searchResultArrayPlural = By.xpath("//*[contains(@id, 'contact-lookup-modal-table-data-contactCode-') and contains(@id, '-contactCode')]");

	//By searchResultArray = By.cssSelector(".react-grid-Cell");

	By companyNameFieldInLookup = By.id("contact-lookup-company-name");
	By clearButtonContactLookup = By.id("clearValues");
	By createButton = By.id("newProjectForm-submit");
	By newProjectField = By.id("newProjectForm-projectName");
	By defaultContact = By.id("new-project-default-contact");
	By projectRequiredValidationMsg = By.className("error-message");
	By filterField = By.id("project-summary-filter-input");
	By projectTitle = By.id("project-summary-project-name-label");
	By projectTitleName = By.id("project-summary-project-name");
	By totalPathAmount = By.id("project-summary-project-total-paths");
	By defaultCompany = By.id("project-summary-project-default-company");
	By errorMessage = By.id("newProjectForm-projectName-error-message");
	By returnHome = By.id("header-homeLink");
	By pathDetailDefaultCompanyField = By.id("path-details-site-0-company-name");
	By projectManagementLink = By.id("home-cta-project-management");
	By projectList = By.id("header-menu-projects-list");
	By projectTypeEngineering = By.id("new-project--project-type-1-label-bottom");
	By projectTypeRenewal = By.id("new-project--project-type-3-label-bottom");
	By projectTypeExternalPCN = By.id("new-project--project-type-2-label-bottom");
	By contactNoresult =By.cssSelector(".no-results-message");
	By usUnit = By.id("new-project--unit-type-US-label-bottom");
	By siUnit = By.id("new-project--unit-type-SI-label-bottom");
	
	//Contact lookup view modal
	By viewConatctDetailsFromContactLookup = By.xpath("//*[contains(@id, 'contact-lookup-modal-table-data-contactCode-') and contains(@id, '-contactId-trigger')]");
	By sendCorrespondence = By.xpath("//*[contains(@id, 'contact-lookup-modal-table-data-contactCode-') and contains(@id, '-contactId-contact-sendCorrespondence')]");
	By contctCodeViewContactDetais =  By.id("contact-lookup-modal-table-data-contactCode-P9026-contactId-contact-contactCode");
	By contctNameViewContactDetais =  By.id("contact-lookup-modal-table-data-contactCode-P9026-contactId-contact-contactName");
	By contctEmailViewContactDetais=  By.id("contact-lookup-modal-table-data-contactCode-P9026-contactId-contact-email-link");
	By contctPRotectionAgentViewContactDetais =  By.id("contact-lookup-modal-table-data-contactCode-P9026-contactId-contact-protectionAgents");
	By contctOfficePhoneViewContactDetais =  By.xpath("//*[contains(@id, 'contact-lookup-modal-table-data-contactCode-') and contains(@id, '-contactId-contact-0-Office')]");
	By contctCompanyViewContactDetais =  By.id("contact-lookup-modal-table-data-contactCode-P9026-contactId-18972-companyName");
	By contctdbaViewContactDetais =  By.id("contact-lookup-modal-table-data-contactCode-P9026-contactId-18972-dbaName");

			

	//Project Landing
	By projectTitile = By.tagName("span");

	public CreateNewPathPage(WebDriver driver){
		//Used by class constructors to invoke constructors of its parent class.
		super(driver);
	    visit("/");
	}

	/**
	 * This method allows you to create a new project and checks for company lookup
	 * @param projectName - Name of the project
	 * @param defaultLicensee - Company Name
	 */
	/**
	 * LEGO-3149 - QA UI auto: Update Project Create modal to show project type & adjust based on permissions LEGO-3014 
	 * @param projectName
	 * @param defaultLicensee
	 */
	public void createBrandNewProjectPath(String projectName, String defaultLicensee){
		assertTrue("can't find the home page after login",isDisplayed(projectManagementLink,130));
		clickJS(projectManagementLink);
		assertTrue("can't find the Project Management page ",isDisplayed(newProject,60));
		clickJS(newProject);
		assertTrue("can't find the Create button in Create New Project window",
				isDisplayed(createButton));
		type(projectName, newProjectField);
		assertTrue("US units radio button",isDisplayed(usUnit,50));
		assertTrue("US units radio button",isDisplayed(siUnit,50));
		click (usUnit);
		assertTrue("can't find the Default contact button",isDisplayed(defaultContact,90));
		assertTrue("can't find the contact lookup button",isDisplayed(companyLookUp, 30));
		assertTrue("Project type - Engineering is missing in create new project window",isDisplayed(projectTypeEngineering, 30));
		click(companyLookUp);
	}
	/**
	 * this method is to create new project from project management page
	 * @param projectName
	 * @param defaultLicensee
	 */
	public void createProjectFromProjectManagmentPage(String projectName, String defaultLicensee){
		assertTrue("can't find the Project Management page ",isDisplayed(newProject,60));
		click(newProject);
		assertTrue("can't find the Create button in Create New Project window",
				isDisplayed(createButton));
		type(projectName, newProjectField);
		assertTrue("US units radio button",isDisplayed(usUnit,50));
		assertTrue("US units radio button",isDisplayed(siUnit,50));
		click (usUnit);
		assertTrue("can't find the Default contact button",isDisplayed(defaultContact,90));
		assertTrue("can't find the contact lookup button",isDisplayed(companyLookUp, 30));
		assertTrue("Project type - Engineering is missing in create new project window",isDisplayed(projectTypeEngineering, 30));
		click(companyLookUp);
	}
	/**
	 * LEGO-3149 - QA UI auto: Update Project Create modal to show project type & adjust based on permissions LEGO-3014 
	 * @param projectName
	 * @param defaultLicensee
	 */
	public void createBrandNewProjectPathAsDBUSer(String projectName, String defaultLicensee){
		assertTrue("can't find the home page after login",isDisplayed(projectManagementLink,130));
		clickJS(projectManagementLink);
		assertTrue("can't find the Project Management page ",isDisplayed(newProject,150));
		clickJS(newProject);
		assertTrue("can't find the Create button in Create New Project window",
				isDisplayed(createButton,40));
		type(projectName, newProjectField);
		assertTrue("US units radio button",isDisplayed(usUnit,50));
		assertTrue("US units radio button",isDisplayed(siUnit,50));
		click (usUnit);
		slowDown(2);
		assertTrue("can't find the Default contact button",isDisplayed(defaultContact,50));
		assertTrue("can't find the contact lookup button",isDisplayed(companyLookUp, 30));
		assertTrue("Project type - ExternalPCN is missing in create new project window",isDisplayed(projectTypeExternalPCN, 30));
		click(companyLookUp);
	}
	/**
	 * This method is to access project management page 
	 */
	public void accessProjectManagement() {
		assertTrue("can't find the project management page after login",isDisplayed(projectManagementLink,130));
		clickJS(projectManagementLink);
		assertTrue("can't find the Project Management page ",isDisplayed(newProject,50));
	}

	/**
	 * This method allows you to create a new project
	 * @param projectName - Name of the project
	 * @param defaultLicensee - Company Name
	 */
	public void createProjectPath(String projectName, String defaultLicensee){
		assertTrue("can't find the home page after login ",isDisplayed(projectManagementLink,120));
		clickJS(projectManagementLink);
		assertTrue("can't find the Project Management page ",isDisplayed(newProject,20));
		clickJS(newProject);
		assertTrue("can't find the Create button in Create New Project window",
				isDisplayed(createButton));
		type(projectName, newProjectField);
		slowDown(2);
		click(companyLookUp);
	}


	/**
	 * This method tries to create a path without a company
	 * @param projectName
	 * @param defaultLicensee
	 */
	public void createBrandNewProjectPathNoCompany(String projectName, String defaultLicensee){
		assertTrue("can't find the home page after login ",isDisplayed(projectManagementLink,110));
		clickJS(projectManagementLink);
		assertTrue("can't find the Project Management page ",isDisplayed(newProject,20));
		clickJS(newProject);
		assertTrue("can't find the Create button in Create New Project window",
				isDisplayed(createButton));
		type(projectName, newProjectField);
		isDisplayed(defaultContact,20);
		click(createButton);
		slowDown(2);
		assertTrue("No FILTER FIELD",isDisplayed(filterField,20));
	}

	/**
	 * This method creates a project with given project and company name
	 * @param projectName - Name of the project
	 * @param defaultLicensee - Company Name
	 */
	public void enterProjectForCompany(String projectName, String defaultLicensee){
		assertTrue("can't find the home page after login ",isDisplayed(projectManagementLink,120));
		clickJS(projectManagementLink);
		assertTrue("can't find the Project Management page ",isDisplayed(newProject,20));
		clickJS(newProject);
		assertTrue("can't find the Create button in Create New Project window",
				isDisplayed(createButton));
		type(projectName, newProjectField);
		isDisplayed(defaultContact,20);
		isDisplayed(companyLookUp, 10);
		clickJS(companyLookUp);
	}

	/**
	 * This method fills out company information
	 * 
	 * @param coCodeText - company code
	 * @param coNameText - manufacturer name
	 * @param coContactText - contact name
	 * @param company - company
	 */
	public void contactLookup(String coCodeText, String coContactText,String coNameText, Integer company) {
		String a;
		contactLookupSearch( coCodeText,  coContactText, coNameText,  company);
		click(searchResultArray);
		slowDown(1);
		a = getFieldText(defaultContactField);
		click(createButton);
		isDisplayed(filterField, 30);

	}
	/**
	 * This method verifies contact details popup from  contact lookup window
	 * 
	 * @param coCodeText - company code
	 * @param coNameText - manufacturer name
	 * @param coContactText - contact name
	 * @param company - company
	 */
	public void contactLookupSearch(String coCodeText, String coContactText,String coNameText, Integer company) {
		contactLookupOnlySearch( coCodeText,  coContactText, coNameText,  company) ;
		isDisplayed(searchResultArray,60);
		slowDown(3);

	}
	/**
	 * This method verifies contact lookup search from contact lookup window
	 * 
	 * @param coCodeText - company code
	 * @param coNameText - manufacturer name
	 * @param coContactText - contact name
	 * @param company - company
	 */
	public void contactLookupOnlySearch(String coCodeText, String coContactText,String coNameText, Integer company) {
		assertTrue("contact Lookup is not displayed",isDisplayed(contactCodeField,90));
		assertTrue("Can't find Name Field",isDisplayed(contactNameField,30));
		assertTrue("Can't find Name Field",isDisplayed(companyNameFieldInLookup,30));
		assertTrue("Can't find Name Field",isDisplayed(companyNameFieldInLookup,30));
		assertTrue("clear button is missing",isDisplayed(clearButtonContactLookup,30));
		type(coCodeText, contactCodeField);
		type(coNameText, contactNameField);
		type(coContactText, companyNameFieldInLookup);
		assertTrue("Can't find Search Button",isDisplayed(companySearchButton,30));
		click(companySearchButton);
		slowDown(2);
	}
	/**
	 * This method is to click the view details for contact results from contact lookup
	 * @param contactCode
	 * @param contactName
	 * @param Email
	 * @param dba
	 * @param Company
	 * @param protection
	 */
			
	public void clickViewContactDetailsFromContactLookup(String contactCode, String contactName,String Email, String dba, String Company,String protection) {
		assertTrue("search results in contact lookup is missing",isDisplayed(searchResultArray,60));
		click(viewConatctDetailsFromContactLookup);
		assertTrue("view details from contact lookup is missing",isDisplayed(sendCorrespondence,60));
		assertTrue("view details from contact lookup is missing",isDisplayed(sendCorrespondence,60));
		assertEquals(contactCode,getText(contctCodeViewContactDetais));
		assertEquals(contactName,getText(contctNameViewContactDetais));
		assertEquals(Email,getText(contctEmailViewContactDetais));
		assertEquals(protection,getText(contctPRotectionAgentViewContactDetais));
		assertEquals(Company,getText(contctCompanyViewContactDetais));
		assertEquals(dba,getText(contctdbaViewContactDetais));


	}
	

	/**
	 * This method checks for create button and creates new project
	 */
	public void simpleClickCreateNewProjectButton(){
		assertTrue("can't find the Create button in Create New Project window",isDisplayed(createButton,80));
		click(createButton);
		if(isDisplayed(createButton)) {
			click(createButton);
			slowDown(2);

		}
		isDisplayed(filterField, 30);
	}

	public void contactLookuprFromDetails(String coCodeText,String coNameText, String coContactText) {
		String a;
		assertTrue("Can't find LookUp",isDisplayed(pathDetailCompanyLookUp1,10));
		click(pathDetailCompanyLookUp1);
		slowDown(2);
		assertTrue("Can't find Code Field",isDisplayed(contactCodeField,10));
		assertTrue("Can't find Name Field",isDisplayed(contactNameField,10));
		assertTrue("Can't find Name Field",isDisplayed(companyNameFieldInLookup));
		clear(contactCodeField);
		clear(contactNameField);
		type(coCodeText, contactCodeField);
		type(coNameText, contactNameField);
		type(coContactText, companyNameFieldInLookup);
		assertTrue("Can't find Search Button",isDisplayed(companySearchButton,10));
		click(companySearchButton );
		slowDown(2);
		assertTrue("Can't find Results",isDisplayed(searchResultArray,10));
		slowDown(2);


		//so you get the max number of rows
		int rows = getRows(searchResultArrayPlural);
		//Then loop through and do your check
		for (int i = 0; i < rows; i++) {
			//try and catch would be inside the for loop
			try
			{
				a = getTextPlural(searchResultArrayPlural,i);//path-details-site-0-company-name
				if ( !coNameText.isEmpty() ){
					assertEquals(a, coNameText);
				}
				
				click(searchResultArrayPlural,i);
				break;
			}
			catch (java.lang.AssertionError failure)
			{
				//in the catch you would check to see if there are any more rows left.
				if (i >= rows) {
					throw failure;
				}
			}

		}

	}

	public void contactLookupErrorChecking(String coCodeText,String coNameText, String coContactText, Integer company) {
		assertTrue("Can't find Code Field",isDisplayed(contactCodeField,10));
		assertTrue("Can't find Name Field",isDisplayed(contactNameField,10));
		assertTrue("Can't find Name Field",isDisplayed(companyNameFieldInLookup));
		type(coCodeText, contactCodeField);
		type(coNameText, contactNameField);
		type(coContactText, companyNameFieldInLookup);
		assertTrue("Can't find Search Button",isDisplayed(companySearchButton));
		click(companySearchButton);
		assertTrue("searchResultArray is missing",isDisplayed(searchResultArray,200));
	}
	/**
	 * This method is to verify wrong contact lookup
	 */
	public void verifyContactLookupSearchWhenWrongConatct() {
		slowDown(1);
		String contactResultNoresultsMessage=getText(contactNoresult);
		assertEquals(contactResultNoresultsMessage,"There are no results to display.");
	}


	public void attemptToCreateProject(String projectName, String defaultLicensee){
		assertTrue("can't find the home page after login ",isDisplayed(projectManagementLink,200));
		clickJS(projectManagementLink);
		assertTrue("can't find the Project Management page ",isDisplayed(newProject,20));
		clickJS(newProject);
		assertTrue("can't find the Create button in Create New Project window",
				isDisplayed(createButton));
		type(projectName, newProjectField);
		assertTrue("can't find the defaultContact ",isDisplayed(defaultContact,20));
		click(createButton);
		slowDown(2);
	}

	public void attemptToCreateProjectNameTooLong(String projectName, String defaultLicensee){
		assertTrue("can't find the home page after login ",isDisplayed(projectManagementLink,200));
		clickJS(projectManagementLink);
		assertTrue("can't find the Project Management page ",isDisplayed(newProject,20));
		clickJS(newProject);
		assertTrue("can't find the Create button in Create New Project window",
				isDisplayed(createButton));
		type(projectName, newProjectField);
		click(defaultContact);
	}


	/**
	 * creates a project when default Licensee value is empty
	 * @param projectName - Name of the project
	 * @param defaultLicensee - Default name of the company
	 */
	public void createProjectPathErrorChecking(String projectName, String defaultLicensee){
		assertTrue("can't find the home page after login ",isDisplayed(projectManagementLink,200));
		clickJS(projectManagementLink);
		assertTrue("can't find the Project Management page ",isDisplayed(newProject,20));
		clickJS(newProject);
		assertTrue("can't find the Create button in Create New Project window",
				isDisplayed(createButton));
		type(projectName, newProjectField);
		isDisplayed(createButton);
		isDisplayed(defaultContact,20);
		click(createButton);
		slowDown(2);
	}

	/**
	 * @return boolean - checks project Name required validation
	 */
	public Boolean hasProjectName() {
		return isDisplayed(projectRequiredValidationMsg);
	}

	public String projectFieldError(){
		assertTrue(isDisplayed(errorMessage,30));
		return getText(errorMessage);
	}

	public Boolean alertMessagePresent(){
		return waitForIsDisplayed(createButton,10);
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

	public String pathAmounts() {
		return getText(totalPathAmount);
	}

	public String defaultCompany() {
		return getText(defaultCompany);
	}

}
