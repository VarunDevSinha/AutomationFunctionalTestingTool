package com.test.Functions;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import com.test.Utilities.apiRestAssuredUtility;
import com.test.Utilities.commonJavaUtility;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

/**
 * 
 * @author VarunDevSinha (press ctrl + O)
 *
 */
public class RestAssuredFunctions extends apiRestAssuredUtility {

	/**
	 * 
	 * @param propertiesFilePath
	 * @param jsonPayload
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequesturlPOST(String propertiesFilePath, JSONObject jsonPayload,
			HashMap<String, Object> cookies, HashMap<String, Object> headers) {

		Response postRequest_Response = null;

		try {
			postRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.contentType(ContentType.JSON).body(jsonPayload).auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
					.cookies(cookies).headers(headers).when().post(commonJavaUtility
							.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostURL"));
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return postRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param pathParam
	 * @param queryParam
	 * @param jsonPayload
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestPOST(String propertiesFilePath, HashMap<String, Object> pathParam,
			JSONObject jsonPayload, HashMap<String, Object> cookies, HashMap<String, Object> headers) {

		Response postRequest_Response = null;

		try {
			postRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.contentType(ContentType.JSON).body(jsonPayload).auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
					.cookies(cookies).headers(headers).when().post(
							commonJavaUtility.getPropertyValue(
									commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
							pathParam);
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return postRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param pathParam
	 * @param queryParam
	 * @param uploadFileList
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestFilePOST(String propertiesFilePath, HashMap<String, Object> pathParam,
			HashMap<String, Object> queryParam, List<File> uploadFileList, HashMap<String, Object> cookies,
			HashMap<String, Object> headers) {

		Response postRequest_Response = null;

		try {
			uploadFileList.forEach(file -> {
				given().proxy(
						commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
								"ApplicationApiHost"),
						Integer.parseInt(commonJavaUtility.getPropertyValue(
								commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
						commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
								"ApplicationApiSchema"))
						.contentType(ContentType.MULTIPART).multiPart(file).auth()
						.oauth2(commonJavaUtility.getPropertyValue(
								commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
						.queryParams(queryParam).cookies(cookies).headers(headers).when()
						.post(commonJavaUtility.getPropertyValue(
								commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
								pathParam);
			});

			postRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.queryParams(queryParam).auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "GetOauth2AccessToken"))
					.cookies(cookies).headers(headers).when().get(
							commonJavaUtility.getPropertyValue(
									commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
							pathParam);

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return postRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequesturlGET(String propertiesFilePath, HashMap<String, Object> cookies,
			HashMap<String, Object> headers) {

		Response getRequest_Response = null;

		try {
			getRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
					.cookies(cookies).headers(headers).when().get(commonJavaUtility
							.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath), "GetUrl"));
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return getRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param basePath
	 * @param pathParam
	 * @param queryParam
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestGET(String propertiesFilePath, HashMap<String, Object> pathParam,
			HashMap<String, Object> queryParam, HashMap<String, Object> cookies, HashMap<String, Object> headers) {

		Response getRequest_Response = null;

		try {
			getRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.queryParams(queryParam).auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
					.cookies(cookies).headers(headers).when().get(
							commonJavaUtility.getPropertyValue(
									commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
							pathParam);
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return getRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param jsonPayload
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestUrlPUT(String propertiesFilePath, JSONObject jsonPayload,
			HashMap<String, Object> cookies, HashMap<String, Object> headers) {

		Response putRequest_Response = null;
		try {
			putRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
					.contentType(ContentType.JSON).body(jsonPayload).cookies(cookies).headers(headers).when()
					.put(commonJavaUtility
							.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath), "PutURL"));
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return putRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param basePath
	 * @param pathParam
	 * @param jsonPayload
	 * @param queryParam
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestPUT(String propertiesFilePath, HashMap<String, Object> pathParam,
			JSONObject jsonPayload, HashMap<String, Object> queryParam, HashMap<String, Object> cookies,
			HashMap<String, Object> headers) {

		Response putRequest_Response = null;
		try {
			putRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.queryParams(queryParam).auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
					.contentType(ContentType.JSON).body(jsonPayload).cookies(cookies).headers(headers).when().put(
							commonJavaUtility.getPropertyValue(
									commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
							pathParam);
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return putRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param pathParam
	 * @param queryParam
	 * @param uploadFileList
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestFilePUT(String propertiesFilePath, HashMap<String, Object> pathParam,
			HashMap<String, Object> queryParam, List<File> uploadFileList, HashMap<String, Object> cookies,
			HashMap<String, Object> headers) {

		Response putRequest_Response = null;

		try {
			uploadFileList.forEach(file -> {
				given().proxy(
						commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
								"ApplicationApiHost"),
						Integer.parseInt(commonJavaUtility.getPropertyValue(
								commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
						commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
								"ApplicationApiSchema"))
						.contentType(ContentType.MULTIPART).multiPart(file).auth()
						.oauth2(commonJavaUtility.getPropertyValue(
								commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
						.queryParams(queryParam).cookies(cookies).headers(headers).when()
						.post(commonJavaUtility.getPropertyValue(
								commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
								pathParam);
			});

			putRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.queryParams(queryParam).auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "GetOauth2AccessToken"))
					.cookies(cookies).headers(headers).when().get(
							commonJavaUtility.getPropertyValue(
									commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
							pathParam);

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return putRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param jsonPayload
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestUrlPATCH(String propertiesFilePath, JSONObject jsonPayload,
			HashMap<String, Object> cookies, HashMap<String, Object> headers) {

		Response patchRequest_Response = null;

		try {
			patchRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
					.contentType(ContentType.JSON).body(jsonPayload).cookies(cookies).headers(headers).when()
					.patch(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PatchUrl"));
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return patchRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param basePath
	 * @param pathParam
	 * @param jsonPayload
	 * @param queryParam
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestPATCH(String propertiesFilePath, HashMap<String, Object> pathParam,
			JSONObject jsonPayload, HashMap<String, Object> queryParam, HashMap<String, Object> cookies,
			HashMap<String, Object> headers) {

		Response patchRequest_Response = null;

		try {
			patchRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.queryParams(queryParam).auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
					.contentType(ContentType.JSON).body(jsonPayload).cookies(cookies).headers(headers).when().patch(
							commonJavaUtility.getPropertyValue(
									commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
							pathParam);
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return patchRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param pathParam
	 * @param queryParam
	 * @param uploadFileList
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestFilePATCH(String propertiesFilePath, HashMap<String, Object> pathParam,
			HashMap<String, Object> queryParam, List<File> uploadFileList, HashMap<String, Object> cookies,
			HashMap<String, Object> headers) {

		Response patchRequest_Response = null;

		try {
			uploadFileList.forEach(file -> {
				given().proxy(
						commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
								"ApplicationApiHost"),
						Integer.parseInt(commonJavaUtility.getPropertyValue(
								commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
						commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
								"ApplicationApiSchema"))
						.contentType(ContentType.MULTIPART).multiPart(file).auth()
						.oauth2(commonJavaUtility.getPropertyValue(
								commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
						.queryParams(queryParam).cookies(cookies).headers(headers).when()
						.post(commonJavaUtility.getPropertyValue(
								commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
								pathParam);
			});

			patchRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.queryParams(queryParam).auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "GetOauth2AccessToken"))
					.cookies(cookies).headers(headers).when().get(
							commonJavaUtility.getPropertyValue(
									commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
							pathParam);

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return patchRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestUrlDELETE(String propertiesFilePath, HashMap<String, Object> cookies,
			HashMap<String, Object> headers) {

		Response deleteRequest_Response = null;

		try {
			deleteRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
					.cookies(cookies).headers(headers).when().delete(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "DeleteUrl"));
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return deleteRequest_Response;
	}

	/**
	 * 
	 * @param propertiesFilePath
	 * @param basePath
	 * @param pathParam
	 * @param queryParam
	 * @param cookies
	 * @param headers
	 * @return
	 */
	public static final Response httprequestDELETE(String propertiesFilePath, HashMap<String, Object> pathParam,
			HashMap<String, Object> queryParam, HashMap<String, Object> cookies, HashMap<String, Object> headers) {

		Response deleteRequest_Response = null;

		try {
			deleteRequest_Response = given().proxy(
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiHost"),
					Integer.parseInt(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "ApplicationApiPort")),
					commonJavaUtility.getPropertyValue(commonJavaUtility.createPropertiesObject(propertiesFilePath),
							"ApplicationApiSchema"))
					.queryParams(queryParam).auth()
					.oauth2(commonJavaUtility.getPropertyValue(
							commonJavaUtility.createPropertiesObject(propertiesFilePath), "PostOauth2AccessToken"))
					.cookies(cookies).headers(headers).when().delete(
							commonJavaUtility.getPropertyValue(
									commonJavaUtility.createPropertiesObject(propertiesFilePath), "apiBasePath"),
							pathParam);
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}

