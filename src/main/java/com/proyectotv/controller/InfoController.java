package com.proyectotv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class InfoController {
    
    @GetMapping("internet")
    public String internet(Model model) {
        
        return "/info/internet";    
    }
    
    @GetMapping("tv")
    public String tv(Model model) {
        
        return "/info/tv";    
    }
    
    @GetMapping("voice")
    public String voice(Model model) {
        
        return "/info/voice";    
    }
    
    @GetMapping("mobile")
    public String mobile(Model model) {
        
        return "/info/mobile";    
    }
}
