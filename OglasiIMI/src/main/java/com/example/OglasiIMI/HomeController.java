package com.example.OglasiIMI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home()
    {
        return "index";
    }
}

@Controller
class HomeController2 {

    @GetMapping("/index.html")
    public String home()
    {
        return "index";
    }
}

@Controller
class ListingController {
    @GetMapping("/listing.html")
    public String listing()
    {
        return "listing";
    }
}


