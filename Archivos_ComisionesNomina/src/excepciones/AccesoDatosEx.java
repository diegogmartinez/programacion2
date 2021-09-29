
package excepciones;

public class AccesoDatosEx extends Exception{
    String mesaje;
    
    public AccesoDatosEx(String msg){
        this.mesaje=msg;        
    }
    
    
}
