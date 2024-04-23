package dev.danvega.hellohtmx._02;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final Faker faker;

    public UserController(Faker faker) {
        this.faker = faker;
    }

    @GetMapping("")
    public String list(Model model) {
        return "02/index";
    }

    @GetMapping("/addUserModal")
    public String addUser() {
        return "02/modal :: modal";
    }

}
