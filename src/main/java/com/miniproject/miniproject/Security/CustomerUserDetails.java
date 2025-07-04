package com.miniproject.miniproject.Security;

import com.miniproject.miniproject.Model.Permission;
import com.miniproject.miniproject.Model.Role;
import com.miniproject.miniproject.Model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class CustomerUserDetails implements UserDetails {
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //Phan quyen tai day
        Set<GrantedAuthority> authorities = new HashSet<>();
        //get role
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            //get authorities
            if (role.getPermissions() != null) {
                for (Permission permission : role.getPermissions()) {
                    authorities.add(new SimpleGrantedAuthority(permission.getCode()));
                }
            }
        }
        return authorities;
    }

    /*.stream()
    //Chuyển List<Role> thành một stream, giúp bạn dễ dàng xử lý từng phần tử bằng lập trình hàm (functional programming).
    .map(role -> new SimpleGrantedAuthority(role.getName()))
    map(...): Duyệt qua từng Role trong danh sách.
    Với mỗi Role, gọi role.getName() để lấy tên role (ví dụ: "ROLE_ADMIN").
    Sau đó tạo ra một object SimpleGrantedAuthority từ tên role đó.
    SimpleGrantedAuthority là một implementation của interface GrantedAuthority.*/
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
