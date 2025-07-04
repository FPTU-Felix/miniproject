package com.miniproject.miniproject.Service.OTP;

import com.miniproject.miniproject.Model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleByID(String id);
}
