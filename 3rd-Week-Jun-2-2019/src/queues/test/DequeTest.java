package queues.test;


import org.junit.*;
import queues.Deque;
import java.util.Iterator;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class DequeTest {

    @Test
    public void testDeque(){
        Deque deque = new Deque();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);

        int count = 0;
        Iterator itr = deque.iterator();
        while(itr.hasNext()){
            Integer o = (Integer) itr.next();
            count++;
            System.out.println(count+ "   "+ o);
            if (count == 1)
                assertThat(o, is(4));
            else if (count == 2)
                assertThat(o, is(3));
            else if (count == 3)
                assertThat(o, is(2));
            else if (count == 4)
                assertThat(o, is(1));
        }
    }
}