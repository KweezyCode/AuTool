package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public final class BroadcastReceive extends Action // implements ReceiverStatement
{
    public AutomateField action;
    public AutomateField categories;
    public AutomateField mimeType;
    public AutomateField uriAuthority;
    public AutomateField uriPath;
    public AutomateField uriScheme;
    public AutomateField useSticky;
    public VariableName varBroadcastAction;
    public VariableName varBroadcastCategories;
    public VariableName varBroadcastExtras;
    public VariableName varBroadcastMimeType;
    public VariableName varBroadcastUri;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.action = a.readObject();
        this.categories = a.readObject();
        this.uriScheme = a.readObject();
        this.uriAuthority = a.readObject();
        this.uriPath = a.readObject();
        this.mimeType = a.readObject();
        this.useSticky = a.readObject();
        this.varBroadcastAction = a.readObject();
        this.varBroadcastCategories = a.readObject();
        this.varBroadcastUri = a.readObject();
        this.varBroadcastMimeType = a.readObject();
        this.varBroadcastExtras = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.action);
        b.writeObject(this.categories);
        b.writeObject(this.uriScheme);
        b.writeObject(this.uriAuthority);
        b.writeObject(this.uriPath);
        b.writeObject(this.mimeType);
        b.writeObject(this.useSticky);
        b.writeObject(this.varBroadcastAction);
        b.writeObject(this.varBroadcastCategories);
        b.writeObject(this.varBroadcastUri);
        b.writeObject(this.varBroadcastMimeType);
        b.writeObject(this.varBroadcastExtras);
    }
}