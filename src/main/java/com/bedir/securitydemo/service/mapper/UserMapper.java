package com.bedir.securitydemo.service.mapper;

import com.bedir.securitydemo.entity.UserEntity;
import com.bedir.securitydemo.service.Dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(UserEntity userEntity){
        UserDto dto = new UserDto();
        dto.setId(userEntity.getId());
        dto.setUsername(userEntity.getUsername());
        dto.setPassword(userEntity.getPassword());

        return dto;
    }

    public UserEntity toEntity(UserDto entity){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(entity.getId());
        userEntity.setUsername(entity.getUsername());
        userEntity.setPassword(entity.getPassword());

        return userEntity;
    }

}
