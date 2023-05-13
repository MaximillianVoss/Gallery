package com.goganesh.gallery.datatablespagination.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PlaceExhibitDataTablesDto {

    private String id;
    private String place;
    private String comment;
    private LocalDateTime start;
    private LocalDateTime end;
}
