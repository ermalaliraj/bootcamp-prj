package com.bootcamp.ms.profile.service;

import com.bootcamp.ms.profile.dto.mapper.UserDtoMapper;
import com.bootcamp.ms.profile.exception.EntityNotFoundException;
import com.bootcamp.ms.profile.model.Role;
import com.bootcamp.ms.profile.model.User;
import com.bootcamp.ms.profile.queryparam.UserQueryParam;
import com.bootcamp.ms.profile.repository.UserRepository;
import com.bootcamp.ms.profile.repository.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserDtoMapper userDtoMapper;

    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    public Page<User> findAll(UserQueryParam params, Pageable pageable) {
        return repository.findAll(new UserSpecification(params), pageable);
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }


    public User update(User newUser) {
        final String id = newUser.getId();
        User oldUser = findById(id).orElseThrow(() -> new EntityNotFoundException(User.class, id));
        userDtoMapper.updateEntity(newUser, oldUser);
        return repository.save(oldUser);
    }

//    public User updateUserRoles(List<Role> roles, String id) {
//        User oldUser = findById(id).orElseThrow(() -> new EntityNotFoundException(User.class, id));
//        oldUser.setRoles(roles);
//        return repository.save(oldUser);
//    }

}
