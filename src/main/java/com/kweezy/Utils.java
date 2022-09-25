package com.kweezy;

import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.StreamCorruptedException;

public class Utils {
    private Utils() {
    }

    public static int transform_35(DataInput a) throws IOException {
        final int h = readULeb128_35(a);
        return (h & Integer.MIN_VALUE) ^ (h << 31 >> 31 ^ h) >> 1;
    }

    public static long transform_63(DataInput a) throws IOException {
        final long i = readULeb128_63(a);
        return (i & Long.MIN_VALUE) ^ (i << 63 >> 63 ^ i) >> 1;
    }

    public static int readULeb128_35(DataInput a) throws IOException {
        int n = 0;
        int n2 = 0;
        while (true) {
            final byte byte1 = a.readByte();
            if ((byte1 & 0x80) == 0x0) {
                return n | byte1 << n2;
            }
            n |= (byte1 & 0x7F) << n2;
            n2 += 7;
            if (n2 <= 35) {
                continue;
            }
            throw new StreamCorruptedException("Variable length quantity is too long (must be <= 35)");
        }
    }

    public static long readULeb128_63(DataInput a) throws IOException {
        long n2;
        long n = n2 = 0L;
        while (true) {
            final long n3 = a.readByte();
            if ((0x80L & n3) == 0x0L) {
                return n3 << (int)n2 | n;
            }
            n |= (n3 & 0x7FL) << (int)n2;
            n2 += 7L;
            if (n2 <= 63L) {
                continue;
            }
            throw new StreamCorruptedException("Variable length quantity is too long (must be <= 63)");
        }
    }

    public static int readSLeb128() {
        return 0;
    }
}
