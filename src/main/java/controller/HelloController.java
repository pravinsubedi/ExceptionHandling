package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

//    @ExceptionHandler
//    void illegalArgumentExceptionHandler(IllegalArgumentException e,HttpServletResponse response) throws IOException{
//        response.sendError(HttpStatus.BAD_REQUEST.value());
//    }

    //Using Generic Handling

    @ExceptionHandler({IllegalArgumentException.class,NullPointerException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException{
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }



    public static void main(String[] args) {
        SpringApplication.run(HelloController.class,args);
    }
}
