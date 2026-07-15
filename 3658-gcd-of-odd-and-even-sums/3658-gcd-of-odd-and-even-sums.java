class Solution {
    public int odd (int n) {
        return n * n;
    }

     public int even (int n) {
        return n * (n+1);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int gcdOfOddEvenSums(int n) {
       
        return gcd( odd(n) , even(n));
        
    }

   
}