/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listapersonas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;


/**
 *
 * @author Alma Gómez
 */
public class Muestra extends JFrame implements ActionListener{
    JButton boton;
    JTextField nombre, app, apm, escuela;
    JLabel noms,ap,am,esc;
    Guarda baseGuarda=new Guarda();
    
    public Muestra (){
        setSize(450,450);
        setTitle("Formulario");
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Color.black);
        iniciaVentana();
        
    }
    public void iniciaVentana(){
        
        boton=new JButton("Guardar");
        nombre=new JTextField("Nombre");
        app=new JTextField("App");
        apm=new JTextField("Apm");
        escuela=new JTextField("Escuela");
        
        noms=new JLabel("Nombre");
        ap=new JLabel("App");
        am=new JLabel("Apm");
        esc=new JLabel("Escuela");
        
        boton.setBounds(75, 200, 250, 40);
        boton.setFont(new Font("Arial", Font.BOLD, 15));
        boton.addActionListener(this);
        add (boton);

        
        nombre.setBounds(100, 20, 250, 32);
        nombre.setBorder(new LineBorder(Color.black, 2));
        nombre.setFont(new Font("Arial", Font.BOLD, 20));
        add (nombre);
        
        app.setBounds(100, 55, 250, 32);
        app.setBorder(new LineBorder(Color.black, 2));
        app.setFont(new Font("Arial", Font.BOLD, 20));
        add (app);
        
        apm.setBounds(100, 90, 250, 32);
        apm.setBorder(new LineBorder(Color.black, 2));
        apm.setFont(new Font("Arial", Font.BOLD, 20));
        add (apm);
        
        escuela.setBounds(100, 125, 250, 32);
        escuela.setBorder(new LineBorder(Color.black, 2));
        escuela.setFont(new Font("Arial", Font.BOLD, 20));
        add (escuela);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton){
            try {
                baseGuarda.guardaBase(nombre.getText(), app.getText(), apm.getText(), escuela.getText());
            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Muestra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
