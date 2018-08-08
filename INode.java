import java.util.*;

public class INode {

    public Date aTime; // last access (update in print??)
    public Date cTime; // time created
    public Date mTime; // time modified (update in add block & remove block)

    public int blockCount; // amount of blocks used
    public int[] directBlocks; // set size as 12. keeps track of the blocks used for this iNode

    public INode () {
        directBlocks = new int[12];
        aTime = new Date();
        cTime = new Date();
        mTime = new Date();

        blockCount = 0;
        for (int i = 0; i < directBlocks.length; i++) {
            directBlocks[i] = -1;
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
        return true;
    }

    public int removeBlock() { // -1 if empty
        if (blockCount == 0) {
            return -1;
        }

        blockCount--;
        return directBlocks[blockCount];
    }
}
