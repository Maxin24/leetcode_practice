import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 * @author liujx
 */
public class Offer30 {
    private Stack<Integer> elementStack;
    private Stack<Integer> minValStack;
    /** initialize your data structure here. */
    public Offer30() {
        elementStack=new Stack<>();
        minValStack=new Stack<>();
    }

    public void push(int x) {
        elementStack.push(x);
        if(!minValStack.empty()){
            if(minValStack.peek()>=x){
                minValStack.push(x);
            }
        }else{
            minValStack.push(x);
        }
    }

    public void pop() {
        if(elementStack.peek().equals(minValStack.peek())){
            minValStack.pop();
        }
        elementStack.pop();
    }

    public int top() {
        return elementStack.peek();
    }

    public int min() {
        return minValStack.peek();
    }
}
