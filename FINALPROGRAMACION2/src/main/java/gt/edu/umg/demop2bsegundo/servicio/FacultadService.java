
package gt.edu.umg.demop2bsegundo.servicio;


import gt.edu.umg.demop2bsegundo.Facultad;
import java.util.List;


public interface FacultadService {
    public List<Facultad> listaFacultad();
    public void guardar(Facultad facultad);
    public void eliminar(Facultad facultad);
    public Facultad encontrarFacultad(Facultad facultad);
}
