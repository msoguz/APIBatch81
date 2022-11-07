package request_Classes.post_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like  {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test
    public void post05ObjectMapper(){

        //Set The Url

        spec.pathParam("first","todos");

        //Set The Expected Data
        JsonPlaceHolderPojo expextedData=new JsonPlaceHolderPojo(55,"Tidy your room", false);
        System.out.println("expextedData = " + expextedData);


        //Send The Request And Get The Response

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expextedData).when().post("{first}");
        response.prettyPrint();


        //Do Assertion
        JsonPlaceHolderPojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.getStatusCode());
        assertEquals(expextedData.getUserId(),actualData.getUserId());
        assertEquals(expextedData.getTitle(),actualData.getTitle());
        assertEquals(expextedData.getCompleted(),actualData.getCompleted());
















    }
}
