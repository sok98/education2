package com.springmvc.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {

    @GetMapping("/api")
    @ResponseBody
    public String api() {

        return  "<h1>api</h1>";
    }

}
