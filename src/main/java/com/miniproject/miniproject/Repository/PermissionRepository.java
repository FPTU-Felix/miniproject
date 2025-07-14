package com.miniproject.miniproject.Repository;

import com.miniproject.miniproject.Model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
}
