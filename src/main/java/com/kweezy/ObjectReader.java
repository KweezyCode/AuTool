package com.kweezy;

import com.kweezy.stmt.BlocksInit;
import com.kweezy.stmt.PreparedBlock;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ObjectReader extends Readers {

    public void setStringFlag(boolean stringFlag) {
        this.stringFlag = stringFlag;
    }

    private boolean stringFlag;
    private final List<Object> StatementsArray;
    int currentVersion;

    public ObjectReader(final InputStream inputStream) {
        super(inputStream);
        this.StatementsArray = new ArrayList<Object>();
    }

    public void setVersion(int a) {
        currentVersion = a;
    }

    public <T> T addBlockToBlocksArray(final T t) {
        this.StatementsArray.add(t);
        return t;
    }

    public int version() {
        return currentVersion;
    }

    public int versionMatches(final int n) throws Exception {
        final int unsignedShort = this.readUnsignedShort();
        setVersion(unsignedShort);
        if (unsignedShort <= n) {
            return unsignedShort;
        }
        throw new Exception();
    }


    public <T> T[] readBlocks(final T[] array) throws IOException {
        int blocksCount = this.unsigned_35();
        Object[] array2 = array;
        if (array.length != blocksCount) {
            array2 = (Object[]) Array.newInstance(array.getClass().getComponentType(), blocksCount);
        }
        int n = 0;
        while (--blocksCount >= 0) {
            array2[n] = this.readObject();
            ++n;
        }
        return (T[])array2;
    }

    public <T> T readObject() throws IOException {
        final int onCompleteIndex = this.transform_35();

        if (onCompleteIndex < 0) {
            try {
                return (T)this.StatementsArray.get(-onCompleteIndex - 1);
            }
            catch (IndexOutOfBoundsException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Illegal object reference: ");
                sb.append(onCompleteIndex);
                throw new InvalidObjectException(sb.toString());
            }
        }
        if (onCompleteIndex <= 0) {
            return null;
        }


        final PreparedBlock<Object> blk = BlocksInit.get().getBlockById(onCompleteIndex);
        if (blk != null) {
            return (T) blk.addToChain(this);
        }

        //final PreparedBlocks<Object> blk = BlocksInit.a().getStatementById(onCompleteIndex); // :(
        //if (blk != null) {
        //    return (T)blk.a(this);
        //}
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal object type: ");
        sb2.append(onCompleteIndex);
        throw new InvalidObjectException(sb2.toString());
    }

    @Override
    public String readUTF() throws IOException {
        String s;
        if (this.stringFlag) {
            s = this.readString();
        }
        else {
            s = this.readStringShort();
        }
        return s;
    }


}
