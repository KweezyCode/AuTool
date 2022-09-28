package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;
import java.util.regex.Pattern;

public final class ContentView extends Action {
    private static final Pattern c4;
    public AutomateField chooser;
    public AutomateField mimeType;
    public AutomateField packageName;
    public AutomateField uri;

    static {
        c4 = Pattern.compile("/events/([0-9]+)(?:/EventTime/([0-9]+)/([0-9]+))?");
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.uri = a.readObject();
        this.mimeType = a.readObject();
        if (91 <= a.version()) {
            this.packageName = a.readObject();
        }
        this.chooser = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.uri);
        b.writeObject(this.mimeType);
        if (91 <= b.version()) {
            b.writeObject(this.packageName);
        }
        b.writeObject(this.chooser);
    }
}
