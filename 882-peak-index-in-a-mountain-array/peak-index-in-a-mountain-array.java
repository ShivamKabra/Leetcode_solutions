class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int ans=0;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>max){
                max=arr[i];
                ans=i;
            }
        }
        
       

        return ans;
    }
}