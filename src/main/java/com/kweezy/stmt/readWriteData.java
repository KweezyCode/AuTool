package com.kweezy.stmt;

import com.kweezy.ObjectReader;

import java.io.IOException;

public interface readWriteData {
    void readData(final ObjectReader p0) throws IOException;

    //void writeBlockData(final ObjectWriter p0); // TODO: writer

}
