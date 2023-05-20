package com.goganesh.gallery.datatablespagination.service;

import com.goganesh.gallery.datatablespagination.dto.EventDataTablesDto;
import com.goganesh.gallery.datatablespagination.mapper.EventDataTablesMapper;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.model.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class EventDataTablesService extends DataServiceBase<EventDataTablesDto> {

    private final EventService eventService;
    private final EventDataTablesMapper eventMapper;

    @Override
    protected List<EventDataTablesDto> getData(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart() / paginationCriteria.getLength();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);

        String search = paginationCriteria.getSearch().getValue();
        List<EventDataTablesDto> result;
        if (Objects.nonNull(search)) {
            result = eventService.findAllByNameContain(search, pageable).map(eventMapper::toDto).getContent();
        } else {
            result = eventService.findAll(pageable).map(eventMapper::toDto).getContent();
        }

        return result;
    }

    @Override
    public long countTotalEntries(PaginationCriteria paginationCriteria) {
        return eventService.count();
    }

    @Override
    public long countFilteredEntries(PaginationCriteria paginationCriteria) {
        String search = paginationCriteria.getSearch().getValue();

        if (Objects.nonNull(search)) {
            return eventService.countAllByNameContain(search);
        }
        return eventService.count();
    }
}
