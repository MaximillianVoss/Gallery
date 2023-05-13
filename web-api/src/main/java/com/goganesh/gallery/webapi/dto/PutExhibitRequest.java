package com.goganesh.gallery.webapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class PutExhibitRequest {
    @NotNull
    private UUID id;
    @NotBlank
    private String name;
    private String description;
    @NotNull
    @JsonProperty("author_id")
    private UUID authorId;
    @NotNull
    @JsonProperty("type_id")
    private UUID typeId;

}
