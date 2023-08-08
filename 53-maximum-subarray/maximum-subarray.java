class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int result=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum<nums[i]){
                sum=nums[i];
            }
            if(result<sum){
                result=sum;
            }
        }

        return result;
    }
}