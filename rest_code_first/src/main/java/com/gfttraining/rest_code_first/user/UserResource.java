package com.gfttraining.rest_code_first.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    @Autowired
    private UserDAOService serviceUser;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return serviceUser.findAll();
    }
    
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        
        User user = serviceUser.findOne(id);
        if(user == null) throw new UserNotFoundException("id - = "+ id + " no existe");
        return user;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        serviceUser.save(user);
    }
}
