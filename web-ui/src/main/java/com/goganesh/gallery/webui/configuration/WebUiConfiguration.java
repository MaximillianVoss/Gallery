package com.goganesh.gallery.webui.configuration;

import com.goganesh.gallery.model.configuration.ModelConfiguration;
import com.goganesh.gallery.model.service.*;
import com.goganesh.gallery.webui.controller.admin.AuthorPageController;
import com.goganesh.gallery.webui.controller.admin.EventPageController;
import com.goganesh.gallery.webui.controller.admin.ExhibitPageController;
import com.goganesh.gallery.webui.controller.admin.AdminPageController;
import com.goganesh.gallery.webui.controller.client.GalleryPageController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ModelConfiguration.class)
public class WebUiConfiguration {

    @Bean
    public AdminPageController adminPageController() {
        return new AdminPageController();
    }

    @Bean
    public ExhibitPageController adminExhibitPageController(ExhibitService exhibitService,
                                                            AuthorService authorService,
                                                            DictionaryService dictionaryService) {
        return new ExhibitPageController(exhibitService, authorService, dictionaryService);
    }

    @Bean
    public AuthorPageController adminAuthorPageController(AuthorService authorService) {
        return new AuthorPageController(authorService);
    }

    @Bean
    public EventPageController adminEventPageController(EventService eventService,
                                                        DictionaryService dictionaryService) {
        return new EventPageController(eventService, dictionaryService);
    }

    @Bean
    public GalleryPageController galleryPageController() {
        return new GalleryPageController();
    }
}
