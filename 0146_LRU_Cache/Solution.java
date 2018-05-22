class DoubleListNode {
    int key, val;
    DoubleListNode last, next;

    public DoubleListNode(int k, int v) {
        key = k;
        val = v;
    }
}

class LRUCache {
    DoubleListNode preHead, preEnd;
    HashMap<Integer, DoubleListNode> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        preHead = new DoubleListNode(0, 0);
        preEnd = new DoubleListNode(0, 0);
        preHead.next = preEnd;
        preEnd.last = preHead;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleListNode node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleListNode node = map.get(key);
            removeNode(node);
            addToHead(node);
            node.val = value;
        } else {
            if (map.size() == capacity) {
                map.remove(preEnd.last.key);
                removeNode(preEnd.last);
            }
            DoubleListNode node = new DoubleListNode(key, value);
            map.put(key, node);
            addToHead(node);
        }
    }

    private void removeNode(DoubleListNode node) {
        node.last.next = node.next;
        node.next.last = node.last;
    }

    private void addToHead(DoubleListNode node) {
        preHead.next.last = node;
        node.next = preHead.next;
        preHead.next = node;
        node.last = preHead;
    }
}
