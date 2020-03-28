package it.lombardia.hackaton.certificami.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.indra.es.utils.constants.CommonApplicationConstants;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebMvc
@Slf4j
public class WebConfigurer implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**").allowedMethods("*").allowedHeaders("*").allowedOrigins("*");
	}
	
	@Override
	public Validator getValidator() {
		
		return null;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {}
	
	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {}
	
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {}
	
}