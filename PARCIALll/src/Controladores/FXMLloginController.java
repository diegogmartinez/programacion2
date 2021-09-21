/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Datos.ClsUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import modelos.*;

/**
 * FXML Controller class
 *
 * @author mjber
 */
public class FXMLloginController implements Initializable {

    @FXML
    private TextField textUsername;
    @FXML
    private TextField textPass;
    private TextField text1;
    private TextField text2;
    private Label label1;
    private Label label2;
    @FXML
    private Button buttonIngresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
   
    }    

    @FXML
    private void eventKey(KeyEvent event) {
         Object ev=event.getSource();
        if(ev.equals(textUsername)){
            if(event.getCharacter().equals(" ")){
                event.consume();
            }
        }else if(ev.equals(textPass)){
            if(event.getCharacter().equals(" ")){
                event.consume();
            }            
        }else if(ev.equals(text1)){
            if(event.getCharacter().equals(" ")){
                event.consume();
            }            
        }else if(ev.equals(text2)){
            if(event.getCharacter().equals(" ")){
                event.consume();
            }            
        }      
    }

    @FXML
    private void buttonAction(ActionEvent event) throws IOException {
        Object ev=event.getSource();
        if(!textUsername.getText().isEmpty() && !textPass.getText().isEmpty()){
            mdUsuario usu=new mdUsuario();
            ClsUsuario usuario= new ClsUsuario();
            usu.setContraseña(textPass.getText());
            usu.setUsername(textUsername.getText());
            
            boolean b=usuario.validacion(usu);   
            
            if(b==true){
                loadStage("/view/FXMLnomina.fxml",event);
            }else{
                System.out.println("error");
            }
                
                            
                                       
        }
    }

    
    public void loadStage(String url, Event event) throws IOException{
        
        Object eventSource=event.getSource();
        Node sourceasNode=(Node) eventSource;
        Scene oldScene=sourceasNode.getScene();
        Window window=oldScene.getWindow();
        Stage stage=(Stage) window;
        stage.hide();
        
        Parent root = FXMLLoader.load(getClass().getResource(url));
        Scene nomina=new Scene(root);
        stage.setScene(nomina);
        Stage newStage=new Stage();
        newStage.setScene(nomina);
        newStage.show();
        
        newStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
            }
        
        });
        
    }

}
