package com.ancrazyking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ancrazyking
 * @date 2018/5/21 14:33
 **/
@Controller
public class PageController
{
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("{page}")
    public String showPage(String page){
        return page;
    }
}
