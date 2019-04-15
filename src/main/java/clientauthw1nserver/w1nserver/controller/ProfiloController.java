package clientauthw1nserver.w1nserver.controller;


import clientauthw1nserver.w1nserver.dto.ApiResponse;
import clientauthw1nserver.w1nserver.model.Profilo;
import clientauthw1nserver.w1nserver.service.AuthenticationFacadeServiceImpl;
import clientauthw1nserver.w1nserver.service.ProfiloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import static clientauthw1nserver.w1nserver.controller.UserController.*;

@RestController
@RequestMapping("/profilo")
public class ProfiloController {


    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private AuthenticationFacadeServiceImpl authenticationFacadeService;

    @Autowired
    private ProfiloService profiloService;




    @Secured({ROLE_ADMIN, ROLE_USER, ROLE_DATORE})
    @RequestMapping(value = "/prendiprofilo" , method = RequestMethod.GET)
    public ApiResponse prendiprofilo(){
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authenticationFacadeService.getAuthentication().getPrincipal();

        if(principal == null) {
            log.info("NON HO TROVATO L'UTENTE");
        }else{
            log.info("HO TROVATO L'UTENTE " + principal.getUsername());
        }

        Profilo result = profiloService.prendiProfiloDaUsername(principal.getUsername());

        log.info(result.getEmail());


        return new ApiResponse(HttpStatus.OK, SUCCESS, result);
    }





}
