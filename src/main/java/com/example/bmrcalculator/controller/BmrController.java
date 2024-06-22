package com.example.bmrcalculator.controller;

import com.example.bmrcalculator.model.Bmr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BmrController {

    @GetMapping("/bmr-calculator")
    public String showBmr(){
        return "bmr";


    }

    @PostMapping("/calculate")
    public String calculateBmr(@ModelAttribute Bmr bmr1, Model model){

        double bmr;
        bmr = calculate(bmr1.getAge(), bmr1.getGender(),bmr1.getHeight(),bmr1.getWeight());
        model.addAttribute("bmr",bmr);
        return "result";
    }


    private double calculate(int age, String gender, double height, double weight){

        double bmr = 0;
        if(gender.equalsIgnoreCase("male")){
            double a = 13.75 * weight;
            double b = 5.003 * height;
            double c = 6.75 * age;
            bmr =  66.5 + a + b - c;
        }
        else if (gender.equalsIgnoreCase("female")){

            double a = 9.563 * weight;
            double b = 1.850 * height;
            double c = 4.679 * age;

            bmr = 655.1 +a+b-c;
        }
        return bmr;

    }
}
