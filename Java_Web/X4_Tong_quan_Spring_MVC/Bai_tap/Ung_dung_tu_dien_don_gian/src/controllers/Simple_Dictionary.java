package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Simple_Dictionary {
    @PostMapping("/search")
    public String simpleDictionary(@RequestParam String txtSearch, Model model) {
        Map<String, String> simpleDictionary = new HashMap<>();
        simpleDictionary.put("Hùng", "Hung Hăn");
        simpleDictionary.put("Hòa", "Hí Hửng");
        simpleDictionary.put("Quốc", "Quằn Quại");
        simpleDictionary.put("Cường", "Cần Cù");
        simpleDictionary.put("Tân", "Táo Tợn");
        simpleDictionary.put("Long", "Lém Lỉnh");
        simpleDictionary.put("Tiến", "Tưng Tửng");
        String result = simpleDictionary.get(txtSearch);
        if (result != null) {
            model.addAttribute("result", result);
            model.addAttribute("word", txtSearch);
        } else {
            model.addAttribute("notFound", "Không tìm thấy");
        }

        return "index1";
    }
}
