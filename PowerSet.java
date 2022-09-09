public class PowerSet
{
    private final String [] slots;
    private int filled;
    private static final int SIZE = 20000;


    public PowerSet()
    {
        slots = new String[SIZE];
        filled = 0;
        for(int i = 0; i < SIZE; i++) slots[i] = null;
    }

    private int hashFun(String value)
    {
        return (Math.abs(value.hashCode() % SIZE));
    }

    public int size()
    {
        return filled;
    }

    public void put(String value)
    {
        int key = hashFun(value);
        if (slots[key] == null) {
            slots[key] = value;
            filled++;
        }
    }

    public boolean get(String value)
    {
        int key = hashFun(value);
        return slots[key] != null;
    }

    public boolean remove(String value)
    {
        int key = hashFun(value);
        if (slots[key] != null) {
            slots[key] = null;
            filled--;
            return true;
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet result = new PowerSet();

        for (int i = 0; i < SIZE; i++) {
            if (slots[i] != null && set2.get(slots[i])) {
                result.put(slots[i]);
            }
        }
        return result;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet result = new PowerSet();

        for (int i = 0; i < SIZE; i++) {
            if (slots[i] != null) {
                result.put(slots[i]);
            }

            if (set2.slots[i] != null) {
                result.put(set2.slots[i]);
            }
        }
        return result;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet result = new PowerSet();

        for (int i = 0; i < SIZE; i++) {
            if (slots[i] != null && !set2.get(slots[i])) {
                result.put(slots[i]);
            }
        }
        return result;
    }

    public boolean isSubset(PowerSet set2)
    {
        int counter = 0;
        for (int i = 0; i < SIZE && counter < set2.size(); i++) {
            if (slots[i] != null && set2.get(slots[i])) {
                counter++;
            }
        }

        return counter == set2.size();
    }
}
