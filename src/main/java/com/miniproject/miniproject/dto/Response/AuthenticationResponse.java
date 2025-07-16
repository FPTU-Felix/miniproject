package com.miniproject.miniproject.dto.Response;

import com.miniproject.miniproject.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String accessToken;
    private String username;
    private String fullname;
    private String email;
    private String avatar;
    private List<Role> roles;
}
