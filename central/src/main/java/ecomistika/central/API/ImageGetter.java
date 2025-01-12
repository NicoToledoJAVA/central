package ecomistika.central.API;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.awt.FlowLayout;
import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Nicolas
 */
public class ImageGetter {

    private String SSH_USER = "root";
    private String SSH_HOST = "200.45.208.91";
    private Integer SSH_PORT = 5599;
    private String SSH_PASSWORD = "Toletole12!";

    public String getImage(Long id) throws Exception {
        JSch jsch = new JSch();
        Session session = null;
        ChannelSftp sftpChannel = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String imagen = "null";
        try {
            // Establecer la sesión SSH
            session = jsch.getSession(SSH_USER, SSH_HOST, SSH_PORT);
            session.setPassword(SSH_PASSWORD);

            // Configurar propiedades de la sesión
            session.setConfig("StrictHostKeyChecking", "no");

            // Conectar a la sesión
            session.connect();

            // Abrir el canal SFTP
            Channel channel = session.openChannel("sftp");
            channel.connect();
            sftpChannel = (ChannelSftp) channel;

            // Ruta del archivo en el servidor
            String remoteFilePath = "/home/vps-3858808-x.dattaweb.com/store/wines/images/" + id + ".jpg";
            System.out.println("Intentando acceder a: " + remoteFilePath);

            // Descargar el archivo
            InputStream inputStream;
            try {
                inputStream = sftpChannel.get(remoteFilePath);
            } catch (Exception e) {
                throw new Exception("Error al acceder al archivo: " + e.getMessage());
            }

            // Leer el archivo en el ByteArrayOutputStream
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            imagen = Base64.getEncoder().encodeToString(outputStream.toByteArray());

            // Devolver la imagen como un arreglo de bytes
            return imagen;

        } finally {
            // Cerrar recursos
            if (sftpChannel != null) {
                sftpChannel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }

}
