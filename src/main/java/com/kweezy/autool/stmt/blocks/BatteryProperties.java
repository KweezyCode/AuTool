package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Action;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public class BatteryProperties extends Action {
    public VariableName varCapacity;
    public VariableName varRemainingCharge;
    public VariableName varRemainingEnergy;
    public VariableName varRemainingPercent;
    public VariableName varTechnology;
    public VariableName varTemperature;
    public VariableName varUsageCurrentAverage;
    public VariableName varUsageCurrentNow;
    public VariableName varVoltage;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.varCapacity = a.readObject();
        this.varRemainingPercent = a.readObject();
        this.varRemainingCharge = a.readObject();
        this.varRemainingEnergy = a.readObject();
        this.varUsageCurrentNow = a.readObject();
        this.varUsageCurrentAverage = a.readObject();
        this.varVoltage = a.readObject();
        this.varTemperature = a.readObject();
        this.varTechnology = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.varCapacity);
        b.writeObject(this.varRemainingPercent);
        b.writeObject(this.varRemainingCharge);
        b.writeObject(this.varRemainingEnergy);
        b.writeObject(this.varUsageCurrentNow);
        b.writeObject(this.varUsageCurrentAverage);
        b.writeObject(this.varVoltage);
        b.writeObject(this.varTemperature);
        b.writeObject(this.varTechnology);
    }

}