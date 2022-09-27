package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.ActivityAction;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.HexNumber;

import java.io.IOException;

public final class DialogMessage extends ActivityAction {
    public AutomateField dismiss;
    public AutomateField linkify;
    public AutomateField message;
    public AutomateField title;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.title = a.readObject();
        this.message = a.readObject();
        AutomateField linkify;
        if (90 <= a.version()) {
            linkify = a.readObject();
        }
        else {
            linkify = new HexNumber(15);
        }
        this.linkify = linkify;
        this.dismiss = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.title);
        b.writeObject(this.message);
        if (90 <= b.version()) {
            b.writeObject(this.linkify);
        }
        b.writeObject(this.dismiss);
    }

}