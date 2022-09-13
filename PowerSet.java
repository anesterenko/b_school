import java.util.LinkedList;
import java.util.ListIterator;

public class PowerSet
{
    private final LinkedList<String> list;

    public PowerSet()
    {
        list = new LinkedList<>();
    }

    public int size()
    {
        return list.size();
    }

    public void put(String value)
    {
        if (!list.contains(value)) {
            list.addLast(value);
        }
    }

    public boolean get(String value)
    {
        return list.contains(value);
    }

    public boolean remove(String value)
    {
        int index = list.indexOf(value);
        if (index == -1) {
            return false;
        }
        list.remove(index);
        return true;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet result = new PowerSet();

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            if (set2.get(next)) {
                result.put(next);
            }
        }
        return result;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet result = new PowerSet();

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            result.put(next);
        }

        ListIterator<String> listIterator2 = set2.list.listIterator();
        while (listIterator2.hasNext()) {
            String next = listIterator2.next();
            result.put(next);
        }
        return result;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet result = new PowerSet();

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            if (!set2.get(next)) {
                result.put(next);
            }
        }
        return result;
    }

    public boolean isSubset(PowerSet set2)
    {
        int counter = 0;
        ListIterator<String> listIterator2 = set2.list.listIterator();

        while (listIterator2.hasNext()) {
            String next = listIterator2.next();
            if (this.get(next)) {
                counter++;
            }
        }
        return counter == set2.size();
    }
}
