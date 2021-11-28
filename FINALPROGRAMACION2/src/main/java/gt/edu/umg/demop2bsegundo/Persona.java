
package gt.edu.umg.demop2bsegundo;
import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;

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
    private Long ID_FACULTAD;
    private Long ID_MARCA_CARRO;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String fecha_nacimiento;
    private Double longitud;
    private Double latitud;
    private String fecha_registro; 
}