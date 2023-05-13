package com.goganesh.gallery.datatablespagination.configuration;

import com.goganesh.gallery.datatablespagination.controller.*;
import com.goganesh.gallery.datatablespagination.mapper.*;
import com.goganesh.gallery.datatablespagination.service.*;
import com.goganesh.gallery.model.configuration.ModelConfiguration;
import com.goganesh.gallery.model.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ModelConfiguration.class)
public class DataTablesPaginationConfiguration {

    @Bean
    public ExhibitDataTablesController exhibitDataTablesController(ExhibitDataTablesService exhibitDataService) {
        return new ExhibitDataTablesController(exhibitDataService);
    }

    @Bean
    public ExhibitDataTablesMapper exhibitDataTablesMapper() {
        return new ExhibitDataTablesMapperImpl();
    }

    @Bean
    public ExhibitDataTablesService exhibitDataTablesService(ExhibitService exhibitService, ExhibitDataTablesMapper exhibitDataTablesMapper) {
        return new ExhibitDataTablesService(exhibitService, exhibitDataTablesMapper);
    }

    @Bean
    public AuthorDataTablesController authorDataTablesController(AuthorDataTablesService authorDataTablesService) {
        return new AuthorDataTablesController(authorDataTablesService);
    }

    @Bean
    public AuthorDataTablesMapper authorDataTablesMapper() {
        return new AuthorDataTablesMapperImpl();
    }

    @Bean
    public AuthorDataTablesService authorDataTablesService(AuthorService authorService, AuthorDataTablesMapper authorDataTablesMapper) {
        return new AuthorDataTablesService(authorService, authorDataTablesMapper);
    }

    @Bean
    public EventDataTablesController eventDataTablesController(EventDataTablesService eventDataTablesService) {
        return new EventDataTablesController(eventDataTablesService);
    }

    @Bean
    public EventDataTablesMapper eventDataTablesMapper() {
        return new EventDataTablesMapperImpl();
    }

    @Bean
    public EventDataTablesService eventDataTablesService(EventService eventService, EventDataTablesMapper eventDataTablesMapper) {
        return new EventDataTablesService(eventService, eventDataTablesMapper);
    }

    @Bean
    public EventExhibitsDataTablesController eventExhibitsDataTablesController(EventExhibitsDataTablesService eventExhibitsDataTablesService) {
        return new EventExhibitsDataTablesController(eventExhibitsDataTablesService);
    }

    @Bean
    public EventExhibitsDataTablesService eventExhibitsDataTablesService(EventExhibitService eventExhibitService, EventService eventService, ExhibitDataTablesMapper exhibitMapper) {
        return new EventExhibitsDataTablesService(eventExhibitService, eventService, exhibitMapper);
    }

    @Bean
    public PlaceExhibitMapper placeExhibitMapper() {
        return new PlaceExhibitMapperImpl();
    }

    @Bean
    public PlaceExhibitsDataTablesService placeExhibitsDataTablesService(ExhibitService exhibitService,
                                                                         ExhibitPlaceService exhibitPlaceService,
                                                                         PlaceExhibitMapper placeExhibitMapper) {
        return new PlaceExhibitsDataTablesService(exhibitService, exhibitPlaceService, placeExhibitMapper);
    }

    @Bean
    public PlaceExhibitsDataTablesController exhibitsDataTablesController(PlaceExhibitsDataTablesService placeExhibitsDataTablesService) {
        return new PlaceExhibitsDataTablesController(placeExhibitsDataTablesService);
    }

    @Bean
    public ExhibitDocumentMapper exhibitDocumentMapper() {
        return new ExhibitDocumentMapperImpl();
    }

    @Bean
    public ExhibitDocumentsDataTablesService exhibitDocumentsDataTablesService(ExhibitService exhibitService,
                                                                               ExhibitFileService exhibitFileService,
                                                                               ExhibitDocumentMapper exhibitDocumentMapper) {
        return new ExhibitDocumentsDataTablesService(exhibitService, exhibitFileService, exhibitDocumentMapper);
    }

    @Bean
    public ExhibitDocumentsDataTablesController exhibitDocumentsDataTablesController(ExhibitDocumentsDataTablesService exhibitDocumentsDataTablesService) {
        return new ExhibitDocumentsDataTablesController(exhibitDocumentsDataTablesService);
    }

}
