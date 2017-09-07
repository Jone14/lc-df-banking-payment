package com.lc.df.banking.payment.sercvice.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RestConfiguration {

	@Bean
	public RequestMappingHandlerAdapter annotationMethodHandlerAdapter() {
		final RequestMappingHandlerAdapter annotationMethodHandlerAdapter = new RequestMappingHandlerAdapter();
		List<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter mapper = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL).setSerializationInclusion(Include.NON_EMPTY);
		mapper.setObjectMapper(objectMapper);
		httpMessageConverters.add(mapper);
		annotationMethodHandlerAdapter.setMessageConverters(httpMessageConverters);
		return annotationMethodHandlerAdapter;
	}

}
