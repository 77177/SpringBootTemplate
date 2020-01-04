package com.template.demo;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.authentication.FormAuthScheme;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.template.demo.person.models.Person;
import com.template.demo.person.services.PersonService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


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
    public void testPost() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void testPut() {
    }

    @Test
    public void testDelete() {
    }
}
