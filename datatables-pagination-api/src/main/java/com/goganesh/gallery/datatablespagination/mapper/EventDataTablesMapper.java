package com.goganesh.gallery.datatablespagination.mapper;

import com.goganesh.gallery.datatablespagination.dto.EventDataTablesDto;
import com.goganesh.gallery.model.domain.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EventDataTablesMapper {

    @Mapping(target = "id",
            source = "event.id")
    @Mapping(target = "name",
            source = "event.name")
    @Mapping(target = "start",
            source = "event.start")
    @Mapping(target = "end",
            source = "event.end")
    @Mapping(target = "type",
            source = "event.type.name")
    EventDataTablesDto toDto(Event event);
}
