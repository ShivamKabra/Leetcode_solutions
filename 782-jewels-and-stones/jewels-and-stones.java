class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> hashset = new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            hashset.add(jewels.charAt(i));
        }
        int count=0;
        for(int i=0;i<stones.length();i++){
            if(hashset.contains(stones.charAt(i))){
                count++;
            }
        }

        return count;
    }
}