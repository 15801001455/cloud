package com.funtl.hello.spring.boot.druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.funtl.hello.spring.boot.druid.dao")
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class HelloSpringBootDruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootDruidApplication.class, args);
	}

}
