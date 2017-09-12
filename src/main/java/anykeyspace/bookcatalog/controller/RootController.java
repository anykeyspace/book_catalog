package anykeyspace.bookcatalog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @RequestMapping("/")
    public String index() {
        return "Spring Boot test";
    }
}
