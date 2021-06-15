public class Offer11 {
    public int minArray(int[] numbers) {
        int res=numbers[0];
        int res1=Integer.MAX_VALUE;
        for(int i=numbers.length-1;i>=0;i--){
            if(numbers[i]>res1){
                break;
            }else {
                res1 = numbers[i];
            }
        }
        return Math.min(res, res1);
    }

    public int minArray1(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            //防止溢出
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                //值得注意这里
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
