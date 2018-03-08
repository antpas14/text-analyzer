package com.gcnc.sskfe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    String index(Model model, Locale locale) {
        logger.info("Request for index");
        model.addAttribute("title", "title");
        model.addAttribute("active", "home");
        return "index";
    }
}
