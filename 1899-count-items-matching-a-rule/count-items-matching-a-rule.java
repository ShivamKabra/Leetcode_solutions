class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int key = 0;
        int count=0;
        if(ruleKey.equals("type")){
            key = 0;
        }
        if(ruleKey.equals("color")){
            key=1;
        }
        if(ruleKey.equals("name")){
            key=2;
        }
        for(int i=0;i<items.size();i++){
            if(items.get(i).get(key).equals(ruleValue)){
                count++;
            }
        }
        return count;
    }
}