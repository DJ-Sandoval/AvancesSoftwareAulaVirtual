package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Modelo.Alumno;
import Modelo.AlumnoDao;
import Vista.frmCrearAlumno;

public class AlumnosController implements ActionListener, KeyListener {
   private Alumno al;
   private AlumnoDao alDao;
   private frmCrearAlumno vista;

// Crear Constructor para inicializar la instancia de las clases   
public AlumnosController(Alumno al, AlumnoDao alDao, frmCrearAlumno vista) {
    this.al = al;
    this.alDao = alDao;
    this.vista = vista;
    this.vista.btnSaveAlumno.addActionListener(this);
    this.vista.btnCancelar.addActionListener(this);
    this.vista.txtNombre.addKeyListener(this);
    
   
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.btnSaveAlumno) {
        // Verificar campos vacios
        if (vista.txtNombre.getText().equals("")
        || vista.txtApellido.getText().equals("")
        || vista.txtUsuario.getText().equals("")
        || String.valueOf(vista.txtClave.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "NO DEJES ESPACIOS EN BLANCO", "Campo vacio", JOptionPane.PLAIN_MESSAGE);
        } else {
            al.setNombre(vista.txtNombre.getText());
            al.setApellido(vista.txtApellido.getText());
            al.setUsuario(vista.txtUsuario.getText());
            al.setClave(String.valueOf(vista.txtClave.getPassword()));
            al.setPais(vista.cbxPais.getSelectedItem().toString());
            al.setSexo(vista.cbxSexo.getSelectedItem().toString());
            if (alDao.registrar(al)) {
                // Si todo se cumple se limpian los campos y se registra
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "Registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar","Error de registro", JOptionPane.ERROR_MESSAGE);
            }
        }
       } else if (e.getSource() == vista.btnCancelar) {
            limpiarCampos();
       }
}
    // Métodos alternos
    public void limpiarCampos() {
        vista.txtNombre.setText("");
        vista.txtApellido.setText("");
        vista.txtUsuario.setText("");
        vista.txtClave.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
   }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            vista.txtApellido.requestFocus();
        } 
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


   

   
}
