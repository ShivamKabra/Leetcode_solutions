class Solution {
    public int findTargetSumWays(int[] nums, int diff) {
        int n = nums.length;
        if(n==1 && nums[0]<diff){
            return 0;
        }
        
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        if(sum+diff<0) return 0;
        if((sum+diff)%2==1) return 0;
       
        int target = (int)Math.ceil((sum+diff)/2);
        int[][] dp = new int[n][target+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        } 
        return helper(n-1, target, nums, dp);
    }

    public int helper(int ind, int target, int[] nums, int[][] dp){
        
        // if(target==0){
        //     return 1;
        // }
        if(ind==0){
            if(nums[0]==0 && target==0){
                return 2;
            }
            if(target==0 || target==nums[0]){
                return 1;
            }
            return 0;
        }

        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }

        int not_take = helper(ind-1, target, nums, dp);
        int take = 0;
        if(nums[ind]<=target){
            take = helper(ind-1, target-nums[ind], nums, dp);
        }

        dp[ind][target] = take+not_take;

        return dp[ind][target];
    }
}