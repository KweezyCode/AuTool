package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.y1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public final class Goto extends Action {
    private volatile Map<Object, Label> c4;
    public AutomateField labelValue;
    public y1<Label>[] labels;

    public Goto() {
        this.labels = (y1<Label>[]) y1.x0;
    }

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        int h = a.unsigned_35();
        this.labels = (y1<Label>[])new y1[h];
        int n = 0;
        while (--h >= 0) {
            this.labels[n] = new y1<Label>(a.readObject());
            ++n;
        }
        this.labelValue = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.unsigned_35(this.I());
        final y1<Label>[] labels = this.labels;
        for (int length = labels.length, i = 0; i < length; ++i) {
            b.writeObject(labels[i].d());
        }
        b.writeObject(this.labelValue);
    }

    private int I() {
        final y1<Label>[] labels = this.labels;
        final int length = labels.length;
        int i = 0;
        int newLength = 0;
        while (i < length) {
            final y1<Label> y1 = labels[i];
            int n = newLength;
            if (y1.d() != null) {
                labels[newLength] = y1;
                n = newLength + 1;
            }
            ++i;
            newLength = n;
        }
        if (newLength != length) {
            this.labels = Arrays.copyOf(labels, newLength);
        }
        return newLength;
    }
}
