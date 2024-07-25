package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.Aplicacion;
 
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
import javax.swing.JOptionPane;

public class CienciasController implements ActionListener, MouseListener {
    private Aplicacion ciencia;
    private boolean isPaused = false;
    private long clipTimePosition;
    private Clip audioClip;
    

    public CienciasController(Aplicacion ciencia) {
        this.ciencia = ciencia;
        this.ciencia.btnCienciasNaturales.addActionListener(this);
        this.ciencia.btnHistoriaCienciasNaturales.addActionListener(this);
        this.ciencia.btnPausarCienciasNaturales.addActionListener(this);
        this.ciencia.btnImportanciaCiencias.addActionListener(this);
        this.ciencia.btnBiologia.addActionListener(this);
        this.ciencia.btnQuimica.addActionListener(this);
        this.ciencia.btnFisica.addActionListener(this);
        this.ciencia.btnGeologia.addActionListener(this);
        this.ciencia.btnAstronomia.addActionListener(this);
        this.ciencia.btnMicrobiologia.addActionListener(this);
        this.ciencia.btnQuimicaOrganica.addActionListener(this);
        this.ciencia.btnFisicaCuantica.addActionListener(this);
        this.ciencia.btnVulcanologia.addActionListener(this);
        this.ciencia.btnMedicina.addActionListener(this);
        this.ciencia.btnTecnologia.addActionListener(this);
        this.ciencia.btnIndustria.addActionListener(this);
        this.ciencia.btnMedioAmbiente.addActionListener(this);
        this.ciencia.btnRelacionCiencias.addActionListener(this);
        // Mouse
        this.ciencia.lblCienciasNaturales.addMouseListener(this);
        this.ciencia.lblHistoriaCienciasNaturales.addMouseListener(this);
        this.ciencia.lblImportanciaCiencias.addMouseListener(this);
        this.ciencia.lblBiologia.addMouseListener(this);
        this.ciencia.lblQuimica.addMouseListener(this);
        this.ciencia.lblFisica.addMouseListener(this);
        this.ciencia.lblGeologia.addMouseListener(this);
        this.ciencia.lblAstronomia.addMouseListener(this);
        this.ciencia.lblMicrobiologia.addMouseListener(this);
        this.ciencia.lblQuimicaOr.addMouseListener(this);
        this.ciencia.lblFisicaCuan.addMouseListener(this);
        this.ciencia.lblVulcanologia.addMouseListener(this);
        this.ciencia.lblMedicina.addMouseListener(this);
        this.ciencia.lblTecnologia.addMouseListener(this);
        this.ciencia.lblMedioAmbiente.addMouseListener(this);
        this.ciencia.lblIndustria.addMouseListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ciencia.btnCienciasNaturales) {
            playSound("/Sonidos/CienciasNaturales.wav");
         } else if (e.getSource() == ciencia.btnHistoriaCienciasNaturales) {
             playSound("/Sonidos/HistoriaCienciasNaturales.wav");
         } else if (e.getSource() == ciencia.btnImportanciaCiencias) {
            playSound("/Sonidos/Importancia.wav");
         } else if (e.getSource() == ciencia.btnRelacionCiencias) {
            playSound("/Sonidos/RelacionCiencias.wav");
         } else if (e.getSource() == ciencia.btnBiologia) {
            playSound("/Sonidos/Biologia.wav");
         } else if (e.getSource() == ciencia.btnQuimica) {
            playSound("/Sonidos/Quimica.wav");
         } else if (e.getSource() == ciencia.btnFisica) {
            playSound("/Sonidos/Fisica.wav");
         } else if (e.getSource() == ciencia.btnGeologia) {
            playSound("/Sonidos/Geologia.wav");
         } else if (e.getSource() == ciencia.btnAstronomia) {
            playSound("/Sonidos/Astronomia.wav");
         } else if (e.getSource() == ciencia.btnMicrobiologia) {
            playSound("/Sonidos/Microbiologia.wav");
         } else if (e.getSource() == ciencia.btnQuimicaOrganica) {
            playSound("/Sonidos/QuimicaOrganica.wav");
         } else if (e.getSource() == ciencia.btnFisicaCuantica) {
            playSound("/Sonidos/FisicaCuantica.wav");
         } else if (e.getSource() == ciencia.btnVulcanologia) {
            playSound("/Sonidos/Vulcanologia.wav");
         } else if (e.getSource() == ciencia.btnMedicina) {
            playSound("/Sonidos/Medicina.wav");
         } else if (e.getSource() == ciencia.btnTecnologia) {
            playSound("/Sonidos/Tecnologia.wav");
         } else if (e.getSource() == ciencia.btnMedioAmbiente) {
            playSound("/Sonidos/MedioAmbiente.wav");
         } else if (e.getSource() == ciencia.btnIndustria) {
            playSound("/Sonidos/Industria.wav");
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



    @Override
    public void mouseClicked(MouseEvent e) {
   }



    @Override
    public void mousePressed(MouseEvent e) {
    }



    @Override
    public void mouseReleased(MouseEvent e) {
    }



    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == ciencia.lblCienciasNaturales) {
            JOptionPane.showMessageDialog(ciencia, " Las ciencias naturales son disciplinas científicas que estudian los fenómenos \r\n" + //
                                "de la naturaleza. Se enfocan en la observación, descripción, comprensión y predicción de \r\n" + //
                                "los fenómenos naturales del universo. Estas ciencias buscan explicar el mundo físico y los \r\n" + //
                                "seres vivos mediante métodos empíricos y la formulación de teorías y leyes basadas en la \r\n" + //
                                "evidencia observable", "¿Que son las ciencias naturales?", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblHistoriaCienciasNaturales) {
            JOptionPane.showMessageDialog(ciencia,"La historia de las ciencias naturales se remonta a la antigüedad, con filósofos \r\n" + //
                                "como Aristóteles que ya intentaban entender el mundo natural. Durante la Edad Media, los \r\n" + //
                                "conocimientos científicos fueron preservados y desarrollados por eruditos islámicos y \r\n" + //
                                "europeos. La revolución científica en el siglo XVII, impulsada por figuras como Galileo \r\n" + //
                                "Galilei, Isaac Newton y Robert Boyle, marcó un cambio significativo en la manera de \r\n" + //
                                "estudiar la naturaleza, estableciendo el método científico. En los siglos XVIII y XIX, las \r\n" + //
                                "ciencias naturales se diversificaron y especializaron, dando lugar a disciplinas como la \r\n" + //
                                "biología, la química y la física moderna. En el siglo XX, los avances tecnológicos y las \r\n" + //
                                "nuevas teorías, como la teoría de la relatividad y la mecánica cuántica, revolucionaron \r\n" + //
                                "nuestra comprensión del universo. ", "Historia de las ciencias naturales", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblImportanciaCiencias) {
            JOptionPane.showMessageDialog(ciencia, ": Las ciencias naturales son fundamentales para el progreso humano. Nos \r\n" + //
                                "permiten comprender el funcionamiento del mundo físico y biológico, lo cual es esencial \r\n" + //
                                "para el desarrollo de nuevas tecnologías y medicamentos, la conservación del medio \r\n" + //
                                "ambiente y la mejora de la calidad de vida. Las ciencias naturales también juegan un papel \r\n" + //
                                "crucial en la educación, fomentando el pensamiento crítico y el método científico, \r\n" + //
                                "habilidades importantes en una sociedad cada vez más dependiente de la ciencia y la \r\n" + //
                                "tecnología.", "Importancia de las ciencias naturales", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblRelacionCiencias) {
            JOptionPane.showMessageDialog(ciencia, ": Las ciencias naturales están estrechamente relacionadas con otras disciplinas \r\n" + //
                                "científicas y no científicas. Por ejemplo, la bioquímica combina la biología y la química \r\n" + //
                                "para estudiar los procesos químicos dentro de los organismos vivos. La geofísica aplica los \r\n" + //
                                "principios de la física al estudio de la Tierra. Además, las ciencias naturales se intersectan \r\n" + //
                                "con las ciencias sociales en áreas como la geografía y la psicología, donde se estudia la \r\n" + //
                                "interacción entre el entorno natural y las sociedades humanas. Esta interdisciplinariedad \r\n" + //
                                "permite abordar problemas complejos desde múltiples perspectivas, ofreciendo \r\n" + //
                                "soluciones más integrales", "Ciencias naturales y su relación con Bioquímica", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblBiologia) {
            JOptionPane.showMessageDialog(ciencia, "es la ciencia que estudia a los seres vivos y los procesos vitales. Esta disciplina abarca una amplia gama de subcampos que examinan la estructura, función, crecimiento, origen, evolución y distribución de los organismos vivos. La biología también investiga cómo los seres vivos interactúan entre sí y con su entorno, lo que incluye aspectos como la ecología, la genética, la fisiología, la microbiología, la zoología y la botánica, entre otros", "Biología", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblQuimica) {
            JOptionPane.showMessageDialog(ciencia, "es la ciencia que estudia la composición, estructura, propiedades y cambios de \r\n" + //
                                "la materia. Examina las sustancias y los elementos que forman los compuestos, así como \r\n" + //
                                "las reacciones y los procesos que transforman unas sustancias en otras. La química \r\n" + //
                                "abarca diversas ramas como la química orgánica, inorgánica, física, analítica y biológica. ", "Quimica", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblFisica) {
            JOptionPane.showMessageDialog(ciencia, "es la ciencia que estudia las propiedades y el comportamiento de la materia y la \r\n" + //
                                "energía. Se centra en comprender los principios fundamentales del universo, como las \r\n" + //
                                "leyes del movimiento, la gravitación, el electromagnetismo, la termodinámica y la \r\n" + //
                                "mecánica cuántica. La física busca explicar fenómenos naturales desde la escala más \r\n" + //
                                "grande del cosmos hasta la escala más pequeña de partículas subatómicas.", "Fisica", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblGeologia) {
            JOptionPane.showMessageDialog(ciencia, "es la ciencia que estudia la composición, estructura y procesos de la Tierra. \r\n" + //
                                "Examina los materiales que constituyen el planeta, así como los procesos que lo han \r\n" + //
                                "moldeado a lo largo del tiempo, como la formación de montañas, la actividad volcánica, la \r\n" + //
                                "erosión y la sedimentación. La geología también se ocupa del estudio de los fósiles y la \r\n" + //
                                "historia geológica del planeta.", "Geología", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblAstronomia) {
            JOptionPane.showMessageDialog(ciencia, "es la ciencia que estudia los cuerpos celestes y los fenómenos que ocurren \r\n" + //
                                "fuera de la atmósfera terrestre. Esto incluye la observación y análisis de estrellas, \r\n" + //
                                "planetas, galaxias, cometas, nebulosas y otros objetos astronómicos. La astronomía \r\n" + //
                                "también se ocupa de entender la formación y evolución del universo.", "Astronomía", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblMicrobiologia) {
            JOptionPane.showMessageDialog(ciencia, " es la rama de la biología que estudia los microorganismos, como bacterias, \r\n" + //
                                "virus, hongos, protozoos y algas microscópicas. Investiga su estructura, función, \r\n" + //
                                "crecimiento, ecología y papel en la salud humana, enfermedades, biotecnología y medio \r\n" + //
                                "ambiente.", "Microbiología", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblQuimicaOr) {
            JOptionPane.showMessageDialog(ciencia, "es la rama de la química que se centra en el estudio de los compuestos \r\n" + //
                                "que contienen carbono. Esto incluye la estructura, propiedades, reacciones y síntesis de \r\n" + //
                                "compuestos orgánicos, que forman la base de la vida y son fundamentales en la biología, \r\n" + //
                                "medicina, y muchas industrias como la farmacéutica y la petroquímica.", "Química Orgánica", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblFisicaCuan) {
            JOptionPane.showMessageDialog(ciencia, " es la rama de la física que estudia los fenómenos a escala de átomos y \r\n" + //
                                "partículas subatómicas. Introduce conceptos fundamentales como la dualidad onda\r\n" + //
                                "partícula, el principio de incertidumbre de Heisenberg y la superposición cuántica. La \r\n" + //
                                "física cuántica es esencial para entender las propiedades de los materiales y el \r\n" + //
                                "comportamiento de la materia y la energía a nivel microscópico.", "Física Cuántica", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblVulcanologia) {
            JOptionPane.showMessageDialog(ciencia, " es la rama de la geología que estudia los volcanes, la lava, el magma y los \r\n" + //
                                "fenómenos geológicos asociados. Investiga la formación, actividad y efectos de los \r\n" + //
                                "volcanes, así como la predicción y mitigación de riesgos volcánicos. La vulcanología \r\n" + //
                                "también se ocupa de estudiar los depósitos volcánicos y su impacto en el medio ambiente \r\n" + //
                                "y la sociedad.", "Vulcanología", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblMedicina) {
            JOptionPane.showMessageDialog(ciencia, " Las ciencias naturales, como la \r\n" + //
                                "biología, la química y la física, son fundamentales en la medicina para entender el \r\n" + //
                                "funcionamiento del cuerpo humano y las enfermedades. La biología proporciona \r\n" + //
                                "conocimientos sobre la anatomía, fisiología y genética, que son esenciales para el \r\n" + //
                                "diagnóstico y tratamiento. La química ayuda en la formulación de medicamentos y en el \r\n" + //
                                "análisis de sustancias biológicas. La física se aplica en técnicas de imagenología como la \r\n" + //
                                "resonancia magnética y la tomografía computarizada. En conjunto, estas ciencias \r\n" + //
                                "permiten el desarrollo de tratamientos efectivos y la innovación en tecnologías médicas.", "Medicina", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblTecnologia) {
            JOptionPane.showMessageDialog(ciencia, "Las ciencias naturales son la base \r\n" + //
                                "para el desarrollo y la innovación tecnológica. La física y la química son esenciales para la \r\n" + //
                                "creación de nuevos materiales y dispositivos electrónicos, como semiconductores y \r\n" + //
                                "baterías. La biología y la química se aplican en la biotecnología para desarrollar productos \r\n" + //
                                "como medicamentos y cultivos genéticamente modificados. Además, los principios de la \r\n" + //
                                "física se utilizan en el diseño de sistemas de comunicación y computación. En resumen, \r\n" + //
                                "las ciencias naturales proporcionan los conocimientos necesarios para el avance \r\n" + //
                                "tecnológico y la creación de soluciones innovadoras.", "Tecnología", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblMedioAmbiente) {
            JOptionPane.showMessageDialog(ciencia, " Las ciencias naturales son \r\n" + //
                                "cruciales para el estudio y la gestión del medio ambiente. La biología y la ecología \r\n" + //
                                "permiten entender los ecosistemas, la biodiversidad y los impactos de las actividades \r\n" + //
                                "humanas. La química se aplica en el análisis de contaminantes y la evaluación de la \r\n" + //
                                "calidad del aire, agua y suelo. La física se utiliza en el monitoreo de fenómenos \r\n" + //
                                "meteorológicos y climáticos. Estas ciencias ayudan a desarrollar estrategias para la \r\n" + //
                                "conservación de recursos naturales, la mitigación del cambio climático y la protección del \r\n" + //
                                "entorno natural. ", "Medio Ambiente", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == ciencia.lblIndustria) {
            JOptionPane.showMessageDialog(ciencia, " En la industria, las ciencias \r\n" + //
                                "naturales son aplicadas para optimizar procesos y desarrollar nuevos productos. La \r\n" + //
                                "química es esencial en la formulación de productos químicos, plásticos y materiales \r\n" + //
                                "avanzados. La física y la ingeniería se utilizan en el diseño de maquinaria, equipos y \r\n" + //
                                "procesos de manufactura. La biología y la biotecnología juegan un papel en la producción \r\n" + //
                                                                        "de alimentos, productos farmacéuticos y biocombustibles. Las ciencias naturales \r\n" + //
                                                                        "permiten mejorar la eficiencia, seguridad y sostenibilidad en la producción industrial y la \r\n" + //
                                                                        "gestión de recursos.", "Industria", JOptionPane.INFORMATION_MESSAGE);
        }
    }



    @Override
    public void mouseExited(MouseEvent e) {
    }


}
