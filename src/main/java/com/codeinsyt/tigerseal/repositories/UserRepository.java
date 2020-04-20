package com.codeinsyt.tigerseal.repositories;

import com.codeinsyt.tigerseal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
