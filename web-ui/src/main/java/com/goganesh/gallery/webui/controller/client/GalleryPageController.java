package com.goganesh.gallery.webui.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryPageController {

    @GetMapping
    public String galleryPage() {
        return "client/gallery";
    }
}
