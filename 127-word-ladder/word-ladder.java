

class Pair{
    String first;
    int second;
    Pair(String _first, int _second){
        this.first = _first;
        this.second = _second;
    } 

}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q  = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        HashSet<String> hashset = new HashSet<>();
        for(int i =0;i<wordList.size();i++){
            hashset.add(wordList.get(i));
        }

        hashset.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if(word.equals(endWord)){
                return steps;
            }

            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch<='z';ch++){
                    char[] replacedArr = word.toCharArray();
                    replacedArr[i] = ch;
                    String replaced_word = new String(replacedArr);
                    if(hashset.contains(replaced_word)){
                        hashset.remove(replaced_word);
                        q.add(new Pair(replaced_word, steps+1));
                    }
                }
            }

            
        }
        return 0;
    }
}