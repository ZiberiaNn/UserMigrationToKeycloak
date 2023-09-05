package com.lotrading.usersmigration.service;

import com.lotrading.usersmigration.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface KeycloakService {
    void createUser(User user);
}
