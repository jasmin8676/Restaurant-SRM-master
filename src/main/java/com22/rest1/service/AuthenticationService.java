package com22.rest1.service;

import com22.rest1.dto.authenticationDto.AuthenticationResponse;
import com22.rest1.dto.authenticationDto.SignInRequest;
import com22.rest1.dto.authenticationDto.SignUpRequest;

public interface AuthenticationService {
    AuthenticationResponse signUp(SignUpRequest signUpRequest);

    AuthenticationResponse signIn(SignInRequest signInRequest);

}
