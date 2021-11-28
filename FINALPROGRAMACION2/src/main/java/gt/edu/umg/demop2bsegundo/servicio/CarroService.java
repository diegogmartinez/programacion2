
package gt.edu.umg.demop2bsegundo.servicio;

import gt.edu.umg.demop2bsegundo.Carro;
import java.util.List;


public interface CarroService {
    public List<Carro> listaCarro();
    public void guardar(Carro carro);
    public void eliminar(Carro carro);
    public Carro encontrarCarro(Carro carro);
    
}
