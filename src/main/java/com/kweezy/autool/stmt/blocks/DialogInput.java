package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.ActivityDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.StringConstantValue;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public class DialogInput extends ActivityDecision {
    public AutomateField hint;
    public AutomateField inputType;
    public AutomateField prepopulate;
    public AutomateField regex;
    public AutomateField title;
    public VariableName varResultText;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.title = a.readObject();
        this.inputType = a.readObject();
        this.regex = a.readObject();
        if (75 > a.version() && this.regex == null) {
            this.regex = new StringConstantValue("(?s).*?\\S+.*");
        }
        if (79 <= a.version()) {
            this.hint = a.readObject();
        }
        if (31 <= a.version()) {
            this.prepopulate = a.readObject();
        }
        this.varResultText = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.title);
        b.writeObject(this.inputType);
        b.writeObject(this.regex);
        if (79 <= b.version()) {
            b.writeObject(this.hint);
        }
        if (31 <= b.version()) {
            b.writeObject(this.prepopulate);
        }
        b.writeObject(this.varResultText);
    }
}