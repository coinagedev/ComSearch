package CommPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;


import static org.junit.Assert.assertEquals;


public class PathDataBasePage extends BasePage {

	public PathDataBasePage(WebDriver driver) {
		super(driver);
		visit("/");
	}

	//Path Data Fields - Element is read only and can use getFieldText method
	By pathLinkInHomePage = By.id("home-cta-database-management-path");
	By pathNameInPathDatabasePage = By.id("path-db-search-path-name");
	By pathnameResult = By.xpath("//*[contains(@id, 'pathDb-modal-table-data-pathId-') and contains(@id, '-pathInfo-path-name')]");
	By sitenameResult = By.xpath("//*[contains(@id, 'pathDb-modal-table-data-pathId-') and contains(@id, '-siteName-site-1')]");

	By site1PathDatabase = By.id("path-db-search-site1-site-name");
	By site1PathDatabaseImport = By.id("path-database-import-site1-site-name");

	By site2PathDatabase = By.id("path-db-search-site2-site-name");
	By callSign1PathDatabase = By.id("path-db-search-site1-call-sign");
	By callSign2PathDatabase = By.id("path-db-search-site2-call-sign");
	By contactCodePathDatabase = By.id("path-db-search-contact-codes");
	By contactCodeLookupPathDatabase =By.id("path-db-search-contact-lookup-trigger");
	By bandPathDatabase =  By.id("path-db-search-band");
	By bandOptionsPathDatabase = By.className("react-select__option");
	//By bandoptions = By.id("react-select-path-db-search-state-region-option-0");
	By callsign1PathDatbaseImport = By.id("path-database-import-site1-call-sign");
	By statePathDatabase = By.id("path-db-search-state-region");
	By siteStatusesPathDatabase = By.id("path-db-search-site-statuses");
	By searchPathDatabase = By.id("path-db-search-submit");
	By searchPathDatabaseImport = By.id("path-database-import-submit");
	By clearPathDatabase = By.id("path-db-search-clear");
	By RCNPathDatabase = By.id("path-db-search-rcn-number");
	By ASRPathDatabase = By.id("path-db-search--asr");
	By FCCPathDatabase = By.id("path-db-search-uls-file-number");
	By billcodePathDatabase = By.id("path-db-search-bill-code");
	By jobnumberPathDatabase = By.id("path-db-search-job-code");
	By protectedAny = By.id("path-db-search-protected---label-bottom");
	By protectedYes = By.id("path-db-search-protected--true-label-bottom");
	By protectedNo = By.id("path-db-search-protected--false-label-bottom");
	By frequencyPathDatabase = By.id("path-db-search-frequency");
	By polarizationPathDatabase = By.id("path-db-search-polarization");
	By radioCodePathDatabase = By.id("path-db-search-radio-code");
	By antennaCodePathDatabase = By.id("path-db-search-antenna-code");
	By radioCodeLookupPathDatabase = By.id("path-db-search-radio-lookup-trigger");
	By antennaCodeLookupPathDatabase = By.id("path-db-search-antenna-lookup-trigger");
	By latitudePathDatabase = By.id("path-db-search-latitude");
	By longitudePathDatabase = By.id("path-db-search-longitude");
	By searchRadiusPathDatabase = By.id("path-db-search-radius");
	By searchRadiusMeterPathDatabase = By.id("path-db-search-radiusUnit-SI-label-bottom");
	By searchRadiusFeetPathDatabase = By.id("path-db-search-radiusUnit-US-label-bottom");

