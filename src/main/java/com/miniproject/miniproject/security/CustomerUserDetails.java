package com.miniproject.miniproject.security;

import com.miniproject.miniproject.model.Role;
import com.miniproject.miniproject.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class CustomerUserDetails implements UserDetails {
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //Phan quyen tai day
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
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

    public String getEmail() {
        return user.getEmail();
    }

    public String getUserId() {
        return user.getId();
    }

    public String getAvatar() {
        return user.getAvatar();
    }

    public List<Role> getRole() {
        return user.getRoles();
    }
}
