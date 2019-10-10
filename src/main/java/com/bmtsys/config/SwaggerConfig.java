package com.bmtsys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * created on :  Oct 8, 2019
 *
 * @author Tharunkumar Bairoju
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Tharunkumar Bairoju", "tharun.it05@gmail.com",
			"tharun.it05@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("BMTSYS", "These are the APIs of BMTSYS service", "1.0",
			"urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	

	@Bean
	public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .apiInfo(DEFAULT_API_INFO)
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.bmtsys"))              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

}
