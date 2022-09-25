package com.kweezy.stmt;

import com.kweezy.ObjectReader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BlocksInit {
    private final PreparedBlock<?>[] preparedblocks;
    private final Map<Class<?>, PreparedBlock<?>> idtoblock;


    public BlocksInit(final PreparedBlock<?>... a) {
        this.preparedblocks = a;
        this.idtoblock = new HashMap<Class<?>, PreparedBlock<?>>(a.length);
        for (final PreparedBlock<?> d : a) {
            this.idtoblock.put(d.blockClass, d);
        }

        Arrays.sort(this.preparedblocks, PreparedBlock.comparator);
    }

    public static BlocksInit get() {
        return init.a;
    }

    public <T> PreparedBlock<T> getBlockById(final int n) {
        final PreparedBlock<?>[] PossibleListOfBlocks = this.preparedblocks;
        int n2 = PossibleListOfBlocks.length - 1;
        int i = 0;
        while (i <= n2) {
            final int n3 = i + n2 >>> 1;
            final int b = PossibleListOfBlocks[n3].blockId;
            if (b < n) {
                i = n3 + 1;
            }
            else {
                if (b <= n) {
                    return (PreparedBlock<T>)PossibleListOfBlocks[n3];
                }
                n2 = n3 - 1;
            }
        }
        return null;
    }

    private static class PrepareStmt<T> extends PreparedBlock<T> {

        public PrepareStmt(int id, final Class<T> cl) {
            super(id, cl);
        }

        @Override
        public T addToChain(ObjectReader p0) {
            try {
                final readWriteData statement = (readWriteData) super.blockClass.getDeclaredConstructor().newInstance();
                p0.addBlockToBlocksArray(statement).readData(p0);

                return (T) statement;
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class init<T extends BlockType> {
        static final BlocksInit a;

        static {
            a = new BlocksInit(new PreparedBlock<?>[]{new PrepareStmt(102, AutomateString.class), new PrepareStmt<>(106, StringConstantValue.class), new PrepareStmt(1120, ToastShow.class)});
        }
    }

}

