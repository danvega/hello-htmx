package dev.danvega.hellohtmx._04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "04/index";
    }

    @GetMapping("/addUserModal")
    public String addUser() {
        return "04/modal :: modal";
    }

    @GetMapping("/removeUserModal")
    public String removeUserModal() {
        return "04/modal :: modal";
    }

    @GetMapping("/getFakeUser")
    public String getFakeUser(Model model) {
        var user = userRepository.createFakeUser();
        model.addAttribute("user", user);
        return "04/new-user-form :: frmNewUser";
    }

    @PostMapping("")
    public String save(@ModelAttribute User user, Model model) {
        userRepository.save(user);

        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "04/index";
    }


}
