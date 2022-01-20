// inherited all properties from the parent class LinkedHashMap 
// LinkedHashMap ultilized the doubly linked list data structure to keep track of order of inserted element. 
class LRUCache extends LinkedHashMap<Integer,Integer> {
    private int max;
    public LRUCache(int capacity) {
        // super keyword refers to the parent class object
        // new LinkedHashMap<Integer, Integer>(int capacity, float fillRatio, boolean Order);
        super(capacity,0.75F,true); 
        this.max = capacity;
    }
    
    public int get(int key) {
        if (super.containsKey(key)) {
            return super.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        super.put(key,value);
    }
    // This method automatically invokved whenever put() is called
    // @Param: eldest is the least recently used entry in the map
    // Return true if there is no space in hashmap and will remove LRU element. Otherwise, return false when LRU element is not being removed
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > max;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
