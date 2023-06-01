package com.example.springbootcrud.view;

import com.example.springbootcrud.modul.Employee;
import com.example.springbootcrud.repository.EmployeeRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "home";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("employee", new Employee());
        return "add";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee,
                       BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "add";
        employeeRepository.save(employee);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Employee employee = findEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("employee") Employee employee,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        employeeRepository.save(employee);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        employeeRepository.deleteById(id);
        return "redirect:/";
    }
    private Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid employee ID: "+ id));
    }
}
