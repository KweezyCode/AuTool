package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.ActivityDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public final class DialogWeb extends ActivityDecision {
    public AutomateField account;
    public AutomateField body;
    public AutomateField regex;
    public AutomateField url;
    public AutomateField userAgent;
    public VariableName varResultTitle;
    public VariableName varResultUrl;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.url = a.readObject();
        this.body = a.readObject();
        this.regex = a.readObject();
        this.account = a.readObject();
        if (79 <= a.version()) {
            this.userAgent = a.readObject();
        }
        this.varResultUrl = a.readObject();
        this.varResultTitle = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.url);
        b.writeObject(this.body);
        b.writeObject(this.regex);
        b.writeObject(this.account);
        if (79 <= b.version()) {
            b.writeObject(this.userAgent);
        }
        b.writeObject(this.varResultUrl);
        b.writeObject(this.varResultTitle);
    }
}
