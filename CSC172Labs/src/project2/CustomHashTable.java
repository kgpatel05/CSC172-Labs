package project2;

public class CustomHashTable {
    private static int DEFAULT_CAPACITY = 100;
    public Entry[] table;
    private int numberOfentires;
    private double LoadFactor = 0.5;

    public int getSize()
    {
        return table.length;
    }

    private int hash(int key)
    {
        return (key*key +8) % table.length;
    }

    public void insert(int key, Response value)
    {
        if ( (double) numberOfentires/ (double) table.length  > LoadFactor){
        // if ( (double) numberOfentires/ (double) DEFAULT_CAPACITY  > LoadFactor){
            rehash();
        }
        Entry newEntry = new Entry(key, value);
        int index = hash(key);
        while (table[index]!= null && table[index].getKey()!= key){
            index = (index +1) % table.length;
            // index = (index +1) % DEFAULT_CAPACITY;
        }
        if (table[index] == null){
            table[index] = newEntry;
            numberOfentires ++;
        } else {
            table[index] = newEntry;
        }
    }

    public Response search(int key)
    {
        int index = hash(key);
        while (table[index]!= null && table[index].getKey()!= key){
            index = (index +1) % table.length;
        }
        if (table[index]==null){
            System.out.println("Key not in table.");
            return null;
        } else {
            return table[index].getValue();
        }
    }

    public void delete(int key)
    {
        int index = hash(key);
        while (table[index]!= null && table[index].getKey()!= key){
            index = (index +1) % table.length;
        }
        if (table[index].getKey()== key){
            table[index] = null;
            numberOfentires--;
        } else {
            System.out.println("No such entry.");
        }
    }


    public void printHT()
    {
        for (int i =0; i < table.length; i++){
            if (table[i]== null){
                System.out.println("null");
            } else {
                System.out.println("("+ table[i].getKey() + "," + table[i].getValue() + ")");
            }
        }
    }
    public CustomHashTable() 
    {
        this.table = new Entry[DEFAULT_CAPACITY];
        this.numberOfentires = 0;
    }

    private void rehash()
    {
        Entry[] oldTable = table;
        int newCapacity = table.length *2;
        table = new Entry[newCapacity];
        numberOfentires = 0;
        for (Entry entry:  oldTable){
            if (entry!= null) {
                insert(entry.getKey(), entry.getValue());
            }
        }


    }
    public static class Entry 
    {
        private final int key;
        private Response value;

        public Entry(int key, Response value)
        {
            this.key = key;
            this.value = value;
        }
        public int getKey()
        {
            return key;
        }
        public Response getValue() 
        {
            return value;
        }
    }

    public static void main(String[] args) 
    {
        CustomHashTable myTable = new CustomHashTable();
        System.out.println(myTable.getSize());
    }
}
