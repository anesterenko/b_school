import java.lang.reflect.Array;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    private static final int DEFAULT_CAPACITY = 16;
    private static final int MIN_FILLING_LEVEL_PERCENT = 50;
    private static final double EXTENSION_RATE = 2;
    private static final double COMPRESSION_RATE = 1.5;

    public DynArray(Class clz)
    {
        clazz = clz;
        count = 0;
        makeArray(DEFAULT_CAPACITY);
    }

    public void makeArray(int new_capacity)
    {
        if (array == null) {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
        } else {
            T[] newArray = (T[]) Array.newInstance(clazz, new_capacity);
            System.arraycopy(array, 0, newArray, 0, count);
            array = newArray;
        }
        capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        return (T) Array.get(array, index);
    }

    public void append(T itm)
    {
        if (isNeededToExtendBuffer()) {
            makeArray(getExtendedBufferSize());
        }

        Array.set(array, count, itm);
        count++;
    }

    public void insert(T itm, int index)
    {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }

        if (isNeededToExtendBuffer()) {
            makeArray(getExtendedBufferSize());
        }

        for (int i = count - 1; i >= index; i--) {
            Array.set(array, i + 1, Array.get(array, i));
        }

        Array.set(array, index, itm);
        count++;
    }

    public void remove(int index)
    {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index + 1; i < count; i++) {
            Array.set(array, i - 1, Array.get(array, i));
        }

        count--;
        if (isNeededToCompressBuffer()) {
            makeArray(getCompressedBufferSize());
        }
    }

    private int getExtendedBufferSize()
    {
        return (int)Math.max(capacity * EXTENSION_RATE, DEFAULT_CAPACITY);
    }

    private int getCompressedBufferSize()
    {
        return (int)Math.max(capacity / COMPRESSION_RATE, DEFAULT_CAPACITY);
    }

    private boolean isNeededToCompressBuffer()
    {
        return getFillingPercent() < MIN_FILLING_LEVEL_PERCENT;
    }

    private boolean isNeededToExtendBuffer()
    {
        return count >= capacity;
    }

    private double getFillingPercent()
    {
        return ((double)count / (double)capacity) * 100;
    }
}