	By selectAllPathDatabase = By.id("pathDb--path-cart-select-all-toggle");
	By hamburgerIconPathDatabase = By.id("pathDb--path-cart-drawer-toggle");
	By generateReportPathDatabase = By.id("path-cart-drawer-options-generate-report");
	By newProjectPathDatabase = By.id("path-cart-drawer-options-project-create");
	By closeHamburger= By.id("pathDb-menu-trigger");
	By PathHighlightPathDatabase = By.xpath("//*[contains(@id, 'pathDb-modal-table-data-pathId-') and contains(@id, '-pathInfo')]");
	By pathDatabaseResult = By.xpath("//*[contains(@id, 'path-database-import-modal-table-data-pathId-') and contains(@id, '-serviceContactCode-site-1')]");
	By pathDatabaseSelectResult = By.xpath("//*[contains(@id, 'pathDb-modal-table-data-pathId-') and contains(@id, '-siteName')]");
	By openPathDetailInDatabase = By.xpath("//*[contains(@id, 'pathDb-modal-table-data-pathId-') and contains(@id, '-siteName-site-1')]");
	By rcnFieldPathDetails = By.id("path-details-rcn-number");
	By jobCode = By.id("path-details-job-number");
	By pathDBSearchResult = By.xpath("//*[contains(@id,'pathDb-modal-table-data-pathId-') and contains(@id,'-siteName')]");
	
	By createButton= By.xpath("//button[contains(text(),'create')]");
	By ImportSuccessFul= By.id("import-paths-modal-success-heading");
	By saveButton=By.id("path-details-footer-save-path-button");
	By copyButton = By.id("path-details-footer-copy-path-button");
	By copySuccessMessage = By.id("path-details-modal-copy-success-message");
	By blankPage=By.cssSelector("div.ReactModal__Overlay.ReactModal__Overlay--after-open");
	By quickAddButton =By.id("project-summary-quick-add-open");
	By pathDeleteSucessHeading = By.id("path-details-modal-delete-success-heading");

	By projectNameFromPathDatabase = By.id("newProjectForm-projectName");
	By pathDatabaseCreateNewProjectButton =By .id("newProjectForm-submit");
	By projectName = By.id("project-summary-project-name");
	By pathCount = By.id("project-summary-project-total-paths");
	By site1PathImportPage = By.id("path-database-import-site1-site-name");
	By pathdetailsRadioCode = By.id("path-details-radios-0-radio-code");
	By pathdetailsMaxPower = By.id("path-details-radios-0-max-power");
	By pathDetailsWarning = By.xpath("//*[contains(@id, 'path-validations-drawer-path-id-') and contains(@id, '-messages-warning-0')]");
	By pathDetailsError = By.xpath("//*[contains(@id, 'path-validations-drawer-path-id-') and contains(@id, '-messages-error-0')]");
	By pathDetailsSite2Longitude = By.id("path-details-site-1-longitude");	
	
	By rcnFieldPathDatabaseImport = By.id("path-database-import-rcn-number");
	By radioFieldPathDatabaseImport = By.id("path-database-import-radio-code");
	By pathNamePathDatabaseImport = By.id("path-database-import-path-name");
	By pathDetailsPathDatabaseReturn = By.id("path-details-discard-button");
	By pathdetailsDBLatitude = By.id("path-details-site-0-latitude");
	By pathdetailsDBLongitude = By.id("path-details-site-0-longitude");
	By databaseHeaderLink = By.id("header-database-management-menu-trigger");
	By pathDatabaseHeaderLink= By.id("header-menu-database-management-path");
	By showSearchLinkPathDB = By.id("path-db-search--advanced-search-show");
	By site1Azimuth = By.id("path-details-site-0-azimuth");
	By site1RadioDBAzimuth = By.id("path-details-radios-0-bandwidth");
	By pathDatabseDeleteFooterPathDetails = By.id("path-details-footer-delete-button");
	By saveDelete = By.id("db-details-comments-submit");
	By pathDeleteReason = By.id("db-details-comments-comment");
	By errorRCN = By.xpath("//*[contains(@id, '-messages-error-0')]");
	By errorMsgClear= By.id("path-validations-drawer-clear-all");
	By geSite1 = By.id("path-details-site-0-elevation");
	By cancelCallsignCascade = By.id("CALLSIGN_CASCADE_FORM-cancel");
	By warningsDrawer = By.id("path-validations-drawer-clear-all");
	
	/**
	 * This method is to access the path Database
	 */

