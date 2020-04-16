package apiController;

import base.ScriptBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class PostCall extends ScriptBase {


    public void postTest(){

        beforeTest();
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");//we chose application json because we get the body format as json.
        httpRequest.body(test); // Here i put Json Body variable.
        Response response = httpRequest.post("users");

        response.then().assertThat().log().all();

        response.then().assertThat().statusCode(201);

        JsonPath jsonPath=response.jsonPath();// here we converting from groovy

//Post expected response verification
        String name=jsonPath.getString("name");
        Assert.assertTrue(name.contains("morpheus"));
        String job=jsonPath.getString("job");
        Assert.assertTrue(job.contains("leader"));;

//Post dynamic id verification
        String id=jsonPath.getString("id");
        System.out.println("This is my Id:" +id);
        Assert.assertTrue(id.contains(id));

//You can extracting json response like that too
        String extract=response.then().extract().asString();
        System.out.println("This is extracting Value:"+extract);

      // Post Dynamic CreateAt Verification
        String createdAt=jsonPath.getString("createdAt");
        System.out.println("This createdAt:" +createdAt);
        Assert.assertTrue(createdAt.contains(createdAt));

    }

    //put Json body in a variable
    public String test="{\n" +
            " \"name\": \"morpheus\",\n" +
            " \"job\": \"leader\"\n" +
            "}";
}
