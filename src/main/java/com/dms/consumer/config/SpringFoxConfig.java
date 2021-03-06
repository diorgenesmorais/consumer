package com.dms.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(this.apiInfo())
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.dms.consumer.controller"))
					.build()
				.tags(new Tag("CEP", "Obter o endereço pelo CEP"));
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
					.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
					.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
					.title("Consumer API")
					.description("API que consome outra API")
					.version("1.0")
					.contact(new Contact("DMS software", "https://github.com/diorgenesmorais/consumer", "diorgenesmorais@gmail.com"))
					.build();
	}
}
