package clientauthw1nserver.w1nserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;



@RestController
public class IndexController {

    //This method will be used to check if the user has a valid token to access the resource
    @RequestMapping("/validateUser")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/test")
    public ModelAndView test(Principal user) {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("userName" , user.getName());
        return model;
    }


}
