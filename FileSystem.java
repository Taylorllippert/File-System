import java.util.*;

public class FileSystem {
    HashMap<String, INode> filetoINode;
    boolean[] dataBlocks;
    
    //Creates File System Object
    //Needs to initialize dataBlocks to false
    public FileSystem (){
        filetoINode = new HashMap<>(); // key: filename, value: iNode
        dataBlocks = new boolean[100]; // false if unused. true if used
    }
    
    //Creates a new file and uses addBlocks to add the necessary blocks
    public void newFile(String name, int bnum){
    	INode node = new INode();
    	filetoINode.put(name, node);
    	addBlocks(name, bnum);
    }
    
    // called for function DB
    // remove a certain number of blocks in the INode of a certain file
    public void deleteBlocks(String name, int bnum){
        INode fnode = filetoINode.get(name);
        for(int i = 0; i < bnum; i++)
            dataBlocks[fnode.removeBlock()] = false;
    }
    
    // add a certain number of blocks into the INode of a certain file
    public void addBlocks(String fileName, int blockNum) {
        INode n = filetoINode.get(fileName); // iNode target

	// iterate through every blocks that exists in the file system
        for (int i = 0; i < dataBlocks.length; i++) {
            if (dataBlocks[i] == false) { // insert to iNode if block is not used
                n.insertBlock(i);
                blockNum--;
            }
            if (blockNum == 0) { // the amount of blocks to be added has been reached
                break;
            }
        }
    }  
	
    public void deleteFile(String filename) {
        INode n = filetoINode.get(filename);
        for (int i =0;i<n.blockCount; i++) {
            deleteBlocks(filename, i);
        }
    //to do: delete INode from hashmap
    }

    
    //TO DO
    public String toString(){

        return "";
    }
}

