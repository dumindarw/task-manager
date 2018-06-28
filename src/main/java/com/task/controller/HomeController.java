package com.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by duminda on 6/19/18.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView home(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
