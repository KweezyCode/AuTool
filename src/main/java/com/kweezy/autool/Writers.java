package com.kweezy.autool;

import java.io.*;

public class Writers extends FilterOutputStream implements DataOutput
{
    private final byte[] x0;

    public Writers(final OutputStream out) {
        super(out);
        this.x0 = new byte[8];
    }

    private static byte[] a(final String s, int i) throws UTFDataFormatException {
        final int length = s.length();
        final int n = 0;
        long n2 = 0L;
        for (int j = 0; j < length; ++j) {
            final char char1 = s.charAt(j);
            long n3;
            if (char1 != '\0' && char1 <= '\u007f') {
                n3 = 1L;
            }
            else if (char1 <= '\u07ff') {
                n3 = 2L;
            }
            else {
                n3 = 3L;
            }
            n2 += n3;
            if (n2 > i) {
                final StringBuilder sb = new StringBuilder();
                sb.append("String more than ");
                sb.append(i);
                sb.append(" UTF bytes long");
                throw new UTFDataFormatException(sb.toString());
            }
        }
        final byte[] array = new byte[(int)n2];
        i = 0;
        for (int k = n; k < length; ++k) {
            final char char2 = s.charAt(k);
            if (char2 != '\0' && char2 <= '\u007f') {
                final int n4 = i + 1;
                array[i] = (byte)char2;
                i = n4;
            }
            else {
                final int n5 = i + 1;
                if (char2 <= '\u07ff') {
                    array[i] = (byte)((char2 >> 6 & 0x1F) | 0xC0);
                    i = n5 + 1;
                    array[n5] = (byte)((char2 & '?') | 0x80);
                }
                else {
                    array[i] = (byte)((char2 >> 12 & 0xF) | 0xE0);
                    final int n6 = n5 + 1;
                    array[n5] = (byte)((char2 >> 6 & 0x3F) | 0x80);
                    i = n6 + 1;
                    array[n6] = (byte)((char2 & '?') | 0x80);
                }
            }
        }
        return array;
    }

    public void writeString(final String s) throws IOException {
        final byte[] a = a(s, Integer.MAX_VALUE);
        this.unsigned_35(a.length);
        this.write(a);
    }

    @Override
    public void close() throws IOException {
        super.out.close();
    }

    public void writeStringShort(final String s) throws IOException {
        final byte[] a = a(s, 65535);
        this.writeShort((short)a.length);
        this.write(a);
    }

    public void transform_35(final int n) throws IOException {
        this.unsigned_35(n >> 31 ^ n << 1);
    }

    public void transform_63(final long n) throws IOException {
        this.unsigned_63(n >> 63 ^ n << 1);
    }

    public void unsigned_35(int n) throws IOException {
        while ((n & 0xFFFFFF80) != 0x0L) {
            this.write((n & 0x7F) | 0x80);
            n >>>= 7;
        }
        this.write(n & 0x7F);
    }

    public void unsigned_63(long n) throws IOException {
        while ((0xFFFFFFFFFFFFFF80L & n) != 0x0L) {
            this.write(((int)n & 0x7F) | 0x80);
            n >>>= 7;
        }
        this.write((int)n & 0x7F);
    }

    @Override
    public void write(final byte[] b, final int off, final int len) throws IOException {
        super.out.write(b, off, len);
    }

    @Override
    public void writeBoolean(final boolean b) throws IOException {
        this.write(b ? 1 : 0);
    }

    @Override
    public void writeByte(final int b) throws IOException {
        this.write(b);
    }

    @Override
    public void writeBytes(final String s) throws IOException {
        int length = s.length();
        if (length != 0) {
            final byte[] b = new byte[length];
            int index = 0;
            while (--length >= 0) {
                b[index] = (byte)s.charAt(index);
                ++index;
            }
            this.write(b);
        }
    }

    @Override
    public void writeChar(final int n) throws IOException {
        this.writeShort(n);
    }

    @Override
    public void writeChars(final String s) throws IOException {
        this.write(s.getBytes("UTF-16BE"));
    }

    @Override
    public void writeUTF(String s) throws IOException {

    }

    @Override
    public void writeDouble(final double value) throws IOException {
        this.writeLong(Double.doubleToLongBits(value));
    }

    @Override
    public void writeFloat(final float value) throws IOException {
        this.writeInt(Float.floatToIntBits(value));
    }

    @Override
    public void writeInt(final int n) throws IOException {
        final byte[] x0 = this.x0;
        x0[0] = (byte)(n >> 24 & 0xFF);
        x0[1] = (byte)(n >> 16 & 0xFF);
        x0[2] = (byte)(n >> 8 & 0xFF);
        x0[3] = (byte)(n & 0xFF);
        this.write(x0, 0, 4);
    }

    @Override
    public void writeLong(final long n) throws IOException {
        final int n2 = (int)(n >> 32);
        final byte[] x0 = this.x0;
        x0[0] = (byte)(n2 >> 24 & 0xFF);
        x0[1] = (byte)(n2 >> 16 & 0xFF);
        x0[2] = (byte)(n2 >> 8 & 0xFF);
        x0[3] = (byte)(n2 & 0xFF);
        final int n3 = (int)n;
        x0[4] = (byte)(n3 >> 24 & 0xFF);
        x0[5] = (byte)(n3 >> 16 & 0xFF);
        x0[6] = (byte)(n3 >> 8 & 0xFF);
        x0[7] = (byte)(n3 & 0xFF);
        this.write(x0, 0, 8);
    }

    @Override
    public void writeShort(final int n) throws IOException {
        final byte[] x0 = this.x0;
        x0[0] = (byte)(n >> 8 & 0xFF);
        x0[1] = (byte)(n & 0xFF);
        this.write(x0, 0, 2);
    }
}