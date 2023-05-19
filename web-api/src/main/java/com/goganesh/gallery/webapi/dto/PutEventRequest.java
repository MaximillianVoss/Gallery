package com.goganesh.gallery.webapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class PutEventRequest {
    @NotNull
    private UUID id;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private String start;

    @NotNull
    private String end;

    @NotNull
    private UUID typeId;

}
