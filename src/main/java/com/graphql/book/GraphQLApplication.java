package com.graphql.book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
public class GraphQLApplication {// extends SpringBootServletInitializer {
	//@Override
    //protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    //    return builder.sources(GraphQLApplication.class);
    //}
	public static void main(String[] args) {
		SpringApplication.run(GraphQLApplication.class, args);
	}
}