/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demop2bsegundo.servicio;

import gt.edu.umg.demop2bsegundo.Departamento;
import gt.edu.umg.demop2bsegundo.Persona;
import gt.edu.umg.demop2bsegundo.dao.IdeptoDao;
import gt.edu.umg.demop2bsegundo.dao.IpersonaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Win10
 */
@Service
public class DepartamentoServiceImpl implements DepartamentoService{
    @Autowired
    private IdeptoDao IdeptoDao;
    
    
 

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> listaDepartamento() {
      return (List<Departamento>) IdeptoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Departamento depto) {
       IdeptoDao.save(depto);
    }

    @Override
    @Transactional
    public void eliminar(Departamento depto) {
        IdeptoDao.delete(depto);
    }

    @Override
    public Persona encontrarPersona(Departamento depto) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}