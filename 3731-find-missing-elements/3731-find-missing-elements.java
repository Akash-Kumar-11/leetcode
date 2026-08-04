class Solution {

    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new  ArrayList<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

         boolean[] present = new boolean[102]; 
        
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            present[num] = true;
        }

         for (int i = min; i <= max; i++) {
            if (!present[i]) {
                result.add(i);
            }
        }
        
        return result;
    

    }
}