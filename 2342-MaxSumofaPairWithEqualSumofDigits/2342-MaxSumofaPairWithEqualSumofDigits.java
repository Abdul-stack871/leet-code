// Last updated: 9/7/2026, 12:27:45 PM
1class LRUCache extends LinkedHashMap<Integer, Integer> {
2    private final int maxCap;
3
4    public LRUCache(int capacity) {
5        super(capacity, 0.75f, true); 
6        maxCap = capacity;
7    }
8
9    public int get(int key) {
10        return super.getOrDefault(key, -1);
11    }
12
13    public void put(int key, int value) {
14        super.put(key, value);
15    }
16
17    @Override
18    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
19        return size() > maxCap;
20    }
21}