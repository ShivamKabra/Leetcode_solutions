class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans= new int[nums1.length+nums2.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=nums1[i];
        }
        int k=0;
        for(int i=nums1.length;i<ans.length;i++){
            ans[i]=nums2[k];
            k++;
        }
        
        Arrays.sort(ans);
        if(ans.length%2!=0){
            return (float)ans[ans.length/2];
        }
        else{
            return (float)(ans[ans.length/2-1] + ans[ans.length/2])/2;
        }

        
    }
}