class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int ele : nums){
            if(ele<0){
                neg.add(ele);
            }else{
                pos.add(ele);
            }
        }
        int cp = 0;
        int np = 0;
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                arr[i] = pos.get(cp);
                cp++;
            }else{
                arr[i] = neg.get(np);
                np++;
            }
        }

        return arr;
    }
}