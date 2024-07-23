package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Modelo.Alumno;
import Modelo.AlumnoDao;
import Vista.Aplicacion;
import Vista.frmLogin;
import raven.alerts.MessageAlerts;


public class LoginController implements ActionListener, KeyListener {
    private Alumno al;
    private AlumnoDao alDao;
    private frmLogin vista;

    // Constructor para inicializar las clases
    public LoginController(Alumno al, AlumnoDao alDao, frmLogin vista) {
        this.al = al;
        this.alDao = alDao;
        this.vista = vista;
        this.vista.txtUsuario.addKeyListener(this);
        this.vista.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnLogin) {
            if (vista.txtUsuario.getText().equals("") || String.valueOf(vista.txtClave.getPassword()).equals("")) {
                MessageAlerts.getInstance().showMessage("NO DEJES ESPACIOS EN BLANCO", "Campo vació", MessageAlerts.MessageType.WARNING);
            } else {
                String usuario = vista.txtUsuario.getText();
                String clave = String.valueOf(vista.txtClave.getPassword());
                al = alDao.login(usuario, clave);
                if (al.getUsuario() != null) {
                    MessageAlerts.getInstance().showMessage("Hola bienvenido", "Éxito", MessageAlerts.MessageType.SUCCESS);

                    Aplicacion app = new Aplicacion(al);
                    app.setVisible(true);
                    vista.dispose();
                } else {
                    MessageAlerts.getInstance().showMessage("Lo sentimos no se pudo iniciar sesión", "Error", MessageAlerts.MessageType.ERROR);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            vista.txtClave.requestFocus();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
     }

   

    
}
