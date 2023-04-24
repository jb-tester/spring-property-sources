package com.mytests.spring.propertysources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file_in_src_resources_root.properties") // no warnings should be reported, resolve should work
public class ConfigPropertiesWithoutPrefix {


    @Value("${thm.prop1}")
    String testStr1;

    @Bean
    public String strBean() {
        return testStr1;
    }

}
