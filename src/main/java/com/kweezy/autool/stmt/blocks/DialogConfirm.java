package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.ActivityDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.HexNumber;

import java.io.IOException;

public final class DialogConfirm extends ActivityDecision {
    public AutomateField linkify;
    public AutomateField message;
    public AutomateField negative;
    public AutomateField positive;
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
        if (5 <= a.version()) {
            this.positive = a.readObject();
            this.negative = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.title);
        b.writeObject(this.message);
        if (90 <= b.version()) {
            b.writeObject(this.linkify);
        }
        if (5 <= b.version()) {
            b.writeObject(this.positive);
            b.writeObject(this.negative);
        }
    }
}

