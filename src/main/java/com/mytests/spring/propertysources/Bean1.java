package com.mytests.spring.propertysources;

/**
 * *
 * <p>Created by irina on 5/9/2022.</p>
 * <p>Project: spring-property-sources</p>
 * *
 */
public class Bean1 {
    private final String attr1;
    private final String attr2;
    private final String attr3;

    public Bean1(String attr1, String attr2, String attr3) {
        this.attr1 = attr1;
        this.attr2 = attr2;
        this.attr3 = attr3;
    }

    public String getAttr1() {
        return attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public String beanMethod1(String arg1, String arg2, String arg3) {
        return "test arguments: "  + arg1 + "; " + arg2 + "; " + arg3 +";";
    }
}
