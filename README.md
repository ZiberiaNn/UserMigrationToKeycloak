# User Migration from Custom DB to Keycloak

Spring Boot app to migrate users from custom database to Keycloak server.

* Update the *src/main/resources/application.properties* file to match with the properties of the custom database where the users are stored.
* Make sure that *src/main/java/com/lotrading/usersmigration/domain/User.java* entity file contains all the user fields you want to migrate from your custom database to Keycloak. Then, you should also check that *src/main/java/com/lotrading/usersmigration/service/Impl/KeycloakServiceImpl.java* prepareUserRepresentation method maps the UserRepresentation object in a right way, matching with your defined User entity fields (and whatever other Keycloak User field you want to set).
* Adjust the native @Query in *src/main/java/com/lotrading/usersmigration/data/UserRepository.java* findAllUsers method to make it succesfully retrieve all the users you want to migrate.
* Edit the *src/main/java/com/lotrading/usersmigration/config/KeycloakClientConfig.java* keycloak method to match with your Keycloak Server info.
