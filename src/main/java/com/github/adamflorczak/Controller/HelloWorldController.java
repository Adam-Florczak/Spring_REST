package com.github.adamflorczak.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String helloName(@RequestParam(name = "name", required = false, defaultValue = "Anonymous") String name, Model model){
        model.addAttribute("name", name);
        return "helloname";

    }

}
