package CommPageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import CommPageObjects.BasePage.*;
public class ProjectManagementPage extends BasePage {

	//fields
	By createUserNameSearchFieldInProjectManagementPage = By.id("project-management-searchcreate-user");
	By projectNameFieldInProjectManagementPage = By.id("project-management-search-project-name");
	By searchIconInProjectManagementPage = By.id("project-management-search-submit");
	By createbuttonInProjectManagementPage = By.id("new-project-modal-trigger");
	By projectStatusActiveInProjectManagementPage = By.id("project-management-search-project-statusproject-status--active-label-bottom");
	By searchResult = By.xpath("//*[contains(@id, 'project-management-modal-table-data-projectId-') and contains(@id, '-projectSummary-path-name')]");
	By searchResultContact = By.xpath("//*[contains(@id, 'project-management-modal-table-data-projectId-') and contains(@id, '-serviceContactCodes')]");
	By searchResultCreatedBy = By.xpath("//*[contains(@id, 'project-management-modal-table-data-projectId-') and contains(@id, '-userName')]");
	By searchResultCreatedDate = By.xpath("//*[contains(@id, 'project-management-modal-table-data-projectId-') and contains(@id, '-createTime')]");
	By searchResultLastModified = By.xpath("//*[contains(@id, 'project-management-modal-table-data-projectId-') and contains(@id, '-modifiedTime')]");
			
	By copyProjectButtonInHamburger =By.id("project-management-copy-projects");
	By selectAllCheckBox = By.id("project-management-highlight-all");
	By hamburger =  By.id("project-management-menu-trigger");
	By deleteProjectInPathManagementPage = By.id("project-management-delete-projects");
	By copyProjectsInPathManagementPage = By.id("project-management-copy-projects");

	By projectDeleteConfirmButton = By.id("delete-confirmation-modal-delete");
	By projectDeleteCancelButton = By.id("delete-confirmation-modal-cancel");
	By deleteConfirmationMessageWarning = By.cssSelector("text-blue-dark");
	By deleteConfirmationMessage = By.cssSelector("padding-half.center-text");
	By projectSearchMessage= By.xpath("//div[@id='project-management-modal']/div[2]/p");
	By newProject = By.id("newProjectForm-projectName");
	By submitProject= By.id("newProjectForm-submit");
	By pathFilter =By.id("project-summary-filter-input");
	By finalizedTab = By.id("project-management-search-project-statusproject-status--3-label");
	By finalizedTableRCNlabel = By.id("project-management-modal-table-header-rcnNumbers");
	By finalizedProjectJobCodeValue = By.xpath("//*[contains(@id, 'project-management-modal-table-data-projectId-') and contains(@id, '-jobCode')]");
	By finalizedProjectRCNValue = By.xpath("//*[contains(@id, 'project-management-modal-table-data-projectId-') and contains(@id, '-rcnNumbers')]");
	By projectsLink = By.id("header-menu-projects-list");
	By hamburgerMenu = By.id("project-management-menu-trigger");
	By deleteProjectsHamburgerMenu = By.id("project-management-delete-projects");
	By deleteConfirmButton = By.id("delete-confirmation-modal-delete");
	By deleteSuccessMessage = By.id("delete-success-modal-message");
	By homeLink = By.id("header-menu-home");
	By projectManagmentHome = By.id("home-cta-project-management");
			
	Random rndNum = new Random();;
	int randomNumber = rndNum.nextInt(100000);
	int randomNumber1 = rndNum.nextInt(100000);
	public ProjectManagementPage(WebDriver driver) {
		super(driver);
		visit("");
	}

	/**
	 * This function is to search for a project and delete the project
	 */

	public void searchProjectAndDeleteProject(String projectName)
	{
		assertTrue("projectName Field In ProjectManagementPage is not displayed",isDisplayed(projectNameFieldInProjectManagementPage,50));
		slowDown(2);
		clear(projectNameFieldInProjectManagementPage);
		type(projectName,projectNameFieldInProjectManagementPage );
		slowDown(1);
		click(searchIconInProjectManagementPage);
		slowDown(1);
		assertTrue("search result is not displayed",isDisplayed(searchResult,50));
		click(selectAllCheckBox);
		click(hamburger);
		assertTrue("'Delete projects' button is not displayed",isDisplayed(deleteProjectInPathManagementPage,50));
		clickJS(deleteProjectInPathManagementPage);
		assertTrue("project Delete Confirm Button  is not displayed",isDisplayed(projectDeleteConfirmButton,50));
		click(projectDeleteConfirmButton);
		slowDown(4);
		//make sure the project actually gets deleted.
		clear(projectNameFieldInProjectManagementPage);
		type(projectName,projectNameFieldInProjectManagementPage );
		slowDown(1);
		click(searchIconInProjectManagementPage);
		slowDown(1);
		String searchMessage=getText(projectSearchMessage);
		assertEquals(searchMessage,"There are no results to display.");
	}
	/**
	 * This function is to search for a project and open it
	 */

