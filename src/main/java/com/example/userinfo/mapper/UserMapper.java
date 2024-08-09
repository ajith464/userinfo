package com.example.userinfo.mapper;

import com.example.userinfo.dto.UserInfoDto;
import com.example.userinfo.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Ajith
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserInfoDto toUserDto(UserInfo user);

    UserInfo toUserInfoEntity(UserInfoDto userDto);

    UserInfo updateUserInfoEntity(UserInfo userFromDB);
}
