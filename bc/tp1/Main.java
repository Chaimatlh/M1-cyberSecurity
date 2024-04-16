import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.createFirstBlock();

        // Add new blocks
        for (int i = 1; i < 100; i++) {
            String blockData = "Block " + i + " Data";
            blockchain.addBlock(blockData);
        }

        for (Block block : blockchain.getBlockChain()) {
            System.out.println("Display the contents of each block");
            System.out.println("Block " + block.getIndex() + " Details:");
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Data: " + block.getData());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Hash: " + block.getHash());
            System.out.println("-------------------------------------");
        }

        // Check if the blockchain is valid
        if (blockchain.isChainValid()) {
            System.out.println("The Blockchain is valid.");
        } else {
            System.out.println("The Blockchain is invalid.");
        }

        ////////////////////////////////////

        // Try changing the data in an existing block
        Block blockToModify = blockchain.getBlockChain().get(1); // Modify the second block (index 1)
        blockToModify.setData("hello every");

        // Display the contents of each block after modification
        for (Block block : blockchain.getBlockChain()) {
            System.out.println("Display the contents of each block");
            System.out.println("Block " + block.getIndex() + " Details:");
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Data: " + block.getData());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Hash: " + block.getHash());
            System.out.println("-------------------------------------");
        }

        // Check if the blockchain is valid after modification
        if (blockchain.isChainValid()) {
            System.out.println("The Blockchain is valid after modification.");
        } else {
            System.out.println("The Blockchain is invalid after modification.");
        }

        ////////////////////////////////////

        // Calculate and display the Merkle root of the transactions
        List<String> transactionHashes = new ArrayList<>();
        for (Block block : blockchain.getBlockChain()) {
            transactionHashes.add(block.getHash());
        }

        String merkleRoot = MerkleTree.calculateMerkleRoot(transactionHashes);
        System.out.println("Merkle Root: " + merkleRoot);
    }
}