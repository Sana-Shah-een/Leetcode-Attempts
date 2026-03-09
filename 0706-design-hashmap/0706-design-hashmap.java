class MyHashMap {

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int N = 1000;
    LinkedList<Node>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return key % N;
    }

    private int search(int key, int bi) {
        LinkedList<Node> ll = buckets[bi];
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i).key == key) {
                return i;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        int bi = hashFunction(key);
        int di = search(key, bi);

        if (di == -1) {
            buckets[bi].add(new Node(key, value));
        } else {
            buckets[bi].get(di).value = value;
        }
    }

    public int get(int key) {
        int bi = hashFunction(key);
        int di = search(key, bi);

        if (di == -1) {
            return -1;
        } else {
            return buckets[bi].get(di).value;
        }
    }

    public void remove(int key) {
        int bi = hashFunction(key);
        int di = search(key, bi);

        if (di != -1) {
            buckets[bi].remove(di);
        }
    }
}