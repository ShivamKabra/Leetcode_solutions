class Solution {
    public int countVowelSubstrings(String word) {
        int count=0;
        HashSet<Character> hashset = new HashSet<>();
        for(int i=0;i<word.length()-4;i++){
            for(int j=i;j<word.length();j++){
                char ch = word.charAt(j);
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    hashset.add(ch);
                    if(hashset.size()==5){
                        count++;
                    }
                }else{
                    break;
                }
            }
            hashset.clear();
        }

        return count;
    }
}