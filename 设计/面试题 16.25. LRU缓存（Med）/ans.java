class LRUCache {
    class DoubleList{
        int key;
        int value;
        DoubleList pre;
        DoubleList next;
        public DoubleList(){

        }
        public DoubleList(int key , int value){
            this.key = key;
            this.value = value;
        }     
    }
    int capacity;
    int size;
    Map<Integer, DoubleList> map = new HashMap<>();
    DoubleList head, tail;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleList();
        tail = new DoubleList();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            DoubleList node = map.get(key);
            moveToHead(node);
            return node.value;
        }
    }
 
    public void put(int key, int value) {
        DoubleList node = map.get(key);
        if(node == null){
            DoubleList curr = new DoubleList(key, value);
            map.put(key, curr);
            addToHead(curr);
            size++;
            if(size > capacity){
                DoubleList tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }     
    }

    private void addToHead(DoubleList node) {
        node.next = head.next;
        head.next = node;
        node.pre = head;
        node.next.pre = node;
    }

    private void removeNode(DoubleList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DoubleList node) {
        removeNode(node);
        addToHead(node);
    }

    private DoubleList removeTail() {
        DoubleList node = tail.pre;
        removeNode(node);
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */