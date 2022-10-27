package com.springboot.hello.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfiguration {
    @Configuration
    public class SwaggerConfig {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.OAS_30)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build();
        }
    }
}

//에러 나는 경우
//(application.properties 를 application.yml로 이름 변경 필요)
//application.yml에 아래와 같이 추가
//spring:
// mvc:
//   pathmatch:
//     matching-strategy: ant_path_matcher