package com.goganesh.gallery.webapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
public class PostExhibitRequest {
    @NotBlank
    private String name;

    @NotNull
    @JsonProperty("author_id")
    private UUID authorId;

    @NotNull
    @JsonProperty("type_id")
    private UUID typeId;

    @NotNull
    @JsonProperty("storage_condition_id")
    private UUID storageConditionId;

    @NotNull
    @Positive
    private Integer year;

    @NotNull
    @Positive
    private Integer length;

    @NotNull
    @Positive
    private Integer width;

    @NotNull
    @JsonProperty("style_id")
    private UUID styleId;

    @NotNull
    @JsonProperty("genre_id")
    private UUID genreId;
}
