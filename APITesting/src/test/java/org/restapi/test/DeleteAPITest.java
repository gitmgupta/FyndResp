package org.restapi.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.restapi.base.TestBase;
import org.restapi.client.RestClient;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAPITest extends TestBase {

	String uri;

	public DeleteAPITest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		String url = prop.getProperty("url");
		String serviceUrl = prop.getProperty("deleteServiceUrl");
		uri = url + serviceUrl;
	}

	@Test
	public void deleteCall() throws ClientProtocolException, IOException {

		RestClient restclient = new RestClient();
		CloseableHttpResponse reposnseUnderDeleteCall = restclient.delete(uri);

		int responseStatusCode = reposnseUnderDeleteCall.getStatusLine().getStatusCode();
		Assert.assertEquals(responseStatusCode, RESPONSE_STATUS_CODE_200);
	}

	@Test
	public void deleteCallWithHeader() throws ClientProtocolException, IOException
	{
		RestClient restclient = new RestClient();

		HashMap<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/json");

		CloseableHttpResponse responseUnderDeleteCall = restclient.delete(uri, header);
		int responseStatusCode = responseUnderDeleteCall.getStatusLine().getStatusCode();
		Assert.assertEquals(responseStatusCode, RESPONSE_STATUS_CODE_200);
	}
}
