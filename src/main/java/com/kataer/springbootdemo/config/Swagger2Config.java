package com.kataer.springbootdemo.config;

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
 * Swagger2 可以识别控制器中的方法，然后自动生成可视化的测试界面。
 * 如果给控制器方法添加注解，还能自动生成在线 API 文档
 */
@Configuration  //标注为配置类
@EnableSwagger2 //启用Swagger功能
public class Swagger2Config {
    /**
     * 配置Swagger2相关的bean
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com"))// com包下所有API都交给Swagger2管理
                .paths(PathSelectors.any()).build();
    }

    /**
     * 此处主要是API文档页面显示信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("演示项目API") // 标题
                .description("学习Swagger2的演示项目") // 描述
                .termsOfServiceUrl("http://www.imooc.com") // 服务网址，一般写公司地址
                .version("1.0") // 版本
                .build();
    }
}
