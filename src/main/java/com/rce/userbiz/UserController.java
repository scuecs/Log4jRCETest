package com.rce.userbiz;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String contentBuy(@RequestParam String username, @RequestParam String password) {

        System.out.println("OriginUsername:"+username);
        log.info("loginUser:{}", username);

        return username+":"+password;

    }

}
