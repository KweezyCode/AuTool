package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class EmailAction extends Action {
    public AutomateField attachments;
    public AutomateField bcc;
    public AutomateField cc;
    public AutomateField message;
    public AutomateField subject;
    public AutomateField to;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.to = a.readObject();
        this.cc = a.readObject();
        this.bcc = a.readObject();
        this.subject = a.readObject();
        this.message = a.readObject();
        this.attachments = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.to);
        b.writeObject(this.cc);
        b.writeObject(this.bcc);
        b.writeObject(this.subject);
        b.writeObject(this.message);
        b.writeObject(this.attachments);
    }
}
