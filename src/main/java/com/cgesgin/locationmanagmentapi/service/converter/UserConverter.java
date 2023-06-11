package com.cgesgin.locationmanagmentapi.service.converter;

import org.springframework.stereotype.Component;

import com.cgesgin.locationmanagmentapi.core.dto.UserDto;
import com.cgesgin.locationmanagmentapi.core.dto.UserLoginDto;
import com.cgesgin.locationmanagmentapi.core.entity.User;

@Component
public class UserConverter {
    
    public User convertDtoToEntity(UserDto dto){
        
        User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());

        return user;
    }

    public User convertDtoToEntity(UserLoginDto dto){
        
        User user = new User();
        user.setFirstname(null);
        user.setLastname(null);
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhone(null);
        
        return user;
    }
}
