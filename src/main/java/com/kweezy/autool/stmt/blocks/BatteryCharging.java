package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.IntermittentDecision;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public class BatteryCharging extends IntermittentDecision // implements ReceiverStatement
{
    public VariableName varUntilFullyCharged;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.varUntilFullyCharged = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.varUntilFullyCharged);
    }
}