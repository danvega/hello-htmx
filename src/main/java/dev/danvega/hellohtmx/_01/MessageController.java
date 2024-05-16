package dev.danvega.hellohtmx._01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/01")
public class MessageController {

    @GetMapping("")
    public String index() {
        return "01/index";
    }

    @GetMapping("/banner")
    public String banner(Model model) {
        model.addAttribute("title", "Spring I/O 2024");
        model.addAttribute("message","Join us in Barcelona, Spain from May 30 – 31");
        return "01/banner :: banner";
    }
}
