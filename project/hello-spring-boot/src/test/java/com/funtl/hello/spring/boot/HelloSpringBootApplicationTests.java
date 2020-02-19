package com.funtl.hello.spring.boot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
/**
 * classes = HelloSpringBootApplication.class 这一句的意思是让单元测试类能装载到src/main/resources/下面的application.yml作为配置文件
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloSpringBootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloSpringBootApplicationTests {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    //@BeforeAll
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void contextLoads() {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        //assertThat(response.getBody(),equalTo("Hello Spring Boot"));
        assert(response.getBody().equals("Hello Spring Boot"));
    }

}
