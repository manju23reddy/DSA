# Container with Most Water
## Leet Code
### Medium
### Two Pointers

“Container With Most Water” — Two-Pointer Method (Deep Notes)
Problem (in one line)

Given an array heights[0..n-1] where each heights[i] is a vertical line at x = i, pick two lines i < j to form a container with the x-axis. The water area is:

area
(
𝑖
,
𝑗
)
=
(
𝑗
−
𝑖
)
×
min
⁡
(
heights
[
𝑖
]
,
heights
[
𝑗
]
)
.
area(i,j)=(j−i)×min(heights[i],heights[j]).

Maximize this area.

Core Insight

The width shrinks as you move pointers inward.

The height of any container is limited by the shorter of the two lines.

Therefore, to possibly increase area when shrinking width, you must try to increase the limiting height.
That means: move the pointer at the shorter line.

Algorithm (Two Pointers)

Set left = 0, right = n-1, best = 0.

While left < right:

width = right - left

h = min(heights[left], heights[right])

best = max(best, width * h)

If heights[left] < heights[right] → left++
else → right--.

Return best.

Time: O(n) (each index visited at most once).
Space: O(1).

Why Moving the Shorter Pointer Is Correct (proof sketch)

Let the current pair be (L, R) with heights a = heights[L], b = heights[R], and W = R - L. Assume w.l.o.g. a ≤ b. The current area is A = W * a.

If you move the taller side (R → R-1 while keeping L), the new width is W-1, and the new height is min(a, heights[R-1]) ≤ a.
So the new area A' ≤ (W-1) * a < W * a = A. You cannot beat A by moving the taller side while a is still the limiter.

If you move the shorter side (L → L+1), width decreases to W-1, but you may find a new height a' = heights[L+1] with a' > a.
Then the new area is (W-1) * min(a', b) which can exceed A if a' is sufficiently larger than a. This is the only step that can potentially increase the limiting height.

Thus, always discard the current shorter line; keeping it cannot lead to a better solution with any inner partner than what we already considered.

Intuition (mental model)

Think of two fences far apart. The water level is capped by the shorter fence. To get more water after bringing the fences closer (smaller width), you need a taller short fence. Sliding the short fence inward is the only way to “search” for that.

Dry Run on Your Example

heights = [1,8,6,2,5,4,8,3,7]

L=0(1), R=8(7): area = 8*1 = 8 → move L (shorter)

L=1(8), R=8(7): area = 7*7 = 49 → move R (shorter)

L=1(8), R=7(3): area = 6*3 = 18 → move R

L=1(8), R=6(8): area = 5*8 = 40 → move R (equal → move either; we move R)

L=1(8), R=5(4): area = 4*4 = 16 → move R

L=1(8), R=4(5): area = 3*5 = 15 → move R

L=1(8), R=3(2): area = 2*2 = 4 → move R

L=1(8), R=2(6): area = 1*6 = 6 → stop (L==R-1)

Best = 49, achieved at indices (1, 8).

Common Pitfalls

❌ Moving the right pointer rightward (right++) instead of inward (right--).

❌ Moving the taller pointer: this can’t improve the min-height and always reduces width.

❌ Off-by-one loops (use while (left < right)).

❌ Overflow worries: in Java, area fits in int when n ≤ 10^5 and heights ≤ 10^4 (max area ≈ 10^9), but for extreme constraints consider long.

Variations & Tips

Return indices too: Track the argmax pair when updating best.

Why not sort? Sorting breaks the original x-order; width depends on original indices, so a sort-based approach loses necessary structure.

Different from “Trapping Rain Water”: That problem sums water over bars and uses prefix/suffix maxima or two pointers differently. Here we choose two bars only and maximize a single rectangle.

Clean Reference Code (Java)
```
class Solution {
   public int maxArea(int[] h) {
    int left = 0, right = h.length - 1, best = 0;
    while (left < right) {
    int width = right - left;
    int height = Math.min(h[left], h[right]);
    best = Math.max(best, width * height);
    
                if (h[left] < h[right]) left++;
                else right--;
            }
            return best;
        }
}
```

Quick Correctness Invariant

At any step with (L,R), there does not exist a better solution that pairs L with any index < R if heights[L] ≤ heights[R]. We safely discard L by incrementing it. Symmetric for R.

Complexity

Time: O(n)

Space: O(1)

That’s all you need for a rock-solid note: the rule (move the shorter side), the proof idea, a dry run, and common bugs to avoid.