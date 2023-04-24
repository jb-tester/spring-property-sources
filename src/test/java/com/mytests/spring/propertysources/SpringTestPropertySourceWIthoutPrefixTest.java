package com.mytests.spring.propertysources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
/*
@TestPropertySources({
        @TestPropertySource("file_in_src_resources_root.properties"), // should report warning
        @TestPropertySource("file_in_test_resources_root.properties"),  // should show warning
        @TestPropertySource("file_in_same_package.properties") // should resolve!
})

*/

@TestPropertySources({
        @TestPropertySource("classpath:file_in_src_resources_root.properties"), // ok, but not resolved
        @TestPropertySource("classpath:file_in_test_resources_root.properties"),  // ok, but not resolved
        @TestPropertySource("file_in_same_package.properties") // should resolve!
})

//@TestPropertySource("file_in_test_resources_root.properties") // warning is reported - ok!
//@TestPropertySource("file_in_same_package.properties") // resolved - ok!
//@TestPropertySource("classpath:file_in_test_resources_root.properties") // resolved - ok!
public class SpringTestPropertySourceWIthoutPrefixTest {
    @Value("${thm.prop2}")
    String testStr1;
    @Value("${t2m.prop1}")
    String testStr2;
    @Value("${t3m.prop1}")
    String testStr3;

    @Test
    void testSrcProperties() {
        assertEquals(testStr1,"third messages prop2");
    }
    @Test
    void testTestProperties() {

        assertEquals(testStr2,"tm_value1");
    }
    @Test
    void testSamePackageProperties() {

        assertEquals(testStr3,"same package");
    }
}
