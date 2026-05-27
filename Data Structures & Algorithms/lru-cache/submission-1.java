class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    ListNode head;
    ListNode tail;
    int capacity;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next =  tail;
        tail.prev = head;
        map = new HashMap<>();    
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        ListNode node;
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        node = new ListNode(key, value);
        insert(node);

        if (map.size() > capacity) {
            remove(head.next);
        }
    }

    void insert(ListNode node) {
        ListNode prevNode = tail.prev;
        node.next = tail;
        node.prev = prevNode;
        prevNode.next = node;
        tail.prev = node;
        map.put(node.key, node);
    }

    void remove(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        map.remove(node.key);
    }
}
