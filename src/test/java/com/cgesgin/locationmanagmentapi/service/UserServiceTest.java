package com.cgesgin.locationmanagmentapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cgesgin.locationmanagmentapi.core.dto.UserDto;
import com.cgesgin.locationmanagmentapi.core.dto.UserLoginDto;
import com.cgesgin.locationmanagmentapi.core.entity.User;
import com.cgesgin.locationmanagmentapi.exception.BusinessException;
import com.cgesgin.locationmanagmentapi.repository.UserRepository;
import com.cgesgin.locationmanagmentapi.service.converter.UserConverter;
import com.cgesgin.locationmanagmentapi.service.userservice.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserConverter userConverter;

    @InjectMocks
    private UserService userService;

    @Test
    public void login_actionExecute_resultException() {
        UserLoginDto loginDto = new UserLoginDto();
        loginDto.setEmail("test@example.com");
        loginDto.setPassword("mypassword");
        Mockito.when(this.userRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword())).thenReturn(null);
        Assertions.assertThrows(BusinessException.class, () -> {
            userService.login(loginDto);
        });
    }

    @Test
    public void login_actionExecute_returnTrue() throws BusinessException {
        UserLoginDto loginDto = new UserLoginDto();
        loginDto.setEmail("test@example.com");
        loginDto.setPassword("mypassword");
        
        User user =new User();
        user.setEmail(loginDto.getEmail());
        user.setPassword(loginDto.getPassword());

        Mockito.when(this.userRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword())).thenReturn(user);
        
        var result =userService.login(loginDto);

        Assertions.assertTrue(result);
    }

    @Test
    public void register_actionExecute_resultException() {
        UserDto dto = new UserDto();
        dto.setEmail("test@example.com");
        dto.setPassword("mypassword");

        User user =new User();
        user.setEmail(dto.getEmail());
        user.setEmail(dto.getPassword());

        Mockito.when(this.userRepository.findByEmail(dto.getEmail())).thenReturn(user);
        Assertions.assertThrows(BusinessException.class, () -> {
            userService.register(dto);
        });
    }

    @Test
    public void register_actionExecute_returnTrue() throws BusinessException {
        UserDto dto = new UserDto();
        dto.setEmail("test@example.com");
        dto.setPassword("mypassword");
        
        User user =new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
 
        Mockito.when(this.userConverter.convertDtoToEntity(dto)).thenReturn(user);
        Mockito.when(this.userRepository.save(user)).thenReturn(user);
        
        var result =userService.register(dto);

        Assertions.assertTrue(result);
    }
}
