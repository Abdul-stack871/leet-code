// Last updated: 8/31/2026, 12:28:18 PM
1import java.util.*;
2
3class Solution {
4    public List<String> subdomainVisits(String[] cpdomains) {
5        Map<String, Integer> map = new HashMap<>();
6
7        for (String domainCount : cpdomains) {
8            int spaceIndex = domainCount.indexOf(' ');
9            int count = Integer.parseInt(domainCount.substring(0, spaceIndex));
10            String domain = domainCount.substring(spaceIndex + 1);
11
12            while (true) {
13                map.merge(domain, count, Integer::sum);
14                int dotIndex = domain.indexOf('.');
15                if (dotIndex == -1) break;
16                domain = domain.substring(dotIndex + 1);
17            }
18        }
19
20        List<String> result = new ArrayList<>(map.size());
21        for (Map.Entry<String, Integer> entry : map.entrySet()) {
22            result.add(entry.getValue() + " " + entry.getKey());
23        }
24
25        return result;
26    }
27}