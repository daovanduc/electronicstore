package com.daovanduc.shop.converter;

import com.daovanduc.shop.dto.UserDTO;
import com.daovanduc.shop.model.UserModel;
import org.springframework.core.convert.ConversionException;

import java.util.Collection;
import java.util.List;

public class UserConverter implements Converter<UserModel, UserDTO> {

    @Override
    public UserDTO convert(UserModel var1) {
        return new UserDTO().setUsername(var1.getUsername()).setPassword(var1.getPassword());
    }

    @Override
    public UserModel convertDataToModel(UserDTO var3) {
        return null;
    }

    @Override
    public UserDTO convert(UserModel var1, UserDTO var2) throws ConversionException {
        return null;
    }

    @Override
    public List<UserDTO> convertAll(Collection<? extends UserModel> userModels) throws ConversionException {
        return null;
    }
}
