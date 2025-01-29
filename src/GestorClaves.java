import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

/**
 * Clase que gestiona la generación de claves RSA, el cifrado y descifrado de mensajes.
 */
public class GestorClaves {

    /**
     * Genera un par de claves RSA (clave pública y clave privada).
     *
     * @return Un objeto {@code KeyPair} que contiene la clave pública y la clave privada.
     * @throws Exception Si ocurre un error durante la generación de las claves.
     */
    public static KeyPair generarClaves() throws Exception {
        KeyPairGenerator generadorClaves = KeyPairGenerator.getInstance("RSA");
        generadorClaves.initialize(2048);
        return generadorClaves.generateKeyPair();
    }

    /**
     * Cifra un mensaje utilizando una clave pública RSA.
     *
     * @param mensaje El texto en claro que se desea cifrar.
     * @param clavePublica La clave pública utilizada para cifrar el mensaje.
     * @return El mensaje cifrado en formato Base64.
     * @throws Exception Si ocurre un error durante el cifrado.
     */
    public static String cifrar(String mensaje, PublicKey clavePublica) throws Exception {
        Cipher objetoCifrado = Cipher.getInstance("RSA");
        objetoCifrado.init(Cipher.ENCRYPT_MODE, clavePublica);
        byte[] mensajeCifrado = objetoCifrado.doFinal(mensaje.getBytes());
        return Base64.getEncoder().encodeToString(mensajeCifrado);
    }

    /**
     * Descifra un mensaje cifrado utilizando una clave privada RSA.
     *
     * @param mensajeCifrado El mensaje cifrado en formato Base64.
     * @param clavePrivada La clave privada utilizada para descifrar el mensaje.
     * @return El mensaje original en texto claro.
     * @throws Exception Si ocurre un error durante el descifrado.
     */
    public static String descifrar(String mensajeCifrado, PrivateKey clavePrivada) throws Exception {
        Cipher objetoCifrado = Cipher.getInstance("RSA");
        objetoCifrado.init(Cipher.DECRYPT_MODE, clavePrivada);
        byte[] mensajeDescifrado = objetoCifrado.doFinal(Base64.getDecoder().decode(mensajeCifrado));
        return new String(mensajeDescifrado);
    }
}
