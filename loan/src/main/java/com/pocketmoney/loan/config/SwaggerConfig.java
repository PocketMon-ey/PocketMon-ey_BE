package com.pocketmoney.loan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("LOAN")
                .description("예외처리 외 다 됨 \n 예외처리 학습 중 \n 안되면 연락 ")
                .build();
    }

    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("loan")
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.pocketmoney.loan.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .host("http://pocketmoney.165.192.105.60.nip.io/loan");
    }
}
