/**
 * 
 */
package com.test.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author VarunDevSinha (press ctrl + O)
 *
 */

public class reportUtility {

	/**
	 * 
	 * @param htmlReportOutputPath
	 * @return
	 */
	public static final ExtentReports getReportEngineSparkReport(String htmlReportOutputPath) {

		ExtentReports reportEngine = new ExtentReports();
		ExtentSparkReporter spartReporter = new ExtentSparkReporter(htmlReportOutputPath);
		reportEngine.attachReporter(spartReporter);

		return reportEngine;
	}

	/**
	 * 
	 * @param reportEngine
	 * @param testName
	 * @param logStatus
	 */
	public static final void executeTestGetReport(ExtentReports reportEngine, String testName, String logLevel) {

		ExtentTest extentTest = reportEngine.createTest(testName).assignAuthor("Varun Dev Sinha")
				.assignCategory("Regression").assignDevice("Windows PC");

		switch (logLevel) {
		case "PASS":
			extentTest.pass("<b>The test case log at PASS level.</b>");
			break;
		case "FAIL":
			extentTest.fail("<i>The test case log at FAIL level.</i>");
			break;
		case "SKIP":
			extentTest.skip("<b>The test case log at SKIP level.</b>");
			break;
		case "WARNING":
			extentTest.warning("<i>The test case log at WARNING level.</i>");
			break;
		case "INFO":
			extentTest.info("<b><i>The test case log at INFO level.</i></b>");
			break;
		default:
			System.out.println("Give logStatus as: PASS / FAIL / SKIP / WARNING / INFO.");
		}

		reportEngine.flush();

	}

	/**
	 * 
	 * @param reportEngine
	 * @param testName
	 * @param logStatus
	 * @param throwableException
	 */
	public static final void executeTestGetReportexceptions(ExtentReports reportEngine, String testName,
			String logLevel, Throwable throwableException) {

		ExtentTest extentTest = reportEngine.createTest(testName).assignAuthor("Varun Dev Sinha")
				.assignCategory("Regression").assignDevice("Windows PC").info(throwableException);

		switch (logLevel) {
		case "PASS":
			extentTest.pass(throwableException);
			break;
		case "FAIL":
			extentTest.fail(throwableException);
			break;
		case "SKIP":
			extentTest.skip(throwableException);
			break;
		case "WARNING":
			extentTest.warning(throwableException);
			break;
		case "INFO":
			extentTest.info(throwableException);
			break;
		default:
			System.out.println(throwableException);
		}

		reportEngine.flush();

	}

	/**
	 * 
	 * @param reportEngine
	 * @param testName
	 * @param logStatus
	 * @param jsonString
	 */
	public static final void executeTestGetReportjsondata(ExtentReports reportEngine, String testName, String logLevel,
			String jsonString) {

		ExtentTest extentTest = reportEngine.createTest(testName).assignAuthor("Varun Dev Sinha")
				.assignCategory("Regression").assignDevice("Windows PC");

		switch (logLevel) {
		case "PASS":
			extentTest.log(Status.PASS, MarkupHelper.createCodeBlock(jsonString, CodeLanguage.JSON));
			break;
		case "FAIL":
			extentTest.log(Status.FAIL, MarkupHelper.createCodeBlock(jsonString, CodeLanguage.JSON));
			break;
		case "SKIP":
			extentTest.log(Status.SKIP, MarkupHelper.createCodeBlock(jsonString, CodeLanguage.JSON));
			break;
		case "WARNING":
			extentTest.log(Status.WARNING, MarkupHelper.createCodeBlock(jsonString, CodeLanguage.JSON));
			break;
		case "INFO":
			extentTest.log(Status.INFO, MarkupHelper.createCodeBlock(jsonString, CodeLanguage.JSON));
			break;
		default:
			System.out.println("Give logStatus as: PASS / FAIL / SKIP / WARNING / INFO.");
		}

		reportEngine.flush();
	}

