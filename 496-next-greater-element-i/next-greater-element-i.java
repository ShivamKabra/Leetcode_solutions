class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] val = find_next_greater(nums2);


        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i], val[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public int[] find_next_greater(int[] nums){
        int[] ans = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        for(int i = nums.length-1; i>=0;i--){
            while(st.size()>0 && st.peek()< nums[i]){
                st.pop();
            }

            if(st.size()==0){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }

            st.push(nums[i]);
        }

        return ans;
    }
}