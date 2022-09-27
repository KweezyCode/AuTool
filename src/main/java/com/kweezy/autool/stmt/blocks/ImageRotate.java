package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public class ImageRotate extends Action // implements AsyncStatement
{
    public AutomateField rotation;
    public VariableName varResultHeight;
    public VariableName varResultWidth;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.rotation = a.readObject();
        this.varResultWidth = a.readObject();
        this.varResultHeight = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.rotation);
        b.writeObject(this.varResultWidth);
        b.writeObject(this.varResultHeight);
    }


}