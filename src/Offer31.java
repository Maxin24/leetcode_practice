import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null || pushed.length==0){
            return true;
        }
        int m=pushed.length;
        int n=popped.length;

        Stack<Integer> stack=new Stack<>();
        int i=0;
        for(int j=0;j<n;j++){
            if(!stack.empty() && stack.peek()==popped[j]){
                stack.pop();
                continue;
            }

            while(i<m && pushed[i]!=popped[j]){
                stack.push(pushed[i++]);
            }

            if(i<m && pushed[i]==popped[j]){
                i++;
                continue;
            }
        }


        if(stack.empty()){
            return true;
        }
        return false;
    }
}
