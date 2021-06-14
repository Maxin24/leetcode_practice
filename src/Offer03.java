import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:LiuJX
 * @Date:2021/6/14
 * @Description:
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int num:nums){
            if(!hashMap.containsKey(num)){
                hashMap.put(num,1);
                continue;
            }

            if(hashMap.get(num)==1){
                return num;
            }
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
