package com.kweezy.stmt;

import com.kweezy.ObjectReader;

import java.io.IOException;
import java.util.Comparator;

public interface BlockType extends readWriteData {
    public static final BlockType[] d = new BlockType[0];

    public static final Comparator<BlockType> e = new Comparator<BlockType>() {
        public int compare(final BlockType f3, final BlockType f4) {
            final long a = f3.id();
            final long a2 = f4.id();
            int n;
            if (a < a2) {
                n = -1;
            }
            else if (a > a2) {
                n = 1;
            }
            else {
                n = 0;
            }
            return n;
        }
    };

    long id();

}
