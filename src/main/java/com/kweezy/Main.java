package com.kweezy;

import com.kweezy.stmt.BlockType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //static List<Object> blocks = new ArrayList<>();

    private static BlockType[] blocks;
    private static long lastStmtId;

    public static void main(String[] args) throws Exception {
        try {
            DataInputStream file = getData("HelloWorldToast.flo");

            ObjectReader a = new ObjectReader(file);
            final int i = readerFileHeader(a, true);
            if (i == 0) {
                return;
            }

            blocks = new BlockType[i]; // Block type? wtf is that
            for (int j = 0; j < i; ++j) {
                blocks[j] = a.readObject();
                System.out.println(blocks[j]);
            }

            //final BlockType[] a2 = new BlockType[i];
            //System.arraycopy(this.x1, 0, a2, 0, i);
            //Arrays.sort(a2, BlockType.e); // TODO: Sort blocks by BlockType.e

        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("File is missing, stopping");
        }

    }

    public static int readerFileHeader(final ObjectReader a, final boolean b) throws Exception {
        final int int1 = a.readInt();
        if (1279346284 == int1) {
            int n;
            if (b) {
                n = 96;
            }
            else {
                n = Integer.MAX_VALUE;
            }
            a.setStringFlag(35 <= a.versionMatches(n));

            lastStmtId = a.transform_63();
            return a.unsigned_35();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Bad magic: 0x");
        sb.append(Integer.toHexString(int1));
        throw new StreamCorruptedException(sb.toString());
    }

    public static DataInputStream getData(String file) throws IOException {
        return new DataInputStream(new ByteArrayInputStream(new FileInputStream(file).readAllBytes()));
    }



}
