package clientauthw1nserver.w1nserver.controller;

import clientauthw1nserver.w1nserver.dto.ApiResponse;
import clientauthw1nserver.w1nserver.dto.UserDto;
import clientauthw1nserver.w1nserver.model.User;
import clientauthw1nserver.w1nserver.service.AuthenticationFacadeServiceImpl;
import clientauthw1nserver.w1nserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public static final String SUCCESS = "success";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private UserService userService;


    @Autowired
    private AuthenticationFacadeServiceImpl authenticationFacadeService;

    @Secured({ROLE_ADMIN})
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public ApiResponse listUser(){
        log.info(String.format("received request to list user %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findAll());
    }

    @Secured({ROLE_ADMIN})
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ApiResponse create(@RequestBody UserDto user){
        log.info(String.format("received request to create user %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.save(user));
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public UserDto findOne(@PathVariable long id){
        return userService.findOne(id).toUserDto();
    }

    @Secured({ROLE_ADMIN, ROLE_USER})
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ApiResponse update(@PathVariable long id){
        log.info(String.format("received request to update user %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findOne(id));
    }

    @Secured({ROLE_ADMIN})
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        log.info(String.format("received request to delete user %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        userService.delete(id);
    }

    @Secured({ROLE_ADMIN, ROLE_USER})
    @RequestMapping(value = "/user/chisono" , method = RequestMethod.GET)
    public ApiResponse chisono(){
        try {
            log.info(String.format("CHI SONO %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        }catch(Exception e){
            System.out.println("NON CI SONO UTENTI LOGGATI");
        }

        return new ApiResponse(HttpStatus.OK, SUCCESS, authenticationFacadeService.getAuthentication().getPrincipal());
    }



}