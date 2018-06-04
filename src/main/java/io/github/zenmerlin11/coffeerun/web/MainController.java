package io.github.zenmerlin11.coffeerun.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
}
