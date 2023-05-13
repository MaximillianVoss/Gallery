package com.goganesh.gallery.webui.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping("/admin")
    public String indexPage() {
        return "redirect:admin/exhibits";
    }
}
