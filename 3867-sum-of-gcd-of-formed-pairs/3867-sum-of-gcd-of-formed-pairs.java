class Solution {
   public static int gcd(int a, int b) {
        while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
        }
        return a;
    }

    

    public long gcdSum(int[] nums) {
        int[] prefixGcd = new int[nums.length];
        int mx = nums[0];

        for (int i=0; i < nums.length; i++){
            if ( nums[i] > mx ){
                mx = nums[i];
            }

            prefixGcd[i] = gcd(nums[i] , mx);
        }
        Arrays.sort(prefixGcd);

        int f = 0;
        int l = prefixGcd.length - 1;
        long sum = 0;

        while( f != l && f < l){
            sum += gcd( prefixGcd[f] , prefixGcd[l] );
            f++;
            l--;
        }

        return sum;

    }
}