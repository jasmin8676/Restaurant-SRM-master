package com22.rest1.api;

import com22.rest1.dto.userDto.UserResponse;
import com22.rest1.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.userDto.UserRequest;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class UserApi {

    private final UserService userService;

    @GetMapping("getAll")
    @Operation(summary = "to get all users")
    List<UserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/getById")
    @Operation(summary = "to get user by id")
    UserResponse getById(@RequestParam Long id) {
        return userService.getById(id);
    }

    @PostMapping
    @Operation(summary = "to save new user")
    SimpleResponse save(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @DeleteMapping()
    @Operation(summary = "to delete a user")
    SimpleResponse delete(@RequestParam Long id) {
        return userService.delete(id);
    }

    @PutMapping("")
    @Operation(summary = "to update a user")
    SimpleResponse updateMap(@RequestParam Long id,
                             @RequestBody UserRequest userRequest, Principal principal) {
        System.out.println("principal.getName() = " + principal.getName());
        return userService.update(id, userRequest);
    }

}
