package com.hjf.swaggerFoxdemo;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 本地訪問地址
 * http://localhost:8080/swagger-ui.html
 * swagger是一款可以根据restful风格生成的接口开发文档，并且支持做测试的一款中间软件。
 *
 * 二：为什么使用swagger？
 *
 * 1.对于后端开发人员来说
 *
 * 不用再手写Wiki接口拼大量参数，避免手写错误
 * 对代码侵入性低，采用全注解的方式，开发简单
 * 方法参数名修改、新增、减少参数都可以直接生效，不用手动维护
 * 缺点：增加了开发成本，写接口还得再写一套参数配置
 * 2.对前端开发来说
 *
 * 后端只需要定义好接口，会自动生成文档，接口功能、参数一目了然
 * 联调方便，如果出了问题，直接测试接口，实时检查参数和返回值，就可以快速定位是前端还是后端的问题
 * 3.对于测试
 *
 * 但对于测试没有前端界面UI的功能，可以直接用它来测试接口
 * 操作简单，不用了解具体代码就可以操作
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).
                select().
                apis(RequestHandlerSelectors.
                        withMethodAnnotation(ApiOperation.class)).
                paths(PathSelectors.any()).
                build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().
                title("swagger和springboot整合").
                description("swagger的api文档").
                version("1.0").build();
    }
}