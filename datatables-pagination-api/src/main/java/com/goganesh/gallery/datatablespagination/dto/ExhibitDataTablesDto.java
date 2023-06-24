package com.goganesh.gallery.datatablespagination.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

public class ExhibitDataTablesDto {

    private UUID id;
    private String name;
    private String code;
    private String author;
    private String type;
    private String storageCondition;
    private String status;
}
