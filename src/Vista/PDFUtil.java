package Vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PDFUtil {

    public static File getTempFileFromResource(String resourcePath) throws IOException {
        InputStream inputStream = PDFUtil.class.getResourceAsStream(resourcePath);
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
}
