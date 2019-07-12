package com.chinadep.fuxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.chinadep.fuxing")
public class ChanseyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChanseyApplication.class, args);
    }
}
