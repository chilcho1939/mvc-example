package com.example.mvc.demo.service;

import com.example.mvc.demo.dto.UserDTO;

import java.util.List;

public interface UsuarioService {

    void create(UserDTO user);

    UserDTO getByName(String name);

    UserDTO deleteByID(Integer id);

    void update(UserDTO user, int useriD);


    List<UserDTO> findAll();
}
