 
package gt.edu.umg.demop2bsegundo;

import gt.edu.umg.demop2bsegundo.servicio.CarroService;
import gt.edu.umg.demop2bsegundo.servicio.DepartamentoService;
import gt.edu.umg.demop2bsegundo.servicio.FacultadService;
import gt.edu.umg.demop2bsegundo.servicio.PersonaService;
import gt.edu.umg.demop2bsegundo.servicio.ProfesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ControladorInicio {
    @Autowired 
    private PersonaService personaService;
    @Autowired 
    private DepartamentoService departamentoService;
    @Autowired 
    private ProfesionService profesionService;
    @Autowired 
    private FacultadService facultadService;
    @Autowired 
    private CarroService carroService;
    
    
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
        return "profesion";
    }
    
    @PostMapping("/guardar_profesion")
    public String guardar(Profesion profesion){
        profesionService.guardar(profesion);
        return "redirect:/";
    }
    
    @GetMapping("/agregar_facultad")
    public String agregar(Facultad facultad){
        return "facultad";
    }
    
    @PostMapping("/guardar_facultad")
    public String guardar(Facultad facultad){
        facultadService.guardar(facultad);
        return "redirect:/";
    }
    
    @GetMapping("/agregar_carro")
    public String agregar(Carro carro){
        return "carro";
    }
    
    @PostMapping("/guardar_carro")
    public String guardar(Carro carro){
        carroService.guardar(carro);
        return "redirect:/";
    }
}