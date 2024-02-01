package com.ritvan.ecommerce;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.File;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EcommerceApplication.class);
    }

    File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));
    MultipartConfigElement multipartConfigElement = new  MultipartConfigElement(uploadDirectory.getAbsolutePath(), 100000, 100000 * 2, 100000 / 2);

}
