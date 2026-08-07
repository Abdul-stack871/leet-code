// Last updated: 8/7/2026, 11:31:11 AM
1import java.util.Iterator;
2
3class PeekingIterator implements Iterator<Integer> {
4    private Integer next = null;
5    private Iterator<Integer> iter;
6
7    public PeekingIterator(Iterator<Integer> iterator) {
8        iter = iterator;
9        if (iter.hasNext()) {
10            next = iter.next();
11        }
12    }
13
14  
15    public Integer peek() {
16        return next;
17    }
18
19    @Override
20    public Integer next() {
21        Integer res = next;
22        next = iter.hasNext() ? iter.next() : null;
23        return res;
24    }
25
26    @Override
27    public boolean hasNext() {
28        return next != null;
29    }
30}