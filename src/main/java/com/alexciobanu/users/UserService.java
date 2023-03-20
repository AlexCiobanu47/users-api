package com.alexciobanu.users;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public void addUser(User user){
        userRepository.insert(user);
    }
    public void deleteUser(ObjectId id){
        userRepository.deleteById(id);
    }
    public void updateUser(ObjectId id, User user){
        if(userRepository.existsById(id)){
            User userToBeUpdated = new User();
            userToBeUpdated.setId(id);
            userToBeUpdated.setUsername(user.getUsername());
            userToBeUpdated.setName(user.getName());
            userToBeUpdated.setEmail(user.getEmail());
            userRepository.save(userToBeUpdated);
        }
        else throw new IllegalStateException(String.format("User with id %s doesn't exist.", id));
    }
}
