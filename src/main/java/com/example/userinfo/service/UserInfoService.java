package com.example.userinfo.service;

import com.example.userinfo.dto.UserInfoDto;
import com.example.userinfo.entity.UserInfo;
import com.example.userinfo.mapper.UserMapper;
import com.example.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ajith
 */
@Service
public class UserInfoService {

    @Autowired
    UserRepository userRepository;
    public UserInfoDto addUser(UserInfoDto userInfoDto) {
        UserInfo savedUser = userRepository.save(UserMapper.INSTANCE.toUserInfoEntity(userInfoDto));
        return  UserMapper.INSTANCE.toUserDto(savedUser);
    }

    public UserInfoDto fetchUserById(Integer userId) {
         return userRepository.findById(userId)
                .map(UserMapper.INSTANCE::toUserDto)
                 .orElseThrow(RuntimeException::new);
    }

    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

    public void updateUserById(Integer userId, UserInfoDto userInfoDto) {
        UserInfo updatedEntity = userRepository.findById(userId)
                .map(userFromDb -> updateEntity(userInfoDto, userFromDb))
                .orElseThrow(RuntimeException::new);
        userRepository.save(updatedEntity);
    }

    private UserInfo updateEntity(UserInfoDto userInfoDto, UserInfo userFromDb) {
        userFromDb.setUserName(userInfoDto.getUserName());
        userFromDb.setCity(userInfoDto.getCity());
        userFromDb.setAddress(userInfoDto.getAddress());
        userFromDb.setPassword(userInfoDto.getPassword());
        return userFromDb;
    }
}
