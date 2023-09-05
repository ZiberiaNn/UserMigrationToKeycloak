package com.lotrading.usersmigration.service;

import com.lotrading.usersmigration.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAllUsers();
    void createAllUsersInKeycloak();
}
