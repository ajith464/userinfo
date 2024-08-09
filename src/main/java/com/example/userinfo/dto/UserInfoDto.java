package com.example.userinfo.dto;

import lombok.*;

/**
 * @author Ajith
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserInfoDto {
    private Integer userId;
    private String userName;
    private String password;
    private String address;
    private String city;
}
