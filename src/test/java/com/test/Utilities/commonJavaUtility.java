/**
 * 
 */
package com.test.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author VarunDevSinha (press ctrl + O)
 *
 */
public class commonJavaUtility {

	static Logger logthisclass = LogManager.getLogger();

	/**
	 * 
	 * @param propertiesFilePath
	 * @return
	 */
	public final static Properties createPropertiesObject(String propertiesFilePath) {

		Properties commonProperties = new Properties();

		File specificPropertiesFile = new File(propertiesFilePath);

		try {
			FileInputStream specificPropertiesFileIS = new FileInputStream(specificPropertiesFile);

			commonProperties.load(specificPropertiesFileIS);
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully ! **********");
		}

		return commonProperties;
	}

	/**
	 * 
	 * @param propertiesObject
	 * @param propertyKey
	 * @param propertyValueType
	 * @return
	 */
	public final static String getPropertyValue(Properties propertiesObject, String propertyKey) {

		String propertyValue = propertiesObject.getProperty(propertyKey);
		return propertyValue;

	}

	/**
	 * 
	 * @param xlsxFilePath
	 * @param columnHeader
	 * @return
	 */
	public static final ArrayList<Object> getSingleColumnList(String xlsxFilePath, String columnHead) {

		ArrayList<Object> xlsxSingleColumn = new ArrayList<Object>();

		try {
			XSSFWorkbook xlsxWorkbook = new XSSFWorkbook(new File(xlsxFilePath));
			XSSFSheet xlsxSheet = xlsxWorkbook.getSheetAt(0);

			for (int r = 0; r < xlsxSheet.getLastRowNum(); r++) {
				XSSFRow datRow = xlsxSheet.getRow(r);
				for (int c = 0; c < datRow.getLastCellNum(); c++) {
					if (xlsxSheet.getRow(0).getCell(c).toString().equalsIgnoreCase(columnHead)) {
						xlsxSingleColumn.add(datRow.getCell(c).toString());
					}
				}
			}

			xlsxWorkbook.close();

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return xlsxSingleColumn;
	}

	/**
	 * 
	 * @param xlsxFilePath
	 * @param rowHeader
	 * @return
	 */
	public static final ArrayList<Object> getSingleRowList(String xlsxFilePath, String rowHead) {

		ArrayList<Object> xlsxSingleRow = new ArrayList<Object>();

		try {
			XSSFWorkbook xlsxWorkbook = new XSSFWorkbook(new File(xlsxFilePath));
			XSSFSheet xlsxSheet = xlsxWorkbook.getSheetAt(0);

			for (int r = 0; r < xlsxSheet.getLastRowNum(); r++) {
				XSSFRow dataRow = xlsxSheet.getRow(r);
				if (dataRow.getCell(0).toString().equalsIgnoreCase(rowHead)) {
					for (int c = 0; c < dataRow.getLastCellNum(); c++) {
						xlsxSingleRow.add(dataRow.getCell(c).toString());
					}
				}
			}

			xlsxWorkbook.close();

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return xlsxSingleRow;
	}

	/**
	 * 
	 * @param xlsxFilePath
	 * @param sheetName
	 * @param blankArray
	 * @return
	 */
	public static final Object[][] getSingleSheetArray2D(String xlsxFilePath, String sheetName, Object[][] blankArray) {

		Object[][] xlsxSingleSheet = blankArray;

		try {
			XSSFWorkbook xlsxWorkbook = new XSSFWorkbook(new File(xlsxFilePath));
			XSSFSheet xlsxSheet = xlsxWorkbook.getSheet(sheetName);

			xlsxSingleSheet = new Object[xlsxSheet.getLastRowNum()][xlsxSheet.getRow(0).getLastCellNum()];

			for (int r = 0; r < xlsxSheet.getLastRowNum(); r++) {
				XSSFRow dataRow = xlsxSheet.getRow(r);
				for (int c = 0; c < dataRow.getLastCellNum(); c++) {
					XSSFCell cellValue = dataRow.getCell(c);
					xlsxSingleSheet[r][c] = cellValue.toString();
				}
			}

			xlsxWorkbook.close();

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return xlsxSingleSheet;
	}

	/**
	 * 
	 * @param xlsxFilePath
	 * @param sheetName
	 * @param searchReference
	 * @param rowHead
	 * @param columnHead
	 * @return
	 */
	public static final Object getSingleCellValue(String xlsxFilePath, String sheetName, String searchReference,
			String rowHead, String columnHead) {

		Object cellValue = null;

		try {
			XSSFWorkbook xlsxWorkbook = new XSSFWorkbook(new File(xlsxFilePath));
			XSSFSheet xlsxSheet = xlsxWorkbook.getSheet(sheetName);

			int searchRowNum = 0;
			int searchCellNum = 0;

			// Get the cellNumber and searchCellNum (Y axis)
			XSSFRow headRow = xlsxSheet.getRow(0);
			for (int cellNum = 0; cellNum < headRow.getLastCellNum(); cellNum++) {
				if (headRow.getCell(cellNum).toString().equalsIgnoreCase(searchReference)) {
					searchRowNum = cellNum;
				}

				if (headRow.getCell(cellNum).toString().equalsIgnoreCase(columnHead)) {
					searchCellNum = cellNum;
				}
			}

			// Go to specific row, and get the cellValue.
			for (int r = 1; r < xlsxSheet.getLastRowNum(); r++) {
				XSSFRow dataRow = xlsxSheet.getRow(r);
				if (dataRow.getCell(searchRowNum).toString().equalsIgnoreCase(rowHead)) {
					cellValue = dataRow.getCell(searchCellNum).toString();

				}
			}

			xlsxWorkbook.close();

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return cellValue;
	}
}
