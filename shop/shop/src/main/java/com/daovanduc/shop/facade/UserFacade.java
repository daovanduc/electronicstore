package com.daovanduc.shop.facade;

import com.daovanduc.shop.dto.RegisterData;
import com.daovanduc.shop.dto.UserDTO;
import com.daovanduc.shop.model.UserModel;

public interface UserFacade {
    UserModel getCurrentUser();

    void register(RegisterData registerData) throws Exception;

}
