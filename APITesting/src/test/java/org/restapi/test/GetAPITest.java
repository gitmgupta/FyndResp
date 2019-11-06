package org.restapi.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.restapi.base.TestBase;
import org.restapi.client.RestClient;
import org.restapi.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetAPITest extends TestBase

{
	String URI;
	RestClient getMethod;
	CloseableHttpResponse responseUnderGetRequest;

	public GetAPITest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		String URL = prop.getProperty("url");
		String serviceURL = prop.getProperty("getServiceUrl");

		// Concatenate end Point URL and service URL to MAke URI
		URI = URL + serviceURL;
		System.out.println("URI is " + URI);

	}

	@Test
	public void getCallTestWithoutHeader() throws ClientProtocolException, IOException {
		// Input Part of GET MEthod
		// Created Object of RestClient Class so that we can call methods in it
		getMethod = new RestClient();

		// GET method is called using only URI and response is saved in variable
		responseUnderGetRequest = getMethod.get(URI);

		// Output Part of GET MEthod
		// Validation part (For GET method output is 1.StatusCode,2.Response
		// JSON,3.Header)
		// 1. Retrieve Response Status Code and Assert it
		int responseStatusCode = responseUnderGetRequest.getStatusLine().getStatusCode();
		Assert.assertEquals(responseStatusCode, RESPONSE_STATUS_CODE_200);

		// 2.Retrieve Response JSON Object as a String and Assert it
		String responseString = EntityUtils.toString(responseUnderGetRequest.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);

		// get the value from JSON Array used Common utility for retrieving data from
		// JSON
		String name = TestUtil.getValueByJpath(responseJson, "/data[0]/id");
		Assert.assertEquals(name, prop.getProperty("employee_name"));
		String id = TestUtil.getValueByJpath(responseJson, "/data[0]/id");
		Assert.assertEquals(id, prop.getProperty("employee_id"));
		String salary = TestUtil.getValueByJpath(responseJson, "/data[0]/employee_salary");
		Assert.assertEquals(salary, prop.getProperty("employee_salary"));
	}

	@Test
	public void getCallTestWithHeader() throws ClientProtocolException, IOException {
		// Input Part of GET Method
		// Created Object of RestClient Class so that we can call methods in it
		getMethod = new RestClient();

		// Header Value to Pass with GET Method (URI is already ready in before Method)
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		// GET method is called using URI and headers and response is saved in variable
		responseUnderGetRequest = getMethod.get(URI, headers);

		// Output Part of GET MEthod
		// Validation part (For GET method output is 1.StatusCode,2.Response
		// JSON,3.Header)
		// 1. Retrieve Response Status Code and Assert it
		int responseStatusCode = responseUnderGetRequest.getStatusLine().getStatusCode();
		Assert.assertEquals(responseStatusCode, RESPONSE_STATUS_CODE_200);

		// 2.Retrieve Response JSON Object as a String and Assert it
		String responseString = EntityUtils.toString(responseUnderGetRequest.getEntity(), "UTF-8");
		System.out.println("response string" + responseString);
		JSONObject responseJson = new JSONObject(responseString);

		// get the value from JSON Array used Common utility for retrieving data from
		// JSON
		String name = TestUtil.getValueByJpath(responseJson, "/data[0]/id");
		Assert.assertEquals(name, prop.getProperty("employee_name"));
		String id = TestUtil.getValueByJpath(responseJson, "/data[0]/id");
		Assert.assertEquals(id, prop.getProperty("employee_id"));
		String salary = TestUtil.getValueByJpath(responseJson, "/data[0]/employee_salary");
		Assert.assertEquals(salary, prop.getProperty("employee_salary"));

		// 3.Response Headers
		Header[] responseHeaders = responseUnderGetRequest.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : responseHeaders) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers are " + allHeaders);

	}

}
