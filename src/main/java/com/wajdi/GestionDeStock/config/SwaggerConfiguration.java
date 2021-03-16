package com.wajdi.GestionDeStock.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.wajdi.GestionDeStock.utils.Constants.APP_ROOT;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Gestion de Stock Api Documentation")
                                .title("Gestion de stock Api ")
                                .build()
                )
                .groupName("Rest API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wajdi.GestionDeStock"))
                .paths(PathSelectors.ant(APP_ROOT + "/**"))
                .build();
    }
}
