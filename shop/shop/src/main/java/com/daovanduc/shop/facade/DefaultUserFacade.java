package com.daovanduc.shop.facade;

import com.daovanduc.shop.dto.RegisterData;
import com.daovanduc.shop.model.UserModel;
import com.daovanduc.shop.service.UserService;

import javax.annotation.Resource;
import java.util.Objects;

public class DefaultUserFacade implements UserFacade {

    @Resource
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Override
    public UserModel getCurrentUser() {
        return null;
    }

    @Override
    public void register(RegisterData registerData) throws Exception {
        Objects.requireNonNull(registerData);
        UserModel userModel = new UserModel();
        userModel.setFirstName(registerData.getFirstName());
        userModel.setLastName(registerData.getLastName());
        userModel.setEmail(registerData.getEmail());
        userModel.setPassword(registerData.getPassword());
        userModel.setUsername(registerData.getUsername());
        getUserService().register(userModel, registerData.getPassword());
    }
}
