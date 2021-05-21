package com.dms.consumer;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations="classpath:test.properties")
public abstract class BaseTest {

	public static RequestSpecification requestSpecification;

	@BeforeTestClass
	public static void setup() {
		// port was not set because the default is 8080, defined in test.properties
		requestSpecification = new RequestSpecBuilder()
				.log(LogDetail.METHOD)
				.log(LogDetail.URI)
				.build();

		RestAssured.requestSpecification = requestSpecification;
	}
}
