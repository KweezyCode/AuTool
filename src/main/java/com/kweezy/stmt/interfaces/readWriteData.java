package com.kweezy.stmt.interfaces;

import com.kweezy.ObjectReader;
import com.kweezy.ObjectWriter;

import java.io.IOException;

public interface readWriteData {
    void readData(final ObjectReader reader) throws IOException;

    void writeData(final ObjectWriter writer) throws IOException;

}