	public void accessPathDataBase(){
		slowDown(3);
		assertTrue("Path link in home page is missing", isDisplayed(pathLinkInHomePage,30));
		//double click
		click(pathLinkInHomePage);
		slowDown(3);
		//double search
		if(!isDisplayed(pathNameInPathDatabasePage,20))
			clickJS(pathLinkInHomePage);
		slowDown(3);
		assertTrue("Path Database page is missing", isDisplayed(pathNameInPathDatabasePage,10));

	}
	/**
	 * This method is to verify the elements in path Database page
	 */
	public void verifyElementsInPathDatabasePage() {
		assertTrue("Path name in path database page is missing", isDisplayed(pathNameInPathDatabasePage,10));
		assertTrue("Site1 in path database page is missing", isDisplayed(site1PathDatabase,10));
		assertTrue("Site2 in path database page is missing", isDisplayed(site2PathDatabase,10));
		assertTrue("Callsign1 in path database page is missing", isDisplayed(callSign1PathDatabase,10));
		assertTrue("Callsign2 in path dataase page is missing", isDisplayed(callSign2PathDatabase,10));
		assertTrue("Contact code in path database page is missing", isDisplayed(contactCodePathDatabase,10));
		assertTrue("Contact code lookup in path database page is missing", isDisplayed(contactCodeLookupPathDatabase,10));
		assertTrue("Band in path database page is missing", isDisplayed(bandPathDatabase,10));
		assertTrue("State in path database page is missing", isDisplayed(statePathDatabase,10));
		assertTrue("Site status in path database page is missing", isDisplayed(siteStatusesPathDatabase,10));
		assertTrue("Search button in path database page is missing", isDisplayed(searchPathDatabase,10));
		assertTrue("Clear button in path database page is missing", isDisplayed(clearPathDatabase,10));
		assertTrue("RCN in path database page is missing", isDisplayed(RCNPathDatabase,10));
		assertTrue("ASR in path database page is missing", isDisplayed(ASRPathDatabase,10));
		assertTrue("FCC in path database page  is missing", isDisplayed(FCCPathDatabase,10));
		assertTrue("Bill code in path database page  is missing", isDisplayed(billcodePathDatabase,10));
		assertTrue("Job number in path database page  is missing", isDisplayed(jobnumberPathDatabase,10));
		assertTrue("Protected - Any in path database page is missing", isDisplayed(protectedAny,10));
		assertTrue("Protected - Yes in path database page is missing", isDisplayed(protectedYes,10));
		assertTrue("Protected - No in path database page is missing", isDisplayed(protectedNo,10));
		assertTrue("Frequency in path database page is missing", isDisplayed(frequencyPathDatabase,10)); 
		assertTrue("Polarization in path database page is missing", isDisplayed(polarizationPathDatabase,10));
		assertTrue("Radio code in path database page is missing", isDisplayed(radioCodePathDatabase,10));
		assertTrue("Antenna code in path database page is missing", isDisplayed(antennaCodePathDatabase,10));
		assertTrue("Radio Code Lookup in path database page is missing", isDisplayed(radioCodeLookupPathDatabase,10));
		assertTrue("Antenna Code Lookup in path database page is missing", isDisplayed(antennaCodeLookupPathDatabase,10));
		assertTrue("Latitude in path database page is missing", isDisplayed(latitudePathDatabase,10));
		assertTrue("Longitude in path database page is missing", isDisplayed(longitudePathDatabase,10));
		assertTrue("Search radius in path database page is missing", isDisplayed(searchRadiusPathDatabase,10));
		assertTrue("Search radius meter in path database page is missing", isDisplayed(searchRadiusMeterPathDatabase,10));
		assertTrue("Search Radius feet in path database page is missing", isDisplayed(searchRadiusFeetPathDatabase,10));
		assertTrue("Select all checkbox in path database page is missing", isDisplayed(selectAllPathDatabase,10));
		assertTrue("Hamburger icon in path database page is missing", isDisplayed(hamburgerIconPathDatabase,10));


	}

	/**
	 * This method is to search Path database based on sitename and multi select bands
	 */

