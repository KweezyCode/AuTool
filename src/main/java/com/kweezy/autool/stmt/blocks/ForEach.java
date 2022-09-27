package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.interfaces.BlockType;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public class ForEach extends Action // implements b3
{
    private int c4;
    public AutomateField container;
    private int d4;
    private int e4;

    public BlockType onEachElement;
    public AutomateField until;
    public VariableName varEntryIndex;
    public VariableName varEntryKey;
    public VariableName varEntryValue;

    public ForEach() {
        this.c4 = -1;
        this.d4 = -1;
        this.e4 = -1;
    }
    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.onEachElement = a.readObject();
        this.container = a.readObject();
        if (47 <= a.version()) {
            this.until = a.readObject();
        }
        this.varEntryValue = a.readObject();
        this.varEntryIndex = a.readObject();
        this.varEntryKey = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.onEachElement);
        b.writeObject(this.container);
        if (47 <= b.version()) {
            b.writeObject(this.until);
        }
        b.writeObject(this.varEntryValue);
        b.writeObject(this.varEntryIndex);
        b.writeObject(this.varEntryKey);
    }

}