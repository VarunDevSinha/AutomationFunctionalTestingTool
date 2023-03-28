/**
 * 
 */
package com.test.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author VarunDevSinha (press ctrl + O)
 */
public class etlJDBCUtility {

	/**
	 * 
	 * @param propertiesFilePath
	 * @param databaseName
	 * @return
	 */
	public static final Connection startDbConnection(String propertiesFilePath, String databaseName) {

		Properties configProperties = commonJavaUtility.createPropertiesObject(propertiesFilePath);

		Connection dbConnection = null;

		try {
			switch (databaseName) {
			case "MySQL":
				Class.forName("com.mysql.jdbc.Driver");
				// Class.forName(commonJavaUtility.getPropertyValue(configProperties,
				// "MySQLDriverName"));
				dbConnection = DriverManager.getConnection(
						commonJavaUtility.getPropertyValue(configProperties, "MySQLurl"),
						commonJavaUtility.getPropertyValue(configProperties, "MySQLuserId"),
						commonJavaUtility.getPropertyValue(configProperties, "MySQLuserPassword"));
				break;
			case "Hive":
				Class.forName("org.apache.hive.jdbc.HiveDriver");
				// Class.forName(commonJavaUtility.getPropertyValue(configProperties,
				// "HiveDriverName"));
				dbConnection = DriverManager.getConnection(
						commonJavaUtility.getPropertyValue(configProperties, "Hiveurl"),
						commonJavaUtility.getPropertyValue(configProperties, "HiveuserId"),
						commonJavaUtility.getPropertyValue(configProperties, "HiveuserPassword"));
				break;
			case "Oracle":
				Class.forName("org.jdbc.Driver.OracleDriver");
				// Class.forName(commonJavaUtility.getPropertyValue(configProperties,
				// "OracleDriverName"));
				dbConnection = DriverManager.getConnection(
						commonJavaUtility.getPropertyValue(configProperties, "Oracleurl"),
						commonJavaUtility.getPropertyValue(configProperties, "OracleuserId"),
						commonJavaUtility.getPropertyValue(configProperties, "OracleuserPassword"));
				break;
			default:
				System.out.println();
			}
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return dbConnection;
	}

	/**
	 * 
	 * @param dbConnection
	 */
	public static final void endDbConnection(Connection dbConnection) {

		try {
			dbConnection.close();
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}
	}

	/**
	 * 
	 * @param dbConnection
	 * @param executeQuery
	 * @return
	 */
	public static final ResultSet statementResultExecuteQuery(Connection dbConnection, String executeQuery) {

		// Fetch from database

		ResultSet queryResult = null;

		try {
			queryResult = dbConnection.createStatement().executeQuery(executeQuery);

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return queryResult;
	}

	/**
	 * 
	 * @param dbConnection
	 * @param updateQuery
	 * @param executeQuery
	 * @return
	 */
	public static final ResultSet statementResultExecuteUpdate(Connection dbConnection, String updateQuery,
			String executeQuery) {

		// Insert or Update database

		ResultSet queryResult = null;

		try {
			System.out.println("Update qruery executed successfuly, with updated row counts: "
					+ dbConnection.createStatement().executeUpdate(updateQuery));
			queryResult = dbConnection.createStatement().executeQuery(executeQuery);

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return queryResult;
	}

	/**
	 * 
	 * @param dbResult
	 * @return
	 */
	public static final ResultSetMetaData getResultsetMetadata(ResultSet dbResult) {

		ResultSetMetaData queryResultMetaData = null;

		try {
			queryResultMetaData = dbResult.getMetaData();
			if (!dbResult.isClosed()) {
				dbResult.close();
			}

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return queryResultMetaData;
	}

	/**
	 * 
	 * @param dbConnection
	 * @param executeQuery
	 * @return
	 */
	public static final HashMap<String, Object> getResultsetWithMetadataSingleExecuteQuerySameDB(
			Connection dbConnection, String executeQuery) {

		HashMap<String, Object> executeQueryOutput1One = new HashMap<String, Object>();

		try {

			ResultSet executeQueryResultSet = dbConnection.createStatement().executeQuery(executeQuery);
			executeQueryOutput1One.put("ResultSet", executeQueryResultSet);

			ResultSetMetaData executeQueryResultMetaData = executeQueryResultSet.getMetaData();
			executeQueryOutput1One.put("ResultSetMetadata", executeQueryResultMetaData);

			if (!executeQueryResultSet.isClosed()) {
				executeQueryResultSet.close();
			}

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return executeQueryOutput1One;
	}

	/**
	 * 
	 * @param dbConnection
	 * @param updateQuery
	 * @param executeQuery
	 * @return
	 */
	public static final HashMap<String, Object> getResultsetWithMetadataSingleUpdateQuerySameDB(Connection dbConnection,
			String updateQuery, String executeQuery) {

		HashMap<String, Object> updateQueryOutput1One = new HashMap<String, Object>();

		try {

			System.out.println("Update qruery executed successfuly, with updated row counts: "
					+ dbConnection.createStatement().executeUpdate(updateQuery));

			ResultSet executeQueryResultSet = dbConnection.createStatement().executeQuery(executeQuery);
			updateQueryOutput1One.put("ResultSet", executeQueryResultSet);

			ResultSetMetaData executeQueryResultMetaData = executeQueryResultSet.getMetaData();
			updateQueryOutput1One.put("ResultSetMetadata", executeQueryResultMetaData);

			if (!executeQueryResultSet.isClosed()) {
				executeQueryResultSet.close();
			}

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return updateQueryOutput1One;
	}

	/**
	 * 
	 * @param dbConnection
	 * @param executeQueryOne
	 * @param executeQueryTwo
	 * @return
	 */
	public static final HashMap<String, Object> getResultsetWithMetadataDoubleExecuteQuerySameDB(
			Connection dbConnection, String executeQueryOne, String executeQueryTwo) {

		HashMap<String, Object> executeQueryOutput2One = new HashMap<String, Object>();

		try {

			ResultSet executeQueryOneResultSet = dbConnection.createStatement().executeQuery(executeQueryOne);
			executeQueryOutput2One.put("ResultSetOne", executeQueryOneResultSet);

			ResultSetMetaData executeQueryOneResultMetaData = executeQueryOneResultSet.getMetaData();
			executeQueryOutput2One.put("ResultSetMetadataOne", executeQueryOneResultMetaData);

			if (!executeQueryOneResultSet.isClosed()) {
				executeQueryOneResultSet.close();
			}

			ResultSet executeQueryTwoResultSet = dbConnection.createStatement().executeQuery(executeQueryTwo);
			executeQueryOutput2One.put("ResultSetTwo", executeQueryTwoResultSet);

			ResultSetMetaData executeQueryTwoResultMetaData = executeQueryTwoResultSet.getMetaData();
			executeQueryOutput2One.put("ResultSetMetadataTwo", executeQueryTwoResultMetaData);

			if (!executeQueryTwoResultSet.isClosed()) {
				executeQueryTwoResultSet.close();
			}

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return executeQueryOutput2One;
	}

	/**
	 * 
	 * @param dbConnectionOne
	 * @param executeQueryOne
	 * @param dbConnectionTwo
	 * @param executeQueryTwo
	 * @return
	 */
	public static final HashMap<String, Object> getResultsetWithMetadataDoubleExecuteQueryDifferentDB(
			Connection dbConnectionOne, String executeQueryOne, Connection dbConnectionTwo, String executeQueryTwo) {

		HashMap<String, Object> executeQueryOutput2Two = new HashMap<String, Object>();

		try {

			ResultSet executeQueryOneResultSet = dbConnectionOne.createStatement().executeQuery(executeQueryOne);
			executeQueryOutput2Two.put("ResultSetOne", executeQueryOneResultSet);

			ResultSetMetaData executeQueryOneResultMetaData = executeQueryOneResultSet.getMetaData();
			executeQueryOutput2Two.put("ResultSetMetadataOne", executeQueryOneResultMetaData);

			if (!executeQueryOneResultSet.isClosed()) {
				executeQueryOneResultSet.close();
			}

			ResultSet executeQueryTwoResultSet = dbConnectionTwo.createStatement().executeQuery(executeQueryTwo);
			executeQueryOutput2Two.put("ResultSetTwo", executeQueryTwoResultSet);

			ResultSetMetaData executeQueryTwoResultMetaData = executeQueryTwoResultSet.getMetaData();
			executeQueryOutput2Two.put("ResultSetMetadataTwo", executeQueryTwoResultMetaData);

			if (!executeQueryTwoResultSet.isClosed()) {
				executeQueryTwoResultSet.close();
			}

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return executeQueryOutput2Two;
	}

	/**
	 * 
	 * @param dbConnection
	 * @param updateQueryOne
	 * @param executeQueryOne
	 * @param updateQueryTwo
	 * @param executeQueryTwo
	 * @return
	 */
	public static final HashMap<String, Object> getResultsetWithMetadataDoubleUpdateQuerySameDB(Connection dbConnection,
			String updateQueryOne, String executeQueryOne, String updateQueryTwo, String executeQueryTwo) {

		HashMap<String, Object> updateQueryOutput2One = new HashMap<String, Object>();

		try {

			System.out.println("Update qruery executed successfuly, with updated row counts: "
					+ dbConnection.createStatement().executeUpdate(updateQueryOne));

			ResultSet executeQueryOneResultSet = dbConnection.createStatement().executeQuery(executeQueryOne);
			updateQueryOutput2One.put("ResultSetOne", executeQueryOneResultSet);

			ResultSetMetaData executeQueryOneResultMetaData = executeQueryOneResultSet.getMetaData();
			updateQueryOutput2One.put("ResultSetMetadataOne", executeQueryOneResultMetaData);

			if (!executeQueryOneResultSet.isClosed()) {
				executeQueryOneResultSet.close();
			}

			System.out.println("Update qruery executed successfuly, with updated row counts: "
					+ dbConnection.createStatement().executeUpdate(updateQueryTwo));

			ResultSet executeQueryTwoResultSet = dbConnection.createStatement().executeQuery(executeQueryTwo);
			updateQueryOutput2One.put("ResultSetTwo", executeQueryTwoResultSet);

			ResultSetMetaData executeQueryTwoResultMetaData = executeQueryTwoResultSet.getMetaData();
			updateQueryOutput2One.put("ResultSetMetadataTwo", executeQueryTwoResultMetaData);

			if (!executeQueryTwoResultSet.isClosed()) {
				executeQueryTwoResultSet.close();
			}

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return updateQueryOutput2One;
	}

	/**
	 * 
	 * @param dbConnectionOne
	 * @param updateQueryOne
	 * @param executeQueryOne
	 * @param dbConnectionTwo
	 * @param updateQueryTwo
	 * @param executeQueryTwo
	 * @return
	 */
	public static final HashMap<String, Object> getResultsetWithMetadataDoubleUpdateQueryDifferentDB(
			Connection dbConnectionOne, String updateQueryOne, String executeQueryOne, Connection dbConnectionTwo,
			String updateQueryTwo, String executeQueryTwo) {

		HashMap<String, Object> updateQueryOutput2Two = new HashMap<String, Object>();

		try {

			System.out.println("Update qruery executed successfuly, with updated row counts: "
					+ dbConnectionOne.createStatement().executeUpdate(updateQueryOne));

			ResultSet executeQueryOneResultSet = dbConnectionOne.createStatement().executeQuery(executeQueryOne);
			updateQueryOutput2Two.put("ResultSetOne", executeQueryOneResultSet);

			ResultSetMetaData executeQueryOneResultMetaData = executeQueryOneResultSet.getMetaData();
			updateQueryOutput2Two.put("ResultSetMetadataOne", executeQueryOneResultMetaData);

			if (!executeQueryOneResultSet.isClosed()) {
				executeQueryOneResultSet.close();
			}

			System.out.println("Update qruery executed successfuly, with updated row counts: "
					+ dbConnectionTwo.createStatement().executeUpdate(updateQueryTwo));

			ResultSet executeQueryTwoResultSet = dbConnectionTwo.createStatement().executeQuery(executeQueryTwo);
			updateQueryOutput2Two.put("ResultSetTwo", executeQueryTwoResultSet);

			ResultSetMetaData executeQueryTwoResultMetaData = executeQueryTwoResultSet.getMetaData();
			updateQueryOutput2Two.put("ResultSetMetadataTwo", executeQueryTwoResultMetaData);

			if (!executeQueryTwoResultSet.isClosed()) {
				executeQueryTwoResultSet.close();
			}

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return updateQueryOutput2Two;
	}

}
