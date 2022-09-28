package com.kweezy.autool.stmt.functions;

import com.kweezy.autool.stmt.types.HashFunction;

import java.security.MessageDigest;

public final class Sha1 extends HashFunction
{
    public static final String NAME = "sha1";

    @Override
    public String getFunctionName() {
        return "sha1";
    }

    // @Override
    // protected byte[] f(final byte[] input) {
    //     return MessageDigest.getInstance("SHA1").digest(input);
    // }
}

