package com.goganesh.gallery.datatablespagination.service;

import com.goganesh.gallery.datatablespagination.data.DataServiceBase;
import com.goganesh.gallery.datatablespagination.dto.AuthorDataTablesDto;
import com.goganesh.gallery.datatablespagination.mapper.AuthorDataTablesMapper;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.model.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@AllArgsConstructor
public class AuthorDataTablesService extends DataServiceBase<AuthorDataTablesDto> {

    private final AuthorService authorService;
    private final AuthorDataTablesMapper authorDataTablesMapper;

    @Override
    protected List<AuthorDataTablesDto> getData(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart() / paginationCriteria.getLength();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);

        return authorService.findAll(pageable).map(authorDataTablesMapper::toDto).getContent();
    }

    @Override
    public long countTotalEntries() {
        return authorService.count();
    }

    @Override
    public long countFilteredEntries(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);

        return authorService.findAll(pageable).getTotalElements();
    }
}
