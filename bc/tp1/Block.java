

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Block {
    private final int index;
    private final long timestamp;
    private String data;
    private final String previousHash;
    private final String hash;
    private int nonce; // Nonce for mining

    // constructor
    public Block(String data, String previousHash, long timestamp, int index) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.index = index;
        this.nonce = 0;
        this.hash = calculateHash();
    }

    // hash function
    public String calculateHash() {
        String text = String.valueOf(index + previousHash + String.valueOf(timestamp) + String.valueOf(data) + nonce);
        MessageDigest digest = null;
        try {
            // we will get the instance of SHA256
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // by using digest() function, we will get hash as one dimensional byte array
        final byte bytes[] = digest.digest(text.getBytes());
        // we wanna use hexadecimal values not bytes in our program
        // will convert byte into hexadecimal
        final StringBuilder hexString = new StringBuilder();
        for (final byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append("0");
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public String getHash() {
        return hash;
    }

    public int getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public int getNonce() {
        return nonce;
    }

    public void mineBlock(Miner miner) {
        
        String hash;
        while (!miner.goldenHash(this)) {
            nonce++; // Increment nonce until finding the golden hash
            hash = calculateHash(); // Recalculate the hash with updated nonce
        }
    }
}