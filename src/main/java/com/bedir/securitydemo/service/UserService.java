package com.bedir.securitydemo.service;

import com.bedir.securitydemo.entity.UserEntity;
import org.springframework.security.core.userdetails.User;
//import com.bedir.securitydemo.entity.User;
import com.bedir.securitydemo.repository.UserRepository;
import com.bedir.securitydemo.service.Dto.UserDto;
import com.bedir.securitydemo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    private final UserMapper mapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserDto save(UserDto dto){
        UserEntity user = mapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = repository.save(user);
        return mapper.toDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserEntity> user = repository.findByUsername(s);
        if (user.isPresent()){
           // return user.get();
            return new User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("kullanıcı bulunamadı");
        }
    }
}