	/**
	 * @param site1 - sitename 1
	 * @param Band1 - multi selecting band option 1 from the drop down
	 * @param Band2 - Band option 2 from the dropdown
	 */
	public void searchPathDatabaseBasedOnSiteNameAndMultiBand(String site1, String site2,String Band1, String Band2) {
		slowDown(2);
		assertTrue("Site1 in path database page is missing", isDisplayed(site1PathDatabase,10));
		type(site1,site1PathDatabase);
		type(site2,site2PathDatabase);
		selectFromReactDropdown(bandPathDatabase, bandOptionsPathDatabase,Band1);
		selectFromReactDropdown(bandPathDatabase, bandOptionsPathDatabase,Band2);

		click(searchPathDatabase);
		slowDown(2);
		assertTrue("Results in path database is missing", isDisplayed(sitenameResult,160));
	}
	/**
	 * Search by rcn
	 * @param rcn 
	 */
	public void searchPathDatabaseBasedOnRCN(String rcn) {
		slowDown(2);
		assertTrue("Site1 in path database page is missing", isDisplayed(site1PathDatabase,10));
		type(rcn,RCNPathDatabase);
		click(searchPathDatabase);
		//double search
				if(!isDisplayed(pathDatabaseResult,5))
					clickJS(searchPathDatabase);
				slowDown(2);
		assertTrue("Results in path database is missing", isDisplayed(pathDBSearchResult,160));
		click(pathDBSearchResult);
		assertTrue("path details page form database is missing", isDisplayed(pathDetailsPathDatabaseReturn,80));
	}
	/**
	 * This method is to do a search for importing paths from path database
	 * @param site1
	 * @param callsign1
	 */

	public void searchPathDatabaseBasedOnImportFromDatabase(String site1, String callsign1) {
		slowDown(2);
		assertTrue("Site1 in path database page is missing", isDisplayed(site1PathDatabaseImport,10));
		type(site1,site1PathDatabaseImport);
		type(callsign1,callsign1PathDatbaseImport);
		click(searchPathDatabaseImport);
		slowDown(1);
		assertTrue("Results in path database is missing", isDisplayed(pathDatabaseResult,90));
	}

	/**
	 * This method is to click the first row from the results in path database
	 * 
	 */
	public void clickPathDatabaseSearchResult() {
		click(pathDatabaseResult);
		slowDown(3);
		assertTrue("Import failed", isDisplayed(ImportSuccessFul,20));
		String message=getText(ImportSuccessFul);
		assertEquals(message,"Import Successful!");
		slowDown(2);
		click(blankPage);
		assertTrue("Quick Add button is missing", isDisplayed(quickAddButton,20));

	}
	/**
	 * This method is to verify create button is not present in path database page
	 */
	public void verifyCreateButtonNotPresent() {
		slowDown(3);
		String elementPresent="false";
		assertEquals(elementPresent, isElementPresent(createButton)+"");

	}
	/**
	 * This method is to select two item from the results
	 * 
	 */
	public void selectTwoFromResults() {
		slowDown(2);
		clickJS(pathnameResult,0);
		clickJS(pathnameResult,1);
		slowDown(2);

	}
	/**
	 * This method is to click hamburger  
	 */
	public void clickHamburgerPathDatabase() {
		assertTrue("Hamburger in path database search page is missing",isDisplayed(hamburgerIconPathDatabase,20));
		clickJS(hamburgerIconPathDatabase);
		slowDown(5);

	}
	/**
	 * This method id to click "create new project button from hamburger menu in path database
	 */
	public void clickCreateNewProjectButtonFromHamburgerMenu() {
		clickJS(newProjectPathDatabase);
		assertTrue("New Project window doesnt appear", isDisplayed(projectNameFromPathDatabase,20));
	}
	/**
	 * This method is to type in values in new project window and click create button
	 * @param newProject 
	 */
	public void createNewProject(String newProject) {
		assertTrue("New Project window doesnt appear", isDisplayed(projectNameFromPathDatabase,20));
		type(newProject,projectNameFromPathDatabase);
		//double click
		click(pathDatabaseCreateNewProjectButton);
		slowDown(5);
		if(!isDisplayed(quickAddButton,20))
			clickJS(pathDatabaseCreateNewProjectButton);
	}
	/**
	 * This method is to verify the project name and path name
	 * @param newProject 
	 * @param count 
	 */
	public void verifyProjectAndPath(String newProject, String count) {
		assertTrue("path summary page of new project dosent appear", isDisplayed(quickAddButton,20));
		String newProjectName=getText(projectName);
		String countOfPath=getText(pathCount);
		assertEquals(newProject,newProjectName);
		assertEquals(countOfPath,count);
	}
	/**
	 * This method is to do a search for importing paths from path database
	 * @param rcn
	 */

