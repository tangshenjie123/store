package com.tangshenjie.store;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class MyStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStoreApplication.class, args);
    }
//    @Bean
//    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean reg = new ServletRegistrationBean(dispatcherServlet);
//        reg.getUrlMappings().clear();
//        reg.addUrlMappings("*.html");
//        reg.addUrlMappings("*.do");
//        return reg;
//    }
}
