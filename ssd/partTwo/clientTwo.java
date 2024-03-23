package partTwo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class clientTwo{
public static void main(String[] args) {
try {
Socket socket=new Socket("localhost",1025); 
InputStream inputStream = socket.getInputStream();
InputStreamReader inputStreamReader =new InputStreamReader(inputStream);
BufferedReader bufferReader= new BufferedReader(inputStreamReader);
OutputStream os = socket.getOutputStream();
PrintWriter pw= new PrintWriter(os,true);
Scanner keyboard = new Scanner(System.in); // send something to the server 
System.out.println("give your name please :");
String string= keyboard.next();
pw.println(string);
String res= bufferReader.readLine();
System.out.println("the result is="+res);
}
catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}