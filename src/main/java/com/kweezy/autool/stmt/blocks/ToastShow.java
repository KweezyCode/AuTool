package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;

import java.io.IOException;

public final class ToastShow extends Action {

    public AutomateField duration;
    public AutomateField message;

    @Override
    public void readData(final ObjectReader reader) throws IOException {
        super.readData(reader); // Reads header: id, x, y, onComplete
        this.message = reader.readObject();
        if (46 <= reader.version()) {
            this.duration = reader.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter writer) throws IOException {
        super.writeData(writer);
        writer.writeObject(this.message);
        if (46 <= writer.version()) {
            writer.writeObject(this.duration);
        }
    }

}
