package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.ActivityDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public class DialogChoice extends ActivityDecision // implements b3
{
    private int c4;
    public AutomateField choices;
    public AutomateField multiselect;
    public AutomateField noselect;
    public AutomateField preselected;
    public AutomateField sort;
    public AutomateField title;
    public VariableName varSelectedIndices;

    public DialogChoice() {
        this.c4 = -1;
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.title = a.readObject();
        this.choices = a.readObject();
        this.multiselect = a.readObject();
        if (60 <= a.version()) {
            this.noselect = a.readObject();
        }
        if (36 <= a.version()) {
            this.preselected = a.readObject();
        }
        this.sort = a.readObject();
        this.varSelectedIndices = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.title);
        b.writeObject(this.choices);
        b.writeObject(this.multiselect);
        if (60 <= b.version()) {
            b.writeObject(this.noselect);
        }
        if (36 <= b.version()) {
            b.writeObject(this.preselected);
        }
        b.writeObject(this.sort);
        b.writeObject(this.varSelectedIndices);
    }
}
