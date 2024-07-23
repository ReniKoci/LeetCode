class RandomizedSet {

    Map<Integer, Integer> map;
    ArrayList<Integer> arr;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;

        map.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;

        int loc = map.get(val);
        if(arr.size() - 1 != loc){// not the last element
            // swap element with last element
            int lastElement = arr.get(arr.size() - 1);
            arr.set(loc, lastElement);
            map.put(lastElement, loc);
        } 
        map.remove(val);
        arr.remove(arr.size() - 1);

        return true;
    }
    
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */