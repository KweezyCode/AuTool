package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

// Block is ready
public final class FileWrite extends Action // implements AsyncStatement
{
    public AutomateField append;
    public AutomateField charset;
    public AutomateField content;
    public AutomateField decode;
    public AutomateField targetFile;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.targetFile = a.readObject();
        this.charset = a.readObject();
        if (82 <= a.version()) {
            this.decode = a.readObject();
        }
        this.append = a.readObject();
        this.content = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.targetFile);
        b.writeObject(this.charset);
        if (82 <= b.version()) {
            b.writeObject(this.decode);
        }
        b.writeObject(this.append);
        b.writeObject(this.content);
    }

}