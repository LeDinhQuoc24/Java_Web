package vnnhnlm.create_product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vnnhnlm.create_product.model.Product;
import vnnhnlm.create_product.repository.ProductRepository;


@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ModelAndView listBlog(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("create-product")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("create-product")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        productRepository.save(product);
        modelAndView.addObject("message", "New product created successfully");
        return modelAndView;
    }
}
