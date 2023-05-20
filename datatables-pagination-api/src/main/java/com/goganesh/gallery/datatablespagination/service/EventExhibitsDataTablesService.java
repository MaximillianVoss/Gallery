package com.goganesh.gallery.datatablespagination.service;

import com.goganesh.gallery.datatablespagination.dto.ExhibitDataTablesDto;
import com.goganesh.gallery.datatablespagination.mapper.ExhibitDataTablesMapper;
import com.goganesh.gallery.datatablespagination.model.ExtendedPaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.EventExhibit;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.EventExhibitService;
import com.goganesh.gallery.model.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class EventExhibitsDataTablesService extends DataServiceBase<ExhibitDataTablesDto> {

    private static final String EVENT_FILTER_NANE = Event.class.getSimpleName();

    private final EventExhibitService eventExhibitService;
    private final EventService eventService;
    private final ExhibitDataTablesMapper exhibitMapper;

    @Override
    protected List<ExhibitDataTablesDto> getData(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart() / paginationCriteria.getLength();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);

        ExtendedPaginationCriteria criteria = (ExtendedPaginationCriteria) paginationCriteria;
        UUID eventId = criteria.getFilter().get(EVENT_FILTER_NANE);
        Event event = eventService.findById(eventId)
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", eventId.toString()));
        return eventExhibitService.findAllByEvent(event, pageable)
                .map(EventExhibit::getExhibit)
                .map(exhibitMapper::toDto)
                .getContent();
    }

    @Override
    public long countTotalEntries(PaginationCriteria paginationCriteria) {
        ExtendedPaginationCriteria criteria = (ExtendedPaginationCriteria) paginationCriteria;
        UUID eventId = criteria.getFilter().get(EVENT_FILTER_NANE);
        Event event = eventService.findById(eventId)
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", eventId.toString()));

        return eventExhibitService.countAllByEvent(event);
    }

    @Override
    public long countFilteredEntries(PaginationCriteria paginationCriteria) {
        ExtendedPaginationCriteria criteria = (ExtendedPaginationCriteria) paginationCriteria;
        UUID eventId = criteria.getFilter().get(EVENT_FILTER_NANE);
        Event event = eventService.findById(eventId)
                .orElseThrow(() -> new NotFoundException(Event.class.getSimpleName(), "id", eventId.toString()));

        return eventExhibitService.countAllByEvent(event);
    }
}
