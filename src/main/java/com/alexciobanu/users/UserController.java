package com.alexciobanu.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
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
    public ResponseEntity<User> getUser(@PathVariable String id){
        return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
    }
    @PostMapping
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
    @PutMapping(path = "/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User user){
        userService.updateUser(id, user);
    }
}
