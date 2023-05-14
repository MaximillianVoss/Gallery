package com.goganesh.gallery.webui.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exhibits")
public class ExhibitsPageController {

    @GetMapping
    public String exhibitsPage() {
        return "client/exhibits";
    }
}
