
package ClsPrincipal;

import ClsModelos.mdPokemon;
import ClsModelos.mdUsuario;
import ClsOperaciones.OperacionesUsu;
import Conexion.ConexionMYSQL;
import com.google.protobuf.Message;
import com.mysql.cj.Session;
import com.sun.jdi.connect.Transport;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Pokedex extends javax.swing.JFrame {

    String matriz[][]; 
    List<mdPokemon> listPokemon = new ArrayList<mdPokemon>();
    boolean inicioSesion=false;
    boolean inicioFav=true;
    String usuarioActual="";
    String idPokemonUsu="";
    BufferedImage buffer1=null;
    Image imagen1=null;
    int contador=0;          
    
    Statement st;
    ResultSet rs;
    Connection cn;
    
    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        
        Graphics2D  g2 = (Graphics2D) ImagenPokemon.getGraphics();
        
        g2.drawImage(buffer1,0,0,ImagenPokemon.getWidth(),
        ImagenPokemon.getHeight(),null);
        
        
    }
    
    public Pokedex() {
        initComponents();
        try {
            imagen1 = ImageIO.read(new File("C:\\Users\\mjber\\Documents\\VI SEMESTRE\\PROGRA II\\datos\\imagenes\\black-white.png"));
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        buffer1 = (BufferedImage) ImagenPokemon.createImage(
        ImagenPokemon.getWidth(),
        ImagenPokemon.getHeight()
        );
        
        Graphics2D g2 = buffer1.createGraphics();
        
        dibujaElPokemonQueEstaEnLaPosicion(30);
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String JDBC_URL="jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=CONVERT_TO_NULL"; 
            cn = DriverManager.getConnection(JDBC_URL,"root","mabe1417");
            st = cn.createStatement();
        
        
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
             ex.printStackTrace(System.out);
        }
    }
    
    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                ImagenPokemon.getWidth(),
                ImagenPokemon.getHeight()); 
        g2.drawImage(imagen1,
                0,  //posicion X inicial dentro del jpanel 
                0,  // posicion Y inicial dentro del jpanel
                ImagenPokemon.getWidth(), //ancho del jpanel
                ImagenPokemon.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null  //si no lo pones no va
                );
        repaint();
        
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImagenPokemon = new javax.swing.JPanel();
        buttonAnterior = new javax.swing.JButton();
        buttonSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResult = new javax.swing.JTable();
        labelNombre = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        textContraseña = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonIngresar = new javax.swing.JButton();
        buttonPokemon = new javax.swing.JButton();
        textBusPokemon = new javax.swing.JTextField();
        buttonMeGusta = new javax.swing.JButton();
        buttonNoMeGusta = new javax.swing.JButton();
        buttonFavoritos = new javax.swing.JButton();
        buttonNoFavoritos = new javax.swing.JButton();
        buttonRegistrarUsu = new javax.swing.JButton();
        buttonReporte = new javax.swing.JButton();
        comboboxFiltros = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POKEDEX");

        ImagenPokemon.setName("ImagenPokemon"); // NOI18N

        javax.swing.GroupLayout ImagenPokemonLayout = new javax.swing.GroupLayout(ImagenPokemon);
        ImagenPokemon.setLayout(ImagenPokemonLayout);
        ImagenPokemonLayout.setHorizontalGroup(
            ImagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ImagenPokemonLayout.setVerticalGroup(
            ImagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        buttonAnterior.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        buttonAnterior.setText("ANTERIOR");
        buttonAnterior.setName("buttonAnterior"); // NOI18N
        buttonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnteriorActionPerformed(evt);
            }
        });

        buttonSiguiente.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        buttonSiguiente.setText("SIGUIENTE");
        buttonSiguiente.setName("buttonSiguiente"); // NOI18N
        buttonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSiguienteActionPerformed(evt);
            }
        });

        tablaResult.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tablaResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "name", "forme_name", "forme_base_pokemon_id", "generation_id", "evolution_chain_id", "evolution_parent_pokemon_id", "evolution_method_id", "evolution_parameter", "height", "weight", "species", "color", "pokemon_shape_id", "habitat", "gender_rate", "capture_rate", "base_experience", "base_happiness", "gen1_internal_id", "is_baby", "has_gen4_fem_sprite", "has_gen4_fem_back_sprite"
            }
        ));
        tablaResult.setName("tablaResult"); // NOI18N
        jScrollPane1.setViewportView(tablaResult);

        labelNombre.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombre.setText("POKEMON");
        labelNombre.setName("labelNombre"); // NOI18N

        textUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textUsuario.setName("textUsuario"); // NOI18N

        textContraseña.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textContraseña.setName("textContraseña"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel2.setText("Usuario");

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña");

        buttonIngresar.setText("INICIO SESION");
        buttonIngresar.setName("buttonIngresar"); // NOI18N
        buttonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngresarActionPerformed(evt);
            }
        });

        buttonPokemon.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        buttonPokemon.setText("Buscar Pokemon");
        buttonPokemon.setName("buttonPokemon"); // NOI18N
        buttonPokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPokemonActionPerformed(evt);
            }
        });

        textBusPokemon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        textBusPokemon.setName("textBusPokemon"); // NOI18N

        buttonMeGusta.setText("Me Gusta");
        buttonMeGusta.setName("buttonMeGusta"); // NOI18N
        buttonMeGusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMeGustaActionPerformed(evt);
            }
        });

        buttonNoMeGusta.setText("No Me Gusta");
        buttonNoMeGusta.setName("buttonNoMeGusta"); // NOI18N
        buttonNoMeGusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoMeGustaActionPerformed(evt);
            }
        });

        buttonFavoritos.setText("Favoritos");
        buttonFavoritos.setName("buttonFavoritos"); // NOI18N
        buttonFavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFavoritosActionPerformed(evt);
            }
        });

        buttonNoFavoritos.setText("No Favoritos");
        buttonNoFavoritos.setName("buttonNoFavoritos"); // NOI18N
        buttonNoFavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNoFavoritosActionPerformed(evt);
            }
        });

        buttonRegistrarUsu.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        buttonRegistrarUsu.setText("Registrar Usuario");
        buttonRegistrarUsu.setName("buttonRegistrarUsu"); // NOI18N
        buttonRegistrarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarUsuActionPerformed(evt);
            }
        });

        buttonReporte.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        buttonReporte.setText("Reporte PDF");
        buttonReporte.setName("buttonReporte"); // NOI18N
        buttonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReporteActionPerformed(evt);
            }
        });

        comboboxFiltros.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        comboboxFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtros", "Color", "Generation", "Species", "Habitat", "Rate de Captura", "Experiencia Base", " " }));
        comboboxFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxFiltrosActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jButton1.setText("Cerrar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ImagenPokemon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(textUsuario))
                                .addGap(18, 18, 18)
                                .addComponent(buttonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buttonPokemon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                    .addComponent(comboboxFiltros, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(11, 11, 11)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textBusPokemon)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonFavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonNoFavoritos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(buttonMeGusta, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonNoMeGusta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(buttonRegistrarUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                            .addComponent(buttonReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(36, 36, 36)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(13, 13, 13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(textContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(buttonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonPokemon)
                            .addComponent(textBusPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonMeGusta)
                            .addComponent(buttonNoMeGusta))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonFavoritos)
                            .addComponent(buttonNoFavoritos)
                            .addComponent(comboboxFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ImagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonRegistrarUsu))
                            .addComponent(labelNombre))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonReporte)
                            .addComponent(buttonSiguiente)
                            .addComponent(buttonAnterior, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReporteActionPerformed
        try {
            Connection con = ConexionMYSQL.getConnection();
            
            JasperReport reporte = null;
            //Ruta del archivo jasper en reportes
            String path = "src\\main\\java\\Reportes\\pokedexreport.jasper";             
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            /*
            3 parametros
            reporte -> Object JasperReport
            null -> no necesitamos enviar parametros al reporte
            con -> conexión a la base de datos.
            */
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null,con);
            //Creamos la vista del reporte
            JasperViewer view = new JasperViewer(jprint, false);
            //Cierre para el reporte, y no se quede la tarea corriendo.
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            //Lo hacemos visible
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Pokedex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Pokedex.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_buttonReporteActionPerformed

    private void buttonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnteriorActionPerformed
        
        contador=contador-1;
        
        if(contador <=0){
            contador = 1;
        }
        
        dibujaElPokemonQueEstaEnLaPosicion(contador-1);
        String cuerito = "Select * from pokemon where id="+(contador);
        
        
        try {
            rs = st.executeQuery(cuerito);
            if (rs.next()){
                labelNombre.setText(rs.getString(2));
            } else {
                labelNombre.setText("No esta en el pokedex");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
        }
        
        
    }//GEN-LAST:event_buttonAnteriorActionPerformed

    private void buttonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSiguienteActionPerformed
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        
        String cuerito = "Select * from pokemon where id="+(contador+1);
        
        
        try {
            rs = st.executeQuery(cuerito);
            if (rs.next()){
                labelNombre.setText(rs.getString(2));
            } else {
                labelNombre.setText("No esta en el pokedex");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Clavo con sql");
        }
        
        contador++;
        if (contador >=649){
            contador = 649;
        }
    }//GEN-LAST:event_buttonSiguienteActionPerformed

    private void buttonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngresarActionPerformed
        
        mdUsuario usu=new mdUsuario();
        OperacionesUsu opUsu= new OperacionesUsu();           
        
        usu.setUsername(textUsuario.getText());
        usu.setPassword(textContraseña.getText());
        inicioSesion=opUsu.validacion(usu);
        
        if(inicioSesion==true){
            JOptionPane.showMessageDialog(rootPane, "Datos Correctos", "Inicio Sesion", JOptionPane.INFORMATION_MESSAGE);            
            usuarioActual=textUsuario.getText();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Datos Incorrectos", "Inicio Sesion", JOptionPane.ERROR_MESSAGE);            
        }
        
        textUsuario.setText("");
        textContraseña.setText("");
        
    }//GEN-LAST:event_buttonIngresarActionPerformed

    private void buttonPokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPokemonActionPerformed
        
        if(inicioSesion==true){
            
            inicioFav=true;
            
            try {
                mdPokemon pok=new mdPokemon();
                OperacionesUsu usu= new OperacionesUsu();
                pok.setEjecutar(textBusPokemon.getText());
                pok.setOperacion(1);                
                listPokemon=usu.listar(pok);                                
                mostrar();
                textBusPokemon.setText("");
                                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Aun no inicia sesion", "Mensaje", JOptionPane.ERROR_MESSAGE);                        
        }
        
        
        
    }//GEN-LAST:event_buttonPokemonActionPerformed

    private void comboboxFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxFiltrosActionPerformed
        
        if(inicioSesion==true){
            try {
            
                List<String> listFiltros = new ArrayList<String>();
                String [] cadenas;
                String opcion="";
                mdPokemon pok=new mdPokemon();
                OperacionesUsu usu= new OperacionesUsu();

                switch(comboboxFiltros.getSelectedIndex()){
                    case 0:
                        break;
                    case 1:
                        pok.setOperacion(1);
                        listFiltros=usu.listarFiltros(pok);
                        cadenas=new String[listFiltros.size()]; 
                        for (int i = 0; i < cadenas.length; i++) {
                            cadenas[i]=listFiltros.get(i);
                        }
                        opcion = (String) JOptionPane.showInputDialog(null,"Selecciona un color", "Colores",JOptionPane.QUESTION_MESSAGE,null,cadenas,cadenas[0]);                    
                        pok=new mdPokemon();
                        pok.setEjecutar(opcion);
                        pok.setOperacion(2);
                        listPokemon=usu.listar(pok);
                        mostrar();
                        break;
                    case 2:
                        pok.setOperacion(2);
                        listFiltros=usu.listarFiltros(pok);
                        cadenas=new String[listFiltros.size()]; 
                        for (int i = 0; i < cadenas.length; i++) {
                            cadenas[i]=listFiltros.get(i);
                        }
                        opcion= (String) JOptionPane.showInputDialog(null,"Selecciona una Generacion de Pokemon", "Generaciones",JOptionPane.QUESTION_MESSAGE,null,cadenas,cadenas[0]);                    
                        pok=new mdPokemon();
                        pok.setEjecutar(opcion);
                        pok.setOperacion(3);
                        listPokemon=usu.listar(pok);
                        mostrar();
                        break;
                    case 3:
                        pok.setOperacion(3);
                        listFiltros=usu.listarFiltros(pok);
                        cadenas=new String[listFiltros.size()]; 
                        for (int i = 0; i < cadenas.length; i++) {
                            cadenas[i]=listFiltros.get(i);
                        }
                        opcion= (String) JOptionPane.showInputDialog(null,"Selecciona una especie de Pokemon", "Especies",JOptionPane.QUESTION_MESSAGE,null,cadenas,cadenas[0]);                    
                        pok=new mdPokemon();
                        pok.setEjecutar(opcion);
                        pok.setOperacion(4);
                        listPokemon=usu.listar(pok);
                        mostrar();
                        break;
                    case 4:
                        pok.setOperacion(4);
                        listFiltros=usu.listarFiltros(pok);
                        cadenas=new String[listFiltros.size()]; 
                        for (int i = 0; i < cadenas.length; i++) {
                            cadenas[i]=listFiltros.get(i);
                        }
                        opcion= (String) JOptionPane.showInputDialog(null,"Selecciona un habitat de Pokemon", "Especies",JOptionPane.QUESTION_MESSAGE,null,cadenas,cadenas[0]);                    
                        pok=new mdPokemon();
                        pok.setEjecutar(opcion);
                        pok.setOperacion(5);
                        listPokemon=usu.listar(pok);
                        mostrar();
                        break;
                    case 5:
                        pok.setOperacion(5);
                        listFiltros=usu.listarFiltros(pok);
                        cadenas=new String[listFiltros.size()]; 
                        for (int i = 0; i < cadenas.length; i++) {
                            cadenas[i]=listFiltros.get(i);
                        }
                        opcion= (String) JOptionPane.showInputDialog(null,"Selecciona Pokemons por Rate de Captura", "Rate de Captura",JOptionPane.QUESTION_MESSAGE,null,cadenas,cadenas[0]);                    
                        pok=new mdPokemon();
                        pok.setEjecutar(opcion);
                        pok.setOperacion(6);
                        listPokemon=usu.listar(pok);
                        mostrar();
                        break;
                    case 6:
                        pok.setOperacion(6);
                        listFiltros=usu.listarFiltros(pok);
                        cadenas=new String[listFiltros.size()]; 
                        for (int i = 0; i < cadenas.length; i++) {
                            cadenas[i]=listFiltros.get(i);
                        }
                        opcion= (String) JOptionPane.showInputDialog(null,"Selecciona Pokemons por Experiencia Base", "Experiencia Base",JOptionPane.QUESTION_MESSAGE,null,cadenas,cadenas[0]);                    
                        pok=new mdPokemon();
                        pok.setEjecutar(opcion);
                        pok.setOperacion(7);
                        listPokemon=usu.listar(pok);
                        mostrar();
                        break;

                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Aun no inicia sesion", "Mensaje", JOptionPane.ERROR_MESSAGE);                                    
        }
        
        
        
    }//GEN-LAST:event_comboboxFiltrosActionPerformed

    private void buttonMeGustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMeGustaActionPerformed
        
        mdUsuario mdusu=new mdUsuario();
        OperacionesUsu usu=new OperacionesUsu();
        boolean revisionfav=false;
        boolean revisionNfav=false;
        
        //verifico que ya haya presionado el boton de buscar pokemon
        if(inicioFav==true){
            
            mdusu.setUsername(usuarioActual);
            mdusu.setPokemon(idPokemonUsu);        
            revisionfav=usu.validacionFAV(mdusu,1); //variable para ver si el pokemon ya está ingresado en mi tabla favoritos     
            revisionNfav=usu.validacionFAV(mdusu,2);//variable para ver si el pokemon ya está ingresado en mi tabla no favoritos                       
                                    
            if(revisionfav==true){
                //cuando el pokemon está en mi tabla FAVORITOS
                JOptionPane.showMessageDialog(rootPane, "Este pokemon ya está registrado en @Favoritos@", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                                                    
            }else if(revisionNfav==true){
                //cuando el pokemon está en mi tabla NO FAVORITOS                
                //variable para saber que boton seleccionó de mi cuadro de dialogo
                int opcion= JOptionPane.showConfirmDialog(rootPane, "Este pokemon ya está registrado en @No Favoritos@\n¿Deseas cambiar a @Favoritos@?", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                if(opcion==0){//cuando presiona SI
                    usu=new OperacionesUsu();
                    mdusu=new mdUsuario();
                    mdusu.setUsername(usuarioActual);
                    mdusu.setPokemon(idPokemonUsu);
                    usu.insertarFav(mdusu,1); 
                    usu.insertarFav(mdusu, 4);
                    JOptionPane.showMessageDialog(rootPane, "Pokemon se añadió a favoritos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                                            
                }else if(opcion==1){//cuando presiona NO
                    JOptionPane.showMessageDialog(rootPane, "Entendido, cancelamos operación", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                                                    
                }else{//cuando presiona CANCELAR
                    
                }  
                
            }else if((revisionfav==false)&&(revisionNfav==false)){
                usu=new OperacionesUsu();
                mdusu=new mdUsuario();
                mdusu.setUsername(usuarioActual);
                mdusu.setPokemon(idPokemonUsu);
                usu.insertarFav(mdusu,1);
                JOptionPane.showMessageDialog(rootPane, "Pokemon se añadió a favoritos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                                    
            }
            
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Aun no inicia sesion", "Mensaje", JOptionPane.ERROR_MESSAGE);                        

        }
        
        
        
    }//GEN-LAST:event_buttonMeGustaActionPerformed

    private void buttonNoMeGustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoMeGustaActionPerformed
        
        mdUsuario mdusu=new mdUsuario();
        OperacionesUsu usu=new OperacionesUsu();
        boolean revisionfav=false;
        boolean revisionNfav=false;
        
        //verifico que ya haya presionado el boton de buscar pokemon
        if(inicioFav==true){
            
            mdusu.setUsername(usuarioActual);
            mdusu.setPokemon(idPokemonUsu);        
            revisionfav=usu.validacionFAV(mdusu,1); //variable para ver si el pokemon ya está ingresado en mi tabla favoritos     
            revisionNfav=usu.validacionFAV(mdusu,2);//variable para ver si el pokemon ya está ingresado en mi tabla no favoritos                       
                                    
            if(revisionNfav==true){
                //cuando el pokemon está en mi tabla FAVORITOS
                JOptionPane.showMessageDialog(rootPane, "Este pokemon ya está registrado en @No Favoritos@", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                                                    
            }else if(revisionfav==true){
                //cuando el pokemon está en mi tabla NO FAVORITOS                
                //variable para saber que boton seleccionó de mi cuadro de dialogo
                int opcion= JOptionPane.showConfirmDialog(rootPane, "Este pokemon ya está registrado en @Favoritos@\n¿Deseas cambiar a @No Favoritos@?", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                if(opcion==0){//cuando presiona SI
                    usu=new OperacionesUsu();
                    mdusu=new mdUsuario();
                    mdusu.setUsername(usuarioActual);
                    mdusu.setPokemon(idPokemonUsu);
                    usu.insertarFav(mdusu,2);
                    usu.insertarFav(mdusu, 3);
                    JOptionPane.showMessageDialog(rootPane, "Pokemon se añadió a  No Favoritos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                                            
                }else if(opcion==1){//cuando presiona NO
                    JOptionPane.showMessageDialog(rootPane, "Entendido, cancelamos operación", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                                                    
                }else{//cuando presiona CANCELAR
                    
                }  
                
            }else if((revisionfav==false)&&(revisionNfav==false)){
                usu=new OperacionesUsu();
                mdusu=new mdUsuario();
                mdusu.setUsername(usuarioActual);
                mdusu.setPokemon(idPokemonUsu);
                usu.insertarFav(mdusu,2);
                JOptionPane.showMessageDialog(rootPane, "Pokemon se añadió a No Favoritos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                                    
            }
            
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Aun no inicia sesion", "Mensaje", JOptionPane.ERROR_MESSAGE);                        
        }                              
        
    }//GEN-LAST:event_buttonNoMeGustaActionPerformed

    private void buttonFavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFavoritosActionPerformed
        
        if(inicioSesion==true){
            
            try {
                OperacionesUsu usu=new OperacionesUsu();
                mdPokemon pok=new mdPokemon();
                pok.setEjecutar(usuarioActual);
                pok.setOperacion(8);
                listPokemon=usu.listar(pok);
                mostrar();
            } catch (SQLException ex) {
                Logger.getLogger(Pokedex.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Aun no inicia sesion", "Mensaje", JOptionPane.ERROR_MESSAGE);                                    
        }
        
        
    }//GEN-LAST:event_buttonFavoritosActionPerformed

    private void buttonNoFavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNoFavoritosActionPerformed
        
        if(inicioSesion==true){
            
            try {
                OperacionesUsu usu=new OperacionesUsu();
                mdPokemon pok=new mdPokemon();
                pok.setEjecutar(usuarioActual);
                pok.setOperacion(9);
                listPokemon=usu.listar(pok);
                mostrar();
            } catch (SQLException ex) {
                Logger.getLogger(Pokedex.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Aun no inicia sesion", "Mensaje", JOptionPane.ERROR_MESSAGE);                                    
        }
                
    }//GEN-LAST:event_buttonNoFavoritosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonRegistrarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarUsuActionPerformed
        if(inicioSesion==false){
            mdUsuario usu=new mdUsuario();
            OperacionesUsu op= new OperacionesUsu();
            usu.setUsername(JOptionPane.showInputDialog(null,new JLabel("Ingrese nombre de usuario"),"REGISTRO",JOptionPane.INFORMATION_MESSAGE));
            if(usu.getUsername()!=null){
                usu.setPassword(JOptionPane.showInputDialog(null,new JLabel("Ingrese contraseña"),"REGISTRO",JOptionPane.INFORMATION_MESSAGE));
                if(usu.getPassword()!=null){
                    usu.setCorreo(JOptionPane.showInputDialog(null,new JLabel("Ingrese correo"),"REGISTRO",JOptionPane.INFORMATION_MESSAGE));
                    if(usu.getCorreo()!=null){
                        op.insertarUsu(usu);
                        JOptionPane.showMessageDialog(rootPane, "Usuario Registrado", "Mensaje", JOptionPane.ERROR_MESSAGE);                                    
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Operacion Candelada", "Mensaje", JOptionPane.ERROR_MESSAGE);                                    

                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Operacion Candelada", "Mensaje", JOptionPane.ERROR_MESSAGE);                                    

                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Operacion Candelada", "Mensaje", JOptionPane.ERROR_MESSAGE);                                                    
            }
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Tiene sesión iniciada", "Mensaje", JOptionPane.ERROR_MESSAGE);                                    
        }
    }//GEN-LAST:event_buttonRegistrarUsuActionPerformed

    public void enviarCorreo(mdUsuario user) throws AddressException, MessagingException{
        
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            
            Session session = Session.getDefaultInstance(props);
            String correoRemitente = "sistemadeventasgt@gmail.com";
            String passwordRemitente = "prueba123";
            
            String correoReceptor = user.getCorreo();
            String asunto = "REGISTRO ÉXITOSO.";
            String mensaje = "Hola";
            
            
            
            MimeMessage message = new MimeMessage((MimeMessage) session);
            message.setFrom(new InternetAddress(correoRemitente));
            
            
            //Receptor normal
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje);
            
            try ( //Lo enviamos
                Transport t = session.getTransport("smtp")) {
                t.connect(correoRemitente,passwordRemitente);
                t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                System.out.println("Correo electronico enviado al : " + user.getCorreo());
            }
            
        } catch (AddressException ex) {
            ex.printStackTrace(System.out);
        } catch (MessagingException ex) {
            ex.printStackTrace(System.out);
        }
       
    }
    
    public void mostrar(){
        
        matriz=new String[listPokemon.size()][23];
        
        for (int i = 0; i < listPokemon.size(); i++) {

            idPokemonUsu=matriz[i][0]=listPokemon.get(i).getId();
            matriz[i][1]=listPokemon.get(i).getName();
            matriz[i][2]=listPokemon.get(i).getForme_name();
            matriz[i][3]=listPokemon.get(i).getForme_base_pokemon_id();
            matriz[i][4]=listPokemon.get(i).getGeneration_id();
            matriz[i][5]=listPokemon.get(i).getEvolution_chain_id();
            matriz[i][6]=listPokemon.get(i).getEvolution_parent_pokemon_id();
            matriz[i][7]=listPokemon.get(i).getEvolution_method_id();
            matriz[i][8]=listPokemon.get(i).getEvolution_parameter();
            matriz[i][9]=listPokemon.get(i).getHeight();
            matriz[i][10]=listPokemon.get(i).getWeight();
            matriz[i][11]=listPokemon.get(i).getSpecies();
            matriz[i][12]=listPokemon.get(i).getColor();
            matriz[i][13]=listPokemon.get(i).getPokemon_shape_id();
            matriz[i][14]=listPokemon.get(i).getHabitat();
            matriz[i][15]=listPokemon.get(i).getGender_rate();
            matriz[i][16]=listPokemon.get(i).getCapture_rate();
            matriz[i][17]=listPokemon.get(i).getBase_experience();
            matriz[i][18]=listPokemon.get(i).getBase_happiness();
            matriz[i][19]=listPokemon.get(i).getGen1_internal_id();
            matriz[i][20]=listPokemon.get(i).getIs_baby();
            matriz[i][21]=listPokemon.get(i).getHas_gen4_fem_sprite();
            matriz[i][22]=listPokemon.get(i).getHas_gen4_fem_back_sprite();

        }

        tablaResult.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
                "id", "name", "forme_name", "forme_base_pokemon_id", "generation_id", "evolution_chain_id", "evolution_parent_pokemon_id", "evolution_method_id", "evolution_parameter", "height", "weight", "species", "color", "pokemon_shape_id", "habitat", "gender_rate", "capture_rate", "base_experience", "base_happiness", "gen1_internal_id", "is_baby", "has_gen4_fem_sprite", "has_gen4_fem_back_sprite"
            }
        ));

    }

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ImagenPokemon;
    private javax.swing.JButton buttonAnterior;
    private javax.swing.JButton buttonFavoritos;
    private javax.swing.JButton buttonIngresar;
    private javax.swing.JButton buttonMeGusta;
    private javax.swing.JButton buttonNoFavoritos;
    private javax.swing.JButton buttonNoMeGusta;
    private javax.swing.JButton buttonPokemon;
    private javax.swing.JButton buttonRegistrarUsu;
    private javax.swing.JButton buttonReporte;
    private javax.swing.JButton buttonSiguiente;
    private javax.swing.JComboBox<String> comboboxFiltros;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JTable tablaResult;
    private javax.swing.JTextField textBusPokemon;
    private javax.swing.JTextField textContraseña;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}
