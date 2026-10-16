/**
* Generate all binary strings
* Link : https://www.geeksforgeeks.org/problems/generate-all-binary-strings/1
* Topic : Recursion
*/
class Solution {
    private void solve(int n, String curr, List<String> ans) {
        // base condition
        if (curr.length() == n) {
            ans.add(curr);
            return;
        }
        
        // put "0"
        solve(n, curr + "0", ans);
        // put "1"
        solve(n, curr + "1", ans);
    }
    
    public List<String> binstr(int n) {
        // code here
        List<String> ans = new ArrayList<>();
        solve(n, "", ans);
        return ans;
    }
}
