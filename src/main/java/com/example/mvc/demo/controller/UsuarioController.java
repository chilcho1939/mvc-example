package com.example.mvc.demo.controller;

import com.example.mvc.demo.dto.UserDTO;
import com.example.mvc.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody UserDTO user) {
        usuarioService.create(user);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/getByName/{name}")
    private ResponseEntity<UserDTO> getByName(@PathVariable(name = "name") String name) {
        UserDTO user = usuarioService.getByName(name);
        if(user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(user);
    }
//Delete
    @DeleteMapping(value = "/{userID}/deleteUser")
    private ResponseEntity<List<UserDTO>> deleteUser(@PathVariable int userID){
         this.usuarioService.deleteByID(userID);
        return ResponseEntity.ok(null);
    }
//Put

    private ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO request, @PathVariable int userID){
        this.usuarioService.update(request, userID);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/findAll")
    private ResponseEntity<List<UserDTO>> findAll() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }
}