	public void searchPathDatabaseBasedOnImportFromDatabase(String rcn) {
		slowDown(2);
		assertTrue("Site1 in path database import page is missing", isDisplayed(site1PathImportPage,60));
		type(rcn,rcnFieldPathDatabaseImport);
		slowDown(2);
		click(searchPathDatabaseImport);
		//double search
		if(!isDisplayed(pathDatabaseResult,15))
			clickJS(searchPathDatabaseImport);
		slowDown(2);
		assertTrue("Results in path database is missing", isDisplayed(pathDatabaseResult,90));
	}
	/**
	 * This method is to do a search for importing paths from path database
	 * @param radio
	 * @param siteName
	 */

	public void searchPathDatabaseBasedOnRadioImportFromDatabase(String radio,String siteName) {
		slowDown(2);
		assertTrue("Site1 in path database import page is missing", isDisplayed(site1PathImportPage,60));
		type(siteName,site1PathDatabaseImport);
		type(radio,radioFieldPathDatabaseImport);
		slowDown(2);
		click(searchPathDatabaseImport);
		//double search
		if(!isDisplayed(pathDatabaseResult,15))
			clickJS(searchPathDatabaseImport);
		slowDown(2);
		assertTrue("Results in path database is missing", isDisplayed(pathDatabaseResult,90));
	}
	
	/**
	 * This method copies a path from path database
	 */
	public void copyPathViaPathDetails(){
		slowDown(2);
		clickJS(pathDatabaseSelectResult);
		assertTrue("CopyButton did not appear", isDisplayed(copyButton, 20));
		clickJS(copyButton);
		slowDown(2);
		assertTrue("CopySuccess message did not appear", isDisplayed(copySuccessMessage, 10));
		String copyMessage = "You have successfully copied the path.";
		String copySuccessMessageResult = getText(copySuccessMessage);
		assertEquals(copySuccessMessageResult, copyMessage);
		click(blankPage);
		slowDown(2);
	}
	/**
	 * This method is to open the search result
	 */
	public void openSearchResult() {
		assertTrue("Results in path database is missing", isDisplayed(sitenameResult,100));
		click(sitenameResult);
		slowDown(1);
		assertTrue("path details page form database is missing", isDisplayed(pathDetailsPathDatabaseReturn,60));
				
	}
	/**
	 * This method is to return latutide value
	 * 
	 */
	public String getLatitudeFromPathDetails() {
		assertTrue("path details page form database is missing", isDisplayed(pathDetailsPathDatabaseReturn,60));
		String latitude= getText(pathdetailsDBLatitude);
		return (latitude);
	}
	
	/**
	 * This method is to return longitude value
	 * 
	 */
		public String getLongitudeFromPathDetails() {
			assertTrue("path details page form database is missing", isDisplayed(pathDetailsPathDatabaseReturn,60));
			String longitude=getText(pathdetailsDBLongitude);
			return (longitude);
		}
		
		/**
		 * This method is to navigate from path database search screen from header
		 */
		public void navigateToPathDatabaseSearchPageFromHeader() {
			assertTrue("database header link is missing", isDisplayed(databaseHeaderLink,60));
			clickJS(databaseHeaderLink);
			slowDown(1);
			clickJS(pathDatabaseHeaderLink);
			slowDown(3);

			// if the showSearch checkbox is not checked, then we need to click it to open the search.
			// this can happen when returning to the search page from a path details page
			// we persist the previous search criteria and automatically trigger a search when returning to the page,
			// this in turn hides the search form and makes the checkbox unchecked.
			if (!driver.findElement(showSearchLinkPathDB).isSelected()) {
				clickJS(showSearchLinkPathDB);
			}

			assertTrue("path database search page is missing", isDisplayed(latitudePathDatabase,70));

		}
		
