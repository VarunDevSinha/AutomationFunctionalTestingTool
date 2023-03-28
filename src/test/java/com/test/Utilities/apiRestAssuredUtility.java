/**
 * 
 */
package com.test.Utilities;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.response.Response;

/**
 * 
 * @author VarunDevSinha (press ctrl + O)
 *
 */
public class apiRestAssuredUtility {

	/**
	 * 
	 * @param jsonFilePath
	 * @return
	 */
	public static final JSONObject jsonFileRequestPayload(String jsonFilePath) {

		JSONObject jsonFileRequestPayloadObject = null;

		try {
			File jsonFile = new File(jsonFilePath);
			FileReader jsonFileRead = new FileReader(jsonFile);
			JSONTokener jsonFileToken = new JSONTokener(jsonFileRead);
			jsonFileRequestPayloadObject = new JSONObject(jsonFileToken);
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}
		return jsonFileRequestPayloadObject;

	}

	/**
	 * 
	 * @param payloadDataMap
	 * @return
	 */
	public static final JSONObject hashMapRequestPayload(HashMap<String, Object> payloadDataMap) {

		JSONObject jsonFileRequestPayloadObject = null;

		try {

			jsonFileRequestPayloadObject = new JSONObject(payloadDataMap);
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}
		return jsonFileRequestPayloadObject;

	}

	/**
	 * 
	 * @param responseFileFolder
	 * @param fileName
	 * @param jsonResponseBody
	 * @return
	 */
	public static final String jsonFileResponsePayload(String responseFileFolder, String fileName,
			Response jsonResponseBody) {

		File jsonResponseFile = new File(
				responseFileFolder + "//" + fileName + "_" + System.currentTimeMillis() + ".json");

		try {
			FileWriter jsonResponseFileWrite = new FileWriter(jsonResponseFile);

			JSONObject responseObject = new JSONObject(jsonResponseBody.asString());

			jsonResponseFileWrite.write(responseObject.toString());
			jsonResponseFileWrite.close();
		} catch (Exception anyException) {
			System.out.println(anyException.getMessage());
		} finally {
			System.out.println("********** Exception(s) handled, Successfully! **********");
		}

		return jsonResponseFile.getAbsolutePath();
	}

}
