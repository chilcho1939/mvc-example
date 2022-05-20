package com.example.mvc.demo.service.impl;

import com.example.mvc.demo.dto.UserDTO;
import com.example.mvc.demo.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {

    List<UserDTO> usuarios = new ArrayList<>();
    int id = 0;

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
    public UserDTO deleteByID(Integer id) {
        this.usuarios.remove(deleteByID(id));
        return (UserDTO) usuarios;

    }

    @Override
    public void update(UserDTO request, int useriD) {
        Optional<UserDTO> users = this.usuarios.stream().findAny(useriD);
        UserDTO user = users.get();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
    }


    @Override
    public List<UserDTO> findAll() {
        return this.usuarios;
    }
}