	/**
	 * 
	 * @param reportEngine
	 * @param testName
	 * @param logStatus
	 * @param xmlString
	 */
	public static final void executeTestGetReportxmldata(ExtentReports reportEngine, String testName, String logLevel,
			String xmlString) {

		ExtentTest extentTest = reportEngine.createTest(testName).assignAuthor("Varun Dev Sinha")
				.assignCategory("Regression").assignDevice("Windows PC");

		switch (logLevel) {
		case "PASS":
			extentTest.log(Status.PASS, MarkupHelper.createCodeBlock(xmlString, CodeLanguage.XML));
			break;
		case "FAIL":
			extentTest.log(Status.FAIL, MarkupHelper.createCodeBlock(xmlString, CodeLanguage.XML));
			break;
		case "SKIP":
			extentTest.log(Status.SKIP, MarkupHelper.createCodeBlock(xmlString, CodeLanguage.XML));
			break;
		case "WARNING":
			extentTest.log(Status.WARNING, MarkupHelper.createCodeBlock(xmlString, CodeLanguage.XML));
			break;
		case "INFO":
			extentTest.log(Status.INFO, MarkupHelper.createCodeBlock(xmlString, CodeLanguage.XML));
			break;
		default:
			System.out.println("Give logStatus as: PASS / FAIL / SKIP / WARNING / INFO.");
		}

		reportEngine.flush();

	}

	/**
	 * 
	 * @param reportEngine
	 * @param testName
	 * @param logStatus
	 * @param collectionObject
	 */
	public static final void executeTestGetReportcollectiondata(ExtentReports reportEngine, String testName,
			String logLevel, Object collectionObject) {

		ExtentTest extentTest = reportEngine.createTest(testName).assignAuthor("Varun Dev Sinha")
				.assignCategory("Regression").assignDevice("Windows PC");

		switch (logLevel) {
		case "PASS":
			extentTest.log(Status.PASS, MarkupHelper.createOrderedList(collectionObject));
			break;
		case "FAIL":
			extentTest.log(Status.FAIL, MarkupHelper.createOrderedList(collectionObject));
			break;
		case "SKIP":
			extentTest.log(Status.SKIP, MarkupHelper.createOrderedList(collectionObject));
			break;
		case "WARNING":
			extentTest.log(Status.WARNING, MarkupHelper.createOrderedList(collectionObject));
			break;
		case "INFO":
			extentTest.log(Status.INFO, MarkupHelper.createOrderedList(collectionObject));
			break;
		default:
			System.out.println("Give logStatus as: PASS / FAIL / SKIP / WARNING / INFO.");
		}

		reportEngine.flush();

	}

	/**
	 * 
	 * @param reportEngine
	 * @param testName
	 * @param logLevel
	 * @param base64Code
	 */
	public static final void executeTestGetReportScreenshotWithoutpreview(ExtentReports reportEngine, String testName,
			String logLevel, String base64Code) {

		ExtentTest extentTest = reportEngine.createTest(testName).assignAuthor("Varun Dev Sinha")
				.assignCategory("Regression").assignDevice("Windows PC");

		switch (logLevel) {
		case "PASS":
			extentTest.pass("").addScreenCaptureFromBase64String(base64Code, "Image Title1");
			break;
		case "FAIL":
			extentTest.fail("").addScreenCaptureFromBase64String(base64Code, "Image Title2");
			break;
		case "SKIP":
			extentTest.skip("").addScreenCaptureFromBase64String(base64Code, "Image Title3");
			break;
		case "WARNING":
			extentTest.warning("").addScreenCaptureFromBase64String(base64Code, "Image Title4");
			break;
		case "INFO":
			extentTest.info("").addScreenCaptureFromBase64String(base64Code, "Image Title5");
			break;
		default:
			System.out.println("Give logStatus as: PASS / FAIL / SKIP / WARNING / INFO.");
		}

		reportEngine.flush();

	}

	/**
	 * 
	 * @param reportEngine
	 * @param testName
	 * @param logLevel
	 * @param imagePath
	 */
	public static final void executeTestGetReportScreenshotWithpreview(ExtentReports reportEngine, String testName,
			String logLevel, String imagePath) {

		ExtentTest extentTest = reportEngine.createTest(testName).assignAuthor("Varun Dev Sinha")
				.assignCategory("Regression").assignDevice("Windows PC");

		switch (logLevel) {
		case "PASS":
			extentTest.pass("").addScreenCaptureFromPath(imagePath, "Image Title1");
			break;
		case "FAIL":
			extentTest.fail("").addScreenCaptureFromPath(imagePath, "Image Title2");
			break;
		case "SKIP":
			extentTest.skip("").addScreenCaptureFromPath(imagePath, "Image Title3");
			break;
		case "WARNING":
			extentTest.warning("").addScreenCaptureFromPath(imagePath, "Image Title4");
			break;
		case "INFO":
			extentTest.info("").addScreenCaptureFromPath(imagePath, "Image Title5");
			break;
		default:
			System.out.println("Give logStatus as: PASS / FAIL / SKIP / WARNING / INFO.");
		}

		reportEngine.flush();

	}
}
