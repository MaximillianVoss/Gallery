package com.goganesh.gallery.datatablespagination.service;

import com.goganesh.gallery.datatablespagination.dto.ExhibitDocumentDataTablesDto;
import com.goganesh.gallery.datatablespagination.mapper.ExhibitDocumentMapper;
import com.goganesh.gallery.datatablespagination.model.ExtendedPaginationCriteria;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.exception.NotFoundException;
import com.goganesh.gallery.model.service.ExhibitFileService;
import com.goganesh.gallery.model.service.ExhibitService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class ExhibitDocumentsDataTablesService extends DataServiceBase<ExhibitDocumentDataTablesDto> {

    private static final String EXHIBIT_FILTER_NANE = Exhibit.class.getSimpleName();

    private final ExhibitService exhibitService;
    private final ExhibitFileService exhibitFileService;
    private final ExhibitDocumentMapper exhibitDocumentMapper;

    @Override
    protected List<ExhibitDocumentDataTablesDto> getData(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart() / paginationCriteria.getLength();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);

        ExtendedPaginationCriteria criteria = (ExtendedPaginationCriteria) paginationCriteria;
        UUID exhibitId = criteria.getFilter().get(EXHIBIT_FILTER_NANE);
        Exhibit exhibit = exhibitService.findById(exhibitId)
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", exhibitId.toString()));
        return exhibitFileService.findAllByExhibit(exhibit, pageable)
                .map(exhibitDocumentMapper::toDto)
                .getContent();
    }

    @Override
    public long countTotalEntries() {
        //todo think about it
        return 0;
    }

    @Override
    public long countFilteredEntries(PaginationCriteria paginationCriteria) {
        int page = paginationCriteria.getStart();
        int size = paginationCriteria.getLength();

        Pageable pageable = PageRequest.of(page, size);

        ExtendedPaginationCriteria criteria = (ExtendedPaginationCriteria) paginationCriteria;
        UUID exhibitId = criteria.getFilter().get(EXHIBIT_FILTER_NANE);
        Exhibit exhibit = exhibitService.findById(exhibitId)
                .orElseThrow(() -> new NotFoundException(Exhibit.class.getSimpleName(), "id", exhibitId.toString()));
        return exhibitFileService.findAllByExhibit(exhibit, pageable)
                .map(exhibitDocumentMapper::toDto)
                .getTotalElements();
    }
}
