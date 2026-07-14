// Last updated: 7/14/2026, 2:23:52 PM
/**
 * @param {number[][]} trees
 * @return {number[][]}
 */
var outerTrees = function(trees) {
    
    function crossProduct(a, b, c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
    }

    const n = trees.length;
    if (n <= 2) return trees;

    trees.sort((a, b) => a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1]);

    const lower = [];
    for (let i = 0; i < n; i++) {
        const p = trees[i];
        while (lower.length >= 2 && crossProduct(lower[lower.length - 2], lower[lower.length - 1], p) < 0) {
            lower.pop();
        }
        lower.push(p);
    }

    const upper = [];
    for (let i = n - 1; i >= 0; i--) {
        const p = trees[i];
        while (upper.length >= 2 && crossProduct(upper[upper.length - 2], upper[upper.length - 1], p) < 0) {
            upper.pop();
        }
        upper.push(p);
    }

    const uniquePoints = new Map();
    const fullHull = lower.concat(upper);
    
    for (const p of fullHull) {
        uniquePoints.set(`${p[0]},${p[1]}`, p);
    }

    return Array.from(uniquePoints.values());
};