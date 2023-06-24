package com.goganesh.gallery.datatablespagination.mapper;


import com.goganesh.gallery.datatablespagination.dto.ExhibitDataTablesDto;
import com.goganesh.gallery.model.domain.Exhibit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ExhibitDataTablesMapper {

    @Mapping(target = "id",
            source = "exhibit.id")
    @Mapping(target = "name",
            source = "exhibit.name")
    @Mapping(target = "code",
            source = "exhibit.code")
    @Mapping(target = "author",
            source = "exhibit.author.name")
    @Mapping(target = "type",
            source = "exhibit.type.name")
    @Mapping(target = "storageCondition",
            source = "exhibit.storageCondition.name")
    @Mapping(target = "status",
        source = "exhibit.status.name")
    ExhibitDataTablesDto toDto(Exhibit exhibit);
}
