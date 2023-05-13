package com.goganesh.gallery.datatablespagination.service;

import com.goganesh.gallery.datatablespagination.data.DataServiceBase;
import com.goganesh.gallery.datatablespagination.dto.EventDataTablesDto;
import com.goganesh.gallery.datatablespagination.mapper.EventDataTablesMapper;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.model.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@AllArgsConstructor
public class EventDataTablesService extends DataServiceBase<EventDataTablesDto> {

    private final EventService eventService;
    private final EventDataTablesMapper eventMapper;

    @Override
    protected List<EventDataTablesDto> getData(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart() / paginationCriteria.getLength();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);
        return eventService.findAll(pageable).map(eventMapper::toDto).getContent();
    }

    @Override
    public long countTotalEntries() {
        return eventService.count();
    }

    @Override
    public long countFilteredEntries(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);

        return eventService.findAll(pageable).getTotalElements();
    }
}
