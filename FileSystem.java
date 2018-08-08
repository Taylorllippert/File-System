import java.util.*;

public class FileSystem {
    HashMap<String, INode> filetoINode;
    boolean[] usedStatus;
    
    //Creates File System Object
    //Needs to initialize usedStatus to false
    public FileSystem (){
        filetoINOde = new HashMap<>(); // key: filename, value: iNode
        usedStatus = new boolean[100]; // false if unused. true if used
    }
    
    //called for function DB
    public void deleteBlocks(String name, int bnum){
        INode fnode = filetoINode.get(name);
        for(int i = 0; i < bnum; i++)
            usedStatus[fnode.remove()] = false;
    }
    
}
