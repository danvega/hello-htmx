package dev.danvega.hellohtmx._03;

import com.github.javafaker.Faker;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

    private final Faker faker;

    public ContactsController(Faker faker) {
        this.faker = faker;
    }

    @GetMapping(value = "", produces = MediaType.TEXT_HTML_VALUE)
    public String list(Model model) {
        model.addAttribute("contacts", createContacts(3));
        return "03/index";
    }

    @GetMapping("/load")
    public String getRows(Model model) {
        model.addAttribute("contacts", createContacts(3));
        return "03/contact-row :: contact-row";
    }

    private List<Contact> createContacts(Integer count) {
        return IntStream.rangeClosed(1,count)
                .mapToObj(i -> new Contact(
                        faker.name().firstName() + " " + faker.name().lastName(),
                        faker.internet().emailAddress(),
                        faker.internet().uuid()
                )).toList();
    }

}
