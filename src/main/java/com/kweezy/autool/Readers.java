package com.kweezy.autool;

import java.io.*;

public class Readers extends FilterInputStream implements DataInput {
    private final byte[] x0;

    public Readers(final InputStream in) {
        super(in);
        this.x0 = new byte[8];
    }

    private static String g(final DataInput dataInput, final int n) throws IOException {
        final byte[] array = new byte[n];
        dataInput.readFully(array);
        final char[] value = new char[n];
        int i = 0;
        int count = 0;
        while (i < n) {
            final int j = i + 1;
            if ((value[count] = (char)array[i]) < '\u0080') {
                ++count;
                i = j;
            }
            else {
                final char c = value[count];
                int n3;
                int n4;
                if ((c & '\u00e0') == 0xC0) {
                    if (j >= n) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Bad second byte at ");
                        sb.append(j);
                        throw new UTFDataFormatException(sb.toString());
                    }
                    final int n2 = j + 1;
                    final byte b = array[j];
                    if ((b & 0xC0) != 0x80) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Bad second byte at ");
                        sb2.append(n2 - 1);
                        throw new UTFDataFormatException(sb2.toString());
                    }
                    n3 = count + 1;
                    value[count] = (char)((c & '\u001f') << 6 | (b & 0x3F));
                    n4 = n2;
                }
                else {
                    if ((c & '\u00f0') != 0xE0) {
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("Bad byte at ");
                        sb3.append(j - 1);
                        throw new UTFDataFormatException(sb3.toString());
                    }
                    final int k = j + 1;
                    if (k >= n) {
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("Bad third byte at ");
                        sb4.append(k);
                        throw new UTFDataFormatException(sb4.toString());
                    }
                    final byte b2 = array[j];
                    final int n5 = k + 1;
                    final byte b3 = array[k];
                    if ((b2 & 0xC0) != 0x80 || (b3 & 0xC0) != 0x80) {
                        final StringBuilder sb5 = new StringBuilder();
                        sb5.append("Bad second or third byte at ");
                        sb5.append(n5 - 2);
                        throw new UTFDataFormatException(sb5.toString());
                    }
                    n3 = count + 1;
                    value[count] = (char)((c & '\u000f') << 12 | (b2 & 0x3F) << 6 | (b3 & 0x3F));
                    n4 = n5;
                }
                final int n6 = n3;
                i = n4;
                count = n6;
            }
        }
        return new String(value, 0, count);
    }

    public String readString() throws IOException {
        return g(this, this.unsigned_35());
    }

    public String readStringShort() throws IOException {
        return g(this, this.readUnsignedShort());
    }

    public int transform_35() throws IOException {
        final int h = this.unsigned_35();
        return (h & Integer.MIN_VALUE) ^ (h << 31 >> 31 ^ h) >> 1;
    }

    public long transform_63() throws IOException {
        final long i = this.unsigned_63();
        return (i & Long.MIN_VALUE) ^ (i << 63 >> 63 ^ i) >> 1;
    }

    public int unsigned_35() throws IOException {
        int n = 0;
        int n2 = 0;
        while (true) {
            final byte byte1 = this.readByte();
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

    public long unsigned_63() throws IOException {
        long n2;
        long n = n2 = 0L;
        while (true) {
            final long n3 = this.readByte();
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

    @Override
    public boolean readBoolean() throws IOException {
        return this.readUnsignedByte() != 0;
    }

    @Override
    public byte readByte() throws IOException {
        return (byte)this.readUnsignedByte();
    }

    @Override
    public char readChar() throws IOException {
        return (char)this.readShort();
    }

    @Override
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public void readFully(final byte[] array) throws IOException {
        this.readFully(array, 0, array.length);
    }

    @Override
    public void readFully(final byte[] b, int off, int i) throws IOException {
        while (i != 0) {
            final int read = this.read(b, off, i);
            if (read < 0) {
                throw new EOFException();
            }
            off += read;
            i -= read;
        }
    }

    @Override
    public int readInt() throws IOException {
        this.readFully(this.x0, 0, 4);
        final byte[] x0 = this.x0;
        return (x0[3] & 0xFF) | ((x0[0] & 0xFF) << 24 | (x0[1] & 0xFF) << 16 | (x0[2] & 0xFF) << 8);
    }

    @Deprecated
    @Override
    public String readLine() {
        throw new UnsupportedOperationException();
    }


    @Override
    public String readUTF() throws IOException {
        return null;
    }

    @Override
    public long readLong() throws IOException {
        this.readFully(this.x0, 0, 8);
        final byte[] x0 = this.x0;
        return (long)((long) (x0[0] & 0xFF) << 24 | (x0[1] & 0xFF) << 16 | (x0[2] & 0xFF) << 8 | (x0[3] & 0xFF)) << 32 | ((long)((x0[7] & 0xFF) | ((x0[6] & 0xFF) << 8 | ((x0[4] & 0xFF) << 24 | (x0[5] & 0xFF) << 16))) & 0xFFFFFFFFL);
    }

    @Override
    public short readShort() throws IOException {
        this.readFully(this.x0, 0, 2);
        final byte[] x0 = this.x0;
        return (short)((x0[1] & 0xFF) | x0[0] << 8);
    }

    @Override
    public int readUnsignedByte() throws IOException {
        final int read = this.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    @Override
    public int readUnsignedShort() throws IOException {
        return this.readShort() & 0xFFFF;
    }

    @Override
    public int skipBytes(final int n) throws IOException {
        int i;
        long skip;
        for (i = 0; i < n; i += (int)skip) {
            skip = this.skip(n - i);
            if (skip <= 0L) {
                break;
            }
        }
        return i;
    }
}
