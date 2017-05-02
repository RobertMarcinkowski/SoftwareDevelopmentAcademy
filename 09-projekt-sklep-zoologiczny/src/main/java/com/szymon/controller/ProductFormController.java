package com.szymon.controller;


import com.szymon.model.Image;
import com.szymon.model.Product;
import com.szymon.service.ImageService;
import com.szymon.service.LinkService;
import com.szymon.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class ProductFormController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "/product-form", method = RequestMethod.GET)
    public ModelAndView productForm(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("productForm");
        modelAndView.addObject("navigationLinks", linkService.fetchLinks(principal));
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("categories", productsService.findAllCategories());
        modelAndView.addObject("postUrl", "/product-form");
        return modelAndView;
    }

    @RequestMapping(value = "/product-form", method = RequestMethod.POST)
    public ModelAndView productPost(@ModelAttribute Product product,Principal principal) {
        ModelAndView modelAndView = new ModelAndView("productForm");
        modelAndView.addObject("navigationLinks", linkService.fetchLinks(principal));
        Image smallImage = new Image(product.getSmallImage().getLink(),product.getSmallImage().getAltText(),product.getSmallImage().getLink());
        Image bigImage = new Image(product.getBigImage().getLink(),product.getBigImage().getAltText(),product.getBigImage().getLink());
        imageService.saveImage(smallImage.getLink(),smallImage.getAltText());
        imageService.saveImage(bigImage.getLink(),bigImage.getAltText());
        productsService.saveProduct(product.getTitle(),product.getDescription(),product.getPrice(),smallImage,bigImage,product.getCategory());
        modelAndView.addObject("product", product);
        modelAndView.addObject("inform", "product added");
        modelAndView.addObject("categories", productsService.findAllCategories());
        return modelAndView;
    }

    @GetMapping(value = "/product-edit/{id}")
    public ModelAndView productEdit(Principal principal, @PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("productForm");
        modelAndView.addObject("navigationLinks", linkService.fetchLinks(principal));
        Product product = productsService.findProductById(id);
        if (product != null){
            modelAndView.addObject("product", product);
        } else {
            modelAndView.setViewName("redirect:/product-form");
        }

        modelAndView.addObject("categories", productsService.findAllCategories());
        modelAndView.addObject("postUrl", "/product-edit/"+id);
        return modelAndView;
    }

    @PostMapping(value = "/product-edit/{id}")
    public String productEditPost(Principal principal, @PathVariable Long id, @ModelAttribute Product product) {
        productsService.updateProduct(product,id);
        return "redirect:/products/"+id;
    }

}
