package ru.kpfu.itis.greenmapc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import ru.kpfu.itis.greenmapc.repository.ScheduleRepository;
import ru.kpfu.itis.greenmapc.util.converter.GroupConverter;
import ru.kpfu.itis.greenmapc.util.converter.ScheduleConverter;
import ru.kpfu.itis.greenmapc.util.freemarker.ActionPathMethod;
import ru.kpfu.itis.greenmapc.util.freemarker.HtmlInjectionSecurityMethod;

import java.util.HashMap;
import java.util.Map;


@Configuration
@ComponentScan(basePackages = {"ru.kpfu.itis.greenmapc.controller", "ru.kpfu.itis.greenmapc.aop", "ru.kpfu.itis.greenmapc.service"})
@EnableWebMvc
@EnableAspectJAutoProxy
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private GroupConverter groupConverter;

    @Autowired
    private ScheduleConverter scheduleConverter;

    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();

        // ДОБАВЛЯЕТ КОДИРОВКУ!
        resolver.setContentType("text/html; charset=utf-8");

        resolver.setCache(false);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setRequestContextAttribute("context");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/ftl/");
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");

        freeMarkerConfigurer.setFreemarkerVariables(setFreemarkerVariable());

        return freeMarkerConfigurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("/assets/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(groupConverter);
        registry.addConverter(scheduleConverter);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("classpath:errorMessages/errors");
        resourceBundleMessageSource.setCacheSeconds(0);
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        resourceBundleMessageSource.setUseCodeAsDefaultMessage(false);
        return resourceBundleMessageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator(){
        return new LocalValidatorFactoryBean();
    }

    @Bean
    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public GroupConverter groupListConverter() {
        return new GroupConverter();
    }

    @Bean
    public ScheduleConverter scheduleConverter() {
        return new ScheduleConverter();
    }

    private Map<String, Object> setFreemarkerVariable() {
        Map<String, Object> map = new HashMap<>();
        map.put("action", new ActionPathMethod());
        map.put("normalize", new HtmlInjectionSecurityMethod());
        return map;
    }
}