		/**
		 * This method is to perform a path database search based on lat long and null radius
		 * 
		 */
		public void searchPathDatabaseBasedOnLatLongEmptyRadius(String latitude,String longitude) {
			slowDown(2);
			click(clearPathDatabase);
			assertTrue("path database search page is missing", isDisplayed(latitudePathDatabase,30));
			type(latitude,latitudePathDatabase);
			type(longitude,longitudePathDatabase);
			slowDown(1);
			click(searchPathDatabase);	
			slowDown(3);
			assertTrue("Results in path database is missing", isDisplayed(sitenameResult,60));
		}
		/**
		 * This method is to verify azimuth 
		 */
		public void verifyAzimuthDegree() {
			assertTrue("path details page form database is missing", isDisplayed(pathDetailsPathDatabaseReturn,60));
			assertTrue("site1 Azimuth in path details page form database is missing", isDisplayed(site1Azimuth,60));
			String azimuth = getText(site1Azimuth) ;
			String degree = azimuth.charAt(azimuth.length() -1)+""; 
			assertEquals(degree,"°");
			
		}
		/**
		 * This method is to verify the radio bandwidth unit
		 */
		public void verifyBandwidthUnit() {
			assertTrue("path details page form database is missing", isDisplayed(pathDetailsPathDatabaseReturn,60));
			assertTrue("Radio bandwidth in path details page form database is missing", isDisplayed(site1RadioDBAzimuth,60));
			String radioBandwith = getText(site1RadioDBAzimuth) ;
			//String unit = radioBandwith.charAt(radioBandwith.length() -1)+""; 
			String unit = radioBandwith.substring(radioBandwith.length() - 3);
			assertEquals(unit,"MHz");
			
		}
		
		/**
		 * This method is to do a search for importing paths from path database
		 * @param jobNumber
		 */

		public void searchPathDatabaseBasedOnJobNumber(String jobNumber) {
			slowDown(2);
			assertTrue("Site1 in path database page is missing", isDisplayed(site1PathDatabase,10));
			type(jobNumber,jobnumberPathDatabase);
			click(searchPathDatabase);
			slowDown(2);
			assertTrue("Results in path database is missing", isDisplayed(pathDatabaseSelectResult,80));
			click(openPathDetailInDatabase);
			assertTrue("Path Details page in path database is missing", isDisplayed(pathDatabseDeleteFooterPathDetails,20));
		}
		/**
		 * This method is to do a search for importing paths from path database
		 * @param rcn
		 */

