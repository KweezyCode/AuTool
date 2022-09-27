package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public class ImageSampleColor extends Action // implements AsyncStatement
{
    public AutomateField centerX;
    public AutomateField centerY;
    public AutomateField sampleSize;
    public VariableName varColorModel;
    public VariableName varSampledAlpha;
    public VariableName varSampledComponents;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.centerX = a.readObject();
        this.centerY = a.readObject();
        this.sampleSize = a.readObject();
        this.varColorModel = a.readObject();
        this.varSampledComponents = a.readObject();
        this.varSampledAlpha = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.centerX);
        b.writeObject(this.centerY);
        b.writeObject(this.sampleSize);
        b.writeObject(this.varColorModel);
        b.writeObject(this.varSampledComponents);
        b.writeObject(this.varSampledAlpha);
    }
}