package com.goganesh.gallery.datatablespagination.mapper;

import com.goganesh.gallery.datatablespagination.dto.ExhibitDocumentDataTablesDto;
import com.goganesh.gallery.model.domain.ExhibitFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ExhibitDocumentMapper {

    @Mapping(target = "id",
            source = "exhibitFile.id")
    @Mapping(target = "type",
            source = "exhibitFile.type.name")
    @Mapping(target = "path",
            source = "exhibitFile.path")
    ExhibitDocumentDataTablesDto toDto(ExhibitFile exhibitFile);
}
