package vnnhnlm.open_blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vnnhnlm.open_blog.model.Category;
import vnnhnlm.open_blog.service.CategoryService;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ModelAndView listCategories(@RequestParam("s") Optional<String> s, @PageableDefault(value=5) Pageable pageable){
        Page<Category> categories;
        if(s.isPresent()){
            categories = categoryService.findAllByNameContaining(s.get(), pageable);
        } else {
            categories = categoryService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
    @GetMapping("/create-category")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/category/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }
    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;

    }


    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Category category=categoryService.findById(id);
        if(category !=null){
            ModelAndView modelAndView=new ModelAndView("/category/edit");
            modelAndView.addObject("category",category);
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("/category/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-category")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView=new ModelAndView("/category/edit");
        modelAndView.addObject("category",category);
        modelAndView.addObject("message","category updated success!!!");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/category/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category") Category category){
        categoryService.remove(category.getId());
        return "redirect:categories";
    }

}
