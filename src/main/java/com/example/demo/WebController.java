package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/api")
public class WebController {

    @Autowired
    MathService mathService;

    @Autowired
    PersonRepo personRepo;

    @GetMapping("/entity/{id}")
    public int getEntityById(@PathVariable int id) {
        return id;
    }

    @GetMapping("/math/{var1}/{var2}")
    public MathResponse getSum(@PathVariable int var1, @PathVariable int var2) {
        return mathService.addInts(var1,var2);
    }

    @GetMapping("/people")
    public List<Person> getAllPeople(){
        return personRepo.findAll();
    }

}