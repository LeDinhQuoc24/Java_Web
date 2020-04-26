package casestudy.javaweb.controller;

import casestudy.javaweb.persistence.entity.Image;
import casestudy.javaweb.persistence.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("images")
    public ModelAndView listImage() {
        List<Image> images = imageService.findAll();
        return new ModelAndView("imageCustomer/listImage", "images", images);
    }

    @GetMapping("createImage")
    public ModelAndView showFormCreate() {
        return new ModelAndView("imageCustomer/createImage", "image", new Image());
    }

    @PostMapping("createImage")
    public ModelAndView saveImage(@ModelAttribute("image") Image image) {
        imageService.save(image);
        List<Image> images = imageService.findAll();
        ModelAndView modelAndView = new ModelAndView("imageCustomer/listImage");
        modelAndView.addObject("images", images);
        modelAndView.addObject("message", "New Image created successfully");
        return modelAndView;
    }

    @GetMapping("editImage/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Image image = imageService.findById(id);
        if (image != null) {
            return new ModelAndView("imageCustomer/editImage", "image", image);
        }
        return new ModelAndView("error.404");
    }

    @PostMapping("editImage")
    public ModelAndView updateImage(@ModelAttribute("image") Image image) {
        imageService.save(image);
        List<Image> images = imageService.findAll();
        ModelAndView modelAndView = new ModelAndView("imageCustomer/listImage");
        modelAndView.addObject("message", "Image updated successfully");
        modelAndView.addObject("images", images);
        return modelAndView;
    }

    @GetMapping("deleteImage/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        Image image = imageService.findById(id);
        if (image != null) {
            return new ModelAndView("imageCustomer/deleteImage", "image", image);
        }
        return new ModelAndView("error.404");
    }
    @PostMapping("deleteImage")
    public String deleteImage(@ModelAttribute("image")Image image) {
        imageService.remove(image.getId());
        return "redirect:images";
    }
}
