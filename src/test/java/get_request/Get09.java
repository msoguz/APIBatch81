package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends RestfulBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/91
    When
        I send GET Request to the url
    Then
        Response body should be like that;
  {
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
}
 */
    @Test
    public void get09(){

        //Set the Url

        spec.pathParams("first","booking","second",91);

        //Set The Expected Data
        Map<String,String> bookingDatesMap=new HashMap<>();
        bookingDatesMap.put("checkin","2013-02-23");
        bookingDatesMap.put("checkout","2014-10-23");

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstname", "Sally");
        expectedData.put("lastname","Brown");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates", bookingDatesMap);
        expectedData.put("additionalneeds","Breakfast");
        System.out.println(expectedData);

    //Send The Request and get The Response

    Response response=given().spec(spec).when().get("{first}/{second}");
    response.prettyPrint();

    //Do Assertion

        Map<String,Object> actualData=response.as(HashMap.class);  //Json olan respons'u HashMap'e ceviriyoruz
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingDatesMap.get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));//Key-value ikilileri,
                                    // String-Object seklinde oldugundan, Bookingdata value kısmını casting ile Map yaptık.
        assertEquals(bookingDatesMap.get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));










    }
}
