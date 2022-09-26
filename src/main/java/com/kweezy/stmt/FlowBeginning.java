package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.actions.Action;

import java.io.IOException;

public final class FlowBeginning extends Action {
    public boolean hidden;
    public boolean parallel;
    public String title;
    public AutomateString varFiberUri;
    public AutomateString varPayload;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.title = a.o();
        if (66 <= a.version()) {
            this.hidden = a.readBoolean();
        }
        this.parallel = a.readBoolean();
        this.varPayload = a.readObject();
        if (43 <= a.version()) {
            this.varFiberUri = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.r(this.title);
        if (66 <= b.version()) {
            b.writeBoolean(this.hidden);
        }
        b.writeBoolean(this.parallel);
        b.writeObject(this.varPayload);
        if (43 <= b.version()) {
            b.writeObject(this.varFiberUri);
        }
    }
}
