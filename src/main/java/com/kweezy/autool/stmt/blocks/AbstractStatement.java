package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.BlockType;

import java.io.IOException;

public class AbstractStatement implements BlockType {
    public long id;
    public int x;
    public int y;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        this.id = a.transform_63();
        this.x = a.transform_35();
        this.y = a.transform_35();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        b.transform_63(this.id);
        b.transform_35(this.x);
        b.transform_35(this.y);
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
