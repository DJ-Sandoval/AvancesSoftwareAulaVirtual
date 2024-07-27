package Vista;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class PDFViewer {

    public static void openPDFInBrowser(File pdfFile) {
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

    public static void main(String[] args) {
        try {
            File pdfFile = PDFUtil.getTempFileFromResource("/Libros/ManualAnatomíaEdwinSaldana.pdf");
            openPDFInBrowser(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
