package ACT10_0D;

import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        
        Queue<String> cua = new LinkedList<>();  // FIFO
        cua.offer("Element1");
        cua.offer("Element2");
        System.out.println(cua.poll());  // element ? "Element1"
        /*
        Deque<String> cua = new LinkedList<>();    // LIFO
        cua.push("Element1");
        cua.push("Element2");
        System.out.println(cua.pop());  // element ? "Element2"
        */
    }
    
}
