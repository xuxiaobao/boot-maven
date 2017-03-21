package com.spring.base;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.template.utility.XmlEscape;

@Configuration
public class FreeMarkerConfigurerWeb implements EnvironmentAware {
	
	private RelaxedPropertyResolver propertyResolver;

	public void setEnvironment(Environment env) {
		this.propertyResolver = new RelaxedPropertyResolver(env, "spring.mvc.view.");
	}
	
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurerBean(){
		FreeMarkerConfigurer fmc = new FreeMarkerConfigurer();
		fmc.setTemplateLoaderPath(propertyResolver.getProperty("prefix"));
		
		fmc.setDefaultEncoding(propertyResolver.getProperty("defaultEncoding"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xml_escape", getXmlEscape());
		fmc.setFreemarkerVariables(map);
		return fmc;
	}
	
	@Bean
	public XmlEscape getXmlEscape(){
		XmlEscape xmle = new XmlEscape();
		
		return xmle;
	}
	
	@Bean("viewResolver")
	public FreeMarkerViewResolver freeMarkerViewResolverr(){
		FreeMarkerViewResolver fmvr = new FreeMarkerViewResolver();
		fmvr.setContentType(propertyResolver.getProperty("contentType"));
		fmvr.setViewNames(propertyResolver.getProperty("suffix"));
		fmvr.setSuffix(propertyResolver.getProperty("suffix"));
		fmvr.setCache(Boolean.valueOf(propertyResolver.getProperty("cache")));
		fmvr.setPrefix(propertyResolver.getProperty("prefix"));
		fmvr.setExposeRequestAttributes(true);
		fmvr.setAllowSessionOverride(true);
		fmvr.setExposeSessionAttributes(true);
		fmvr.setExposeSpringMacroHelpers(true);
		return fmvr;
	}
	
}
