/**
 * 
 */
package com.test.Utilities;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author VarunDevSinha (press ctrl + O)
 *
 */
public class uiSeleniumUtility {

	/**
	 * 
	 * @param browser
	 * @param propertiesFilePath
	 */
	public static final void setWebdriverLocally(String browser, String propertiesFilePath) {

		if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"GoogleWebDriverName"),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"GoogleWebDriverPath"));

			System.out.println(
					"Current System property for WebDriver: " + System.getProperty(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "GoogleWebDriverName")));

		} else if (browser.equalsIgnoreCase("Edge")) {

			System.setProperty(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"EdgeWebDriverName"),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"EdgeWebDriverPath"));

			System.out.println(
					"Current System property for WebDriver: " + System.getProperty(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "EdgeWebDriverName")));

		} else if (browser.equalsIgnoreCase("Safari")) {

			System.setProperty(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"SafariWebDriverName"),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"SafariWebDriverPath"));

			System.out.println(
					"Current System property for WebDriver: " + System.getProperty(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "SafariWebDriverName")));
		}

	}

	/**
	 * 
	 * @return
	 */
	public static final ChromeOptions getChromeoptionsObject() {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("headless", true);
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(10));

		return chromeOptions;
	}

	/**
	 * 
	 * @return
	 */
	public static final EdgeOptions getEdgeoptionsObject() {

		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.setCapability("headless", true);
		edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		edgeOptions.setImplicitWaitTimeout(Duration.ofSeconds(10));

		return edgeOptions;
	}

	/**
	 * 
	 * @return
	 */
	public static final SafariOptions getSafarioptionsObject() {

		SafariOptions safariOptions = new SafariOptions();
		safariOptions.setCapability("headless", true);
		safariOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		safariOptions.setImplicitWaitTimeout(Duration.ofSeconds(10));

		return safariOptions;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @return
	 */
	public static final WebDriver getBrowserWebdriverLocal(String propertiesFilePath) {

		WebDriver driver = null;

		if (System.getProperty(System.getProperty(commonJavaUtility.getPropertyValue(
				commonJavaUtility.createPropertiesObject(propertiesFilePath), "GoogleWebDriverName"))) != null) {

			driver = new ChromeDriver(getChromeoptionsObject());

		} else if (System.getProperty(System.getProperty(commonJavaUtility.getPropertyValue(
				commonJavaUtility.createPropertiesObject(propertiesFilePath), "EdgeWebDriverName"))) != null) {

			driver = new EdgeDriver(getEdgeoptionsObject());

		} else if (System.getProperty(System.getProperty(commonJavaUtility.getPropertyValue(
				commonJavaUtility.createPropertiesObject(propertiesFilePath), "SafariWebDriverName"))) != null) {

			driver = new SafariDriver(getSafarioptionsObject());

		}

		return driver;
	}

	/**
	 * 
	 * @param seleniumRemote
	 * @param browser
	 * @return
	 */
	public static final WebDriver getBrowserWebdriverRemote(URL seleniumRemote, String browser) {

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome")) {

			driver = new RemoteWebDriver(seleniumRemote, getChromeoptionsObject());

		} else if (browser.equalsIgnoreCase("Edge")) {

			driver = new RemoteWebDriver(seleniumRemote, getEdgeoptionsObject());

		} else if (browser.equalsIgnoreCase("Safari")) {

			driver = new RemoteWebDriver(seleniumRemote, getSafarioptionsObject());

		}

		return driver;
	}

	/**
	 * 
	 * @param driver
	 * @param seconds
	 * @return
	 */
	public static final WebDriverWait getwebDriverExplicitWaitObject(WebDriver driver, Long seconds) {

		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		return explicitWait;
	}

	/**
	 * 
	 * @param driver
	 * @param seconds
	 * @return
	 */
	public static final Wait<WebDriver> getwebDriverFluentWaitObject(WebDriver driver, Long seconds) {

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(seconds))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

		return fluentWait;
	}

	/**
	 * 
	 * @param driver
	 * @param targetFilePath
	 * @return
	 */
	public static final Boolean getDriverScreenshot(WebDriver driver, String targetFilePath) {

		boolean fileSaved = true;

		try {
			File driverCapture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(driverCapture,
					new File(targetFilePath + "driverCapture_" + System.currentTimeMillis() + ".png"));

			fileSaved = driverCapture.exists();
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return fileSaved;
	}

	/**
	 * 
	 * @param driver
	 * @param idLocatorValue
	 * @param targetFilePath
	 * @return
	 */
	public static final Boolean getElementScreenshot(WebDriver driver, String idLocatorValue, String targetFilePath) {

		boolean fileSaved = true;

		try {
			File elementCapture = ((TakesScreenshot) driver.findElement(By.id(idLocatorValue)))
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(elementCapture,
					new File(targetFilePath + "elementCapture_" + System.currentTimeMillis() + ".png"));

			fileSaved = elementCapture.exists();
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return fileSaved;
	}
}
