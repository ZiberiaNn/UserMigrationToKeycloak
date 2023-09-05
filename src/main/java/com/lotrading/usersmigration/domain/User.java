package com.lotrading.usersmigration.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @Column(name = "nm_employee_id")
    private Long id;
    @Column(name = "cd_login")
    private String username;
    @Column(name = "ds_first_name")
    private String firstName;
    @Column(name = "ds_last_name")
    private String lastName;
    @Column(name = "ds_email_address")
    private String email;
    @Column(name = "cd_passwordaccess")
    private String password;
}
