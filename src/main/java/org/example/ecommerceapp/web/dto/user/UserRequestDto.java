package org.example.ecommerceapp.web.dto.user;

import lombok.Data;

@Data
public class UserRequestDto {
    private String email;
    private String password;
    private String username;
}
