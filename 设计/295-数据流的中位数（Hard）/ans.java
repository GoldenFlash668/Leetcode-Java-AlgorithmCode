class MedianFinder {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small; 
    /** initialize your data structure here. */
    public MedianFinder() {
        //Set<Integer> set = new HashSet<>();//Set中不能出现重复数
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a, b) -> {
            return b-a;
        });
    }
    
    public void addNum(int num) {
        if(large.size() <= small.size()){
            small.offer(num);
            large.add(small.poll());
        }else{
            large.offer(num);
            small.add(large.poll());
        }
        

    }
    
    public double findMedian() {
        if(large.size() < small.size()){
            return small.peek();
        }else if(large.size() > small.size() ){
            return large.peek();
        }
        return (large.peek() + small.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */