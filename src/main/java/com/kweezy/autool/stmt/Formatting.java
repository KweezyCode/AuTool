package com.kweezy.autool.stmt;

import com.kweezy.autool.stmt.interfaces.AutomateField;

public class Formatting {

    public static void c(final CharSequence charSequence, final int n, final StringBuilder sb) {
        StringFormatting(charSequence, 0, charSequence.length(), n, sb);
    }

    public static void StringFormatting(final CharSequence charSequence, int n, int n2, final int n3, final StringBuilder sb) {
        int n4 = n;
        int n5 = n2;
        if ((n3 & 0x4) != 0x0) {
            Label_0060_Outer:
            while (--n2 >= 0) {
                final char char1 = charSequence.charAt(n);
                Label_0052_Outer: // TODO: Stolen code, should be fixed
                while (true) {
                    Label_0060:
                    while (true) {
                        Label_0071: {
                            if (char1 == ';') {
                                break Label_0071;
                            }
                            if (char1 != '{') {
                                if (char1 != '}') {
                                    break Label_0060;
                                }
                                break Label_0071;
                            }
                            sb.append('\\');
                            sb.append(char1);
                            ++n;
                            continue Label_0060_Outer;
                        }
                        if ((n3 & 0x2) != 0x0) {
                            continue;
                        }
                        break;
                    }
                    continue Label_0052_Outer;
                }
            }
        }
        else {
            while (--n5 >= 0) {
                final char char2 = charSequence.charAt(n4);
                Label_0336: {
                    String hexString = null;
                    Label_0284: {
                        if (char2 != '\f') {
                            if (char2 != '\r') {
                                Label_0309: {
                                    Label_0301: {
                                        if (char2 != '\"') {
                                            if (char2 != ';') {
                                                if (char2 == '\\' || char2 == '{') {
                                                    break Label_0301;
                                                }
                                                if (char2 != '}') {
                                                    switch (char2) {
                                                        default: {
                                                            if ((char2 < ' ') || ((char2 >= '\u0080') && (char2 < ' ' /*   */)) || ((char2 >= '\u2000') && (char2 < '\u2100')) || ((char2 >= '\ud800') && (char2 <= '\udfff'))) {
                                                                hexString = Integer.toHexString(char2);
                                                                sb.append("\\u0000", 0, 6 - hexString.length());
                                                                break Label_0284;
                                                            }
                                                            break Label_0309;
                                                        }
                                                        case 10: {
                                                            hexString = "\\n";
                                                            break Label_0284;
                                                        }
                                                        case 9: {
                                                            hexString = "\\t";
                                                            break Label_0284;
                                                        }
                                                        case 8: {
                                                            hexString = "\\b";
                                                            break Label_0284;
                                                        }
                                                    }
                                                }
                                            }
                                            if ((n3 & 0x2) == 0x0) {
                                                break Label_0309;
                                            }
                                        }
                                    }
                                    sb.append('\\');
                                }
                                sb.append(char2);
                                break Label_0336;
                            }
                            hexString = "\\r";
                        }
                        else {
                            hexString = "\\f";
                        }
                    }
                    sb.append(hexString);
                }
                ++n4;
            }
        }
    }

    public static String n0(int i, String str, final AutomateField... array) { // TODO: Rename
        final StringBuilder sb = new StringBuilder();
        int n = 0;
        if ((i & 0x1) != 0x0) {
            sb.append(array[0].prettyPrint(0));
            sb.append(';');
            sb.append(str);
            int length = array.length;
            while (true) {
                final int n2 = length - 1;
                if (n2 <= 0) {
                    break;
                }
                final int n3 = n + 1;
                final AutomateField v0 = array[n3];
                n = n3;
                length = n2;
                if (v0 == null) {
                    continue;
                }
                sb.append(';');
                sb.append(v0.prettyPrint(i | 0x2));
                n = n3;
                length = n2;
            }
        }
        else {
            sb.append(str);
            sb.append('(');
            final int length2 = array.length;
            str = "";
            AutomateField v2;
            String s;
            for (i = 0; i < length2; ++i, str = s) {
                v2 = array[i];
                s = str;
                if (v2 != null) {
                    sb.append(str);
                    sb.append(v2.prettyPrint(0));
                    s = ", ";
                }
            }
            sb.append(')');
        }
        return sb.toString();
    }

    public static String constantString(final CharSequence charSequence, final int n) {
        final int length = charSequence.length();
        final StringBuilder sb = new StringBuilder(length + 8);
        if ((n & 0x1) != 0x0) {
            StringFormatting(charSequence, 0, length, n, sb);
        }
        else {
            sb.append('\"');
            StringFormatting(charSequence, 0, length, n, sb);
            sb.append('\"');
        }
        return sb.toString();
    }
    public static double NumberToBoolean(final boolean b) {
        double n;
        if (b) {
            n = 1.0;
        }
        else {
            n = 0.0;
        }
        return n;
    }
    public static String FormatNumber(final double d) {
        if (d != d) {
            return "NaN";
        }
        if (d == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        if (d == 0.0) {
            return "0";
        }
        final long i = (long)d;
        String s;
        if (i == d) {
            s = Long.toString(i);
        }
        else {
            s = Double.toString(d);
        }
        return s;
    }
}
