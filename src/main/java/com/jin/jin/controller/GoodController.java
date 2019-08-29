package com.jin.jin.controller;

import com.jin.jin.model.Good;
import com.jin.jin.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    public GoodService goodService;

    @RequestMapping("/allgood")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("shop");
        List<Good> goodList = goodService.getAllGood();
        mav.addObject("goodList",goodList);
        return mav;
    }
}
