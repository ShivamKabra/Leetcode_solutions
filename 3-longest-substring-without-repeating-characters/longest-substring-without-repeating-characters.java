class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int a = 0;
        int b = 0;

        HashSet<Character> hashset = new HashSet<>();
        int max = 0;
        while(b<s.length()){
            if(!hashset.contains(s.charAt(b))){
                hashset.add(s.charAt(b));
                b=b+1;
                max = Math.max(hashset.size(), max);
            }else{
                
                //b=b+1;
                hashset.remove(s.charAt(a));
                a=a+1;

            }
        }

        return max;
    }
}