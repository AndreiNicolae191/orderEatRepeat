package com.app.controllers;


import com.app.entities.Products;
import com.app.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProductsController {
    ProductsRepository productsRepository;

    @Autowired
    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Products> product = (List<Products>) productsRepository.findAll();
        model.addAttribute("products", product);
        return "products";
    }

    @GetMapping("/showFormForAdd")
    public String addProducts(Model model) {
        Products product = new Products();
        model.addAttribute("product", product);
        return "products-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("tempProd") int id, Model model) {
        Products products = productsRepository
                .findById(Integer.toUnsignedLong(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid id" + id));
        model.addAttribute("product", products);

        return "products-form";
    }


    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Products products, Model model) {
        productsRepository.save(products);
        model.addAttribute("products", productsRepository.findAll());
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productsRepository.deleteById(id);
                return "products";
    }
}
