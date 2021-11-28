
package gt.edu.umg.demop2bsegundo.servicio;

import gt.edu.umg.demop2bsegundo.Facultad;
import gt.edu.umg.demop2bsegundo.dao.IfacultadDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class FacultadServiceImpl implements FacultadService{

    @Autowired
    private IfacultadDao IfacultadDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Facultad> listaFacultad() {
        return (List<Facultad>) IfacultadDao.findAll();
    }

    @Override
    public void guardar(Facultad facultad) {
        IfacultadDao.save(facultad);
    }

    @Override
    public void eliminar(Facultad facultad) {
        IfacultadDao.delete(facultad);
    }

    @Override
    public Facultad encontrarFacultad(Facultad facultad) {
        throw new UnsupportedOperationException("No"); 
    }
    
}
