import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class GestorClaves {

//     Metodo para generar las claves publica y privada
    public static KeyPair generarClaves() throws Exception {
        KeyPairGenerator generadorClaves = KeyPairGenerator.getInstance("RSA");
        generadorClaves.initialize(2048);
        return generadorClaves.generateKeyPair();
    }

    // Metodo para cifrar un mensaje con la clave pública
    public static String cifrar(String mensaje, PublicKey clavePublica) throws Exception {
        Cipher objetoCifrado = Cipher.getInstance("RSA");
        objetoCifrado.init(Cipher.ENCRYPT_MODE, clavePublica);
        byte[] mensajeCifrado = objetoCifrado.doFinal(mensaje.getBytes());
        return Base64.getEncoder().encodeToString(mensajeCifrado);
    }

    // Metodo para descifrar un mensaje con la clave privada
    public static String descifrar(String mensajeCifrado, PrivateKey clavePrivada) throws Exception {
        Cipher objetoCifrado = Cipher.getInstance("RSA");
        objetoCifrado.init(Cipher.DECRYPT_MODE, clavePrivada);
        byte[] mensajeDescifrado = objetoCifrado.doFinal(Base64.getDecoder().decode(mensajeCifrado));
        return new String(mensajeDescifrado);
    }
}
