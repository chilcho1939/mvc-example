package com.example.mvc.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    private String name;
    private String lastname;
}
