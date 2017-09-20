package com.ahn.springboot.controller;

import com.ahn.springboot.domain.AdwideAdvertiser;
import com.ahn.springboot.domain.WideAdmin;
import com.ahn.springboot.persistence.AdwideAdvertiserRepository;
import com.ahn.springboot.persistence.WideAdminRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Binding;

@Controller
@RequestMapping("/admin/")
@Log
public class AdvertiserController {
    @Autowired
    AdwideAdvertiserRepository adwideAdvertiserRepository;

    @Autowired
    WideAdminRepository wideAdminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/main")
    public void main(){

    }

    @GetMapping("/advertiser/advertiserRegister")
    public void GetRegisterAdvertiser(){
        log.info("Advertiser Regist Page");
    }

    @PostMapping("/advertiser/advertiserRegister")
    public void PostRegisterAdvertiser(@ModelAttribute("adwideAdvertiser") AdwideAdvertiser advertiserVO
                                       ,BindingResult bindingResult){
        WideAdmin wideAdmin = new WideAdmin();

        wideAdmin.setWide_admin_email(advertiserVO.getAdvertiser_email());
        wideAdmin.setWide_admin_name(advertiserVO.getAdvertiser_name());
        wideAdmin.setWide_admin_contractStatusCode(advertiserVO.getAdvertiser_contract_statusCode());
        wideAdmin.setWide_admin_contractFinishDate(advertiserVO.getAdvertiser_finish_date());
        wideAdmin.setWide_admin_roleCode("AD");
        wideAdmin.setWide_admin_password(passwordEncoder.encode("1234"));

        wideAdminRepository.save(wideAdmin);
        adwideAdvertiserRepository.save(advertiserVO);
    }

}
