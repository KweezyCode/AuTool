package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.AutomateNumber;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public final class ContentQuery extends Action // implements AsyncStatement
{
    public AutomateField limit;
    public AutomateField offset;
    public AutomateField parameters;
    public AutomateField projection;
    public AutomateField resultType;
    public AutomateField selection;
    public AutomateField sortOrder;
    public AutomateField uri;
    public VariableName varResult;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.uri = a.readObject();
        this.projection = a.readObject();
        this.selection = a.readObject();
        if (68 <= a.version()) {
            this.parameters = a.readObject();
        }
        this.sortOrder = a.readObject();
        this.offset = a.readObject();
        this.limit = a.readObject();
        AutomateField resultType;
        if (68 <= a.version()) {
            resultType = a.readObject();
        }
        else {
            resultType = new AutomateNumber(2);
        }
        this.resultType = resultType;
        this.varResult = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.uri);
        b.writeObject(this.projection);
        b.writeObject(this.selection);
        if (68 <= b.version()) {
            b.writeObject(this.parameters);
        }
        b.writeObject(this.sortOrder);
        b.writeObject(this.offset);
        b.writeObject(this.limit);
        if (68 <= b.version()) {
            b.writeObject(this.resultType);
        }
        b.writeObject(this.varResult);
    }
}