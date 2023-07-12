package ru.Bogachev.calculate.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.Bogachev.calculate.service.CalculateService;
@Controller
@RequiredArgsConstructor
public class MainController {
    private final CalculateService calculateService;
    @GetMapping("/")
    public String userBmi () {
        return "main";
    }
    @PostMapping("/")
    public String bmi (
            @RequestParam String height,
            @RequestParam String weight, Model model) {
        if(height.isEmpty() && weight.isEmpty()) {
            model.addAttribute("imt",
                    "Некорректные данные");
        }
        else {
            String [] result = calculateService.calculationBmi(height, weight);
            int size = result.length;
            String imt = result[0];
            if(size == 2) {
                String res = result[1];
                model.addAttribute("imt", imt);
                model.addAttribute("res", res);
            }
            model.addAttribute("imt", imt);
        }
        return "main";
    }
}
