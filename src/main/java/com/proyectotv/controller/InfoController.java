
package com.proyectotv.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InfoController {
    
    @GetMapping("info/internet")
    public String internet(Model model) {
        
        return "/info/internet";    
    }
    
    @GetMapping("info/tv")
    public String tv(Model model) {
        
        return "/info/tv";    
    }
    
    @GetMapping("info/voice")
    public String voice(Model model) {
        
        return "/info/voice";    
    }
    
    @GetMapping("info/mobile")
    public String mobile(Model model) {
        
        return "/info/mobile";    
    }
}
