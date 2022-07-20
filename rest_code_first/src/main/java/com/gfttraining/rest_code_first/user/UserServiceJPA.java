package com.gfttraining.rest_code_first.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceJPA {
    @Autowired
    private UserRepository userRepository;
    
    public User findOne(Integer id){
        return userRepository.findById(id).get();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public List<User> findSome(int numItems){
        return userRepository.findAll().subList(0, numItems);
    }
}
