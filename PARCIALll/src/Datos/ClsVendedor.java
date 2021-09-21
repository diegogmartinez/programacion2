
package Datos;

import BaseDatos.ConexionMYSQL;
import java.sql.*;
import java.util.*;
import modelos.*;


public class ClsVendedor {
    
    private static final String SQL_SELECT="SELECT * FROM bd_nominacomisiones.tb_comisiones";
    private static final String SQL_INSERT="insert into tb_comisiones (nombre,enero,febrero,marzo,total,promedio) values (?,?,?,?,?,?)";
    private static final String SQL_UPDATENom="UPDATE tb_comisiones set nombre=? where id=?";
    private static final String SQL_UPDATECant="UPDATE tb_comisiones set ?=? where id=?";    ;
    private static final String SQL_DELETE="delete FROM tb_comisiones WHERE id=?";
        
    
    public List<mdVendedor> listar()  {
        
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        mdVendedor vende=null;       
        List<mdVendedor> vendedor = new ArrayList<mdVendedor>();
        
        
           
        try {
            conn=ConexionMYSQL.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            
            while(rs.next()){
                int codigo=rs.getInt(1);
                String nombre=rs.getString(2);
                double enero=rs.getDouble(3);
                double febrero=rs.getDouble(4);
                double marzo=rs.getDouble(5);
                double total=rs.getDouble(6);
                double promedio=rs.getDouble(7);
                vende= new mdVendedor();
                vende.setId(codigo);
                vende.setNombre(nombre);
                vende.setEnero(enero);
                vende.setFebrero(febrero);
                vende.setMarzo(marzo);
                vende.setTotal(total);
                vende.setPromedio(promedio);
                vendedor.add(vende);
                                               
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ConexionMYSQL.close(rs);
            ConexionMYSQL.close(stmt);
            ConexionMYSQL.close(conn);
        }

        return vendedor;
    }
    
    
   public int escribir(mdVendedor vend) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows=0;
        
        try {
            conn = ConexionMYSQL.getConnection();                        
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vend.getNombre());
            stmt.setDouble(2, vend.getEnero());
            stmt.setDouble(3, vend.getFebrero());
            stmt.setDouble(4, vend.getMarzo());
            stmt.setDouble(5, vend.getTotal());
            stmt.setDouble(6, vend.getPromedio());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);   
                                                                       
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionMYSQL.close(stmt);            
            ConexionMYSQL.close(conn);
        }
        
        return rows;
    }
   
   
    public void modNOM(mdVendedor datos){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexionMYSQL.getConnection();                        
            stmt = conn.prepareStatement(SQL_UPDATENom);
            stmt.setString(1, datos.getNombre());            
            stmt.setInt(2, datos.getId());            

            System.out.println("ejecutando query:" + SQL_UPDATENom);
                                                                       

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionMYSQL.close(stmt);            
            ConexionMYSQL.close(conn);
        }

        
    }

    public void modCant(int Id, double newcantidad,int mesopc){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        String mes="";

        try {
            conn = ConexionMYSQL.getConnection();                        
            if (mesopc==1){
                mes="enero";
            }else if(mesopc==2){
                mes="febrero";
            }else if(mesopc==4){
                mes="marzo";
            }else{
                System.out.println("Error opcion");
            }
            stmt = conn.prepareStatement(SQL_UPDATECant);
            stmt.setString(1, mes);            
            stmt.setDouble(2, newcantidad);            
            stmt.setInt(3, Id);

            System.out.println("ejecutando query:" + SQL_UPDATECant);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);                                                             

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            ConexionMYSQL.close(stmt);            
            ConexionMYSQL.close(conn);
        }
    }
    
    public List<String> buscar(double cant){
        
        Connection conn=null;
        PreparedStatement stmt1=null;
        PreparedStatement stmt2=null;
        PreparedStatement stmt3=null;
        ResultSet rs1=null;
        ResultSet rs2=null;
        ResultSet rs3=null;
        mdVendedor vende=null;       
        List<String> list = new ArrayList<String>();
        
        
        
           
        try {
            conn=ConexionMYSQL.getConnection();
            stmt1=conn.prepareStatement("SELECT nombre, enero from tb_comisiones WHERE enero=?");
            stmt2=conn.prepareStatement("SELECT nombre, febrero from tb_comisiones WHERE febrero=?");
            stmt3=conn.prepareStatement("SELECT nombre, marzo from tb_comisiones WHERE marzo=?");
            stmt1.setDouble(1,cant);
            stmt2.setDouble(1,cant);
            stmt3.setDouble(1,cant);
            rs1=stmt1.executeQuery();
            rs2=stmt2.executeQuery();
            rs3=stmt3.executeQuery();
            
            
            while(rs1.next()){
                String nombre=rs1.getString(1);
                double enero=rs1.getDouble(2);
                list.add(" vendió Q."+enero+" en el mes de enero");
                                               
            }           
            while(rs2.next()){
                String nombre=rs2.getString(1);
                double febrero=rs2.getDouble(2);
                list.add(" vendió Q."+febrero+" en el mes de enero");
                                               
            }
            while(rs3.next()){
                String nombre=rs3.getString(1);
                double marzo=rs3.getDouble(2);
                list.add(" vendió Q."+marzo+" en el mes de enero");
                                               
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            ConexionMYSQL.close(rs1);
            ConexionMYSQL.close(stmt1);
            ConexionMYSQL.close(rs2);
            ConexionMYSQL.close(stmt2);
            ConexionMYSQL.close(rs3);
            ConexionMYSQL.close(stmt3);
            ConexionMYSQL.close(conn);
        }

     return list;
     
    }


    public int borrar(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = ConexionMYSQL.getConnection();                        
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);            

            System.out.println("ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
            
            //Reordenar-restablecer la clave principal de incremento automático
            stmt.execute("ALTER TABLE bd_nominacomisiones.tb_comisiones DROP id;");
            stmt.execute("ALTER TABLE bd_nominacomisiones.tb_comisiones AUTO_INCREMENT = 1;");
            stmt.execute("ALTER TABLE bd_nominacomisiones.tb_comisiones ADD id bigint UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;");
           
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
