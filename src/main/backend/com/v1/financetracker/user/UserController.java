package com.v1.financetracker.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
@CrossOrigin(origins="*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // gets all users
    @GetMapping
    public ResponseEntity<List> getListOfUsers() {
        try {
            List<User> allUsers = userService.getAllUsers();
            if (allUsers != null) {
                return new ResponseEntity<>(allUsers, HttpStatus.OK);
            } else {
                if (allUsers == null) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // get single user
    @GetMapping("/{id}")
    public ResponseEntity<User> findAUser(@PathVariable("id") Long id) {
        try {
            User user = userService.findUser(id);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // register user
    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User newUser = userService.addNewUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    // update user
    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user ){
        try {
            User currUser = userService.updateUser(id, user);
            if (currUser == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(currUser, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @DeleteMapping

}
