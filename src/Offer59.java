import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liujx
 * 单调队列
 */
public class Offer59 {
    Queue<Integer> elementQueue;
    Deque<Integer> maxValQueue;

    public Offer59() {
        elementQueue=new LinkedList<>();
        maxValQueue=new LinkedList<>();
    }

    public int max_value() {
        if(maxValQueue.isEmpty()){
            return -1;
        }
        return maxValQueue.peek();
    }

    public void push_back(int value) {
        elementQueue.add(value);
        if(maxValQueue.isEmpty()){
            maxValQueue.add(value);
        }else{
            while(maxValQueue.getLast()<value){
                maxValQueue.removeLast();
                if(maxValQueue.isEmpty()){
                    break;
                }
            }
            maxValQueue.addLast(value);
        }
    }

    public int pop_front() {
        if(elementQueue.isEmpty()){
            return -1;
        }else{
            int res=elementQueue.remove();
            if(res==maxValQueue.getFirst()){
                maxValQueue.removeFirst();
            }
            return res;
        }

    }
}
