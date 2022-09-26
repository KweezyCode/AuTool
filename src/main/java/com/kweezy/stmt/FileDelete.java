package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.actions.Action;
import com.kweezy.stmt.interfaces.AutomateField;

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
