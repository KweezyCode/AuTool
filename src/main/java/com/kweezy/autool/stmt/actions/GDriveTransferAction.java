package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class GDriveTransferAction extends GDriveAction {
    public AutomateField localPath;
    public AutomateField onlyNewerFiles;
    public AutomateField recursive;
    public AutomateField remotePath;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.localPath = a.readObject();
        this.remotePath = a.readObject();
        this.recursive = a.readObject();
        if (57 <= a.version()) {
            this.onlyNewerFiles = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.localPath);
        b.writeObject(this.remotePath);
        b.writeObject(this.recursive);
        if (57 <= b.version()) {
            b.writeObject(this.onlyNewerFiles);
        }
    }
}