package com.daovanduc.shop.service;

import com.daovanduc.shop.model.UserModel;

public interface UserService {
    void register(UserModel userModel, String password) throws Exception;
}
