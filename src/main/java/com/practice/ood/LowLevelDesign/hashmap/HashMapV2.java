package com.practice.ood.LowLevelDesign.hashmap;

public class HashMapV2<K, V> {
    private static final int INITIAL_SIZE = 1 << 4;// 16 entries
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    public Entry<K, V>[] hashTable;

    public HashMapV2() {
        this.hashTable = new Entry[INITIAL_SIZE];
    }

    public HashMapV2(int capacity) {
        int tableSize = tableSizeFor(capacity);
        this.hashTable = new Entry[tableSize];
    }

    public static void main(String[] args) {
        HashMapV2<Integer, Integer> myHashMap = new HashMapV2<Integer, Integer>(102333);
        myHashMap.put(1, 3);
        myHashMap.put(2, 6);
        myHashMap.put(3, 9);
        myHashMap.put(4, 12);
        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.get(0));
    }

    private int tableSizeFor(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K, V> node = this.hashTable[hashCode];
        if (node == null) {
            Entry<K, V> newNode = new Entry<>(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Entry<K, V> current = node, prev = null;
            while (current != null) {
                // check if there is any node existing before with this key
                // if it exists update the value for this key else create a new node
                // and attach at the end of the list.
                if (current.getKey().equals(key)) {
                    current.setValue(value);
                }
                prev = current;
                current = current.next;
            }
            Entry<K, V> newNode = new Entry<>(key, value);
            prev.next = newNode;
        }
    }

    private V get(K key) {
        int hashCode = key.hashCode() % this.hashTable.length;
        Entry<K, V> node = this.hashTable[hashCode];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return (V) node.getValue();
            }
            node = node.next;
        }
        return null;
    }

    private static class Entry<K, V> {
        public K key;
        public V value;
        public Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }
    }
}
