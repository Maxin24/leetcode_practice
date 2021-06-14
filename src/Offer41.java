import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author:LiuJX
 * @Date:2021/6/14
 * @Description:
 */
public class Offer41 {
    private PriorityQueue<Integer> smallQueue;
    private PriorityQueue<Integer> bigQueue;

    /** initialize your data structure here. */
    public Offer41() {
        smallQueue=new PriorityQueue<>((num1,num2) -> num2-num1);
        bigQueue=new PriorityQueue<>();
    }

    public void addNum(int num) {
        int smallQueueSize=smallQueue.size();
        int bigQueueSize=bigQueue.size();

        if(smallQueueSize!=bigQueueSize){
            bigQueue.offer(num);
            smallQueue.offer(bigQueue.poll());
        }else{
            smallQueue.offer(num);
            bigQueue.offer(smallQueue.poll());
        }
    }

    public double findMedian() {
        int smallQueueSize=smallQueue.size();
        int bigQueueSize=bigQueue.size();

        if(smallQueueSize!=bigQueueSize){
            return bigQueue.peek();
        }else{
            return (double)(smallQueue.peek()+bigQueue.peek())/2;
        }
    }
}
