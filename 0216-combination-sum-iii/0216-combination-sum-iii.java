class Solution {
    static void solve(int k , int n, int index , List<List<Integer>> ans , List<Integer> output, int count,int[] candidates){
        if(count > k) return;

        if(count == k && n == 0){
            ans.add(new ArrayList(output));
            return;
        }

        if(index >= candidates.length) return;

        if(n < 0) return;

        output.add(candidates[index]);
        solve(k, n - candidates[index] , index+1, ans , output, count+1, candidates);

        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]){
            index++;
        }

        output.remove(output.size() - 1);
        solve(k , n , index+1, ans , output , count,candidates);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int [] candidates = {1,2,3,4,5,6,7,8,9};
        int index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int count = 0;

        solve(k, n , index , ans , output, count, candidates);

        return ans;
    }
}