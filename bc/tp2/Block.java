package tp2;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Block{
    private int index;
    private long timestamp;
    private String data;
    private String previousHash;
    private String Hash;
    private int nonce;

    public Block(int index,String data,String previousHash){
        this.index=index;
        this.data=data;
        this.previousHash=previousHash;
        this.timestamp=System.currentTimeMillis();
        this.Hash=calculateHash();
        this.nonce=0;
    }

    public String getHash(){
        return Hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public int IncrementNonce(){
        this.nonce ++;
        return nonce;
    }
     
    public void setData(String newData){
        this.data=newData;
    }
    
    public void setHash(){
        this.Hash=calculateHash();
    }
    
    public String calculateHash(){
        String text=String.valueOf(nonce+index+previousHash+String.valueOf(data)+String.valueOf(timestamp));
        MessageDigest digest= null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        final byte bytes[]=digest.digest(text.getBytes());
        final StringBuilder hexString = new StringBuilder();
        for(final byte b:bytes){
            String hex=Integer.toHexString(0xff &b);
            if(hex.length()==1){
                hexString.append("0");
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    public void Context(){
        System.out.println("-------------------------------------------------");
        System.out.println("Block number : "+index);
        System.out.println("Nonce :"+nonce);
        System.out.println("Data : "+data);
        System.out.println("Previous Hash : "+previousHash);
        System.out.println("Block Hash : "+String.valueOf(Hash));
        System.out.println("Block TimeStamp is : "+timestamp);
        System.out.println("-------------------------------------------------");
    }
}