package com.mytests.spring.propertysources;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(properties = {"here.prop1 = foo", "here.prop2 = ${here.prop1}bar", "here.prop3 = ${here.prop2}boo"})
class SpringTestPropertySourcesLocalPlaceholdersTest {

    @Value("${here.prop1}")
    String attr1;
    @Value("${here.prop2}")
    String attr2;
    @Value("${here.prop3}")
    String attr3;

    @Autowired Bean1 b1;

    @Test
    void testProperties() {
        String rez = b1.beanMethod1(attr1,attr2, attr3);
        assertEquals("test arguments: foo; foobar; foobarboo;", rez);
    }


}
