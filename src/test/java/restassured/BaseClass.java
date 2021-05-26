package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class BaseClass {

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
        return given(requestSpecification).contentType(ContentType.JSON).with().body(createRequest(id)).when().post();
    }


    public static Response deleteNewPet(int id){
        return given(requestSpecification).delete("/"+id);
    }

}
