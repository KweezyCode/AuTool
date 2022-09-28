package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.Decision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

public class Weather extends Decision // implements AsyncStatement
{
    public AutomateField advance;
    public AutomateField latitude;
    public AutomateField longitude;
    public AutomateField period;
    public VariableName varCloudiness;
    public VariableName varForecastTime;
    public VariableName varHumidity;
    public VariableName varPressure;
    public VariableName varRain;
    public VariableName varSnow;
    public VariableName varTemperature;
    public VariableName varWindDirection;
    public VariableName varWindSpeed;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readData(a);
        this.latitude = a.readObject();
        this.longitude = a.readObject();
        this.advance = a.readObject();
        if (45 <= a.version()) {
            this.period = a.readObject();
        }
        this.varForecastTime = a.readObject();
        this.varTemperature = a.readObject();
        this.varHumidity = a.readObject();
        this.varPressure = a.readObject();
        this.varCloudiness = a.readObject();
        this.varWindSpeed = a.readObject();
        this.varWindDirection = a.readObject();
        this.varRain = a.readObject();
        this.varSnow = a.readObject();
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.writeData(b);
        b.writeObject(this.latitude);
        b.writeObject(this.longitude);
        b.writeObject(this.advance);
        if (45 <= b.version()) {
            b.writeObject(this.period);
        }
        b.writeObject(this.varForecastTime);
        b.writeObject(this.varTemperature);
        b.writeObject(this.varHumidity);
        b.writeObject(this.varPressure);
        b.writeObject(this.varCloudiness);
        b.writeObject(this.varWindSpeed);
        b.writeObject(this.varWindDirection);
        b.writeObject(this.varRain);
        b.writeObject(this.varSnow);
    }
}
