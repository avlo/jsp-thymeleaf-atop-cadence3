package com.prosilion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Cadence3JspUserDemo extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(Cadence3JspUserDemo.class);
  }
  public static void main(String[] args) {
    SpringApplication.run(Cadence3JspUserDemo.class, args);
  }
}
