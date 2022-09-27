package com.kweezy.autool.stmt.types;

import com.kweezy.autool.ObjectReader;
import com.kweezy.autool.ObjectWriter;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public enum ConversionType
{


    Boolean("Boolean", 0),
    BooleanArray("BooleanArray", 1),
    Bundle("Bundle", 23),
    BundleArray("BundleArray", 24),
    BundleList("BundleList", 25),
    Byte("Byte", 2),
    ByteArray("ByteArray", 3),
    Char("Char", 4),
    CharArray("CharArray", 5),
    CharSequence("CharSequence", 20),
    CharSequenceArray("CharSequenceArray", 21),
    CharSequenceList("CharSequenceList", 22),
    ComponentName("ComponentName", 29),
    ComponentNameArray("ComponentNameArray", 30),
    ComponentNameList("ComponentNameList", 31),
    Double("Double", 6),
    DoubleArray("DoubleArray", 7),

    Float("Float", 8),
    FloatArray("FloatArray", 9),
    Int("Int", 10),
    IntArray("IntArray", 11),
    IntList("IntList", 12),
    Intent("Intent", 32),
    IntentArray("IntentArray", 33),
    IntentList("IntentList", 34),
    Long("Long", 13),
    LongArray("LongArray", 14),
    Rect("Rect", 35),
    Short("Short", 15),
    ShortArray("ShortArray", 16),
    String("String", 17),
    StringArray("StringArray", 18),
    StringList("StringList", 19),
    Uri("Uri", 26),
    UriArray("UriArray", 27),
    UriList("UriList", 28);


    // private static final ConversionType[] $VALUES;
    public static final ConversionType[] EMPTY_ARRAY;


    private static final Map<CharSequence, ConversionType> x0;

    static {
        Comparator<CharSequence> bbb = new Comparator<CharSequence>() {
            public int compare(final CharSequence charSequence, final CharSequence charSequence2) {
                int length = charSequence.length();
                int length2 = charSequence2.length();
                int n = 0;
                int n2 = 0;
                int n3;
                int n6;
                while (true) {
                    n3 = 0;
                    int n4;
                    int n5;
                    while (true) {
                        n4 = length - 1;
                        n5 = n;
                        if (n4 < 0) {
                            break;
                        }
                        n5 = n + 1;
                        final char char1 = charSequence.charAt(n);
                        if (char1 < '0') {
                            break;
                        }
                        if (char1 > '9') {
                            break;
                        }
                        n3 = n3 * 10 + char1 - 48;
                        length = n4;
                        n = n5;
                    }
                    n6 = 0;
                    int n7;
                    int n8;
                    while (true) {
                        n7 = length2 - 1;
                        n8 = n2;
                        if (n7 < 0) {
                            break;
                        }
                        final int n9 = n2 + 1;
                        final char char2 = charSequence2.charAt(n2);
                        if (char2 < '0' || char2 > '9') {
                            n8 = n9;
                            break;
                        }
                        n6 = n6 * 10 + char2 - 48;
                        n2 = n9;
                        length2 = n7;
                    }
                    if (n3 != n6) {
                        break;
                    }
                    length = n4;
                    length2 = n7;
                    n = n5;
                    n2 = n8;
                    if (n4 >= 0) {
                        continue;
                    }
                    length = n4;
                    length2 = n7;
                    n = n5;
                    n2 = n8;
                    if (n7 < 0) {
                        break;
                    }
                }
                return n3 - n6;
            }
        };

        int i = 0;
        EMPTY_ARRAY = new ConversionType[0];
        x0 = new TreeMap<CharSequence, ConversionType>(bbb);
        for (ConversionType[] values = values(); i < values.length; ++i) {
            final ConversionType conversionType = values[i];
            ConversionType.x0.put(conversionType.name(), conversionType);
        }
    }


    private ConversionType(final String name, final int ordinal) {
    }

    public static ConversionType forName(final CharSequence charSequence) {
        ConversionType conversionType;
        if (charSequence != null) {
            conversionType = ConversionType.x0.get(charSequence);
        }
        else {
            conversionType = null;
        }
        return conversionType;
    }

    public static ConversionType readObject(final ObjectReader a) throws IOException {
        final int e = a.transform_35();
        ConversionType conversionType;
        if (e >= 0 && e < values().length) {
            conversionType = values()[e];
        }
        else {
            conversionType = null;
        }
        return conversionType;
    }

    public static void writeObject(final ObjectWriter b, final ConversionType conversionType) throws IOException {
        int ordinal;
        if (conversionType == null) {
            ordinal = -1;
        }
        else {
            ordinal = conversionType.ordinal();
        }
        b.transform_35(ordinal);
    }
}
