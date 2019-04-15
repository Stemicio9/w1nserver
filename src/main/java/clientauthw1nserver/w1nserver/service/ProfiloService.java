package clientauthw1nserver.w1nserver.service;

import clientauthw1nserver.w1nserver.dao.ProfiloDao;
import clientauthw1nserver.w1nserver.model.Profilo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "profiloService")
public class ProfiloService {


    @Autowired
    ProfiloDao profiloDao;

    @Autowired
    UserService userService;



    public Profilo prendiProfiloDaUsername(String username){
          long id = userService.prendiIdByUsername(username);
          Profilo result = profiloDao.findById(id);
          return result;
    }


}
