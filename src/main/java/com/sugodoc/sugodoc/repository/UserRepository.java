package com.sugodoc.sugodoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sugodoc.sugodoc.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
    List<User> findAll();
    User findById(long id);
}
