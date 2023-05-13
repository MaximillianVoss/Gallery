package com.goganesh.gallery.datatablespagination.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EventDataTablesDto {
    private UUID id;
    private String name;
    private LocalDate start;
    private LocalDate end;
    private String type;
}
