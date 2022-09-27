package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public class ImageRescale extends Action // implements AsyncStatement
{
    public AutomateField scaledHeight;
    public AutomateField scaledWidth;
    public VariableName varResultHeight;
    public VariableName varResultWidth;

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.scaledWidth);
        b.writeObject(this.scaledHeight);
        b.writeObject(this.varResultWidth);
        b.writeObject(this.varResultHeight);
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.scaledWidth = a.readObject();
        this.scaledHeight = a.readObject();
        this.varResultWidth = a.readObject();
        this.varResultHeight = a.readObject();
    }
}