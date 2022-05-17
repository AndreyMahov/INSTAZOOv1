package com.example.instazoo_v1.payLoad.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTTTokenSuccessResponse {
    private boolean success;
    private String token;
}
