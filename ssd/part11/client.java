package part11;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class client  { // dans une autre app  et env 
public static void main(String[] args) {
try {
    // cree object socket 
Socket s=new Socket("localhost",1025); // hna y9dar ydirlek prblm tae l machine wl al port taek serveur li madinahalo
InputStream is= s.getInputStream();
OutputStream os= s.getOutputStream();
Scanner keyboard = new Scanner(System.in); // 7na li nbaeo lel serveur n7tajouu scammer 
System.out.println("give a number:");
int nb= keyboard.nextInt(); // declare un nombre de type integer
os.write(nb); // nabaet le nombre li dakhelto  
int res= is.read(); //traitement resultat dans le input todkholni resultat 
System.out.println("the result is="+res);
}
catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}