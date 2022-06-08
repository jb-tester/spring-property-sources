package com.mytests.spring.propertysources;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * *
 * <p>Created by irina on 5/9/2022.</p>
 * <p>Project: spring-property-sources</p>
 * *
 */
@Component
@ConfigurationProperties("local")
public class MyConfProps {

    String prop3;
    String prop4;
    String prop5;
    String prop6;
    String propsLocation;

    public String getProp3() {
        return prop3;
    }

    public void setProp3(String prop3) {
        this.prop3 = prop3;
    }

    public String getProp4() {
        return prop4;
    }

    public void setProp4(String prop4) {
        this.prop4 = prop4;
    }

    public String getProp5() {
        return prop5;
    }

    public void setProp5(String prop5) {
        this.prop5 = prop5;
    }

    public String getProp6() {
        return prop6;
    }

    public void setProp6(String prop6) {
        this.prop6 = prop6;
    }

    public String getPropsLocation() {
        return propsLocation;
    }

    public void setPropsLocation(String propsLocation) {
        this.propsLocation = propsLocation;
    }
}
