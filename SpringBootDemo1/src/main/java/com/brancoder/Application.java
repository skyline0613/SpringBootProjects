package com.brancoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//這邊使用 Java Class 作為設定，而非XML
@Configuration
//啟用 Spring Boot 自動配置，將自動判斷專案使用到的套件，建立相關的設定。
@EnableAutoConfiguration
//自動掃描 Spring Bean 元件
//@ComponentScan(basePackages = { "com.brancoder", "com.brancoder.controller" })

@ImportResource("classpath:app-config.xml")
@SpringBootApplication
public class Application {
	private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
		LOGGER.info("SpringApplication start success!");
    }
}
