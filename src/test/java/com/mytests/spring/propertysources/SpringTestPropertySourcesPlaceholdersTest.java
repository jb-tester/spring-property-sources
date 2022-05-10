package com.mytests.spring.propertysources;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(properties = {"local.prop5 = local prop5","local.prop6 = placeholders: ${local.prop3},${local.prop4},${local.prop5}","local.prop7 = ${foobar}"})
class SpringTestPropertySourcesPlaceholdersTest {

    @Value("${local.prop5}")
    String attr1;
    @Value("${local.prop6}")
    String attr2;
    @Value("${local.prop7}")
    String attr3;

    @Autowired Bean1 b1;

    @Test
    void testProperties() {
        String rez = b1.beanMethod1(attr1,attr2, attr3);
        assertEquals(rez,"test arguments: local prop5; placeholders: local_prop3 from application.properties,local_prop4 from @PropertySource-defined properties,local prop5; barr;");
    }


}
