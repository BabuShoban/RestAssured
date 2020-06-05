
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;



public class JuiceShopTest {


    @Test
    public void newUserCreation(){
        RestAssured.baseURI = "http://localhost:3000/";
        Response resp = (Response) RestAssured.
                given()
                .header("Content-type", "application/json").when()
                .body("{\"email\":\"abcessmvn shoban@gmail.com\" ,\n" +
                        "    \"password\":\"Password@123\",\n" +
                        "    \"passwordRepeat\":\"Password@123\",\n" +
                        "    \"securityQuestion\":{  \"id\":1, \n" +
                        "    \t\t\t\t\t  \"question\":\"Your eldest siblings middle name?\",\n" +
                        "                  \"createdAt\":\"2020-06-03T14:06:01.000Z\",\n" +
                        "                  \"updatedAt\":\"2020-06-03T14:06:01.000Z\"\n" +
                        "                  },\n" +
                        "    \"securityAnswer\":\"asdf\"\n" +
                        "}")
                .post("/api/users")
                .then().assertThat().statusCode(201).log().all()
                .extract().body();

    }

    @Test
    public void getSearchItems(){

        RestAssured.baseURI = "http://localhost:3000/";
         RestAssured.given().header("Content-type","application/json")
                .when().get("rest/products/search?q=apple").then().log().all().assertThat().statusCode(200);




    }


}
