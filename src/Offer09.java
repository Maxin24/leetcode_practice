import java.util.Stack;

/**
 * @author liujx
 */
public class Offer09 {
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;
    public Offer09() {
        inputStack=new Stack<>();
        outputStack=new Stack<>();
    }

    public void appendTail(int value) {
        inputStack.push(value);
    }

    public int deleteHead() {
        if(outputStack.empty() && inputStack.empty()){
            return -1;
        }

        if(outputStack.empty()){
            while(!inputStack.empty()){
                outputStack.push(inputStack.pop());
            }
        }



        return outputStack.pop();
    }
}
