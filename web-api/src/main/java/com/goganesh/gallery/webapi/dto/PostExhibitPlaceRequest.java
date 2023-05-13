package com.goganesh.gallery.webapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class PostExhibitPlaceRequest {
    @NotNull
    @JsonProperty("place_id")
    private UUID placeId;

    @NotBlank
    private String comment;
}
