package tp2;

public class Miner {
    private int difficulty=1;
     
    public boolean GoldenHash(Block block){
        String leadingZeros = new String(new char[difficulty]).replace('\0', '0');
        
        boolean valid =block.getHash().substring(0,difficulty).equals(leadingZeros);
        
        return valid;
    }

}
