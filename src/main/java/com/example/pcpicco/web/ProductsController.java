package com.example.pcpicco.web;

import com.example.pcpicco.model.Product;
import com.example.pcpicco.model.Store;
import com.example.pcpicco.model.enumeration.Roles;
import com.example.pcpicco.repository.ProductRepository;
import com.example.pcpicco.repository.StoreRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    public ProductsController(ProductRepository productRepository, StoreRepository storeRepository) {
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    @GetMapping
    public String getProducts(Model model){
        List<Product> list = productRepository.findAll();
        model.addAttribute("client", Roles.CLIENT);
        model.addAttribute("seller_admin", Roles.SELLER_ADMIN);
        model.addAttribute("admin", Roles.ADMIN);
        model.addAttribute("products",list);
        return "products";
    }

    @GetMapping("/{id}/view")
    public String viewProduct(@PathVariable Integer id, Model model ){
        Product product = this.productRepository.findById(id).get();
        model.addAttribute("selectedProduct", product);
        return "view";
    }

    @GetMapping("/add-form")
    @PreAuthorize("hasRole('SELLER_ADMIN')")
    public String addProduct(Model model){
        List<Store> stores = this.storeRepository.findAll();
        model.addAttribute("stores",stores);
        return "addProduct";
    }

    @PostMapping("/add")
    public String saveProduct(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Integer price,
                              @RequestParam String type,
                              @RequestParam Integer quantity,
                              @RequestParam String store_name,
                              @RequestParam String url){
        Store store = this.storeRepository.findByName(store_name);
        Product product = new Product(name,description,price,type,quantity,store);
        product.setUrl(url);
        this.productRepository.save(product);
        return "redirect:/products";
    }
}
