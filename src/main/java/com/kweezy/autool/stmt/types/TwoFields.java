package com.kweezy.autool.stmt.types;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class TwoFields implements AutomateField
{
    public AutomateField first;
    public AutomateField second;

    public TwoFields() {
    }

    public TwoFields(final AutomateField first, final AutomateField second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        this.first = a.readObject();
        this.second = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        b.writeObject(this.first);
        b.writeObject(this.second);
    }

    protected final void b(final ObjectReader a, final int n) throws IOException {
        this.first = a.readObject();
        if (n <= a.version()) {
            this.second = a.readObject();
        }
    }

    protected final void d(final ObjectWriter b, final int n) throws IOException {
        b.writeObject(this.first);
        if (n <= b.version()) {
            b.writeObject(this.second);
        }
    }
}
