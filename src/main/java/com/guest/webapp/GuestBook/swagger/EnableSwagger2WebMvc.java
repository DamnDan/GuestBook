package com.guest.webapp.GuestBook.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationWebMvcConfiguration;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Indicates that Swagger support should be enabled.
 *
 * This should be applied to a Spring java config and should have an accompanying '@Configuration' annotation.
 *
 * Loads all required beans defined in @see SpringSwaggerConfig
 *
 *
 */
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = { java.lang.annotation.ElementType.TYPE })
@Documented
@Import({Swagger2DocumentationWebMvcConfiguration.class})
@ConditionalOnWebApplication
public @interface EnableSwagger2WebMvc {
}