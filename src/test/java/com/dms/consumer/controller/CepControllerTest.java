package com.dms.consumer.controller;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import com.dms.consumer.BaseTest;

public class CepControllerTest extends BaseTest {

	@Test
	public void shouldGetCep() throws Exception {
		given()
		.when()
			.get("http://127.0.0.1:8080/cep/54735275")
		.then()
			.assertThat()
			.statusCode(200)
			.body("cep", Matchers.containsString("54735-275"))
			.and()
			.body("logradouro", Matchers.containsString("Rua Sárdio"));
	}
}
