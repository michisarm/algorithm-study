package queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int N;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // construct an empty deque
    public Deque(){
        N = 0;
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return N == 0;
    }

    // return the number of items on the deque
    public int size(){
        return N;
    }

    // add the item to the front
    public void addFirst(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        first.next = oldFirst;
        if (isEmpty()) last = first;
        else oldFirst.prev = first;
        N++;
    }

    // add the item to the end
    public void addLast(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node oldFirst = first;
        Item item = oldFirst.item;
        first = first.next;
        N--;
        return item;
    }

    // remove and return the item from the end
    public Item removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node oldLast = last;
        Item item = oldLast.item;
        last = last.prev;
        N--;
        return item;
    }

    // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    public class ListIterator implements Iterator<Item>{

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (optional)
    public static void main(String[] args){
        //Test는 DequeTest에서 진행
    }
}