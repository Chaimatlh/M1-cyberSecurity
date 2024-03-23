package partTwo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
public class serverTwo {
public static void main(String[] args) {
try {
ServerSocket serverSocket= new ServerSocket(1025); // cree l object 
System.out.println("Wait for connexion of a client ");
Socket socket= serverSocket.accept();
InputStream inputStream = socket.getInputStream(); // lire chaine de c du client 
InputStreamReader isr =new InputStreamReader(inputStream); 
BufferedReader br= new BufferedReader(isr);
OutputStream outputStream = socket.getOutputStream();
PrintWriter pw= new PrintWriter(outputStream,true); // envoyer chaine de c au client , li ybaetha l server 
System.out.println("I wait for a message"); 
String str= br.readLine();
String res= "Hello CyberSecurity Student to the course ofSecure Software Development"+str;
System.out.println("I send the result");
pw.println(res);
socket.close(); // close the connection
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}