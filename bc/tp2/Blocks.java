package tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
 

public class Blocks {
    private List<Block> blockchain= new ArrayList<>(10);
    private int index=0; 
    Miner mine=new Miner();

    public void SetGenesisBlock() { 
        String prevHash="0000000000000000000000000000000000000000000000000000000000000000";
        Block GenesisBlock = new Block(index,"This is the Genesis block",prevHash);
        boolean GoldenHash=mine.GoldenHash(GenesisBlock);
        while(!GoldenHash){
            GenesisBlock.IncrementNonce();
            GenesisBlock.setHash();
            GoldenHash=mine.GoldenHash(GenesisBlock);
        }
        blockchain.add(GenesisBlock);
    }
    
    public Block Last(){
        return blockchain.get(blockchain.size()-1);
    }

    public void AddBlock(String data){
        
        String prevHash=Last().getHash();
        index++;
        Block block = new Block(index,data,prevHash);
        boolean GoldenHash=mine.GoldenHash(block);
        while(!GoldenHash){
            block.IncrementNonce();
            block.setHash();
            GoldenHash=mine.GoldenHash(block);
        }
        blockchain.add(block);
            

    }
    public int Size(){
        int s = blockchain.size();
        return s;
    }
    
    public void BlocksContext(){
        for(int i=0;i<blockchain.size();i++){
            blockchain.get(i).Context();
        }
        
    }

    public boolean Valid(){
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);
            
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }
            
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    public void Modify(int index,String newData){
        blockchain.get(index).setData(newData);
        blockchain.get(index).setHash();

    }



}