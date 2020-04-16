package base;

import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScriptBase {





    public void beforeTest(){

        RestAssured.baseURI = "https://reqres.in/api/";
    }


}
