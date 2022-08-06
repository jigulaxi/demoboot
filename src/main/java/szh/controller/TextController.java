package szh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {

    @RequestMapping("/")
    public String text(){
        return "hello springBoot";
    }
}
