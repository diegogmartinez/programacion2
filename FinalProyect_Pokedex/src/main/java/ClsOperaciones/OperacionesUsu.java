
package ClsOperaciones;

import ClsModelos.mdPokemon;
import ClsModelos.mdUsuario;
import Conexion.ConexionMYSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperacionesUsu {
    
    private String SQL_INSERTUSU="insert into tb_usuariospokemon (username, contraseña, correo) values(?,aes_encrypt(?,?),?);";
    private String SQL_SELECTNOMPokemon="select * from pokemon where name=?;";
    private String SQL_SELECTColor="select * from pokemon where color=?;";
    private String SQL_SELECTGeneration="select * from pokemon where generation_id=?;";
    private String SQL_SELECTSpecies="select * from pokemon where species=?;";
    private String SQL_SELECTHabitat="select * from pokemon where habitat=?;";
    private String SQL_SELECTRCaptura="select * from pokemon where capture_rate=?;";
    private String SQL_SELECTEBase="select * from pokemon where base_experience=?;";
    private String SQL_SELECTUsuFav="select * from pokemon where id in (select pokemon_id from test.tb_favoritos where username=?);";
    private String SQL_SELECTUsuNoFav="select * from pokemon where id in (select pokemon_id from test.tb_nofavoritos where username=?);";
    private String SQL_SELECTFiltro1="select distinct(color) from test.pokemon;";
    private String SQL_SELECTFiltro2="select distinct(generation_id) from test.pokemon;";
    private String SQL_SELECTFiltro3="select distinct(species) from test.pokemon;";
    private String SQL_SELECTFiltro4="select distinct(habitat) from test.pokemon;";
    private String SQL_SELECTFiltro5="select distinct(capture_rate) from test.pokemon;";
    private String SQL_SELECTFiltro6="select distinct(base_experience) from test.pokemon;";
    private String SQL_VALIDACION="select * from tb_usuariospokemon where binary username=? and contraseña=(aes_encrypt(?,?));";   
    private String SQL_VALIDACIONFavorito="select * from tb_favoritos where username=? and pokemon_id=?;";
    private String SQL_VALIDACIONNoFav="select * from tb_nofavoritos where username=? and pokemon_id=?;";
//    private String SQL_UPDATE="UPDATE tb_usuario SET username=?, contraseña=(aes_encrypt(?,?)) where id=?";
    private String SQL_DELETEFav="delete from tb_favoritos where username=? and pokemon_id=?;";
    private String SQL_DELETENoFav="delete from tb_nofavoritos where username=? and pokemon_id=?;";
    private String SQL_INSERTFavoritos="insert into tb_favoritos (username,pokemon_id) values (?,?);";            
    private String SQL_INSERTNoFavoritos="insert into tb_nofavoritos (username,pokemon_id) values (?,?);";           
    
    
    public List<mdPokemon> listar(mdPokemon usu) throws SQLException{
        
        String operacionEjec=" ";
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<mdPokemon> listPokemon = new ArrayList<mdPokemon>();
        
        switch(usu.getOperacion()){
            case 1:
                operacionEjec=SQL_SELECTNOMPokemon;
                break;
            case 2:
                operacionEjec=SQL_SELECTColor;
                break;
            case 3:
                operacionEjec=SQL_SELECTGeneration;
                break;
            case 4:
                operacionEjec=SQL_SELECTSpecies;
                break;
            case 5:
                operacionEjec=SQL_SELECTHabitat;
                break;
            case 6:
                operacionEjec=SQL_SELECTRCaptura;
                break;
            case 7:
                operacionEjec=SQL_SELECTEBase;
                break;
            case 8:
                operacionEjec=SQL_SELECTUsuFav;
                break;
            case 9:
                operacionEjec=SQL_SELECTUsuNoFav;
                break;
        }
           
        try {
            conn=ConexionMYSQL.getConnection();
            stmt=conn.prepareStatement(operacionEjec);
            stmt.setString(1, usu.getEjecutar());
            rs=stmt.executeQuery();
            
            while(rs.next()){
                mdPokemon pok=new mdPokemon();
                pok.setId(rs.getString(1));
                pok.setName(rs.getString(2));
                pok.setForme_name(rs.getString(3));
                pok.setForme_base_pokemon_id(rs.getString(4));
                pok.setGeneration_id(rs.getString(5));
                pok.setEvolution_chain_id(rs.getString(6));
                pok.setEvolution_parent_pokemon_id(rs.getString(7));
                pok.setEvolution_method_id(rs.getString(8));
                pok.setEvolution_parameter(rs.getString(9));
                pok.setHeight(rs.getString(10));
                pok.setWeight(rs.getString(11));
                pok.setSpecies(rs.getString(12));
                pok.setColor(rs.getString(13));
                pok.setPokemon_shape_id(rs.getString(14));
                pok.setHabitat(rs.getString(15));
                pok.setGender_rate(rs.getString(16));
                pok.setCapture_rate(rs.getString(17));
                pok.setBase_experience(rs.getString(18));
                pok.setBase_happiness(rs.getString(19));
                pok.setGen1_internal_id(rs.getString(20));
                pok.setIs_baby(rs.getString(21));
                pok.setHas_gen4_fem_sprite(rs.getString(22));
                pok.setHas_gen4_fem_back_sprite(rs.getString(23));
                listPokemon.add(pok);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ConexionMYSQL.close(rs);
            ConexionMYSQL.close(stmt);
            ConexionMYSQL.close(conn);
        }

        return listPokemon;
        
    }
    
    public List<String> listarFiltros(mdPokemon usu) throws SQLException{
        
        List<String> listFiltros = new ArrayList<String>();
        int contador=0;
        String operacionEjec=" ";
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        switch(usu.getOperacion()){
            case 1:
                operacionEjec=SQL_SELECTFiltro1;
                break;
            case 2:
                operacionEjec=SQL_SELECTFiltro2;
                break;
            case 3:
                operacionEjec=SQL_SELECTFiltro3;
                break;
            case 4:
                operacionEjec=SQL_SELECTFiltro4;
                break;
            case 5:
                operacionEjec=SQL_SELECTFiltro5;
                break;
            case 6:
                operacionEjec=SQL_SELECTFiltro6;
                break;
        }
           
        try {
            conn=ConexionMYSQL.getConnection();
            stmt=conn.prepareStatement(operacionEjec);
            rs=stmt.executeQuery();
            
            
            while(rs.next()){
                
                String valor=rs.getString(1);
                listFiltros.add(valor);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ConexionMYSQL.close(rs);
            ConexionMYSQL.close(stmt);
            ConexionMYSQL.close(conn);
        }

        return listFiltros;
        
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
            stmt.setString(2, datos.getPassword());
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
    
    public boolean validacionFAV(mdUsuario datos,int tbfav){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        boolean permiso=false;
        String ejecutar="";
        
        switch(tbfav){
            case 1:
                ejecutar=SQL_VALIDACIONFavorito;
                break;
            case 2:               
                ejecutar=SQL_VALIDACIONNoFav;
                break;
        }
              
           
        try {
            conn=ConexionMYSQL.getConnection();
            stmt=conn.prepareStatement(ejecutar);
            stmt.setString(1, datos.getUsername());
            stmt.setString(2, datos.getPokemon());
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
    
    public void insertarFav(mdUsuario usu, int op) {
        String Ejecutar="";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        switch (op){
            case 1:
                Ejecutar=SQL_INSERTFavoritos;
                break;
            case 2:
                Ejecutar=SQL_INSERTNoFavoritos;
                break;
            case 3:
               Ejecutar=SQL_DELETEFav; 
                break;
            case 4:
                Ejecutar=SQL_DELETENoFav;
                break;
        }
        
        try {
            conn = ConexionMYSQL.getConnection();                        
            stmt = conn.prepareStatement(Ejecutar);
            stmt.setString(1, usu.getUsername());
            stmt.setString(2, usu.getPokemon());           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionMYSQL.close(stmt);            
            ConexionMYSQL.close(conn);
        }
                        
    }
    
    public void insertarUsu(mdUsuario usu) {
        Connection conn = null;
        PreparedStatement stmt = null;              
        
        try {
            conn = ConexionMYSQL.getConnection();                        
            stmt = conn.prepareStatement(SQL_INSERTUSU);
            stmt.setString(1, usu.getUsername());
            stmt.setString(2, usu.getPassword());           
            stmt.setString(3, usu.getPassword());           
            stmt.setString(4, usu.getCorreo());           
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionMYSQL.close(stmt);            
            ConexionMYSQL.close(conn);
        }
                        
    }
}
