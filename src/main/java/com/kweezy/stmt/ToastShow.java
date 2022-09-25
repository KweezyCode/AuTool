package com.kweezy.stmt;

import com.kweezy.ObjectReader;

import java.io.IOException;

public class ToastShow extends Action {

    public automateField duration;
    public automateField message;

    @Override
    public void readData(final ObjectReader reader) throws IOException {
        super.readData(reader); // Reads header: id, x, y, onComplete
        this.message = reader.readObject();
        if (46 <= reader.version()) {
            this.duration = reader.readObject();
        }
    }

    // @Override
    // public void writeBlockData(final ObjectWriter writer) {
    //     super.writeBlockData(writer);
    //     writer.writeObject(this.message);
    //     if (46 <= writer.version()) {
    //         writer.writeObject(this.duration);
    //     }
    // }

}
