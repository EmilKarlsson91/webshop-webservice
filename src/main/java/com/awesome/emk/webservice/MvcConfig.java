package com.awesome.emk.webservice;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.postgresql.ds.PGSimpleDataSource;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/denied").setViewName("access-denied");
	}
	
	@Bean(name="authDataSource")
	public DataSource getAuthDataSource() {
		PGSimpleDataSource result = new PGSimpleDataSource();
		result.setUrl("jdbc:postgresql://localhost:5432/webshop");
		result.setUser("awesome");
		result.setPassword("123");
		return result;
	}
}
