package com.ahn.springboot.controller;

import com.ahn.springboot.domain.WideSession;
import com.ahn.springboot.persistence.WideSessionRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
@Controller
public class LoginController {

    @Autowired
    WideSessionRepository wideSessionRepository;

    @GetMapping("/login")
    public void login() {
        log.info("enter GET Login controller");
    }

    @GetMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login");
    }

    @GetMapping("/logout")
    public void logout(HttpServletResponse response) throws  Exception{
        log.info("enter Logout controller");
        String authenticatedSessionID = RequestContextHolder.currentRequestAttributes().getSessionId();

        log.info("로그아웃 할 SID : " + authenticatedSessionID);

        wideSessionRepository.findById(authenticatedSessionID)
                .filter(session -> session.getWide_session_id().equals(authenticatedSessionID))
                .ifPresent(session -> {
                    log.info("SID : " + authenticatedSessionID);
                    wideSessionRepository.save(session);
                    log.info("로그아웃 성공");
                });

        response.sendRedirect("/login");
    }




}
