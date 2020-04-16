package vnnhnlm.open_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vnnhnlm.open_blog.model.Blog;
import vnnhnlm.open_blog.model.Category;
import vnnhnlm.open_blog.service.BlogService;
import vnnhnlm.open_blog.service.CategoryService;

import java.util.Date;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }


    @GetMapping("/blogs")
    public ModelAndView listBlogs(@RequestParam("s") Optional<String> s, @PageableDefault(value = 5) Pageable pageable) {
        Page<Blog> blogs;
        Pageable pageableSortByDateTime = PageRequest.of(pageable.getPageNumber(), 5, Sort.by("dateTime").descending());
        if (s.isPresent()) {
            blogs = blogService.findAllByNameContaining(s.get(), pageable);
        } else {
            blogs = blogService.findAll(pageableSortByDateTime);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blog.setDateTime(new Date());
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView;
        Blog blog = blogService.findById(id);
        if (blog != null) {
            modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
        } else {
            modelAndView = new ModelAndView("blog/error.404");
        }
        return modelAndView;
    }

    @PostMapping("edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blog.setDateTime(new Date());
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("message", "Blog updated successfully");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        ModelAndView modelAndView;
        Blog blog = blogService.findById(id);
        if (blog != null) {
            modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog);
        } else {
            modelAndView = new ModelAndView("/blog/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:blogs";
    }

//    @GetMapping("/blogs/{id}")
//    public ModelAndView listBlogs2(@PathVariable("id") Long id, Pageable pageable) {
//        Category category = categoryService.findById(id);
//        Page<Blog> blogs = blogService.findAllByCategory(category, pageable);
//        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("blogs", blogs);
//        return modelAndView;
//    }
    @GetMapping("/blogs/{id}")
    public ModelAndView listBlogs2(@PathVariable("id") Long id, Pageable pageable) {

        Page<Blog> blogs = blogService.findByCategory_Id(id, pageable);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/blogview/{id}")
    public ModelAndView viewBlog(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView(("/blog/view"));
        Blog blog = blogService.findById(id);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
}
