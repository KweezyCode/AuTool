package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public final class FileDelete extends Action // implements AsyncStatement
{
    public AutomateField path;
    public AutomateField recursive;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.path = a.readObject();
        this.recursive = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.path);
        b.writeObject(this.recursive);
    }
}
