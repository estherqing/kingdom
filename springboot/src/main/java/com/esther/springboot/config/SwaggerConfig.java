package com.esther.springboot.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: SwaggerConfig配置
 * @Author: huzhaorui
 * @CreateDate: 2019/8/14 14:18
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {
    @Value("${app.env:dev}")
    private String env;

    /**
     * 将Swagger2 的swagger-ui.html加入资源路径下,否则Swagger2静态页面不能访问。要想使资源能够访问，可以有两种方法
     * 一：需要配置类继承WebMvcConfigurationSupport 类，实现addResourceHandlers方法。
     * 但是实现了WebMvcConfigurationSupport以后，Spring Boot的 WebMvc自动配置就会失效，具体表现比如访问不到
     * 静态资源（js，css等）了，这是因为WebMvc的自动配置都在WebMvcAutoConfiguration类中，但是类中有这个注解
     *
     * @param registry
     * @ConditionalOnMissingBean({WebMvcConfigurationSupport.class})，意思是一旦在容器中检测到 WebMvcConfigurationSupport这个类，WebMvcAutoConfiguration类中的配置都不生效。
     * 所以一旦我们自己写的配置类继承了WebMvcConfigurationSupport，相当于容器中已经有了WebMvcConfigurationSupport，
     * 所有默认配置都不会生效，都得自己在配置文件中配置。
     * 二：继承WebMvcConfigurer接口，这里采用此方法 网上有人说使用该方法会导致date编译等问题，可能在配置文件中得到解决，
     * 本人没有碰到，不多做解释
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public Docket createRestApi() {
        if ("prd".equals(env)) {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfoOnline())
                    .select()
                    //如果是线上环境，添加路径过滤，设置为全部都不符合
                    .paths(PathSelectors.none())
                    .build();
        } else {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    // .apis(RequestHandlerSelectors.basePackage("com.vivo.internet.scence.intellig.health.web.controller"))
                    .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                    .paths(PathSelectors.any())
                    .build();
        }

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("第一个springboot项目 后台 APIs")
                .description("第一个springboot项目 后台")
                .termsOfServiceUrl("http://192.168.1.198:10070/platformgroup/ms-admin")
                .contact("esther")
                .version("1.0")
                .build();
    }

    private ApiInfo apiInfoOnline() {
        return new ApiInfoBuilder()
                .title("")
                .description("")
                .license("")
                .licenseUrl("")
                .termsOfServiceUrl("")
                .version("")
                .contact(new Contact("", "", ""))
                .build();
    }
}
