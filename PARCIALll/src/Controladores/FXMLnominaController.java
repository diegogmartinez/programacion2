/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Datos.ClsUsuario;
import Datos.ClsVendedor;
import Nomina.ClsOperaciones;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import modelos.mdUsuario;
import modelos.mdVendedor;


/**
 * FXML Controller class
 *
 * @author mjber
 */
public class FXMLnominaController implements Initializable {


    @FXML
    private Button buttonVentas;
    @FXML
    private TextField textCantidadBus;
    @FXML
    private Button buttonCantidadBus;
    private TextField textId;
    @FXML
    private Button buttonModificaciones;
    @FXML
    private ComboBox<String> ComboboxVentas;
    @FXML
    private Label labelVentas;
    @FXML
    private TextField textMes;
    @FXML
    private ComboBox<String> comboboxMod;
    @FXML
    private Label labelmod1;
    @FXML
    private TextField textmod1;
    @FXML
    private Label labelmod2;
    @FXML
    private TextField textmod2;
    @FXML
    private TextField respuestaventa;
    @FXML
    private TextField respuestabuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboboxVentas.getItems().add("Venta Máxima Mes");
        ComboboxVentas.getItems().add("Venta Mínima Mes");
        ComboboxVentas.getItems().add("Venta Máxima Total");
        comboboxMod.getItems().add("Editar Nombre");
        comboboxMod.getItems().add("Eliminar Dato");
        
    }    

    @FXML
    private void eventKeyNum(KeyEvent event) {
        
        Object evt=event.getSource();
        
        
         if(evt.equals(textCantidadBus)){
            if(!Character.isDigit(event.getCharacter().charAt(0))){
                event.consume();;
            }
        }else if(evt.equals(textId)){
            if(!Character.isDigit(event.getCharacter().charAt(0))){
                event.consume();;
            }
        }else if(evt.equals(textMes)){
            if(!Character.isLetter(event.getCharacter().charAt(0))){
                event.consume();;
            }
        }
    }



    @FXML
    private void ButtonVentas(ActionEvent event) {
        
        String res="";
        respuestaventa.clear();
        
        if(ComboboxVentas.getSelectionModel().getSelectedItem().toString().equals("Venta Máxima Mes")){
            
            if(!textMes.getText().isEmpty()&& (textMes.getText().equalsIgnoreCase("enero"))){
                ClsOperaciones obj= new ClsOperaciones();
                res=obj.numMaxMes(1);
                                                                                
            }else if(!textMes.getText().isEmpty()&& (textMes.getText().equalsIgnoreCase("febrero"))){
                ClsOperaciones obj= new ClsOperaciones();
                res=obj.numMaxMes(2);
                                                                                                
            }else  if(!textMes.getText().isEmpty()&& (textMes.getText().equalsIgnoreCase("marzo"))){
                ClsOperaciones obj= new ClsOperaciones();
                res=obj.numMaxMes(3);
                                                                                                
            }                   
            
        }else if(ComboboxVentas.getSelectionModel().getSelectedItem().toString().equals("Venta Mínima Mes")){
            
            if(!textMes.getText().isEmpty()&& (textMes.getText().equalsIgnoreCase("enero"))){
                ClsOperaciones obj= new ClsOperaciones();
                res=obj.numMinMes(1);
                                                                                
            }else if(!textMes.getText().isEmpty()&& (textMes.getText().equalsIgnoreCase("febrero"))){
                ClsOperaciones obj= new ClsOperaciones();
                res=obj.numMinMes(2);
                                                                                                
            }else  if(!textMes.getText().isEmpty()&& (textMes.getText().equalsIgnoreCase("marzo"))){
                ClsOperaciones obj= new ClsOperaciones();
                res=obj.numMinMes(3);
                                                                                                
            }                   
            
        }else if(ComboboxVentas.getSelectionModel().getSelectedItem().toString().equals("Venta Máxima Total")){
            
            ClsOperaciones obj= new ClsOperaciones();
            res=obj.numMaxTotal();
            
        }
        
        textMes.clear();
        labelVentas.setText(" ");
        respuestaventa.setText(res);
        
   
    }

    @FXML
    private void ButtonCantidadBuscar(ActionEvent event) {
     
        respuestabuscar.clear();
        if(!textCantidadBus.getText().isEmpty()){
            
            
            ClsOperaciones obj=new ClsOperaciones();
            List<String> list =obj.buscar(Double.valueOf(textCantidadBus.getText()));
            for(String e: list){
                respuestabuscar.setText(""+e);
            }            
            
        }        
        
        textCantidadBus.clear();
    }

    @FXML
    private void ButtonModificar(ActionEvent event) {
        
        
        if(comboboxMod.getSelectionModel().getSelectedItem().toString().equals("Editar Nombre")){
            
            if(!textmod1.getText().isEmpty()&& !textmod2.getText().isEmpty()){     
                mdVendedor vende=new mdVendedor();
                ClsVendedor obj=new ClsVendedor();    
                vende.setNombre(textmod2.getText());
                vende.setId(Integer.valueOf(textmod1.getText()));
                obj.modNOM(vende);
                                                                                
            }                 
            
        }else if(comboboxMod.getSelectionModel().getSelectedItem().toString().equals("Eliminar Dato")){
            
            if(!textmod1.getText().isEmpty()){
                mdVendedor vende=new mdVendedor();
                ClsVendedor obj=new ClsVendedor();                
                obj.borrar(Integer.valueOf(textmod1.getText()));
                                                                                
            }                 
            
        }
        
        textmod1.clear();
        textmod2.clear();
    }

    @FXML
    private void ComboBoxVentas(ActionEvent event) {
        
        if(ComboboxVentas.getSelectionModel().getSelectedItem().toString().equals("Venta Máxima Mes")){                       
            labelVentas.setText("¿Qúe mes desea consultar?");
            textMes.setEditable(true);
        }else if(ComboboxVentas.getSelectionModel().getSelectedItem().toString().equals("Venta Mínima Mes")){                       
            labelVentas.setText("¿Qúe mes desea consultar?");
            textMes.setEditable(true);
        }else if(ComboboxVentas.getSelectionModel().getSelectedItem().toString().equals("Venta Máxima Total")){                       
            labelVentas.setText(" ");
            textMes.setEditable(false);
        }
        
    }

    @FXML
    private void ComboboxMod(ActionEvent event) {
        
        if(comboboxMod.getSelectionModel().getSelectedItem().toString().equals("Editar Nombre")){                       
            labelmod1.setText("Ingrese el Id");
            labelmod2.setText("Ingrese el nuevo nombre");
            textmod1.setEditable(true);
            textmod2.setEditable(true);
        }else if(comboboxMod.getSelectionModel().getSelectedItem().toString().equals("Eliminar Dato")){                       
            labelmod1.setText("Ingrese el Id");
            labelmod2.setText(" ");
            textmod1.setEditable(true);
            textmod2.setEditable(false);
        }
        
    }
        
    
}
