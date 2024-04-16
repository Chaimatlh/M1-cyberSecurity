package tp2;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Blocks chain1= new Blocks();
        chain1.SetGenesisBlock();
        Scanner scan = new Scanner(System.in);
        System.out.print("tap the number pf blocks :  ");
        int n = scan.nextInt();
        int i = 1;
        while(i <= n){
            System.out.println("tap the data  "+i+" :");
            String data= scan.next();
            data += scan.nextLine();
            chain1.AddBlock(data);                
            i++;
            } 
        
        chain1.BlocksContext();
        System.out.println("block chain is valid ? "+chain1.Valid());
        System.out.println(" ");
    }
}