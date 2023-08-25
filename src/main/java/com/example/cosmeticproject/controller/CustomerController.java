package com.example.cosmeticproject.controller;

import com.example.cosmeticproject.dto.CustomerDto;
import com.example.cosmeticproject.dto.request.CustomerRequest;
import com.example.cosmeticproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
public class CustomerController {

    final CustomerService customerService;


    @GetMapping({"/list", "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("list-customers");
        mav.addObject("customers", customerService.getAllCustomerByName("nijat"));
        return mav;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-employee-form");
        CustomerRequest newCustomer = new CustomerRequest();
        mav.addObject("customer", newCustomer);
        return mav;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute CustomerRequest customerRequest ) {
        customerService.saveCustomer(customerRequest);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
        ModelAndView mav = new ModelAndView("add-employee-form");
        CustomerDto customerDto = customerService.getCustomerById(employeeId);
        mav.addObject("customer", customerDto);
        return mav;
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long employeeId) {
        customerService.deleteCustomerById(employeeId);
        return "redirect:/list";
    }

    }

