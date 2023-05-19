package com.goganesh.gallery.webapi.configuration;

import com.goganesh.gallery.model.configuration.ModelConfiguration;
import com.goganesh.gallery.model.service.*;
import com.goganesh.gallery.webapi.controller.AuthorController;
import com.goganesh.gallery.webapi.controller.EventController;
import com.goganesh.gallery.webapi.controller.ExhibitController;
import com.goganesh.gallery.webapi.controller.FileController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.awt.*;

@Configuration
@Import(ModelConfiguration.class)
public class WebApiConfiguration {

    @Bean
    public ExhibitController exhibitController(ExhibitService exhibitService,
                                               AuthorService authorService,
                                               DictionaryService dictionaryService,
                                               ExhibitPlaceService exhibitPlaceService,
                                               ImageService imageService) {
        return new ExhibitController(exhibitService, authorService, dictionaryService, exhibitPlaceService, imageService);
    }

    @Bean
    public AuthorController authorController(AuthorService authorService) {
        return new AuthorController(authorService);
    }

    @Bean
    public EventController eventController(EventService eventService,
                                           ExhibitService exhibitService,
                                           EventExhibitService eventExhibitService,
                                           DictionaryService dictionaryService,
                                           ImageService imageService) {
        return new EventController(eventService, exhibitService, eventExhibitService, dictionaryService, imageService);
    }

    @Bean
    public FileController fileController(ExhibitService exhibitService,
                                         DictionaryService dictionaryService,
                                         ExhibitFileService exhibitFileService,
                                         FileStorageService fileStorageService) {
        return new FileController(exhibitService, dictionaryService, exhibitFileService, fileStorageService);
    }
}
