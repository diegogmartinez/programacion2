
package gt.edu.umg.demop2bsegundo;

import gt.edu.umg.demop2bsegundo.servicio.DepartamentoService;
import gt.edu.umg.demop2bsegundo.servicio.DepartamentoService;
import gt.edu.umg.demop2bsegundo.servicio.PersonaService;
import gt.edu.umg.demop2bsegundo.servicio.ProfesionService;
import gt.edu.umg.demop2bsegundo.servicio.ProfesionService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Win10
 */

@Controller
public class ControladorInicio {
    @Autowired 
    private PersonaService personaService;
    @Autowired 
    private DepartamentoService departamentoService;
    @Autowired 
    private ProfesionService profesionService;
    
    
    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaService.listaPersonas();
        model.addAttribute("personas", personas);
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id_persona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{id_persona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/"; 
    }
    
    @GetMapping("/agregar_depto")
    public String agregar(Departamento depto){
        return "departamento";
    }
    
    @PostMapping("/guardar_depto")
    public String guardar(Departamento depto){
        departamentoService.guardar(depto);
        return "redirect:/";
    }
    
    @GetMapping("/agregar_profesion")
    public String agregar(Profesion profesion){
        return "departamento";
    }
    
    @PostMapping("/guardar_profesion")
    public String guardar(Profesion profesion){
        profesionService.guardar(profesion);
        return "redirect:/";
    }
}