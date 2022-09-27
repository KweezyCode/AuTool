package com.kweezy.autool.stmt.blocks;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;
import com.kweezy.autool.stmt.actions.IntermittentDecision;
import com.kweezy.autool.stmt.interfaces.AutomateField;
import com.kweezy.autool.stmt.types.VariableName;

import java.io.IOException;

// Block is ready
public class NotificationShow extends IntermittentDecision // implements AsyncStatement, IntentStatement
{
    @Deprecated
    private AutomateField c4;
    public AutomateField cancellable;
    public AutomateField category;
    public AutomateField channelId;
    @Deprecated
    private AutomateField d4;
    @Deprecated
    private AutomateField e4;
    @Deprecated
    private AutomateField f4;
    @Deprecated
    private AutomateField g4;
    public AutomateField icon;
    public AutomateField message;
    public AutomateField ongoing;
    public AutomateField personUri;
    public AutomateField pictureUri;
    public AutomateField progress;
    public AutomateField title;
    public VariableName varKey;
    public AutomateField visibility;

    @Override
    public void readData(final ObjectReader a) throws IOException {
        super.readContinuity(a, 68);
        if (68 > a.version()) {
            super.onNegative = super.onPositive;
        }
        this.title = a.readObject();
        this.message = a.readObject();
        if (79 <= a.version()) {
            this.pictureUri = a.readObject();
            this.personUri = a.readObject();
        }
        if (47 <= a.version()) {
            this.icon = a.readObject();
        }
        this.cancellable = a.readObject();
        if (17 <= a.version()) {
            this.ongoing = a.readObject();
        }
        if (77 > a.version()) {
            this.c4 = a.readObject();
        }
        if (35 <= a.version()) {
            this.visibility = a.readObject();
            this.category = a.readObject();
        }
        if (77 <= a.version()) {
            this.channelId = a.readObject();
        } else {
            this.d4 = a.readObject();
            this.e4 = a.readObject();
            if (21 <= a.version()) {
                this.f4 = a.readObject();
            }
            this.g4 = a.readObject();
        }
        this.progress = a.readObject();
        // if (79 > a.version()) { // TODO: Not implemented
        //     final AutomateField progress = this.progress;
        //     if (progress != null) {
        //         Object progress2;
        //         if (progress instanceof i) {
        //             if (com.llamalab.automate.expr.h.h0(progress)) {
        //                 progress2 = new j0(-1);
        //             } else {
        //                 progress2 = null;
        //             }
        //         } else {
        //             progress2 = new n(this.progress, new j0(-1), i0.x0);
        //         }
        //         this.progress = (AutomateField) progress2;
        //     }
        // }
        if (16 <= a.version()) {
            this.varKey = a.readObject();
        }
    }

    @Override
    public void writeData(final ObjectWriter b) throws IOException {
        super.W(b, 68);
        b.writeObject(this.title);
        b.writeObject(this.message);
        if (79 <= b.version()) {
            b.writeObject(this.pictureUri);
            b.writeObject(this.personUri);
        }
        if (47 <= b.version()) {
            b.writeObject(this.icon);
        }
        b.writeObject(this.cancellable);
        if (17 <= b.version()) {
            b.writeObject(this.ongoing);
        }
        if (77 > b.version()) {
            b.writeObject(null);
        }
        if (35 <= b.version()) {
            b.writeObject(this.visibility);
            b.writeObject(this.category);
        }
        if (77 <= b.version()) {
            b.writeObject(this.channelId);
        }
        else {
            b.writeObject(null);
            b.writeObject(null);
            if (21 <= b.version()) {
                b.writeObject(null);
            }
            b.writeObject(null);
        }
        b.writeObject(this.progress);
        if (16 <= b.version()) {
            b.writeObject(this.varKey);
        }
    }
}
