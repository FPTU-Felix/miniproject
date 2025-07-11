package com.miniproject.miniproject.Repository;

import com.miniproject.miniproject.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
