package clientauthw1nserver.w1nserver.dao;

import clientauthw1nserver.w1nserver.model.Profilo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfiloDao extends CrudRepository<Profilo,Long> {

    Profilo findById(long id);

}
