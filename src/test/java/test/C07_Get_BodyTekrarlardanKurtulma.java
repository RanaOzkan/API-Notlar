package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C07_Get_BodyTekrarlardanKurtulma {

    /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"Mary",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, 371,
                    ve "depositpaid“in,false,
                    ve "bookingdates": { "checkin": "2022-07-02",
                                         "checkout": "2023-01-24" }
                                          oldugunu test edin
         */
    @Test
    public void get01(){

        String url="https://restful-booker.herokuapp.com/booking/10";


        Response response=given().when().get(url);
        response.prettyPrint();


        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Sally"),
                        "lastname",equalTo("Wilson"),
                        "totalprice",equalTo(803),
                        "depositpaid",equalTo(true),
                        "bookingdates",equalTo("breakfast")
                        );

    }
}
