package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public final class HttpRequest extends Action // implements AsyncStatement
{
    public AutomateField account;
    public AutomateField bodyPart;
    public AutomateField bodyPath;
    public AutomateField contentType;
    public AutomateField dontRedirect;
    public AutomateField headers;
    public AutomateField method;
    public AutomateField networkInterface;
    public AutomateField responsePath;
    public AutomateField saveResponse;
    public AutomateField timeout;
    public AutomateField trust;
    public AutomateField url;
    public VariableName varResponseBody;
    public VariableName varResponseCode;
    public VariableName varResponseHeaders;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        if (74 <= a.version()) {
            this.networkInterface = a.readObject();
        }
        this.url = a.readObject();
        this.method = a.readObject();
        this.account = a.readObject();
        if (82 <= a.version()) {
            this.timeout = a.readObject();
        }
        if (45 <= a.version()) {
            this.trust = a.readObject();
        }
        if (47 <= a.version()) {
            this.dontRedirect = a.readObject();
        }
        this.contentType = a.readObject();
        this.bodyPart = a.readObject();
        if (82 <= a.version()) {
            this.bodyPath = a.readObject();
        }
        if (35 <= a.version()) {
            this.headers = a.readObject();
        }
        this.saveResponse = a.readObject();
        this.responsePath = a.readObject();
        this.varResponseCode = a.readObject();
        this.varResponseBody = a.readObject();
        if (35 <= a.version()) {
            this.varResponseHeaders = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        if (74 <= b.version()) {
            b.writeObject(this.networkInterface);
        }
        b.writeObject(this.url);
        b.writeObject(this.method);
        b.writeObject(this.account);
        if (82 <= b.version()) {
            b.writeObject(this.timeout);
        }
        if (45 <= b.version()) {
            b.writeObject(this.trust);
        }
        if (47 <= b.version()) {
            b.writeObject(this.dontRedirect);
        }
        b.writeObject(this.contentType);
        b.writeObject(this.bodyPart);
        if (82 <= b.version()) {
            b.writeObject(this.bodyPath);
        }
        if (35 <= b.version()) {
            b.writeObject(this.headers);
        }
        b.writeObject(this.saveResponse);
        b.writeObject(this.responsePath);
        b.writeObject(this.varResponseCode);
        b.writeObject(this.varResponseBody);
        if (35 <= b.version()) {
            b.writeObject(this.varResponseHeaders);
        }
    }
}