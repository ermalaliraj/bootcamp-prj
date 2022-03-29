package com.bootcamp.ms.profile.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto extends BaseDto {
    private String id;
    private String name;
    private String email;
    private String gender;
    private String status;

//    @JsonProperty("status")
//    public void setIsStatus(boolean isDel) {
//        this.status = String.valueOf(isDel);
//    }
//    private List<RoleDto> roles = new ArrayList<>();
}
