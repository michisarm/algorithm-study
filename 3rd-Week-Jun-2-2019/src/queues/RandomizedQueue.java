package queues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int N;
    private Item[] items;

    // construct an empty randomized queue
    public RandomizedQueue() {
        //items = (Item[]) new Object[1];
        resize(1);
        N = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return N;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        if (N == items.length) resize(2 * items.length);
        items[N++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        if (N > 0 && N == items.length / 4) resize(items.length / 2);
        int index = StdRandom.uniform(N);
        Item item = items[index];
        items[index] = items[--N];
        items[N] = null;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int index = StdRandom.uniform(N);
        return items[index];
    }

    private void resize(int n) {
        Item[] copy = (Item[]) new Object[n];
        if (n == 1) {
            items = copy;
            return;
        }
        for (int i = 0; i < n; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new RandomListIterator();
    }

    private class RandomListIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (isEmpty()) {
                throw new java.util.NoSuchElementException();
            }

            int index = StdRandom.uniform(N);
            return items[index];
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    // unit testing (optional)
    public static void main(String[] args) {

    }
}