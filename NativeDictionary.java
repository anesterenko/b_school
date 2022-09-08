import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        return (Math.abs(key.hashCode() % size));
    }

    public boolean isKey(String key)
    {
        int keyIndex = hashFun(key);
        return slots[keyIndex] != null;
    }

    public void put(String key, T value)
    {
        int keyIndex = hashFun(key);
        slots[keyIndex] = key;
        values[keyIndex] = value;
    }

    public T get(String key)
    {
        int keyIndex = hashFun(key);
        if (slots[keyIndex] != null) {
            return values[keyIndex];
        }
        return null;
    }
}