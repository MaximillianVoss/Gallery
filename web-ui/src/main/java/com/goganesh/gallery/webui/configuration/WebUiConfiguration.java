package com.goganesh.gallery.webui.configuration;

import com.goganesh.gallery.model.configuration.ModelConfiguration;
import com.goganesh.gallery.model.service.*;
import com.goganesh.gallery.webui.controller.admin.AuthorAdminPageController;
import com.goganesh.gallery.webui.controller.admin.EventAdminPageController;
import com.goganesh.gallery.webui.controller.admin.ExhibitAdminPageController;
import com.goganesh.gallery.webui.controller.admin.AdminPageController;
import com.goganesh.gallery.webui.controller.client.*;
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
    public ExhibitAdminPageController exhibitAdminPageController(ExhibitService exhibitService,
                                                                 AuthorService authorService,
                                                                 DictionaryService dictionaryService) {
        return new ExhibitAdminPageController(exhibitService, authorService, dictionaryService);
    }

    @Bean
    public AuthorAdminPageController authorAdminPageController(AuthorService authorService) {
        return new AuthorAdminPageController(authorService);
    }

    @Bean
    public EventAdminPageController eventAdminPageController(EventService eventService,
                                                             DictionaryService dictionaryService) {
        return new EventAdminPageController(eventService, dictionaryService);
    }

    @Bean
    public GalleryPageController galleryPageController() {
        return new GalleryPageController();
    }

    @Bean
    public AboutPageController aboutPageController() {
        return new AboutPageController();
    }

    @Bean
    public ContactsPageController contactsPageController() {
        return new ContactsPageController();
    }

    @Bean
    public EventsPageController eventsPageController(EventService eventService, ExhibitService exhibitService) {
        return new EventsPageController(eventService, exhibitService);
    }

    @Bean
    public ExhibitsPageController exhibitsPageController(ExhibitService exhibitService) {
        return new ExhibitsPageController(exhibitService);
    }
}
