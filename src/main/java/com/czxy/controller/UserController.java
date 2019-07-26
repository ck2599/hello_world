package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public ResponseEntity<String> login(User user, HttpServletRequest httpServletResponse){
        try {
            User login = userService.login(user);
            if (login!=null){
                HttpSession session = httpServletResponse.getSession();
                session.setAttribute("login",login);
                return new ResponseEntity<>("登陆成功",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("用户名或密码错误", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<String> add(){
        System.out.println("... 执行add方法");
        return new ResponseEntity<>("add..OK",HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(){
        System.out.println("... 执行update方法");
        return new ResponseEntity<>("update..OK",HttpStatus.OK);
    }

    @PostMapping("/del")
    public ResponseEntity<String> del(){
        System.out.println("... 执行del方法");
        return new ResponseEntity<>("del..OK",HttpStatus.OK);
    }

}
