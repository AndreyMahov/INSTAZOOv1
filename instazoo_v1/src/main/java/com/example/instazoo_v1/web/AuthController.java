package com.example.instazoo_v1.web;

import com.example.instazoo_v1.payLoad.request.LoginRequest;
import com.example.instazoo_v1.payLoad.request.SignupRequest;
import com.example.instazoo_v1.payLoad.response.JWTTTokenSuccessResponse;
import com.example.instazoo_v1.payLoad.response.MessageResponse;
import com.example.instazoo_v1.security.JWTTTokenProvider;
import com.example.instazoo_v1.security.SecurityConstants;
import com.example.instazoo_v1.service.UserService;
import com.example.instazoo_v1.validators.ResponseErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
@PreAuthorize("permitAll()")
public class AuthController {

    @Autowired
    private JWTTTokenProvider jwttTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ResponseErrorValidation responseErrorValidation;
    @Autowired
    private UserService userService;
@PostMapping("/signin")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult){
        ResponseEntity<Object> error = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(error)){
            return error;
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = SecurityConstants.TOKEN_PREFIX + jwttTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTTTokenSuccessResponse(true,jwt));
    }


@PostMapping("/signup")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody SignupRequest signupRequest,
                                           BindingResult bindingResult){
ResponseEntity<Object> error = responseErrorValidation.mapValidationService(bindingResult);
if (!ObjectUtils.isEmpty(error)){
    return error;
}
userService.createUser(signupRequest);
return  ResponseEntity.ok(new MessageResponse("User registered successfully"));

}

}
