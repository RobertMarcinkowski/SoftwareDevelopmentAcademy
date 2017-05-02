package com.szymon.controller;

import com.szymon.model.Link;
import com.szymon.service.ImageService;
import com.szymon.service.LinkService;
import com.szymon.service.ProductsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Arrays;

@Controller
public class ShopController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ProductsService productsService;

    @RequestMapping("shop")
    public ModelAndView shop(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("navigationLinks", linkService.fetchLinks(principal));
        modelAndView.addObject("mainLink", new Link("Pet Shop", "/shop"));
        modelAndView.addObject("carouselImages", imageService.fetchImages());
        modelAndView.addObject("products", productsService.fetchAllProducts());
        modelAndView.addObject("categories", productsService.findAllCategories());
        return modelAndView;
    }

    @RequestMapping(value = "shop", params = {"category"})
    public ModelAndView shopWithCategory(@RequestParam String category,Principal principal) {
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("navigationLinks", linkService.fetchLinks(principal));
        modelAndView.addObject("mainLink", new Link("Pet Shop", "/shop"));
        modelAndView.addObject("carouselImages", imageService.fetchImages());
        modelAndView.addObject("products", productsService.findProductsByCategory(category));
        modelAndView.addObject("categories", productsService.findAllCategories());
        modelAndView.addObject("activeCategory", StringUtils.capitalize(category));
        return modelAndView;
    }

}
