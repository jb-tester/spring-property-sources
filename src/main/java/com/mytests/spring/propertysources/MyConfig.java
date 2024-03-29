package com.mytests.spring.propertysources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * *
 * <p>Created by irina on 5/9/2022.</p>
 * <p>Project: spring-property-sources</p>
 * *
 */
@Configuration
@PropertySource({"classpath:first_messages.properties",
                 "classpath:xml_messages.xml",
                 "classpath:${local.props-location}"})
public class MyConfig {
    @Value("${fm.prop1}")  // from first_messages.properties
    String attr1;
    @Value("${xm.prop1}") // from xml_messages.xml
    String attr2;
    @Value("${sm.prop1}") // from ${local.props-location} (second_messages.properties)
    String attr3;
    @Value("${spring.application.name}") // from application.properties
    @Bean
    public Bean1 b1() {
        return new Bean1(attr1,attr2,attr3);
    }

}
