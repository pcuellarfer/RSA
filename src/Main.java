import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Clase principal que ejecuta la generación de claves RSA,
 * el cifrado de un mensaje con la clave pública y su descifrado con la clave privada.
 */
public class Main {

    /**
     * Metodo principal que genera un par de claves RSA, cifra un mensaje y luego lo descifra.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        try {
            // Generación de las claves pública y privada
            KeyPair parDeClaves = GestorClaves.generarClaves();
            PublicKey clavePublica = parDeClaves.getPublic();
            PrivateKey clavePrivada = parDeClaves.getPrivate();

            // Mensaje que va a ser cifrado y luego descifrado
            String mensajeOriginal = "Mensaje secreto de prueba";
            System.out.println("Mensaje original: " + mensajeOriginal);

            // Cifrado con la clave pública
            String mensajeCifrado = GestorClaves.cifrar(mensajeOriginal, clavePublica);
            System.out.println("Mensaje cifrado: " + mensajeCifrado);

            // Descifrado con la clave privada
            String mensajeDescifrado = GestorClaves.descifrar(mensajeCifrado, clavePrivada);
            System.out.println("Mensaje descifrado: " + mensajeDescifrado);

        } catch (Exception e) {
            // Captura cualquier error que pueda pasar
            e.printStackTrace();
        }
    }
}
