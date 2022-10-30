package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get02b extends ReqresBaseUrl {

     /*
   Given
       https://reqres.in/api/users/23
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Server is "cloudflare"
   And
       Response body should be empty

*/
    @Test
    public void get02(){

        //Set the url
        spec.pathParams("first","api","second","users","third",23);

        //Set the expected data

        //Send teh Request and Get The Response
       Response response= given().spec(spec).when().get("/{first}/{second}/{third}");
       response.prettyPrint();



       //Do Assertion
        assertEquals(404, response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found", response.statusLine());
        assertEquals("cloudflare", response.getHeader("Server"));
        assertEquals(2, response.asString().replaceAll("\\s", "").length());





    }





}
