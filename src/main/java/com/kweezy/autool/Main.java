package com.kweezy.autool;

import com.kweezy.autool.stmt.blocks.AbstractStatement;
import com.kweezy.autool.stmt.blocks.NotificationShow;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.interfaces.BlockType;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class Main {
    //static List<Object> blocks = new ArrayList<>();

    // private static BlockType[] blocks;

    private static ArrayList<BlockType> blocksnew = new ArrayList<>();
    private static long lastStmtId;

    public static void main(String[] args) throws Exception {

        DataInputStream in = getData("AutomatOS.flo");

        ObjectReader a = new ObjectReader(in);
        final int i = readerFileHeader(a, true);
        if (i == 0) {
            return;
        }


        //blocks = new BlockType[i];
        for (int j = 0; j < i; ++j) {
            //blocks[j] = a.readObject();
            blocksnew.add(a.readObject());
            // System.out.println(blocksnew.get(j));

        }
        blocksnew.sort(BlockType.comparator); // Sort after reading

        // ------------ Main Part START ------------



        int maxx = (int) sqrt(blocksnew.size())-1;

        int yy = 0;
        int xx = 0;

        for (BlockType ii : blocksnew) {
            AbstractStatement as = (AbstractStatement) ii;
            as.x = xx * 8;
            as.y = yy * 6;

            if (ii instanceof NotificationShow) {
                NotificationShow ns = (NotificationShow) ii;
                System.out.println(ns.message.prettyPrint(0));
            }

            if (xx < maxx) {
                xx++;
            }
            else {
                yy++;
                xx = 0;
            }
        }


        // ------------ Main Part END ------------




        DataOutputStream out = new DataOutputStream(new FileOutputStream("auto-generated.flo"));

        ObjectWriter b = new ObjectWriter(out);
        writeFileHeader(b);


        blocksnew.sort(BlockType.comparator); // Sort before writing
        for (int length = blocksnew.size(), ii = 0; ii < length; ++ii) {
            b.writeObject(blocksnew.get(ii));
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

    public static AbstractStatement generateBlock(String classname, int x, int y) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        x = x * 8;
        y = y * 6;
        lastStmtId++;
        AbstractStatement blk = (AbstractStatement) ((Class<? extends BlockType>) Class.forName(classname)).newInstance();

        blk.x = x;
        blk.y = y;
        blk.id = lastStmtId;

        return blk;
    }

    public static AutomateField generateFieldValue(String classname) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        AutomateField field = (AutomateField) ((Class<? extends AutomateField>) Class.forName(classname)).newInstance();

        return field;
    }

    public static DataInputStream getData(String file) throws IOException {
        return new DataInputStream(new ByteArrayInputStream(new FileInputStream(file).readAllBytes()));
    }



}
