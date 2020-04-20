package vnnhnlm.create_product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vnnhnlm.create_product.model.Image;
import vnnhnlm.create_product.model.Product;
import vnnhnlm.create_product.service.ImageService;
import vnnhnlm.create_product.service.ProductService;

import java.util.Date;
import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ImageService imageService;

    @ModelAttribute("images")
    public List<Image> images() {
        return imageService.findAll();

    }

    @GetMapping("/products")
    public ModelAndView listBlog(@PageableDefault(value = 3) Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
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
        product.setDateTime(new Date());
        productService.save(product);
        modelAndView.addObject("message", "New product created successfully");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("view-product/{id}")
    public ModelAndView viewProduct(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/product/view");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("edit-product/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        ModelAndView modelAndView;
        Product product = productService.findById(id);
        if (product != null) {
            modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product", product);
        } else {
            modelAndView = new ModelAndView("/product/error.404");
        }
        return modelAndView;
    }

    @PostMapping("edit-product")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        product.setDateTime(new Date());
        productService.save(product);
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }

    @GetMapping("delete-product/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        ModelAndView modelAndView;
        Product product = productService.findById(id);
        if (product != null) {
            modelAndView = new ModelAndView("/product/delete");
            modelAndView.addObject("product", product);
        } else {
            modelAndView = new ModelAndView("product/error.404");
        }
        return modelAndView;
    }
    @PostMapping("delete-product")
    public String deleteProduct(@ModelAttribute("product") Product product) {
        productService.remove(product.getId());
        return "redirect:products";
    }
}
