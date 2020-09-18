class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
      map = new HashMap<>();
      list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
      if(map.containsKey(val)) return false;
      map.put(val, list.size());
      list.add(val);
      return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
      if(!map.containsKey(val)) return false;

      int element = list.get(list.size()-1);    
      int index = map.get(val);
      list.set(index, element);
      map.put(element, index);
      map.remove(val);
      list.remove(list.size()-1);
      return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
      return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */