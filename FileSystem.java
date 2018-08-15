import java.util.*;

public class FileSystem {
    HashMap<String, INode> filetoINode;
    boolean[] dataBlocks;   // disk map

    final int MAX_DISK_BLOCKS = 1000;

    final String DEFAULT_MODE = "f-rwxr--r--";
    final int BLOCK_SIZE = 512; // 512K in bytes
    final String DEFAULT_UID = "CSS430";
    final String DEFAULT_GID = "CSS430";

    //Creates File System Object
    //Needs to initialize dataBlocks to false
    public FileSystem (){
        filetoINode = new HashMap<>(); // key: filename, value: iNode
        dataBlocks = new boolean[MAX_DISK_BLOCKS]; // false if unused. true if used
    }
    
    //Creates a new file and uses addBlocks to add the necessary blocks
    public void newFile(String name, int bnum){
        INode node = new INode(DEFAULT_MODE, DEFAULT_UID, DEFAULT_GID, BLOCK_SIZE);
    	filetoINode.put(name, node);
    	addBlocks(name, bnum);
    }
    
    // called for function DB
    // remove a certain number of blocks in the INode of a certain file
    public void deleteBlocks(String name, int bnum){
        INode fnode = filetoINode.get(name);
        for(int i = 0; i < bnum; i++) {
            if(fnode.blockCount == 0){
                System.out.println("DB (deleteBlock) command failed; no blocks to delete");
                return;
            }
            dataBlocks[fnode.removeBlock()] = false;
        }
    }
    
    // add a certain number of blocks into the INode of a certain file
    public void addBlocks(String fileName, int blockNum) {
        INode n = filetoINode.get(fileName); // iNode target

	// iterate through every blocks that exists in the file system
        for (int i = 0; i < dataBlocks.length; i++) {
            if (dataBlocks[i] == false) { // insert to iNode if block is not used
                n.insertBlock(i);
                blockNum--;
                dataBlocks[i] = true;
            }
            if (blockNum == 0) { // the amount of blocks to be added has been reached
                break;
            }
        }
    }  

    //deletes a file from disk
    public void deleteFile(String fileName) {
        INode n = filetoINode.get(fileName);
        deleteBlocks(fileName, n.blockCount);
        filetoINode.remove(fileName);   //delete iNode from hashmap
    }
    private int usedSpace(){
	int i = 0;
	for (int j = 0; j < MAX_DISK_BLOCKS; j++)
	    if(dataBlocks[j])
		i++;
	return BLOCK_SIZE*i;
    }
    
    //TO DO
    public String toString(){
        String display = "Used Space: " + usedSpace();
        for (String name: filetoINode.keySet()){
            INode val = filetoINode.get(name);
            display += "\n" +val + " " +name ;
        }
            return display;
}

}

