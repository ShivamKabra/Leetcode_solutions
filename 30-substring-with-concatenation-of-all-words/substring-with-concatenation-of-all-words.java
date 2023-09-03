class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        int m = words[0].length();
        int l = n*m;
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : words){
            if(!map.containsKey(str)){
                map.put(str, 1);
            }else{
                int count = map.get(str);
                count++;
                map.put(str, count);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<=s.length()-l;i++){
            HashMap<String, Integer> seen  = new HashMap<>();

            for(int j=0;j<n;j++){
                int nextWordIndex = i+j*m;

                String temp = s.substring(nextWordIndex, nextWordIndex+m);

                if(!map.containsKey(temp)){
                    break;
                }

                seen.put(temp, seen.getOrDefault(temp, 0)+1);

                if(seen.get(temp)>map.getOrDefault(temp, 0)){
                    break;
                }

                if(j+1==n){
                    result.add(i);
                }
            }
        }

        return result;




    }
}