package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 12/21/2016.
 */

@RestController
@SpringBootApplication
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name){
        if (name.isEmpty()|| name==null) {
            throw new IllegalArgumentException("the 'name' parameter should not be null or empty");
        }
        return "hello"+name;
    }




    public static void main(String[] args) {
        SpringApplication.run(HelloController.class,args);
    }
}
