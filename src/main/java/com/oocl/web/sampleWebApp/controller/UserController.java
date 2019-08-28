package com.oocl.web.sampleWebApp.controller;

import com.oocl.web.sampleWebApp.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<User>(){{
//        add(new User("luna"));
//        add(new User("liuyinping"));
    }};

    @GetMapping
    public ResponseEntity<List<User>> queryUsers(){
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
