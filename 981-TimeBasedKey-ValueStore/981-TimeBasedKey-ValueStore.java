// Last updated: 9/1/2026, 11:43:08 AM
1class TimeMap {
2    public Map<String, TreeMap<Integer, String>> map;
3
4    public TimeMap() {
5        map = new HashMap<>();
6    }
7    
8    public void set(String key, String value, int timestamp) {
9        if (map.containsKey(key)) {
10            map.get(key).put(timestamp, value);
11        } else {
12            TreeMap<Integer, String> t = new TreeMap<>();
13            t.put(timestamp, value);
14            map.put(key, t);
15        }
16    }
17    
18    public String get(String key, int timestamp) {
19        if (map.containsKey(key)) {
20            Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
21            
22            if (entry != null) {
23                return entry.getValue();
24            }
25        }
26        return "";
27    }
28}