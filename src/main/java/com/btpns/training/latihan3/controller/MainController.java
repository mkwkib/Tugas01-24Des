package com.btpns.training.latihan3.controller;

import com.btpns.training.latihan3.entity.UserEntity;
import com.btpns.training.latihan3.service.PasswordConverterService;
import com.btpns.training.latihan3.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordConverterService passwordConverterService;

    @RequestMapping(value = "/main")
    public String mainPage(Model model){

        return "index";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String loginPage (Model model, String error, String logout, HttpServletRequest request,
                                 @ModelAttribute("userEntity") UserEntity userEntity){
            if(error != null){
                model.addAttribute("error", "*Your Username or Password is Invalid");
            }
            if(logout != null){
                model.addAttribute("message", "Kamu sudah Logout");
            }
            return "index";
        }

    @RequestMapping(value = "/saveRegis")
    public String saveRegis(Model model, @ModelAttribute("userEntity")UserEntity userEntity){
        userEntity.setPassword(passwordConverterService.convertPassword(userEntity.getPassword()));
        userService.insertUser(userEntity);
        return "index";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutRequestMatcher(Model model, String error, String logout){
        if(error != null){
            model.addAttribute("error", "*Your Username or Password is Invalid");
        }
        if(logout != null){
            model.addAttribute("message", "Kamu sudah Logout");
        }
        return "index";
    }
}
