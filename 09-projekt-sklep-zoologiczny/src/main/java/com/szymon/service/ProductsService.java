package com.szymon.service;

import com.szymon.model.Image;
import com.szymon.model.Link;
import com.szymon.model.Product;
import com.szymon.repository.ProductRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;

    public Product findProductById(Long id) {
        return productRepository.findOne(id);
    }

    public List<Product> fetchAllProducts() {
        List<Product> products = new ArrayList<>();
        Iterable<Product> iterable = productRepository.findAll();
        iterable.forEach(products::add);
        return products;
    }

    public List<Product> findProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Set<Link> findAllCategories() {
        List<Product> products = fetchAllProducts();
        Set<Link> collect = products.stream()
                .map(e -> e.getCategory())
                .map(e -> new Link(StringUtils.capitalize(e), "/shop?category=" + e))
                .collect(Collectors.toSet());
        return new TreeSet<>(collect);
    }

    public void saveProduct(String title, String description, Double price, Image smallImage, Image bigImage, String category) {
        productRepository.save(new Product(title, description, price, smallImage, bigImage, category));
    }

    public void updateProduct(Product product,Long id) {
        Product productToEdit = findProductById(id);
        productToEdit.setTitle(product.getTitle());
        productToEdit.setDescription(product.getDescription());
        productToEdit.setPrice(product.getPrice());
        productToEdit.setSmallImage(product.getSmallImage());
        productToEdit.setBigImage(product.getBigImage());
        productToEdit.setSmallImage(product.getSmallImage());

    }


}
