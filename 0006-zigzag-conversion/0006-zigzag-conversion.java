class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }


        StringBuilder result = new StringBuilder();
        int n = s.length();
        int inc = 2 * (numRows - 1);

        for (int r = 0; r<numRows;r++){
            for(int i = r; i < n ;i += inc){
                result.append(s.charAt(i));

                if (r > 0 && r < numRows - 1) {
                    int diagIdx = i + inc - 2 * r;
                    if (diagIdx < n) {
                        result.append(s.charAt(diagIdx));
                    }
                }
            }
        }
        return result.toString();
    }
}