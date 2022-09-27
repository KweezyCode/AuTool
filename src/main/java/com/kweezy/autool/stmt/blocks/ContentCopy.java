package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.types.VariableName;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

// Block is ready
public class ContentCopy extends Action // implements AsyncStatement
{
    public AutomateField sourceUri;
    public AutomateField targetPath;
    public VariableName varContentDisplayName;
    public VariableName varContentFile;
    public VariableName varContentMimeType;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.sourceUri = a.readObject();
        this.targetPath = a.readObject();
        this.varContentFile = a.readObject();
        this.varContentDisplayName = a.readObject();
        this.varContentMimeType = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.sourceUri);
        b.writeObject(this.targetPath);
        b.writeObject(this.varContentFile);
        b.writeObject(this.varContentDisplayName);
        b.writeObject(this.varContentMimeType);
    }
}