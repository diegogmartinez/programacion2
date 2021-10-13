
package ClsModelos;


public class mdUsuario {
    
    private int id;
    private String username;
    private String password;
    private String correo;
    private String pokemon;


    public mdUsuario() {
        
    }

    @Override
    public String toString() {
        return "mdUsuario{" + "id=" + id + ", username=" + username + ", password=" + password + ", correo=" + correo + '}';
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
