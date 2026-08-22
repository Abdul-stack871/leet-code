// Last updated: 8/22/2026, 10:26:27 AM
1class Solution {
2    public void dfs(String node, String dest, HashMap<String, HashMap<String, Double>> gr, HashSet<String> vis, double[] ans, double temp) {
3        if (vis.contains(node))
4            return;
5
6        vis.add(node);
7        if (node.equals(dest)) {
8            ans[0] = temp;
9            return;
10        }
11
12        for (Map.Entry<String, Double> entry : gr.get(node).entrySet()) {
13            String ne = entry.getKey();
14            double val = entry.getValue();
15            dfs(ne, dest, gr, vis, ans, temp * val);
16        }
17    }
18
19    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
20        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();
21
22        for (int i = 0; i < equations.size(); i++) {
23            String dividend = equations.get(i).get(0);
24            String divisor = equations.get(i).get(1);
25            double value = values[i];
26
27            gr.putIfAbsent(dividend, new HashMap<>());
28            gr.putIfAbsent(divisor, new HashMap<>());
29
30            gr.get(dividend).put(divisor, value);
31            gr.get(divisor).put(dividend, 1.0 / value);
32        }
33
34        return gr;
35    }
36
37    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
38        HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);
39        double[] finalAns = new double[queries.size()];
40
41        for (int i = 0; i < queries.size(); i++) {
42            String dividend = queries.get(i).get(0);
43            String divisor = queries.get(i).get(1);
44
45            if (!gr.containsKey(dividend) || !gr.containsKey(divisor)) {
46                finalAns[i] = -1.0;
47            } else {
48                HashSet<String> vis = new HashSet<>();
49                double[] ans = {-1.0};
50                double temp = 1.0;
51                dfs(dividend, divisor, gr, vis, ans, temp);
52                finalAns[i] = ans[0];
53            }
54        }
55
56        return finalAns;
57    }
58}