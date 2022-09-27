package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public final class ImageCrop extends Action // implements AsyncStatement
{
    public AutomateField croppedHeight;
    public AutomateField croppedLeft;
    public AutomateField croppedTop;
    public AutomateField croppedWidth;
    public VariableName varResultHeight;
    public VariableName varResultWidth;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.croppedLeft = a.readObject();
        this.croppedTop = a.readObject();
        this.croppedWidth = a.readObject();
        this.croppedHeight = a.readObject();
        this.varResultWidth = a.readObject();
        this.varResultHeight = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.croppedLeft);
        b.writeObject(this.croppedTop);
        b.writeObject(this.croppedWidth);
        b.writeObject(this.croppedHeight);
        b.writeObject(this.varResultWidth);
        b.writeObject(this.varResultHeight);
    }
}