package com.sugodoc.sugodoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sugodoc.sugodoc.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findAll();
    Role findById(long id);
}
