package apiController;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class GetDemo {

    public void getAllEmployee() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        Response response = httpRequest.get("employees");
        Assert.assertEquals(200, response.getStatusCode());

        //Now verifying content below-

     ResponseBody body=response.getBody();
     String bodyValue=body.asString();
     System.out.println("This is Employee detail  "+bodyValue);
     JsonPath jsonPath=response.jsonPath();
     String statusValue=jsonPath.get("status");
     Assert.assertTrue(statusValue.equalsIgnoreCase("success"));





    }
}
// query parameter is- ?id=458