

import java.util.ArrayList;
import java.util.List;

 class Blockchain {

    private List<Block> blockChain = new ArrayList<>();  // create a block chain
    public List<Block> getBlockChain() {
        return blockChain;
    }

    public void createFirstBlock() {
        Block genesisBlock = new Block("Genesis Block", "0", System.currentTimeMillis(), 0);
        blockChain.add(genesisBlock);
    }
    // Create a method that retrieves the latest block
    public Block getLatestBlock() {
        return blockChain.get(blockChain.size() - 1);
    }

    public void addBlock(String data) {
        String prevHash = getLatestBlock().calculateHash();
        Block block = new Block(data, prevHash, System.currentTimeMillis(), blockChain.size() + 1);
        blockChain.add(block);
    }
    
    // For each block in the chain, 
    // check if the saved block hash and its previous
    // block hash are the same

    public boolean isChainValid() {
        for (int i = 1; i < blockChain.size(); i++) {
            Block currentBlock = blockChain.get(i);
            Block previousBlock = blockChain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }
}