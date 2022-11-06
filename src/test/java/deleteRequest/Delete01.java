package deleteRequest;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01 extends JsonplaceholderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */
    @Test
    public void delete01(){
        //Set the Url
        spec.pathParams("first","todos","second",198);

        //Set The Expected Data
        Map<String,String> expectedData=new HashMap<>(); // Bos olarak gelecek.
        //Send The Request And Get The Response
        Response response=given().spec(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        Map actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(200,response.getStatusCode());
        //1.YOL
        assertEquals(expectedData,actualData);

        //2.YOL
        assertTrue(actualData.isEmpty());

        //3.YOL
        assertEquals(0,actualData.size());

    }

//Yorum yapacaktim.git add .

}
