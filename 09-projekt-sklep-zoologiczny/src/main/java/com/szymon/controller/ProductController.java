package com.szymon.controller;

import com.szymon.model.Product;
import com.szymon.service.LinkService;
import com.szymon.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @Autowired
    private LinkService linkService;

    @RequestMapping("/products/{id}")
    public ModelAndView modelAndView(@PathVariable Long id,Principal principal) {
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("navigationLinks", linkService.fetchLinks(principal));
        Product productById = productsService.findProductById(id);
        modelAndView.addObject("categories", productsService.findAllCategories());
        modelAndView.addObject("product", productById);
        if (productById == null) {
            modelAndView = null;
        }
        return modelAndView;
    }
}
