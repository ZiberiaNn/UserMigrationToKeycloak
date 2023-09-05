package com.lotrading.usersmigration.data;

import com.lotrading.usersmigration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            value = "SELECT\n" +
                    "    nm_employee_id,\n" +
                    "    cd_login,\n" +
                    "    ds_first_name,\n" +
                    "    ds_last_name,\n" +
                    "    ds_email_address,\n" +
                    "    cd_passwordaccess\n" +
                    "FROM (\n" +
                    "    SELECT\n" +
                    "        employees.nm_employee_id,\n" +
                    "        employees.cd_login,\n" +
                    "        employees.ds_first_name,\n" +
                    "        employees.ds_last_name,\n" +
                    "        emails.ds_email_address,\n" +
                    "        employees.cd_passwordaccess,\n" +
                    "        ROW_NUMBER() OVER (PARTITION BY employees.nm_employee_id ORDER BY employees.nm_employee_id) AS row_num\n" +
                    "    FROM\n" +
                    "        lotradingdb.t_sec_employees employees\n" +
                    "    RIGHT JOIN\n" +
                    "        lotradingdb.t_sec_employee_emails emails ON emails.nm_employee_id = employees.nm_employee_id\n" +
                    "    WHERE\n" +
                    "        employees.dt_disabled IS NULL\n" +
                    ") AS ranked\n" +
                    "WHERE\n" +
                    "    row_num = 1;",
            nativeQuery = true)
    List<User> findAllUsers();
}
