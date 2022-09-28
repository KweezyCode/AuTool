package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.IntermittentAction;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public final class LocationGet extends IntermittentAction // implements AsyncStatement
{
    public AutomateField maxFixAge;
    public AutomateField minDistance;
    public AutomateField provider;
    public VariableName varFixAccuracy;
    public VariableName varFixAltitude;
    public VariableName varFixBearing;
    public VariableName varFixLatitude;
    public VariableName varFixLongitude;
    public VariableName varFixProvider;
    public VariableName varFixSpeed;
    public VariableName varFixTimestamp;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.I(a, 22);
        this.provider = a.readObject();
        this.maxFixAge = a.readObject();
        if (22 <= a.version()) {
            this.minDistance = a.readObject();
        }
        this.varFixLatitude = a.readObject();
        this.varFixLongitude = a.readObject();
        if (41 <= a.version()) {
            this.varFixAltitude = a.readObject();
            this.varFixBearing = a.readObject();
            this.varFixSpeed = a.readObject();
            this.varFixAccuracy = a.readObject();
        }
        if (51 <= a.version()) {
            this.varFixTimestamp = a.readObject();
            this.varFixProvider = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.J(b, 22);
        b.writeObject(this.provider);
        b.writeObject(this.maxFixAge);
        if (22 <= b.version()) {
            b.writeObject(this.minDistance);
        }
        b.writeObject(this.varFixLatitude);
        b.writeObject(this.varFixLongitude);
        if (41 <= b.version()) {
            b.writeObject(this.varFixAltitude);
            b.writeObject(this.varFixBearing);
            b.writeObject(this.varFixSpeed);
            b.writeObject(this.varFixAccuracy);
        }
        if (51 <= b.version()) {
            b.writeObject(this.varFixTimestamp);
            b.writeObject(this.varFixProvider);
        }
    }
}
