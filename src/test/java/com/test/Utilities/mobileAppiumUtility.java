/**
 * 
 */
package com.test.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * @author VarunDevSinha (press ctrl + O)
 *
 */
public class mobileAppiumUtility {

	/**
	 * 
	 * @param propertiesFilePath
	 * @return
	 */
	public static final AppiumDriverLocalService setAppiumEnvironmentUpLocally(String propertiesFilePath) {

		Properties configProperties = commonJavaUtility.createPropertiesObject(propertiesFilePath);

		AppiumDriverLocalService appiumDriverLocalService = new AppiumServiceBuilder()
				.withAppiumJS(new File(commonJavaUtility.getPropertyValue(configProperties, "AppiumJSfilePath")))
				.withIPAddress(commonJavaUtility.getPropertyValue(configProperties, "AppiumServerIPaddress"))
				.usingPort(Integer.parseInt(commonJavaUtility.getPropertyValue(configProperties, "AppiumServerPort")))
				.build();

		return appiumDriverLocalService;
	}

	/**
	 * 
	 * @param appiumDriverLocalService
	 * @return
	 */
	public static final String startAppiumEnvironmentLocally(AppiumDriverLocalService appiumDriverLocalService) {

		appiumDriverLocalService.start();

		String appiumStatus = null;
		if (appiumDriverLocalService.isRunning()) {
			appiumStatus = "Appium local service started successfully.";
		} else {

		}

		return appiumStatus;
	}

	/**
	 * 
	 * @param appiumDriverLocalService
	 * @return
	 */
	public static final String stopAppiumEnvironmentLocally(AppiumDriverLocalService appiumDriverLocalService) {

		appiumDriverLocalService.stop();

		String appiumStatus = null;
		if (!appiumDriverLocalService.isRunning()) {
			appiumStatus = "Appium local service stopped successfully.";
		} else {

		}

		return appiumStatus;
	}

	/**
	 * 
	 * @param batchFilePath
	 * @param batchFileName
	 */
	public static final StringBuilder runBatchFile(String batchFilePath, String batchFileName) {

		ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c",
				"cd " + batchFilePath + "\\ && " + batchFileName + ".bat");

		StringBuilder stringBuilder = new StringBuilder();

		try {
			processBuilder.redirectErrorStream(true);
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while (true) {
				line = reader.readLine();
				if (line == null) {
					break;
				}
			}
			stringBuilder.append(line);

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return stringBuilder;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @return
	 */
	public static final UiAutomator2Options getAndroidOptions(String propertiesFilePath) {

		Properties configProperties = commonJavaUtility.createPropertiesObject(propertiesFilePath);

		UiAutomator2Options androidOptions = new UiAutomator2Options();
		androidOptions.setAutomationName(commonJavaUtility.getPropertyValue(configProperties, "AndroidAutomationName"));

		return androidOptions;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @return
	 */
	public static final XCUITestOptions getIosOptions(String propertiesFilePath) {

		Properties configProperties = commonJavaUtility.createPropertiesObject(propertiesFilePath);

		XCUITestOptions iosOptions = new XCUITestOptions();
		iosOptions.setAutomationName(commonJavaUtility.getPropertyValue(configProperties, "IosAutomationName"));

		return iosOptions;
	}

	/**
	 * 
	 * @param appiumDriverLocalService
	 * @param androidOptions
	 * @return
	 */
	public static final AndroidDriver getLocalAndroidDriver(AppiumDriverLocalService appiumDriverLocalService,
			UiAutomator2Options androidOptions) {

		AndroidDriver androidDriver = new AndroidDriver(appiumDriverLocalService, androidOptions);
		return androidDriver;
	}

	/**
	 * 
	 * @param appiumRemote
	 * @param androidOptions
	 * @return
	 */
	public static final AndroidDriver getRemoteAndroidDriver(URL appiumRemote, UiAutomator2Options androidOptions) {

		AndroidDriver androidDriver = new AndroidDriver(appiumRemote, androidOptions);
		return androidDriver;
	}

	/**
	 * 
	 * @param androidDriver
	 */
	public static final void setAndroidDriverSessionDown(AndroidDriver androidDriver) {

		Set<String> browserWindows = androidDriver.getWindowHandles();

		for (String windowHandle : browserWindows) {
			if (browserWindows.size() > 1) {
				androidDriver.switchTo().window(windowHandle).close();
			} else {
				androidDriver.quit();
			}
		}
	}

	/**
	 * 
	 * @param appiumDriverLocalService
	 * @param iosOptions
	 * @return
	 */
	public static final IOSDriver getLocalIOSDriver(AppiumDriverLocalService appiumDriverLocalService,
			XCUITestOptions iosOptions) {

		IOSDriver iosDriver = new IOSDriver(appiumDriverLocalService, iosOptions);
		return iosDriver;
	}

	/**
	 * 
	 * @param appiumRemote
	 * @param iosOptions
	 * @return
	 */
	public static final IOSDriver getRemoteIOSDriver(URL appiumRemote, XCUITestOptions iosOptions) {

		IOSDriver iosDriver = new IOSDriver(appiumRemote, iosOptions);
		return iosDriver;
	}

	/**
	 * 
	 * @param iosDriver
	 */
	public static final void setIosDriverSessionDown(IOSDriver iosDriver) {

		Set<String> browserWindows = iosDriver.getWindowHandles();

		for (String windowHandle : browserWindows) {
			if (browserWindows.size() > 1) {
				iosDriver.switchTo().window(windowHandle).close();
			} else {
				iosDriver.quit();
			}
		}
	}
}
