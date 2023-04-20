package io.chone.algorithm.solution;


import java.util.HashMap;

/**
 * https://leetcode.cn/problems/lru-cache/
 * <p>
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {

    private HashMap<Integer, Node> hashMap = new HashMap<>();
    private final int capacity;
    private Node dummyHead;
    private Node dummyTail;

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        int ret = lruCache.get(1);
        System.out.println("get(1): 1, real:" + ret);
        lruCache.put(3, 3);
        System.out.println("get(2): -1, real:" + lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println("get(1)：-1 , real: " + lruCache.get(1));
        lruCache.get(3);
        lruCache.get(4);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        //使用伪头/尾，减少首次空的判断
        dummyHead = new Node(-1);
        dummyTail = new Node(-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            // move to head
            Node node = hashMap.get(key);
            moveToHead(node);
            printLinkList();
            return node.value;
        }
        printLinkList();
        return -1;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (node != null) {
            node.value = value;
            return;
        }
        if (hashMap.size() >= capacity) {
            //删除最后一个
            hashMap.remove(dummyTail.prev.value);
            removeTail();
        }
        node = new Node(value);
        //添加新节点，到头部
        addToHead(node);
        //加入hash
        hashMap.put(key, node);
        printLinkList();
    }



    private void moveToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;

    }

    private void addToHead(Node node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void removeTail() {
        dummyTail.prev.prev.next = dummyTail;
        dummyTail.prev = dummyTail.prev.prev;
    }


    public static class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }
    }


    private void printLinkList() {
        Node cur = dummyHead;
        StringBuffer sb = new StringBuffer();
        while (cur != null) {
            sb.append(cur.value).append(">");
            cur = cur.next;
        }
        sb.append(",reverse:");
        cur = dummyTail;
        while (cur != null) {
            sb.append(cur.value).append("<");
            cur = cur.prev;
        }
        System.out.println(sb);
    }
}
