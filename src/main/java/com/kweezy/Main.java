package com.kweezy;

import com.kweezy.stmt.BlockType;
import com.kweezy.stmt.ToastShow;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Math.sin;

public class Main {
    //static List<Object> blocks = new ArrayList<>();

    // private static BlockType[] blocks;

    private static ArrayList<BlockType> blocksnew = new ArrayList<>();
    private static long lastStmtId;

    public static void main(String[] args) throws Exception {
        try {
            DataInputStream in = getData("HelloWorldToast.flo");

            ObjectReader a = new ObjectReader(in);
            final int i = readerFileHeader(a, true);
            if (i == 0) {
                return;
            }


            //blocks = new BlockType[i];
            for (int j = 0; j < i; ++j) {
                //blocks[j] = a.readObject();
                blocksnew.add(a.readObject());

            }

            long counter = lastStmtId + 1;
            for(double x=-450;x<=450;x=x+0.5) {
                double y = 50 * sin(x * (3.1415926 / 180));
                int Y = (int) y;
                int X = (int) x;
                blocksnew.add(generateToastBlock(counter, X, Y));
                counter++;
            }
            // for (long jj = lastStmtId; jj < 1000; ++jj) {
            //     blocksnew.add(generateToastBlock(jj+1, (int) jj, (int) jj));
            // }


            DataOutputStream out = new DataOutputStream(new FileOutputStream("auto-generated.flo"));

            ObjectWriter b = new ObjectWriter(out);
            writeFileHeader(b);

            for (int length = blocksnew.size(), ii = 0; ii < length; ++ii) {
                b.writeObject(blocksnew.get(ii));
            }


            //final BlockType[] a2 = new BlockType[i];
            //System.arraycopy(this.x1, 0, a2, 0, i);
            //Arrays.sort(a2, BlockType.e); // TODO: Sort blocks by BlockType.e

        } catch (IOException e) {
            System.out.println(e.toString());
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

    public static void writeFileHeader(final ObjectWriter writer) throws IOException {
        writer.writeInt(1279346284);
        writer.writeVersion(96);
        writer.setStringFlag(true);
        writer.transform_63(lastStmtId);
        writer.unsigned_35(blocksnew.size());

    }

    public static ToastShow generateToastBlock(long id, int x, int y) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ToastShow blk = (ToastShow)((Class<? extends BlockType>) Class.forName("com.kweezy.stmt.ToastShow")).newInstance();
        blk.x = x;
        blk.y = y;
        blk.id = id;

        return blk;
    }

    public static DataInputStream getData(String file) throws IOException {
        return new DataInputStream(new ByteArrayInputStream(new FileInputStream(file).readAllBytes()));
    }



}
