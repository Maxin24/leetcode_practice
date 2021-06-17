public class Offer21 {
    public int[] exchange(int[] nums) {
        int len=nums.length;
        int i=0,j=nums.length-1;
        while(i<j){
            while(i<len && nums[i]%2!=0){
                i++;
            }

            while(j>=0 && nums[j]%2==0){
                j--;
            }
            if(i<j){
                swap(nums,i++,j--);
            }
        }
        return nums;
    }

    private void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
