package com.forum.system.responses;

import lombok.Data;

@Data
public class AuthResponse {
    String message;
    Long userId;
}
