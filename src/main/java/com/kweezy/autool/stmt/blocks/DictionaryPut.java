package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.Formatting;
import com.kweezy.autool.stmt.actions.DictionarySubscriptAction;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.interfaces.customValue;
import com.kweezy.autool.stmt.types.ConversionType;
import com.kweezy.autool.stmt.types.StringConstantValue;

import java.io.IOException;

public final class DictionaryPut extends DictionarySubscriptAction {
    public AutomateField type;
    public AutomateField value;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.value = a.readObject();
        if (79 <= a.version()) {
            this.type = a.readObject();
        }
        else {
            final ConversionType object = ConversionType.readObject(a);
            if (object != null) {
                this.type = new StringConstantValue(object.name());
            }
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.value);
        if (79 <= b.version()) {
            b.writeObject(this.type);
        }
        else {
            final AutomateField type = this.type;
            final boolean b2 = type instanceof customValue;
            ConversionType forName = null;
            if (b2) {
                forName = ConversionType.forName(Formatting.T0(type, null));
            }
            ConversionType.writeObject(b, forName);
        }
    }

}
