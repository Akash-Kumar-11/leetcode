class Solution {
    public boolean canAliceWin(int n) {
        if(n <= 9){
            return false;
        }

        if(n==10 || n <= 18){
            return true;
        }
        int sub = 10;
        boolean flag = true;

        while(n>=sub){
            n = n-sub;
            sub--;
            flag = !flag;
        }
        return !flag;
    }
}