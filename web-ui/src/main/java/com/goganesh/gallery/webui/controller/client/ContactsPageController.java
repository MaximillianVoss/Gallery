package com.goganesh.gallery.webui.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactsPageController {

    @GetMapping
    public String contactsPage() {
        return "client/contacts";
    }
}
