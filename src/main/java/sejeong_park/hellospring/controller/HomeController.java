package sejeong_park.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // domain host
    @GetMapping("/")
    public String home(){
        return "home";
    } // home.html




}
