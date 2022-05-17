package com.v1.financetracker.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <User, Long> {

    @Query("SELECT user FROM User user WHERE user.username = ?1 AND user.password = ?2")
    User findUserByNameAndPassword(String username, String password);

}
