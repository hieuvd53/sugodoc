package com.sugodoc.sugodoc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sugodoc.sugodoc.domain.Role;
import com.sugodoc.sugodoc.domain.User;
import com.sugodoc.sugodoc.domain.dto.RegisterDTO;
import com.sugodoc.sugodoc.repository.RoleRepository;
import com.sugodoc.sugodoc.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User handleSaveUser(User user){
        return this.userRepository.save(user);
    }

    public List<User> getAllUser(){
        return this.userRepository.findAll();
    }

    public User getUserById(long id){
        return this.userRepository.findById(id);
    }

    public List<Role> getRoles(){
        return this.roleRepository.findAll();
    }

    public Role getRoleById(long id) {
        return this.roleRepository.findById(id);
    }

    // mapper (transfer từ registerDTO sang object User)
    public User registerDTOtoUser(RegisterDTO registerDTO){
        User user = new User();
        user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        return user;
    }
}
