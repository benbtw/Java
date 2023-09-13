import java.util.PriorityQueue;
import java.util.Queue;

public class priority_queues {
    //first in, first out. puts orders in the priority order
    public static void main(String[] args){

        Queue<Double> queue = new PriorityQueue<>();
        //reverse order would be PriorityQueue<>(Collections.reverseOrder());
        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);
        /*
        priority turns it in order, so it would print numbers in ascending order
         */
    }
}
