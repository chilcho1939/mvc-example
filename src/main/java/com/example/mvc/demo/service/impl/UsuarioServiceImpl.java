package com.example.mvc.demo.service.impl;

import com.example.mvc.demo.dto.UserDTO;
import com.example.mvc.demo.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {

    List<UserDTO> usuarios = new ArrayList<>();
    long id = 0;

    @Override
    public void create(UserDTO user) {
        usuarios.add(UserDTO.builder()
                .id(++id)
                .name(user.getName())
                .lastname(user.getLastname())
                .build());
    }

    @Override
    public UserDTO getByName(String name) {
        if(usuarios.size() == 0) return null;
        return usuarios.stream()
                .filter(userDto -> userDto.getName().equals(name))
                .findAny().get();
    }

    @Override
    public void update(UserDTO user) {

    }

    @Override
    public List<UserDTO> findAll() {
        return this.usuarios;
    }
}
