package com.dmx.server.config;

import com.dmx.social_graph.shared.infrastructure.spring.ApiExceptionMiddleware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


@Configuration
public class SocialGraphServerConfiguration {

	private final RequestMappingHandlerMapping mapping;

	public SocialGraphServerConfiguration(@Qualifier("requestMappingHandlerMapping") RequestMappingHandlerMapping mapping) {
		this.mapping = mapping;
	}

	@Bean
	public FilterRegistrationBean<ApiExceptionMiddleware> apiExceptionMiddleware() {
		FilterRegistrationBean<ApiExceptionMiddleware> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new ApiExceptionMiddleware(mapping));

		return registrationBean;
	}
}
