/**
 * Weird Algorithm
 * Topic : Recursion
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    private void solve(long n, List<Long> ans) {
        // add current number to the sequence
        ans.add(n);
        
        // base condition
        if (n == 1) {
            return;
        }
        
        // recursive calls based on even or odd
        if (n % 2 == 0) {
            solve(n / 2, ans);
        } else {
            solve(n * 3 + 1, ans);
        }
    }
    
    public List<Long> weirdAlgorithm(long n) {
        List<Long> ans = new ArrayList<>();
        solve(n, ans);
        return ans;
    }
}
