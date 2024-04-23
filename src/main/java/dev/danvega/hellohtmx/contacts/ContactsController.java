package dev.danvega.hellohtmx.contacts;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

    @GetMapping(value = "", produces = MediaType.TEXT_HTML_VALUE)
    public String list(Model model) {
        List<Contact> contacts = List.of(
                new Contact("Test 1","test1@gmail.com", "1234567890"),
                new Contact("Test 2","test2@gmail.com", "5219189198"),
                new Contact("Test 3","test3@gmail.com", "2191298899")
        );

        model.addAttribute("contacts", contacts);
        return "contacts/index";
    }

    /*
     * This method will just return the fragment for a contact row
     */
    @GetMapping("/load")
    public String getRows(Model model) {
        List<Contact> contacts = List.of(
                new Contact("More 1","more1@gmail.com", "1234567890"),
                new Contact("More 2","more2@gmail.com", "5219189198"),
                new Contact("More 3","more3@gmail.com", "2191298899"),
                new Contact("More 4","more4@gmail.com", "2191298899"),
                new Contact("More 5","more5@gmail.com", "2191298899")
        );
        model.addAttribute("contacts", contacts);
        return "contacts/contact-row :: contact-row";
    }

}
