package br.com.safecity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v1")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()                
                .apiInfo(new ApiInfoBuilder()                        
                        .title("API Safe City")
                        .description("API Safe City")
                        .version("1.0.0")
                        .build());
    }

}