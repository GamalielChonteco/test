package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class UsuarioDto {
    @JsonProperty("id")
    private int id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("avatar")
    private String avatar;
}
