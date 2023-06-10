package com.cgesgin.locationmanagmentapi.service.userService;

import com.cgesgin.locationmanagmentapi.core.dto.UserDto;
import com.cgesgin.locationmanagmentapi.core.dto.UserLoginDto;
import com.cgesgin.locationmanagmentapi.exception.BusinessException;

public interface IUserService {
    boolean login(UserLoginDto userLoginDto) throws BusinessException;
    boolean register(UserDto userDto) throws BusinessException;
}
