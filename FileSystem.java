import java.util.*;

public class FileSystem {
    HashMap<String, INode> filetoINode;
    boolean[] usedStatus;
    public FileSystem (){
        filetoINOde = new HashMap<>(); // key: filename, value: iNode
        usedStatus = new boolean[100]; // false if unused. true if used
    }
    
    public void deleteBlocks(String name, int bnum){
    //Taylor Working here
    
    }
}
