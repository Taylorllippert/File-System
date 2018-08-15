import java.util.*;

public class INode {

    public Date aTime; // last access
    public Date cTime; // time created
    public Date mTime; // time modified (update in add block & remove block)

    public int blockCount; // amount of blocks used
    public int[] directBlocks; // set size as 12. keeps track of the blocks used for this iNode
    public int fileSize;    //fileSize based on block size(in bytes)
    public int blockSize;
    public int fMode;
    public String fUid;
    public String fGid;

    final int INVALID_BLOCK_NUMBER = -1;    // default block number
    final int HARDCODED_BLOCKMAX = 12;  //ASSUMPTION: a File may not exceed 12 blocks

    public INode (int mode, String uid, String gid, int bSize) {
        directBlocks = new int[HARDCODED_BLOCKMAX];
        aTime = new Date();
        cTime = new Date();
        mTime = new Date();

        blockSize = bSize;
        fMode = mode;
        fUid = uid;
        fGid = gid;
        blockCount = 0;
        fileSize = 0;
        for (int i = 0; i < directBlocks.length; i++) {
            directBlocks[i] = INVALID_BLOCK_NUMBER;
        }
    }

    // accepts an index to be inserted into directBlocks
    public boolean insertBlock(int newBlockIndex) {
        // directBlocks is already full
        if (blockCount == 12) {
            return false;
        }

        // can insert
        directBlocks[blockCount] = newBlockIndex;
        mTime = new Date();
        blockCount++;
        updateFileSize();
        return true;
    }

    // @returns -1 if empty or index of removed block
    public int removeBlock() {
        if (blockCount == 0) {
            return INVALID_BLOCK_NUMBER;
        }

        blockCount--;
        updateFileSize();
        int tmp = directBlocks[blockCount];
        directBlocks[blockCount] = INVALID_BLOCK_NUMBER;
        mTime = new Date();
        return tmp;
    }

    private void updateFileSize(){
        fileSize = blockCount*blockSize;
    }
    //TO DO
    public String toString(){

        return "";
    }
}
