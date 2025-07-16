package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
}
