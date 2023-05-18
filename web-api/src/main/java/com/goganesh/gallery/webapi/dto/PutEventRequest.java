package com.goganesh.gallery.webapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private LocalDate start;

    @NotNull
    private LocalDate end;

    @NotNull
    @JsonProperty("type_id")
    private UUID typeId;

}
