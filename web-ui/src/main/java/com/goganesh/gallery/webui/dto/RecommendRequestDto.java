package com.goganesh.gallery.webui.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
public class RecommendRequestDto {
    @NotBlank
    private UUID eduId;

    @NotBlank
    private UUID genreId;

    @NotBlank
    private UUID sexId;

    @NotBlank
    private UUID styleId;

    @NotBlank
    @Positive
    private Integer age;
}
