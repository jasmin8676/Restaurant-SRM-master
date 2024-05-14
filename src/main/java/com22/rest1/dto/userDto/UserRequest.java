package com22.rest1.dto.userDto;

import com22.rest1.entity.User;
import com22.rest1.enums.Role;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserRequest(
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String email,
        String password,
        String phoneNumber,
        Role role,
        int experience
) {

    public User requestToEntity() {
        return User.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .dateOfBirth(this.dateOfBirth)
                .email(this.email)
                .password(this.password)
                .phoneNumber(this.phoneNumber)
                .role(this.role)
                .experience(this.experience)
                .build();
    }

    public User requestToEntityForUpdate(User user) {
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setDateOfBirth(this.dateOfBirth);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setPhoneNumber(this.phoneNumber);
        user.setRole(this.role);
        user.setExperience(this.experience);
        return user;
    }

}
