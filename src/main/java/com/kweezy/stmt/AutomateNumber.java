package com.kweezy.stmt;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;
import com.kweezy.stmt.interfaces.i;

import java.io.IOException;

public class AutomateNumber extends Number implements i<Double> {
    private double number;

    public AutomateNumber() {
    }
    public AutomateNumber(final double x0) {
        this.number = x0;
    }

    public AutomateNumber(final int n) {
        this.number = n;
    }

    public AutomateNumber(final boolean b) {
        this.number = Formatting.NumberToBoolean(b);
    }

    @Override
    public final void readData(final ObjectReader a) throws IOException {
        this.number = a.readDouble();
    }

    @Override
    public final void writeData(final ObjectWriter b) throws IOException {
        b.writeDouble(this.number);
    }

    // public Double b(final y0 y0) {
    //    return this.x0;
    // }


    @Override
    public final double doubleValue() {
        return this.number;
    }

    public final Double e() {
        return this.number;
    }

    @Override
    public float floatValue() {
        return (float)this.number;
    }

    @Override
    public final int intValue() {
        return (int)this.number;
    }

    @Override
    public final long longValue() {
        return (long)this.number;
    }

    @Override
    public String prettyPrint(final int n) {
        return Formatting.FormatNumber(this.number);
    }

    @Override
    public final String toString() {
        return Formatting.FormatNumber(this.number);
    }

    @Override
    public Double value() {
        return null;
    }
}
