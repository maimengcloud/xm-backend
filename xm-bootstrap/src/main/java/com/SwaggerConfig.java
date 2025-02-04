package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * api 文档,
 * 生产环境需要禁止访问,每个项目需要单独引入swagger包，不能继承
 * 如果要mdp swagger enhance生效，必须 把启动文件置于com.mdp的上层或者顶层目录下，否则加载不到升级文件
 * mdp swagger enhance主要解决的是接收参数是map的时候的文档输出问题。参考 https://blog.csdn.net/x11819130/article/details/111608470
 * 需要将下面路径放到 WebSecurityConfig 中
 *
 *                 "/swagger-ui.html",
 *                 "/webjars/**",
 *                 "/swagger-ui/**",
 *                 "/swagger-resources/**",
 *                 "/v2/*",
 *                 "/csrf",
 *                 "/"
 */

//@ConditionalOnProperty(havingValue = "dev",name = {"spring.profiles.active"})
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value(value = "${spring.application.name:}")
    String applicationName="";

    @Value(value = "${spring.application.name:}")
    String springProfilesActive="";

    @Value(value = "${server.port:}")
    String serverPort="";

    @Value(value = "${swagger2.enable:true}")
    boolean enableSwagger2;

    @Bean
    public Docket customDocket() {
        ParameterBuilder tokenPar= new ParameterBuilder();
        List<Parameter> pars=new ArrayList<>();
        tokenPar.name("Authorization").description("令牌 格式：【bearer 令牌值】,注意bearer后根一个空格。").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        tokenPar.name("accessToken").description("令牌，直接填写令牌值").modelRef(new ModelRef("string")).parameterType("query").required(false).build();
        pars.add(tokenPar.build());
        Docket docket= new Docket(DocumentationType.SWAGGER_2).select().
                apis(RequestHandlerSelectors.any())
                .build().globalOperationParameters(pars)
                .apiInfo(apiInfo()).enable(enableSwagger2);

        /*
         * 下面的语句是开启对JWT的支持，当用户用Swagger调用受JWT认证保护的方法，
         * 必须要先提交参数（例如令牌）
         */
        //存储用户必须提交的参数
        List<ApiKey> apikey = new ArrayList();
        //规定用户需要输入什么参数
        apikey.add(new ApiKey("accesToken", "accesToken", "accesToken"));
        docket.securitySchemes(apikey);

        //以下定义如果用户JWT认证通过，则在Swagger中全局有效
        AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] scopeArray = {scope};
        //存储令牌和作用域
        SecurityReference reference = new SecurityReference("token", scopeArray);
        List refList = new ArrayList();
        refList.add(reference);
        SecurityContext context = SecurityContext.builder().securityReferences(refList).build();
        List cxtList = new ArrayList();
        cxtList.add(context);
        docket.securityContexts(cxtList);
        return docket;
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("广州擎勤网络科技有限公司", String.format("https://www.qingqinkj.com/api/m1/%s/swagger-ui.html",applicationName), "cyc58469@163.com");
        return new ApiInfoBuilder()
                .title("唛盟接口")
                .description(String.format("接口文档 本地访问地址 http://localhost:%s/swagger-ui.html",serverPort))
                .contact(contact)
                .version("1.0.0")
                .build();
    }


}
