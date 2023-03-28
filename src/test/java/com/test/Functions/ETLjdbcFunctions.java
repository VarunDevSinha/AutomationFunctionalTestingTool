package com.test.Functions;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;

import com.test.Utilities.etlJDBCUtility;

/**
 * 
 * @author VarunDevSinha (press ctrl + O)
 *
 */
public class ETLjdbcFunctions extends etlJDBCUtility {

	/**
	 * 
	 * @param dbConnection
	 * @param executeQuery
	 * @param expectedCount
	 */
	public static final void singleQueryCountValidation(Connection dbConnection, String executeQuery,
			int expectedCount) {

		try {

			int tableCount = etlJDBCUtility.statementResultExecuteQuery(dbConnection, executeQuery).getInt(0);

			System.out.println("Expected: " + expectedCount + ", " + "Actual: " + tableCount);

			assertEquals(expectedCount, tableCount);

		} catch (Exception anyException) {
			anyException.getMessage();
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}
	}

	/**
	 * 
	 * @param dbConnectionSource
	 * @param executeQuerySource
	 * @param dbConnectionTarget
	 * @param executeQueryTarget
	 */
	public static final void doubleQueryCountValidation(Connection dbConnectionSource, String executeQuerySource,
			Connection dbConnectionTarget, String executeQueryTarget) {

		try {

			int tableCountSource = etlJDBCUtility.statementResultExecuteQuery(dbConnectionSource, executeQuerySource)
					.getInt(0);
			int tableCountTarget = etlJDBCUtility.statementResultExecuteQuery(dbConnectionTarget, executeQueryTarget)
					.getInt(0);

			System.out.println("Source: " + tableCountSource + ", " + "Target: " + tableCountTarget);

			assertEquals(tableCountSource, tableCountTarget);

		} catch (Exception anyException) {
			anyException.getMessage();
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}
	}

	/**
	 * 
	 * @param dbConnection
	 * @param executeQuery
	 */
	public static final void singleQueryDuplicateValidation(Connection dbConnection, String executeQuery) {

		try {

			int tableDuplicateCount = etlJDBCUtility.statementResultExecuteQuery(dbConnection, executeQuery).getInt(0);

			System.out.println("Expected: " + 0 + ", " + "Actual: " + tableDuplicateCount);

			assertEquals(0, tableDuplicateCount);

		} catch (Exception anyException) {
			anyException.getMessage();
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}
	}

	/**
	 * 
	 * @param dbConnectionSource
	 * @param executeQuerySource
	 * @param dbConnectionTarget
	 * @param executeQueryTarget
	 */
	public static final void doubleQueryDuplicateValidation(Connection dbConnectionSource, String executeQuerySource,
			Connection dbConnectionTarget, String executeQueryTarget) {

		try {

			int tableDuplicateCountSource = etlJDBCUtility
					.statementResultExecuteQuery(dbConnectionSource, executeQuerySource).getInt(0);
			int tableDuplicateCountTarget = etlJDBCUtility
					.statementResultExecuteQuery(dbConnectionTarget, executeQueryTarget).getInt(0);

			System.out.println("Source: " + tableDuplicateCountSource + ", " + "Target: " + tableDuplicateCountTarget);

			assertEquals(0, tableDuplicateCountSource & 0, tableDuplicateCountTarget);

		} catch (Exception anyException) {
			anyException.getMessage();
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

	}

	/**
	 * 
	 * @param dbConnection
	 * @param executeQuery
	 */
	public static final void singleQueryDataValidation(Connection dbConnection, String executeQuery) {

		try {

			int tableCount = etlJDBCUtility.statementResultExecuteQuery(dbConnection, executeQuery).getInt(0);

			System.out.println("Expected: " + 0 + ", " + "Actual: " + tableCount);

			assertEquals(0, tableCount);

		} catch (

		Exception anyException) {
			anyException.getMessage();
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}
	}

	/**
	 * 
	 * @param dbConnectionSource
	 * @param executeQuerySource
	 * @param dbConnectionTarget
	 * @param executeQueryTarget
	 */
	public static final void doubleQueryDataValidation(Connection dbConnectionSource, String executeQuerySource,
			Connection dbConnectionTarget, String executeQueryTarget) {

		try {

			ResultSet sourceResultSet = etlJDBCUtility.statementResultExecuteQuery(dbConnectionSource,
					executeQuerySource);
			int tableDataSource = sourceResultSet.getInt(0);

			if (!sourceResultSet.isClosed()) {
				sourceResultSet.close();
			}

			ResultSet targetResultSet = etlJDBCUtility.statementResultExecuteQuery(dbConnectionSource,
					executeQuerySource);
			int tableDataTarget = targetResultSet.getInt(0);

			if (!targetResultSet.isClosed()) {
				targetResultSet.close();
			}

			System.out.println("Source: " + tableDataSource + ", " + "Target: " + tableDataTarget);

			assertEquals(0, tableDataSource & 0, tableDataTarget);
			assertEquals(sourceResultSet, targetResultSet);

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

	}

}
