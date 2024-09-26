package Medium;

public class LC_72_EditDistance {
    public int minDistance(String word1, String word2) {
         if(word1.isEmpty()) return word2.length();
         if(word2.isEmpty()) return word1.length();

        int[][] dp = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;

        for (int i = 1; i < word1.length()+1 ; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < word2.length()+1 ; i++) {
            dp[0][i] = i;
        }

        for (int r = 1; r <= word1.length(); r++) {
            for (int c = 1; c <= word2.length(); c++) {
                if (word1.charAt(r-1) == word2.charAt(c-1)) {
                    dp[r][c] = dp[r-1][c-1];
                }
                else {
                    int insertDelete1 = dp[r-1][c];
                    int insertDelete2 = dp[r][c-1];
                    int replace = dp[r-1][c-1];
                    dp[r][c] = 1 + Math.min(Math.min(insertDelete1, insertDelete2), replace);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
