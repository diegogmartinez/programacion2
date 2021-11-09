package gt.edu.umg.demop2bsegundo.dao;

import gt.edu.umg.demop2bsegundo.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Win10
 */
public interface IpersonaDao extends CrudRepository<Persona, Long> {
    
}