import java.lang.reflect.Array;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    private static final int DEFAULT_CAPACITY = 16;
    private static final int MIN_FILL_PERCENTAGE = 50;
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
            T[] newArray = (T[]) Array.newInstance(clazz, capacity);
            System.arraycopy(array, 0, newArray, 0, count);
            array = newArray;
        }
        capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException();
        }

        return (T) Array.get(array, index);
    }

    public void append(T itm)
    {
        if (needToExtendCapacity()) {
            makeArray(getExtendedCapacitySize());
        }
        Array.set(array, count, itm);
        count++;
    }

    public void insert(T itm, int index)
    {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }

        if (needToExtendCapacity()) {
            makeArray(getExtendedCapacitySize());
        }

        for (int i = count - 1; i >= index; i--) {
            Array.set(array, i + 1, Array.get(array, i));
        }
        Array.set(array, index, itm);
        count++;
    }

    public void remove(int index)
    {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index + 1; i < count; i++) {
            Array.set(array, i - 1, Array.get(array, i));
        }
        count--;
        if (needToCompressCapacity()) {
            makeArray(getCompressedCapacitySize());
        }
    }

    private int getExtendedCapacitySize()
    {
        return (int)Math.max(capacity * EXTENSION_RATE, DEFAULT_CAPACITY);
    }

    private int getCompressedCapacitySize()
    {
        return (int)Math.max(capacity / COMPRESSION_RATE, DEFAULT_CAPACITY);
    }

    private boolean needToCompressCapacity()
    {
        return getFilledCapacityPercentage() < MIN_FILL_PERCENTAGE;
    }

    private boolean needToExtendCapacity()
    {
        return count >= capacity;
    }

    private double getFilledCapacityPercentage()
    {
        return (count / capacity) * 100;
    }

    public void print()
    {
        for (int i = 0; i < capacity; i++) {
            System.out.println(String.format("[%d]: %d", i, Array.get(array, i)));
        }
    }
}