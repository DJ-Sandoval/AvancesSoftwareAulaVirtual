package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Modelo.Alumno;
import Modelo.AlumnoDao;
import Vista.Aplicacion;

public class PanelPerfilController implements ActionListener {
    
    private Alumno al;
    private AlumnoDao alDao;
    private Aplicacion vista;
   
    // Constructor con la instacia de las clases
    public PanelPerfilController(Alumno al, AlumnoDao alDao, Aplicacion vista) {
        this.al = al;
        this.alDao = alDao;
        this.vista = vista;
        this.vista.btnEditarDatos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnEditarDatos) {
            
        } 
            
    }

   

    
    
}
