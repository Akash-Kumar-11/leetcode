class Solution {
    public String smallestPalindrome(String s) {
        int [] alpha = new int [26];

        for(char c : s.toCharArray()){
            alpha[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String mid = "";

        for(int i=0;i<26;i++){
            if(alpha[i]>0){
                char c = (char) (   i + 'a'  );
                if( alpha [i] % 2 == 1){
                    mid = String.valueOf(c);
                }
                for(int j=0;j<alpha[i]/2;j++){
                    left.append(c);
                }
            }
        }

        String ls = left.toString();
        String rs = new StringBuilder(ls).reverse().toString();

        return ls+mid+rs;

    }
}