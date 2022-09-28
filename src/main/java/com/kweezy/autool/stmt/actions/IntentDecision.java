package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class IntentDecision extends Decision {
    public AutomateField action;
    public AutomateField categories;
    public AutomateField className;
    public AutomateField extras;
    public AutomateField flags;
    public AutomateField mimeType;
    public AutomateField packageName;
    public AutomateField uri;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.packageName = a.readObject();
        this.className = a.readObject();
        this.action = a.readObject();
        this.uri = a.readObject();
        this.mimeType = a.readObject();
        this.categories = a.readObject();
        this.extras = a.readObject();
        if (73 <= a.version()) {
            this.flags = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.packageName);
        b.writeObject(this.className);
        b.writeObject(this.action);
        b.writeObject(this.uri);
        b.writeObject(this.mimeType);
        b.writeObject(this.categories);
        b.writeObject(this.extras);
        if (73 <= b.version()) {
            b.writeObject(this.flags);
        }
    }
}
