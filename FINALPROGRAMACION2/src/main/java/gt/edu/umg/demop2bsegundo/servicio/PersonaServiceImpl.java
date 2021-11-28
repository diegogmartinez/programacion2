
package gt.edu.umg.demop2bsegundo.servicio;
import gt.edu.umg.demop2bsegundo.Persona;
import gt.edu.umg.demop2bsegundo.dao.IpersonaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private IpersonaDao IpersonaDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listaPersonas() {
       return (List<Persona>) IpersonaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
       IpersonaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        IpersonaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly=true)
    public Persona encontrarPersona(Persona persona) {
        return IpersonaDao.findById(persona.getId_persona()).orElse(null);
    }
    
}