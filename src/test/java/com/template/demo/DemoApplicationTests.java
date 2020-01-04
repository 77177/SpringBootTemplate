package com.template.demo;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.authentication.FormAuthScheme;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;
import com.template.demo.person.models.Person;
import com.template.demo.person.services.PersonService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = DemoApplication.class)
@ActiveProfiles(value = {"default"})
class DemoApplicationTests {

    @Autowired
    private PersonService personService;

    @LocalServerPort
    private int portNumber;

    @BeforeEach
    public void setup() {
        RestAssured.port = portNumber;
        RestAssured.baseURI = "https://localhost";
        RestAssured.useRelaxedHTTPSValidation();
        FormAuthScheme formAuthScheme = new FormAuthScheme();
        formAuthScheme.setUserName("username");
        formAuthScheme.setPassword("password");
        FormAuthConfig formAuthConfig = new FormAuthConfig("/login", "username", "password");
        formAuthScheme.setConfig(formAuthConfig);
        RestAssured.authentication = formAuthScheme;
    }

    @Test
    public void testPostGetPutDelete() {

        Person person = new Person(1,"First","Last");

        //POST TEST ----------------------------------------------------------------------------------------------
        ExtractableResponse<Response> postResponse = RestAssured.given().contentType(ContentType.JSON)
                .body(person)
                .post("/persons/create")
                .then()
                .statusCode(200)
                .extract();
        //---------------------------------------------------------------------------------------------------------

        long id = Long.parseLong(postResponse.response().body().asString());

        //GET TEST ----------------------------------------------------------------------------------------------
        RestAssured.given().contentType(ContentType.JSON)
                .get("/persons/get/" + id)
                .then()
                .body("firstName", Matchers.is(person.getFirstName()))
                .body("lastName", Matchers.is(person.getLastName()))
                .statusCode(200);
        //---------------------------------------------------------------------------------------------------------

        Person personUpdated = new Person(id,"NewFirst","NewLast");

        //PUT TEST ----------------------------------------------------------------------------------------------
        ExtractableResponse<Response> putResponse = RestAssured.given().contentType(ContentType.JSON)
                .body(personUpdated)
                .put("/persons/update")
                .then()
                .statusCode(200)
                .extract();
        //---------------------------------------------------------------------------------------------------------

        long updateId = Long.parseLong(putResponse.response().body().asString());

        Assert.assertEquals(id,updateId);

        RestAssured.given().contentType(ContentType.JSON)
                .get("/persons/get/" + updateId)
                .then()
                .body("firstName", Matchers.is(personUpdated.getFirstName()))
                .body("lastName", Matchers.is(personUpdated.getLastName()))
                .statusCode(200);

        int sizeBeforeDelete = personService.getAllPersons().size();

        //DELETE TEST ----------------------------------------------------------------------------------------------
        RestAssured.given().contentType(ContentType.JSON)
                .delete("/persons/delete/" + updateId)
                .then()
                .statusCode(200);
        //---------------------------------------------------------------------------------------------------------

        int sizeAfterDelete = personService.getAllPersons().size();

        Assert.assertEquals((1), sizeBeforeDelete - sizeAfterDelete);
    }

}
