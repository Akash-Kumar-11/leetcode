class Solution {

    public int product (int n ){
        int pro = 1;
        while (n > 0){
            int digit = n%10;
            pro = pro*digit;
            n = n/10;
        }
        return pro;
    }

    public int smallestNumber(int n, int t) {

        boolean flag = true;

      

        while(flag){
            if(product(n)%t == 0){
                return n;
            }else{
                n++;
            }
        }
        return 0;


        
    }
}