class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        String[] arr = text.split(" ");
        int count=0;
        for(int i=0;i<arr.length;i++){
            //char ch = brokenLetters.charAt(i);
            for(int j=0;j<brokenLetters.length();j++){
                if(arr[i].contains(brokenLetters.substring(j, j+1))){
                    count++;
                    break;
                }
            }
        }

        return arr.length-count;
    }
}