package com.gfttraining.rest_code_first.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jpa")
public class UserResourceJPA {
    
    @Autowired
    private UserServiceJPA serviceUser;

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = serviceUser.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("user " + id + " no existe");
        }
        return user;
    }

    @GetMapping("/users")
    public List<User> retrieveUsers(@RequestParam(required = false) Integer numItems){
        
        if (numItems == null) {
            return serviceUser.findAll();
        }
        return serviceUser.findSome(numItems);
    }
}
