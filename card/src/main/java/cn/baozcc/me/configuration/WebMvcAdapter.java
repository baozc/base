package cn.baozcc.me.configuration;


import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author baozc
 * @date 2019/3/20 5:16 PM
 * //
 */
@Configuration
public class WebMvcAdapter implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet);
        servletServletRegistrationBean.getUrlMappings().clear();
        servletServletRegistrationBean.addUrlMappings("/");
        servletServletRegistrationBean.addUrlMappings("*.do");
        servletServletRegistrationBean.addUrlMappings("*.html");
        servletServletRegistrationBean.addUrlMappings("*.css");
        servletServletRegistrationBean.addUrlMappings("*.js");
        servletServletRegistrationBean.addUrlMappings("*.png");
        servletServletRegistrationBean.addUrlMappings("*.gif");
        servletServletRegistrationBean.addUrlMappings("*.ico");
        servletServletRegistrationBean.addUrlMappings("*.jpeg");
        servletServletRegistrationBean.addUrlMappings("*.jpg");
        servletServletRegistrationBean.addUrlMappings("*.swf");
        servletServletRegistrationBean.addUrlMappings("/v2/api-docs");
        return servletServletRegistrationBean;
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")
                //放行哪些原始域
                .allowedOrigins("*")
                //放行哪些原始域(头部信息)
                .allowedHeaders("x-requested-with,content-type");
    }

    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addContextCustomizers(context -> {
            SecurityConstraint securityConstraint = new SecurityConstraint();
            securityConstraint.setUserConstraint("CONFIDENTIAL");
            SecurityCollection collection = new SecurityCollection();
            collection.addPattern("/*");
            collection.addMethod("HEAD");
            collection.addMethod("PUT");
            collection.addMethod("DELETE");
            collection.addMethod("OPTIONS");
            collection.addMethod("TRACE");
            collection.addMethod("COPY");
            collection.addMethod("SEARCH");
            collection.addMethod("PROPFIND");
            securityConstraint.addCollection(collection);
            context.addConstraint(securityConstraint);
        });
        return factory;
    }
}
