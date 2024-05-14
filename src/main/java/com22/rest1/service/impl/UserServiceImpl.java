package com22.rest1.service.impl;

import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.userDto.UserRequest;
import com22.rest1.dto.userDto.UserResponse;
import com22.rest1.entity.User;
import com22.rest1.globalException.NotFoundException;
import com22.rest1.repository.UserRepository;
import com22.rest1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponse> getAll() {
        return userRepository.getAll();
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found with id " + id)
        );
        return UserResponse.entityToResponse(user);
    }

    @Override
    public SimpleResponse save(UserRequest userRequest) {
        User user = userRequest.requestToEntity();
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        if(user.getRole().toString().equals("ADMIN")) {
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .message("ADMIN can not save other admin")
                    .note("choose another role: {'WAITER', 'SHEF', 'COOK'}")
                    .build();
        }
        userRepository.save(user);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User saved")
                .build();
    }

    @Override
    public SimpleResponse update(Long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found with id " + id)
        );
        userRepository.save(userRequest.requestToEntityForUpdate(user));
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User updated with  id "+ user.getId())
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found with id " + id)
        );
        userRepository.deleteById(id);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User deleted with id " + id)
                .build();
    }
}
