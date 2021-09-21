
package modelos;

public class mdUsuario {
    
    private int id;
    private String username;
    private String contraseña;
    private String clave;

    @Override
    public String toString() {
        return "mdUsuario{" + "id=" + id + ", username=" + username + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    public mdUsuario(){
        
    }
    
    public mdUsuario(int id_usuario){
        this.id=id_usuario;
    }
    
    public mdUsuario(String username, String contra){
        this.username=username;
        this.contraseña=contra;
    }
    
    public mdUsuario(int id_usuario,String username, String contra ){
        this.id=id_usuario;
        this.username=username;
        this.contraseña=contra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
