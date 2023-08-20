

class Solution {
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[n];
        helper(ans, ds, freq, arr);

       //Collections.sort(ans, new ListComparator());
        StringBuilder sb = new StringBuilder();

        List<Integer> temp  = ans.get(k-1);

        for(int ele : temp){
            sb.append((char)(ele+'0'));
        }

        return sb.toString();
    }

    public void helper(List<List<Integer>> ans, List<Integer> ds, boolean[] freq, int[] arr){
        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(arr[i]);
                helper(ans, ds, freq, arr);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
            
        }
        return;
    }
}