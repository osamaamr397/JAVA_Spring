package com.luv2code.springdemo.mvc.controller;

import com.luv2code.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // add an itibinder ... to convert trim input  strings
    //remove loading and trailing whitespace
    //resolve issue for or validation
    @InitBinder
    //this method will called for every web request coming into our controller
    public void initBinder(WebDataBinder dataBinder){
        //this will remove whitespace leading and trailing
        //StringTrimmerEditor defined in spring API
        //StringTrimmerEditor(true) it is true meaning that if it's all white space trim it down to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @GetMapping("/")
    public String showForm(Model theModel) {
        //model allows us to share information between the controllers and view pages

        theModel.addAttribute("customer", new Customer());
        return "customer-form";

    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
        //video 196 is very important
        //@Valid tell spring MVC to perform Validation for this given form data which in Customer Class
        //@ModelAttribute("customer") read the form data from the model attribute customer
        //so that's the customer that was submitted by the form which submitted
        //BindingResult bindingResult -> hold the result of validation

        System.out.println("Last name: |"+theCustomer.getLastName() + "|");

        //the binding result
        System.out.println("Binding Result "+theBindingResult.toString());
        System.out.println("\n\n\n\n\n");

        if (theBindingResult.hasErrors()){
            return "customer-form";
        }else{
            return "customer-confirmation";
        }

    }
}
