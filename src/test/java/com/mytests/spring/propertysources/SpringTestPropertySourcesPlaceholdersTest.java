package com.mytests.spring.propertysources;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = {"classpath:test_messages.properties"}, properties = {"local.prop1 = l.val1","local.prop2 = l.val2", "fm.prop1 = prop1 from testProperties"})
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
        assertEquals(rez,"test arguments: tm_value1 l.val1 l.val2");
    }

    @Test
    void testBean1() {
        assertEquals(b1.getAttr1(),"prop1 from testProperties");
        assertEquals(b1.getAttr2(),"xm_value1");
    }
}
