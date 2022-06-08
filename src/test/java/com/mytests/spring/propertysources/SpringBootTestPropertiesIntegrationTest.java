package com.mytests.spring.propertysources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = { "sbtest.prop1=overriden_prop1", "sbtest.prop3=annotation_only.prop3" })
public class SpringBootTestPropertiesIntegrationTest {

    @Value("${sbtest.prop1}") String prop1;
    @Value("${sbtest.prop2}") String prop2;
    @Value("${sbtest.prop3}") String prop3;


    @Test
    public void shouldSpringBootTestAnnotation_overridePropertyValues() {


        assertEquals("overriden_prop1", prop1);
        assertEquals("default_prop2", prop2);
        assertEquals("annotation_only.prop3", prop3);
    }
}