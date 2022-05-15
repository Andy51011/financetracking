package com.v1.financetracker.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //find all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // find a single user
    public User findUser(Long id) {
        return userRepository.getById(id);
    }

    // return true if deleted
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    // adds new user
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    //update user
    public User updateUser(Long id , User updatedUser) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User _user = user.get();
            _user.setUserId(updatedUser.getUserId());
            _user.setUsername(updatedUser.getUsername());
            _user.setEmail(updatedUser.getEmail());
            _user.setFirstName(updatedUser.getFirstName());
            _user.setLastName(updatedUser.getLastName());
            _user.setPassword(updatedUser.getPassword());
            return userRepository.save(_user);
        } else {
            return null;
        }
    }
}
