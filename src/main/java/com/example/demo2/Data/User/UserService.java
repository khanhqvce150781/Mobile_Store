package com.example.demo2.Data.User;

import com.example.demo2.Data.User.User;
import com.example.demo2.Data.User.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserReponsitory repo;
    public List<User> ListAllUsers(){
        return (List<User>) repo.findAll();
    }



}
