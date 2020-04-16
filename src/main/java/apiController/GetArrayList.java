package apiController;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class GetArrayList {


    public void getAllUser() {
        //RestAssured.given().header("Content-Type", "application/json").get("http://dummy.restapiexample.com/api/v1/employees").then().assertThat().statusCode(200);

       //Define our base URL
        RestAssured.baseURI = "https://reqres.in/api/";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");

        //Add END USER here----
        Response response = httpRequest.get("users");

       //log your response details in your local machine
        response.then().assertThat().log().all();

        //response.then().assertThat().statusCode(200).and().assertThat().body("data.first_allUsername",Matchers.containsInAnyOrder("George","Janet","Emma","Eve","Charles","Tracey"));
        JsonPath jsonPath = response.jsonPath();
    //Convert to String value

    // Get All content : example All -last_name/id/first_name inside response
        List<String> id = jsonPath.getList("data.id");
        System.out.println("This is all the user ID------   " + id);

        List<String> last_name = jsonPath.getList("data.last_name");
        System.out.println("This is all the user Last_Name-----  " + last_name);

        List<String> first_name = jsonPath.getList("data.first_name");
        System.out.println("This is all the user First_Name----- " + first_name);

    }
}
