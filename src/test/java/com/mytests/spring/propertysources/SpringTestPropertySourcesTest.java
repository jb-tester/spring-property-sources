package com.mytests.spring.propertysources;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = {"classpath:test_messages.properties"}, properties = {"local.prop1 = l.val1","local.prop2 = ${tm.prop2}", "fm.prop1 = prop1 from testProperties"})
class SpringTestPropertySourcesTest {

    @Value("${tm.prop1}")
    String attr1;
    @Value("${local.prop1}")
    String attr2;
    @Value("${local.prop2}")
    String attr3;

    @Autowired Bean1 b1;

    @Test
    void testProperties() {
        String rez = b1.beanMethod1(attr1,attr2, attr3);
        assertEquals("test arguments: tm_value1; l.val1; tm_value2;", rez);
    }

    @Test
    void testBean1() {
        assertEquals("prop1 from testProperties", b1.getAttr1());
        assertEquals("xml_value1", b1.getAttr2());
        assertEquals("property from second_messages", b1.getAttr3());
    }
}
