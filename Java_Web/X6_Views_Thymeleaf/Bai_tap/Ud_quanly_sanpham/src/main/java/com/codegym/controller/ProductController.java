package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class ProductController {
    private ProductService productService = new ProductServiceImpl();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listproduct", productService.findAll());
        return "index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        Product p = new Product();
        MultipartFile[] fileDatas = new MultipartFile[1];
        model.addAttribute("product", p);
        model.addAttribute("fileDatas", fileDatas);
        return "create";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product product,@ModelAttribute("fileDatas") MultipartFile[] fileDatas, RedirectAttributes redirect) throws IOException {
        if (product.getId() == 0) {
            product.setId((int) (Math.random() * 1000));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("data:image/png;base64,");
        sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(product.getFileDatas()[0].getBytes(), false)));
        product.setImage(sb.toString());
        productService.save(product);
        redirect.addFlashAttribute("success", "Add product successly!!!");
        return "redirect:/";

    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/product/delete")
    public String delete(int id, RedirectAttributes redirect) {
        productService.remove(id);
        redirect.addFlashAttribute("success", "Delete product successly!!!");
        return "redirect:/";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Update customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}