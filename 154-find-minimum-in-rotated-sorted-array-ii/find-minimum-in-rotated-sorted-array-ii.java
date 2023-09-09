class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int ele : nums){
            min = Math.min(min, ele);
        }

        return min;
    }
}