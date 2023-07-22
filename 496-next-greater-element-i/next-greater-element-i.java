class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int j;
        Arrays.fill(ans, -1);
        for(int i=0;i<nums1.length;i++){
            boolean found=false;
           for( j=0;j<nums2.length;j++){
               if(nums2[j]>nums1[i] && found){
                   ans[i]=nums2[j];
                   break;
               }

               if(nums2[j]==nums1[i]){
                   found=true;
               }
           }
           if(j==nums2.length){
               ans[i]=-1;
           }
        }

        return ans;
    }
}