class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int twos = nums.length - 1;
        for(int i = 0; i <= twos; i++){
           
            while(nums[i] == 2 && i < twos){//swap with twos element
                int temp = nums[twos];
                nums[twos] = nums[i];
                nums[i] = temp;
                twos--;
            }

            while(nums[i] == 0 && i > zeros){
                int temp = nums[zeros];
                nums[zeros] = nums[i];
                nums[i] = temp;
                zeros++;
            }
        }
    }
}