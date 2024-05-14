package com22.rest1.dto.authenticationDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
