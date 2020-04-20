package vnnhnlm.create_product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vnnhnlm.create_product.model.Image;
import vnnhnlm.create_product.service.ImageService;

import java.util.List;

@Controller
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/images")
    public ModelAndView listImages() {
        ModelAndView modelAndView = new ModelAndView("/image/list");
        List<Image> images = imageService.findAll();
        modelAndView.addObject("images", images);
        return modelAndView;
    }

    @GetMapping("/create-image")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/image/create");
        modelAndView.addObject("image", new Image());
        return modelAndView;
    }

    @PostMapping("create-image")
    public ModelAndView saveImage(@ModelAttribute("image") Image image) {
        imageService.save(image);
        ModelAndView modelAndView = new ModelAndView("/image/create");
        modelAndView.addObject("message", "New Image created successfully");
        modelAndView.addObject("image", new Image());
        return modelAndView;
    }

    @GetMapping("edit-image/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Image image = imageService.findById(id);
        ModelAndView modelAndView;
        if (image != null) {
            modelAndView = new ModelAndView("/image/edit");
            modelAndView.addObject("image", image);
        } else {
            modelAndView = new ModelAndView("image/error.404");
        }
        return modelAndView;
    }

    @PostMapping("edit-image")
    public ModelAndView updateImage(@ModelAttribute("image") Image image) {
        ModelAndView modelAndView = new ModelAndView("/image/create");
        imageService.save(image);
        modelAndView.addObject("message", "Image updated successfully");
        modelAndView.addObject("image", image);
        return modelAndView;
    }

    @GetMapping("delete-image/{id}")
    public ModelAndView showFormDelete(@PathVariable("id") Long id) {
        ModelAndView modelAndView;
        Image image = imageService.findById(id);
        if (image != null) {
            modelAndView = new ModelAndView("/image/delete");
            modelAndView.addObject("image", image);
        } else {
            modelAndView = new ModelAndView("/image/error.404");
        }
        return modelAndView;
    }

    @PostMapping("delete-image")
    public String deleteImage(@ModelAttribute("image") Image image) {
        imageService.remove(image.getId());
        return "redirect:images";
    }

    @GetMapping("view-image/{id}")
    public ModelAndView viewImage(@PathVariable("id")Long id) {
        ModelAndView modelAndView = new ModelAndView("/image/view");
        Image image = imageService.findById(id);
        modelAndView.addObject("image", image);
        return modelAndView;
    }
}
