package com.mytests.spring.propertysources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * *
 * <p>Created by irina on 6/8/2022.</p>
 * <p>Project: spring-property-sources</p>
 * *
 */
@SpringBootTest
public class DynamicPropertySourcesTest {

    private static MyPropertiesProvider provider = new MyPropertiesProvider();

    @DynamicPropertySource  // no validation for the method signature - https://youtrack.jetbrains.com/issue/IDEA-272357
    static void messProperties(DynamicPropertyRegistry registry) {
        registry.add("dynamic.props.test.prop1", provider::firstProperty);
        registry.add("dynamic.props.test.prop2", provider::secondProperty);
    }
    @Value("${dynamic.props.test.prop1}")
    String mess1;
    @Value("${dynamic.props.test.prop2}")
    String mess2;

    @Test
    public void testMess1(){
        assertEquals(mess1,"hello");
    }
    @Test
    public void testMess2(){
        assertEquals(mess2,"bye");
    }

    private static class MyPropertiesProvider {
        public String firstProperty() {
            return "hello";
        }

        public String secondProperty() {
            return "bye";
        }
    }
}