		public void searchPathDatabaseBasedOnRcn(String rcn) {
			slowDown(2);
			assertTrue("Site1 in path database page is missing", isDisplayed(site1PathDatabase,10));
			type(rcn,RCNPathDatabase);
			click(searchPathDatabase);
			slowDown(2);
			assertTrue("Results in path database is missing", isDisplayed(pathDatabaseSelectResult,80));
			click(openPathDetailInDatabase);
			assertTrue("Path Details page in path database is missing", isDisplayed(pathDatabseDeleteFooterPathDetails,20));
		}
		/**
		 * This method is to delete path from database
		 */
		public void deletePathFromPathDetailsFromDatabase() {
			assertTrue("Path Details page in path database is missing", isDisplayed(pathDatabseDeleteFooterPathDetails,20));
			click(pathDatabseDeleteFooterPathDetails);
			assertTrue("Confirm Delete in path database deletion is missing", isDisplayed(saveDelete));
			type("QA testing",pathDeleteReason);
			click(saveDelete);
			slowDown(2);
			assertTrue("Results in path database is missing", isDisplayed(pathDatabaseSelectResult,20));
			click(openPathDetailInDatabase);
			slowDown(1);
			assertTrue("Path Details page in path database is missing", isDisplayed(pathDatabseDeleteFooterPathDetails,20));
			click(pathDatabseDeleteFooterPathDetails);
			assertTrue("Confirm Delete in path database deletion is missing", isDisplayed(saveDelete));
			type("QA testing",pathDeleteReason);
			click(saveDelete);
			slowDown(2);
			assertTrue("Path delete heading not displayed",isDisplayed(pathDeleteSucessHeading,150));
			assertEquals("Path not deleted","PATH DELETED SUCCESSFULLY",getText(pathDeleteSucessHeading));
			click(blankPage);

		}
		/**
		 * this method is to verify error when rcn or job code is removed
		 */
		public void removeRCNSavePathVerifyError(String error,String jobCodeError) {
			assertTrue("Path Details page in path database is missing", isDisplayed(pathDatabseDeleteFooterPathDetails,20));
			String rcn=getFieldText(rcnFieldPathDetails);
			slowDown(1);
			clear(rcnFieldPathDetails);
			click(saveButton);
			assertTrue("Error message is missing", isDisplayed(errorRCN,40));
			assertEquals(getText(errorRCN),error );
			slowDown(1);
			click(errorMsgClear);
			type(rcn,rcnFieldPathDetails);
			String jobCodeValue=getFieldText(jobCode);
			clear(jobCode);
			click(saveButton);
			slowDown(1);
			assertTrue("Error message is missing", isDisplayed(errorRCN,40));
			assertEquals(getText(errorRCN),jobCodeError );
			click(errorMsgClear);
			type(jobCodeValue,jobCode);
			click(saveButton);

		}
		/**
		 * This method is to remove existing radio code from site 1 and apply another radio code
		 * @param analogRadiocode
		 */
		public void removeAndApplyRadio(String analogRadiocode) {
			assertTrue("Path Details page in path database is missing", isDisplayed(pathdetailsRadioCode,20));
			clear(pathdetailsRadioCode);
			type(analogRadiocode,pathdetailsRadioCode);
			click(pathdetailsMaxPower);
			slowDown(1);
		}
		/**
		 * this method is to save path details form
		 */
		public void savePathDetailsForm() {
			assertTrue("Path Details page in path database is missing", isDisplayed(pathdetailsRadioCode,20));
			click(saveButton);

		}
		/**
		 * This method is to verify minimum throughput error is not displayed in the warning
		 */
		public void verifyMinTroughputErrorNotDisplayedInWarnings(boolean flag) {
			assertTrue("warning is missing",isDisplayed(pathDetailsWarning,90));
			String warning = getText(pathDetailsWarning);
			//next step will fail if there is a throughput related warning 
			assertEquals(warning.contains("Throughput"),flag);
		}
		/** 
		 * this method is to change the site 2 coordinates to Eastern hemisphere
		 * @param coordinateSite2Longitude
		 */
		public void changeSite2ToEasternHemisphere(String coordinateSite2Longitude) {
			assertTrue("Path Details page in path database is missing", isDisplayed(pathdetailsRadioCode,20));
			getFieldText(pathDetailsSite2Longitude);
			clear(pathDetailsSite2Longitude);
			type(coordinateSite2Longitude,pathDetailsSite2Longitude);
			
		}
		/**
		 * this method is to validate the error
		 * @param errorPathLength
		 */
		public void verifyPathLengthViolationError(boolean errorPathLength) {
			assertTrue("warning is missing",isDisplayed(pathDetailsError,90));
			String error = getText(pathDetailsError);
			//next step will fail if there is a throughput related warning 
			assertEquals(error.contains("Path length"),errorPathLength);
		
		}
		/**
		 * this method is to clear ground elevation for site 1 and type in a new value
		 * @param ge_site1
		 */
		public String clearGEandTypein(String ge_site1) {
			assertTrue("ge Site1 is missing",isDisplayed(geSite1,90));
			String existing_ge =getFieldText(geSite1);
			clear(geSite1);
			type(ge_site1,geSite1);
			return existing_ge;
		}
		/**
		 * this method is to click cancel if callsign cascade window appears
		 */
		public void clickCancelIfCallsignCascadeWindowAppears() {
			if(isDisplayed(cancelCallsignCascade,40)) {
				click(cancelCallsignCascade);
			}
			if(!isDisplayed(warningsDrawer,30)) {
				assertTrue("ge Site1 is missing",isDisplayed(geSite1,90));
			}else {
				String warning = getText(pathDetailsWarning);
				if(warning.contains("must be within +0.5 or -3.0 meters"))
					//fail the test.
					assertTrue("Not working as expected- should show msg related to GE", isDisplayed(ImportSuccessFul,20));

			}

		}
		public void updateWithOriginalGEValue(String existing_ge) {
			assertTrue("ge Site1 is missing",isDisplayed(geSite1,90));
			clear(geSite1);
			type(existing_ge,geSite1);
			
		}
}	
