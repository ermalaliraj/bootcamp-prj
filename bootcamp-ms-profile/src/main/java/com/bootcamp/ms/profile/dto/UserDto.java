package com.bootcamp.ms.profile.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto extends BaseDto {
    private String id;
    private String name;
    private String email;
    private String gender;
    private boolean status;

//    private List<RoleDto> roles = new ArrayList<>();
}
