package CommPageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommTests.Config;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage implements Config {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	private WebElement element;
	private ChromeOptions options;

	public BasePage(WebDriver driver) {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("window-size=4000,3000");
		//options.addArguments("--headless");
	}

	@BeforeAll
	public void visit(String url) {

		if (driver == null) {
			driver = new ChromeDriver(options);
		}
		if (url.contains("https")) {
			driver.get(url);
			driver.manage().deleteAllCookies();
			wait = new WebDriverWait(driver, 5);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

		} else {
			driver.get(baseUrl + url);
			driver.manage().deleteAllCookies();
			wait = new WebDriverWait(driver, 5);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		}
	}

	/**
	 * Method designed to drag and drop files from file system (filePath)to
	 * specified element in application (target)
	 * 
	 * @param filePath
	 * @param target
	 * @param offsetX
	 * @param offsetY
	 */
	public static void DropFile(File filePath, WebElement target, int offsetX, int offsetY) {
		if (!filePath.exists())
			throw new WebDriverException("File not found: " + filePath.toString());

		WebDriver driver = ((RemoteWebElement) target).getWrappedDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		String JS_DROP_FILE = "var target = arguments[0]," + "    offsetX = arguments[1],"
				+ "    offsetY = arguments[2]," + "    document = target.ownerDocument || document,"
				+ "    window = document.defaultView || window;" + "" + "var input = document.createElement('INPUT');"
				+ "input.type = 'file';" + "input.style.display = 'none';" + "input.onchange = function () {"
				+ "  var rect = target.getBoundingClientRect(),"
				+ "      x = rect.left + (offsetX || (rect.width >> 1)),"
				+ "      y = rect.top + (offsetY || (rect.height >> 1)),"
				+ "      dataTransfer = { files: this.files };" + ""
				+ "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {"
				+ "    var evt = document.createEvent('MouseEvent');"
				+ "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);"
				+ "    evt.dataTransfer = dataTransfer;" + "    target.dispatchEvent(evt);" + "  });" + ""
				+ "  setTimeout(function () { document.body.removeChild(input); }, 25);" + "};"
				+ "document.body.appendChild(input);" + "return input;";

		WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
		input.sendKeys(filePath.getAbsoluteFile().toString());
		wait.until(ExpectedConditions.stalenessOf(input));
	}

	/**
	 * Method designed to upload specified file(fileName) by location (location)
	 * 
	 * @param fileName
	 * @param location
	 * @param fileSubmit
	 */
	public void uploadFile(String fileName, By location, By fileSubmit) {
		String filename = fileName;
		File file = new File(filename);
		String path = file.getAbsolutePath();
		type(path, location);
		click(fileSubmit);
		slowDown(2);
	}

	public void uploadFile(String fileName, By location) {
		String filename = fileName;
		File file = new File(filename);
		String path = file.getAbsolutePath();
		type(path, location);
	}

	/**
	 * Method designed to upload multiple specified files(fileName) by location
	 * (location)
	 * 
	 * @param fileName
	 * @param location
	 * @param fileSubmit
	 */
	public void uploadFileMulti(String fileName, By location, By fileSubmit) {
		String string = fileName;
		String[] filename = string.split(";");
		String part1 = filename[0];
		String part2 = filename[1];
		File file2 = new File(part2);
		File file1 = new File(part1);
		String path1 = file1.getAbsolutePath();
		String path2 = file2.getAbsolutePath();
		slowDown(2);
		types(path1, path2, location);
		click(fileSubmit);
	}

	/**
	 * Pauses execution to adjust to running suite in different environments.
	 *
	 * @param i
	 */
	public void slowDown(int i) {
		try {
			TimeUnit.SECONDS.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void goBack() {
		driver.navigate().back();
	}

	/**
	 * finds a single element using the Selenium's findElement
	 *
	 * @param locator
	 * @return
	 */
	public WebElement find(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * finds a multiple elements using the Selenium's findElements for array
	 * selection
	 *
	 * @param locators
	 * @param i
	 * @return
	 */
	public WebElement find(By locators, int i) {
		return driver.findElements(locators).get(i);
	}

	/**
	 * gets the field text of element(locator) being passed via parameter
	 *
	 * @param locator
	 * @return
	 */
	public String getFieldText(By locator) {
		WebElement txtBoxContent = driver.findElement(locator);
		String fieldValue = new String();
		fieldValue = txtBoxContent.getAttribute("value");
		return fieldValue;
	}

	public String getFieldTextTitle(By title) {
		WebElement txtBoxContent = driver.findElement(title);
		String fieldValue = new String();
		fieldValue = txtBoxContent.getAttribute("title");
		return fieldValue;
	}

	/**
	 * This method is to extract href value
	 * 
	 * @param locator
	 * @return
	 */
	public String getHref(By locator) {
		WebElement txtBoxContent = driver.findElement(locator);
		String fieldValue = new String();
		fieldValue = txtBoxContent.getAttribute("href");
		return fieldValue;
	}

	/**
	 * This method allows you to use the i parameter to select the element form an
	 * array of elements to get the locator's field text
	 * 
	 * @param locator
	 * @param i
	 * @return
	 */
	public String getFieldTextPlural(By locator, int i) {
		WebElement txtBoxContent = driver.findElements(locator).get(i);
		String textValue = new String();
		textValue = txtBoxContent.getAttribute("value");
		return textValue;
	}

	public String getFieldText(By locator, String alt) {
		WebElement txtBoxContent = driver.findElement(locator);
		String textValue = new String();
		textValue = txtBoxContent.getAttribute(alt);
		return textValue;

	}

	/**
	 * deletes field text of element(locator) being passed via parameter
	 *
	 * @param locator
	 */
	public void clear(By locator) {
		if (ie.equals("IE")) {
			find(locator).sendKeys(Keys.CONTROL + "a");
		}
		driver.findElement(locator).clear();
	}

	public void copyText(By locator) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		clipboard.setContents(new StringSelection(find(locator).getAttribute("value")), null);
	}

	/**
	 * Method takes the data from clip board and pastes in specified field
	 * 
	 * @param locator
	 */
	public void pasteText(By locator) {
		click(locator);
		slowDown(3);

		if (os_version.equals("windows")) {
			Actions builder = new Actions(driver);
			Action select = builder.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build();
			select.perform();
		} else {
			Actions builder = new Actions(driver);
			Action select = builder.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).build();
			select.perform();
		}

	}

	public void focusAndType(By locator, String text) {
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(text);
		actions.build().perform();
	}

	/**
	 * This method presses the enter key
	 */
	public void sendKeyEnter() {
		new Actions(driver).sendKeys(Keys.RETURN).perform();
	}

	/**
	 * // or any locator strategy that you find suitable WebElement locOfOrder =
	 * driver.findElement(By.id("id of the order id")); Actions act = new
	 * Actions(driver);
	 * act.moveToElement(locOfOrder).doubleClick().build().perform(); // catch here
	 * is double click on the text will by default select the text // now apply copy
	 * command
	 * 
	 * driver.findElement(By.id("")).sendKeys(Keys.chord(Keys.CONTROL,"c")); // now
	 * apply the command to paste driver.findElement
	 * (By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).sendKeys(Keys.chord(Keys.CONTROL,
	 * "v"));
	 */

	public boolean checked(By locator) {
		boolean checked = find(locator).isSelected();
		return checked;
	}

	/**
	 * COM-426 Fix Site search locator and add COM 393 Clicks on elements that are
	 * difficult to locate
	 * 
	 * @param locator
	 */
	public void clickJS(By locator) {
		WebElement invisible = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", invisible);
	}

	public void clickJS(By locator, int i) {
		WebElement invisible = driver.findElements(locator).get(i);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", invisible);
	}

	/**
	 * produces a list of elements and prints the attribute list
	 *
	 * @param locators
	 * @return
	 */
	public List<WebElement> finds(By locators) {
		List<WebElement> yourList = driver.findElements(locators);
		if (yourList != null || !yourList.isEmpty()) {
			for (WebElement webElement : yourList) {
			}
		} else {

		}
		return driver.findElements(locators);
	}

	public void max() {
		driver.manage().window().maximize();
	}

	public void resizeTest() {
		((JavascriptExecutor) driver).executeScript("window.resizeTo(1374, 975);");
	}

	/**
	 * finds a single element's text using the Selenium's findElement and getText
	 *
	 * @param locator
	 * @return
	 */
	public String getText(By locator) {
		WebElement txtBoxContent = driver.findElement(locator);
		String textValue = new String();
		textValue = txtBoxContent.getText();
		return textValue;
	}

	public String getTextInner(By locator) {
		WebElement txtBoxContent = driver.findElement(locator);
		String textValue = new String();
		textValue = txtBoxContent.getAttribute("innerText");
		return textValue;
	}

	public String getTextDropdown(By locator) {
		Select dropdown = new Select(driver.findElement(locator));
		String selectedValue = dropdown.getFirstSelectedOption().getText();
		return selectedValue;
	}

	/**
	 * finds multiple element's text using the Selenium's findElements and getText
	 * user may select using an array
	 *
	 * @param locator
	 * @param i
	 * @return
	 */
	public String getTextPlural(By locator, int i) {
		WebElement txtBoxContent = driver.findElements(locator).get(i);
		String textValue = new String();
		textValue = txtBoxContent.getText();
		return textValue;
	}

	/**
	 * finds single element using the Selenium's findElement and clicking element
	 * using the seleinium's click method
	 *
	 * @param locator
	 */
	public void click(By locator) {
		WebElement ele = find(locator);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
	}

	/**
	 * This method is to find whether an element is enabled or disabled
	 *
	 * @param locator
	 */

	public boolean enabled(By locator) {
		boolean b = driver.findElement(locator).isEnabled();
		return b;
	}

	public void waitForFieldText(String fieldTest, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementValue((locator), fieldTest));
	}

	public void waitForFieldToBeNotNull(final By locator) {
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(locator).getAttribute("value").length() != 0;
			}
		});
	}

	public void waitForText(String fieldTest, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated((locator), fieldTest));
	}

	public void waitForText(String fieldTest, By locator, int i) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBePresentInElementLocated((locator), fieldTest));
	}

	/**
	 * finds multiple elements using the Selenium's findElements and clicking
	 * element using the seleinium's click method
	 *
	 * @param locators
	 * @param i
	 */
	public void click(By locators, int i) {
		finds(locators).get(i).click();
	}

	/**
	 * interacts with elements that have hover lists allows for hovering, selecting
	 * and clicking a specific option
	 *
	 * @param locator
	 * @param i
	 */
	public void hover(By locator, int i) {

		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";

		WebElement we = driver.findElements(locator).get(i);
		((JavascriptExecutor) driver).executeScript(javaScript, we);

		/*
		 * Actions action = new Actions(driver); WebElement we =
		 * driver.findElements(locator).get(i);
		 * action.moveToElement(we).click().build().perform();
		 */
	}

	/**
	 * interacts with element that have hover and allows for hovering, selecting and
	 * clicking a specific option
	 *
	 * @param locator
	 */
	public void hover(By locator) {

		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";

		WebElement we = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript(javaScript, we);

	}

	public void hoverElement(By locator) {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(locator);
		action.moveToElement(we).click().build().perform();
	}

	/**
	 * A variation of the hover method that hovers specified element
	 * 
	 * @param locator
	 * @param subMenu
	 */
	public void hoverElement(By locator, By subMenu) {

		Actions actions = new Actions(driver);
		WebElement menuHoverLink = find(locator);
		actions.moveToElement(menuHoverLink);

		WebElement subLink = find(subMenu);
		actions.moveToElement(subLink);
		actions.click();
		actions.perform();
	}

	/**
	 * inputs text(inputText)into field element(locator)
	 *
	 * @param inputText
	 * @param locator
	 */
	public void type(String inputText, By locator) {

		find(locator).sendKeys(inputText);
	}

	/**
	 * supports the adding of multiple files to the comments module attachment
	 * feature
	 * 
	 * @param inputText
	 * @param inputText2
	 * @param locator
	 */
	public void types(String inputText, String inputText2, By locator) {
		find(locator).sendKeys(inputText);
		find(locator).sendKeys(inputText2);
	}

	/**
	 * supports the adding of multiple files to the comments module attachment
	 * feature
	 * 
	 * @param inputText
	 * @param inputText2
	 * @param locator
	 */
	public void types(String inputText, String inputText2, String inputText3, By locator) {
		find(locator).sendKeys(inputText);
		find(locator).sendKeys(inputText2);
		find(locator).sendKeys(inputText3);
	}

	/**
	 * supports the adding of multiple files to the comments module attachment
	 * feature
	 * 
	 * @param inputText
	 * @param inputText2
	 * @param locator
	 */
	public void types(String inputText, String inputText2, String inputText3, String inputText4, By locator) {
		find(locator).sendKeys(inputText);
		find(locator).sendKeys(inputText2);
		find(locator).sendKeys(inputText3);
		find(locator).sendKeys(inputText4);
	}

	public void typePlural(String inputText, By locator, int i) {
		WebElement we = driver.findElements(locator).get(i);
		we.sendKeys(inputText);
	}

	public Boolean isDisplayed(By locator) {
		return find(locator).isDisplayed();
	}

	public Boolean isDisplayedArray(By locators, int i) {
		return finds(locators).get(i).isDisplayed();
	}

	// element not present
	public boolean isElementPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Will check to see if an element is not present Instead of returning exception
	 * this will return false
	 *
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public Boolean isDisplayed(By locator, Integer timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (org.openqa.selenium.TimeoutException exception) {
			return false;
		}
		return true;
	}

	/**
	 * Waits for element to be located and clickable will timeout if element is not
	 * clickable
	 *
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public Boolean isDisplayedAndClickable(By locator, Integer timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));

		} catch (org.openqa.selenium.TimeoutException exception) {
			return false;
		}
		return true;
	}

	/**
	 * waits until a given element is not present then allows process to conitue
	 *
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public Boolean waitUntilNotPresent(By locator, Integer timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (org.openqa.selenium.TimeoutException exception) {
			return false;
		}
		return true;
	}

	/**
	 * Switches into a given frame and allows selenium to interact with elements
	 * therein
	 * 
	 * @param i
	 */
	public void switchToFrame(int i) {
		driver.switchTo().frame(i);
	}

	/**
	 *
	 */
	public void switchBackToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	/**
	 * dismisses javascript alerts
	 */
	public void DealWithTheAlert() {
		Alert Popup = driver.switchTo().alert();
		Popup.accept();
	}

	/**
	 * Validates that an alrert is presernt
	 */
	public void checkAlertAndAccept() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {

		}
	}

	/**
	 * pass a list of objects to the method so that a for loop can iterate the list
	 * to find the correct row
	 * 
	 * @param locators
	 * @return
	 */
	public int getRows(By locators) {
		int rows = finds(locators).size();
		return rows;
	}

	public Boolean waitForIsDisplayed(By locator, Integer... timeout) {
		try {
			waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeout.length > 0 ? timeout[0] : null));
		} catch (org.openqa.selenium.TimeoutException exception) {
			return false;
		}
		return true;
	}

	/**
	 * Explicit Wait specify amount of time and an action then seleinium will
	 * attempt the action Until the action is completed or the process times out
	 * 
	 * @param condition
	 * @param timeout
	 */
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
		timeout = timeout != null ? timeout : 5;// if nothing is passed default wait will be 5 seconds
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(condition);
	}

	public void selectFromDropdown(By location, String option) {
		WebElement dropDownListBox = driver.findElement(location);
		Select clickThis = new Select(dropDownListBox);
		slowDown(3);
		clickThis.selectByVisibleText(option);
	}

	public void selectFromReactDropdown(By locationDropdown, By locationOption, String option) {

		WebElement radioButtonElement = driver.findElement(locationDropdown);

		// Create Actions for use with react js
		Actions act = new Actions(driver);
		act.click(radioButtonElement).build().perform();

		// Get Dropdown list
		List<WebElement> dropDownListBox = driver.findElements(locationOption);

		// Loop through and check for first matching entry
		for (int i = 0; i < dropDownListBox.size(); i++) {
			if (dropDownListBox.get(i).getText().equals(option)) {
				// Click matching entry through Action
				act.click(dropDownListBox.get(i)).build().perform();
				break;
			}
		}

		slowDown(3);

	}

	public void sortAttributeValidationAscending(By listLocator, String attributeType) {
		ArrayList<String> obtainedList = new ArrayList<String>();
		List<WebElement> elementList = driver.findElements(listLocator);
		for (WebElement we : elementList) {
			obtainedList.add(we.getAttribute(attributeType));
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		assertEquals(sortedList, (obtainedList));
	}

	public void sortAttributeByColorValidationAscending(By listLocator, String attributeType) {
		ArrayList<String> obtainedList = new ArrayList<String>();
		List<WebElement> elementList = driver.findElements(listLocator);
		for (WebElement we : elementList) {
			obtainedList.add(we.getAttribute(attributeType));
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.reverse(sortedList);
		Collections.reverse(sortedList);
		assertEquals(sortedList, (obtainedList));
	}

	public void sortAttributeValidationDescending(By listLocator, String attributeType) {
		ArrayList<String> obtainedList = new ArrayList<String>();
		obtainedList.removeAll(Arrays.asList("", null));
		List<WebElement> elementList = driver.findElements(listLocator);
		for (WebElement we : elementList) {
			obtainedList.add(we.getAttribute(attributeType));
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		sortedList.removeAll(Arrays.asList("", null));
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.reverse(sortedList);
		assertEquals(sortedList, (obtainedList));
	}

	public void sortValidationAscending(By listLocator) {
		ArrayList<String> obtainedList = new ArrayList<String>();
		List<WebElement> elementList = driver.findElements(listLocator);
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		assertTrue(sortedList.equals(obtainedList));
	}

	/**
	 * Checks for elements and count and captures the element's name values
	 * increments for each element and sorts in reverse then compares the list
	 * 
	 * @param listLocator
	 */
	public void sortValidationDescending(By listLocator) {
		ArrayList<String> obtainedList = new ArrayList<String>();
		obtainedList.removeAll(Arrays.asList("", null));
		List<WebElement> elementList = driver.findElements(listLocator);
		for (WebElement we : elementList) {
			obtainedList.add(we.getText());
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		sortedList.removeAll(Arrays.asList("", null));
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.reverse(sortedList);
		Collections.reverse(sortedList);
		assertTrue(sortedList.equals(obtainedList));
	}

	/**
	 * Check if the sorting is by ascending by checking if the arrow is 'up'; if not
	 * click on it to sort by ascending
	 * 
	 * @param sortControl
	 */
	public void checkForAscend(By sortControl) {
		slowDown(2);
		String arrow_direction = driver.findElement(sortControl).getAttribute("class");
		if (!arrow_direction.contains("down"))
			element = driver.findElement(sortControl);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	/**
	 * Check if the sorting is by ascending by checking if the arrow is 'up'; if not
	 * click on it to sort by ascending
	 * 
	 * @param sortControl
	 */
	public void checkForDescend(By sortControl) {
		String arrow_direction = driver.findElement(sortControl).getAttribute("class");
		if (!arrow_direction.contains("up"))
			element = driver.findElement(sortControl);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	/**
	 * Checks for elements and count and captures the element's name values
	 * increments for each element and sorts then compares the list
	 * 
	 * @param element
	 * @param listOfItems
	 * @param PathList
	 */
	public void sortAramma(By element, By listOfItems, By PathList) {
		int eleCount;
		List<WebElement> elements;
		List<String> customerNameA = new ArrayList<String>();
		List<String> customerNameB = new ArrayList<String>();
		assertTrue(isDisplayed(element));
		elements = driver.findElements(listOfItems);

		eleCount = elements.size();
		System.out.println("Element count: " + eleCount);

		for (int i = 2; i < eleCount; i++) {
			customerNameA.add(driver.findElement(PathList).getText());
			System.out.println(driver.findElement(PathList).getText());
			customerNameB.add(driver.findElement(PathList).getText());

		}
		Collections.sort(customerNameA);

		for (int i = 0; i < customerNameA.size(); i++) {
			System.out.println("Customer Name from input: " + customerNameB.get(i)
					+ "--Customer Name from sorted input: " + customerNameA.get(i));
			if (!(customerNameA.get(i).equals(customerNameB.get(i)))) {
				System.out.println("Customer Names not sorted: " + i);
				break;

			}
		}
	}

	public String getAttributeValue(By id) {
		WebElement disabled = driver.findElement(id);
		String fieldValue = new String();
		fieldValue = disabled.getAttribute("value");
		return fieldValue;
	}

	public String getAttributeStyle(By id) {
		WebElement element = driver.findElement(id);
		return element.getAttribute("style");
	}

	public static final String INACTIVE_POINTER = "inactive pointer";
	public static final String DOWN_POINTER = "active direction-down pointer";
	public static final String PROJECT_ROW = "project-summary-path-row-";
	public static final String PATH_VAL = "//*[contains(@id, 'path-') and contains(@id,";
	public static final String ANTENNA_DB_MODAL = "antennaDb-modal-table-data-antennaCode-";
	public static final String RADIO_DB_MODAL = "radioDb-modal-table-data-radioCode-";
	public static final String RADIO_LOOKUPDB_MODAL = "radio-lookup-modal-table-data-radioCode";
	public static final int RADIO_CODE_LENGTH = 6;
	public static final String ANTENNA_DISCRIMINATION_TEXT = "discrimination-calculator-results-disc-";
	public static final String ANTENNA_DISCRIMINATION_GAIN__TEXT = "discrimination-calculator-results-gain-";
	public static final String FREQUENCY_CHANNEL_SITE1_TEXT = "frequencyPlans[0]frequencies";
	public static final String FREQUENCY_CHANNEL_SITE2_TEXT = "frequencyPlans[1]frequencies";
	public static final String FREQUENCY_PLAN_TEXT = "path-details-frequency-plan-0--frequency-lookup-table-data-frequencyPlanId-";
	public static final String PROJECT_SUMMARY_PATHID = "//*[contains(@id, 'project-summary-path-summary-data-pathId-') and contains(@id,";

	public static void quit() {
		driver.quit();
		driver = null; // we destroy the driver object after quit operation
	}

	public static void close() {
		driver.close();
		driver = null; // we destroy the driver object after quit operation
	}
}
