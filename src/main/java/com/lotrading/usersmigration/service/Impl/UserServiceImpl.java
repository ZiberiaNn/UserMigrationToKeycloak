package com.lotrading.usersmigration.service.Impl;

import com.lotrading.usersmigration.data.UserRepository;
import com.lotrading.usersmigration.domain.User;
import com.lotrading.usersmigration.service.KeycloakService;
import com.lotrading.usersmigration.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private KeycloakService keyCloakService;
    public List<User> findAllUsers(){
        return userRepository.findAllUsers();
    }
    public void createAllUsersInKeycloak(){
        findAllUsers().forEach(user -> keyCloakService.createUser(user));
    }
}
