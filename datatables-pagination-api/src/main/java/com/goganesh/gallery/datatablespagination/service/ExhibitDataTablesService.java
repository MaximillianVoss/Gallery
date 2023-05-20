package com.goganesh.gallery.datatablespagination.service;

import com.goganesh.gallery.datatablespagination.dto.ExhibitDataTablesDto;
import com.goganesh.gallery.datatablespagination.mapper.ExhibitDataTablesMapper;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.model.service.ExhibitService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class ExhibitDataTablesService extends DataServiceBase<ExhibitDataTablesDto> {

    private final ExhibitService exhibitService;
    private final ExhibitDataTablesMapper exhibitMapper;

    @Override
    protected List<ExhibitDataTablesDto> getData(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart() / paginationCriteria.getLength();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);

        String search = paginationCriteria.getSearch().getValue();
        List<ExhibitDataTablesDto> result;
        if (Objects.nonNull(search)) {
            result = exhibitService.findAllByNameContain(search, pageable).map(exhibitMapper::toDto).getContent();
        } else {
            result = exhibitService.findAll(pageable).map(exhibitMapper::toDto).getContent();
        }

        return result;
    }

    @Override
    public long countTotalEntries(PaginationCriteria paginationCriteria) {
        return exhibitService.count();
    }

    @Override
    public long countFilteredEntries(PaginationCriteria paginationCriteria) {
        String search = paginationCriteria.getSearch().getValue();

        if (Objects.nonNull(search)) {
            return exhibitService.countAllByNameContain(search);
        }

        return exhibitService.count();
    }
}
