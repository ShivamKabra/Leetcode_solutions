class RandomizedSet {
    HashSet<Integer> hashset;
    public RandomizedSet() {
        hashset = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(hashset.contains(val)){
            return false;
        }
        hashset.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(hashset.contains(val)){
            hashset.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        List<Integer> list = new ArrayList<Integer>(hashset);
        int r=(int)(Math.random()*hashset.size());
        
       return list.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */