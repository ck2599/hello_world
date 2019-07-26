package com.czxy.Interceptor;

import com.czxy.domain.Log;
import com.czxy.domain.User;
import com.czxy.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 1519389876@qq.com
 * @version v 1.0
 * @date 2019/7/25  11:11
 * @infos
 */

@Component
public class Interceptor implements HandlerInterceptor {
    @Autowired
    private LogService logService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String s = request.getRequestURL().toString();
        System.out.println(s);
//        if (s.contains("login")){
//            return true;
//        }else {
//            User login = (User) request.getSession().getAttribute("login");
//            if (login==null){
//                response.sendRedirect("index.html");
//                return false;
//            }else {
//                return true;
//            }
//        }
        if (s.contains("index.html") || s.contains("css") || s.contains("js") || s.contains("images") || s.contains("login")) {
            return true;
        } else {

            User login = (User) request.getSession().getAttribute("login");
            if (s.contains("user")&&login==null){
                response.sendRedirect("/index.html");
                return false;
            }
            if (login==null){
                response.sendRedirect("/index.html");
                return false;
            }else {
                if (s.contains("user/")){
                    String s1=s.split("/")[4];
                    System.out.println(s1);
                    Date date=new Date();
                    DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String format = dateFormat.format(date);
                    System.out.println(format);
                    Log log=new Log(null,login.getId(),login.getUsername(),s1,date);
                    logService.add(log);

                }
                return true;
            }
        }
    }
}
