/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demop2bsegundo.servicio;

import gt.edu.umg.demop2bsegundo.Departamento;
import gt.edu.umg.demop2bsegundo.Persona;
import java.util.List;


public interface DepartamentoService {
    public List<Departamento> listaDepartamento();
    public void guardar(Departamento depto);
    public void eliminar(Departamento depto);
    public Persona encontrarPersona(Departamento depto);
}