package com.example.userinfo.repository;

import com.example.userinfo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ajith
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {
}
