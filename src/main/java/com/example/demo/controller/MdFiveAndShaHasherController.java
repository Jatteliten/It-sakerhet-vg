package com.example.demo.controller;

import com.example.demo.services.MdFiveAndShaConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.NoSuchAlgorithmException;

@Controller
public class MdFiveAndShaHasherController {
    MdFiveAndShaConverter converter = new MdFiveAndShaConverter();

    @RequestMapping("/md5-and-sha")
    public String mdFiveAndShaForm(){
        return "createmd5andsha.html";
    }

    @RequestMapping("/md5-and-sha/result")
    public String mdFiveAndShaResult(@RequestParam String inputText, Model model){
        try {
            model.addAttribute("md5text", converter.getMD5(inputText));
            model.addAttribute("shatext", converter.toHexString(converter.getSHA(inputText)));
        }catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }

        return "md5andsharesult.html";
    }

}
