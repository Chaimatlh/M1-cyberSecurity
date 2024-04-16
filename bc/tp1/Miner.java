

public class Miner {
    private int difficulty;

    public Miner(int difficulty) {
        this.difficulty = difficulty;
    }
    
    public int getDifficulty() {
        return difficulty;
    }

    public boolean goldenHash(Block block) {
        String leadingZeros = new String(new char[difficulty]).replace('\0', '0');
        return block.getHash().substring(0, difficulty).equals(leadingZeros);
    }
}
