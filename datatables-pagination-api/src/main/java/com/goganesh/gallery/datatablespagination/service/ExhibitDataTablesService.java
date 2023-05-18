package com.goganesh.gallery.datatablespagination.service;

import com.goganesh.gallery.datatablespagination.dto.ExhibitDataTablesDto;
import com.goganesh.gallery.datatablespagination.mapper.ExhibitDataTablesMapper;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.model.service.ExhibitService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@AllArgsConstructor
public class ExhibitDataTablesService extends DataServiceBase<ExhibitDataTablesDto> {

    private final ExhibitService exhibitService;
    private final ExhibitDataTablesMapper exhibitMapper;

    @Override
    protected List<ExhibitDataTablesDto> getData(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart() / paginationCriteria.getLength();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);
        String name = paginationCriteria.getColumns().get(1).getSearch().getValue();

        List<ExhibitDataTablesDto> result;
        if (name != null) {
            result = exhibitService.findAllByNameContaining(name, pageable).map(exhibitMapper::toDto).getContent();
        } else {
            result = exhibitService.findAll(pageable).map(exhibitMapper::toDto).getContent();
        }

        return result;
    }

    @Override
    public long countTotalEntries() {
        return exhibitService.count();
    }

    @Override
    public long countFilteredEntries(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);
        String name = paginationCriteria.getColumns().get(1).getSearch().getValue();

        long result;
        if (name != null) {
            result = exhibitService.findAllByNameContaining(name, pageable).getTotalElements();
        } else {
            result = exhibitService.findAll(pageable).getTotalElements();
        }

        return result;
    }
}
