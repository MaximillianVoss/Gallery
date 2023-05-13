package com.goganesh.gallery.webapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PostAuthorRequest {
    @NotBlank
    private String name;
}
