package com.goganesh.gallery.datatablespagination.mapper;


import com.goganesh.gallery.datatablespagination.dto.AuthorDataTablesDto;
import com.goganesh.gallery.model.domain.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthorDataTablesMapper {

    @Mapping(target = "id",
            source = "author.id")
    @Mapping(target = "name",
            source = "author.name")
    AuthorDataTablesDto toDto(Author author);
}
