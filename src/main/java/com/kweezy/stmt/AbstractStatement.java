package com.kweezy.stmt;

import com.kweezy.ObjectReader;

import java.io.DataInputStream;
import java.io.IOException;

public class AbstractStatement implements BlockType {
    private long id;
    private int x;
    private int y;
    private int onComplete;

    public void readBlockHeader(DataInputStream dis) throws IOException {
        id = dis.readInt();
        x = dis.readInt();
        y = dis.readInt();
        onComplete = dis.readInt();
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        this.id = a.transform_63();
        this.x = a.transform_35();
        this.y = a.transform_35();
    }

    @Override
    public final long id() {
        return this.id;
    }

    public final int x() {
        return this.x;
    }

    public final int y() {
        return this.y;
    }

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[statementId=");
        sb.append(this.id);
        sb.append(", cell={");
        sb.append(this.x);
        sb.append(",");
        sb.append(this.y);
        sb.append("}]");
        return sb.toString();
    }
}
