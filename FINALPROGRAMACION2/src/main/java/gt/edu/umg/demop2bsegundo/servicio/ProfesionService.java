package gt.edu.umg.demop2bsegundo.servicio;

import gt.edu.umg.demop2bsegundo.Profesion;
import java.util.List;


public interface ProfesionService {
    public List<Profesion> listaProfesiones();
    public void guardar(Profesion profesion);
    public void eliminar(Profesion profesion);
    public Profesion encontrarProfesion(Profesion profesion);
}