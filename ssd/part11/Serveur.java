package part11;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
public class Serveur {
public static void main(String[] args) {
try {
ServerSocket serverSocket= new ServerSocket(1025);  // ida 3ad lport mosta3mel ykhrjlk exeption hna drna enstance of ss
System.out.println("wait connexion please "); // 
Socket socket= serverSocket.accept(); // accept connextion of the user 
InputStream is = socket.getInputStream(); // deux objets // li baetha client 
OutputStream os = socket.getOutputStream(); // li ybaethom server li client 
System.out.println("I wait for a number");
int nb= is.read(); // nmbr of the client nresevih 
int resultat= nb*3; // traitement multple * 3 
System.out.println("I send the result"); 
os.write(resultat); // nbaet lel client envoie la repance 
socket.close(); // close the connection : fermer notre socket  connexion = socket 
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
