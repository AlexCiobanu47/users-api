package com.alexciobanu.users;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable ObjectId id){
        return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
    }
    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}
