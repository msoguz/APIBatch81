package patch_request.get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01b {

    /*
   Given
       https://reqres.in/api/users/3
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
*/

    @Test
    public void get01(){

        //TODO:First Step:Set the Url
        String url="https://reqres.in/api/users/3";

        //TODO:Second Step:Set The Expected Data   Bu asamayi daha sonra ogerenecegiz.

        //TODO:Third Step:Send The Request and Get The Response
        Response response=given().when().get(url);
        response.prettyPrint();

        //TODO:Fourt Step:Do Assertion

        // Then
        //       HTTP Status Code should be 200
        //   And
        //       Content Type should be JSON
        //   And
        //       Status Line should be HTTP/1.1 200 OK
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");


    }



}
