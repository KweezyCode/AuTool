package com.kweezy.autool.stmt.interfaces;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;

import java.io.IOException;

public interface readWriteData {
    void readData(final ObjectReader reader) throws IOException;

    void writeData(final ObjectWriter writer) throws IOException;

}
