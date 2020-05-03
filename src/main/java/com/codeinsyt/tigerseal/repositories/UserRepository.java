package com.codeinsyt.tigerseal.repositories;

import com.codeinsyt.tigerseal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String user, String password);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User e SET e.stat = ?2 WHERE e.id = ?1")
    @Transactional
    int softDelete(Long id, String status);

    List<User> findAllByStatOrderByIdAsc(String status);

    @Query(
            value = "SELECT * FROM users_roles INNER JOIN app_users ON app_users.id = users_roles.user_id \n" +
                    "INNER JOIN roles ON roles.id = users_roles.role_id WHERE roles.role = ?1 AND app_users.stat !='deleted'",
            nativeQuery = true)
    List<User> findAllByRole(String role);

    @Query(
            value = "SELECT * FROM users_roles INNER JOIN app_users ON app_users.id = users_roles.user_id \n" +
                    "INNER JOIN roles ON roles.id = users_roles.role_id WHERE roles.role != 'OWNER' AND app_users.stat !='deleted'",
            nativeQuery = true)
    List<User> findAllUsers();


}
