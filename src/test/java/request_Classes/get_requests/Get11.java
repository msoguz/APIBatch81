package request_Classes.get_requests;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {

/*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status
    And
        Niranjan Gupta, Samir Namboothiri and Gandharva Kaul are among the users
    And
        The female users are less than or equals to male users
 */
    @Test
    public void get11(){

        //1- Set The Url

        spec.pathParam("first", "users");

        //2- Ste The Expected Data (put, post, patch)

        //3- Send The Request And Get The Response

        Response response=given().spec(spec).when().get("{first}");
        response.prettyPrint();


        //4- Do Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("meta.pagination.limit",equalTo(10),
                 "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                         "data",hasSize(10),
                         "data.status",hasItem("active"),
                         "data.name", hasItems("Pres. Amarnath Dhawan", "Sujata Chaturvedi", "Navin Panicker"));


        //Kadin ve erkek sayilarini karsilastiralim
        //1. YOL :
        List<String> genders=response.jsonPath().getList("data.gender");
        System.out.println(genders);

        int numOfFemale=0;
        for (String w:genders    ) {
            if(w.equalsIgnoreCase("female")){
                numOfFemale++;
            }
        }
        assertTrue(numOfFemale<= genders.size()-numOfFemale);

        //2.YOL: Kadin ve erkeksayilarini Groovy ile bulalim.

        List<String> femaleNames=  response.jsonPath().getList("data.findAll{it.gender=='female'}.name");
        System.out.println(femaleNames);

        List<String> maleNames=  response.jsonPath().getList("data.findAll{it.gender=='male'}.name");
        System.out.println(maleNames);

        assertTrue(femaleNames.size()<=maleNames.size());



    }


}