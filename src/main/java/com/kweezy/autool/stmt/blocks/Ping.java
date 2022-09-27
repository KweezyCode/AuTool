package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Decision;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public class Ping extends Decision // implements AsyncStatement
{
    public AutomateField host;
    public AutomateField networkInterface;
    public AutomateField protocol;
    public AutomateField timeout;
    public AutomateField ttl;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.host = a.readObject();
        if (74 <= a.version()) {
            this.protocol = a.readObject();
        }
        this.networkInterface = a.readObject();
        this.ttl = a.readObject();
        this.timeout = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.host);
        if (74 <= b.version()) {
            b.writeObject(this.protocol);
        }
        b.writeObject(this.networkInterface);
        b.writeObject(this.ttl);
        b.writeObject(this.timeout);
    }
}