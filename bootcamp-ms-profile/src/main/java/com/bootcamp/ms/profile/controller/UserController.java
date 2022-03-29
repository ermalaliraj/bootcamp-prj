package com.bootcamp.ms.profile.controller;

import com.bootcamp.ms.profile.dto.PageDto;
import com.bootcamp.ms.profile.dto.UserDto;
import com.bootcamp.ms.profile.dto.mapper.UserDtoMapper;
import com.bootcamp.ms.profile.model.User;
import com.bootcamp.ms.profile.queryparam.UserQueryParam;
import com.bootcamp.ms.profile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDtoMapper userDtoMapper;
//    @Autowired
//    private RoleDtoMapper roleDtoMapper;

    @GetMapping(value = "/{id}", produces = "application/json")
    public UserDto findById(@PathVariable("id") String id) {
        User user = userService.findById(id).orElse(null);
        return userDtoMapper.toDto(user);
    }

    @GetMapping(produces = "application/json")
    public PageDto<UserDto> findAll(UserQueryParam params, Pageable pageable) {
        Page<User> page = userService.findAll(params, pageable);
        return userDtoMapper.toPageDto(page);
    }

    @PostMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public UserDto importUsersExternal(@PathVariable("id") String id) {
        try {
            UserDto newDto = new UserDto();
            URL url = new URL("https://gorest.co.in/public/v2/users");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.connect();
            if (conn.getResponseCode() == 200) {
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    String temp = scan.nextLine();
                    System.out.println("PRINT " + temp);


                    //parse json here...........................
                    String extUser = id;


                }
                newDto = new UserDto();
                newDto.setId(id);
                User user = userDtoMapper.toEntity(newDto);
                user = userService.insert(user);
                newDto = userDtoMapper.toDto(user);
            }
            return newDto;
        } catch (Exception e) {
            throw new IllegalStateException("Error", e);
        }
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public UserDto insert(@RequestBody UserDto dto) {
        User user = userDtoMapper.toEntity(dto);
        user = userService.insert(user);
        return userDtoMapper.toDto(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") String id) {
        userService.delete(id);
    }

    @PutMapping(value = "/{id}/{enabled}")
    public void enableUser(@PathVariable("id") String id, @PathVariable("enabled") boolean enabled) {
        userService.enableUser(id, enabled);
    }

}