	public void searchProject(String projectName)
	{
		assertTrue("projectName Field In ProjectManagementPage is not displayed",isDisplayed(projectNameFieldInProjectManagementPage,50));
		slowDown(2);
		clear(projectNameFieldInProjectManagementPage);
		type(projectName,projectNameFieldInProjectManagementPage );
		slowDown(1);
		click(searchIconInProjectManagementPage);
		slowDown(1);
		assertTrue("search result is not displayed",isDisplayed(searchResult,80));


	}

	/**
	 * This function is to search for a project and select it
	 */

	public void searchProjectAndClickSelectProject(String projectName)
	{
		searchProject( projectName);
		clickJS(searchResult);

	}
	/**
	 * This method is to copy a project and returms the name of the new project
	 * @param projectName
	 * @return
	 */
	public String copyProject(String projectName) {
		clickJS(hamburger);
		assertTrue("copyProject Button In Hamburger is not displayed",isDisplayed(copyProjectButtonInHamburger,50));
		slowDown(1);
		click(copyProjectButtonInHamburger);
		String copiedProjectName="copied" + randomNumber;
		assertTrue("Copy project window doesnt appear", isDisplayed(newProject));
		type(copiedProjectName,newProject);
		click(submitProject);
		slowDown(5);
		if(!isDisplayed(pathFilter,5))
			click(submitProject);
		return copiedProjectName;
	}
	
	/**
	 * This method searches for a project with user name and clicks it
	 */
	public void searchProjectWithUsername(String projectName, String userName) {
		slowDown(5);
		assertTrue("username field dropdown is not displayed", isDisplayed(createUserNameSearchFieldInProjectManagementPage,50));
		focusAndType(createUserNameSearchFieldInProjectManagementPage, userName);
		slowDown(5);
		sendKeyEnter();
		slowDown(5);
		searchProject(projectName);
		slowDown(5);
		click(searchResultContact);
		slowDown(5);
	}
	
	/**
	 * This method verifies authenticated user and created/modified by dates
	 */
	public void verifyCreatedByUserAndDate(String projectName, String userName) {
		assertEquals(userName, getText(searchResultCreatedBy));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		assertEquals(currentDate, getText(searchResultCreatedDate));
		assertEquals(currentDate, getText(searchResultLastModified));
	}
	/**
	 * this method is to click finalized toggle from project management page
	 */

	public void clickFinalizedToggle() {
		assertTrue("finalized tab is missing",isDisplayed(finalizedTab,50));
		click(finalizedTab);
		assertTrue("finalizedProjectJobCodeValue is missing",isDisplayed(finalizedProjectJobCodeValue,50));

	}
	/**
	 * this method is to verify ProjectManagement jobCode and RCN values
	 * @param generatedJobCode
	 * @param generatedRcn
	 */
	public void verifyProjectManagementjobCodeandRCNvalues(String generatedJobCode, String generatedRcn) {
		assertEquals(generatedJobCode, getText(finalizedProjectJobCodeValue));
		assertEquals(generatedRcn, getText(finalizedProjectRCNValue));
		
	}
	/**
	 * this method is to click projects link from the header
	 */
	public void clickProjectsLink() {
		assertTrue("projectsLink is missing",isDisplayed(projectsLink,50));
		clickJS(projectsLink);
	}
	/**
	 * this method is to click hamburger menu
	 */
	public void clickHamburger() {
		click(hamburgerMenu);
		assertTrue("delete Projects option is missing in HamburgerMenu",isDisplayed(deleteProjectsHamburgerMenu,30));
	}
	/**
	 * this method is to click delete option from hamburger menu
	 * @param deleteSuccessMsg
	 */
	public void clickDeleteProjectOption(String deleteSuccessMsg) {
		assertTrue("delete Projects option is missing in HamburgerMenu",isDisplayed(deleteProjectsHamburgerMenu,30));
		click(deleteProjectsHamburgerMenu);
		assertTrue("delete confirm button is missing" ,isDisplayed(deleteConfirmButton,30));
		click(deleteConfirmButton);
		assertTrue("delete Success Message is missing" ,isDisplayed(deleteSuccessMessage,50));
		assertEquals(deleteSuccessMsg,getText(deleteSuccessMessage));
	}
	/**
	 * this method is to click home link from header
	 */

	public void clickHome() {
		assertTrue("projectsLink is missing",isDisplayed(homeLink,50));
		clickJS(homeLink);
		assertTrue("projectsLink is missing",isDisplayed(projectManagmentHome,60));

	}
}

