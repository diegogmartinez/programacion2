/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import BaseDatos.ConexionMYSQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelos.*;

/**
 *
 * @author mjber
 */
public class ClsUsuario {
    
    private static final String SQL_SELECT="SELECT * FROM bd_nominacomisiones.tb_usuario";
    private static final String SQL_VALIDACION="select * from tb_usuario where binary username=? and contraseña=(aes_encrypt(?,?));";   
    private static final String SQL_UPDATE="UPDATE tb_usuario SET username=?, contraseña=(aes_encrypt(?,?)) where id=?";
    private static final String SQL_DELETE="Delete from tb_usuario where id=?";
    private static final String SQL_INSERT="insert into tb_usuario (username, contraseña) values (?,aes_encrypt(?,?));";            
    
    public List<mdUsuario> listar(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        mdUsuario usuario=null;       
        List<mdUsuario> listUsu = new ArrayList<mdUsuario>();
        
        
           
        try {
            conn=ConexionMYSQL.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            
            while(rs.next()){
                int codigo=rs.getInt(1);
                String nomUsuario=rs.getString(2);
                String psw=rs.getString(3);
                usuario= new mdUsuario();
                usuario.setId(codigo);
                usuario.setUsername(nomUsuario);
                usuario.setContraseña(psw);
                listUsu.add(usuario);
                                               
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ConexionMYSQL.close(rs);
            ConexionMYSQL.close(stmt);
            ConexionMYSQL.close(conn);
        }

        return listUsu;
        
    }
    
    public boolean validacion(mdUsuario datos){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        boolean permiso=false;
        
           
        try {
            conn=ConexionMYSQL.getConnection();
            stmt=conn.prepareStatement(SQL_VALIDACION);
            stmt.setString(1, datos.getUsername());
            stmt.setString(2, datos.getContraseña());
            stmt.setString(3, datos.getUsername());
            rs=stmt.executeQuery();

                        
            while(rs.next()){
                permiso=true;                                                                               
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ConexionMYSQL.close(rs);
            ConexionMYSQL.close(stmt);
            ConexionMYSQL.close(conn);
        }

        return permiso;
        
    }
    
    public void escribir(mdUsuario usu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConexionMYSQL.getConnection();                        
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usu.getUsername());
            stmt.setString(2, usu.getContraseña());   
            stmt.setString(3, usu.getClave());

            System.out.println("ejecutando query:" + SQL_INSERT);
                                                                        
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionMYSQL.close(stmt);            
            ConexionMYSQL.close(conn);
        }
                        
    }
    
    public void modificar(mdUsuario datos ){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ConexionMYSQL.getConnection();                        
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, datos.getUsername());            
            stmt.setString(2, datos.getContraseña());
            stmt.setString(3, datos.getUsername());                        
            stmt.setInt(4, datos.getId());

            System.out.println("ejecutando query:" + SQL_UPDATE);
                                                                    

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionMYSQL.close(stmt);            
            ConexionMYSQL.close(conn);
        }

        
    }
    
    
    public int borrarDato(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;

        try {
            conn = ConexionMYSQL.getConnection();                        
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);            

            System.out.println("ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
            //Reordenar-restablecer la clave principal de incremento automático
            stmt.execute("ALTER TABLE bd_nominacomisiones.tb_usuario DROP id;");
            stmt.execute("ALTER TABLE bd_nominacomisiones.tb_usuario AUTO_INCREMENT = 1;");
            stmt.execute("ALTER TABLE bd_nominacomisiones.tb_usuario ADD id bigint UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;");
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionMYSQL.close(stmt);            
            ConexionMYSQL.close(conn);
        }

        return rows;
    }
    
}
