/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demop2bsegundo.servicio;

import gt.edu.umg.demop2bsegundo.Persona;
import java.util.List;

/**
 *
 * @author Win10
 */
public interface PersonaService {
    public List<Persona> listaPersonas();
    public void guardar(Persona persona);
    public void eliminar(Persona persona);
    public Persona encontrarPersona(Persona persona);
}