package com.mytests.spring.propertysources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class SpringPropertySourcesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringPropertySourcesApplication.class, args);
    }

    @Autowired
    ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        Bean1 b1 = ctx.getBean(Bean1.class);
        System.out.println(b1.getAttr1());
        System.out.println(b1.getAttr2());
    }
}