		return deleteRequest_Response;
	}

	/**
	 * 
	 * @param Request_Response
	 */
	public static final void logResponseBodyAll(Response Request_Response) {

		Request_Response.then().log().all();
	}

	/**
	 * 
	 * @param Request_Response
	 * @param jsonPath
	 */
	public static final void logResponseBodyObject(Response Request_Response, String jsonPath) {

		Request_Response.then().log().body().extract().path(jsonPath);

	}

	/**
	 * 
	 * @param Request_Response
	 */
	public static final void getResponseBodyObject(Response Request_Response) {

		System.out.println("Status code: " + Request_Response.getStatusCode() + "\n" + "Status line: "
				+ Request_Response.getStatusLine() + "\n" + "ResponseTime inSeconds: "
				+ Request_Response.getTimeIn(TimeUnit.SECONDS));
	}

	/**
	 * 
	 * @param Request_Response
	 * @param jsonSchema
	 */
	public static final void responseSchemaValidationJSON(Response Request_Response, File jsonSchema) {

		try {

			System.out.println(
					Request_Response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema)));

		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handles, Successfully! **********");
		}
	}

	/**
	 * 
	 * @param Request_Response
	 * @param jsonPath
	 * @param validateValueWith
	 * @return
	 */
	public static final boolean responseBodyValidationObject(Response Request_Response, String jsonPath,
			Object expectedValue) {

		boolean bodyValidates = true;

		bodyValidates = Request_Response.then().extract().body().path(jsonPath).equals(expectedValue);

		return bodyValidates;
	}

	/**
	 * 
	 * @param Request_Response
	 * @param statusCode
	 * @param statusLine
	 * @param responseTimeMili
	 */
	public static final void responseGeneralValidation(Response Request_Response, Integer statusCode, String statusLine,
			Long responseTimeMili) {

		Request_Response.then().statusCode(statusCode).statusLine(statusLine).time(lessThanOrEqualTo(responseTimeMili));

	}

	/**
	 * 
	 * @param responseFileFolder
	 * @param fileName
	 * @param jsonResponseBody
	 */
	public static final void responseBodySaveJSON(String responseFileFolder, String fileName,
			Response jsonResponseBody) {

		jsonFileResponsePayload(responseFileFolder, fileName, jsonResponseBody);
	}
}
