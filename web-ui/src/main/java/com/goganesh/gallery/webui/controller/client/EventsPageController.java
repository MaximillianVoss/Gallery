package com.goganesh.gallery.webui.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventsPageController {

    @GetMapping
    public String eventsPage() {
        return "client/events";
    }
}
