package com.alexciobanu.users;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    public IUserRepository userRepository;

    public UserService(IUserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getUser(ObjectId id){
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(
                        String.format("User with id %s doesn't exist.", id)
                )
        );
    }
}
