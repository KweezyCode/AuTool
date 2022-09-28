package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.ActivityDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public final class CaptureImage extends ActivityDecision // implements b3, AsyncStatement
{
    private int c4;
    public AutomateField packageName;
    public AutomateField targetPath;
    public VariableName varImageFile;

    public CaptureImage() {
        this.c4 = -1;
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        if (80 <= a.version()) {
            this.packageName = a.readObject();
        }
        this.targetPath = a.readObject();
        this.varImageFile = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        if (80 <= b.version()) {
            b.writeObject(this.packageName);
        }
        b.writeObject(this.targetPath);
        b.writeObject(this.varImageFile);
    }
}