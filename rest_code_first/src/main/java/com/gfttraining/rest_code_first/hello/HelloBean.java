package com.gfttraining.rest_code_first.hello;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloBean {
    private String message;

    public HelloBean(String message){
        this.message = message;
    }

    @JsonProperty("SomeAmazingMessage")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
