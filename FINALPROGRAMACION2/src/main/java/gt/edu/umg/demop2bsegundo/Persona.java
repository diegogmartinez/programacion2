/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.demop2bsegundo;
import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;

/**
 *
 * @author Win10
 */
@Data
@Entity
@Table(name="Persona")
public class Persona implements Serializable{
    private static final long serialVersionUI = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;
    private Long ID_DEPTO;
    private Long ID_PROFESION;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String fecha_nacimiento;
    private Double longitud;
    private Double latitud;
    private String fecha_registro; 
}