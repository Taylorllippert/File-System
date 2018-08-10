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
    
    //called for function DB
    public void deleteBlocks(String name, int bnum){
        INode fnode = filetoINode.get(name);
        for(int i = 0; i < bnum; i++)
            dataBlocks[fnode.removeBlock()] = false;
    }
    
    public void addBlocks(String fileName, int blockNum) {
        INode n = filetoINode.get(fileName); // iNode target

        for (int i = 0; i < dataBlocks.length; i++) {
            if (dataBlocks[i] == false) { // insert to iNode
                n.insertBlock(i);
                blockNum--;
            }
            if (blockNum == 0) {
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

