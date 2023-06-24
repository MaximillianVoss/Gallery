package com.goganesh.gallery.webapi.dto;

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
    private UUID authorId;

    @NotNull
    private UUID typeId;

    @NotNull
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
    private UUID styleId;

    @NotNull
    private UUID genreId;

    @NotNull
    private UUID statusId;
}
