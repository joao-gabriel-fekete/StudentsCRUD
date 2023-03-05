package get.academic.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/index")
public class Start {

    @GetMapping
    public String index(){
        return "Let's start! Será mesmo?";
    }

}
