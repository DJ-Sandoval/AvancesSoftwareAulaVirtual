package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.InterCienciasNaturales;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class CienciasController implements ActionListener {
    private InterCienciasNaturales ciencia;
    private boolean isPaused = false;
    private long clipTimePosition;
    private Clip audioClip;
    

    public CienciasController(InterCienciasNaturales ciencia) {
        this.ciencia = ciencia;
        this.ciencia.btnCienciasNaturales.addActionListener(this);
        this.ciencia.btnHistoriaCienciasNaturales.addActionListener(this);
        this.ciencia.btnPausarCienciasNaturales.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ciencia.btnCienciasNaturales) {
            playSound("/Sonidos/CienciasNaturales.wav");
         } else if (e.getSource() == ciencia.btnHistoriaCienciasNaturales) {
             playSound("/Sonidos/HistoriaCienciasNaturales.wav");
         }
       
       else if (e.getSource() == ciencia.btnPausarCienciasNaturales) {
             // Pausar o reanudar el audio
             if (audioClip != null) {
                 if (isPaused) {
                     ciencia.btnPausarCienciasNaturales.setText("PAUSAR");
                     audioClip.setMicrosecondPosition(clipTimePosition);
                     audioClip.start();
                     isPaused = false;
                 } else {
                     ciencia.btnPausarCienciasNaturales.setText("REANUDAR");
                     clipTimePosition = audioClip.getMicrosecondPosition();
                     audioClip.stop();
                     
                     isPaused = true;
                 }
             }
       } else if (e.getSource() == ciencia.btnPausarCienciasNaturales) {
            // Pausar o reanudar el audio
             if (audioClip != null) {
                 if (isPaused) {
                     audioClip.setMicrosecondPosition(clipTimePosition);
                     audioClip.start();
                     isPaused = false;
                 } else {
                     clipTimePosition = audioClip.getMicrosecondPosition();
                     audioClip.stop();
                     isPaused = true;
                 }
             }
       }
    }

    private void playSound(String filePath) {
        try {
            File audioFile = new File(getClass().getResource(filePath).getFile());
            AudioInputStream audioStream = null;
            try {
                audioStream = AudioSystem.getAudioInputStream(audioFile);
            } catch (IOException ex) {
                Logger.getLogger(CienciasController.class.getName()).log(Level.SEVERE, null, ex);
            }
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
