package com.lotrading.usersmigration.service.Impl;

import com.lotrading.usersmigration.domain.User;
import com.lotrading.usersmigration.service.KeycloakService;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class KeycloakServiceImpl implements KeycloakService {
    @Autowired
    private Keycloak keycloak;
    @Override
    public void createUser(User user) {
        CredentialRepresentation password = preparePasswordRepresentation(user.getPassword());
        UserRepresentation newUser = prepareUserRepresentation(user, password);
        keycloak
                .realm("lotrading")
                .users()
                .create(newUser);
    }
    private CredentialRepresentation preparePasswordRepresentation(String password){
        CredentialRepresentation cR = new CredentialRepresentation();
        cR.setTemporary(false);
        cR.setType(CredentialRepresentation.PASSWORD);
        cR.setValue(password);
        return cR;
    }
    private UserRepresentation prepareUserRepresentation(User user, CredentialRepresentation cR){
        UserRepresentation newUser = new UserRepresentation();
        newUser.setUsername(user.getUsername());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setEnabled(true);
        newUser.setCredentials(Collections.singletonList(cR));
        return newUser;
    }
}
