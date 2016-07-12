package br.com.grands.infrastructure.config;


import gumga.framework.annotations.GumgaSwagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by gelatti on 27/05/16.
 */
//
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createApiDocumentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(GumgaSwagger.class))
                .paths(PathSelectors.regex("/api/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "XML Storage",
                "API para acessar ou inserir informações no software",
                "",
                "",
                "",
                "",
                ""
        );
        return apiInfo;
    }
}
