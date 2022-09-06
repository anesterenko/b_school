public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    private int filled;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        filled = 0;
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        return (Math.abs(value.hashCode() % size));
    }

    public int seekSlot(String value)
    {
        if (filled == size) {
            return -1;
        }

        int key = hashFun(value);
        if (slots[key] == null) {
            return key;
        }

        while (slots[key] != null) {
            key = (key + step) < size ? key + step : (key + step) % size;
        }
        return key;
    }

    public int put(String value)
    {
        int key = seekSlot(value);
        if (key != -1) {
            slots[key] = value;
            filled++;
        }
        return key;
    }

    public int find(String value)
    {
        for (int i = 0; i < size; i++) {
            if (slots[i] != null && slots[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
}