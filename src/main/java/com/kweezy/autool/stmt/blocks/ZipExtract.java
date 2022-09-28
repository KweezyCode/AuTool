package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public final class ZipExtract extends Action // implements AsyncStatement
{
    public AutomateField recursive;
    public AutomateField sourcePath;
    public AutomateField targetPath;
    public AutomateField zipFile;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.zipFile = a.readObject();
        this.targetPath = a.readObject();
        this.sourcePath = a.readObject();
        this.recursive = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.zipFile);
        b.writeObject(this.targetPath);
        b.writeObject(this.sourcePath);
        b.writeObject(this.recursive);
    }
}