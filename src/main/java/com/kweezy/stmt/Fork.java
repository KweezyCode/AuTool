package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.actions.Action;
import com.kweezy.stmt.interfaces.BlockType;

import java.io.IOException;

public class Fork extends Action {
    public BlockType onChildFiber;
    public boolean stopWithParent;
    public AutomateString varChildFiberUri;
    public AutomateString varParentFiberUri;


    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.onChildFiber = a.readObject();
        if (9 <= a.version()) {
            this.stopWithParent = a.readBoolean();
        }
        this.varChildFiberUri = a.readObject();
        if (23 <= a.version()) {
            this.varParentFiberUri = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.onChildFiber);
        if (9 <= b.version()) {
            b.writeBoolean(this.stopWithParent);
        }
        b.writeObject(this.varChildFiberUri);
        if (23 <= b.version()) {
            b.writeObject(this.varParentFiberUri);
        }
    }
}
