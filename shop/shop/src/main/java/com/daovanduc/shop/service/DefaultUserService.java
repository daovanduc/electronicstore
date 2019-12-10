package com.daovanduc.shop.service;

import com.daovanduc.shop.model.UserModel;
import com.daovanduc.shop.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class DefaultUserService implements UserService {
    @Resource
    private UserDao userDao;

    @Transactional
    @Override
    public void register(UserModel userModel, String password) throws Exception {
        Optional<UserModel> user = Optional.ofNullable(userDao.findByUsername(userModel.getUsername()));
        if (user.isPresent()){
            throw new Exception(String.format("user with name '%s' already exist", userModel.getUsername()));
        }else {
            userDao.save(userModel);
        }
    }
}
