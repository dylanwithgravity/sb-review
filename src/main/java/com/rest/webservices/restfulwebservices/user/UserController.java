package com.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userService;

    //GET /user
    //retrieveAllUsers
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
    return userService.findAll();
    }


    //GET users/{id}
    //retrieveUser(int id)
    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userService.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return user;

    }

    //DELETE user/{id}
    //deleteUser(int id)
    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userService.deleteById(id);
        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);


        // create status of created is best practice

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()//returns current request URI
                .path("/{id}")//appends /id to the current request URI
                .buildAndExpand(savedUser.getId())// replaces /id with savedUser.getID
                .toUri();

        return ResponseEntity.created(location).build();


    }
}
