package com.cgesgin.locationmanagmentapi.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cgesgin.locationmanagmentapi.core.dto.UserDto;
import com.cgesgin.locationmanagmentapi.service.converter.UserConverter;

@ExtendWith(MockitoExtension.class)
public class UserConverterTest {
    
    @InjectMocks
    private UserConverter userConverter;

    @Test
    public void convertDtoToEntity_actionExecute_resultEntity(){
        UserDto dto=new UserDto();

        dto.setEmail("test@example.com");
        dto.setFirstname("john");
        dto.setFirstname("doe");
        dto.setPhone("123");
        dto.setPassword("1234");


        var resultEntity = this.userConverter.convertDtoToEntity(dto);

        Assertions.assertEquals(dto.getFirstname(), resultEntity.getFirstname());
        Assertions.assertEquals(dto.getLastname(), resultEntity.getLastname());
        Assertions.assertEquals(dto.getEmail(), resultEntity.getEmail());
        Assertions.assertEquals(dto.getPhone(), resultEntity.getPhone());
        Assertions.assertEquals(dto.getPassword(), resultEntity.getPassword());
        
    }
}
