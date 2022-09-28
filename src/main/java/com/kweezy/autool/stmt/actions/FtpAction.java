package com.kweezy.autool.stmt.actions;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public abstract class FtpAction extends Action // implements AsyncStatement
{
    public AutomateField account;
    public AutomateField charset;
    public AutomateField host;
    public AutomateField port;
    public AutomateField prot;
    public AutomateField security;
    public AutomateField trust;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.host = a.readObject();
        this.port = a.readObject();
        this.security = a.readObject();
        if (26 <= a.version()) {
            this.trust = a.readObject();
        }
        if (85 <= a.version()) {
            this.prot = a.readObject();
        }
        this.account = a.readObject();
        this.charset = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.host);
        b.writeObject(this.port);
        b.writeObject(this.security);
        if (26 <= b.version()) {
            b.writeObject(this.trust);
        }
        if (85 <= b.version()) {
            b.writeObject(this.prot);
        }
        b.writeObject(this.account);
        b.writeObject(this.charset);
    }
}
