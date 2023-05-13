package com.goganesh.gallery.datatablespagination.mapper;


import com.goganesh.gallery.datatablespagination.dto.PlaceExhibitDataTablesDto;
import com.goganesh.gallery.model.domain.ExhibitPlace;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PlaceExhibitMapper {

    @Mapping(target = "id",
            source = "exhibitPlace.id")
    @Mapping(target = "place",
            source = "exhibitPlace.place.name")
    @Mapping(target = "comment",
            source = "exhibitPlace.comment")
    @Mapping(target = "start",
            source = "exhibitPlace.start")
    @Mapping(target = "end",
            source = "exhibitPlace.end")
    PlaceExhibitDataTablesDto toDto(ExhibitPlace exhibitPlace);
}
