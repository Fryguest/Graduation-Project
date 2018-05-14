package com.wlmiao.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/forbidden")
    public String forbidden() {
        logger.info("subject {} permission denied", SecurityUtils.getSubject().getPrincipal());
        return "forbidden";
    }

    @RequestMapping("/logout")
    public String logout() {
        logger.info("subject {} logout", SecurityUtils.getSubject().getPrincipal());
        SecurityUtils.getSubject().logout();
        return "redirect:index";
    }

    @RequestMapping("/login")
    public String login(String username, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        if (StringUtils.hasText(username) && StringUtils.hasText(password)) {
            try {
                currentUser.login(new UsernamePasswordToken(username, password));
                logger.info("subject {} login success", SecurityUtils.getSubject().getPrincipal());
            } catch (Exception e) {
                logger.info("subject {} login failed", username);
                return "login";
            }
            return "redirect:index";
        } else {
            return "login";
        }
    }

}
