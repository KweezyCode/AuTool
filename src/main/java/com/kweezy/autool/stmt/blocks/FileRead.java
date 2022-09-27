package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public final class FileRead extends Action // implements AsyncStatement
{
    public AutomateField charset;
    public AutomateField sourceFile;
    public VariableName varContent;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.sourceFile = a.readObject();
        this.charset = a.readObject();
        this.varContent = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.sourceFile);
        b.writeObject(this.charset);
        b.writeObject(this.varContent);
    }
}