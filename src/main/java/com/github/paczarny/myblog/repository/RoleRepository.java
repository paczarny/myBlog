package com.github.paczarny.myblog.repository;

import com.github.paczarny.myblog.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String Role);
}
