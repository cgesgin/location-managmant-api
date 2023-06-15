package com.cgesgin.locationmanagmentapi.service.userservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cgesgin.locationmanagmentapi.core.dto.UserDto;
import com.cgesgin.locationmanagmentapi.core.dto.UserLoginDto;
import com.cgesgin.locationmanagmentapi.core.entity.User;
import com.cgesgin.locationmanagmentapi.exception.BusinessException;
import com.cgesgin.locationmanagmentapi.exception.ErrorModel;
import com.cgesgin.locationmanagmentapi.exception.ErrorType;
import com.cgesgin.locationmanagmentapi.repository.UserRepository;
import com.cgesgin.locationmanagmentapi.service.converter.UserConverter;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private UserConverter userConverter;

    public UserService(UserRepository userRepository,UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter=userConverter;
    }

    @Override
    public boolean login(UserLoginDto userLoginDto) throws BusinessException {
        boolean success = false;
        User user = this.userRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
        if(user == null) {
            List<ErrorModel> errors = new ArrayList<>();
            ErrorModel error = new ErrorModel();
            error.setCode(ErrorType.AUTH_INVALID_CEREDENTIAL.toString());
            error.setMessage("Incorrect password or username");
            errors.add(error);
            throw new BusinessException(errors);
        }else{
            success = true;
        }
        return success;
    }

    @Override
    public boolean register(UserDto userDto) throws BusinessException {
        
        var user=this.userRepository.findByEmail(userDto.getEmail());

        if(user !=null){
            List<ErrorModel> errors = new ArrayList<>();
            ErrorModel error = new ErrorModel();
            error.setCode(ErrorType.ALREADY_EXISTS.toString());
            error.setMessage("Email already exists");
            errors.add(error);
            throw new BusinessException(errors);
        }

        this.userRepository.save(this.userConverter.convertDtoToEntity(userDto));
        return true;
    }
}
