package com.gfttraining.rest_code_first.hello;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String helloWorld(){
        return "We are in busines!";
    }

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name){
        return "Hello " + name ;
    }

    @GetMapping("/greetingFull/{name}/{lastName}")
    public String greetingFull(@PathVariable String name, @PathVariable String lastName){
        return "Hello " + name + " " + lastName;
    }

    @GetMapping("/helloBean")
    public HelloBean helloWorldBean(){
        return new HelloBean("Afayaivos!");
    }

    @GetMapping("/helloBeanRe")
    public ResponseEntity<HelloBean> helloWorldBeanRe(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Language", "ast");
        
        return new ResponseEntity(new HelloBean("Afayaivos re"), headers, HttpStatus.OK);
    }
}
