package restassured;

import static io.restassured.RestAssured.given;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;

import java.io.File;

import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.hamcrest.core.Is;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseClass {

    static final String baseURI = "https://petstore.swagger.io/v2/";
    //private RequestSpecification requestSpecification;
    static int id;
    static String updatedName = "Updated" + RandomStringUtils.randomAlphabetic(6);

    static RequestSpecification requestSpecification = RestAssured.given().baseUri("https://petstore.swagger.io").basePath("/v2/pet");

    public static JSONObject createRequest(int id) {

        JSONObject    requestInput = new JSONObject();
        requestInput.put("id",id);

        JSONObject catArray = new JSONObject();
        catArray.put("id", RandomUtils.nextInt());
        catArray.put("name","Catname" + RandomStringUtils.randomAlphabetic(5));

        requestInput.put("category",catArray);

        requestInput.put("name","Dog" + RandomStringUtils.randomAlphabetic(5));
        JSONArray photoAr = new JSONArray();
        photoAr.add("string");
        requestInput.put("photoUrls",photoAr);

        JSONObject tagArray = new JSONObject();
        tagArray.put("id",RandomUtils.nextInt());
        tagArray.put("name","Tag" + RandomStringUtils.randomAlphabetic(5));

        JSONArray tagAr = new JSONArray();
        tagAr.add(tagArray);

        requestInput.put("tags",tagAr);

        requestInput.put("status","available");

        return requestInput;
    }


    public static Response addNewPet(){
        id = RandomUtils.nextInt();
        return given(requestSpecification).log().all().contentType(ContentType.JSON).with().body(createRequest(id)).when().post();
    }


    public static Response deleteNewPet(int id){
        return given(requestSpecification).delete("/pet/"+id);
    }

}
