class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if(s1.equals(s2)){
            return true;
        }
        if(n==1){
            return false;
        }

        String key = s1+" "+s2;

        if(map.containsKey(key)){
            return map.get(key);
        }

        for(int i=1;i<n;i++){
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))){
                map.put(key, true);
                return map.get(key);
            }

            if(isScramble(s1.substring(0,i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0,n-i))){
                map.put(key, true);
                return map.get(key);
            }
        }

        map.put(key, false);
        return false;
    }
}