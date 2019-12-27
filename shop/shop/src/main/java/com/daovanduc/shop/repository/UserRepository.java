package com.daovanduc.shop.repository;

import com.daovanduc.shop.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByUsername(String username);
}
