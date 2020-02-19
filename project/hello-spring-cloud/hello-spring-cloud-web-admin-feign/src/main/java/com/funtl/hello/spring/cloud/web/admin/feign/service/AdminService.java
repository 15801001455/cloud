package com.funtl.hello.spring.cloud.web.admin.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//通过 @FeignClient("服务名") 注解来指定调用哪个服务。代码如下：
@FeignClient(value = "hello-spring-cloud-service-admin")
public interface AdminService {
    //service层要加RequestMapping注解，因为这里才是真正调用eureka服务的地方,很容易写错了
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);
}
