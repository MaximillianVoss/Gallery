package com.goganesh.gallery.webapi.configuration;

import com.goganesh.gallery.model.configuration.ModelConfiguration;
import com.goganesh.gallery.model.service.*;
import com.goganesh.gallery.webapi.controller.AuthorController;
import com.goganesh.gallery.webapi.controller.EventController;
import com.goganesh.gallery.webapi.controller.ExhibitController;
import com.goganesh.gallery.webapi.controller.FileUploadController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ModelConfiguration.class)
public class WebApiConfiguration {

    @Bean
    public ExhibitController exhibitController(ExhibitService exhibitService,
                                               AuthorService authorService,
                                               DictionaryService dictionaryService,
                                               ExhibitPlaceService exhibitPlaceService) {
        return new ExhibitController(exhibitService, authorService, dictionaryService, exhibitPlaceService);
    }

    @Bean
    public AuthorController authorController(AuthorService authorService) {
        return new AuthorController(authorService);
    }

    @Bean
    public EventController eventController(EventService eventService,
                                           ExhibitService exhibitService,
                                           EventExhibitService eventExhibitService,
                                           DictionaryService dictionaryService) {
        return new EventController(eventService, exhibitService, eventExhibitService, dictionaryService);
    }

    @Bean
    public FileUploadController fileUploadController(ExhibitService exhibitService,
                                                     DictionaryService dictionaryService,
                                                     ExhibitFileService exhibitFileService) {
        return new FileUploadController(exhibitService, dictionaryService, exhibitFileService);
    }
}
