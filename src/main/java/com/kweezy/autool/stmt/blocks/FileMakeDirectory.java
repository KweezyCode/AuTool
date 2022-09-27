package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public final class FileMakeDirectory extends Action // implements AsyncStatement
{
    public AutomateField path;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.path = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.path);
    }
}