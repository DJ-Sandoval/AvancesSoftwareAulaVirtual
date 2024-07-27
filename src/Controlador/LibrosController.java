package Controlador;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.CatalogoCienciasNaturales;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LibrosController implements ActionListener, MouseListener, KeyListener {
    // Instancia de clases
    private CatalogoCienciasNaturales catalogo;

    

    public LibrosController(CatalogoCienciasNaturales catalogo) {
        this.catalogo = catalogo;
        this.catalogo.btnAnatomia.addActionListener(this);
        this.catalogo.btnAtlasAnatomia.addActionListener(this);
        this.catalogo.btnCiencias1.addActionListener(this);
        this.catalogo.btnIntroduccion.addActionListener(this);
        this.catalogo.btnMaterial.addActionListener(this);
        this.catalogo.btnPlantas.addActionListener(this);
        // Label
        this.catalogo.lblAnatomia.addMouseListener(this);
        this.catalogo.lblAtlas.addMouseListener(this);
        this.catalogo.lblCiencias.addMouseListener(this);
        this.catalogo.lblIntroduccion.addMouseListener(this);
        this.catalogo.lblMaterial.addMouseListener(this);
        this.catalogo.lblPlantas.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == catalogo.btnAnatomia) {
            openPDF("/Libros/ManualAnatomíaEdwinSaldana.pdf");
        } else if (e.getSource() == catalogo.btnAtlasAnatomia) {
            openPDF("/Libros/Atlas de AnatomíaHumana.pdf");
        } else if (e.getSource() == catalogo.btnCiencias1) {
            openPDF("/Libros/CienciasNaturales1.pdf");
        } else if (e.getSource() == catalogo.btnIntroduccion) {
            openPDF("/Libros/IntroducciónCN.pdf");
        } else if (e.getSource() == catalogo.btnMaterial) {
            openPDF("/Libros/MaterialApoyoCN.pdf");
        } else if (e.getSource() == catalogo.btnPlantas) {
            openPDF("/Libros/Plantas.pdf");
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // Métodos de pdf
    private void openPDF(String resourcePath) {
        try {
            File pdfFile = getTempFileFromResource(resourcePath);
            openPDFInBrowser(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getTempFileFromResource(String resourcePath) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(resourcePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("El recurso no se encuentra: " + resourcePath);
        }

        File tempFile = File.createTempFile("temp", ".pdf");
        tempFile.deleteOnExit();

        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);  // Aquí está la corrección: agregar el offset y el length
            }
        } finally {
            inputStream.close();
        }
        return tempFile;
    }

    private void openPDFInBrowser(File pdfFile) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(pdfFile.toURI());
                } else {
                    throw new UnsupportedOperationException("Navegador no soportado");
                }
            } else {
                throw new UnsupportedOperationException("Desktop no soportado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
