public class FixedCapacityStackOfGeneric<Item> {

    private Item[] s;
    private int N = 0;

    public FixedCapacityStackOfGeneric(int capacity) {
        //generic array creation not allowed in Java
        //s = new Item[capacity];

        s = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        return s[--N];
    }
}