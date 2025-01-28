import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Main {

    public static void main(String[] args) {
        try {
            // Generacion de las claves pública y privada
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
            e.printStackTrace();
        }
    }
}