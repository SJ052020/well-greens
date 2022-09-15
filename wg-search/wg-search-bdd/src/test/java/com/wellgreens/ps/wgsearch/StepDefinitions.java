package com.wellgreens.ps.wgsearch;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class StepDefinitions extends RunCucumberTest{

    private String payload;

    @When("We request all categories")
    public void allStepDefinitionsAreImplemented() throws IOException {
        HttpPost postReq = new HttpPost("https://m2ayyv2ch2.execute-api.us-east-1.amazonaws.com/prod/search/graphql");
        postReq.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        String str = "{\"query\":\"query{\\r\\ngetCategories {\\r\\n    categories{\\r\\n    id\\r\\n    name\\r\\n         \\r\\n  }  \\r\\n}\\r\\n}\",\"variables\":{}}";
        postReq.setEntity(new StringEntity(str));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(postReq)) {
            payload = EntityUtils.toString(response.getEntity());
        }
    }

    @Then("Validate categories list with items")
    public void theScenarioPasses() {
        assertNotNull("Payload is null",payload);
    }

}
