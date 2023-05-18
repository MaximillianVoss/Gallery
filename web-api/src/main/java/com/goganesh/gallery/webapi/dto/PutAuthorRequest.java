package com.goganesh.gallery.webapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class PutAuthorRequest {
    @NotNull
    private UUID id;

    @NotBlank
    private String name;

}
