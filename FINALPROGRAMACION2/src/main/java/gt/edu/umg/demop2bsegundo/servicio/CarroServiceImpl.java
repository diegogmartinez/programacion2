
package gt.edu.umg.demop2bsegundo.servicio;

import gt.edu.umg.demop2bsegundo.Carro;
import gt.edu.umg.demop2bsegundo.dao.IcarroDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class CarroServiceImpl implements CarroService{

    @Autowired
    private IcarroDao IcarroDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Carro> listaCarro() {
        return (List<Carro>) IcarroDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Carro carro) {
        IcarroDao.save(carro);
    }

    @Override
    @Transactional
    public void eliminar(Carro carro) {
        IcarroDao.delete(carro);
    }

    @Override
    @Transactional
    public Carro encontrarCarro(Carro carro) {
        throw new UnsupportedOperationException("No"); 
    }
    
}
