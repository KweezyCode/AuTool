package com.kweezy.autool.stmt.types.fieldcount;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class ThreeFields implements AutomateField
{
    public AutomateField first;
    public AutomateField second;
    public AutomateField third;

    public ThreeFields() {
    }

    public ThreeFields(final AutomateField first, final AutomateField second, final AutomateField third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        this.first = a.readObject();
        this.third = a.readObject();
        this.second = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        b.writeObject(this.first);
        b.writeObject(this.third);
        b.writeObject(this.second);
    }

    protected void b(final ObjectReader a, final int n) throws IOException {
        this.first = a.readObject();
        this.third = a.readObject();
        if (n <= a.version()) {
            this.second = a.readObject();
        }
    }

    protected void d(final ObjectWriter b, final int n) throws IOException {
        b.writeObject(this.first);
        b.writeObject(this.third);
        if (n <= b.version()) {
            b.writeObject(this.second);
        }
    }
}

