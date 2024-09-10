package com.example.demo.controller;

import com.example.demo.services.MdFiveAndShaCracker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MdFiveAndShaCrackerController {
    MdFiveAndShaCracker cracker = new MdFiveAndShaCracker();

    @RequestMapping("/crack-md5-and-sha256")
    public String crackMdFiveAndSha(){
        return "crackmd5andsha.html";
    }

    @RequestMapping("/crack-md5-and-sha256/result")
    public String crackMdFiveAndShaResult(@RequestParam String inputHash, Model model){
        model.addAttribute("password", cracker.crackPasswordAndReturnResultOrFail(inputHash));
        return "crackmd5andsharesult.html";
    }
}
