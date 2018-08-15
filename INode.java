import java.util.*;

public class INode {

    public Date aTime; // last access
    public Date cTime; // time created
    public Date mTime; // time modified (update in add block & remove block)

    public int blockCount; // amount of blocks used
    public int[] directBlocks; // set size as 12. keeps track of the blocks used for this iNode

    final int INVALID_BLOCK_NUMBER = -1;    // default block number

    public INode () {
        directBlocks = new int[12];
        cTime = new Date();
        mTime = cTime;
		aTime = mTime;

        blockCount = 0;
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
        return true;
    }

    // @returns -1 if empty or index of removed block
    public int removeBlock() {
        if (blockCount == 0) {
            return INVALID_BLOCK_NUMBER;
        }

        blockCount--;
        int tmp = directBlocks[blockCount];
        directBlocks[blockCount] = INVALID_BLOCK_NUMBER;
        mTime = new Date();
        return tmp;
    }
    //TO DO
    public String toString(){

        return "";
    }
}
